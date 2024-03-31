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
        ItemStack abuse = new ItemBuilder(Material.LAVA_BUCKET, 1).setName("§6Abus").setLore("§fAbus de la part d'un joueur.", "", "§a> §fClic gauche pour ouvrir").toItemStack();
        ItemStack close = new ItemBuilder(Material.DARK_OAK_DOOR, 1).setName("§cFermer").setLore("§7Fermer le menu").toItemStack();

        inv.setItem(0, playerHead);
        inv.setItem(1, messages);
        inv.setItem(2, gameplay);
        inv.setItem(3, cheat);
        inv.setItem(4, abuse);
        inv.setItem(53, close);

        player.openInventory(inv);
    }

    public static void openBanguiMessagesMenu(Player player, OfflinePlayer target){
        Inventory inv = Bukkit.createInventory(null, 54, "Sanctions - Messages");

        ItemStack playerHead = new ItemBuilder(Material.PLAYER_HEAD, 1, (short)3).setSkullOwner(target.getName()).setName("§b" + target.getName()).toItemStack();
        ItemStack uselessMessage = new ItemBuilder(Material.WOODEN_HOE, 1).setName("§6Message inutile").setLore("§fMessage inutile, sans intérêt", "§fAttention au contexte, ne pas", "§fsanctionner si ça ne dérange personne.", "", "§a> §fClic gauche pour appliquer").toItemStack();
        ItemStack fakeNews = new ItemBuilder(Material.GLASS_BOTTLE, 1).setName("§6Fausse information").setLore("§fDiffusion de §bfausses informations", "§fsans se renseigner ou pour troller.", "", "§a> §fClic gauche pour appliquer").toItemStack();
        ItemStack smsLanguage = new ItemBuilder(Material.ZOMBIE_HEAD, 1).setName("§6Langage SMS").setLore("§fUtilisation abusive du langage SMS", "§fou des abréviations.", "", "§a> §fClic gauche pour appliquer").toItemStack();
        ItemStack incorrectFormatting = new ItemBuilder(Material.TROPICAL_FISH, 1).setName("§6Mauvais formatage").setLore("§fTentative de mise en avant du message", "§fen contournant la protection (Maj, etc...)", "", "§a> §fClic gauche pour appliquer").toItemStack();
        ItemStack flood = new ItemBuilder(Material.TNT, 1).setName("§6Flood").setLore("§fEnvoi répété de messages", "§fsans intérêt ou pour déranger.", "", "§a> §fClic gauche pour appliquer").toItemStack();
        ItemStack badLanguage = new ItemBuilder(Material.ROTTEN_FLESH, 1).setName("§6Langage inapproprié").setLore("§fUtilisation de mots ou expressions", "§finterdits ou insultants mais", "§fsans insulter un autre joueur", "", "§a> §fClic gauche pour appliquer").toItemStack();
        ItemStack provocation = new ItemBuilder(Material.WATER_BUCKET, 1).setName("§6Provocation").setLore("§fProvocation envers un joueur", "§fsans insulter ou dénigrer.", "", "§a> §fClic gauche pour appliquer").toItemStack();
        ItemStack insult = new ItemBuilder(Material.SKELETON_SKULL, 1).setName("§6Insulte").setLore("§fInsulte envers un joueur", "", "§a> §fClic gauche pour appliquer").toItemStack();
        ItemStack crimeIncitement = new ItemBuilder(Material.ENDER_PEARL, 1).setName("§6Incitation a l'infraction").setLore("§fIncitation à commettre une infraction", "§fou a ne pas respecter une règle", "", "§a> §fClic gauche pour appliquer").toItemStack();
        ItemStack bypassChatProtection = new ItemBuilder(Material.BOOK, 1).setName("§6Contournement protection chat").setLore("§fContournement de la protection", "§fdu chat", "", "§a> §fClic gauche pour appliquer").toItemStack();
        ItemStack forbiddenLink = new ItemBuilder(Material.BARRIER, 1).setName("§6Lien interdit").setLore("§fEnvoi de lien interdit mais", "§fsans tentative de hack", "", "§a> §fClic gauche pour appliquer").toItemStack();
        ItemStack advertising = new ItemBuilder(Material.RED_BANNER, 1).setName("§6Publicité").setLore("§fPublicité pour un serveur", "§fou un site", "", "§a> §fClic gauche pour appliquer").toItemStack();
        ItemStack hack = new ItemBuilder(Material.CARROT_ON_A_STICK, 1).setName("§6DDOS ou Hack/Fake/Phishing").setLore("§fTentative de hack d'un", "§fautre utilisateur", "", "§a> §fClic gauche pour appliquer").toItemStack();
        ItemStack irlMenace = new ItemBuilder(Material.WITHER_SKELETON_SKULL, 1).setName("§6Menace IRL").setLore("§fMenace IRL", "", "§a> §fClic gauche pour appliquer").toItemStack();
        ItemStack back = new ItemBuilder(Material.ARROW, 1).setName("§aRetour").toItemStack();

        inv.setItem(0, playerHead);
        inv.setItem(1, uselessMessage);
        inv.setItem(2, fakeNews);
        inv.setItem(3, smsLanguage);
        inv.setItem(4, incorrectFormatting);
        inv.setItem(5, flood);
        inv.setItem(6, badLanguage);
        inv.setItem(7, provocation);
        inv.setItem(8, insult);
        inv.setItem(9, crimeIncitement);
        inv.setItem(10, bypassChatProtection);
        inv.setItem(11, forbiddenLink);
        inv.setItem(12, advertising);
        inv.setItem(13, hack);
        inv.setItem(14, irlMenace);
        inv.setItem(53, back);

        player.openInventory(inv);
    }

}
