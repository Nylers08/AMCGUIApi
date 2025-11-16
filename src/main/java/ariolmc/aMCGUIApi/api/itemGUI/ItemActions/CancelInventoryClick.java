package ariolmc.aMCGUIApi.api.itemGUI.ItemActions;

import org.bukkit.event.inventory.InventoryClickEvent;

public class CancelInventoryClick implements Action{
    @Override
    public void action(InventoryClickEvent event) {
        event.setCancelled(true);
    }
}
