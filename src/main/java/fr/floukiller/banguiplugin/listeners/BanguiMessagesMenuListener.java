package fr.floukiller.banguiplugin.listeners;

import fr.floukiller.banguiplugin.guis.BanguiMenu;
import fr.floukiller.banguiplugin.managers.BanManager;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import java.util.Objects;

public class BanguiMessagesMenuListener implements Listener {

    @EventHandler
    public void onInventoryClick(InventoryClickEvent e){
        if(e.getCurrentItem() == null) return;

        if(e.getView().getTitle().contains("Messages")){
            e.setCancelled(true);

            Player player = (Player) e.getWhoClicked();
            OfflinePlayer target = Bukkit.getOfflinePlayer(Objects.requireNonNull(Objects.requireNonNull(e.getInventory()
                                    .getItem(0))
                                    .getItemMeta())
                                    .getDisplayName()
                                    .substring(2));

            switch(e.getCurrentItem().getType()){
                case WOODEN_HOE:
                    // uselessMessage
                    player.closeInventory();
                    player.sendMessage("§cCette fonctionnalité n'est pas encore disponible");
                    break;
                case GLASS_BOTTLE:
                    // fakeNews
                    player.closeInventory();
                    player.sendMessage("§cCette fonctionnalité n'est pas encore disponible");
                    break;
                case ZOMBIE_HEAD:
                    // smsLanguage
                    player.closeInventory();
                    player.sendMessage("§cCette fonctionnalité n'est pas encore disponible");
                    break;
                case TROPICAL_FISH:
                    // incorrectFormatting
                    player.closeInventory();
                    player.sendMessage("§cCette fonctionnalité n'est pas encore disponible");
                    break;
                case TNT:
                    // flood
                    player.closeInventory();
                    player.sendMessage("§cCette fonctionnalité n'est pas encore disponible");
                    break;
                case ROTTEN_FLESH:
                    // badLanguage
                    player.closeInventory();
                    player.sendMessage("§cCette fonctionnalité n'est pas encore disponible");
                    break;
                case WATER_BUCKET:
                    // provocation
                    player.closeInventory();
                    player.sendMessage("§cCette fonctionnalité n'est pas encore disponible");
                    break;
                case SKELETON_SKULL:
                    // insult
                    player.closeInventory();
                    player.sendMessage("§cCette fonctionnalité n'est pas encore disponible");
                    break;
                case ENDER_PEARL:
                    // crimeIncitement
                    player.closeInventory();
                    player.sendMessage("§cCette fonctionnalité n'est pas encore disponible");
                    break;
                case BOOK:
                    // bypassChatProtection
                    player.closeInventory();
                    player.sendMessage("§cCette fonctionnalité n'est pas encore disponible");
                    break;
                case BARRIER:
                    // forbiddenLink
                    BanManager.banPlayer(player, target, "Publicité interdite", 24);
                    player.closeInventory();
                    break;
                case RED_BANNER:
                    // advertising
                    player.closeInventory();
                    player.sendMessage("§cCette fonctionnalité n'est pas encore disponible");
                    break;
                case CARROT_ON_A_STICK:
                    // hack
                    BanManager.banPlayer(player, target, "Tentative ou menace de hack", 24*30);
                    player.closeInventory();
                    break;
                case WITHER_SKELETON_SKULL:
                    // irlMenace
                    BanManager.banPlayer(player, target, "Menace IRL", -1);
                    player.closeInventory();
                    break;
                case ARROW:
                    // back
                    BanguiMenu.openBanguiMainMenu(player, target);
                    break;
                default:
                    break;
            }
        }
    }

}
