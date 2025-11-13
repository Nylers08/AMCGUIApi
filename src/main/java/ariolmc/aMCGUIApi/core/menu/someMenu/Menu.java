package ariolmc.aMCGUIApi.core.menu.someMenu;

import ariolmc.aMCGUIApi.core.itemGUI.ItemGUI;
import ariolmc.aMCGUIApi.core.itemGUI.itemGUIFabric.ItemGUIFabric;
import ariolmc.aMCGUIApi.core.menu.namedInventory.NamedInventory;
import net.kyori.adventure.text.Component;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;

public interface Menu extends InventoryHolder {

    Component getName();
    void rename(Component title);
    void setItemGUI(int slot, ItemGUIFabric fabric);
    ItemStack getItem(int slot);
    NamedInventory getNamedInventory();
}
