package ariolmc.aMCGUIApi;

import ariolmc.aMCGUIApi.core.commands.AbstractCommand;
import ariolmc.aMCGUIApi.core.itemGUI.services.ItemGUIFabricRegistrar;
import ariolmc.aMCGUIApi.core.itemGUI.services.ItemGUIRegistry;
import ariolmc.aMCGUIApi.core.listenersAndEvents.listeners.InventoryClickListener;
import ariolmc.aMCGUIApi.core.menu.services.MenuOpener;
import ariolmc.aMCGUIApi.core.menu.services.MenuRegistry;
import ariolmc.aMCGUIApi.infrastructure.ApiWrappers;
import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public final class AMCGUIApi extends JavaPlugin {

    @Getter private static AMCGUIApi instance;

    @Getter private ApiWrappers apiWrappers;

    @Getter private MenuRegistry menuRegistry;
    @Getter private MenuOpener menuOpener;

    @Getter private ItemGUIRegistry itemGUIRegistry;
    @Getter private ItemGUIFabricRegistrar itemGUIFabricRegistrar;


    @Override
    public void onEnable() {
        // Plugin startup logic
        instance = this;

        initApiWrappers();
        initMenuServices();
        initItemGUIServices();

        initListeners();
        initCommands();
    }

    private void initApiWrappers(){
        apiWrappers = new ApiWrappers();
    }

    private void initMenuServices(){
        menuRegistry = new MenuRegistry();
        menuOpener = new MenuOpener(menuRegistry, apiWrappers.getInventoryOpener());
    }

    private void initItemGUIServices(){
        itemGUIRegistry = new ItemGUIRegistry();
        itemGUIFabricRegistrar = new ItemGUIFabricRegistrar(itemGUIRegistry);
    }


    private void initListeners(){
        Bukkit.getPluginManager().registerEvents(new InventoryClickListener(), this);
    }

    private void initCommands(){
        Objects.requireNonNull(getCommand("guiapi")).setExecutor(new AbstractCommand());
    }


    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
