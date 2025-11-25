package ariolmc.aMCGUIApi.core.commands.tabCompleters.manage;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AbstractTabCompleter implements TabCompleter {

    protected final List<CommandTabCompleter> tabCompleters = new ArrayList<>();

    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command command, @NotNull String alias, @NotNull String[] args) {
        if(!(sender instanceof Player)) return Collections.emptyList();

        Player player = (Player) sender;

        for (CommandTabCompleter completer : tabCompleters){
            List<String> result = completer.complete(player, args);
            if(!result.isEmpty()) return result;
        }

        return Collections.emptyList();
    }

    public void addTabCompleter(CommandTabCompleter tabCompleter){
        tabCompleters.add(tabCompleter);
    }
}
