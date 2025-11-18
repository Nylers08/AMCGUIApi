package ariolmc.aMCGUIApi.api.menu.animatedMenu.animationFrame.core;

import ariolmc.aMCGUIApi.api.menu.menu.Menu;
import ariolmc.aMCGUIApi.api.menu.menu.factory.MenuFactory;
import org.bukkit.Sound;

/**
 * Кадр анимации, лежит довольно низко в рамках анимации меню.
 * Содержит в себе StaticFrame, который будет генерироваться заново, при окончании анимации
 */
public class FactoryFrame implements AnimationFrame{

    private StaticFrame frame;
    private final MenuFactory menuFactory;
    private final long duration;
    private final Sound sound;

    /**
     * @param menuFactory фабрика по создании меню
     * @param duration сколько в тиках, будет показываться
     * @param sound звук при показе кадра
     */
    public FactoryFrame(MenuFactory menuFactory, long duration, Sound sound){
        this.menuFactory = menuFactory;
        this.duration = duration;
        this.sound = sound;
        generateNewFrame();
    }

    /**
     * @param menuFactory фабрика по создании меню
     * @param duration сколько в тиках, будет показываться
     */
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
