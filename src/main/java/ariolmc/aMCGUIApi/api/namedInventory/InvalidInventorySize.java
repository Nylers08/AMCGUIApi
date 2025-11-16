package ariolmc.aMCGUIApi.api.namedInventory;

import net.kyori.adventure.text.Component;

public class InvalidInventorySize extends RuntimeException {
    public InvalidInventorySize(Component titleInventory, int size) {
        super("Недопустимый размер (" + size + ") для инвентаря: " + titleInventory + "\nРазмер должен быть кратным 9, быть не больше 54, и не меньше 9");
    }
}
