package ariolmc.aMCGUIApi.core.commands.admin.sub;

import ariolmc.aMCGUIApi.api.menu.services.exceptions.NotFoundPluginForCloser;
import ariolmc.aMCGUIApi.api.menu.services.services.MenuCloser;
import ariolmc.aMCGUIApi.core.commands.SubCommand;
import org.bukkit.command.CommandSender;

public class CloseMenusPlugin implements SubCommand {

    private final MenuCloser menuCloser;

    public CloseMenusPlugin(MenuCloser menuCloser){
        this.menuCloser = menuCloser;
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        if(!checkPermission(sender)){
            sender.sendMessage("§cУ вас не прав, для использования этой команды!");
            return;
        }

        String pluginName = args[1];
        try {
            menuCloser.closeMenus(pluginName);
            sender.sendMessage("§6[AMCGUIApi] §fУспешно закрыты все меню для §6" + pluginName);
        } catch (NotFoundPluginForCloser e){
            sender.sendMessage("§6[AMCGUIApi] §f" + e.getMessage());
        }
    }

    private boolean checkPermission(CommandSender sender){
        return sender.hasPermission("amcguiapi.closeplugin");
    }
}
