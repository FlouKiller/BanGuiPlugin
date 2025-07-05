package fr.floukiller.banguiplugin;

import fr.floukiller.banguiplugin.commands.BanguiCommand;
import fr.floukiller.banguiplugin.commands.MuteCommands;
import fr.floukiller.banguiplugin.managers.EventsManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

public class Main extends JavaPlugin {

    public String formatDate(Date date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        return dateFormat.format(date);
    }

    private static Main instance;

    @Override
    public void onEnable() {
        instance = this;

        new EventsManager().registers();

        Objects.requireNonNull(getCommand("bangui")).setExecutor(new BanguiCommand());
        Objects.requireNonNull(getCommand("mute")).setExecutor(new MuteCommands());
        Objects.requireNonNull(getCommand("unmute")).setExecutor(new MuteCommands());

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