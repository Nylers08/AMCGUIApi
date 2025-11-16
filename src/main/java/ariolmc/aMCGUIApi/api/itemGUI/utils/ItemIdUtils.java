package ariolmc.aMCGUIApi.api.itemGUI.utils;

import ariolmc.aMCGUIApi.AMCGUIApi;
import ariolmc.aMCGUIApi.api.itemGUI.utils.exceptions.ImpossibleGetIdFromNullItem;
import ariolmc.aMCGUIApi.api.itemGUI.utils.exceptions.ImpossibleSetIdForNullItem;
import ariolmc.aMCGUIApi.api.itemGUI.utils.exceptions.ImpossibleVerifyIdForNullItem;
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
        throwIfItemStackIsNull(item, new ImpossibleSetIdForNullItem());

        ItemMeta meta = item.getItemMeta();
        meta.getPersistentDataContainer()
                .set(ID_KEY, PersistentDataType.STRING, id);
        item.setItemMeta(meta);
    }

    public static String getIdFromNBT(ItemStack item){
        throwIfItemStackIsNull(item, new ImpossibleGetIdFromNullItem());

        ItemMeta meta = item.getItemMeta();
        return meta.getPersistentDataContainer()
                .get(ID_KEY, PersistentDataType.STRING);
    }

    public static boolean hasIdInNBT(ItemStack item){
        throwIfItemStackIsNull(item, new ImpossibleVerifyIdForNullItem());

        ItemMeta meta = item.getItemMeta();
        if(meta == null)
            return false;

        return meta.getPersistentDataContainer()
                .has(ID_KEY, PersistentDataType.STRING);
    }


    public static void generateIdInNBT(ItemStack item){
        setIdToNBT(item, generateId());
    }

    public static String generateId(){
        return UUID.randomUUID().toString();
    }


    private static void throwIfItemStackIsNull(ItemStack itemStack, RuntimeException e){
        if(itemStack==null) throw e;
    }


}
