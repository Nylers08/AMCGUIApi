package ariolmc.aMCGUIApi;

import ariolmc.aMCGUIApi.core.commands.AbstractCommand;
import ariolmc.aMCGUIApi.core.itemGUI.services.ItemGUIRegistry;
import ariolmc.aMCGUIApi.core.listenersAndEvents.listeners.InventoryClickListener;
import ariolmc.aMCGUIApi.core.listenersAndEvents.listeners.InventoryCloseListener;
import ariolmc.aMCGUIApi.core.menu.services.DefaultMenuServicesBuilder;
import ariolmc.aMCGUIApi.core.menu.services.MenuServices;
import ariolmc.aMCGUIApi.infrastructure.ApiWrappers;
import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public final class AMCGUIApi extends JavaPlugin {

    @Getter private static AMCGUIApi instance;

    @Getter private ApiWrappers apiWrappers;

    @Getter private MenuServices menuServices;

    @Getter private ItemGUIRegistry itemGUIRegistry;


    @Override
    public void onEnable() {
        // Plugin startup logic
        instance = this;

        initApiWrappers();
        initItemGUIServices();
        initMenuServices();

        initListeners();
        initCommands();
    }

    private void initApiWrappers(){
        apiWrappers = new ApiWrappers();
    }

    private void initItemGUIServices(){
        itemGUIRegistry = new ItemGUIRegistry();
    }

    private void initMenuServices(){
        menuServices = DefaultMenuServicesBuilder.build(itemGUIRegistry);
    }


    private void initListeners(){
        Bukkit.getPluginManager().registerEvents(new InventoryClickListener(), this);
        Bukkit.getPluginManager().registerEvents(new InventoryCloseListener(menuServices.registry()), this);
    }

    private void initCommands(){
        Objects.requireNonNull(getCommand("guiapi")).setExecutor(new AbstractCommand());
    }


    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
