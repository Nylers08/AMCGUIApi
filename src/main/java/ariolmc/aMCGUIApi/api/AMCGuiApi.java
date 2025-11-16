package ariolmc.aMCGUIApi.api;

import ariolmc.aMCGUIApi.AMCGUIApi;
import ariolmc.aMCGUIApi.api.itemGUI.services.ItemGUIRegistry;
import ariolmc.aMCGUIApi.api.menu.animatedMenu.AnimationTickGenerator;
import ariolmc.aMCGUIApi.api.menu.services.MenuServices;
import lombok.Getter;

import java.util.logging.Logger;

public class AMCGuiApi {

    @Getter private static Logger logger;
    @Getter private static MenuServices menuServices;
    @Getter private static ItemGUIRegistry itemGUIRegistry;
    @Getter private static AnimationTickGenerator animationTickGenerator;

    public static void initialize(AMCGUIApi plugin){
        logger = plugin.getLogger();
        menuServices = plugin.getMenuServices();
        itemGUIRegistry = plugin.getItemGUIRegistry();
        animationTickGenerator = plugin.getAnimationTickGenerator();
    }

}
