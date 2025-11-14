package ariolmc.aMCGUIApi.core.menu.someMenu.factory;

import ariolmc.aMCGUIApi.AMCGUIApi;
import ariolmc.aMCGUIApi.core.itemGUI.ItemGUI;
import ariolmc.aMCGUIApi.core.itemGUI.ItemStackBuilder;
import ariolmc.aMCGUIApi.core.itemGUI.itemGUIFactory.DecorItemGUIFactory;
import ariolmc.aMCGUIApi.core.menu.services.MenuServices;
import ariolmc.aMCGUIApi.core.menu.someMenu.Menu;
import net.kyori.adventure.text.Component;
import org.bukkit.Material;

public class AnimationFrame22 implements MenuFactory{

    @Override
    public Menu create(){
        Menu menu = new BaseMenuFactory(18, Component.text("Frame22")).create();

        ItemGUI itemGUI1 = new DecorItemGUIFactory(new ItemStackBuilder(Material.BLUE_STAINED_GLASS_PANE).build()).create();
        ItemGUI itemGUI2 = new DecorItemGUIFactory(new ItemStackBuilder(Material.RED_STAINED_GLASS_PANE).build()).create();

        MenuServices services = AMCGUIApi.getInstance().getMenuServices();

        services.setItemGUI(menu, itemGUI2, 0, 1, 2, 3, 9, 10, 11, 12);
        services.setItemGUI(menu, itemGUI1, 5, 6, 7, 8, 14, 15, 16, 17);

        return menu;
    }
}
