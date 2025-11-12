package ariolmc.aMCGUIApi.core.menu.services;

import ariolmc.aMCGUIApi.core.menu.someMenu.Menu;

import java.util.*;

public class MenuRegistry {

    private final Map<UUID, Menu> playerMenus = new HashMap<>();
    private final Map<Menu, Set<UUID>> menuViewers = new HashMap<>();

    public void register(UUID playerId, Menu menu){
        playerMenus.put(playerId, menu);
        menuViewers.computeIfAbsent(menu, v -> new HashSet<>()).add(playerId);
    }

    public void unregister(UUID playerId){
        Menu menu = playerMenus.get(playerId);
        playerMenus.remove(playerId);
        menuViewers.get(menu).remove(playerId);
    }

    public Menu getMenu(UUID playerId){
        return playerMenus.get(playerId);
    }

    public Set<UUID> getViewers(Menu menu){
        return menuViewers.get(menu);
    }
}
