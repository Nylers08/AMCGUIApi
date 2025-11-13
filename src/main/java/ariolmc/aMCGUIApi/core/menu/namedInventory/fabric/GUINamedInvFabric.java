package ariolmc.aMCGUIApi.core.menu.namedInventory.fabric;

import ariolmc.aMCGUIApi.core.menu.namedInventory.GUINamedInventory;
import ariolmc.aMCGUIApi.core.menu.namedInventory.NamedInventory;
import ariolmc.aMCGUIApi.infrastructure.inventoryFabric.BukkitInventoryCreator;
import ariolmc.aMCGUIApi.infrastructure.inventoryFabric.InventoryCreator;
import net.kyori.adventure.text.Component;
import org.bukkit.inventory.InventoryHolder;

public class GUINamedInvFabric implements NamedInventoryFabric {

    private InventoryCreator creator;
    private int size;
    private Component title;

    public GUINamedInvFabric(InventoryCreator creator, int size, Component title){
        this.creator = creator;
        this.size = size;
        this.title = title;
    }

    public GUINamedInvFabric(int size, Component title){
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
