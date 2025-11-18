package ariolmc.aMCGUIApi.api.itemGUI.itemGUIFactory;

import ariolmc.aMCGUIApi.api.itemGUI.ItemGUI;
import ariolmc.aMCGUIApi.api.itemGUI.ItemGUIAction;
import ariolmc.aMCGUIApi.api.itemGUI.utils.ItemIdUtils;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;

/**
 * Заготовка для фабрик.
 * Уже настроенная генерация id и создание нового ItemGUI.
 * В дочерних классах, требуется только передать параметры в super
 */
public abstract class AbstractItemGUIFactory implements ItemGUIFactory {

    protected final ItemStack item;
    protected final List<ItemGUIAction> actions;
    protected String id;

    public AbstractItemGUIFactory(ItemStack item, List<ItemGUIAction> actions){
        this.item = item;
        this.actions = actions;
    }

    /**
     * Генерирует id в ItemStack и создаёт новый ItemGUI
     * @return
     * Возвращает ItemGUI, с уже сгенерированным id, заложенными в ItemStack; а также с заданными действиями
     */
    @Override
    public ItemGUI create() {
        generateAndSetId();
        return new ItemGUI(id, new ItemStack(item), new ArrayList<>(actions));
    }

    /**
     * Генерация и установка id в ItemStack
     */
    protected void generateAndSetId(){
        id = ItemIdUtils.generateId();
        ItemIdUtils.setIdToNBT(item, id);
    }
}
