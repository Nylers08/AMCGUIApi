package ariolmc.aMCGUIApi.core.listenersAndEvents.listeners;

import ariolmc.aMCGUIApi.AMCGUIApi;
import ariolmc.aMCGUIApi.core.itemGUI.services.ItemGUIRegistry;
import ariolmc.aMCGUIApi.core.itemGUI.utils.ItemIdUtils;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

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
}
