package ariolmc.aMCGUIApi.core.menu.inventoryFabric;

import net.kyori.adventure.text.Component;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public interface InventoryFabric {
    Inventory create();
}
