package ariolmc.aMCGUIApi.api.menu.services.services;

import ariolmc.aMCGUIApi.api.menu.menu.Menu;
import ariolmc.aMCGUIApi.api.menu.menu.factory.MenuFactory;
import ariolmc.aMCGUIApi.api.menu.services.services.menuRegistry.menuRegistry.MenuRegistry;
import ariolmc.aMCGUIApi.infrastructure.inventoryOpener.InventoryOpener;
import org.bukkit.plugin.Plugin;

import java.util.Set;
import java.util.UUID;

/**
 * Сервис по правильному открытию меню. Сразу открывает и регистрирует в MenuRegistry
 */
public class MenuOpener {

    private final MenuRegistry registry;
    private final InventoryOpener inventoryOpener;

    /**
     * @param registry куда будем регистрировать меню
     * @param opener как именно будем открывать
     */
    public MenuOpener(MenuRegistry registry, InventoryOpener opener){
        this.inventoryOpener = opener;
        this.registry = registry;
    }

    /**
     * Используется для открывания уже готово меню, содержимое которого всегда одинаковое,
     * или должно использоваться разными игроками.
     * К примеру: хранилище клана; общий эндер сундук; меню сервера, если оно у всех игроков должно выглядеть одинаково
     * @param owner какой плагин открывает
     * @param playerId для кого открываем
     * @param menu что открываем
     */
    public void open(Plugin owner, UUID playerId, Menu menu){
        inventoryOpener.open(playerId, menu.getInventory());
        registry.register(owner, playerId, menu);
    }

    /**
     * Используется, для открывания нового меню, содержимое которого всегда разное.
     * К примеру: аукцион; рулетка и .тд
     * @param owner какой плагин открывает
     * @param playerId для кого открываем
     * @param factory как создаём новое меню
     */
    public void openNewMenu(Plugin owner, UUID playerId, MenuFactory factory){
        open(owner, playerId, factory.create());
    }

    /**
     * Переоткрыть меню для всех игроков. К примеру, если оно было переименовано
     */
    public void reopen(Menu menu){
        Set<UUID> viewers = registry.getViewers(menu);
        if(viewers == null || viewers.isEmpty()) return;
        Set<UUID> copiedViewers = Set.copyOf(viewers);

        Plugin plugin = registry.getPlugin(menu);
        copiedViewers.forEach(v->open(plugin, v, menu));
    }
}
