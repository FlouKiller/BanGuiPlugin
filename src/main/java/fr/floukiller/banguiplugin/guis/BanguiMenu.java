package fr.floukiller.banguiplugin.guis;

import fr.floukiller.banguiplugin.utils.ItemBuilder;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class BanguiMenu {

    public static void openBanguiMainMenu(Player player, OfflinePlayer target){
        Inventory inv = Bukkit.createInventory(null, 54, "Sanctions");

        ItemStack playerHead = new ItemBuilder(Material.PLAYER_HEAD).setSkullOwner(target.getName()).setName("§6" + target.getName()).toItemStack();
        ItemStack messages = new ItemBuilder(Material.BOOK).setName("§6Messages").setLore("", "§fSanctions liées aux", "§fmessages du joueur").toItemStack();
        ItemStack gameplay = new ItemBuilder(Material.DIAMOND_SWORD).setName("§6Gameplay").setLore("", "§fSanctions liées au", "§fgameplay du joueur").toItemStack();
        ItemStack cheat = new ItemBuilder(Material.COBWEB).setName("§6Triche").setLore("", "§fSanctions concernant la triche").toItemStack();
        ItemStack close = new ItemBuilder(Material.BARRIER).setName("§cFermer").toItemStack();

        inv.setItem(0, playerHead);
        inv.setItem(1, messages);
        inv.setItem(2, gameplay);
        inv.setItem(3, cheat);
        inv.setItem(53, close);

        player.openInventory(inv);
    }

    public static void openBanguiMessagesMenu(Player player, OfflinePlayer target){
        Inventory inv = Bukkit.createInventory(null, 54, "Sanctions - Messages");

        ItemStack playerHead = new ItemBuilder(Material.PLAYER_HEAD).setSkullOwner(target.getName()).setName("§6" + target.getName()).toItemStack();
        ItemStack spam = new ItemBuilder(Material.PAPER).setName("§6Spam").setLore("", "§fSanctions liées au", "§fspam du joueur").toItemStack();
        ItemStack insult = new ItemBuilder(Material.PAPER).setName("§6Insultes").setLore("", "§fSanctions liées aux", "§finsultes du joueur").toItemStack();
        ItemStack pub = new ItemBuilder(Material.PAPER).setName("§6Publicité").setLore("", "§fSanctions liées à la", "§fpublicité du joueur").toItemStack();
        ItemStack back = new ItemBuilder(Material.ARROW).setName("§cRetour").toItemStack();

        inv.setItem(0, playerHead);
        inv.setItem(1, spam);
        inv.setItem(2, insult);
        inv.setItem(3, pub);
        inv.setItem(53, back);

        player.openInventory(inv);
    }

}
