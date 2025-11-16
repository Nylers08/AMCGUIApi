package ariolmc.aMCGUIApi.api.listeners;

import ariolmc.aMCGUIApi.api.menu.services.services.MenuRegistry;
import ariolmc.aMCGUIApi.api.menu.menu.Menu;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.InventoryHolder;

import java.util.UUID;

public class InventoryCloseListener implements Listener {

    private final MenuRegistry menuRegistry;

    public InventoryCloseListener(MenuRegistry menuRegistry){
        this.menuRegistry = menuRegistry;
    }

    @EventHandler
    public void unregisterMenu(InventoryCloseEvent event){
        InventoryHolder holder = event.getInventory().getHolder();
        UUID playerId = event.getPlayer().getUniqueId();
        if(holder instanceof Menu){
            menuRegistry.unregister(playerId);
        }
    }
}
