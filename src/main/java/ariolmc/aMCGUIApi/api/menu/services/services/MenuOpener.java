package ariolmc.aMCGUIApi.api.menu.services.services;

import ariolmc.aMCGUIApi.api.menu.menu.Menu;
import ariolmc.aMCGUIApi.api.menu.menu.factory.MenuFactory;
import ariolmc.aMCGUIApi.api.menu.services.services.menuRegistry.menuRegistry.MenuRegistry;
import ariolmc.aMCGUIApi.infrastructure.inventoryOpener.InventoryOpener;
import org.bukkit.plugin.Plugin;

import java.util.Set;
import java.util.UUID;

public class MenuOpener {

    private final MenuRegistry registry;
    private final InventoryOpener inventoryOpener;

    public MenuOpener(MenuRegistry registry, InventoryOpener opener){
        this.inventoryOpener = opener;
        this.registry = registry;
    }

    public void open(Plugin owner, UUID playerId, Menu menu){
        inventoryOpener.open(playerId, menu.getInventory());
        registry.register(owner, playerId, menu);
    }

    public void openNewMenu(Plugin owner, UUID playerId, MenuFactory factory){
        open(owner, playerId, factory.create());
    }

    public void reopen(Menu menu){
        Set<UUID> viewers = Set.copyOf(registry.getViewers(menu));
        Plugin plugin = registry.getPlugin(menu);
        if(viewers == null || viewers.isEmpty()) return;
        viewers.forEach(v->open(plugin, v, menu));
    }
}
