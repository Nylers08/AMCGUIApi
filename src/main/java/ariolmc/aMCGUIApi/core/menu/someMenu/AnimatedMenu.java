package ariolmc.aMCGUIApi.core.menu.someMenu;

import ariolmc.aMCGUIApi.core.menu.utils.InventoryUtils;
import ariolmc.aMCGUIApi.infrastructure.inventoryFabric.InventoryFabric;
import net.kyori.adventure.text.Component;
import org.bukkit.inventory.Inventory;

import java.util.List;

public class AnimatedMenu extends Menu{

    private final List<Inventory> frames;
    private int currentFrame = 0;
    private double secondsBetweenFrame = 5;

    public AnimatedMenu(InventoryFabric fabric, List<Inventory> frames) {
        super(fabric);
        this.frames = frames;
    }

    public void nextFrame(){
        currentFrame = currentFrame<frames.size() ? currentFrame+1 : 0;
        inventory = InventoryUtils.copyWithNewTitle(frames.get(currentFrame), Component.text("asd"));
    }
}
