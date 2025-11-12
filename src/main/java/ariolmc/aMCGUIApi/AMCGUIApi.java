package ariolmc.aMCGUIApi;

import lombok.Getter;
import org.bukkit.plugin.java.JavaPlugin;

public final class AMCGUIApi extends JavaPlugin {

    @Getter private AMCGUIApi instance;

    @Override
    public void onEnable() {
        // Plugin startup logic
        instance = this;

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
