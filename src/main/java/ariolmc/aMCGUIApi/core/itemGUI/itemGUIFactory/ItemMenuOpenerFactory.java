package ariolmc.aMCGUIApi.core.itemGUI.itemGUIFactory;

import ariolmc.aMCGUIApi.core.itemGUI.ItemActions.Action;
import ariolmc.aMCGUIApi.core.itemGUI.ItemActions.MenuOpenAction;
import ariolmc.aMCGUIApi.core.menu.services.services.MenuOpener;
import ariolmc.aMCGUIApi.core.menu.someMenu.Menu;
import org.bukkit.inventory.ItemStack;

import java.util.List;

public class ItemMenuOpenerFactory extends AbstractItemGUIFactory{

    public ItemMenuOpenerFactory(ItemStack item, Menu menu, MenuOpener opener) {
        super(item, List.of(new MenuOpenAction(menu, opener)));
    }
}
