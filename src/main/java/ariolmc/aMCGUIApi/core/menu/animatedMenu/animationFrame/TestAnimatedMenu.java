package ariolmc.aMCGUIApi.core.menu.animatedMenu.animationFrame;

import ariolmc.aMCGUIApi.AMCGUIApi;
import ariolmc.aMCGUIApi.core.menu.animatedMenu.BaseAnimatedMenu;
import ariolmc.aMCGUIApi.core.menu.animatedMenu.animationFrame.factory.AnimatedFrameFactory1;
import ariolmc.aMCGUIApi.core.menu.animatedMenu.animationFrame.factory.AnimationFrameFactory;
import ariolmc.aMCGUIApi.core.menu.services.services.MenuOpener;

public class TestAnimatedMenu extends BaseAnimatedMenu {
    public TestAnimatedMenu() {
        super(new AnimatedFrameFactory1(), AMCGUIApi.getInstance().getMenuServices().opener());
    }
}
