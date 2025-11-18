package ariolmc.aMCGUIApi.api.itemGUI;

import ariolmc.aMCGUIApi.api.events.ItemGUIClickEvent;
import ariolmc.aMCGUIApi.api.itemGUI.utils.ItemRenameUtil;
import lombok.Getter;
import net.kyori.adventure.text.Component;
import org.bukkit.inventory.ItemStack;

import java.util.List;

/**
 * ItemGUI, это своего рода кнопка в меню
 * <p>
 * Хранит в себе id, itemStack и список действий.
 * В самом инвентаре лежит как itemStack.
 * Id, как правило, записывается на фабрике, в itemStack, в NBT.
 * ItemGUI, как правило, хранятся в ItemGUIRegistry
 */
public class ItemGUI {

    @Getter private String id;
    @Getter private ItemStack itemStack;
    @Getter private List<ItemGUIAction> actions;

    public ItemGUI(String id, ItemStack itemStack, List<ItemGUIAction> actions){
        this.id = id;
        this.itemStack = itemStack;
        this.actions = actions;
    }

    /**
     * Поочерёдно вызывает все заложенные в него действия (ItemGUIAction)
     */
    public void execute(ItemGUIClickEvent event){
        actions.forEach(a -> a.action(event));
    }

    /**
     * Позволяет добавить новое действие
     */
    public void addAction(ItemGUIAction action){
        actions.add(action);
    }

    /**
     * Переименовывает хранящейся ItemStack
     */
    public void rename(Component name){
        ItemRenameUtil.rename(itemStack, name);
    }
}
