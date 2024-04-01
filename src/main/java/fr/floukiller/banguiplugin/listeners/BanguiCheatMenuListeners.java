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

public class BanguiCheatMenuListeners implements Listener {

    @EventHandler
    public void onInventoryClick(InventoryClickEvent e){
        if(e.getCurrentItem() == null) return;

        if(e.getView().getTitle().contains("Sanctions - Triche")){

            e.setCancelled(true);

            Player player = (Player) e.getWhoClicked();
            OfflinePlayer target = Bukkit.getOfflinePlayer(Objects.requireNonNull(Objects.requireNonNull(e.getInventory()
                    .getItem(0))
                    .getItemMeta())
                    .getDisplayName()
                    .substring(2));

            ItemStack sanctionItem;
            String category = "Triche";

            switch(e.getCurrentItem().getType()){
                case COBWEB:
                    //AntiKnockback

                    sanctionItem = e.getCurrentItem();
                    BanguiMenu.openBanguiConfirmMenu(player, target, sanctionItem, category);

                    break;
                case IRON_SWORD:
                    //KillAura

                    sanctionItem = e.getCurrentItem();
                    BanguiMenu.openBanguiConfirmMenu(player, target, sanctionItem, category);

                    break;
                case CLOCK:
                    //Timer

                    sanctionItem = e.getCurrentItem();
                    BanguiMenu.openBanguiConfirmMenu(player, target, sanctionItem, category);

                    break;
                case BOW:
                    //Reach

                    sanctionItem = e.getCurrentItem();
                    BanguiMenu.openBanguiConfirmMenu(player, target, sanctionItem, category);

                    break;
                case DIAMOND_AXE:
                    //Macro

                    sanctionItem = e.getCurrentItem();
                    BanguiMenu.openBanguiConfirmMenu(player, target, sanctionItem, category);

                    break;
                case ELYTRA:
                    //Fly

                    sanctionItem = e.getCurrentItem();
                    BanguiMenu.openBanguiConfirmMenu(player, target, sanctionItem, category);

                    break;
                case SUGAR:
                    //Speedhack

                    sanctionItem = e.getCurrentItem();
                    BanguiMenu.openBanguiConfirmMenu(player, target, sanctionItem, category);

                    break;
                case DIAMOND_ORE:
                    //Xray

                    sanctionItem = e.getCurrentItem();
                    BanguiMenu.openBanguiConfirmMenu(player, target, sanctionItem, category);

                    break;
                case SCAFFOLDING:
                    //Scaffold

                    sanctionItem = e.getCurrentItem();
                    BanguiMenu.openBanguiConfirmMenu(player, target, sanctionItem, category);

                    break;
                case ARROW:
                    //Back

                    BanguiMenu.openBanguiMainMenu(player, target);

                    break;
                default:
                    break;
            }
        }
    }

}
