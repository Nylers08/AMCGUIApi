package ariolmc.aMCGUIApi.core.itemGUI.ItemActions;

import org.bukkit.event.inventory.InventoryClickEvent;

public class CancelInventoryClick implements Action{
    @Override
    public void action(InventoryClickEvent event) {
        System.out.println("Cancel Drag action!"); // TODO: отмена перетаскивание предмета в инвентаре
    }
}
