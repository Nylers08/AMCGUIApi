package ariolmc.aMCGUIApi.api.itemGUI.services;

import ariolmc.aMCGUIApi.api.itemGUI.ItemGUI;
import org.bukkit.event.inventory.InventoryClickEvent;

import java.util.HashMap;
import java.util.Map;

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

    public void executeItemGUI(String id, InventoryClickEvent event){
        if(!hasItemGUI(id)) {
            throw new NotFoundItemGUI(id);
        }

        getItemGUI(id).execute(event);
    }
}
