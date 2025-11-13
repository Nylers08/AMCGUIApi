package ariolmc.aMCGUIApi.core.menu.services;

import ariolmc.aMCGUIApi.core.menu.someMenu.Menu;
import ariolmc.aMCGUIApi.infrastructure.inventoryCloser.InventoryCloser;

import java.util.Set;
import java.util.UUID;

public class MenuCloser {

    private final InventoryCloser closer;
    private final MenuRegistry registry;

    public MenuCloser(InventoryCloser closer, MenuRegistry registry){
        this.closer = closer;
        this.registry = registry;
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
