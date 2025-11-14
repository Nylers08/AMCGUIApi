package ariolmc.aMCGUIApi.core.menu.services;

import ariolmc.aMCGUIApi.core.menu.services.services.*;
import lombok.RequiredArgsConstructor;
import lombok.experimental.Delegate;

@RequiredArgsConstructor
public class MenuServices {

    @Delegate protected final MenuRegistry registry;
    @Delegate protected final MenuOpener opener;
    @Delegate protected final MenuCloser closer;
    @Delegate protected final MenuRenamer renamer;
    @Delegate protected final MenuItemGUISetter itemGUISetter;
}
