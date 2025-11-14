package ariolmc.aMCGUIApi.core.menu.animatedMenu.animationFrame.core;

import ariolmc.aMCGUIApi.core.menu.someMenu.Menu;

public interface AnimationFrame {

    void tick();
    boolean isAnimationFinished();
    Menu getCurrentMenu();
    void reset();
}
