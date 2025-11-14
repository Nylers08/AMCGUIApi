package ariolmc.aMCGUIApi.core.menu.someMenu.factory;

import ariolmc.aMCGUIApi.AMCGUIApi;
import ariolmc.aMCGUIApi.core.itemGUI.ItemGUI;
import ariolmc.aMCGUIApi.core.itemGUI.itemGUIFactory.DecorItemGUIFactory;
import ariolmc.aMCGUIApi.core.itemGUI.itemGUIFactory.ItemGUIFactory;
import ariolmc.aMCGUIApi.core.menu.namedInventory.factory.GUINamedInvFactory;
import ariolmc.aMCGUIApi.core.menu.namedInventory.factory.NamedInventoryFactory;
import ariolmc.aMCGUIApi.core.menu.services.MenuServices;
import ariolmc.aMCGUIApi.core.menu.someMenu.BaseMenu;
import ariolmc.aMCGUIApi.core.menu.someMenu.Menu;
import net.kyori.adventure.text.Component;
import org.bukkit.Material;

public class Test2MenuFactory implements MenuFactory{

    @Override
    public Menu create() {
        NamedInventoryFactory inventoryFactory = new GUINamedInvFactory(18, Component.text("§6Test"));
        BaseMenu menu = new BaseMenu(inventoryFactory);

        MenuServices services = AMCGUIApi.getInstance().getMenuServices();

        ItemGUIFactory guiFactory = new DecorItemGUIFactory(Component.text("§0Test"), Material.DRAGON_EGG);
        ItemGUI itemGUI = guiFactory.create();

        services.setItemGUI(menu, 0, itemGUI);
        services.setItemGUI(menu, 9, itemGUI);
        services.setItemGUI(menu, 8, itemGUI);
        services.setItemGUI(menu, 17, itemGUI);

        return menu;
    }
}
