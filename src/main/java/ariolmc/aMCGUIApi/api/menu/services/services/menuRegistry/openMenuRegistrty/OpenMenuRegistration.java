package ariolmc.aMCGUIApi.api.menu.services.services.menuRegistry.openMenuRegistrty;

import ariolmc.aMCGUIApi.api.menu.menu.Menu;

import java.util.UUID;

public interface OpenMenuRegistration {
    void register(UUID viewerId, Menu menu);
    void unregister(UUID viewerId);
}
