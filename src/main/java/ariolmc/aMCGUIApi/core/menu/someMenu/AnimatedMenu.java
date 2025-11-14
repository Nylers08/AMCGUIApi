package ariolmc.aMCGUIApi.core.menu.someMenu;

import ariolmc.aMCGUIApi.core.itemGUI.services.ItemGUIRegistry;
import ariolmc.aMCGUIApi.core.menu.namedInventory.fabric.NamedInventoryFabric;
import org.bukkit.inventory.Inventory;

import java.util.List;

public class AnimatedMenu extends BaseMenu {

    private final List<Inventory> frames;
    private int currentFrameIndex = 0;
    private double secondsBetweenFrame = 1;

    public AnimatedMenu(NamedInventoryFabric fabric, List<Inventory> frames) {
        super(fabric);
        this.frames = frames;
    }

    private void setCurrentFrame(){

    }
}
