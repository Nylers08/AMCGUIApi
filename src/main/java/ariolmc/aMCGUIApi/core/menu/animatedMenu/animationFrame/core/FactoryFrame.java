package ariolmc.aMCGUIApi.core.menu.animatedMenu.animationFrame.core;

import ariolmc.aMCGUIApi.core.menu.someMenu.Menu;
import ariolmc.aMCGUIApi.core.menu.someMenu.factory.MenuFactory;
import org.bukkit.Sound;

public class FactoryFrame implements AnimationFrame{

    private StaticFrame frame;
    private final MenuFactory menuFactory;
    private final long duration;
    private final Sound sound;

    public FactoryFrame(MenuFactory menuFactory, long duration, Sound sound){
        this.menuFactory = menuFactory;
        this.duration = duration;
        this.sound = sound;
        generateNewFrame();
    }

    public FactoryFrame(MenuFactory menuFactory, long duration){
        this(menuFactory, duration, null);
    }


    @Override
    public void tick() {
        frame.tick();
        if(isAnimationFinished())
            generateNewFrame();
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

    private void generateNewFrame(){
        frame = new StaticFrame(menuFactory.create(), duration, sound);
    }
}
