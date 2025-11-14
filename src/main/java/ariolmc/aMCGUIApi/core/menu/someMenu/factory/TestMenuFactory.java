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
        NamedInventoryFactory inventoryFactory = new GUINamedInvFactory(27, Component.text("§6Test"));
        BaseMenu menu = new BaseMenu(inventoryFactory);

        MenuServices services = AMCGUIApi.getInstance().getMenuServices();

        ItemGUIFactory guiFactory = new DecorBlackPaneItemGUIFactory();
        ItemGUI itemGUI = guiFactory.create();

        services.setItemGUI(menu, itemGUI, 0, 1, 2, 3, 5, 6, 7, 8);

        return menu;
    }
}
