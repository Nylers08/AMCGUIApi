package ariolmc.aMCGUIApi.api.itemGUI;

import ariolmc.aMCGUIApi.api.events.ItemGUIClickEvent;

@FunctionalInterface
public interface ItemGUIAction {
    void action(ItemGUIClickEvent event);
}
