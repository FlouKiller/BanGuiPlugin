package fr.floukiller.banguiplugin;

import fr.floukiller.banguiplugin.managers.EventsManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    private static Main instance;

    @Override
    public void onEnable() {
        instance = this;

        new EventsManager().registers();

        getLogger().info("Plugin BanguiPlugin activé !");
    }

    @Override
    public void onDisable() {
        getLogger().info("Plugin BanguiPlugin désactivé !");
    }

    public static Main getInstance() {
        return instance;
    }

}