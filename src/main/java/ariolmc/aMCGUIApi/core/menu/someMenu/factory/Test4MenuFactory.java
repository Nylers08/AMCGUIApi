package ariolmc.aMCGUIApi.core.menu.someMenu.factory;

import ariolmc.aMCGUIApi.AMCGUIApi;
import ariolmc.aMCGUIApi.core.itemGUI.ItemGUI;
import ariolmc.aMCGUIApi.core.itemGUI.ItemStackBuilder;
import ariolmc.aMCGUIApi.core.itemGUI.itemGUIFactory.ItemMenuOpenerFactory;
import ariolmc.aMCGUIApi.core.menu.services.services.MenuOpener;
import ariolmc.aMCGUIApi.core.menu.someMenu.Menu;
import net.kyori.adventure.text.Component;
import org.bukkit.Material;

public class Test4MenuFactory implements MenuFactory{

    private final Menu menu;

    public Test4MenuFactory(Menu menu){
        this.menu = menu;
    }

    @Override
    public Menu create() {
        Menu newMenu = new BaseMenuFactory(18, Component.text("TestMenu")).create();

        ItemGUI menuOpener = new ItemMenuOpenerFactory(
                new ItemStackBuilder(Material.STONE_BUTTON).name(Component.text("menu")).build(),
                menu,
                AMCGUIApi.getInstance().getMenuServices().opener()
        ).create();

        AMCGUIApi.getInstance().getMenuServices().setItemGUI(newMenu,0, menuOpener);

        return newMenu;
    }
}
