package ariolmc.aMCGUIApi.core.menu.animatedMenu.animationFrame.core;

import ariolmc.aMCGUIApi.core.menu.someMenu.Menu;
import org.bukkit.Sound;
import org.bukkit.entity.Player;

public class StaticFrame implements AnimationFrame {

    private final Menu frame;
    private final long duration;
    private long passed;
    boolean isAnimationFinished;
    private final Sound sound;

    public StaticFrame(Menu frame, long duration, Sound sound){
        this.frame = frame;
        this.duration = duration;
        passed = 0;
        this.sound = sound;
    }

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
        passed = 0;
        isAnimationFinished = false;
    }


    private void playSoundForViewers(){
        if(sound != null && passed == 1){
            frame.getInventory().getViewers().forEach(h->{
                if(h instanceof Player p){
                    p.playSound(p.getLocation(), sound, 1 ,1);
                }
            });
        }
    }

    private void tickTime(){
        passed++;

        if((duration>=0) && (passed > duration)) {
            isAnimationFinished = true;
        }
    }
}
