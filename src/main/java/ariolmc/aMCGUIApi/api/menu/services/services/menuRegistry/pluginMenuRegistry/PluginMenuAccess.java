package ariolmc.aMCGUIApi.api.menu.services.services.menuRegistry.pluginMenuRegistry;

import ariolmc.aMCGUIApi.api.menu.menu.Menu;
import org.bukkit.plugin.Plugin;

import java.util.Set;

public interface PluginMenuAccess {

    Set<Plugin> getAllPlugins();
    Set<Menu> getMenus(Plugin plugin);
    Plugin getPlugin(Menu menu);
}
