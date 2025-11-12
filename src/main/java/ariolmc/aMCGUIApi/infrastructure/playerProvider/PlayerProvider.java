package ariolmc.aMCGUIApi.infrastructure.playerProvider;

import org.bukkit.entity.Player;

import java.util.Optional;
import java.util.UUID;

public interface PlayerProvider {
    Optional<Player> findPlayerById(UUID id);
}
