package ariolmc.aMCGUIApi.core.commands.tabCompleters.manage;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.List;

public interface CommandTabCompleter {

    List<String> complete(CommandSender sender, String[] args);
}
