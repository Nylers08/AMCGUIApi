package ariolmc.aMCGUIApi.core.menu.services.services;

import ariolmc.aMCGUIApi.core.menu.menu.Menu;
import ariolmc.aMCGUIApi.infrastructure.inventoryCloser.InventoryCloser;

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

    public void closeEveryone(Menu menu){
        Set<UUID> viewers = registry.getViewers(menu);
        viewers.forEach(this::close);
    }
}
