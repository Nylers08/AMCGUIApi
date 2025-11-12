package ariolmc.aMCGUIApi.infrastructure.inventoryOpener;

import ariolmc.aMCGUIApi.infrastructure.playerProvider.PlayerProvider;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import java.util.Optional;
import java.util.UUID;

public class BukkitInventoryOpener implements InventoryOpener{

    private final PlayerProvider playerProvider;

    public BukkitInventoryOpener(PlayerProvider playerProvider){
        this.playerProvider = playerProvider;
    }

    @Override
    public void open(UUID playerId, Inventory inv) {
        Optional<Player> player = playerProvider.findPlayerById(playerId);
        player.ifPresent(p-> p.openInventory(inv));
    }
}
