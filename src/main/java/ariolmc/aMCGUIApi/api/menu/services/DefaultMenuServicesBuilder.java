package ariolmc.aMCGUIApi.api.menu.services;

import ariolmc.aMCGUIApi.api.itemGUI.services.ItemGUIRegistry;
import ariolmc.aMCGUIApi.api.menu.services.services.*;
import ariolmc.aMCGUIApi.api.menu.services.services.menuRegistry.DefaultMenuRegistry;
import ariolmc.aMCGUIApi.api.menu.services.services.menuRegistry.menuRegistry.MenuRegistry;
import ariolmc.aMCGUIApi.api.menu.services.services.menuRegistry.menuRegistry.MenuRegistryImpl;
import ariolmc.aMCGUIApi.infrastructure.inventoryCloser.BukkitInventoryCloser;
import ariolmc.aMCGUIApi.infrastructure.inventoryCloser.InventoryCloser;
import ariolmc.aMCGUIApi.infrastructure.inventoryOpener.BukkitInventoryOpener;
import ariolmc.aMCGUIApi.infrastructure.inventoryOpener.InventoryOpener;
import ariolmc.aMCGUIApi.infrastructure.playerProvider.BukkitPlayerProvider;
import ariolmc.aMCGUIApi.infrastructure.playerProvider.PlayerProvider;

/**
 * Создатель обычного MenuServices.
 * Используйте, если вы хотите сами заботиться о меню, в своём плагине
 */
public class DefaultMenuServicesBuilder {

    public static MenuServices build(){

        MenuRegistry registry = new DefaultMenuRegistry();
        PlayerProvider playerProvider = new BukkitPlayerProvider();
        InventoryOpener invOpener = new BukkitInventoryOpener(playerProvider);
        InventoryCloser invCloser = new BukkitInventoryCloser(playerProvider);

        MenuOpener menuOpener = new MenuOpener(registry, invOpener);

        return new MenuServices(
                registry,
                menuOpener,
                new MenuCloser(registry, invCloser),
                new MenuRenamer(menuOpener),
                new MenuItemGUISetter()
                );
    }
}
