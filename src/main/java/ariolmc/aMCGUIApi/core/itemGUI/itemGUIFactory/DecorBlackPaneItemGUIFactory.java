package ariolmc.aMCGUIApi.core.itemGUI.itemGUIFactory;

import net.kyori.adventure.text.Component;
import org.bukkit.Material;

public class DecorBlackPaneItemGUIFactory extends DecorItemGUIFactory {

    public DecorBlackPaneItemGUIFactory() {
        super(
                Component.text(" "),
                Material.BLACK_STAINED_GLASS_PANE
        );
    }
}
