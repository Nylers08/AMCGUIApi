package ariolmc.aMCGUIApi.api.menu.services.services;

import ariolmc.aMCGUIApi.api.menu.menu.Menu;
import ariolmc.aMCGUIApi.api.menu.services.services.menuRegistry.menuRegistry.MenuRegistry;
import ariolmc.aMCGUIApi.infrastructure.inventoryCloser.InventoryCloser;
import org.bukkit.plugin.Plugin;

import java.util.Set;
import java.util.UUID;

public class MenuCloser {

    private final MenuRegistry registry;
    private final InventoryCloser closer;

    public MenuCloser(MenuRegistry registry, InventoryCloser closer){
        this.registry = registry;
        this.closer = closer;
    }

    public void close(UUID playerId){
        closer.closeInventory(playerId);
        registry.unregister(playerId);
    }

    public void closeAbsoluteAllMenu(){
        Set<Menu> menus = registry.getAllOpenMenus();
        menus.forEach(this::closeEveryone);
    }

    public void closeMenus(Plugin plugin){
        Set<Menu> menus = registry.getMenus(plugin);
        menus.forEach(this::closeEveryone);
    }

    public void closeEveryone(Menu menu){
        Set<UUID> viewers = registry.getViewers(menu);
        viewers.forEach(this::close);
    }
}
