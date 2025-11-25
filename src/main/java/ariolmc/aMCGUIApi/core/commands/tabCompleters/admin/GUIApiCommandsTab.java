package ariolmc.aMCGUIApi.core.commands.tabCompleters.admin;

import ariolmc.aMCGUIApi.core.commands.tabCompleters.manage.CommandTabCompleter;
import org.bukkit.command.CommandSender;

import java.util.*;
import java.util.stream.Collectors;

public class GUIApiCommandsTab implements CommandTabCompleter {

    private final Set<String> subCommandNames;

    public GUIApiCommandsTab(Set<String> subCommandNames){
        this.subCommandNames = subCommandNames;
    }

    @Override
    public List<String> complete(CommandSender sender, String[] args) {
        if(args.length == 1){
            String prefix = args[0];
            return subCommandNames.stream()
                    .filter(Objects::nonNull)
                    .filter(name -> name.toLowerCase().startsWith(prefix))
                    .collect(Collectors.toList());

        }
        return Collections.emptyList();
    }
}
