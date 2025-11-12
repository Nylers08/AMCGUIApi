package ariolmc.aMCGUIApi.core.menu.namedInventory.fabric;

import ariolmc.aMCGUIApi.core.menu.namedInventory.NamedInventory;
import ariolmc.aMCGUIApi.infrastructure.inventoryFabric.BukkitInventoryCreator;
import ariolmc.aMCGUIApi.infrastructure.inventoryFabric.InventoryCreator;
import net.kyori.adventure.text.Component;
import org.bukkit.inventory.InventoryHolder;

public abstract class AbstractNamedInvFabric implements NamedInventoryFabric{

    private final InventoryCreator creator;

    private int size;
    private Component title;

    public AbstractNamedInvFabric(InventoryCreator creator, int size, Component title){
        this.creator = creator;
        this.size = size;
        this.title = title;
    }

    @Override
    public NamedInventory create(InventoryHolder owner) {
        return new NamedInventory(creator, owner, size, title);
    }
}
