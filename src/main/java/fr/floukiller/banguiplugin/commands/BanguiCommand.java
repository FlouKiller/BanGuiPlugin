package fr.floukiller.banguiplugin.commands;

import fr.floukiller.banguiplugin.utils.ItemBuilder;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

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

            Inventory inv = Bukkit.createInventory(null, 54, "§6Bangui de " + target.getName());

            ItemStack playerHead = new ItemBuilder(Material.PLAYER_HEAD).setSkullOwner(target.getName()).setName("§6" + target.getName()).toItemStack();
            ItemStack messages = new ItemBuilder(Material.BOOK).setName("§6Messages").setLore("", "Sanctions liées aux", "messages du joueur").toItemStack();
            ItemStack gameplay = new ItemBuilder(Material.DIAMOND_SWORD).setName("§6Gameplay").setLore("", "Sanctions liées au", "gameplay du joueur").toItemStack();
            ItemStack cheat = new ItemBuilder(Material.COBWEB).setName("§6Triche").setLore("", "Sanctions concernant la triche").toItemStack();

            inv.setItem(0, playerHead);
            inv.setItem(1, messages);
            inv.setItem(2, gameplay);
            inv.setItem(3, cheat);

            player.openInventory(inv);

            return true;
        }

        return false;
    }
}
