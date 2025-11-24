package ariolmc.aMCGUIApi.core.commands;

import ariolmc.aMCGUIApi.AMCGUIApi;
import ariolmc.aMCGUIApi.api.menu.animatedMenu.AnimatedMenu;
import ariolmc.aMCGUIApi.api.menu.menu.factory.MenuFactory;
import ariolmc.aMCGUIApi.api.menu.services.MenuServices;
import ariolmc.aMCGUIApi.api.menu.menu.Menu;
import ariolmc.aMCGUIApi.api.readyMadeSolutions.menus.TestAnimatedMenuFactory;
import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class AbstractCommand implements CommandExecutor {

    MenuFactory menuFactory = new TestAnimatedMenuFactory();
    Menu menu = menuFactory.create();
    MenuServices services;

    boolean b = true;

    public AbstractCommand(){

        services = AMCGUIApi.getInstance().getMenuServices();
    }

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String @NotNull [] strings) {

        Player player = (Player) commandSender;

        services.openNewMenu(AMCGUIApi.getInstance(), player.getUniqueId(), menuFactory);

        return true;
    }
}
