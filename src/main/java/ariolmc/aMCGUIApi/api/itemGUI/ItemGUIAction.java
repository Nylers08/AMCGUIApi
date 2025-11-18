package ariolmc.aMCGUIApi.api.itemGUI;

import ariolmc.aMCGUIApi.api.events.ItemGUIClickEvent;

/**
 * Действие, которое выполняется в ItemGUI, на который нажали
 */
@FunctionalInterface
public interface ItemGUIAction {

    void action(ItemGUIClickEvent event);
}
