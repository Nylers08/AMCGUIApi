package ariolmc.aMCGUIApi.api.menu.services.services;

import ariolmc.aMCGUIApi.api.menu.menu.Menu;
import net.kyori.adventure.text.Component;

/**
 * Сервис по корректному переименовыванию меню. Переименовывает и сразу переоткрывает меню
 */
public class MenuRenamer {

    private MenuOpener menuOpener;

    /**
     * @param menuOpener как именно будем открывать
     */
    public MenuRenamer(MenuOpener menuOpener){
        this.menuOpener = menuOpener;
    }

    public void rename(Menu menu, Component title){
        menu.rename(title);
        menuOpener.reopen(menu);
    }
}
