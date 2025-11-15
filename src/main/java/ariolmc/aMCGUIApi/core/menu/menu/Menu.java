package ariolmc.aMCGUIApi.core.menu.menu;

import ariolmc.aMCGUIApi.core.namedInventory.NamedInventory;
import net.kyori.adventure.text.Component;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;

public interface Menu extends InventoryHolder {

    Component getTitle();
    void rename(Component title);
    void setItem(int slot, ItemStack item);
    ItemStack getItem(int slot);
    NamedInventory getNamedInventory();

    boolean isAllowItemMovement();
    void setAllowItemMovement(boolean value);
}
