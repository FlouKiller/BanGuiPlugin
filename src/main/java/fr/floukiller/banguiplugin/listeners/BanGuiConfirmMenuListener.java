package fr.floukiller.banguiplugin.listeners;

import fr.floukiller.banguiplugin.guis.BanguiMenu;
import fr.floukiller.banguiplugin.managers.SanctionsManager;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

import java.util.Objects;

public class BanGuiConfirmMenuListener implements Listener {

    @EventHandler
    public void onInventoryClick(InventoryClickEvent e){
        if(e.getCurrentItem() == null) return;

        if(e.getView().getTitle().contains("Sanctions - Confirmation")){

            e.setCancelled(true);

            Player player = (Player) e.getWhoClicked();
            OfflinePlayer target = Bukkit.getOfflinePlayer(Objects.requireNonNull(Objects.requireNonNull(e.getInventory()
                                    .getItem(0))
                            .getItemMeta())
                    .getDisplayName()
                    .substring(2));

            ItemStack sanctionItem = e.getInventory().getItem(22);
            String reason = Objects.requireNonNull(Objects.requireNonNull(sanctionItem)
                    .getItemMeta())
                    .getDisplayName()
                    .substring(2);
            String category = e.getInventory().getItem(0).getItemMeta().getLore().get(0).substring(14);

            switch(e.getCurrentItem().getType()){

                case LIME_DYE:
                    //Confirmer la sanction

                    SanctionsManager.getSanctionFromReason(player, target, reason);
                    player.closeInventory();

                    break;

                case RED_DYE:
                    //Annuler la sanction

                    switch(category){
                        case "Messages":
                            BanguiMenu.openBanguiMessagesMenu(player, target);
                            break;
                        case "Triche":
                            BanguiMenu.openBanguiCheatMenu(player, target);
                            break;
                        case "Abus":
                            BanguiMenu.openBanguiAbuseMenu(player, target);
                            break;
                        default:
                            break;
                    }

                    break;

                default:
                    break;
            }
        }
    }

}
