package fr.floukiller.banguiplugin.listeners;

import com.google.common.util.concurrent.Service;
import fr.floukiller.banguiplugin.managers.SanctionsManager;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class MutedPlayersListener implements Listener {

    @EventHandler
    public void onPlayerChat(AsyncPlayerChatEvent e) {
        Player player = e.getPlayer();

        if(SanctionsManager.isMuted(player)){
            e.setCancelled(true);
            String reason = SanctionsManager.getMuteReason(player);
            String expiration = SanctionsManager.getMuteExpiration(player);
            player.sendMessage(
                "§cVous êtes actuellement mute !\n" +
                "§cRaison: §7" + reason + "\n" +
                "§cExpiration: §7" + expiration);
        }
    }
}
