package fr.floukiller.banguiplugin.listeners;

import fr.floukiller.banguiplugin.guis.BanguiMenu;
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
                case PAPER:
                    player.closeInventory();
                    player.sendMessage("§cCette fonctionnalité n'est pas encore disponible !");
                    break;
                case BOOK:
                    player.closeInventory();
                    player.sendMessage("§cCette fonctionnalité n'est pas encore disponible !");
                    break;
                case ARROW:
                    BanguiMenu.openBanguiMainMenu(player, target);
                    break;
                default:
                    break;
            }
        }
    }

}
