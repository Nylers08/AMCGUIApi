package ariolmc.aMCGUIApi.api.menu.animatedMenu;

import ariolmc.aMCGUIApi.api.menu.menu.Menu;
import ariolmc.aMCGUIApi.api.menu.services.services.menuRegistry.menuRegistry.MenuRegistry;
import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitTask;

/**
 * Все анимированные меню, изменяются через тики.
 * Этот класс, как раз таки генерирует для них эти самые тики
 */
public class AnimationTickGenerator {

    private final Plugin plugin;
    private final MenuRegistry menuRegistry;
    private final long delay;

    private BukkitTask ticker;

    /**
     * Запускает генерацию тиков
     *
     * @param plugin на каком плагине запустится BukkitTask, для генерации тиков
     * @param menuRegistry в какой регистр, обращаться за всеми меню
     * @param delay раз во сколько Майнкрафтовских тиков, генерировать свой тик
     * @return новый объект, в котором вы сможете остановить, или заного запустить тики
     */
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

    /**
     * Снова начать генерацию тиков
     */
    public void startGeneration(){
        stopGeneration();
        ticker = Bukkit.getScheduler().runTaskTimerAsynchronously(plugin, this::generateTick, delay, delay);
    }

    /**
     * Остановить генерацию тиков
     */
    public void stopGeneration(){
        if(ticker != null){
            ticker.cancel();
        }
    }

    /**
     * Принудительно сгенерировать тик, для всех меню
     */
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
