package ariolmc.aMCGUIApi;

import ariolmc.aMCGUIApi.core.commands.AbstractCommand;
import ariolmc.aMCGUIApi.api.itemGUI.services.ItemGUIRegistry;
import ariolmc.aMCGUIApi.api.listeners.InventoryClickListener;
import ariolmc.aMCGUIApi.api.listeners.InventoryCloseListener;
import ariolmc.aMCGUIApi.api.menu.animatedMenu.AnimationTickGenerator;
import ariolmc.aMCGUIApi.api.menu.services.DefaultMenuServicesBuilder;
import ariolmc.aMCGUIApi.api.menu.services.MenuServices;
import ariolmc.aMCGUIApi.core.commands.admin.GuiApiCommand;
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

    @Getter private AnimationTickGenerator animationTickGenerator;


    @Override
    public void onEnable() {
        // Plugin startup logic
        instance = this;

        initApiWrappers();
        initItemGUIServices();
        initMenuServices();
        initAnimationTickGenerator();

        initListeners();
        initCommands();
    }

    private void initApiWrappers(){
        apiWrappers = new ApiWrappers();
    }

    private void initItemGUIServices(){
        itemGUIRegistry = new ItemGUIRegistry(this);
    }

    private void initMenuServices(){
        menuServices = DefaultMenuServicesBuilder.build(itemGUIRegistry);
    }

    private void initAnimationTickGenerator(){
        animationTickGenerator = AnimationTickGenerator.startGeneration(this, menuServices.registry(), 1L);
    }


    private void initListeners(){
        Bukkit.getPluginManager().registerEvents(new InventoryClickListener(), this);
        Bukkit.getPluginManager().registerEvents(new InventoryCloseListener(menuServices.registry()), this);
    }

    private void initCommands(){
        Objects.requireNonNull(getCommand("guiapi")).setExecutor(new GuiApiCommand(menuServices));
    }


    @Override
    public void onDisable() {
        // Plugin shutdown logic

        animationTickGenerator.stopGeneration();

        logDisable();
        menuServices.closeAbsoluteAllMenu();
    }

    private void logDisable(){
        getLogger().info("Плагин отключается!");
        getLogger().info("В целях безопасности от дюпов и т.п, закрываются абсолютно все меню!");
    }
}
