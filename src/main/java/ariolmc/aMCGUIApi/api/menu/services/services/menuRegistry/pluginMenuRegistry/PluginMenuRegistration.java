package ariolmc.aMCGUIApi.api.menu.services.services.menuRegistry.pluginMenuRegistry;

import ariolmc.aMCGUIApi.api.menu.menu.Menu;
import org.bukkit.plugin.Plugin;

public interface PluginMenuRegistration {
    void register(Plugin plugin, Menu menu);
    void unregister(Menu menu);
}
