package ariolmc.aMCGUIApi.core.menu.services;

import ariolmc.aMCGUIApi.core.menu.someMenu.BaseMenu;
import ariolmc.aMCGUIApi.core.menu.someMenu.Menu;
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

    public void reopen(Menu menu){
        Set<UUID> viewers = registry.getViewers(menu);
        viewers.forEach(v->open(v, menu));
    }
}
