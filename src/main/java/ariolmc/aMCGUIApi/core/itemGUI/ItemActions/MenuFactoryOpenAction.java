package ariolmc.aMCGUIApi.core.itemGUI.ItemActions;

import ariolmc.aMCGUIApi.core.menu.services.services.MenuOpener;
import ariolmc.aMCGUIApi.core.menu.menu.factory.MenuFactory;
import org.bukkit.event.inventory.InventoryClickEvent;

import java.util.UUID;

public class MenuFactoryOpenAction implements Action {

    private final MenuFactory menuFactory;
    private final MenuOpener opener;

    public MenuFactoryOpenAction(MenuFactory menuFactory, MenuOpener opener){
        this.menuFactory = menuFactory;
        this.opener = opener;
    }

    @Override
    public void action(InventoryClickEvent event) {
        UUID playerId = event.getWhoClicked().getUniqueId();
        opener.openNewMenu(playerId, menuFactory);
    }
}
