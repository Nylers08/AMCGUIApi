package ariolmc.aMCGUIApi.api.events;

import ariolmc.aMCGUIApi.api.itemGUI.ItemGUI;
import lombok.Getter;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.jetbrains.annotations.NotNull;

public class ItemGUIClickEvent extends Event {

    private static final HandlerList HANDLERS = new HandlerList();

    @Getter private final InventoryClickEvent inventoryClickEvent;
    @Getter private final ItemGUI itemGUI;

    public ItemGUIClickEvent(InventoryClickEvent inventoryClickEvent, ItemGUI itemGUI) {
        this.itemGUI = itemGUI;
        this.inventoryClickEvent = inventoryClickEvent;
    }

    @Override
    public @NotNull HandlerList getHandlers() {
        return HANDLERS;
    }

    public static HandlerList getHandlerList(){
        return HANDLERS;
    }
}
