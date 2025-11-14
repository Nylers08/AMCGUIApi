package ariolmc.aMCGUIApi.core.menu.someMenu.factory;

import ariolmc.aMCGUIApi.AMCGUIApi;
import ariolmc.aMCGUIApi.core.itemGUI.ItemGUI;
import ariolmc.aMCGUIApi.core.itemGUI.ItemStackBuilder;
import ariolmc.aMCGUIApi.core.itemGUI.itemGUIFactory.MenuFactoryOpenerGUIFabric;
import ariolmc.aMCGUIApi.core.menu.services.MenuServices;
import ariolmc.aMCGUIApi.core.menu.someMenu.Menu;
import net.kyori.adventure.text.Component;
import org.bukkit.Material;

public class Test3MenuFactory implements MenuFactory{

    private final int pageNumber;

    public Test3MenuFactory(){
        this.pageNumber = 1;
    };

    public Test3MenuFactory(int pageNumber){
        this.pageNumber = pageNumber;
    }

    @Override
    public Menu create() {
        Menu menu = new BaseMenuFactory(27, buildTitle()).create();

        MenuServices services = AMCGUIApi.getInstance().getMenuServices();

        ItemGUI itemGUI = new MenuFactoryOpenerGUIFabric(
                new ItemStackBuilder(Material.ARROW).name(Component.text("menuOpener+1")).build(),
                new Test3MenuFactory(pageNumber+1),
                services.opener()
        ).create();

        ItemGUI gui2 = new MenuFactoryOpenerGUIFabric(
                new ItemStackBuilder(Material.ARROW).name(Component.text("menuOpener-1")).build(),
                new Test3MenuFactory(pageNumber-1),
                services.opener()
        ).create();


        services.setItemGUI(menu, itemGUI, 1);
        services.setItemGUI(menu, gui2, 0);

        return menu;
    }


    private Component buildTitle(){
        return Component.text("Страница: " + pageNumber);
    }
}
