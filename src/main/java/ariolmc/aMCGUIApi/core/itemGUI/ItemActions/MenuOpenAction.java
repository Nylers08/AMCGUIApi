package ariolmc.aMCGUIApi.core.itemGUI.ItemActions;

import ariolmc.aMCGUIApi.core.menu.services.services.MenuOpener;
import ariolmc.aMCGUIApi.core.menu.menu.Menu;
import org.bukkit.event.inventory.InventoryClickEvent;

import java.util.UUID;

public class MenuOpenAction implements Action{

    private final Menu menu;
    private final MenuOpener opener;

    public MenuOpenAction(Menu menu, MenuOpener opener){
        this.menu = menu;
        this.opener = opener;
    }

    @Override
    public void action(InventoryClickEvent event) {
        UUID playerId = event.getWhoClicked().getUniqueId();
        opener.open(playerId, menu);
    }
}
