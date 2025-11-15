package ariolmc.aMCGUIApi.core.listenersAndEvents.listeners;

import ariolmc.aMCGUIApi.AMCGUIApi;
import ariolmc.aMCGUIApi.core.itemGUI.services.ItemGUIRegistry;
import ariolmc.aMCGUIApi.core.itemGUI.utils.ItemIdUtils;
import ariolmc.aMCGUIApi.core.menu.menu.Menu;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;

import java.util.Objects;

public class InventoryClickListener implements Listener {

    private final ItemGUIRegistry itemGUIRegistry
            = AMCGUIApi.getInstance().getItemGUIRegistry();

    @EventHandler
    public void itemGUIClick(InventoryClickEvent event){
        ItemStack item = event.getCurrentItem();
        if(item == null || !ItemIdUtils.hasIdInNBT(item)) return;

        String id = ItemIdUtils.getIdFromNBT(item);
        if(itemGUIRegistry.hasItemGUI(id)){
            itemGUIRegistry.executeItemGUI(id, event);
        }
    }

    @EventHandler
    public void menuNotAllowedMovementClick(InventoryClickEvent event){
        InventoryHolder holder = Objects.requireNonNull(event.getInventory()).getHolder();
        if(holder instanceof Menu menu){
            cancelIfItemMovementDisabled(menu, event);
        }
    }

    private void cancelIfItemMovementDisabled(Menu menu, InventoryClickEvent event){
        if(!menu.isAllowItemMovement()){
            event.setCancelled(true);
        }
    }
}
