package ariolmc.aMCGUIApi.api.itemGUI.utils;

import net.kyori.adventure.text.Component;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;


public class ItemRenameUtil {

    public static void rename(ItemStack itemStack, Component name){
        ItemMeta meta = itemStack.getItemMeta();
        meta.displayName(name);
        itemStack.setItemMeta(meta);
    }
}
