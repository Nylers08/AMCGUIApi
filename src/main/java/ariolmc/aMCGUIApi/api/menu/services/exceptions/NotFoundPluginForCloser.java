package ariolmc.aMCGUIApi.api.menu.services.exceptions;

public class NotFoundPluginForCloser extends RuntimeException{
    public NotFoundPluginForCloser(String pluginName){
        super("Не удалось найти плагин \"" + pluginName + "\" для закрытия его меню");
    }
}
