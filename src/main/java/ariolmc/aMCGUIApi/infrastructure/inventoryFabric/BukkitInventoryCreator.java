package ariolmc.aMCGUIApi.infrastructure.inventoryFabric;

import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;

public class BukkitInventoryCreator implements InventoryCreator {

//    private InventoryHolder holder;
//    private int size;
//    private Component title;
//
//    public BukkitInventoryCreator(InventoryHolder holder, int size, Component title){
//        this.holder = holder;
//        this.size = size;
//        this.title = title;
//    }

    @Override
    public Inventory create(InventoryHolder holder, int size, Component title) {
        return Bukkit.createInventory(holder, size, title);
    }
}
