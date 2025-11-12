package ariolmc.aMCGUIApi.infrastructure.playerProvider;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.Optional;
import java.util.UUID;

public class BukkitPlayerProvider implements PlayerProvider{

    @Override
    public Optional<Player> findPlayerById(UUID id) {
        return Optional.ofNullable(Bukkit.getPlayer(id));
    }
}
