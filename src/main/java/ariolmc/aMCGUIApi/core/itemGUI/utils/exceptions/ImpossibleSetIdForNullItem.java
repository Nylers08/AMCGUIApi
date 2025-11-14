package ariolmc.aMCGUIApi.core.itemGUI.utils.exceptions;

public class ImpossibleSetIdForNullItem extends RuntimeException {
    public ImpossibleSetIdForNullItem()
    {
        super("Невозможно установить id ItemGUI в NBT для NULL");
    }
}
