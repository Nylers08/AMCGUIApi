package ariolmc.aMCGUIApi.api.readyMadeSolutions.menus.baseMenu;

import ariolmc.aMCGUIApi.AMCGUIApi;
import ariolmc.aMCGUIApi.api.itemGUI.ItemGUI;
import ariolmc.aMCGUIApi.api.itemGUI.ItemStackBuilder;
import ariolmc.aMCGUIApi.api.menu.menu.Menu;
import ariolmc.aMCGUIApi.api.menu.menu.factory.BaseMenuFactory;
import ariolmc.aMCGUIApi.api.menu.menu.factory.MenuFactory;
import ariolmc.aMCGUIApi.api.menu.services.MenuServices;
import ariolmc.aMCGUIApi.api.readyMadeSolutions.itemGui.factories.DecorItemGUIFactory;
import net.kyori.adventure.text.Component;
import org.bukkit.Material;

public class TestBaseMenuFactory2 implements MenuFactory {

    @Override
    public Menu create() {

        Menu menu = new BaseMenuFactory(9, Component.text("asd")).create();

        MenuServices menuServices = AMCGUIApi.getInstance().getMenuServices();

        ItemGUI itemGUI = new DecorItemGUIFactory(new ItemStackBuilder(Material.WHITE_STAINED_GLASS_PANE)
                .name(Component.text(" ")).build()).create();

        menuServices.setItemGUI(menu, itemGUI, 0,1,2,3,4,5,6,7,8);

        return menu;
    }
}
