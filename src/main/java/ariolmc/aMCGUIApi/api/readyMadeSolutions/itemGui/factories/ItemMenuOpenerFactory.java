package ariolmc.aMCGUIApi.api.readyMadeSolutions.itemGui.factories;

import ariolmc.aMCGUIApi.AMCGUIApi;
import ariolmc.aMCGUIApi.api.itemGUI.itemGUIFactory.AbstractItemGUIFactory;
import ariolmc.aMCGUIApi.api.menu.services.services.MenuOpener;
import ariolmc.aMCGUIApi.api.menu.menu.Menu;
import ariolmc.aMCGUIApi.api.readyMadeSolutions.itemGui.actions.MenuOpenAction;
import org.bukkit.inventory.ItemStack;

import java.util.List;

public class ItemMenuOpenerFactory extends AbstractItemGUIFactory {

    public ItemMenuOpenerFactory(ItemStack item, Menu menu, MenuOpener opener) {
        super(item, List.of(new MenuOpenAction(AMCGUIApi.getInstance(), menu, opener)));
    }
}
