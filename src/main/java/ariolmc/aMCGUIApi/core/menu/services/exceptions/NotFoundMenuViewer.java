package ariolmc.aMCGUIApi.core.menu.services.exceptions;

import java.util.UUID;

public class NotFoundMenuViewer extends RuntimeException {
    public NotFoundMenuViewer(UUID viewerId) {
        super("Не удалось найти, за каким меню наблюдает сущность с UUID: " + viewerId);
    }
}
