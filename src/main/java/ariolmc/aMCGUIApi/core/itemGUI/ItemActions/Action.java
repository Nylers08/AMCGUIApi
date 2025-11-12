package ariolmc.aMCGUIApi.core.itemGUI.ItemActions;

import org.bukkit.event.inventory.InventoryClickEvent;

@FunctionalInterface
public interface Action {
    void action(InventoryClickEvent event);
}
