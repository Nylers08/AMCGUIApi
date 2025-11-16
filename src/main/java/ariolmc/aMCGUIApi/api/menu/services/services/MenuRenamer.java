package ariolmc.aMCGUIApi.api.menu.services.services;

import ariolmc.aMCGUIApi.api.menu.menu.Menu;
import net.kyori.adventure.text.Component;

public class MenuRenamer {

    private MenuOpener menuOpener;

    public MenuRenamer(MenuOpener menuOpener){
        this.menuOpener = menuOpener;
    }

    public void rename(Menu menu, Component title){
        menu.rename(title);
        menuOpener.reopen(menu);
    }
}
