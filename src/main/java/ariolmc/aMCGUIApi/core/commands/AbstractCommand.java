package ariolmc.aMCGUIApi.core.commands;

import ariolmc.aMCGUIApi.AMCGUIApi;
import ariolmc.aMCGUIApi.core.menu.services.MenuServices;
import ariolmc.aMCGUIApi.core.menu.menu.Menu;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class AbstractCommand implements CommandExecutor {

    Menu menu;
    MenuServices services;

    public AbstractCommand(){

        services = AMCGUIApi.getInstance().getMenuServices();
    }

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String @NotNull [] strings) {

        Player player = (Player) commandSender;


        return true;
    }
}
