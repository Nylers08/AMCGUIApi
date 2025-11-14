package ariolmc.aMCGUIApi.core.menu.someMenu.fabric;

import ariolmc.aMCGUIApi.core.menu.namedInventory.NamedInventory;
import ariolmc.aMCGUIApi.core.menu.namedInventory.fabric.NamedInventoryFabric;
import ariolmc.aMCGUIApi.core.menu.someMenu.Menu;
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
    public void setItem(int slot, ItemStack item){
        namedInventory.setItem(slot, item);
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
