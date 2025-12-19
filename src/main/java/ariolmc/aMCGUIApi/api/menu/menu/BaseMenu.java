package ariolmc.aMCGUIApi.api.menu.menu;

import ariolmc.aMCGUIApi.api.itemGUI.services.ItemGUIRegistry;
import ariolmc.aMCGUIApi.api.namedInventory.NamedInventory;
import ariolmc.aMCGUIApi.api.namedInventory.factory.NamedInventoryFactory;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Delegate;
import org.bukkit.inventory.Inventory;
import org.jetbrains.annotations.NotNull;

/**
 * Базовая реализация Menu
 * Большинство методов делегируется из NamedInventory
 */
@Getter
public class BaseMenu implements Menu {

    @Delegate protected NamedInventory namedInventory;
    @Setter private boolean allowItemMovement = false;

    @Getter private final ItemGUIRegistry itemGUIRegistry =
            new ItemGUIRegistry();

    /**
     * @param factory попытался реализовать Dependency Inversion.
     *                Можете смело использовать GUINamedInvFactory
     */
    public BaseMenu(NamedInventoryFactory factory){
        this.namedInventory = factory.create(this);
    }

    /**
     * @return Inventory, который потом используется для отображения Menu
     */
    @Override
    public @NotNull Inventory getInventory() {
        return namedInventory.getInventory();
    }

}
