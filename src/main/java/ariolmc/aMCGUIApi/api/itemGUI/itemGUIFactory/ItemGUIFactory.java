package ariolmc.aMCGUIApi.api.itemGUI.itemGUIFactory;

import ariolmc.aMCGUIApi.api.itemGUI.ItemGUI;

/**
 * Фабрика по созданию ItemGUI
 */
@FunctionalInterface
public interface ItemGUIFactory {
    ItemGUI create();
}
