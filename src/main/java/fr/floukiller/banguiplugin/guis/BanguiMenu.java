package fr.floukiller.banguiplugin.guis;

import fr.floukiller.banguiplugin.utils.ItemBuilder;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Collections;
import java.util.Objects;

public class BanguiMenu {

    public static void openBanguiMainMenu(Player player, OfflinePlayer target){
        Inventory inv = Bukkit.createInventory(null, 54, "Menu de sanctions");

        ItemStack playerHead = null;
        if(target.isOnline()){
            Player onlineTarget = (Player) target;
            playerHead = new ItemBuilder(Material.PLAYER_HEAD, 1, (short)3).setSkullOwner(target.getName()).setName("§b" + target.getName()).setLore("§aEn ligne", "§fVie : " + onlineTarget.getHealth(), "§fNourriture : " + onlineTarget.getFoodLevel(), "§fIP : " + onlineTarget.getAddress().toString().split(":")[0].substring(1)).toItemStack();
        } else {
            playerHead = new ItemBuilder(Material.PLAYER_HEAD, 1, (short)3).setSkullOwner(target.getName()).setName("§b" + target.getName()).setLore("§7Hors ligne").toItemStack();
        }
        ItemStack messages = new ItemBuilder(Material.PAPER, 1).setName("§6Messages").setLore("§fSanctions liées au §bcontenu §fd'un", "§fmessage", "", "§a> §fClic gauche pour ouvrir").toItemStack();
        ItemStack cheat = new ItemBuilder(Material.ENCHANTED_GOLDEN_APPLE, 1).setName("§6Triche").setLore("§fSanctions liées à la l'utilisation d'§bun", "§bmode de triche§f.", "", "§a> §fClic gauche pour ouvrir").toItemStack();
        ItemStack abuse = new ItemBuilder(Material.LAVA_BUCKET, 1).setName("§6Abus").setLore("§fAbus de la part d'un joueur.", "", "§a> §fClic gauche pour ouvrir").toItemStack();
        ItemStack close = new ItemBuilder(Material.DARK_OAK_DOOR, 1).setName("§cFermer").setLore("§7Fermer le menu").toItemStack();

        inv.setItem(0, playerHead);
        inv.setItem(1, messages);
        inv.setItem(2, cheat);
        inv.setItem(3, abuse);
        inv.setItem(53, close);

        player.openInventory(inv);
    }

    public static void openBanguiMessagesMenu(Player player, OfflinePlayer target){
        Inventory inv = Bukkit.createInventory(null, 54, "Sanctions - Messages");

        ItemStack playerHead = new ItemBuilder(Material.PLAYER_HEAD, 1, (short)3).setSkullOwner(target.getName()).setName("§b" + target.getName()).setLore("§7Catégorie : Messages").toItemStack();
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
        ItemStack irlMenace = new ItemBuilder(Material.WITHER_SKELETON_SKULL, 1).setName("§6Menace IRL").setLore("§fMenace IRL sur un autre joueur", "§f(Menaces physiques, etc...)", "", "§a> §fClic gauche pour appliquer").toItemStack();
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

    public static void openBanguiCheatMenu(Player player, OfflinePlayer target) {
        Inventory inv = Bukkit.createInventory(null, 54, "Sanctions - Triche");

        ItemStack playerHead = new ItemBuilder(Material.PLAYER_HEAD, 1, (short)3).setSkullOwner(target.getName()).setName("§b" + target.getName()).setLore("§7Catégorie : Triche").toItemStack();
        ItemStack antiKb = new ItemBuilder(Material.COBWEB, 1).setName("§6Triche : Anti-Knockback").setLore("§fUtilisation d'un anti-knockback", "§fpermettant de ne pas reculer", "§flors d'un coup", "", "§a> §fClic gauche pour appliquer").toItemStack();
        ItemStack killAura = new ItemBuilder(Material.IRON_SWORD, 1).setName("§6Triche : KillAura").setLore("§fUtilisation d'un KillAura", "§fpermettant de frapper et viser", "§fautomatiquement", "", "§a> §fClic gauche pour appliquer").toItemStack();
        ItemStack timer = new ItemBuilder(Material.CLOCK, 1).setName("§6Triche : Timer").setLore("§fUtilisation d'un timer", "§fpermettant d'augmenter la vitesse", "§fdu jeu pour faire certaines actions", "", "§a> §fClic gauche pour appliquer").toItemStack();
        ItemStack reach = new ItemBuilder(Material.BOW, 1).setName("§6Triche : Reach").setLore("§fUtilisation d'un reach", "§fpermettant de frapper plus loin", "", "§a> §fClic gauche pour appliquer").toItemStack();
        ItemStack macro = new ItemBuilder(Material.DIAMOND_AXE, 1).setName("§6Triche : Macro").setLore("§fUtilisation d'une macro", "§fpermettant de cliquer très", "§frapidement et automatiquement", "", "§a> §fClic gauche pour appliquer").toItemStack();
        ItemStack fly = new ItemBuilder(Material.ELYTRA, 1).setName("§6Triche : Fly").setLore("§fUtilisation d'un fly", "§fpermettant de voler", "", "§a> §fClic gauche pour appliquer").toItemStack();
        ItemStack speedhack = new ItemBuilder(Material.SUGAR, 1).setName("§6Triche : Speedhack").setLore("§fUtilisation d'un speedhack", "§fpermettant de courir plus vite", "", "§a> §fClic gauche pour appliquer").toItemStack();
        ItemStack xray = new ItemBuilder(Material.DIAMOND_ORE, 1).setName("§6Triche : X-Ray").setLore("§fUtilisation d'un X-Ray", "§fpermettant de voir à travers les blocs", "", "§a> §fClic gauche pour appliquer").toItemStack();
        ItemStack scaffold = new ItemBuilder(Material.SCAFFOLDING, 1).setName("§6Triche : Scaffold").setLore("§fUtilisation d'un scaffold", "§fpermettant de construire plus rapidement", "", "§a> §fClic gauche pour appliquer").toItemStack();
        ItemStack back = new ItemBuilder(Material.ARROW, 1).setName("§aRetour").toItemStack();

        inv.setItem(0, playerHead);
        inv.setItem(1, antiKb);
        inv.setItem(2, killAura);
        inv.setItem(3, timer);
        inv.setItem(4, reach);
        inv.setItem(5, macro);
        inv.setItem(6, fly);
        inv.setItem(7, speedhack);
        inv.setItem(8, xray);
        inv.setItem(9, scaffold);
        inv.setItem(53, back);

        player.openInventory(inv);

    }

    public static void openBanguiAbuseMenu(Player player, OfflinePlayer target){
        Inventory inv = Bukkit.createInventory(null, 54, "Sanctions - Abus");

        ItemStack playerHead = new ItemBuilder(Material.PLAYER_HEAD, 1, (short)3).setSkullOwner(target.getName()).setName("§b" + target.getName()).setLore("§7Catégorie : Abus").toItemStack();
        ItemStack reportAbuse = new ItemBuilder(Material.ZOMBIE_HEAD, 1).setName("§6Abus de report").setLore("§fAbus de la commande /report", "§futilisée pour signaler un joueur", "§fà tort", "", "§a> §fClic gauche pour appliquer").toItemStack();
        ItemStack badReport = new ItemBuilder(Material.STONE_SWORD, 1).setName("§6Report quelque chose d'autorisé").setLore("§fReport délibérément quelque chose qui", "§fn'est pas interdit sur le serveur", "", "§a> §fClic gauche pour appliquer").toItemStack();
        ItemStack badSkin = new ItemBuilder(Material.LEATHER_CHESTPLATE, 1).setName("§6Skin inapproprié").setLore("§fUtilisation d'un skin inapproprié", "§fou choquant", "", "§a> §fClic gauche pour appliquer").toItemStack();
        ItemStack badUsername = new ItemBuilder(Material.NAME_TAG, 1).setName("§6Pseudo inapproprié").setLore("§fUtilisation d'un pseudo inapproprié", "§fou choquant", "", "§a> §fClic gauche pour appliquer").toItemStack();
        ItemStack badBuild = new ItemBuilder(Material.STONE_BRICKS, 1).setName("§6Construction inappropriée").setLore("§fConstruction inappropriée", "§fou choquante", "", "§a> §fClic gauche pour appliquer").toItemStack();
        ItemStack back = new ItemBuilder(Material.ARROW, 1).setName("§aRetour").toItemStack();

        inv.setItem(0, playerHead);
        inv.setItem(1, reportAbuse);
        inv.setItem(2, badReport);
        inv.setItem(3, badSkin);
        inv.setItem(4, badUsername);
        inv.setItem(5, badBuild);
        inv.setItem(53, back);

        player.openInventory(inv);
    }

    public static void openBanguiConfirmMenu(Player player, OfflinePlayer target, ItemStack sanctionItem, String category){
        Inventory inv = Bukkit.createInventory(null, 54, "Sanctions - Confirmation");

        ItemStack playerHead = new ItemBuilder(Material.PLAYER_HEAD, 1, (short)3).setSkullOwner(target.getName()).setName("§b" + target.getName()).setLore("§7Catégorie : " + category).toItemStack();
        ItemStack confirm = new ItemBuilder(Material.LIME_DYE, 1).setName("§aConfirmer").setLore("§fConfirmer la sanction").toItemStack();
        ItemStack cancel = new ItemBuilder(Material.RED_DYE, 1).setName("§cAnnuler").setLore("§fAnnuler la sanction").toItemStack();

        int lines = Objects.requireNonNull(sanctionItem.getItemMeta()).getLore().size();
        ItemMeta meta = sanctionItem.getItemMeta();
        meta.setLore(sanctionItem.getItemMeta().getLore().subList(0, lines - 2));
        sanctionItem.setItemMeta(meta);

        inv.setItem(0, playerHead);
        inv.setItem(22, sanctionItem);
        inv.setItem(30, confirm);
        inv.setItem(32, cancel);

        player.openInventory(inv);
    }
}
