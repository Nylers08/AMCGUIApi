package ariolmc.aMCGUIApi.api.itemGUI.itemGUIFactory;

import ariolmc.aMCGUIApi.api.itemGUI.ItemGUI;
import ariolmc.aMCGUIApi.api.itemGUI.ItemGUIAction;
import ariolmc.aMCGUIApi.api.itemGUI.utils.ItemIdUtils;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractItemGUIFactory implements ItemGUIFactory {

    protected final ItemStack item;
    protected final List<ItemGUIAction> actions;
    protected String id;

    public AbstractItemGUIFactory(ItemStack item, List<ItemGUIAction> actions){
        this.item = item;
        this.actions = actions;
    }


    @Override
    public ItemGUI create() {
        generateId();
        return new ItemGUI(id, new ItemStack(item), new ArrayList<>(actions));
    }


    protected void generateId(){
        id = ItemIdUtils.generateId();
        ItemIdUtils.setIdToNBT(item, id);
    }
}
