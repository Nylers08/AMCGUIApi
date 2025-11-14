package ariolmc.aMCGUIApi.core.menu.someMenu.factory;

import ariolmc.aMCGUIApi.core.menu.namedInventory.factory.GUINamedInvFactory;
import ariolmc.aMCGUIApi.core.menu.someMenu.Menu;
import net.kyori.adventure.text.Component;

public class BaseMenuFactory implements MenuFactory{

    private int size;
    private Component title;

    public BaseMenuFactory(int size, Component title){
        this.size = size;
        this.title = title;
    }

    @Override
    public Menu create() {
        return new BaseMenu(new GUINamedInvFactory(size, title));
    }
}
