package ariolmc.aMCGUIApi.core.menu.animatedMenu.animationFrame;

import ariolmc.aMCGUIApi.AMCGUIApi;
import ariolmc.aMCGUIApi.core.menu.animatedMenu.BaseAnimatedMenu;
import ariolmc.aMCGUIApi.core.menu.animatedMenu.animationFrame.factory.TestFactoryFrameFactory;

public class TestAnimatedMenu1 extends BaseAnimatedMenu {

    public TestAnimatedMenu1() {
        super(
                new TestFactoryFrameFactory(),
                AMCGUIApi.getInstance().getMenuServices().opener()
                );
    }
}
