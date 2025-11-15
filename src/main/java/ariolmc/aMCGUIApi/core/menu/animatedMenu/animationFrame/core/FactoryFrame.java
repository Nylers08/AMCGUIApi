package ariolmc.aMCGUIApi.core.menu.animatedMenu.animationFrame.core;

import ariolmc.aMCGUIApi.core.menu.someMenu.Menu;
import ariolmc.aMCGUIApi.core.menu.someMenu.factory.MenuFactory;
import org.bukkit.Sound;

public class FactoryFrame implements AnimationFrame{

    private StaticFrame frame;
    private final MenuFactory menuFactory;

    public FactoryFrame(MenuFactory menuFactory, long duration, Sound sound){
        this.menuFactory = menuFactory;
        frame = new StaticFrame(
                menuFactory.create(),
                duration,
                sound
        );
    }

    public FactoryFrame(MenuFactory menuFactory, long duration){
        this.menuFactory = menuFactory;
        frame = new StaticFrame(
                menuFactory.create(),
                duration
        );
    }


    @Override
    public void tick() {

    }

    @Override
    public boolean isAnimationFinished() {
        return frame.isAnimationFinished;
    }

    @Override
    public Menu getCurrentMenu() {
        return frame.getCurrentMenu();
    }

    @Override
    public void reset() {
        frame.reset();
    }

    private void generateFrameIfFirstTick(){
        if(frame.getPassedTick() == 0){
            frame = new StaticFrame(menuFactory.create(), frame.getDuration(), frame.getSound());
        }
    }
}
