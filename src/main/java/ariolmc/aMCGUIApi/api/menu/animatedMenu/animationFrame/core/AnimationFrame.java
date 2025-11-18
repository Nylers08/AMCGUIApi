package ariolmc.aMCGUIApi.api.menu.animatedMenu.animationFrame.core;

import ariolmc.aMCGUIApi.api.menu.menu.Menu;

/**
 * Кадр для анимации
 */
public interface AnimationFrame {

    void tick();
    boolean isAnimationFinished();
    Menu getCurrentMenu();
    void reset();
}
