package ariolmc.aMCGUIApi.core.menu.namedInventory.fabric;

import ariolmc.aMCGUIApi.core.menu.namedInventory.NamedInventory;
import org.bukkit.inventory.InventoryHolder;

public interface NamedInventoryFabric {
    NamedInventory create(InventoryHolder owner);
}
