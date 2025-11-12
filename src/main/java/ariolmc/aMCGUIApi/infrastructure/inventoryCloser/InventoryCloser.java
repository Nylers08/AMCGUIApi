package ariolmc.aMCGUIApi.infrastructure.inventoryCloser;

import java.util.UUID;

public interface InventoryCloser {
    void closeInventory(UUID playerId);
}
