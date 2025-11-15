package ariolmc.aMCGUIApi.core.itemGUI.itemGUIFactory;

import ariolmc.aMCGUIApi.core.itemGUI.ItemActions.MenuFactoryOpenAction;
import ariolmc.aMCGUIApi.core.menu.services.services.MenuOpener;
import ariolmc.aMCGUIApi.core.menu.menu.factory.MenuFactory;
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
