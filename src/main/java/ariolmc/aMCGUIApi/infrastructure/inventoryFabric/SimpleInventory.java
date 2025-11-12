package ariolmc.aMCGUIApi.infrastructure.inventoryFabric;

import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.inventory.Inventory;

public class SimpleInventory implements InventoryFabric {

    private Component title;
    private int size;

    public SimpleInventory(Component title, int size){
        this.title = title;
        this.size = size;
    }

    @Override
    public Inventory create() {
        return Bukkit.createInventory(null, size, title);
    }
}
