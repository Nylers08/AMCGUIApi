package ariolmc.aMCGUIApi.core.commands.tabCompleters.admin;

import ariolmc.aMCGUIApi.api.menu.services.services.menuRegistry.menuRegistry.MenuRegistry;
import ariolmc.aMCGUIApi.api.menu.services.services.menuRegistry.menuRegistry.MenuRegistryImpl;
import ariolmc.aMCGUIApi.api.menu.services.services.menuRegistry.pluginMenuRegistry.PluginMenuRegistry;
import ariolmc.aMCGUIApi.core.commands.tabCompleters.manage.CommandTabCompleter;
import lombok.Getter;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.Plugin;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class GUIApiClosePluginTab implements CommandTabCompleter {

    @Getter private final MenuRegistry menuRegistry;

    public GUIApiClosePluginTab(MenuRegistry menuRegistry) {
        this.menuRegistry = menuRegistry;
    }

    @Override
    public List<String> complete(CommandSender sender, String[] args) {
        if(!args[0].equalsIgnoreCase("closeplugin"))
            return Collections.emptyList();

        String prefix = args[1];
        return getNamesOpenPlugins().stream()
                .filter(Objects::nonNull)
                .filter(name -> name.toLowerCase().startsWith(prefix))
                .collect(Collectors.toList());
    }

    private List<String> getNamesOpenPlugins(){
        Set<Plugin> plugins = menuRegistry.getAllPlugins();
        return plugins.stream()
                .map(Plugin::getName)
                .toList();
    }
}
