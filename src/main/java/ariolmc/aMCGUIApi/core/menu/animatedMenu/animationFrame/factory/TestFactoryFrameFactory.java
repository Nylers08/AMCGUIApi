package ariolmc.aMCGUIApi.core.menu.animatedMenu.animationFrame.factory;

import ariolmc.aMCGUIApi.core.menu.animatedMenu.animationFrame.core.AnimationFrame;
import ariolmc.aMCGUIApi.core.menu.animatedMenu.animationFrame.core.StaticFrame;

public class TestFactoryFrameFactory implements AnimationFrameFactory{
    @Override
    public AnimationFrame create() {

        return new StaticFrame(new TestMenuFactory3().create(), 20);
    }
}
