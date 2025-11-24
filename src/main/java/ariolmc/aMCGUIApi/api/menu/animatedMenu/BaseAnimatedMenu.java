package ariolmc.aMCGUIApi.api.menu.animatedMenu;

import ariolmc.aMCGUIApi.api.menu.animatedMenu.animationFrame.core.AnimationFrame;
import ariolmc.aMCGUIApi.api.menu.animatedMenu.animationFrame.factory.AnimationFrameFactory;
import ariolmc.aMCGUIApi.api.namedInventory.NamedInventory;
import ariolmc.aMCGUIApi.api.menu.services.services.MenuOpener;
import ariolmc.aMCGUIApi.api.menu.menu.Menu;
import net.kyori.adventure.text.Component;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

/**
 * Базовая реализация анимированного меню
 * <p> Сам по себе не хранит NamedInventory, в отличие от BaseMenu.
 * Но хранит в себе AnimationFrame. Который в свою очередь может хранить несколько других AnimationFrame.
 * И где-то в конце обязательно будет Menu, в котором найдётся Inventory и namedInventory
 * <p> Такая реализация нужна, для вложенных анимаций, и переиспользования готовых анимаций
 * <p> Каждый раз когда AnimationFrame, меняет кадр, отображает этот кадр у игроков.
 * По сути каждый кадр - это в конце концов Menu.
 * <p> В зачастую схема выглядит примерно так: Menu -> StaticFrame/FactoryFrame -> AnimatedFrame -> AnimatedMenu
 */
public class BaseAnimatedMenu implements AnimatedMenu {

    private final AnimationFrame animatedFrame;
    private final MenuOpener menuOpener;
    private Menu lastFrame;

    /**
     * @param factory Фабрика для создания AnimationFactory
     * @param menuOpener По сути каждый кадр в анимированном меню, это другие меню, и для их показа нужен MenuOpener
     */
    public BaseAnimatedMenu(AnimationFrameFactory factory, MenuOpener menuOpener){
        this.animatedFrame = factory.create();
        this.menuOpener = menuOpener;
    }


    @Override
    public Component getTitle() {
        return animatedFrame.getCurrentMenu().getTitle();
    }

    /**
     *  Меняет имя текущего кадра. Для корректной работы лучше использовать MenuRenamer
     */
    @Override
    public void rename(Component title) {
        animatedFrame.getCurrentMenu().rename(title);
    }

    /**
     * Если хотите поставить ItemGUI, то лучше используйте MenuItemGUISetter
     */
    @Override
    public void setItem(int slot, ItemStack item) {
        animatedFrame.getCurrentMenu().setItem(slot, item);
    }

    @Override
    public ItemStack getItem(int slot) {
        return animatedFrame.getCurrentMenu().getItem(slot);
    }

    @Override
    public NamedInventory getNamedInventory() {
        return animatedFrame.getCurrentMenu().getNamedInventory();
    }

    @Override
    public boolean isAllowItemMovement() {
        return animatedFrame.getCurrentMenu().isAllowItemMovement();
    }

    @Override
    public void setAllowItemMovement(boolean value) {
        animatedFrame.getCurrentMenu().setAllowItemMovement(value);
    }

    @Override
    public @NotNull Inventory getInventory() {
        return animatedFrame.getCurrentMenu().getInventory();
    }


    @Override
    public void tick() {
        lastFrame = getCurrentMenu();
        animatedFrame.tick();

        if(isAnimationFinished())
            return;

        if(hasFrameChanged()){
            showCurrentFrame();
        }
    }

    private void showCurrentFrame(){
        menuOpener.reopen(this);
    }

    private boolean hasFrameChanged(){
        return lastFrame != null && !lastFrame.equals(getCurrentMenu());
    }


    @Override
    public boolean isAnimationFinished() {
        return animatedFrame.isAnimationFinished();
    }

    @Override
    public Menu getCurrentMenu() {
        return animatedFrame.getCurrentMenu();
    }

    @Override
    public void reset() {
        animatedFrame.reset();
    }
}
