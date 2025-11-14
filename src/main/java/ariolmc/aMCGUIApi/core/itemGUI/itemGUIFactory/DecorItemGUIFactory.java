package ariolmc.aMCGUIApi.core.itemGUI.itemGUIFactory;

import ariolmc.aMCGUIApi.core.itemGUI.ItemActions.Action;
import ariolmc.aMCGUIApi.core.itemGUI.ItemActions.CancelInventoryClick;
import org.bukkit.inventory.ItemStack;
import org.checkerframework.checker.units.qual.A;

import java.util.ArrayList;
import java.util.List;

public class DecorItemGUIFactory extends AbstractItemGUIFactory {

    public DecorItemGUIFactory(ItemStack item){
        super(
                item,
                buildActions()
        );
    }

    public DecorItemGUIFactory(ItemStack item, List<Action> actions){
        super(
                item,
                buildActions(actions)
        );
    }

    private static List<Action> buildActions(){
        return List.of(new CancelInventoryClick());
    }

    private static List<Action> buildActions(List<Action> otherActions){
        List<Action> actions = new ArrayList<>(buildActions());
        actions.addAll(otherActions);
        return actions;
    }

}
