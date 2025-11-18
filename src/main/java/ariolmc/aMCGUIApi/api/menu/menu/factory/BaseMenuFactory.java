package ariolmc.aMCGUIApi.api.menu.menu.factory;

import ariolmc.aMCGUIApi.api.namedInventory.factory.GUINamedInvFactory;
import ariolmc.aMCGUIApi.api.menu.menu.BaseMenu;
import ariolmc.aMCGUIApi.api.menu.menu.Menu;
import net.kyori.adventure.text.Component;

/**
 * Фабрика, для создания базового меню.
 * Сама по себе использует GUINamedInvFactory
 */
public class BaseMenuFactory implements MenuFactory{

    private int size;
    private Component title;

    /**
     *
     * @param size Размер меню, должен быть кратным 9, и не больше 54
     * @param title Название меню
     */
    public BaseMenuFactory(int size, Component title){
        this.size = size;
        this.title = title;
    }

    /**
     *
     * @return BaseMenu, с заданным размером и названием
     */
    @Override
    public Menu create() {
        return new BaseMenu(new GUINamedInvFactory(size, title));
    }
}
