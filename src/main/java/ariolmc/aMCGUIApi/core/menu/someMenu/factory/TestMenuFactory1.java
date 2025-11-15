package ariolmc.aMCGUIApi.core.menu.someMenu.factory;

import ariolmc.aMCGUIApi.AMCGUIApi;
import ariolmc.aMCGUIApi.core.itemGUI.ItemGUI;
import ariolmc.aMCGUIApi.core.itemGUI.ItemStackBuilder;
import ariolmc.aMCGUIApi.core.itemGUI.itemGUIFactory.DecorItemGUIFactory;
import ariolmc.aMCGUIApi.core.menu.services.services.MenuItemGUISetter;
import ariolmc.aMCGUIApi.core.menu.someMenu.Menu;
import net.kyori.adventure.text.Component;
import org.bukkit.Material;

import java.util.Random;

public class TestMenuFactory1 implements MenuFactory{

    private final MenuItemGUISetter menuItemGUISetter = AMCGUIApi.getInstance().getMenuServices().itemGUISetter();
    private final BaseMenuFactory menuFactory = new BaseMenuFactory(27, Component.text("test1"));

    @Override
    public Menu create() {
        Menu menu = menuFactory.create();

        int intName = (int) (Math.random()*10);
        String name = String.valueOf(intName);
        Component component = Component.text(name);
        ItemGUI itemGUI = new DecorItemGUIFactory(new ItemStackBuilder(Material.RED_STAINED_GLASS_PANE).name(component).build()).create();

        menuItemGUISetter.setItemGUI(menu, itemGUI, 0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26);

        return menu;
    }
}
