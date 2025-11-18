package ariolmc.aMCGUIApi.api.menu.animatedMenu.animationFrame.core;

import ariolmc.aMCGUIApi.api.menu.menu.Menu;
import lombok.Getter;
import org.bukkit.Sound;
import org.bukkit.entity.Player;

/**
 * Статичный кадр. Довольно низкий уровень в рамках анимации.
 * Содержит в себе Menu, то сколько тиков будет показываться, и какой звук проиграет, при появлении.
 * Будет возвращаться, то меню, которое в него положили изначально
 * <p>Если у вас есть готовое меню, у которого всегда, одинаковое содержимое, то используйте StaticFrame.
 * Если содержимое должно быть разным при появлении, то лучше использовать FactoryFrame
 */
public class StaticFrame implements AnimationFrame {

    private final Menu frame;
    @Getter private final long duration;
    @Getter private long passedTick;
    boolean isAnimationFinished;
    @Getter private final Sound sound;

    /**
     *
     * @param frame Сам кадр, что отобразится в AnimatedMenu
     * @param duration Сколько тиков будет показываться
     * @param sound Какой звук проиграет при появлении
     */
    public StaticFrame(Menu frame, long duration, Sound sound){
        this.frame = frame;
        this.duration = duration;
        passedTick = 0;
        this.sound = sound;
    }

    /**
     * @param frame Сам кадр, что отобразится в AnimatedMenu
     * @param duration Сколько тиков будет показываться
     */
    public StaticFrame(Menu frame, long duration){
        this(frame, duration, null);
    }

    @Override
    public void tick() {
        if(isAnimationFinished)
            return;

        playSoundForViewers();
        tickTime();
    }

    @Override
    public boolean isAnimationFinished() {
        return isAnimationFinished;
    }

    @Override
    public Menu getCurrentMenu() {
        return frame;
    }

    @Override
    public void reset() {
        passedTick = 0;
        isAnimationFinished = false;
    }


    private void playSoundForViewers(){
        if(!(sound != null && passedTick == 0))
            return;

        frame.getInventory().getViewers().forEach(h->{
            if(h instanceof Player p){
                p.playSound(p.getLocation(), sound, 1 ,1);
            }
        });
    }

    private void tickTime(){
        passedTick++;

        if((duration>=0) && (passedTick > duration)) {
            isAnimationFinished = true;
        }
    }
}
