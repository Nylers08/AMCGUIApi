package ariolmc.aMCGUIApi.api.menu.services.services.menuRegistry.menuRegistry;

import ariolmc.aMCGUIApi.api.menu.menu.Menu;
import ariolmc.aMCGUIApi.api.menu.services.exceptions.NotFoundMenuViewer;
import ariolmc.aMCGUIApi.api.menu.services.services.menuRegistry.openMenuRegistrty.OpenMenuRegistry;
import ariolmc.aMCGUIApi.api.menu.services.services.menuRegistry.pluginMenuRegistry.PluginMenuRegistry;
import org.bukkit.plugin.Plugin;

import java.util.Optional;
import java.util.Set;
import java.util.UUID;

public class MenuRegistryImpl implements MenuRegistry{

    private final OpenMenuRegistry openMenuRegistry;
    private final PluginMenuRegistry pluginMenuRegistry;

    public MenuRegistryImpl(OpenMenuRegistry openMenuRegistry, PluginMenuRegistry pluginMenuRegistry) {
        this.openMenuRegistry = openMenuRegistry;
        this.pluginMenuRegistry = pluginMenuRegistry;
    }

    @Override
    public void register(Plugin plugin, UUID viewerId, Menu menu) {
        openMenuRegistry.register(viewerId, menu);
        pluginMenuRegistry.register(plugin, menu);
    }

    @Override
    public void unregister(UUID viewerId) {
        Optional<Menu> menu = openMenuRegistry.getMenu(viewerId);
        if(menu.isEmpty()) throw new NotFoundMenuViewer(viewerId);

        openMenuRegistry.unregister(viewerId);
        pluginMenuRegistry.unregister(menu.get());
    }

    @Override
    public boolean existMenu(Menu menu) {
        return openMenuRegistry.existMenu(menu);
    }

    @Override
    public Optional<Menu> getMenu(UUID viewerId) {
        return openMenuRegistry.getMenu(viewerId);
    }

    @Override
    public Set<UUID> getViewers(Menu menu) {
        return openMenuRegistry.getViewers(menu);
    }

    @Override
    public Set<Menu> getAllOpenMenus() {
        return openMenuRegistry.getAllOpenMenus();
    }

    @Override
    public boolean existViewer(UUID viewerId) {
        return openMenuRegistry.existViewer(viewerId);
    }

    @Override
    public Set<Plugin> getAllPlugins() {
        return pluginMenuRegistry.getAllPlugins();
    }

    @Override
    public Set<Menu> getMenus(Plugin plugin) {
        return pluginMenuRegistry.getMenus(plugin);
    }

    @Override
    public Plugin getPlugin(Menu menu) {
        return pluginMenuRegistry.getPlugin(menu);
    }

    @Override
    public boolean existPlugin(Plugin plugin) {
        return pluginMenuRegistry.existPlugin(plugin);
    }
}
