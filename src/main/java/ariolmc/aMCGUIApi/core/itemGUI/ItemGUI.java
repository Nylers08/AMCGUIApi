package ariolmc.aMCGUIApi.core.itemGUI;

import ariolmc.aMCGUIApi.core.itemGUI.ItemActions.Action;
import lombok.Getter;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

import java.util.List;

public class ItemGUI {

    @Getter private String id;
    @Getter private ItemStack itemStack;
    @Getter private List<Action> actions;

    public ItemGUI(String id, ItemStack itemStack, List<Action> actions){
        this.id = id;
        this.itemStack = itemStack;
        this.actions = actions;
    }

    public void execute(InventoryClickEvent event){
        actions.forEach(a -> a.action(event));
    }
}
