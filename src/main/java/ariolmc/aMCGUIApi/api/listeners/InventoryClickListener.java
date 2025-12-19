package ariolmc.aMCGUIApi.api.listeners;

import ariolmc.aMCGUIApi.api.events.ItemGUIClickEvent;
import ariolmc.aMCGUIApi.api.itemGUI.ItemGUI;
import ariolmc.aMCGUIApi.api.itemGUI.services.ItemGUIRegistry;
import ariolmc.aMCGUIApi.api.itemGUI.utils.ItemIdUtils;
import ariolmc.aMCGUIApi.api.menu.menu.Menu;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;

import java.util.Objects;

public class InventoryClickListener implements Listener {

    @EventHandler
    public void itemGUIClick(InventoryClickEvent event){
        InventoryHolder holder = event.getInventory().getHolder();
        if(!(holder instanceof Menu menu)){
            return;
        }
        ItemGUIRegistry itemGUIRegistry = menu.getItemGUIRegistry();

        ItemStack item = event.getCurrentItem();
        if(item == null || !ItemIdUtils.hasIdInNBT(item)) return;

        String id = ItemIdUtils.getIdFromNBT(item);
        if(itemGUIRegistry.hasItemGUI(id)){
            ItemGUI itemGUI = itemGUIRegistry.getItemGUI(id);
            ItemGUIClickEvent itemGUIClickEvent = new ItemGUIClickEvent(event, itemGUI);
            itemGUIClickEvent.callEvent();
            itemGUIRegistry.executeItemGUI(id, itemGUIClickEvent);
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
