package me.tsb.discordBot.commands;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import org.bukkit.Bukkit;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.meta.ItemMeta;

public class EnchantCommand {

    public EnchantCommand(MessageReceivedEvent event, String[] args) {
        try {
            int enchantLevel = 1;
            Enchantment enchant = Enchantment.getByName(args[2]);
            Player player = Bukkit.getPlayer(args[1]);
            ItemMeta meta = player.getInventory().getItemInMainHand().getItemMeta();
            if (meta == null) {
                event.getChannel().sendMessage("ItemMeta is null").queue();
                return;
            }

            try {
                enchantLevel = Integer.parseInt(args[3]);
            }
            catch (Exception e) {
                event.getChannel().sendMessage("That is not a number").queue();
                enchantLevel = 1;
            }

            meta.addEnchant(Enchantment.getByName(args[2]), enchantLevel, true);

            player.getInventory().getItemInMainHand().setItemMeta(meta);

        } catch (Exception e){
            event.getChannel().sendMessage("Not enough args. Usage: enchant [player] [enchant] [level]");
        }
    }

}
