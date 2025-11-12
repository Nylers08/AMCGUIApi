package ariolmc.aMCGUIApi.core.menu.namedInventory;

import ariolmc.aMCGUIApi.core.menu.utils.InventoryUtils;
import ariolmc.aMCGUIApi.infrastructure.inventoryFabric.InventoryCreator;
import lombok.Getter;
import lombok.Setter;
import net.kyori.adventure.text.Component;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;

public class NamedInventory {

    @Getter private Component title;
    @Getter @Setter private Inventory inventory;

    @Getter private final InventoryCreator creator;

    public NamedInventory(InventoryCreator creator, InventoryHolder holder, int size, Component title){
        this.title = title;
        this.inventory = creator.create(holder, size, title);
        this.creator = creator;
    }

    public void rename(Component title){
        this.title = title;
        InventoryUtils utils = new InventoryUtils(creator);
        inventory = utils.copyWithNewTitle(inventory, title);
    }


    public void setItem(int slot, ItemStack itemStack){
        inventory.setItem(slot, itemStack);
    }

    public ItemStack getItem(int slot){
        return inventory.getItem(slot);
    }

    public void setContents(ItemStack[] contents){
        inventory.setContents(contents);
    }

    public ItemStack[] getContents(){
        return inventory.getContents();
    }

}
