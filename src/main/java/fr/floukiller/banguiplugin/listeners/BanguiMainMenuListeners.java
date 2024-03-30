package fr.floukiller.banguiplugin.listeners;

import fr.floukiller.banguiplugin.guis.BanguiMenu;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class BanguiMainMenuListeners implements Listener {

    @EventHandler
    public void onInventoryClick(InventoryClickEvent e){
        if(e.getCurrentItem() == null) return;

        if(e.getView().getTitle().contains("Sanctions")){
            e.setCancelled(true);

            Player player = (Player) e.getWhoClicked();
            OfflinePlayer target = Bukkit.getOfflinePlayer(e.getInventory().getItem(0).getItemMeta().getDisplayName().substring(2));

            switch(e.getCurrentItem().getType()){
                case BOOK:
                    BanguiMenu.openBanguiMessagesMenu(player, target);
                    break;
                case DIAMOND_SWORD:
                    //Ouvre le menu des sanctions liées au gameplay
                    break;
                case COBWEB:
                    //Ouvre le menu des sanctions liées à la triche
                    break;
                case BARRIER:
                    player.closeInventory();
                    break;
                default:
                    break;
            }
        }
    }

}
