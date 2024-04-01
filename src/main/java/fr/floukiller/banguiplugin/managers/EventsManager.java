package fr.floukiller.banguiplugin.managers;

import fr.floukiller.banguiplugin.Main;
import fr.floukiller.banguiplugin.listeners.*;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;

public class EventsManager {
    public void registers(){
        PluginManager pm = Bukkit.getPluginManager();

        pm.registerEvents(new BanguiMainMenuListeners(), Main.getInstance());
        pm.registerEvents(new BanguiMessagesMenuListener(), Main.getInstance());
        pm.registerEvents(new BanguiCheatMenuListeners(), Main.getInstance());
        pm.registerEvents(new BanguiAbuseMenuListeners(), Main.getInstance());
        pm.registerEvents(new BannedPlayerLoginListener(), Main.getInstance());
        pm.registerEvents(new BanGuiConfirmMenuListener(), Main.getInstance());
    }
}
