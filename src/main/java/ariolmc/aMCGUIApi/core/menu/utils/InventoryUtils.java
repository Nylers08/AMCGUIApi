package ariolmc.aMCGUIApi.core.menu.utils;

import ariolmc.aMCGUIApi.infrastructure.inventoryFabric.InventoryCreator;
import lombok.Getter;
import net.kyori.adventure.text.Component;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class InventoryUtils {

    @Getter private final InventoryCreator creator;

    public InventoryUtils(InventoryCreator creator){
        this.creator = creator;
    }

    public Inventory copyWithNewTitle(Inventory inv, Component title){
        Inventory newInv = creator.create(inv.getHolder(), inv.getSize(), title);
        newInv.setContents(inv.getContents());
        return newInv;
    }

    public Inventory merge(Inventory source, Inventory target, Component title){
        Inventory newInv = copyWithNewTitle(target, title);
        setContentsWithoutAir(newInv, source.getContents());
        return newInv;
    }

    private void setContentsWithoutAir(Inventory inv, ItemStack[] contents){
        int minSize = Math.min(inv.getSize(), contents.length);
        for (int i = 0; i < minSize; i++) {
            ItemStack item = contents[i];
            setItemIfExist(inv, i, item);
        }
    }

    private void setItemIfExist(Inventory inv, int slot, ItemStack item){
        if(isNullOrAir(item)) return;
        inv.setItem(slot, item);
    }

    private boolean isNullOrAir(ItemStack item){
        return item == null || item.getType().equals(Material.AIR);
    }
}
