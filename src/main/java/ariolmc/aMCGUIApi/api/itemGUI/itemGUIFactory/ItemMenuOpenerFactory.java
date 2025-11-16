package ariolmc.aMCGUIApi.api.itemGUI.itemGUIFactory;

import ariolmc.aMCGUIApi.api.itemGUI.ItemActions.MenuOpenAction;
import ariolmc.aMCGUIApi.api.menu.services.services.MenuOpener;
import ariolmc.aMCGUIApi.api.menu.menu.Menu;
import org.bukkit.inventory.ItemStack;

import java.util.List;

public class ItemMenuOpenerFactory extends AbstractItemGUIFactory{

    public ItemMenuOpenerFactory(ItemStack item, Menu menu, MenuOpener opener) {
        super(item, List.of(new MenuOpenAction(menu, opener)));
    }
}
