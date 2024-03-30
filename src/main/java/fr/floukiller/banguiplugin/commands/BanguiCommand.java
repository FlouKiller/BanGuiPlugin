package fr.floukiller.banguiplugin.commands;

import fr.floukiller.banguiplugin.guis.BanguiMenu;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class BanguiCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if(label.equalsIgnoreCase("bangui")){

            if(!(sender instanceof Player player)){
                sender.sendMessage("§cVous devez être un joueur pour exécuter cette commande !");
                return true;
            }

            if (!player.hasPermission("banguiplugin.bangui")) {
                player.sendMessage("§cVous n'avez pas la permission d'utiliser cette commande !");
                return true;
            }

            if(args.length == 0){
                player.sendMessage("§cUtilisation: /bangui <joueur>");
                return true;
            }

            OfflinePlayer target = Bukkit.getOfflinePlayer(args[0]);

            if(!target.hasPlayedBefore()){
                player.sendMessage("§cCe joueur n'a jamais joué sur le serveur !");
                return true;
            }

            BanguiMenu.openBanguiMainMenu(player, target);

            return true;
        }

        return false;
    }
}
