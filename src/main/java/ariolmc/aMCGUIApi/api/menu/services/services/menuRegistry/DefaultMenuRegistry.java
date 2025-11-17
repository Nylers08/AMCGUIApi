package ariolmc.aMCGUIApi.api.menu.services.services.menuRegistry;

import ariolmc.aMCGUIApi.api.menu.services.services.menuRegistry.menuRegistry.MenuRegistryImpl;
import ariolmc.aMCGUIApi.api.menu.services.services.menuRegistry.openMenuRegistrty.OpenMenuRegistryImp;
import ariolmc.aMCGUIApi.api.menu.services.services.menuRegistry.pluginMenuRegistry.PluginMenuRegistryImp;

public class DefaultMenuRegistry extends MenuRegistryImpl {

    public DefaultMenuRegistry() {
        super(new OpenMenuRegistryImp(), new PluginMenuRegistryImp());
    }
}
