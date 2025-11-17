package ariolmc.aMCGUIApi.api.itemGUI;

import ariolmc.aMCGUIApi.api.events.ItemGUIClickEvent;
import ariolmc.aMCGUIApi.api.itemGUI.utils.ItemRenameUtil;
import lombok.Getter;
import net.kyori.adventure.text.Component;
import org.bukkit.inventory.ItemStack;

import java.util.List;

public class ItemGUI {

    @Getter private String id;
    @Getter private ItemStack itemStack;
    @Getter private List<ItemGUIAction> actions;

    public ItemGUI(String id, ItemStack itemStack, List<ItemGUIAction> actions){
        this.id = id;
        this.itemStack = itemStack;
        this.actions = actions;
    }

    public void execute(ItemGUIClickEvent event){
        actions.forEach(a -> a.action(event));
    }

    public void addAction(ItemGUIAction action){
        actions.add(action);
    }


    public void rename(Component name){
        ItemRenameUtil.rename(itemStack, name);
    }
}
