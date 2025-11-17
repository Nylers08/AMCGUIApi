package ariolmc.aMCGUIApi.api.menu.services.services.menuRegistry.menuRegistry;

import ariolmc.aMCGUIApi.api.menu.services.services.menuRegistry.openMenuRegistrty.OpenMenuAccess;
import ariolmc.aMCGUIApi.api.menu.services.services.menuRegistry.openMenuRegistrty.OpenMenuExistence;
import ariolmc.aMCGUIApi.api.menu.services.services.menuRegistry.pluginMenuRegistry.PluginMenuAccess;
import ariolmc.aMCGUIApi.api.menu.services.services.menuRegistry.pluginMenuRegistry.PluginMenuExistence;

public interface MenuRegistry extends
        MenuRegistration,
        RegistryMenuExistence,
        OpenMenuAccess,
        OpenMenuExistence,
        PluginMenuAccess,
        PluginMenuExistence {

//    private final OpenMenuRegistry openMenuRegistry;
//    private final PluginMenuRegistry pluginMenuRegistry;
//
//    public MenuRegistry(OpenMenuRegistry openMenuRegistry, PluginMenuRegistry pluginMenuRegistry) {
//        this.openMenuRegistry = openMenuRegistry;
//        this.pluginMenuRegistry = pluginMenuRegistry;
//    }


}
