package ariolmc.aMCGUIApi.core.menu.services;

import ariolmc.aMCGUIApi.core.menu.someMenu.Menu;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class MenuRegistry {

    private final Map<UUID, Menu> openMenus = new HashMap<>();

    public void register(UUID playerId, Menu menu){
        openMenus.put(playerId, menu);
    }

    public Menu getMenu(UUID playerId){
        return openMenus.get(playerId);
    }
}
