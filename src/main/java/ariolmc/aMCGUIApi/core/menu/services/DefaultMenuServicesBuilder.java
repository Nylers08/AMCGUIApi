package ariolmc.aMCGUIApi.core.menu.services;

import ariolmc.aMCGUIApi.core.itemGUI.services.ItemGUIRegistry;
import ariolmc.aMCGUIApi.core.menu.services.services.*;
import ariolmc.aMCGUIApi.infrastructure.inventoryCloser.BukkitInventoryCloser;
import ariolmc.aMCGUIApi.infrastructure.inventoryCloser.InventoryCloser;
import ariolmc.aMCGUIApi.infrastructure.inventoryOpener.BukkitInventoryOpener;
import ariolmc.aMCGUIApi.infrastructure.inventoryOpener.InventoryOpener;
import ariolmc.aMCGUIApi.infrastructure.playerProvider.BukkitPlayerProvider;
import ariolmc.aMCGUIApi.infrastructure.playerProvider.PlayerProvider;

public class DefaultMenuServicesBuilder {

    public static MenuServices build(ItemGUIRegistry itemGUIRegistry){

        MenuRegistry registry = new MenuRegistry();
        PlayerProvider playerProvider = new BukkitPlayerProvider();
        InventoryOpener invOpener = new BukkitInventoryOpener(playerProvider);
        InventoryCloser invCloser = new BukkitInventoryCloser(playerProvider);

        MenuOpener menuOpener = new MenuOpener(registry, invOpener);

        return new MenuServices(
                registry,
                menuOpener,
                new MenuCloser(registry, invCloser),
                new MenuRenamer(menuOpener),
                new MenuItemGUISetter(itemGUIRegistry)
                );
    }
}
