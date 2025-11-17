package ariolmc.aMCGUIApi.api.readyMadeSolutions.itemGui.actions;

import ariolmc.aMCGUIApi.api.events.ItemGUIClickEvent;
import ariolmc.aMCGUIApi.api.itemGUI.ItemGUIAction;
import ariolmc.aMCGUIApi.api.itemGUI.utils.ItemIdUtils;
import ariolmc.aMCGUIApi.api.itemGUI.utils.ItemRenameUtil;
import net.kyori.adventure.text.Component;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

public class RenameAction implements ItemGUIAction {

    private int amount = 1;

    @Override
    public void action(ItemGUIClickEvent event) {
        ItemStack item = event.getItemGUI().getItemStack();

        String name = "Нажали: " + amount++;
        Component compName = Component.text(name);

        ItemRenameUtil.rename(item,compName);
    }
}
