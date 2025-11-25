package ariolmc.aMCGUIApi.core.commands;


import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public abstract class AbstractCommand implements CommandExecutor {

    private final Map<String, SubCommand> subCommands = new HashMap<>();

    public void addSubCommand(SubCommand subCommand, String... names){
        for (String name : names){
            subCommands.put(name, subCommand);
        }
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String s, @NotNull String @NotNull [] args) {
        callSubCommand(sender, args);

        return true;
    }

    protected void callSubCommand(CommandSender sender, String[] args){
        if(args.length < 1){
            actionNoArgs(sender);
            return;
        }

        String sub = args[0];
        SubCommand subCommand = subCommands.get(sub);
        if(subCommand == null) return;

        subCommand.execute(sender, args);
    }

    protected abstract void actionNoArgs(CommandSender sender);

    public Set<String> getAllSubCommandNames(){
        return subCommands.keySet();
    }
}
