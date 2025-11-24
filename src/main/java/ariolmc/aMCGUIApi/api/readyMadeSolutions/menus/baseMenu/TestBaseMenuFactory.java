package ariolmc.aMCGUIApi.api.readyMadeSolutions.menus.baseMenu;

import ariolmc.aMCGUIApi.AMCGUIApi;
import ariolmc.aMCGUIApi.api.itemGUI.ItemGUI;
import ariolmc.aMCGUIApi.api.itemGUI.ItemStackBuilder;
import ariolmc.aMCGUIApi.api.itemGUI.itemGUIFactory.ItemGUIFactory;
import ariolmc.aMCGUIApi.api.menu.menu.Menu;
import ariolmc.aMCGUIApi.api.menu.menu.factory.BaseMenuFactory;
import ariolmc.aMCGUIApi.api.menu.menu.factory.MenuFactory;
import ariolmc.aMCGUIApi.api.menu.services.MenuServices;
import ariolmc.aMCGUIApi.api.readyMadeSolutions.itemGui.factories.DecorBlackPaneItemGUIFactory;
import ariolmc.aMCGUIApi.api.readyMadeSolutions.itemGui.factories.DecorItemGUIFactory;
import ariolmc.aMCGUIApi.api.readyMadeSolutions.itemGui.factories.ItemMenuOpenerFactory;
import ariolmc.aMCGUIApi.api.readyMadeSolutions.itemGui.factories.MenuFactoryOpenerGUIFabric;
import net.kyori.adventure.text.Component;
import org.bukkit.Material;

public class TestBaseMenuFactory implements MenuFactory {

    MenuServices menuServices = AMCGUIApi.getInstance().getMenuServices();

    @Override
    public Menu create() {

        Menu menu = new BaseMenuFactory(9, Component.text("asd")).create();

        return menu;
    }
}
