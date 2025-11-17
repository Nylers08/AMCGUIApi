package ariolmc.aMCGUIApi.api.itemGUI.ItemActions;

import ariolmc.aMCGUIApi.api.events.ItemGUIClickEvent;
import org.bukkit.event.inventory.InventoryClickEvent;

public class CancelInventoryClick implements Action{
    @Override
    public void action(ItemGUIClickEvent event) {
        event.getInventoryClickEvent().setCancelled(true);
    }
}
