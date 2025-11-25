package ariolmc.aMCGUIApi.core.commands.admin.sub;

import ariolmc.aMCGUIApi.api.menu.services.services.MenuCloser;
import ariolmc.aMCGUIApi.core.commands.SubCommand;
import org.bukkit.command.CommandSender;

public class CloseAbsoluteAllMenu implements SubCommand {

    private final MenuCloser menuCloser;

    public CloseAbsoluteAllMenu(MenuCloser menuCloser){
        this.menuCloser = menuCloser;
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        menuCloser.closeAbsoluteAllMenu();
        sender.sendMessage("§6[AMCGuiApi]§f Все меню успешно закрыты!");
    }
}
