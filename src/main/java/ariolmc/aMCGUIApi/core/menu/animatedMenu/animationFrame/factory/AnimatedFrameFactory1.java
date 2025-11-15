package ariolmc.aMCGUIApi.core.menu.animatedMenu.animationFrame.factory;

import ariolmc.aMCGUIApi.core.menu.animatedMenu.animationFrame.core.AnimatedFrame;
import ariolmc.aMCGUIApi.core.menu.animatedMenu.animationFrame.core.AnimationFrame;
import ariolmc.aMCGUIApi.core.menu.animatedMenu.animationFrame.core.StaticFrame;
import ariolmc.aMCGUIApi.core.menu.menu.factory.TestMenuFactory1;
import ariolmc.aMCGUIApi.core.menu.menu.factory.TestMenuFactory2;
import org.bukkit.Sound;

import java.util.List;

public class AnimatedFrameFactory1 implements AnimationFrameFactory{

    @Override
    public AnimationFrame create() {

        StaticFrame staticFrame1 = new StaticFrame(new TestMenuFactory1().create(), 10, Sound.BLOCK_IRON_BREAK);
        StaticFrame staticFrame2 = new StaticFrame(new TestMenuFactory2().create(), 10, Sound.BLOCK_ANVIL_DESTROY);

        return new AnimatedFrame(List.of(staticFrame1, staticFrame2), -1);
    }
}
