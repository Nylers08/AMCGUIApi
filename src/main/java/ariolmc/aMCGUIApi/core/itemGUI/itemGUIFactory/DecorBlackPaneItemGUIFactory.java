package ariolmc.aMCGUIApi.core.itemGUI.itemGUIFactory;

import ariolmc.aMCGUIApi.core.itemGUI.ItemStackBuilder;
import net.kyori.adventure.text.Component;
import org.bukkit.Material;

public class DecorBlackPaneItemGUIFactory extends DecorItemGUIFactory {

    public DecorBlackPaneItemGUIFactory() {
        super(
                new ItemStackBuilder(Material.BLACK_STAINED_GLASS_PANE)
                        .name(Component.text(" "))
                        .build()
        );
    }
}
