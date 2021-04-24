package me.kmatias.backdoor.events;

import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.AnvilInventory;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryView;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

// this is pasted from a spigotmc thread from what i remember
public class InventoryEvent implements Listener {

    @EventHandler(priority = EventPriority.HIGH)
    public void onInventoryClick(InventoryClickEvent event) {
        // check if the event has been cancelled by another plugin
        if (!event.isCancelled()) {
            HumanEntity entity = event.getWhoClicked();

            // not really necessary
            if (entity instanceof Player) {
                Player player = (Player) entity;
                Inventory inv = event.getInventory();

                // see if the event is about an anvil
                if (inv instanceof AnvilInventory) {
                    InventoryView view = event.getView();
                    int rawSlot = event.getRawSlot();

                    // compare the raw slot with the inventory view to make sure we are talking about the upper inventory
                    if (rawSlot == view.convertSlot(rawSlot)) {
                        /*
                        slot 0 = left item slot
                        slot 1 = right item slot
                        slot 2 = result item slot

                        see if the player clicked in the result item slot of the anvil inventory
                        */
                        if (rawSlot == 2) {
                            /*
                            get the current item in the result slot
                            I think inv.getItem(rawSlot) would be possible too
                            */
                            ItemStack item = event.getCurrentItem();

                            // check if there is an item in the result slot
                            if (item != null) {
                                ItemMeta meta = item.getItemMeta();

                                // it is possible that the item does not have meta data
                                if (meta != null) {
                                    // see whether the item is beeing renamed
                                    if (meta.hasDisplayName()) {
                                        String displayName = meta.getDisplayName();
                                        // TODO: event for renaming an item in an anvil
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
