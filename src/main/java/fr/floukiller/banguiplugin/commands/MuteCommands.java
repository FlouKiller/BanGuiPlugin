package fr.floukiller.banguiplugin.commands;

import fr.floukiller.banguiplugin.managers.SanctionsManager;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class MuteCommands implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if(label.equalsIgnoreCase("mute")){

            if (!sender.hasPermission("banguiplugin.mute")) {
                sender.sendMessage("§cVous n'avez pas la permission d'utiliser cette commande !");
                return true;
            }

            if(args.length != 3){
                sender.sendMessage("§cUtilisation: /mute <joueur> <durée en secondes> <raison>");
                return true;
            }

            OfflinePlayer target = Bukkit.getOfflinePlayer(args[0]);
            int duration;
            try {
                duration = Integer.parseInt(args[1]);
            } catch (NumberFormatException e) {
                sender.sendMessage("§cDurée invalide : " + args[1]);
                return true;
            }

            if (duration <= 0) {
                sender.sendMessage("§cLa durée doit être supérieure à 0 secondes.");
                return true;
            }

            String reason = args[2];
            if (reason.isEmpty()) {
                sender.sendMessage("§cLa raison ne peut pas être vide.");
                return true;
            }

            if(SanctionsManager.isMuted(target)) {
                sender.sendMessage("§cLe joueur " + target.getName() + " est déjà mute.");
                return true;
            }

            SanctionsManager.mutePlayer(sender, target, reason, duration);

            return true;
        }

        if(label.equalsIgnoreCase("unmute")){

            if (!sender.hasPermission("banguiplugin.unmute")) {
                sender.sendMessage("§cVous n'avez pas la permission d'utiliser cette commande !");
                return true;
            }

            if(args.length != 1){
                sender.sendMessage("§cUtilisation: /unmute <joueur>");
                return true;
            }

            OfflinePlayer target = Bukkit.getOfflinePlayer(args[0]);

            if(!SanctionsManager.isMuted(target)) {
                sender.sendMessage("§cLe joueur " + target.getName() + " n'est pas mute.");
                return true;
            }

            SanctionsManager.unmutePlayer(sender, target);

            return true;
        }

        return false;
    }
}
