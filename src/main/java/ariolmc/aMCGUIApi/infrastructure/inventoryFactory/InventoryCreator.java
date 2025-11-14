package ariolmc.aMCGUIApi.infrastructure.inventoryFactory;

import net.kyori.adventure.text.Component;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;

public interface InventoryCreator {
    Inventory create(InventoryHolder holder, int size, Component title);
}
