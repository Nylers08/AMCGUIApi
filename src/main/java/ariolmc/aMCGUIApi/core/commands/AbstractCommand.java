package ariolmc.aMCGUIApi.core.commands;

import ariolmc.aMCGUIApi.AMCGUIApi;
import ariolmc.aMCGUIApi.core.menu.services.MenuServices;
import ariolmc.aMCGUIApi.core.menu.someMenu.Menu;
import ariolmc.aMCGUIApi.core.menu.someMenu.factory.*;
import net.kyori.adventure.text.Component;
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

        services.openNewMenu(player.getUniqueId(), new Test4MenuFactory(menu));

        Bukkit.getScheduler().runTaskLater(AMCGUIApi.getInstance(), ()->{
            Component newTitle = menu.getTitle();
            newTitle = newTitle.append(Component.text("_кек"));
            services.rename(menu, newTitle);
        }, 20L * 3);

        return true;
    }
}
