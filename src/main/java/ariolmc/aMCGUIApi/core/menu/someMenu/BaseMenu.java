package ariolmc.aMCGUIApi.core.menu.someMenu;

import ariolmc.aMCGUIApi.core.itemGUI.ItemGUI;
import ariolmc.aMCGUIApi.core.menu.namedInventory.NamedInventory;
import ariolmc.aMCGUIApi.core.menu.namedInventory.fabric.NamedInventoryFabric;
import lombok.Getter;
import net.kyori.adventure.text.Component;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

public class BaseMenu implements Menu {

    @Getter protected NamedInventory namedInventory;

    public BaseMenu(NamedInventoryFabric fabric){
        this.namedInventory = fabric.create(this);
    }

    @Override
    public Component getName(){
        return namedInventory.getTitle();
    }

    @Override
    public void rename(Component title){
        namedInventory.rename(title);
    }

    @Override
    public void setItemGUI(int slot, ItemGUI itemGUI){
        namedInventory.setItem(slot, itemGUI.getItemStack());
    }

    @Override
    public ItemStack getItem(int slot) {
        return namedInventory.getItem(slot);
    }

    @Override
    public @NotNull Inventory getInventory() {
        return namedInventory.getInventory();
    }

}
