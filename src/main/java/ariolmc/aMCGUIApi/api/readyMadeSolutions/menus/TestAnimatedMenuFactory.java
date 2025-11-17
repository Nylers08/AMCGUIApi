package ariolmc.aMCGUIApi.api.readyMadeSolutions.menus;

import ariolmc.aMCGUIApi.AMCGUIApi;
import ariolmc.aMCGUIApi.api.menu.animatedMenu.AnimatedMenu;
import ariolmc.aMCGUIApi.api.menu.animatedMenu.AnimatedMenuFactory;
import ariolmc.aMCGUIApi.api.menu.animatedMenu.BaseAnimatedMenu;
import ariolmc.aMCGUIApi.api.readyMadeSolutions.menus.animatedMenu.animatedFrames.TestAnimatedFrameFactory;

public class TestAnimatedMenuFactory implements AnimatedMenuFactory {
    @Override
    public AnimatedMenu create() {
        return new BaseAnimatedMenu(new TestAnimatedFrameFactory(), AMCGUIApi.getInstance().getMenuServices().opener());
    }
}
