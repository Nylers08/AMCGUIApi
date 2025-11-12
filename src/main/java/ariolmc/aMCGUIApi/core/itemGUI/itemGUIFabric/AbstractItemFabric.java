package ariolmc.aMCGUIApi.core.itemGUI.itemGUIFabric;

import ariolmc.aMCGUIApi.core.itemGUI.ItemActions.Action;
import ariolmc.aMCGUIApi.core.itemGUI.ItemGUI;
import ariolmc.aMCGUIApi.core.itemGUI.utils.ItemIdUtils;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractItemFabric implements ItemGUIFabric {

    protected final ItemStack item;
    protected final List<Action> actions;
    protected String id;

    public AbstractItemFabric(ItemStack item){
        this.item = item;
        actions = buildActions();
    }


    @Override
    public ItemGUI create() {
        generateId();
        return new ItemGUI(id, new ItemStack(item), new ArrayList<>(actions));
    }


    protected abstract List<Action> buildActions();

    protected void generateId(){
        id = ItemIdUtils.generateId();
        ItemIdUtils.setIdToNBT(item, id);
    }
}
