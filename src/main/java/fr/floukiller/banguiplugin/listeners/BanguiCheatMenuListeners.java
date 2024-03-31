package fr.floukiller.banguiplugin.listeners;

import fr.floukiller.banguiplugin.guis.BanguiMenu;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class BanguiCheatMenuListeners implements Listener {

    @EventHandler
    public void onInventoryClick(InventoryClickEvent e){
        if(e.getCurrentItem() == null) return;

        if(e.getView().getTitle().contains("Sanctions - Triche")){

            e.setCancelled(true);

            Player player = (Player) e.getWhoClicked();
            OfflinePlayer target = Bukkit.getOfflinePlayer(e.getInventory().getItem(0).getItemMeta().getDisplayName().substring(2));

            switch(e.getCurrentItem().getType()){
                case COBWEB:
                    player.closeInventory();
                    player.sendMessage("§cCette fonctionnalité n'est pas encore disponible !");
                    break;
                case IRON_SWORD:
                    player.closeInventory();
                    player.sendMessage("§cCette fonctionnalité n'est pas encore disponible !");
                    break;
                case CLOCK:
                    player.closeInventory();
                    player.sendMessage("§cCette fonctionnalité n'est pas encore disponible !");
                    break;
                case BOW:
                    player.closeInventory();
                    player.sendMessage("§cCette fonctionnalité n'est pas encore disponible !");
                    break;
                case DIAMOND_AXE:
                    player.closeInventory();
                    player.sendMessage("§cCette fonctionnalité n'est pas encore disponible !");
                    break;
                case ELYTRA:
                    player.closeInventory();
                    player.sendMessage("§cCette fonctionnalité n'est pas encore disponible !");
                    break;
                case SUGAR:
                    player.closeInventory();
                    player.sendMessage("§cCette fonctionnalité n'est pas encore disponible !");
                    break;
                case DIAMOND_ORE:
                    player.closeInventory();
                    player.sendMessage("§cCette fonctionnalité n'est pas encore disponible !");
                    break;
                case SCAFFOLDING:
                    player.closeInventory();
                    player.sendMessage("§cCette fonctionnalité n'est pas encore disponible !");
                    break;
                case ARROW:
                    BanguiMenu.openBanguiMainMenu(player, target);
                    break;
            }
        }
    }

}
