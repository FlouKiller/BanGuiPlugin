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
        Inventory inv = Bukkit.createInventory(null, 54, "Menu de sanctions");

        ItemStack playerHead = new ItemBuilder(Material.PLAYER_HEAD, 1, (short)3).setSkullOwner(target.getName()).setName("§b" + target.getName()).toItemStack();
        ItemStack messages = new ItemBuilder(Material.PAPER, 1).setName("§6Messages").setLore("§fSanctions liées au §bcontenu §fd'un", "§fmessage", "", "§a> §fClic gauche pour ouvrir").toItemStack();
        ItemStack gameplay = new ItemBuilder(Material.IRON_SWORD, 1).setName("§6Gameplay").setLore("§fSanctions liées au §bcomportement", "§bin-game §f(Mauvais pseudo, skin, ...)", "", "§a> §fClic gauche pour ouvrir").toItemStack();
        ItemStack cheat = new ItemBuilder(Material.ENCHANTED_GOLDEN_APPLE, 1).setName("§6Triche").setLore("§fSanctions liées à la l'utilisation d'§bun", "§bmode de triche§f.", "", "§a> §fClic gauche pour ouvrir").toItemStack();
        ItemStack abus = new ItemBuilder(Material.LAVA_BUCKET, 1).setName("§6Abus").setLore("§fAbus de la part d'un joueur.", "", "§a> §fClic gauche pour ouvrir").toItemStack();
        ItemStack close = new ItemBuilder(Material.DARK_OAK_DOOR, 1).setName("§cFermer").setLore("§7Fermer le menu").toItemStack();

        inv.setItem(0, playerHead);
        inv.setItem(1, messages);
        inv.setItem(2, gameplay);
        inv.setItem(3, cheat);
        inv.setItem(4, abus);
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
