package ariolmc.aMCGUIApi.core.namedInventory.factory;

import ariolmc.aMCGUIApi.core.namedInventory.GUINamedInventory;
import ariolmc.aMCGUIApi.core.namedInventory.NamedInventory;
import ariolmc.aMCGUIApi.infrastructure.inventoryFactory.BukkitInventoryCreator;
import ariolmc.aMCGUIApi.infrastructure.inventoryFactory.InventoryCreator;
import net.kyori.adventure.text.Component;
import org.bukkit.inventory.InventoryHolder;

public class GUINamedInvFactory implements NamedInventoryFactory {

    private InventoryCreator creator;
    private int size;
    private Component title;

    public GUINamedInvFactory(InventoryCreator creator, int size, Component title){
        this.creator = creator;
        this.size = size;
        this.title = title;
    }

    public GUINamedInvFactory(int size, Component title){
        this(
                new BukkitInventoryCreator(),
                size, title
        );
    }

    @Override
    public NamedInventory create(InventoryHolder owner) {
        return new GUINamedInventory(creator, owner, size, title);
    }
}
