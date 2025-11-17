package ariolmc.aMCGUIApi.api.readyMadeSolutions.itemGui.factories;

import ariolmc.aMCGUIApi.api.itemGUI.ItemStackBuilder;
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
