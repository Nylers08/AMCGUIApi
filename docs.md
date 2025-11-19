# Немного о том как пользоваться
Немного расскажу как пользоваться этой библиотекой. Слегонца и совсем немного.

Как уже можно было догадаться, это плагин для создания меню, в других плагинах. Для работы нужны будет поставить его на свой сервер.
Можно создавать как обычные, статичные меню, так и анимированные.

## Получение основного класса

Для начала, хорошо бы получить основной класс плагина, в свой плагин. Покажу на примере другого своего плагина:

```java
public final class AMCSkyCore extends JavaPlugin {

    @Getter private static AMCSkyCore instance;

    @Getter private AMCGUIApi amcguiApi;

    ...

    void loadGuiAPI(){
        amcguiApi = null;
        Plugin plugin = Bukkit.getPluginManager().getPlugin("AMCGUIApi");
        if (plugin instanceof AMCGUIApi) {
            amcguiApi = (AMCGUIApi) plugin;
        }

        if (amcguiApi == null) {
            getLogger().severe("AMCGUIApi не найден или не загружен!");
        }
    }

    ...

```

loadGuiAPI, следует вызвать в методе onEnable()

## Структура

Сама по себе структура выглядит так: ItemGUI(ItemStack) -> Menu(Inventory) -> AnimationFrame -> AnimatedMenu

Поговорим поподробнее о каждом элементе цепочки. Начнём с Menu

## Menu

### NamedInventory

Для отображение хоть какого-то интерфейса игроку, используется Inventory. Но мне не понравилось, что Inventory, сам по себе не хранит имя. Поэтому я сделал надстройку над ним и сделал NamedInventory.
NamedInventory, простой interface, реализует его GUINamedInventory. Некоторые классы могут потребовать от вас фабрику NamedInventory, по стандарту можете использовать **GUINamedInvFactory**

### Interface Menu

Сам Menu выглядит так:
```java
public interface Menu extends InventoryHolder {

    Component getTitle();
    void rename(Component title);
    void setItem(int slot, ItemStack item);
    ItemStack getItem(int slot);
    NamedInventory getNamedInventory();

    boolean isAllowItemMovement();
    void setAllowItemMovement(boolean value);
}

```
Из непонятного, думаю, здесь только isAllowItemMovement(). Если он false, то запрещает взаимодействие с меню.
По умолчанию он false

### BaseMenu

Конечно, вам не нужно самому реализовывать Menu, для этого есть BaseMenu.
По сути, это класс, который "владеет" инвентарём. Он принмает в конструктор, фабрику для NamedInventory, и делегирует большинство методов из NamedInventory.

Используйте BaseMenu для отображения статичного меню.

Кстати, для BaseMenu, есть уже готовая фабрика - BaseMenuFactory. В конструкторе принимает: размер, название.
Размер должен быть кратным 9, и не больше 54. Название передаётся, через [Component](https://jd.advntr.dev/api/4.9.0/net/kyori/adventure/text/Component.html?is-external=true).
```java
MenuFactory factory = new BaseMenuFactory(9, Component.text("§aMenu title"));
Menu menu = factory.create();
```

### Вставка ItemGUI в Menu

Как вы могли заметить, меню(как и NamedInventory) не хранит ItemGUI, а только ItemStack. Это связано с тем, как работает ItemGUI(Об этом позже) 
Для корректной вставки ItemGUI в меню, следует использовть сервис MenuItemGUISetter(Название возможно поменяется), либо же просто MenuServices(Он делегирует в себе работу всех сервисов).

Получить вы можете их следующим образом:
```java
public final class AMCSkyCore extends JavaPlugin {

  ...
  @Getter private MenuServices menuServices;
  @Getter private MenuItemGUISetter menuItemGUISetter;
  ...

  @Override
  public void onEnable() {
    ...
    loadGuiAPI();
    menuServices = amcguiApi.getMenuServices();
    menuItemGUISetter = menuServices.itemGUISetter();
    ...
  }
```

Для вставки есть два метода
1) setItemGUI(Menu menu, ItemGUI itemGUI, int... slots).
2) setItemGUI(Menu menu, ItemGUIFactory itemGUIFactory, int... slots);

Первый метод используйте, если у вас должены быть предметы с "неуникальной реализацией".
К примеру, декоротивный предмет. У всех таких кнопок, всегда одинаковое имя, и не запоминают в себе ничего уникального для себя.

Второй метод, если каждый вставленный предмет должен быть уникальным. 
К примеру, каждый отдельная кнопка, должна запоминать, сколько именно на неё раз нажали.
Он генерирует каждый раз новую кнопку с разным id.

Пример первого метода
```java
Menu menu = new BaseMenuFactory(9, Component.text("asd")).create();
ItemGUI itemGUI = new ItemClickCounterFactory().create();
        
menuServices.setItemGUI(menu, itemGUI, 0,1,2,3,4,5,6,7,8);
```

Пример второго метода
```java
Menu menu = new BaseMenuFactory(9, Component.text("asd")).create();
ItemGUIFactory itemGUIFactory = new ItemClickCounterFactory();

menuServices.setItemGUI(menu, itemGUIFactory, 0,1,2,3,4,5,6,7,8);
```

На первый взгляд, разница небольшая. Сейчас объясню.

Скажем ItemClickCounterFactory, считает сколько раз нажали на предмет, и переименовывает его в "Нажали: N", где 'N', кол-во нажатий.

В первом случае, у всех кнопок, будет общий счётчик нажатий. Если вы нажали на предмет в первом слоте 20 раз, то его имя будет "Нажали: 20".
Если потом нажмёте, 1 раз, на предмет во втором слоте, то его имя станет "Нажали: 21"

Во втором случае, у всех кнопок разные счётчики. Если вы нажали на предмет в первом слоте 20 раз. 
А потом, на предмет во втором слоте, то их имена будут "Нажали: 20" и "Нажали: 1".


### Открытие меню

Для корректного открытия, также используется сервис: MenuOpener, либо также MenuServices.

MenuOpener, не просто показывает Inventory игроку, а также сразу же регистрирует нажатие в MenuRegistry(хранит открытые меню).

Для открытия также есть два метода:
1) open(Plugin owner, UUID playerId, Menu menu)
2) openNewMenu(Plugin owner, UUID playerId, MenuFactory factory)
   
Всё также, по аналогии с MenuItemGUISetter.

Первый метод, если должен показываться один Inventory, для разных игроков.
К примеру: "клановое хранилище", "меню сервера"(если оно без *уникальной* анимации для *каждого* игрока) и т.д.

Второй метод, если меню каждый раз, содержит разные предметы, либо же уникально для каждого игрока.
К примеру: "страница аукциона", "статистика игрока"


Для примера покажу, в классе отвечающем за команды.

Сам класс:
```java
public class Command implements CommandExecutor {

    private final MenuFactory menuFactory = new TestAnimatedMenuFactory();
    private final Menu menu = new AnimatedMenu1().create();

    private final AMCSkyCore plugin = AMCSkyCore.getInstance();
    private final MenuServices menuServices = plugin.getAmcguiApi().getMenuServices();

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String @NotNull [] strings) {
        ...
    }
}
```

Показывание **одного** меню, разным игрокам
```java
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String @NotNull [] strings) {

        Player player = (Player) commandSender;
        menuServices.open(plugin, player.getUniqueId(), menu);

        return true;
    }
```

Показывание **разных** меню, разным игрокам
```java
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String @NotNull [] strings) {

        Player player = (Player) commandSender;
        menuServices.openNewMenu(plugin, player.getUniqueId(), menuFactory);

        return true;
    }
```

В первом варианте, все игроки будут видеть одно меню. Скажем если у первого игрока 15 кадр анимации, то и у второго игрока, тоже 15 кадр анимации.

Во втором случае, у кажого игрока "своё" меню. У первого игрока может быть 3 кадр анимации, а у второго 20 кадр.

### Создание своего меню

Наконец перейдём к созданию своего меню!

Давайте сперва сделаем простенькое меню. Скажем размер у него будет 9 ячеек. По краям будут декоративные предметы, с которыми нельзя взаимодействовать. 
А по центру алмаз, который игрок сможет взять, или положить туда свой предмет. Открывать будем просто по вызову команды

Сделаем две реализации.
1) С классом меню и абстрактной фабрикой
2) Просто абстрактная фабрика

#### Первая реализация
```java
public class TestMenu extends BaseMenu {

    public TestMenu(MenuItemGUISetter itemGUISetter) {
        super(new GUINamedInvFactory(9, Component.text("§aМеню")));
        fillItemsGUI(itemGUISetter);
        setAllowItemMovement(true);
    }

    private void fillItemsGUI(MenuItemGUISetter itemGUISetter){
        ItemGUI decorItem = new DecorBlackPaneItemGUIFactory().create();
        
        itemGUISetter.setItemGUI(this, decorItem, 0,1,2,3);
        setItem(4, new ItemStack(Material.DIAMOND));
        itemGUISetter.setItemGUI(this, decorItem, 5,6,7,8);
    }
}
```
Мы отнаследовались от BaseMenu. Явно сказали, что будем использовать GUINamedInvFactory, с определённым размером и названием.

Но при этом, при принимаем MenuItemGUISetter, класс не знает, какой именно будет использоваться сеттер, и как именно он будет устанавливать и регистрировать ItemGUI.
Это нужно на тот случай, если у вас будет своя регистрация ItemGUI в плагине. (в большенстве случаев, лучше использовать регистрацию в AMCGUIApi).
При желании, можно сразу использовать сервис из плагина
```java
    ...
    private void fillItems(){
        MenuItemGUISetter itemGUISetter = AMCSkyCore.getInstance().getMenuItemGUISetter();
        
        ItemGUI decorItem = new DecorBlackPaneItemGUIFactory().create();

        itemGUISetter.setItemGUI(this, decorItem, 0,1,2,3);
        setItem(4, new ItemStack(Material.DIAMOND));
        itemGUISetter.setItemGUI(this, decorItem, 5,6,7,8);
    }
```

Дальше мы заполняем инвентарь предметамии. Как можете заметить, для установки обычного ItemStack, можно использовать setItem.

Затем, мы разрешаем перетаскивать предметы. На нашу декративную чёрную панель, это не распространяется, ведь в её поведении заложено так, что она не перетаскивается.

Меню уже созданно и можно использовать! Но перед этим давайте сделаем абстрактную фабрику, для нашего меню.

```java
public class TestMenuFactory implements MenuFactory {

    private final MenuItemGUISetter itemGUISetter;

    public TestMenuFactory(MenuItemGUISetter itemGUISetter){
        this.itemGUISetter = itemGUISetter;
    }

    @Override
    public Menu create() {
        return new TestMenu(itemGUISetter);
    }
}
```

И уже можно проверить на деле!

Почти тот же класс для команды
```java
public class AbstractCommand implements CommandExecutor {

    private final AMCSkyCore plugin = AMCSkyCore.getInstance();
    private final MenuServices menuServices = plugin.getAmcguiApi().getMenuServices();

    private final MenuFactory menuFactory = new TestMenuFactory(menuServices.itemGUISetter());
    private final Menu menu = menuFactory().create();

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String @NotNull [] strings) {
        ...
    }
}
```

Если откроем меню через **open**:
```java
        Player player = (Player) commandSender;
        menuServices.open(plugin, player.getUniqueId(), menu);

        return true;
```
То все игроки, что открыли меню, смогут пользоваться слотом по центру. Класть и забирать вещи друг друга.
Игроки, находящиеся даже в разных мирах, смогут обменивать предметами с друг другом. Или временно положить предмет, закрыть-открыть меню, и снова забрать.

Но если мы откроем через **openNewMenu**:
```java
        Player player = (Player) commandSender;
        menuServices.openNewMenu(plugin, player.getUniqueId(), menuFactory);

        return true;
```
То у каждого игрока при  вводе команды, будет создаваться новое меню, конкретно для него.
Если игрок заберёт алмаз закроет-откроет меню, то оно снова сгенерируется и появиться новый алмаз по центру.


#### Вторая реализация

Мы можем не делать отдельный класс TestMenu. А сразу сделать TestMenuFactory

```java
public class TestMenuFactory2 implements MenuFactory {

    private final MenuItemGUISetter itemGUISetter;

    public TestMenuFactory2(MenuItemGUISetter itemGUISetter){
        this.itemGUISetter = itemGUISetter;
    }

    @Override
    public Menu create() {
        Menu menu = new BaseMenuFactory(9, Component.text("§cМеню")).create();

        ItemGUI decorItem = new DecorBlackPaneItemGUIFactory().create();
        itemGUISetter.setItemGUI(menu, decorItem, 0,1,2,3);
        menu.setItem(4, new ItemStack(Material.DIAMOND));
        itemGUISetter.setItemGUI(menu, decorItem, 5,6,7,8);

        return menu;
    }
}
```

Но как по мне, первая реализация предпочтительней


### Переименовка Menu

У Inventory - есть большой минус. Для того, чтобы его переименовать, его нужно пересоздать, с тем же содержимым, но другим именем.
Поэтому, если вы просто вызовите у Menu, метод .rename(..), то не увидите разницы. Его нужно ещё и переоткрыть..

Для таких целей, есть свой сервис: MenuRenamer, он также делегируется в MenuServices.

Пример использования:
```java
menuServices.rename(menu, Component.text("New Title"));
```

Он переименует menu, и переоткроет, у всех кто на него смотрел.



## ItemGUI

После того, как научились делать меню(если нет, то вам будет немного трудновато), можно переходить и к ItemGUI(кнопкам).

### Как устроен ItemGUI

ItemGUI, содержит 3 важных поля:
1) String id;
2) ItemStack itemStack;
3) List\<ItemGUIAction\> actions;

Как вы уже наверное знаете, мы не можем положить ItemGUI напрямую в Menu, для этого мы используем ItemStack.
Но вот беда, ItemStack, не может знать, что он ItemGUI. Для этого, ещё на этапе фабрики, мы ложем id в NBT ItemStack'а.
И получается что, ItemStack, связан с ItemGUI, через id.

И когда мы нажимаем на предмет в инвентаре:
1) Проверяется есть ли у него в NBT, id от ItemGUI
2) Если есть, то пытаемся найти его в ItemGUIRegistry
3) Если нашли, то вызваем у него все действия.

Как вы могли понять, когда мы вставляем ItemGUI в Menu, через MenuItemGUISetter, то он как раз таки, регистрирует наш ItemGUI в ItemGUIRegistry.

### ItemGUIAction

Что за ItemGUIAction? По сути это интерфейс, что скрывает всю бизнес-логику, нашей кнопки.
Выглядит он кстати так:
```java
@FunctionalInterface
public interface ItemGUIAction {
    void action(ItemGUIClickEvent event);
}
```
На вход он принимаеи ItemGUIClickEvent. ItemGUIClickEvent - за собой скрывает ItemGUI, по которому нажали и InventoryItemClickEvent

У ItemGUIAction может быть совсем разная реализация. Вот пару готовых примеров:
<details>
<summary>CancelInventoryClick</summary>
    
```java
public class CancelInventoryClick implements ItemGUIAction {
    @Override
    public void action(ItemGUIClickEvent event) {
        event.getInventoryClickEvent().setCancelled(true);
    }
}
```
</details>

<details>
<summary>MenuOpenAction</summary>
    
```java
public class MenuOpenAction implements ItemGUIAction {

    private final Plugin owner;
    private final Menu menu;
    private final MenuOpener opener;

    public MenuOpenAction(Plugin owner, Menu menu, MenuOpener opener){
        this.owner = owner;
        this.menu = menu;
        this.opener = opener;
    }

    @Override
    public void action(ItemGUIClickEvent event) {
        UUID playerId = event.getInventoryClickEvent().getWhoClicked().getUniqueId();
        opener.open(owner, playerId, menu);
    }
}

```
</details>

<details>
<summary>MenuFactoryOpenAction</summary>
    
```java
public class MenuFactoryOpenAction implements ItemGUIAction {

    private final Plugin owner;
    private final MenuFactory menuFactory;
    private final MenuOpener opener;

    public MenuFactoryOpenAction(Plugin owner, MenuFactory menuFactory, MenuOpener opener){
        this.owner = owner;
        this.menuFactory = menuFactory;
        this.opener = opener;
    }

    @Override
    public void action(ItemGUIClickEvent event) {
        UUID playerId = event.getInventoryClickEvent().getWhoClicked().getUniqueId();
        opener.openNewMenu(owner, playerId, menuFactory);
    }
}

```
</details>

### Создание своего ItemGUI

#### AbstractItemGUIFactory

По правде, ItemGUI написан кривовато. Будет трудно создать отдельный для конкретно вашего ItemGUI, как было с Menu.
У ItemGUI, для этого используется **AbstractItemGUIFactory**. Вы наследуетесь от AbstractItemGUIFactory, либо от другой фабрики и в super передаёте параметры.

Примеры:
<details>
<summary>DecorItemGUIFactory</summary>
    
```java
public class DecorItemGUIFactory extends AbstractItemGUIFactory {

    public DecorItemGUIFactory(ItemStack item){
        super(
                item,
                buildActions()
        );
    }

    public DecorItemGUIFactory(ItemStack item, List<ItemGUIAction> actions){
        super(
                item,
                buildActions(actions)
        );
    }

    private static List<ItemGUIAction> buildActions(){
        return List.of(new CancelInventoryClick());
    }

    private static List<ItemGUIAction> buildActions(List<ItemGUIAction> otherActions){
        List<ItemGUIAction> actions = new ArrayList<>(buildActions());
        actions.addAll(otherActions);
        return actions;
    }

}

```
</details>

<details>
<summary>DecorBlackPaneItemGUIFactory</summary>
    
```java
public class DecorBlackPaneItemGUIFactory extends DecorItemGUIFactory {

    public DecorBlackPaneItemGUIFactory() {
        super(
                new ItemStackBuilder(Material.BLACK_STAINED_GLASS_PANE)
                        .name(Component.text(" "))
                        .build()
        );
    }
}

```
</details>


### ItemStackBuilder

В DecorBlackPaneItemGUIFactory, вы можете заметить Некий класс ItemStackBuilder.
Это специальный небольшой класс, чтобы удобнее создавать ItemStack. С нужным материалом, кол-вом, именем и лором.

Пример использования:
<details>
<summary>Чёрный бриллиант</summary>
    
```java
new ItemStackBuilder(Material.DIAMOND)
                        .name(Component.text("§0Чёрный бриллиант"))
                        .lore(lore)
                        .build()

```
</details>

<details>
<summary>Пули смерти</summary>
    
```java
new ItemStackBuilder(Material.ARROW, 64)
                        .name(Component.text("§0Пули смерти"))
                        .build()

```
</details>


## Анимированное меню

Анимированное меню - это список из обычных меню.

Анимированное меню, состоит их кадров. Кадр может быть: анимированным и статичным.
Как бы странно это не звучало, но да, кадр тоже может иметь свою кадры, а те в свою очередь свои.
Но в конце, всей этой цепочки обязательно будет статичный кадр.
А статичный кадр - это по сути меню. Так и выходит, что анимированное меню, это просто список из обычных меню.

Такая запутанная на первый взгляд реализация, позволяет комибинировать и переиспользовать разные анимации.

Все кадры имплементируют интерфейс AnimationFrame.

Основные классы фрэймов: StaticFrame, FactoryFrame, AnimatedFrame.
Начнём по порядку.


### StaticFrame

Сождержит такие поля:
1) Menu frame;
2) long duration;
3) Sound sound;

frame - сам кадр, меню которое покажется, на этом кадре. 
duration - сколько тиков, будет показываться этот кадр. Указывйте -1, если хотите, вечный кадр
sound - звук при показе

Пример создания:
<details>
<summary>TestStaticFrame1</summary>
    
```java
public class TestStaticFrame1 extends StaticFrame {
    public TestStaticFrame1() {
        super(new Test1MenuFactory().create(), 10, Sound.BLOCK_IRON_BREAK);
    }
}
```
</details>

StaticFrame - можно использовать, для уже созданных меню. Когда меню, всегда должно показываться одно.
К примеру, даже если нужно показывать, с изменёным содержимым.


### FactoryFrame

Сождержит такие поля:
1) StaticFrame frame;
2) MenuFactory menuFactory;
3) long duration;
4) Sound sound;

Каждый раз, когда анимация заканчивается, он заного генерирует StaticFrame.
В конструкторе принимает: MenuFactory, long, Sound;

Используется, если меню, должно генерироваться заного, на этом кадре.
К примеру, генерировать меню, с именем игрока, или уникальным содержимым, которое генерируется, каждый раз заного, на этом кадре.


### AnimatedFrame

То самое анимированное меню.

Из важных полей содержит:
1) List<AnimationFrame> frames;
2) int repeatCount;

frames - как раз таки те самые кадры анимации, их может быть много. Могут быть как и StaticFrame, FactortyFrame, AnimatedFrame или вообще ваша реализация AnimationFrame.
Как можете догадаться, если это AnimatedFrame, то кадр не переключиться, пока у того AnimatedFrame, не проиграют все анимации. И это рекурсивно.

repeatCount - сколько раз это анимация проиграется. По умолчанию 1. Если указать -1, то будет играть бесконечно.

Пример использования:
<details>
<summary>AnimatedFrame1</summary>
    
```java
public class AnimatedFrame1 implements AnimationFrameFactory {

    @Override
    public AnimationFrame create() {
        return new AnimatedFrame(List.of(
                new TestStaticFrame1(),
                new StaticFrame2()
        ), -1);
    }
}
```
</details>

##№ AnimatedMenu

Наконец-то и анимированное меню.

AnimatedMenu, само по себе интерфейс, которое наследуется от Menu и AnimationFrame.
Так-что, оно тоже может быть использовано, как кадр анимации.

#### BaseAnimatedMenu

BaseAnimatedMenu - реализует AnimatedMenu.

Важные поля:
1) AnimatedFrame animatedFrame
2) MenuOpener menuOpener

В конструктор принимает: AnimationFrameFactory factory, MenuOpener menuOpener

Так как, по сути AnimatedMenu, постоянно открывает новые меню для игроков, ему и необходим MenuOpener

Пример создания:
<details>
<summary>AnimatedMenu1</summary>
    
```java
public class AnimatedMenu1 implements MenuFactory {

    @Override
    public AnimatedMenu create() {
        return
                new BaseAnimatedMenu(
                new AnimatedFrame1(),
                AMCSkyCore.getInstance().getAmcguiApi().getMenuServices().opener());
    }
}
```
</details>


## Заключение

В целом, это всё, что я хотел рассказать. Надеюсь этого хватит, чтобы вы смогли разобраться, в этой библиотеке.
Да, она написана криво, но я только начал учиться писать код более-менее, худо-бедно чисто Clean Code там, SOLID всякие)

Главное помните, что структура выглядит примерно так: ItemGUI->Menu->AnimationFrame->AnimatedMenu

Ну и удачи в разработке)
