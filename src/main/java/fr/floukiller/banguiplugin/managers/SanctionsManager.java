package fr.floukiller.banguiplugin.managers;

import fr.floukiller.banguiplugin.Main;
import org.bukkit.BanEntry;
import org.bukkit.BanList;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.UUID;

public class SanctionsManager {

    public static void getSanctionFromReason(Player sender, OfflinePlayer target, String reason){

        switch(reason){
            case "Message inutile":
                //Sanction en cas de message inutile
                mutePlayer(sender, target, reason, 60 * 5);
                break;
            case "Fausse information":
                //Sanction en cas de fausse information
                break;
            case "Langage SMS":
                // Sanction en cas d'utilisation abusive du langage SMS
                break;
            case "Mauvais formatage":
                // Sanction en cas de mauvais formatage du message
                break;
            case "Flood":
                // Sanction en cas d'envoi répété de messages
                break;
            case "Langage inapproprié":
                // Sanction en cas d'utilisation de langage inapproprié
                break;
            case "Provocation":
                // Sanction en cas de provocation envers un joueur
                break;
            case "Insulte":
                // Sanction en cas d'insulte envers un joueur
                break;
            case "Incitation a l'infraction":
                // Sanction en cas d'incitation à l'infraction
                break;
            case "Contournement protection chat":
                // Sanction en cas de contournement de la protection du chat
                break;
            case "Lien interdit":
                // Sanction en cas d'envoi de lien interdit
                banPlayer(sender, target, reason, 24*14);
                break;
            case "Publicité":
                // Sanction en cas de publicité pour un serveur ou un site
                break;
            case "DDOS ou Hack/Fake/Phishing":
                // Sanction en cas de tentative de DDOS, hack, fake ou phishing
                banPlayer(sender, target, reason, 24*30);
                break;
            case "Menace IRL":
                // Sanction en cas de menace IRL sur un autre joueur
                banPlayer(sender, target, reason, -1);
                break;
            case "Triche : Anti-Knockback":
                // Sanction en cas d'utilisation d'un anti-knockback
                banPlayer(sender, target, reason, 24*7);
                break;
            case "Triche : KillAura":
                // Sanction en cas d'utilisation d'un KillAura
                banPlayer(sender, target, reason, 24*90);
                break;
            case "Triche : Timer":
                // Sanction en cas d'utilisation d'un timer
                banPlayer(sender, target, reason, 24*7);
                break;
            case "Triche : Reach":
                // Sanction en cas d'utilisation d'un reach
                banPlayer(sender, target, reason, 24*90);
                break;
            case "Triche : Macro":
                // Sanction en cas d'utilisation d'une macro
                banPlayer(sender, target, reason, 24*7);
                break;
            case "Triche : Fly":
                // Sanction en cas d'utilisation d'un fly
                banPlayer(sender, target, reason, 24*90);
                break;
            case "Triche : Speedhack":
                // Sanction en cas d'utilisation d'un speedhack
                banPlayer(sender, target, reason, 24*90);
                break;
            case "Triche : X-Ray":
                // Sanction en cas d'utilisation d'un X-Ray
                banPlayer(sender, target, reason, 24*90);
                break;
            case "Triche : Scaffold":
                // Sanction en cas d'utilisation d'un scaffold
                banPlayer(sender, target, reason, 24*30);
                break;
            case "Abus de report":
                // Sanction en cas d'abus de la commande /report
                break;
            case "Report quelque chose d'autorisé":
                // Sanction en cas de report délibéré de quelque chose qui n'est pas interdit sur le serveur
                break;
            case "Skin inapproprié":
                // Sanction en cas d'utilisation d'un skin inapproprié ou choquant
                banPlayer(sender, target, reason + "\nContactez un modérateur après avoir changé de skin pour être débanni", -1);
                break;
            case "Pseudo inapproprié":
                // Sanction en cas d'utilisation d'un pseudo inapproprié ou choquant
                banPlayer(sender, target, reason + "\nContactez un modérateur après avoir changé de pseudo pour être débanni", -1);
                break;
            case "Construction inappropriée":
                // Sanction en cas de construction inappropriée ou choquante
                banPlayer(sender, target, reason, 24*14);
                break;
            default:
                sender.sendMessage("§cErreur lors de la récupération de la sanction");
                break;
        }

    }

    private static void banPlayer(Player sender, OfflinePlayer target, String reason, int duration) {

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

            for(int i = 0; i < 5; i++){
                target.getPlayer().getWorld().strikeLightningEffect(target.getPlayer().getLocation());
            }

            target.getPlayer().kickPlayer("§cVous êtes banni " + (banEntry.getExpiration() == null ? "définitivement " : "" ) + "de ce serveur\n\n"
                    + "§7Raison : §f" + (banEntry.getReason() != null ? banEntry.getReason() : "Aucune raison définie") + "\n"
                    + "§7Banni par : §f" + banEntry.getSource() + "\n"
                    + (banEntry.getExpiration() != null ? "§7Date de fin : §f" + Main.getInstance().formatDate(banEntry.getExpiration()) + "\n\n" : "\n")
                    + "§7Contester : §fdiscord.gg/serveur");
        }

        sender.sendMessage("§aLe joueur " + target.getName() + " a bien été banni pour " + reason);
    }

    public static void mutePlayer(Player sender, OfflinePlayer target, String reason, int duration) {
        File folder = Main.getInstance().getDataFolder();
        if (!folder.exists()) {
            folder.mkdirs(); // Crée le dossier du plugin s'il n'existe pas
        }

        File file = new File(folder, "mutedPlayers.yml");
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                sender.sendMessage("§cErreur lors de la création du fichier de mute.");
                e.printStackTrace();
                return;
            }
        }

        if (isMuted(target)) {
            sender.sendMessage("§cCe joueur est déjà mute !");
            return;
        }

        FileConfiguration config = YamlConfiguration.loadConfiguration(file);
        UUID uuid = target.getUniqueId();
        String path = "muted." + uuid;

        config.set(path + ".name", target.getName());
        config.set(path + ".reason", reason);
        config.set(path + ".duration", duration); // durée en secondes
        config.set(path + ".start", System.currentTimeMillis());

        try {
            config.save(file);
        } catch (IOException e) {
            sender.sendMessage("§cErreur lors de l'enregistrement du fichier de mute.");
            e.printStackTrace();
            return;
        }

        sender.sendMessage("§aLe joueur " + target.getName() + " a été mute pour " + duration + " secondes. Raison : " + reason);
    }

    public static boolean isMuted(OfflinePlayer target) {
        File file = new File(Main.getInstance().getDataFolder(), "mutedPlayers.yml");
        if (!file.exists()) return false;

        FileConfiguration config = YamlConfiguration.loadConfiguration(file);
        UUID targetUUID = target.getUniqueId();
        String path = "muted." + targetUUID;

        if (!config.contains(path)) return false;

        long start = config.getLong(path + ".start");
        int duration = config.getInt(path + ".duration"); // en secondes

        if (duration == -1) return true; // mute permanent

        long now = System.currentTimeMillis();
        long end = start + duration * 1000L;

        if (now > end) {
            // Mute expiré, suppression automatique
            config.set(path, null);
            try {
                config.save(file);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return false;
        }

        return true;
    }

    public static void unmutePlayer(OfflinePlayer target) {
        File file = new File(Main.getInstance().getDataFolder(), "mutedPlayers.yml");
        if (!file.exists()) return;

        FileConfiguration config = YamlConfiguration.loadConfiguration(file);
        UUID targetUUID = target.getUniqueId();
        String path = "muted." + targetUUID;

        if (config.contains(path)) {
            config.set(path, null);
            try {
                config.save(file);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


}
