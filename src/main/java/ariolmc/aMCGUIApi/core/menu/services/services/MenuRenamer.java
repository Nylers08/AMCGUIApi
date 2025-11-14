package ariolmc.aMCGUIApi.core.menu.services.services;

import ariolmc.aMCGUIApi.core.menu.someMenu.Menu;
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
