package ariolmc.aMCGUIApi.api.menu.menu;

import ariolmc.aMCGUIApi.api.itemGUI.services.ItemGUIRegistry;
import ariolmc.aMCGUIApi.api.namedInventory.NamedInventory;
import net.kyori.adventure.text.Component;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;

/**
 * Меню, используется для отображения GUI для игрока
 * Для отображения использует NamedInventory (Обычный Inventory, с возможностью переименовывания)
 * Также может использоваться как Inventory Holder для Inventory
 */
public interface Menu extends InventoryHolder {

    Component getTitle();
    void rename(Component title);
    void setItem(int slot, ItemStack item);
    ItemStack getItem(int slot);
    NamedInventory getNamedInventory();

    ItemGUIRegistry getItemGUIRegistry();

    /**
     * Может ли игрок двигать предметы в Menu
     */
    boolean isAllowItemMovement();
    void setAllowItemMovement(boolean value);
}
