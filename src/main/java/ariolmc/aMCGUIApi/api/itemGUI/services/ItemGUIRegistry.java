package ariolmc.aMCGUIApi.api.itemGUI.services;

import ariolmc.aMCGUIApi.api.events.ItemGUIClickEvent;
import ariolmc.aMCGUIApi.api.itemGUI.ItemGUI;
import org.bukkit.Bukkit;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.plugin.Plugin;

import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

/**
 * Класс, который регистрирует в себе ItemGUI.
 * Сюда как правило обращаются слушатели, чтобы убедиться, что нажатый предмет является ItemGUI,
 * Если это так, то они прямо из этого класса, сразу могут попросить ItemGUI выполнить заложенные в него действия
 */
public class ItemGUIRegistry {

    private final Map<String, WeakReference<ItemGUI>> itemGUIMap = new HashMap<>();


    public ItemGUIRegistry(Plugin plugin){
        startCleanUpTimer(plugin, 3600); // 3600 - очищать от ненужного ItemGUI, раз в 3 минуты
    }


    public void register(ItemGUI itemGUI){
        itemGUIMap.put(itemGUI.getId(), new WeakReference<>(itemGUI));
    }

    public boolean hasItemGUI(String id){
        return itemGUIMap.containsKey(id);
    }

    public ItemGUI getItemGUI(String id){
        return itemGUIMap.get(id).get();
    }

    public void executeItemGUI(String id, ItemGUIClickEvent event){
        if(!hasItemGUI(id)) {
            throw new NotFoundItemGUI(id);
        }

        getItemGUI(id).execute(event);
    }


    private void startCleanUpTimer(Plugin plugin, long delay){
        Bukkit.getScheduler().runTaskTimer(plugin, this::cleanup, delay, delay);
    }

    public void cleanup() {
        itemGUIMap.entrySet().removeIf(e -> e.getValue().get() == null);
    }
}
