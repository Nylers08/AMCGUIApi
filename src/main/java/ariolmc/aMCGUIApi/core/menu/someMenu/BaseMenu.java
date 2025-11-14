package ariolmc.aMCGUIApi.core.menu.someMenu;

import ariolmc.aMCGUIApi.core.menu.namedInventory.NamedInventory;
import ariolmc.aMCGUIApi.core.menu.namedInventory.factory.NamedInventoryFactory;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Delegate;
import org.bukkit.inventory.Inventory;
import org.jetbrains.annotations.NotNull;

@Getter
public class BaseMenu implements Menu {

    @Delegate protected NamedInventory namedInventory;
    @Setter private boolean allowItemMovement = false;

    public BaseMenu(NamedInventoryFactory factory){
        this.namedInventory = factory.create(this);
    }

    @Override
    public @NotNull Inventory getInventory() {
        return namedInventory.getInventory();
    }


}
