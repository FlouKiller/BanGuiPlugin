package fr.floukiller.banguiplugin.listeners;

import fr.floukiller.banguiplugin.guis.BanguiMenu;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

import java.util.Objects;

public class BanguiAbuseMenuListeners implements Listener {

    @EventHandler
    public void onInventoryClick(InventoryClickEvent e){
        if(e.getCurrentItem() == null) return;

        if(e.getView().getTitle().contains("Sanctions - Abus")){

            e.setCancelled(true);

            Player player = (Player) e.getWhoClicked();
            OfflinePlayer target = Bukkit.getOfflinePlayer(Objects.requireNonNull(Objects.requireNonNull(e.getInventory()
                    .getItem(0))
                    .getItemMeta())
                    .getDisplayName()
                    .substring(2));

            ItemStack sanctionItem;

            switch(e.getCurrentItem().getType()){
                case ZOMBIE_HEAD:
                    //reportAbuse

                    sanctionItem = e.getCurrentItem();
                    BanguiMenu.openBanguiConfirmMenu(player, target, sanctionItem);

                    break;
                case STONE_SWORD:
                    //badReport

                    sanctionItem = e.getCurrentItem();
                    BanguiMenu.openBanguiConfirmMenu(player, target, sanctionItem);

                    break;
                case LEATHER_CHESTPLATE:
                    //badSkin

                    sanctionItem = e.getCurrentItem();
                    BanguiMenu.openBanguiConfirmMenu(player, target, sanctionItem);

                    break;
                case NAME_TAG:
                    //badUsername

                    sanctionItem = e.getCurrentItem();
                    BanguiMenu.openBanguiConfirmMenu(player, target, sanctionItem);

                    break;
                case STONE_BRICKS:
                    //badBuild

                    sanctionItem = e.getCurrentItem();
                    BanguiMenu.openBanguiConfirmMenu(player, target, sanctionItem);

                    break;
                case ARROW:
                    //back

                    sanctionItem = e.getCurrentItem();
                    BanguiMenu.openBanguiConfirmMenu(player, target, sanctionItem);

                    break;
                default:
                    break;
            }
        }
    }
}
