package ariolmc.aMCGUIApi.core.menu.animatedMenu.animationFrame.factory;

import ariolmc.aMCGUIApi.core.menu.animatedMenu.animationFrame.core.AnimatedFrame;
import ariolmc.aMCGUIApi.core.menu.animatedMenu.animationFrame.core.AnimationFrame;

import java.util.List;

public class TestAnimationFrameFactory implements AnimationFrameFactory{

    @Override
    public AnimationFrame create() {
        AnimatedFrame animatedFrame = new AnimatedFrame(List.of(
                new TestAnimationFrameFactory1().create(),
                new TestAnimationFrameFactory2().create(),
                new  TestAnimationFrameFactory3().create()
                ));

        return animatedFrame;
    }
}
