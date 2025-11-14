package ariolmc.aMCGUIApi.core.menu.someMenu.factory;

import ariolmc.aMCGUIApi.AMCGUIApi;
import ariolmc.aMCGUIApi.core.itemGUI.ItemGUI;
import ariolmc.aMCGUIApi.core.itemGUI.itemGUIFactory.DecorBlackPaneItemGUIFactory;
import ariolmc.aMCGUIApi.core.itemGUI.itemGUIFactory.ItemGUIFactory;
import ariolmc.aMCGUIApi.core.menu.namedInventory.factory.GUINamedInvFactory;
import ariolmc.aMCGUIApi.core.menu.namedInventory.factory.NamedInventoryFactory;
import ariolmc.aMCGUIApi.core.menu.services.MenuServices;
import ariolmc.aMCGUIApi.core.menu.someMenu.BaseMenu;
import ariolmc.aMCGUIApi.core.menu.someMenu.Menu;
import net.kyori.adventure.text.Component;

public class TestMenuFactory implements MenuFactory{

    @Override
    public Menu create() {
        NamedInventoryFactory inventoryFactory = new GUINamedInvFactory(9, Component.text("§6Test"));
        BaseMenu menu = new BaseMenu(inventoryFactory);

        MenuServices services = AMCGUIApi.getInstance().getMenuServices();

        ItemGUIFactory guiFactory = new DecorBlackPaneItemGUIFactory();
        ItemGUI itemGUI = guiFactory.create();

        services.setItemGUI(menu, 0, itemGUI);
        services.setItemGUI(menu, 1, itemGUI);
        services.setItemGUI(menu, 2, itemGUI);
        services.setItemGUI(menu, 3, itemGUI);
        services.setItemGUI(menu, 5, itemGUI);
        services.setItemGUI(menu, 6, itemGUI);
        services.setItemGUI(menu, 7, itemGUI);
        services.setItemGUI(menu, 8, itemGUI);

        return menu;
    }
}
