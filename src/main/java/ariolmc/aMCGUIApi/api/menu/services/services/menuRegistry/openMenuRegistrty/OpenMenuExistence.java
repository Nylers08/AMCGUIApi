package ariolmc.aMCGUIApi.api.menu.services.services.menuRegistry.openMenuRegistrty;

import ariolmc.aMCGUIApi.api.menu.services.services.menuRegistry.menuRegistry.RegistryMenuExistence;

import java.util.UUID;

public interface OpenMenuExistence extends RegistryMenuExistence {

    boolean existViewer(UUID viewerId);
}
