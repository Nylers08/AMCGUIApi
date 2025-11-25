package ariolmc.aMCGUIApi.core.commands.admin;

import ariolmc.aMCGUIApi.api.menu.services.MenuServices;
import ariolmc.aMCGUIApi.core.commands.AbstractCommand;
import ariolmc.aMCGUIApi.core.commands.admin.sub.CloseAbsoluteAllMenu;
import ariolmc.aMCGUIApi.core.commands.admin.sub.CloseMenuForPlayer;
import ariolmc.aMCGUIApi.core.commands.admin.sub.CloseMenusPlugin;
import lombok.Getter;
import org.bukkit.command.CommandSender;

public class GUIApiCommand extends AbstractCommand {

    @Getter private final MenuServices menuServices;

    public GUIApiCommand(MenuServices menuServices){
        this.menuServices = menuServices;

        addSubCommand(new CloseAbsoluteAllMenu(menuServices.closer()), "closeall");
        addSubCommand(new CloseMenusPlugin(menuServices.closer()), "closeplugin");
        addSubCommand(new CloseMenuForPlayer(menuServices.closer()), "closeplayer");
    }

    @Override
    protected boolean checkPrediction(CommandSender sender, String[] args) {
        return sender.hasPermission("amcguiapi.use");
    }

    @Override
    protected void actionNoArgs(CommandSender sender) {
        sender.sendMessage("§6[AMCGUIApi] §f☺");
    }
}
