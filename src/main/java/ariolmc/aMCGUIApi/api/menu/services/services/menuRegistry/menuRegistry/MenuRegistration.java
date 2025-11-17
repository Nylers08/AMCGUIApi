package ariolmc.aMCGUIApi.api.menu.services.services.menuRegistry.menuRegistry;

import ariolmc.aMCGUIApi.api.menu.menu.Menu;
import org.bukkit.plugin.Plugin;

import java.util.UUID;

public interface MenuRegistration {

    void register(Plugin plugin, UUID viewerId, Menu menu);
    void unregister(UUID viewerId);
}
