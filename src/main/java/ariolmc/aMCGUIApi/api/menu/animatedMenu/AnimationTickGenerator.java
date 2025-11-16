package ariolmc.aMCGUIApi.api.menu.animatedMenu;

import ariolmc.aMCGUIApi.api.menu.menu.Menu;
import ariolmc.aMCGUIApi.api.menu.services.services.MenuRegistry;
import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitTask;

public class AnimationTickGenerator {

    private final Plugin plugin;
    private final MenuRegistry menuRegistry;
    private final long delay;

    private BukkitTask ticker;

    public static AnimationTickGenerator startGeneration(Plugin plugin, MenuRegistry menuRegistry, long delay){
        AnimationTickGenerator tickGenerator = new AnimationTickGenerator(plugin, menuRegistry, delay);
        tickGenerator.startGeneration();
        return tickGenerator;
    }

    private AnimationTickGenerator(Plugin plugin, MenuRegistry menuRegistry, long delay){
        this.plugin = plugin;
        this.menuRegistry = menuRegistry;
        this.delay = delay;
    }

    public void startGeneration(){
        stopGeneration();
        ticker = Bukkit.getScheduler().runTaskTimerAsynchronously(plugin, this::generateTick, delay, delay);
    }

    public void stopGeneration(){
        if(ticker != null){
            ticker.cancel();
        }
    }

    public void generateTick(){
        for (Menu menu : menuRegistry.getAllOpenMenus()){
            generateTickForMenu(menu);
        }
    }

    private void generateTickForMenu(Menu menu){
        if(menu instanceof AnimatedMenu animatedMenu){
            Bukkit.getScheduler().runTask(plugin, animatedMenu::tick);
        }
    }
}
