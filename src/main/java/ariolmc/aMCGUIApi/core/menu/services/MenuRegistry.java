package ariolmc.aMCGUIApi.core.menu.services;

import ariolmc.aMCGUIApi.core.menu.services.exceptions.NotFoundMenuViewer;
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
        Optional<Menu> menu = getMenu(playerId);
        menu.orElseThrow(()->new NotFoundMenuViewer(playerId));

        playerMenus.remove(playerId);
        removeViewerFromMenuViewers(playerId, menu.get());
    }

    private void removeViewerFromMenuViewers(UUID playerId, Menu menu){
        Set<UUID> viewers = getViewers(menu);
        viewers.remove(playerId);
        if(viewers.isEmpty()) menuViewers.remove(menu);
    }

    public Optional<Menu> getMenu(UUID playerId){
        return Optional.ofNullable(playerMenus.get(playerId));
    }

    public Set<UUID> getViewers(Menu menu){
        return menuViewers.get(menu);
    }

    public boolean hasViewer(UUID playerId){
        return playerMenus.containsKey(playerId);
    }
}
