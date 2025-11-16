package ariolmc.aMCGUIApi.api.menu.services.services;

import ariolmc.aMCGUIApi.api.itemGUI.ItemGUI;
import ariolmc.aMCGUIApi.api.itemGUI.itemGUIFactory.ItemGUIFactory;
import ariolmc.aMCGUIApi.api.itemGUI.services.ItemGUIRegistry;
import ariolmc.aMCGUIApi.api.menu.menu.Menu;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class MenuItemGUISetter {

    private final ItemGUIRegistry itemGUIRegistry;

    public void setItemGUI(Menu menu, ItemGUI itemGUI, int... slots){
        for (int slot : slots){
            menu.setItem(slot, itemGUI.getItemStack());
        }
        itemGUIRegistry.register(itemGUI);
    }

    public void setItemGUI(Menu menu, ItemGUIFactory itemGUIFactory, int... slots){
        setItemGUI(menu, itemGUIFactory.create(), slots);
    }
}
