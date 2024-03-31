package fr.floukiller.banguiplugin.managers;

import fr.floukiller.banguiplugin.Main;
import org.bukkit.BanEntry;
import org.bukkit.BanList;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;

import java.text.SimpleDateFormat;
import java.util.Date;

public class BanManager {

    public static void banPlayer(Player sender, OfflinePlayer target, String reason, int duration) {

        if (target.isBanned()) {
            sender.sendMessage("§cCe joueur est déjà banni !");
            return;
        }

        if(duration == -1) {
            Bukkit.getBanList(BanList.Type.PROFILE).addBan(target.getName(), reason, null, sender.getName());
        } else {
            Bukkit.getBanList(BanList.Type.PROFILE).addBan(target.getName(), reason, new Date(System.currentTimeMillis() + (long) duration * 1000 * 60 * 60), sender.getName());
        }

        BanEntry<?> banEntry = Bukkit.getBanList(BanList.Type.PROFILE).getBanEntry(target.getName());

        if(target.isOnline()) {
            target.getPlayer().kickPlayer("§cVous êtes banni " + (banEntry.getExpiration() == null ? "définitivement " : "" ) + "de ce serveur\n\n"
                    + "§7Raison : §f" + (banEntry.getReason() != null ? banEntry.getReason() : "Aucune raison définie") + "\n"
                    + "§7Banni par : §f" + banEntry.getSource() + "\n"
                    + (banEntry.getExpiration() != null ? "§7Date de fin : §f" + Main.getInstance().formatDate(banEntry.getExpiration()) + "\n\n" : "\n")
                    + "§7Contester : §fdiscord.gg/serveur");
        }

        sender.sendMessage("§aLe joueur " + target.getName() + " a bien été banni pour " + reason);
    }

}
