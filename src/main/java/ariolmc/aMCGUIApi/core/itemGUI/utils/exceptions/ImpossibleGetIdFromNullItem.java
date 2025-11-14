package ariolmc.aMCGUIApi.core.itemGUI.utils.exceptions;

public class ImpossibleGetIdFromNullItem extends RuntimeException{
    public ImpossibleGetIdFromNullItem(){
        super("Невозможно получить id ItemGUI из NBT из NULL");
    }
}
