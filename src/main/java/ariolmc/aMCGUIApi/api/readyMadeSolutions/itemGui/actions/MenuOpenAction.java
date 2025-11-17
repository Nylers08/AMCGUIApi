package ariolmc.aMCGUIApi.api.readyMadeSolutions.itemGui.actions;

import ariolmc.aMCGUIApi.api.events.ItemGUIClickEvent;
import ariolmc.aMCGUIApi.api.itemGUI.ItemGUIAction;
import ariolmc.aMCGUIApi.api.menu.services.services.MenuOpener;
import ariolmc.aMCGUIApi.api.menu.menu.Menu;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.plugin.Plugin;

import java.util.UUID;

public class MenuOpenAction implements ItemGUIAction {

    private final Plugin owner;
    private final Menu menu;
    private final MenuOpener opener;

    public MenuOpenAction(Plugin owner, Menu menu, MenuOpener opener){
        this.owner = owner;
        this.menu = menu;
        this.opener = opener;
    }

    @Override
    public void action(ItemGUIClickEvent event) {
        UUID playerId = event.getInventoryClickEvent().getWhoClicked().getUniqueId();
        opener.open(owner, playerId, menu);
    }
}
