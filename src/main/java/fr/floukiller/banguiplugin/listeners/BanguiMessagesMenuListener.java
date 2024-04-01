package fr.floukiller.banguiplugin.listeners;

import fr.floukiller.banguiplugin.guis.BanguiMenu;
import fr.floukiller.banguiplugin.managers.BanManager;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

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

            ItemStack sanctionItem;
            String category = "Messages";

            switch(e.getCurrentItem().getType()){
                case WOODEN_HOE:
                    // uselessMessage

                    sanctionItem = e.getCurrentItem();
                    BanguiMenu.openBanguiConfirmMenu(player, target, sanctionItem, category);

                    break;
                case GLASS_BOTTLE:
                    // fakeNews

                     sanctionItem = e.getCurrentItem();
                    BanguiMenu.openBanguiConfirmMenu(player, target, sanctionItem, category);

                    break;
                case ZOMBIE_HEAD:
                    // smsLanguage

                    sanctionItem = e.getCurrentItem();
                    BanguiMenu.openBanguiConfirmMenu(player, target, sanctionItem, category);

                    break;
                case TROPICAL_FISH:
                    // incorrectFormatting

                    sanctionItem = e.getCurrentItem();
                    BanguiMenu.openBanguiConfirmMenu(player, target, sanctionItem, category);

                    break;
                case TNT:
                    // flood

                    sanctionItem = e.getCurrentItem();
                    BanguiMenu.openBanguiConfirmMenu(player, target, sanctionItem, category);

                    break;
                case ROTTEN_FLESH:
                    // badLanguage

                    sanctionItem = e.getCurrentItem();
                    BanguiMenu.openBanguiConfirmMenu(player, target, sanctionItem, category);

                    break;
                case WATER_BUCKET:
                    // provocation

                    sanctionItem = e.getCurrentItem();
                    BanguiMenu.openBanguiConfirmMenu(player, target, sanctionItem, category);

                    break;
                case SKELETON_SKULL:
                    // insult

                    sanctionItem = e.getCurrentItem();
                    BanguiMenu.openBanguiConfirmMenu(player, target, sanctionItem, category);

                    break;
                case ENDER_PEARL:
                    // crimeIncitement

                    sanctionItem = e.getCurrentItem();
                    BanguiMenu.openBanguiConfirmMenu(player, target, sanctionItem, category);

                    break;
                case BOOK:
                    // bypassChatProtection

                    sanctionItem = e.getCurrentItem();
                    BanguiMenu.openBanguiConfirmMenu(player, target, sanctionItem, category);

                    break;
                case BARRIER:
                    // forbiddenLink

                    sanctionItem = e.getCurrentItem();
                    BanguiMenu.openBanguiConfirmMenu(player, target, sanctionItem, category);

                    break;
                case RED_BANNER:
                    // advertising

                    sanctionItem = e.getCurrentItem();
                    BanguiMenu.openBanguiConfirmMenu(player, target, sanctionItem, category);

                    break;
                case CARROT_ON_A_STICK:
                    // hack

                    sanctionItem = e.getCurrentItem();
                    BanguiMenu.openBanguiConfirmMenu(player, target, sanctionItem, category);

                    break;
                case WITHER_SKELETON_SKULL:
                    // irlMenace

                    sanctionItem = e.getCurrentItem();
                    BanguiMenu.openBanguiConfirmMenu(player, target, sanctionItem, category);

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
