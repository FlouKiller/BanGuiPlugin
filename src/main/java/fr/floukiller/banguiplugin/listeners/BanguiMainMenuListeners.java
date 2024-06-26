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

public class BanguiMainMenuListeners implements Listener {

    @EventHandler
    public void onInventoryClick(InventoryClickEvent e){
        if(e.getCurrentItem() == null) return;

        if(e.getView().getTitle().contains("Menu de sanctions")){

            e.setCancelled(true);

            Player player = (Player) e.getWhoClicked();
            OfflinePlayer target = Bukkit.getOfflinePlayer(Objects.requireNonNull(Objects.requireNonNull(e.getInventory()
                    .getItem(0))
                    .getItemMeta())
                    .getDisplayName()
                    .substring(2));

            switch(e.getCurrentItem().getType()){
                case PAPER:
                    BanguiMenu.openBanguiMessagesMenu(player, target);
                    break;
                case ENCHANTED_GOLDEN_APPLE:
                    BanguiMenu.openBanguiCheatMenu(player, target);
                    break;
                case LAVA_BUCKET:
                    BanguiMenu.openBanguiAbuseMenu(player, target);
                    break;
                case DARK_OAK_DOOR:
                    player.closeInventory();
                    break;
                default:
                    break;
            }
        }
    }

}
