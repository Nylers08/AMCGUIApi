package ariolmc.aMCGUIApi.core.menu.animatedMenu.animationFrame.factory;

import ariolmc.aMCGUIApi.core.menu.animatedMenu.animationFrame.core.AnimatedFrame;
import ariolmc.aMCGUIApi.core.menu.animatedMenu.animationFrame.core.AnimationFrame;
import ariolmc.aMCGUIApi.core.menu.animatedMenu.animationFrame.core.StaticFrame;
import ariolmc.aMCGUIApi.core.menu.someMenu.factory.AnimationFrame1;
import ariolmc.aMCGUIApi.core.menu.someMenu.factory.AnimationFrame2;
import ariolmc.aMCGUIApi.core.menu.someMenu.factory.AnimationFrame21;
import ariolmc.aMCGUIApi.core.menu.someMenu.factory.AnimationFrame22;
import org.bukkit.Sound;

import java.util.List;

public class TestAnimationFrameFactory2 implements AnimationFrameFactory{

    @Override
    public AnimationFrame create() {
        StaticFrame staticFrame1 = new StaticFrame(new AnimationFrame21().create(), 10, Sound.BLOCK_CHAIN_HIT);
        StaticFrame staticFrame2 = new StaticFrame(new AnimationFrame22().create(), 10, Sound.BLOCK_BONE_BLOCK_BREAK);

        AnimatedFrame animatedFrame = new AnimatedFrame(List.of(staticFrame1, staticFrame2));

        return animatedFrame;
    }
}
