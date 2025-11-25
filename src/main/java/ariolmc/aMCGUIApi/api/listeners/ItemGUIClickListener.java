package ariolmc.aMCGUIApi.api.listeners;

import ariolmc.aMCGUIApi.api.events.ItemGUIClickEvent;
import ariolmc.aMCGUIApi.api.itemGUI.services.ItemGUIRegistry;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class ItemGUIClickListener implements Listener {

    private final ItemGUIRegistry registry;

    public ItemGUIClickListener(ItemGUIRegistry registry){
        this.registry = registry;
    }

    @EventHandler
    public void itemGUIClick(ItemGUIClickEvent event){
        registry.executeItemGUI(event.getItemGUI().getId(), event);
    }
}
