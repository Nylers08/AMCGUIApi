package ariolmc.aMCGUIApi.api.menu.services.services.menuRegistry.openMenuRegistrty;

import ariolmc.aMCGUIApi.api.menu.menu.Menu;

import java.util.Optional;
import java.util.Set;
import java.util.UUID;

public interface OpenMenuAccess {

    Optional<Menu> getMenu(UUID viewerId);
    Set<UUID> getViewers(Menu menu);
    Set<Menu> getAllOpenMenus();
}
