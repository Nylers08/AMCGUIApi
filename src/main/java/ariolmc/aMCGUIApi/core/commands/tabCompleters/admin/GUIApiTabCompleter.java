package ariolmc.aMCGUIApi.core.commands.tabCompleters.admin;

import ariolmc.aMCGUIApi.core.commands.admin.GUIApiCommand;
import ariolmc.aMCGUIApi.core.commands.tabCompleters.manage.AbstractTabCompleter;
import lombok.Getter;

public class GUIApiTabCompleter extends AbstractTabCompleter {

    @Getter private final GUIApiCommand guiApiCommand;

    public GUIApiTabCompleter(GUIApiCommand guiApiCommand){
        this.guiApiCommand = guiApiCommand;

        addTabCompleter(new GUIApiCommandsTab(
                guiApiCommand.getAllSubCommandNames()));

        addTabCompleter(new GUIApiClosePluginTab(
                guiApiCommand.getMenuServices().registry()));

        addTabCompleter(new GUIApiClosePlayerTab());
    }
}
