package ariolmc.aMCGUIApi.core.itemGUI.itemGUIFabric;

import ariolmc.aMCGUIApi.core.itemGUI.ItemActions.Action;
import ariolmc.aMCGUIApi.core.itemGUI.ItemActions.CancelInventoryClick;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;

public class DecorItemFabric extends AbstractItemFabric{

    public DecorItemFabric(ItemStack item){
        super(item);
    }

    public DecorItemFabric(Material material, int amount){
        super(
                new ItemStack(material, amount)
        );
    }

    public DecorItemFabric(Material material){
        super(
                new ItemStack(material)
        );
    }


    @Override
    protected List<Action> buildActions(){
        List<Action> actions = new ArrayList<>();

        actions.add(new CancelInventoryClick());

        return actions;
    }

}
