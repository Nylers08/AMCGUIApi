package ariolmc.aMCGUIApi.api.itemGUI.services;

public class NotFoundItemGUI extends RuntimeException {

    public NotFoundItemGUI() {
        super();
    }

    public NotFoundItemGUI(String id) {
        super("ItemGUI с id: " + id + " не найден!");
    }
}
