package ariolmc.aMCGUIApi.core.itemGUI.services;

import ariolmc.aMCGUIApi.core.itemGUI.ItemGUI;
import ariolmc.aMCGUIApi.core.itemGUI.itemGUIFabric.ItemGUIFabric;

public class ItemGUIFabricRegistrar {

    private final ItemGUIRegistry itemGUIRegistry;

    public ItemGUIFabricRegistrar(ItemGUIRegistry itemGUIRegistry){
        this.itemGUIRegistry = itemGUIRegistry;
    }

    public ItemGUI createAndRegister(ItemGUIFabric fabric){
        ItemGUI itemGUI = fabric.create();
        itemGUIRegistry.register(itemGUI);
        return itemGUI;
    }
}
