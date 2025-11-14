package ariolmc.aMCGUIApi.core.itemGUI.itemGUIFactory;

import ariolmc.aMCGUIApi.core.itemGUI.ItemActions.Action;
import ariolmc.aMCGUIApi.core.itemGUI.ItemActions.CancelInventoryClick;
import ariolmc.aMCGUIApi.core.itemGUI.utils.ItemRenameUtil;
import net.kyori.adventure.text.Component;
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

    public DecorItemGUIFactory(Component name, ItemStack item){
        super(
                new ItemStack(item)
        );
        ItemRenameUtil.rename(this.item, name);
    }

    public DecorItemGUIFactory(Component name, Material material){
        this(name, new ItemStack(material));
    }

    public DecorItemGUIFactory(Component name, Material material, int amount){
        this(name, new ItemStack(material, amount));
    }


    @Override
    protected List<Action> buildActions(){
        List<Action> actions = new ArrayList<>();

        actions.add(new CancelInventoryClick());

        return actions;
    }

}
