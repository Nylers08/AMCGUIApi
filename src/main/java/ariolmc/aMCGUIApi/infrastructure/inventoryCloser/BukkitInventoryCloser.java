package ariolmc.aMCGUIApi.infrastructure.inventoryCloser;

import ariolmc.aMCGUIApi.infrastructure.playerProvider.PlayerProvider;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;

import java.util.Optional;
import java.util.UUID;

public class BukkitInventoryCloser implements InventoryCloser{

    private final PlayerProvider playerProvider;

    public BukkitInventoryCloser(PlayerProvider playerProvider){
        this.playerProvider = playerProvider;
    }

    @Override
    public void closeInventory(UUID playerId) {
        Optional<Player> player = playerProvider.findPlayerById(playerId);
        player.ifPresent(HumanEntity::closeInventory);
    }
}
