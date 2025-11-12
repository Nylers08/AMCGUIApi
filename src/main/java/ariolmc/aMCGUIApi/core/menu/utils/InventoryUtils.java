package ariolmc.aMCGUIApi.core.menu.utils;

import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class InventoryUtils {

    public static Inventory copyWithNewTitle(Inventory inv, Component title){
        Inventory newInv = Bukkit.createInventory(null, inv.getSize(), title);
        newInv.setContents(inv.getContents());
        return newInv;
    }

    public static Inventory merge(Inventory source, Inventory target, Component title){
        Inventory newInv = copyWithNewTitle(target, title);

        ItemStack[] contents = source.getContents();
        setContentsWithoutAir(newInv, contents);

        return newInv;
    }

    private static void setContentsWithoutAir(Inventory inv, ItemStack[] contents){
        for (int i = 0; i < contents.length; i++) {
            if(i > inv.getSize()) return;

            ItemStack item = contents[i];
            if(item.getType().equals(Material.AIR)) continue;
            inv.setItem(i, item);
        }
    }
}
