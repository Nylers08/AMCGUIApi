package ariolmc.aMCGUIApi.core.menu;

import ariolmc.aMCGUIApi.core.itemGUI.ItemGUI;
import ariolmc.aMCGUIApi.infrastructure.inventoryFabric.InventoryFabric;
import ariolmc.aMCGUIApi.core.menu.utils.InventoryUtils;
import lombok.Getter;
import net.kyori.adventure.text.Component;
import org.bukkit.inventory.Inventory;
;

public class Menu {

    @Getter private Inventory inventory;

    public Menu(InventoryFabric fabric){
        this.inventory = fabric.create();
    }

    public void rename(Component newTitle){
        inventory = InventoryUtils.copyWithNewTitle(inventory, newTitle);
    }

    public void setItemGUI(int slot, ItemGUI itemGUI){
        inventory.setItem(slot, itemGUI.getItemStack());
    }
}
