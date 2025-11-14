package ariolmc.aMCGUIApi.core.menu.someMenu;

import ariolmc.aMCGUIApi.core.menu.namedInventory.NamedInventory;
import net.kyori.adventure.text.Component;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;

public interface Menu extends InventoryHolder {

    Component getName();
    void rename(Component title);
    void setItem(int slot, ItemStack item);
    ItemStack getItem(int slot);
    NamedInventory getNamedInventory();
}
