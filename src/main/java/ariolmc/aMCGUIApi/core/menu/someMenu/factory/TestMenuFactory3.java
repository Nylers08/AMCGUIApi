package ariolmc.aMCGUIApi.core.menu.someMenu.factory;

import ariolmc.aMCGUIApi.core.menu.someMenu.Menu;

public class TestMenuFactory3 implements MenuFactory{

    private int numCreated = 0;

    @Override
    public Menu create() {

        MenuFactory menuFactory;

        if(numCreated++%2 == 0){
            menuFactory = new TestMenuFactory1();
        } else {
            menuFactory = new TestMenuFactory2();
        }

        return menuFactory.create();
    }
}
