package fr.floukiller.banguiplugin.managers;

import fr.floukiller.banguiplugin.Main;
import org.bukkit.BanEntry;
import org.bukkit.BanList;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.UUID;

public class SanctionsManager {

    public static void getSanctionFromReason(Player sender, OfflinePlayer target, String reason){

        switch (reason) {
            case "Message inutile":
                mutePlayer(sender, target, reason, 300); // 5 minutes
                break;
            case "Fausse information":
                mutePlayer(sender, target, reason, 600); // 10 minutes
                break;
            case "Langage SMS":
                mutePlayer(sender, target, reason, 600); // 10 minutes
                break;
            case "Mauvais formatage":
                mutePlayer(sender, target, reason, 300); // 5 minutes
                break;
            case "Flood":
                mutePlayer(sender, target, reason, 900); // 15 minutes
                break;
            case "Langage inapproprié":
                mutePlayer(sender, target, reason, 1800); // 30 minutes
                break;
            case "Provocation":
                mutePlayer(sender, target, reason, 1800); // 30 minutes
                break;
            case "Insulte":
                mutePlayer(sender, target, reason, 86400); // 1 jour
                break;
            case "Incitation a l'infraction":
                mutePlayer(sender, target, reason, 86400); // 1 jour
                break;
            case "Contournement protection chat":
                mutePlayer(sender, target, reason, 172800); // 2 jours
                break;
            case "Lien interdit":
                banPlayer(sender, target, reason, 1209600); // 14 jours
                break;
            case "Publicité":
                banPlayer(sender, target, reason, 1209600); // 14 jours
                break;
            case "DDOS ou Hack/Fake/Phishing":
                banPlayer(sender, target, reason, 2592000); // 30 jours
                break;
            case "Menace IRL":
                banPlayer(sender, target, reason, -1); // permanent
                break;
            case "Triche : Anti-Knockback":
                banPlayer(sender, target, reason, 604800); // 7 jours
                break;
            case "Triche : KillAura":
                banPlayer(sender, target, reason, 7776000); // 90 jours
                break;
            case "Triche : Timer":
                banPlayer(sender, target, reason, 604800); // 7 jours
                break;
            case "Triche : Reach":
                banPlayer(sender, target, reason, 7776000); // 90 jours
                break;
            case "Triche : Macro":
                banPlayer(sender, target, reason, 604800); // 7 jours
                break;
            case "Triche : Fly":
                banPlayer(sender, target, reason, 7776000); // 90 jours
                break;
            case "Triche : Speedhack":
                banPlayer(sender, target, reason, 7776000); // 90 jours
                break;
            case "Triche : X-Ray":
                banPlayer(sender, target, reason, 7776000); // 90 jours
                break;
            case "Triche : Scaffold":
                banPlayer(sender, target, reason, 2592000); // 30 jours
                break;
            case "Abus de report":
                banPlayer(sender, target, reason, 1209600); // 14 jours
                break;
            case "Report quelque chose d'autorisé":
                banPlayer(sender, target, reason, 1209600); // 14 jours
                break;
            case "Skin inapproprié":
                banPlayer(sender, target, reason + "\nContactez un modérateur après avoir changé de skin pour être débanni", -1); // permanent
                break;
            case "Pseudo inapproprié":
                banPlayer(sender, target, reason + "\nContactez un modérateur après avoir changé de pseudo pour être débanni", -1); // permanent
                break;
            case "Construction inappropriée":
                banPlayer(sender, target, reason, 1209600); // 14 jours
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

    public static void mutePlayer(CommandSender sender, OfflinePlayer target, String reason, int duration) {
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
        if( target.isOnline() ) {
            target.getPlayer().sendMessage("§cVous avez été mute pour " + duration + " secondes. Raison : " + reason);
        }
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

    public static void unmutePlayer(CommandSender sender, OfflinePlayer target) {
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

        sender.sendMessage("§aLe joueur " + target.getName() + " a été unmute.");
        if( target.isOnline() ) {
            target.getPlayer().sendMessage("§aVous avez été unmute");
        }
    }

    public static String getMuteReason(OfflinePlayer target) {
        File file = new File(Main.getInstance().getDataFolder(), "mutedPlayers.yml");
        if (!file.exists()) return "Aucune raison définie";

        FileConfiguration config = YamlConfiguration.loadConfiguration(file);
        UUID targetUUID = target.getUniqueId();
        String path = "muted." + targetUUID;

        if (config.contains(path)) {
            return config.getString(path + ".reason", "Aucune raison définie");
        }

        return "Aucune raison définie";
    }

    public static String getMuteExpiration(OfflinePlayer target) {
        File file = new File(Main.getInstance().getDataFolder(), "mutedPlayers.yml");
        if (!file.exists()) return "Aucune expiration définie";

        FileConfiguration config = YamlConfiguration.loadConfiguration(file);
        UUID targetUUID = target.getUniqueId();
        String path = "muted." + targetUUID;

        if (config.contains(path)) {
            long start = config.getLong(path + ".start");
            int duration = config.getInt(path + ".duration"); // en secondes

            if (duration == -1) return "Permanent";

            long end = start + duration * 1000L;
            Date date = new Date(end);
            java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            return sdf.format(date);
        }

        return "Aucune expiration définie";
    }

}
