package fr.floukiller.banguiplugin.listeners;

import fr.floukiller.banguiplugin.Main;
import org.bukkit.BanEntry;
import org.bukkit.BanList;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;

import java.text.SimpleDateFormat;
import java.util.Date;

public class BannedPlayerLoginListener implements Listener {

    @EventHandler
    public void onPlayerLogin(PlayerLoginEvent e){

        if(e.getResult() == PlayerLoginEvent.Result.KICK_BANNED){

            Player player = e.getPlayer();
            BanEntry<?> banEntry = Bukkit.getBanList(BanList.Type.PROFILE).getBanEntry(player.getName());

            e.setKickMessage("§cVous êtes banni " + (banEntry.getExpiration() == null ? "définitivement " : "" ) + "de ce serveur\n\n"
                    + "§7Raison : §f" + (banEntry.getReason() != null ? banEntry.getReason() : "Aucune raison définie") + "\n"
                    + "§7Banni par : §f" + banEntry.getSource() + "\n"
                    + (banEntry.getExpiration() != null ? "§7Date de fin : §f" + Main.getInstance().formatDate(banEntry.getExpiration()) + "\n\n" : "\n")
                    + "§7Contester : §fdiscord.gg/serveur");
        }
    }

}
