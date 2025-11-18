package ariolmc.aMCGUIApi.api.itemGUI.services;

import ariolmc.aMCGUIApi.api.events.ItemGUIClickEvent;
import ariolmc.aMCGUIApi.api.itemGUI.ItemGUI;
import org.bukkit.event.inventory.InventoryClickEvent;

import java.util.HashMap;
import java.util.Map;

/**
 * Класс, который регистрирует в себе ItemGUI.
 * Сюда как правило обращаются слушатели, чтобы убедиться, что нажатый предмет является ItemGUI,
 * Если это так, то они прямо из этого класса, сразу могут попросить ItemGUI выполнить заложенные в него действия
 */
public class ItemGUIRegistry {

    private final Map<String, ItemGUI> itemGUIMap = new HashMap<>();

    public void register(ItemGUI itemGUI){
        itemGUIMap.put(itemGUI.getId(), itemGUI);
    }

    public boolean hasItemGUI(String id){
        return itemGUIMap.containsKey(id);
    }

    public ItemGUI getItemGUI(String id){
        return itemGUIMap.get(id);
    }

    public void executeItemGUI(String id, ItemGUIClickEvent event){
        if(!hasItemGUI(id)) {
            throw new NotFoundItemGUI(id);
        }

        getItemGUI(id).execute(event);
    }
}
