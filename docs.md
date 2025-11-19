# Немного о том как пользоваться
Немного расскажу как пользоваться этой библиотекой. Слегонца и совсем немного.

Как уже можно было догадаться, это плагин для создания меню, в других плагинах. Для работы нужны будет поставить его на свой сервер.
Можно создавать как обычные, статичные меню, так и анимированные.

## Получение основного класса

Для начала, хорошо бы получить основной класс плагина, в свой плагин. Покажу на примере другого своего плагина:

```
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
```
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

### BaseMenu

Конечно, вам не нужно самому реализовывать Menu, для этого есть BaseMenu.
По сути, это класс, который "владеет" инвентарём. Он принмает в конструктор, фабрику для NamedInventory, и делегирует большинство методов из NamedInventory.

Используйте BaseMenu для отображения статичного меню.

Кстати, для BaseMenu, есть уже готовая фабрика - BaseMenuFactory. В конструкторе принимает: размер, название.
Размер должен быть кратным 9, и не больше 54. Название передаётся, через [Component](https://jd.advntr.dev/api/4.9.0/net/kyori/adventure/text/Component.html?is-external=true).
```
MenuFactory factory = new BaseMenuFactory(9, Component.text("§aMenu title"));
Menu menu = factory.create();
```

### Вставка ItemGUI в Menu

Как вы могли заметить, меню(как и NamedInventory) не хранит ItemGUI, а только ItemStack. Это связано с тем, как работает ItemGUI(Об этом позже) 
Для корректной вставки ItemGUI в меню, следует использовть сервис MenuItemGUISetter(Название возможно поменяется), либо же просто MenuServices(Он делегирует в себе работу всех сервисов).

Получить вы можете их следующим образом:
```
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
Поскольку, он генерирует каждый раз новую кнопку с разным id.

Пример первого метода
```
Menu menu = new BaseMenuFactory(9, Component.text("asd")).create();
ItemGUI itemGUI = new ItemClickCounterFactory().create();
        
menuServices.setItemGUI(menu, itemGUI, 0,1,2,3,4,5,6,7,8);
```

Пример второго метода
```
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

Конечно, для корректного открытия, также используется сервис: MenuOpener, либо также MenuServices.

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
```
public class AbstractCommand implements CommandExecutor {

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
```
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String @NotNull [] strings) {

        Player player = (Player) commandSender;
        menuServices.open(plugin, player.getUniqueId(), menu);

        return true;
    }
```

Показывание **разных** меню, разным игрокам
```
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String @NotNull [] strings) {

        Player player = (Player) commandSender;
        menuServices.openNewMenu(plugin, player.getUniqueId(), menuFactory);

        return true;
    }
```

В первом варианте, все игроки будут видеть одно меню. Скажем если у первого игрока 15 кадр анимации, то и у второго игрока, тоже 15 кадр анимации.

Во втором случае, у кажого игрока "своё" меню. У первого игрока может быть 3 кадр анимации, а у второго 20 кадр.
