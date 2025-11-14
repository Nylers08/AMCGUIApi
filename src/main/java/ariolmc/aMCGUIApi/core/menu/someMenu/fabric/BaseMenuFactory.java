package ariolmc.aMCGUIApi.core.menu.someMenu.fabric;

import ariolmc.aMCGUIApi.core.menu.namedInventory.fabric.GUINamedInvFabric;
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
        return new BaseMenu(new GUINamedInvFabric(size, title));
    }
}
