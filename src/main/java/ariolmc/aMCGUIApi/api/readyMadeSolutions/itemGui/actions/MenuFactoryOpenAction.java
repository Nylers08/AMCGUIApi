package ariolmc.aMCGUIApi.api.readyMadeSolutions.itemGui.actions;

import ariolmc.aMCGUIApi.api.events.ItemGUIClickEvent;
import ariolmc.aMCGUIApi.api.itemGUI.ItemGUIAction;
import ariolmc.aMCGUIApi.api.menu.services.services.MenuOpener;
import ariolmc.aMCGUIApi.api.menu.menu.factory.MenuFactory;
import org.bukkit.plugin.Plugin;

import java.util.UUID;

public class MenuFactoryOpenAction implements ItemGUIAction {

    private final Plugin owner;
    private final MenuFactory menuFactory;
    private final MenuOpener opener;

    public MenuFactoryOpenAction(Plugin owner, MenuFactory menuFactory, MenuOpener opener){
        this.owner = owner;
        this.menuFactory = menuFactory;
        this.opener = opener;
    }

    @Override
    public void action(ItemGUIClickEvent event) {
        UUID playerId = event.getInventoryClickEvent().getWhoClicked().getUniqueId();
        opener.openNewMenu(owner, playerId, menuFactory);
    }
}
