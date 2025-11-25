package ariolmc.aMCGUIApi.core.commands.tabCompleters.admin;

import ariolmc.aMCGUIApi.core.commands.tabCompleters.manage.CommandTabCompleter;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Collections;
import java.util.List;

public class GUIApiClosePlayerTab implements CommandTabCompleter {

    @Override
    public List<String> complete(CommandSender sender, String[] args) {
        if (args.length == 0 || !args[0].equalsIgnoreCase("closeplayer"))
            return Collections.emptyList();

        return Bukkit.getOnlinePlayers().stream()
                .map(Player::getName)
                .toList();
    }

}
