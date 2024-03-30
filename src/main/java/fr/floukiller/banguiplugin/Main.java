package fr.floukiller.banguiplugin;

import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        getLogger().info("Plugin BanguiPlugin activé !");
    }

    @Override
    public void onDisable() {
        getLogger().info("Plugin BanguiPlugin désactivé !");
    }

}