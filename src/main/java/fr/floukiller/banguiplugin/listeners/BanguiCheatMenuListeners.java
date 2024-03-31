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
                    //AntiKnockback
                    player.closeInventory();
                    player.sendMessage("§cCette fonctionnalité n'est pas encore disponible");
                    break;
                case IRON_SWORD:
                    //KillAura
                    player.closeInventory();
                    player.sendMessage("§cCette fonctionnalité n'est pas encore disponible");
                    break;
                case CLOCK:
                    //Timer
                    player.closeInventory();
                    player.sendMessage("§cCette fonctionnalité n'est pas encore disponible");
                    break;
                case BOW:
                    //Reach
                    player.closeInventory();
                    player.sendMessage("§cCette fonctionnalité n'est pas encore disponible");
                    break;
                case DIAMOND_AXE:
                    //Macro
                    player.closeInventory();
                    player.sendMessage("§cCette fonctionnalité n'est pas encore disponible");
                    break;
                case ELYTRA:
                    //Fly
                    player.closeInventory();
                    player.sendMessage("§cCette fonctionnalité n'est pas encore disponible");
                    break;
                case SUGAR:
                    //Speedhack
                    player.closeInventory();
                    player.sendMessage("§cCette fonctionnalité n'est pas encore disponible");
                    break;
                case DIAMOND_ORE:
                    //Xray
                    player.closeInventory();
                    player.sendMessage("§cCette fonctionnalité n'est pas encore disponible");
                    break;
                case SCAFFOLDING:
                    //Scaffold
                    player.closeInventory();
                    player.sendMessage("§cCette fonctionnalité n'est pas encore disponible");
                    break;
                case ARROW:
                    //Back
                    BanguiMenu.openBanguiMainMenu(player, target);
                    break;
            }
        }
    }

}
