package ariolmc.aMCGUIApi.api.readyMadeSolutions.itemGui.factories;

import ariolmc.aMCGUIApi.api.itemGUI.ItemGUIAction;
import ariolmc.aMCGUIApi.api.itemGUI.itemGUIFactory.AbstractItemGUIFactory;
import ariolmc.aMCGUIApi.api.readyMadeSolutions.itemGui.actions.CancelInventoryClick;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;

public class DecorItemGUIFactory extends AbstractItemGUIFactory {

    public DecorItemGUIFactory(ItemStack item){
        super(
                item,
                buildActions()
        );
    }

    public DecorItemGUIFactory(ItemStack item, List<ItemGUIAction> actions){
        super(
                item,
                buildActions(actions)
        );
    }

    private static List<ItemGUIAction> buildActions(){
        return List.of(new CancelInventoryClick());
    }

    private static List<ItemGUIAction> buildActions(List<ItemGUIAction> otherActions){
        List<ItemGUIAction> actions = new ArrayList<>(buildActions());
        actions.addAll(otherActions);
        return actions;
    }

}
