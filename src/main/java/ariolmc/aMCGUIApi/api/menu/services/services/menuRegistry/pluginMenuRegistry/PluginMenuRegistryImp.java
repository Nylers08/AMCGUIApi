package ariolmc.aMCGUIApi.api.menu.services.services.menuRegistry.pluginMenuRegistry;

import ariolmc.aMCGUIApi.api.menu.menu.Menu;
import org.bukkit.plugin.Plugin;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class PluginMenuRegistryImp implements PluginMenuRegistry {

    private final Map<Plugin, Set<Menu>> pluginMenusMap = new HashMap<>();
    private final Map<Menu, Plugin> menuPluginMap = new HashMap<>();

    @Override
    public void register(Plugin plugin, Menu menu) {
        pluginMenusMap.computeIfAbsent(plugin, m->new HashSet<>()).add(menu);
        menuPluginMap.put(menu, plugin);
    }

    @Override
    public void unregister(Menu menu) {
        Plugin plugin = menuPluginMap.get(menu);
        if (plugin == null) return;
        menuPluginMap.remove(menu);
        removeMenuFromPlugin(plugin, menu);
    }

    private void removeMenuFromPlugin(Plugin plugin, Menu menu){
        Set<Menu> menus = pluginMenusMap.get(plugin);
        if (menus == null) return;
        menus.remove(menu);
        if(menus.isEmpty()){
            pluginMenusMap.remove(plugin);
        }
    }

    @Override
    public boolean existPlugin(Plugin plugin) {
        return pluginMenusMap.containsKey(plugin);
    }

    @Override
    public boolean existMenu(Menu menu) {
        return menuPluginMap.containsKey(menu);
    }

    @Override
    public Set<Plugin> getAllPlugins() {
        return pluginMenusMap.keySet();
    }

    @Override
    public Set<Menu> getMenus(Plugin plugin) {
        return menuPluginMap.keySet();
    }

    @Override
    public Plugin getPlugin(Menu menu) {
        return menuPluginMap.get(menu);
    }
}
