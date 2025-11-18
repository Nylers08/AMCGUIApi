package ariolmc.aMCGUIApi.api.menu.services.services.menuRegistry.menuRegistry;

import ariolmc.aMCGUIApi.api.menu.services.services.menuRegistry.openMenuRegistrty.OpenMenuAccess;
import ariolmc.aMCGUIApi.api.menu.services.services.menuRegistry.openMenuRegistrty.OpenMenuExistence;
import ariolmc.aMCGUIApi.api.menu.services.services.menuRegistry.pluginMenuRegistry.PluginMenuAccess;
import ariolmc.aMCGUIApi.api.menu.services.services.menuRegistry.pluginMenuRegistry.PluginMenuExistence;

/**
 * Регистрирует в себе Menu
 */
public interface MenuRegistry extends
        MenuRegistration,
        RegistryMenuExistence,
        OpenMenuAccess,
        OpenMenuExistence,
        PluginMenuAccess,
        PluginMenuExistence {
}
