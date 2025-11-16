package ariolmc.aMCGUIApi.api.menu.services;

import ariolmc.aMCGUIApi.api.menu.services.services.*;
import lombok.experimental.Delegate;

public record MenuServices(
        @Delegate MenuRegistry registry,
        @Delegate MenuOpener opener,
        @Delegate MenuCloser closer,
        @Delegate MenuRenamer renamer,
        @Delegate MenuItemGUISetter itemGUISetter) {

}
