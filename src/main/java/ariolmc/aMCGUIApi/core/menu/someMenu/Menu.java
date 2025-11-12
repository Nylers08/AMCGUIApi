package ariolmc.aMCGUIApi.core.menu.someMenu;

import ariolmc.aMCGUIApi.core.itemGUI.ItemGUI;
import ariolmc.aMCGUIApi.core.menu.namedInventory.NamedInventory;
import ariolmc.aMCGUIApi.core.menu.namedInventory.fabric.NamedInventoryFabric;
import lombok.Getter;
import net.kyori.adventure.text.Component;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.jetbrains.annotations.NotNull;

public class Menu implements InventoryHolder {

    @Getter protected NamedInventory namedInventory;

    public Menu(NamedInventoryFabric fabric){
        this.namedInventory = fabric.create(this);
    }

    public Component getName(){
        return namedInventory.getTitle();
    }

    public void rename(Component title){
        namedInventory.rename(title);
    }

    public void setItemGUI(int slot, ItemGUI itemGUI){
        namedInventory.setItem(slot, itemGUI.getItemStack());
    }

    @Override
    public @NotNull Inventory getInventory() {
        return namedInventory.getInventory();
    }
}
