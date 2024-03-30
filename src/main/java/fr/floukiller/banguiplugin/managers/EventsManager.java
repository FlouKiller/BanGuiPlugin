package fr.floukiller.banguiplugin.managers;

import fr.floukiller.banguiplugin.Main;
import fr.floukiller.banguiplugin.listeners.BanguiMainMenuListeners;
import fr.floukiller.banguiplugin.listeners.BanguiMessagesMenuListener;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;

public class EventsManager {
    public void registers(){
        PluginManager pm = Bukkit.getPluginManager();

        pm.registerEvents(new BanguiMainMenuListeners(), Main.getInstance());
        pm.registerEvents(new BanguiMessagesMenuListener(), Main.getInstance());
    }
}
