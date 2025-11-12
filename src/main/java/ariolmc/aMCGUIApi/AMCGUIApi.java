package ariolmc.aMCGUIApi;

import ariolmc.aMCGUIApi.core.menu.services.MenuOpener;
import ariolmc.aMCGUIApi.core.menu.services.MenuRegistry;
import ariolmc.aMCGUIApi.infrastructure.ApiWrappers;
import lombok.Getter;
import org.bukkit.plugin.java.JavaPlugin;

public final class AMCGUIApi extends JavaPlugin {

    @Getter private static AMCGUIApi instance;

    @Getter private ApiWrappers apiWrappers;

    @Getter private MenuRegistry registry;
    @Getter private MenuOpener opener;

    @Override
    public void onEnable() {
        // Plugin startup logic
        instance = this;

        initApiWrappers();
        initMenuServices();
    }

    private void initApiWrappers(){
        apiWrappers = new ApiWrappers();
    }

    private void initMenuServices(){
        registry = new MenuRegistry();
        opener = new MenuOpener(registry, apiWrappers.getInventoryOpener());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
