package ariolmc.aMCGUIApi.core.itemGUI.utils.exceptions;

public class ImpossibleVerifyIdForNullItem extends RuntimeException {
    public ImpossibleVerifyIdForNullItem() {
        super("Невозможно проверить наличие id ItemGUI из NBT для NULL");
    }
}
