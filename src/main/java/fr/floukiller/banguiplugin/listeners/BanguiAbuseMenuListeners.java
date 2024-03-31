package fr.floukiller.banguiplugin.listeners;

import fr.floukiller.banguiplugin.guis.BanguiMenu;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class BanguiAbuseMenuListeners implements Listener {

    @EventHandler
    public void onInventoryClick(InventoryClickEvent e){
        if(e.getCurrentItem() == null) return;

        if(e.getView().getTitle().contains("Sanctions - Abus")){

            e.setCancelled(true);

            Player player = (Player) e.getWhoClicked();
            OfflinePlayer target = Bukkit.getOfflinePlayer(e.getInventory().getItem(0).getItemMeta().getDisplayName().substring(2));

            switch(e.getCurrentItem().getType()){
                case ZOMBIE_HEAD:
                    //reportAbuse
                    player.sendMessage("§cCette fonctionnalité n'est pas encore disponible");
                    player.closeInventory();
                    break;
                case STONE_SWORD:
                    //badReport
                    player.sendMessage("§cCette fonctionnalité n'est pas encore disponible");
                    player.closeInventory();
                    break;
                case LEATHER_CHESTPLATE:
                    //badSkin
                    player.sendMessage("§cCette fonctionnalité n'est pas encore disponible");
                    player.closeInventory();
                    break;
                case NAME_TAG:
                    //badUsername
                    player.sendMessage("§cCette fonctionnalité n'est pas encore disponible");
                    player.closeInventory();
                    break;
                case STONE_BRICKS:
                    //badBuild
                    player.sendMessage("§cCette fonctionnalité n'est pas encore disponible");
                    player.closeInventory();
                    break;
                case ARROW:
                    //back
                    BanguiMenu.openBanguiMainMenu(player, target);
                    break;
                default:
                    break;
            }
        }
    }
}
