package ariolmc.aMCGUIApi.infrastructure;

import ariolmc.aMCGUIApi.infrastructure.inventoryOpener.BukkitInventoryOpener;
import ariolmc.aMCGUIApi.infrastructure.inventoryOpener.InventoryOpener;
import ariolmc.aMCGUIApi.infrastructure.playerProvider.BukkitPlayerProvider;
import ariolmc.aMCGUIApi.infrastructure.playerProvider.PlayerProvider;
import lombok.Getter;

public class ApiWrappers {

    @Getter private final PlayerProvider playerProvider;
    @Getter private final InventoryOpener inventoryOpener;

    public ApiWrappers(){
        playerProvider = new BukkitPlayerProvider();
        inventoryOpener = new BukkitInventoryOpener(playerProvider);
    }
}
