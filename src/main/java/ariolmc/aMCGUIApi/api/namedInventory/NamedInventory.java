package ariolmc.aMCGUIApi.api.namedInventory;

import net.kyori.adventure.text.Component;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public interface NamedInventory {
    Component getTitle();
    Inventory getInventory();
    void rename(Component title);
    void setItem(int slot, ItemStack item);
    ItemStack getItem(int slot);
    void setContents(ItemStack[] contents);
    void copyContentsWithSize(ItemStack[] contents);
    void changeSize(int size);
    void createNewInvWithNewSize(int size);
    ItemStack[] getContents();
    int getSize();
}
