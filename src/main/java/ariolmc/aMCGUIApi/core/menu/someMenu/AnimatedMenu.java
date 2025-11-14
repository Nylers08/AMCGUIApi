package ariolmc.aMCGUIApi.core.menu.someMenu;

import ariolmc.aMCGUIApi.core.menu.namedInventory.factory.NamedInventoryFactory;
import org.bukkit.inventory.Inventory;

import java.util.List;

public class AnimatedMenu extends BaseMenu {

    private final List<Inventory> frames;
    private int currentFrameIndex = 0;
    private double secondsBetweenFrame = 1;

    public AnimatedMenu(NamedInventoryFactory factory, List<Inventory> frames) {
        super(factory);
        this.frames = frames;
    }

    private void setCurrentFrame(){

    }
}
