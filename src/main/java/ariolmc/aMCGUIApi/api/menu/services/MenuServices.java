package ariolmc.aMCGUIApi.api.menu.services;

import ariolmc.aMCGUIApi.api.menu.services.services.*;
import ariolmc.aMCGUIApi.api.menu.services.services.menuRegistry.menuRegistry.MenuRegistry;
import lombok.experimental.Delegate;

/**
 * Класс, который объеденяет все сервисы в себе
 */
public record MenuServices(
        @Delegate MenuRegistry registry,
        @Delegate MenuOpener opener,
        @Delegate MenuCloser closer,
        @Delegate MenuRenamer renamer,
        @Delegate MenuItemGUISetter itemGUISetter) {

}
