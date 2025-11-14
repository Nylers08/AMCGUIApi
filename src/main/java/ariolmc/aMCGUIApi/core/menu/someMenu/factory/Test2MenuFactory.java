package ariolmc.aMCGUIApi.core.menu.someMenu.factory;

import ariolmc.aMCGUIApi.AMCGUIApi;
import ariolmc.aMCGUIApi.core.itemGUI.ItemActions.RenameAction;
import ariolmc.aMCGUIApi.core.itemGUI.ItemGUI;
import ariolmc.aMCGUIApi.core.itemGUI.ItemStackBuilder;
import ariolmc.aMCGUIApi.core.itemGUI.itemGUIFactory.DecorItemGUIFactory;
import ariolmc.aMCGUIApi.core.itemGUI.itemGUIFactory.ItemGUIFactory;
import ariolmc.aMCGUIApi.core.menu.namedInventory.factory.GUINamedInvFactory;
import ariolmc.aMCGUIApi.core.menu.namedInventory.factory.NamedInventoryFactory;
import ariolmc.aMCGUIApi.core.menu.services.MenuServices;
import ariolmc.aMCGUIApi.core.menu.someMenu.BaseMenu;
import ariolmc.aMCGUIApi.core.menu.someMenu.Menu;
import net.kyori.adventure.text.Component;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class Test2MenuFactory implements MenuFactory{

    @Override
    public Menu create() {
        NamedInventoryFactory inventoryFactory = new GUINamedInvFactory(27, Component.text("§6Test"));
        BaseMenu menu = new BaseMenu(inventoryFactory);

        MenuServices services = AMCGUIApi.getInstance().getMenuServices();

        ItemStack itemStack = new ItemStackBuilder(Material.DRAGON_EGG).name(Component.text("§0TEST")).build();
        ItemGUIFactory guiFactory = new DecorItemGUIFactory(itemStack);
        ItemGUI itemGUI = guiFactory.create();
        itemGUI.addAction(new RenameAction());

        services.setItemGUI(menu, itemGUI, 0);

        return menu;
    }
}
