package ariolmc.aMCGUIApi.core.menu.animatedMenu;

import ariolmc.aMCGUIApi.AMCGUIApi;
import ariolmc.aMCGUIApi.core.menu.animatedMenu.animationFrame.factory.AnimatedFrameFactory1;

public class TestAnimatedMenuFactory implements AnimatedMenuFactory{
    @Override
    public AnimatedMenu create() {
        return new BaseAnimatedMenu(new AnimatedFrameFactory1(), AMCGUIApi.getInstance().getMenuServices().opener());
    }
}
