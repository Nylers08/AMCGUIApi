package ariolmc.aMCGUIApi.core.commands.admin.sub;

import ariolmc.aMCGUIApi.api.menu.services.exceptions.NotFoundMenuViewer;
import ariolmc.aMCGUIApi.api.menu.services.services.MenuCloser;
import ariolmc.aMCGUIApi.core.commands.SubCommand;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.UUID;

public class CloseMenuForPlayer implements SubCommand {

    private final MenuCloser menuCloser;

    public CloseMenuForPlayer(MenuCloser menuCloser) {
        this.menuCloser = menuCloser;
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        if(!checkPermission(sender)){
            sender.sendMessage("§cУ вас не прав, для использования этой команды!");
            return;
        }

        String playerName = args[1];
        Player player = Bukkit.getPlayer(playerName);
        if(player == null || !player.isOnline()){
            sender.sendMessage("§cНе удалось закрыть меню для " + playerName + ". Игрок не найден, либо не в сети.");
            return;
        }

        try {
            UUID playerId = player.getUniqueId();
            menuCloser.close(playerId);
            sender.sendMessage("§6[AMCGUIApi] §fУспешно закрыли меню для §6" + player.getName());
        } catch (NotFoundMenuViewer e){
            sender.sendMessage("§cНе удалось закрыть меню для " + player.getName() + ". Скорее всего, он не просматривает не одно меню");
        }

    }

    private boolean checkPermission(CommandSender sender){
        return sender.hasPermission("amcguiapi.closeplayer");
    }
}
