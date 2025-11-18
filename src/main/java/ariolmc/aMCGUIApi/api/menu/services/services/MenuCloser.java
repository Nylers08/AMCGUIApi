package ariolmc.aMCGUIApi.api.menu.services.services;

import ariolmc.aMCGUIApi.api.menu.menu.Menu;
import ariolmc.aMCGUIApi.api.menu.services.services.menuRegistry.menuRegistry.MenuRegistry;
import ariolmc.aMCGUIApi.infrastructure.inventoryCloser.InventoryCloser;
import org.bukkit.plugin.Plugin;

import java.util.Set;
import java.util.UUID;

/**
 * Сервис по правильному закрыванию меню. Закрывает и сразу исключает из MenuRegistry
 */
public class MenuCloser {

    private final MenuRegistry registry;
    private final InventoryCloser closer;

    /**
     * @param registry из какого регистра исключать меню
     * @param closer как именно будет закрывать инвентарь
     */
    public MenuCloser(MenuRegistry registry, InventoryCloser closer){
        this.registry = registry;
        this.closer = closer;
    }

    /**
     * Закрыть меню у конкретного игрока
     */
    public void close(UUID playerId){
        registry.unregister(playerId);
        closer.closeInventory(playerId);
    }

    /**
     * Закрыть абсолютно все меню
     * Использовать в КРАЙНЕЙ необходимости
     */
    public void closeAbsoluteAllMenu(){
        Set<Menu> menus = Set.copyOf(registry.getAllOpenMenus());
        menus.forEach(this::closeEveryone);
    }

    /**
     * Закрыть все меню, конкретного плагина
     */
    public void closeMenus(Plugin plugin){
        Set<Menu> menus = Set.copyOf(registry.getMenus(plugin));
        menus.forEach(this::closeEveryone);
    }

    /**
     * Закрыть у всех какое-то меню
     */
    public void closeEveryone(Menu menu){
        Set<UUID> viewers = Set.copyOf(registry.getViewers(menu));
        viewers.forEach(this::close);
    }
}
