package ariolmc.aMCGUIApi.api.readyMadeSolutions.menus.animatedMenu.animatedFrames;

import ariolmc.aMCGUIApi.api.menu.animatedMenu.animationFrame.core.AnimatedFrame;
import ariolmc.aMCGUIApi.api.menu.animatedMenu.animationFrame.core.AnimationFrame;
import ariolmc.aMCGUIApi.api.menu.animatedMenu.animationFrame.core.StaticFrame;
import ariolmc.aMCGUIApi.api.menu.animatedMenu.animationFrame.factory.AnimationFrameFactory;
import ariolmc.aMCGUIApi.api.readyMadeSolutions.menus.baseMenu.TestBaseMenuFactory1;
import ariolmc.aMCGUIApi.api.readyMadeSolutions.menus.baseMenu.TestBaseMenuFactory2;

import java.util.List;

public class TestAnimatedFrameFactory implements AnimationFrameFactory {
    @Override
    public AnimationFrame create() {
        StaticFrame staticFrame1 = new StaticFrame(new TestBaseMenuFactory1().create(), 10);
        StaticFrame staticFrame2 = new StaticFrame(new TestBaseMenuFactory2().create(), 10);
        return new AnimatedFrame(List.of(staticFrame1, staticFrame2), -1);
    }
}
