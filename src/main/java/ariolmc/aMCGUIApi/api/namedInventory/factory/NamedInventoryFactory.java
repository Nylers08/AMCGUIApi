package ariolmc.aMCGUIApi.api.namedInventory.factory;

import ariolmc.aMCGUIApi.api.namedInventory.NamedInventory;
import org.bukkit.inventory.InventoryHolder;

public interface NamedInventoryFactory {
    NamedInventory create(InventoryHolder owner);
}
