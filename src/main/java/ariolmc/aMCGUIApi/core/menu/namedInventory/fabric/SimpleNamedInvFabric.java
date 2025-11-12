package ariolmc.aMCGUIApi.core.menu.namedInventory.fabric;

import ariolmc.aMCGUIApi.core.menu.namedInventory.NamedInventory;
import ariolmc.aMCGUIApi.infrastructure.inventoryFabric.BukkitInventoryCreator;
import ariolmc.aMCGUIApi.infrastructure.inventoryFabric.InventoryCreator;
import net.kyori.adventure.text.Component;
import org.bukkit.inventory.InventoryHolder;

public class SimpleNamedInvFabric extends AbstractNamedInvFabric {

    public SimpleNamedInvFabric(int size, Component title){
        super(
                new BukkitInventoryCreator(),
                size, title
        );
    }
}
