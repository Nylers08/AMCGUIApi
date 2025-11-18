package ariolmc.aMCGUIApi.api.menu.utils;

import ariolmc.aMCGUIApi.infrastructure.inventoryFactory.InventoryCreator;
import lombok.Getter;
import net.kyori.adventure.text.Component;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

/**
 * Утилита для работы с Inventory
 * Как правило, создаёт новый инвентарь, из 1 и более инвентарей и парочку параметров
 */
public class InventoryUtils {

    @Getter private final InventoryCreator creator;

    /**
     *
     * @param creator То как именно будет создаваться меню
     */
    public InventoryUtils(InventoryCreator creator){
        this.creator = creator;
    }

    /**
     * В Майнкрафте нельзя, само по себе переименовать меню.
     * Поэтому приходится создавать новое, но с другим названием
     *
     * @param inv инвентарь, который хотим переименовать
     * @param title новое имя для инвентаря
     * @return новый инвентарь, точно такой же как inv, но с другим названием
     */
    public Inventory copyWithNewTitle(Inventory inv, Component title){
        Inventory newInv = creator.create(inv.getHolder(), inv.getSize(), title);
        newInv.setContents(inv.getContents());
        return newInv;
    }

    /**
     * Достаёт ItemStack из source и вставляет в target,
     * При этом весь Air из source игнорируется
     * Т.е вставляет предметы, которые на самом деле лежат в source
     *
     * @param source откуда достаём контент
     * @param target куда вставляем контент
     * @param title какое имя будет на выходе
     */
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
