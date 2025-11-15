package ariolmc.aMCGUIApi.core.menu.animatedMenu;

import ariolmc.aMCGUIApi.AMCGUIApi;
import ariolmc.aMCGUIApi.core.menu.animatedMenu.animationFrame.core.AnimationFrame;
import ariolmc.aMCGUIApi.core.menu.animatedMenu.animationFrame.factory.AnimationFrameFactory;
import ariolmc.aMCGUIApi.core.namedInventory.NamedInventory;
import ariolmc.aMCGUIApi.core.menu.services.services.MenuOpener;
import ariolmc.aMCGUIApi.core.menu.menu.Menu;
import net.kyori.adventure.text.Component;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

public class BaseAnimatedMenu implements AnimatedMenu {

    private final AnimationFrame animatedFrame;
    private final MenuOpener menuOpener;
    private Menu lastFrame;

    public BaseAnimatedMenu(AnimationFrameFactory factory, MenuOpener menuOpener){
        this.animatedFrame = factory.create();
        this.menuOpener = menuOpener;
    }


    @Override
    public Component getTitle() {
        return animatedFrame.getCurrentMenu().getTitle();
    }

    @Override
    public void rename(Component title) {
        animatedFrame.getCurrentMenu().rename(title);
    }

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

        showCurrentFrame();
    }

    private void showCurrentFrame(){
        if(hasFrameChanged()){
            menuOpener.reopen(this);
            AMCGUIApi.getInstance().getLogger().info("Показали новое меню");
        }
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
