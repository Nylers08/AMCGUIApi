package ariolmc.aMCGUIApi.core.commands;

import ariolmc.aMCGUIApi.AMCGUIApi;
import ariolmc.aMCGUIApi.core.menu.animatedMenu.BaseAnimatedMenu;
import ariolmc.aMCGUIApi.core.menu.animatedMenu.animationFrame.factory.TestAnimationFrameFactory;
import ariolmc.aMCGUIApi.core.menu.animatedMenu.animationFrame.factory.TestAnimationFrameFactory1;
import ariolmc.aMCGUIApi.core.menu.services.MenuServices;
import ariolmc.aMCGUIApi.core.menu.someMenu.Menu;
import ariolmc.aMCGUIApi.core.menu.someMenu.factory.*;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class AbstractCommand implements CommandExecutor {

    Menu menu;
    MenuServices services;

    public AbstractCommand(){

        MenuFactory menuFactory = new Test2MenuFactory();
        menu = menuFactory.create();

        services = AMCGUIApi.getInstance().getMenuServices();
    }

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String @NotNull [] strings) {

        Player player = (Player) commandSender;

        BaseAnimatedMenu animatedMenu = new BaseAnimatedMenu(new TestAnimationFrameFactory(), services.opener());
        services.open(player.getUniqueId(), animatedMenu);

        Bukkit.getScheduler().runTaskTimer(AMCGUIApi.getInstance(), ()->{
            animatedMenu.tick();
            if(animatedMenu.isAnimationFinished())
                animatedMenu.reset();
        }, 1, 1);

        return true;
    }
}
