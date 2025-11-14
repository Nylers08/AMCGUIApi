package ariolmc.aMCGUIApi.core.itemGUI.itemGUIFactory;

import ariolmc.aMCGUIApi.core.itemGUI.ItemActions.Action;
import ariolmc.aMCGUIApi.core.itemGUI.ItemActions.CancelInventoryClick;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;

public class DecorItemGUIFactory extends AbstractItemGUIFactory {

    public DecorItemGUIFactory(ItemStack item){
        super(item);
    }

    public DecorItemGUIFactory(Material material, int amount){
        super(
                new ItemStack(material, amount)
        );
    }

    public DecorItemGUIFactory(Material material){
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
