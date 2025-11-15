package ariolmc.aMCGUIApi.core.menu.animatedMenu;

import ariolmc.aMCGUIApi.AMCGUIApi;
import ariolmc.aMCGUIApi.core.menu.animatedMenu.animationFrame.factory.AnimatedFrameFactory1;

public class TestAnimatedMenu extends BaseAnimatedMenu {
    public TestAnimatedMenu() {
        super(new AnimatedFrameFactory1(), AMCGUIApi.getInstance().getMenuServices().opener());
    }
}
