package ariolmc.aMCGUIApi.core.menu.menu.factory;

import ariolmc.aMCGUIApi.AMCGUIApi;
import ariolmc.aMCGUIApi.core.itemGUI.ItemGUI;
import ariolmc.aMCGUIApi.core.itemGUI.ItemStackBuilder;
import ariolmc.aMCGUIApi.core.itemGUI.itemGUIFactory.DecorItemGUIFactory;
import ariolmc.aMCGUIApi.core.menu.menu.Menu;
import ariolmc.aMCGUIApi.core.menu.services.MenuServices;
import net.kyori.adventure.text.Component;
import org.bukkit.Material;

public class TestMenuFactory2 implements MenuFactory{

    @Override
    public Menu create() {
        Menu menu = new BaseMenuFactory(9, Component.text("frame2")).create();

        MenuServices menuServices = AMCGUIApi.getInstance().getMenuServices();

        ItemGUI itemGUI = new DecorItemGUIFactory(new ItemStackBuilder(Material.BLUE_STAINED_GLASS_PANE).name(Component.text(" ")).build()).create();

        menuServices.setItemGUI(menu, itemGUI, 0,1,2,3,4,5,6,7,8);

        return menu;
    }
}
