package ariolmc.aMCGUIApi.core.menu.utils;

import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.inventory.Inventory;

public class InventoryUtils {

    public static Inventory copyWithNewTitle(Inventory inv, Component title){
        Inventory newInv = Bukkit.createInventory(null, inv.getSize(), title);
        newInv.setContents(inv.getContents());
        return newInv;
    }
}
