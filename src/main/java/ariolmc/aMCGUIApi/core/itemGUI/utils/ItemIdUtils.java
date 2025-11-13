package ariolmc.aMCGUIApi.core.itemGUI.utils;

import ariolmc.aMCGUIApi.AMCGUIApi;
import lombok.Getter;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;

import java.util.UUID;

public class ItemIdUtils {

    @Getter private final static NamespacedKey ID_KEY =
            new NamespacedKey(AMCGUIApi.getInstance(), "id");

    public static void setIdToNBT(ItemStack item, String id){
        ItemMeta meta = item.getItemMeta();
        meta.getPersistentDataContainer()
                .set(ID_KEY, PersistentDataType.STRING, id);
        item.setItemMeta(meta);
    }

    public static String getIdFromNBT(ItemStack item){
        ItemMeta meta = item.getItemMeta();
        return meta.getPersistentDataContainer()
                .get(ID_KEY, PersistentDataType.STRING);
    }

    public static boolean hasIdInNBT(ItemStack item){
        ItemMeta meta = item.getItemMeta();
        return meta.getPersistentDataContainer()
                .has(ID_KEY, PersistentDataType.STRING);
    }

    public static void generateIdInNBT(ItemStack item){
        setIdToNBT(item, generateId());
    }

    public static String generateId(){
        return UUID.randomUUID().toString();
    }
}
