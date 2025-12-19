package ariolmc.aMCGUIApi.api.menu.services.services;

import ariolmc.aMCGUIApi.api.itemGUI.ItemGUI;
import ariolmc.aMCGUIApi.api.itemGUI.itemGUIFactory.ItemGUIFactory;
import ariolmc.aMCGUIApi.api.itemGUI.services.ItemGUIRegistry;
import ariolmc.aMCGUIApi.api.menu.menu.Menu;
import lombok.RequiredArgsConstructor;

/**
 * Сервис по правильному вставлению ItemGUI в Menu
 */
public class MenuItemGUISetter {

    /**
     * Используется, для вставления ItemGUI с "неуникальной" реализации.
     * К примеру для декоративных предметов, у них нет никакой реализации, требующей разных, не идентичных ItemGUI.
     * К примеру, если у вас у каждого предмета должен быть "счётчик нажатий", то передавайте ItemGUIFactory
     * @param slots не должны превышать размеры Menu
     */
    public void setItemGUI(Menu menu, ItemGUI itemGUI, int... slots){
        for (int slot : slots){
            menu.setItem(slot, itemGUI.getItemStack());
        }
        menu.getItemGUIRegistry().register(itemGUI);
    }

    /**
     * Используется для вставки предметов с "уникальной реализацией".
     * Если каждый предмет должен быть уникальным.
     * К примеру, каждый предмет должен знать, сколько раз конкретно по нему, нажали.
     * @param slots не должны превышать размеры Menu
     */
    public void setItemGUI(Menu menu, ItemGUIFactory itemGUIFactory, int... slots){
        setItemGUI(menu, itemGUIFactory.create(), slots);
    }
}
