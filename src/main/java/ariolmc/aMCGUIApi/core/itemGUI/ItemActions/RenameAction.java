package ariolmc.aMCGUIApi.core.itemGUI.ItemActions;

import ariolmc.aMCGUIApi.core.itemGUI.utils.ItemIdUtils;
import ariolmc.aMCGUIApi.core.itemGUI.utils.ItemRenameUtil;
import net.kyori.adventure.text.Component;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

public class RenameAction implements Action{

    private int amount = 1;

    @Override
    public void action(InventoryClickEvent event) {
        ItemStack item = event.getCurrentItem();
        if(item == null) return;
        if(!ItemIdUtils.hasIdInNBT(item)) return;

        String name = "Нажали: " + amount++;
        Component compName = Component.text(name);

        ItemRenameUtil.rename(item,compName);
    }
}
