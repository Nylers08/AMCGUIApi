package ariolmc.aMCGUIApi.api.itemGUI.ItemActions;

import ariolmc.aMCGUIApi.api.events.ItemGUIClickEvent;

@FunctionalInterface
public interface Action {
    void action(ItemGUIClickEvent event);
}
