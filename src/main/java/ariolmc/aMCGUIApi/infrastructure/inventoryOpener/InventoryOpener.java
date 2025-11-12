package ariolmc.aMCGUIApi.infrastructure.inventoryOpener;

import org.bukkit.inventory.Inventory;

import java.util.UUID;

public interface InventoryOpener {
    void open(UUID playerId, Inventory inv);
}
