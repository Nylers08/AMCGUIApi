package ariolmc.aMCGUIApi.core.namedInventory.factory;

import ariolmc.aMCGUIApi.core.namedInventory.NamedInventory;
import org.bukkit.inventory.InventoryHolder;

public interface NamedInventoryFactory {
    NamedInventory create(InventoryHolder owner);
}
