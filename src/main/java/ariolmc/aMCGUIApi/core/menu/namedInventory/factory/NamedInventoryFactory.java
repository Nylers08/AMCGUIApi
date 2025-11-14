package ariolmc.aMCGUIApi.core.menu.namedInventory.factory;

import ariolmc.aMCGUIApi.core.menu.namedInventory.NamedInventory;
import org.bukkit.inventory.InventoryHolder;

public interface NamedInventoryFactory {
    NamedInventory create(InventoryHolder owner);
}
