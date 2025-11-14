package ariolmc.aMCGUIApi.core.menu.services.services;

import ariolmc.aMCGUIApi.core.itemGUI.ItemGUI;
import ariolmc.aMCGUIApi.core.itemGUI.itemGUIFabric.ItemGUIFabric;
import ariolmc.aMCGUIApi.core.itemGUI.services.ItemGUIRegistry;
import ariolmc.aMCGUIApi.core.menu.someMenu.Menu;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class MenuItemGUISetter {

    private final ItemGUIRegistry itemGUIRegistry;

    public void setItemGUI(Menu menu, int slot, ItemGUI itemGUI){
        menu.setItem(slot, itemGUI.getItemStack());
        itemGUIRegistry.register(itemGUI);
    }

    public void setItemGUI(Menu menu, int slot, ItemGUIFabric itemGUIFabric){
        setItemGUI(menu, slot, itemGUIFabric.create());
    }
}
