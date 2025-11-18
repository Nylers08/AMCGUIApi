package ariolmc.aMCGUIApi.api.itemGUI;

import net.kyori.adventure.text.Component;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;

/**
 * Часто используется для создания нового ItemStack, для ItemGUI
 * <p>
 *      Использование выглядит примерно так:
 * <p>
 *      new ItemStack(Material.APPLE, 16)
 *                   .name(name)
 *                   .lore(lore)
 *                   .build();
 */
public class ItemStackBuilder {

    private final ItemStack itemStack;
    private final ItemMeta meta;

    public ItemStackBuilder(Material material, int amount){
        itemStack = new ItemStack(material, amount);
        meta = itemStack.getItemMeta();
    }

    public ItemStackBuilder(Material material){
        this(material, 1);
    }


    public ItemStack build(){
        itemStack.setItemMeta(meta);
        return itemStack;
    }


    public ItemStackBuilder name(Component name){
        meta.displayName(name);
        return this;
    }

    public ItemStackBuilder lore(List<? extends Component> lore){
        meta.lore(lore);
        return this;
    }
}
