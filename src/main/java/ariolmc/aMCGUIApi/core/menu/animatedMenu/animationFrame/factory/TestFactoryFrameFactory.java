package ariolmc.aMCGUIApi.core.menu.animatedMenu.animationFrame.factory;

import ariolmc.aMCGUIApi.core.menu.animatedMenu.animationFrame.core.AnimationFrame;
import ariolmc.aMCGUIApi.core.menu.animatedMenu.animationFrame.core.FactoryFrame;
import ariolmc.aMCGUIApi.core.menu.animatedMenu.animationFrame.core.StaticFrame;
import ariolmc.aMCGUIApi.core.menu.someMenu.factory.TestMenuFactory3;

public class TestFactoryFrameFactory implements AnimationFrameFactory{
    @Override
    public AnimationFrame create() {

        return new StaticFrame(new TestMenuFactory3().create(), 20);
    }
}
