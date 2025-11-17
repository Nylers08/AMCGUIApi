package ariolmc.aMCGUIApi.api.menu.services.services.menuRegistry.pluginMenuRegistry;

import ariolmc.aMCGUIApi.api.menu.services.services.menuRegistry.menuRegistry.RegistryMenuExistence;
import org.bukkit.plugin.Plugin;

public interface PluginMenuExistence extends RegistryMenuExistence {

    boolean existPlugin(Plugin plugin);

}
