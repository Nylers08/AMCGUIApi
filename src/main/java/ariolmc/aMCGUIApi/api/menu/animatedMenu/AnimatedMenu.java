package ariolmc.aMCGUIApi.api.menu.animatedMenu;

import ariolmc.aMCGUIApi.api.menu.animatedMenu.animationFrame.core.AnimationFrame;
import ariolmc.aMCGUIApi.api.menu.menu.Menu;

/**
 * Анимированное меню.
 * Может представлять собой как обычное меню, и как "Frame", для другого анимированного меню
 */
public interface AnimatedMenu extends Menu, AnimationFrame {
}
