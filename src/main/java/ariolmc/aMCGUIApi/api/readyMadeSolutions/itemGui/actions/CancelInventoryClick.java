package ariolmc.aMCGUIApi.api.readyMadeSolutions.itemGui.actions;

import ariolmc.aMCGUIApi.api.events.ItemGUIClickEvent;
import ariolmc.aMCGUIApi.api.itemGUI.ItemGUIAction;
import org.bukkit.event.inventory.InventoryClickEvent;

public class CancelInventoryClick implements ItemGUIAction {
    @Override
    public void action(ItemGUIClickEvent event) {
        event.getInventoryClickEvent().setCancelled(true);
    }
}
