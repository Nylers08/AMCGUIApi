package ariolmc.aMCGUIApi.api.menu.services.services;

import ariolmc.aMCGUIApi.api.menu.menu.Menu;
import ariolmc.aMCGUIApi.api.menu.menu.factory.MenuFactory;
import ariolmc.aMCGUIApi.infrastructure.inventoryOpener.InventoryOpener;

import java.util.Set;
import java.util.UUID;

public class MenuOpener {

    private final MenuRegistry registry;
    private final InventoryOpener inventoryOpener;

    public MenuOpener(MenuRegistry registry, InventoryOpener opener){
        this.inventoryOpener = opener;
        this.registry = registry;
    }

    public void open(UUID playerId, Menu menu){
        inventoryOpener.open(playerId, menu.getInventory());
        registry.register(playerId, menu);
    }

    public void openNewMenu(UUID playerId, MenuFactory factory){
        open(playerId, factory.create());
    }

    public void reopen(Menu menu){
        Set<UUID> viewers = registry.getViewers(menu);
        if(viewers == null || viewers.isEmpty()) return;
        viewers.forEach(v->open(v, menu));
    }
}
