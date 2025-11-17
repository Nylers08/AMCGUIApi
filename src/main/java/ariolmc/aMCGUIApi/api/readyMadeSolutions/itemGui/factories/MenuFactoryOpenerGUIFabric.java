package ariolmc.aMCGUIApi.api.readyMadeSolutions.itemGui.factories;

import ariolmc.aMCGUIApi.AMCGUIApi;
import ariolmc.aMCGUIApi.api.itemGUI.itemGUIFactory.AbstractItemGUIFactory;
import ariolmc.aMCGUIApi.api.menu.services.services.MenuOpener;
import ariolmc.aMCGUIApi.api.menu.menu.factory.MenuFactory;
import ariolmc.aMCGUIApi.api.readyMadeSolutions.itemGui.actions.MenuFactoryOpenAction;
import org.bukkit.inventory.ItemStack;

import java.util.List;

public class MenuFactoryOpenerGUIFabric extends AbstractItemGUIFactory {

    public MenuFactoryOpenerGUIFabric(ItemStack item, MenuFactory menuFactory, MenuOpener opener) {
        super(
                item,
                List.of(new MenuFactoryOpenAction(AMCGUIApi.getInstance(), menuFactory, opener))
        );
    }
}
