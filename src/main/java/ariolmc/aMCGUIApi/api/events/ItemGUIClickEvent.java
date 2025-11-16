package ariolmc.aMCGUIApi.api.events;

import ariolmc.aMCGUIApi.api.itemGUI.ItemGUI;
import lombok.Getter;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

public class ItemGUIClickEvent extends Event {

    private static final HandlerList HANDLERS = new HandlerList();

    @Getter private final ItemGUI itemGUI;

    public ItemGUIClickEvent(ItemGUI itemGUI) {
        this.itemGUI = itemGUI;
    }

    @Override
    public @NotNull HandlerList getHandlers() {
        return HANDLERS;
    }

    public static HandlerList getHandlerList(){
        return HANDLERS;
    }
}
