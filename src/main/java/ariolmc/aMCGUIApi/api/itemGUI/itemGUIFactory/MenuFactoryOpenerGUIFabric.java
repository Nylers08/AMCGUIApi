package ariolmc.aMCGUIApi.api.itemGUI.itemGUIFactory;

import ariolmc.aMCGUIApi.api.itemGUI.ItemActions.MenuFactoryOpenAction;
import ariolmc.aMCGUIApi.api.menu.services.services.MenuOpener;
import ariolmc.aMCGUIApi.api.menu.menu.factory.MenuFactory;
import org.bukkit.inventory.ItemStack;

import java.util.List;

public class MenuFactoryOpenerGUIFabric extends AbstractItemGUIFactory{

    public MenuFactoryOpenerGUIFabric(ItemStack item, MenuFactory menuFactory, MenuOpener opener) {
        super(
                item,
                List.of(new MenuFactoryOpenAction(menuFactory, opener))
        );
    }
}
