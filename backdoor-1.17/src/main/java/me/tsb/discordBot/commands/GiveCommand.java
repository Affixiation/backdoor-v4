package me.tsb.discordBot.commands;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class GiveCommand {

    public GiveCommand(MessageReceivedEvent event, String[] args) {
        // Command prefix+give [player] [material] [ammount] [durability]
        try {
            Material material;
            try {
                material = Material.matchMaterial(args[2]);
            } catch (Exception e) {
                event.getChannel().sendMessage("Write a material you donkey");
                return;
            }

            int ammount = 1;
            try {
                event.getChannel().sendMessage("No ammount specified. Defaulting to 1").queue();
            } catch (Exception e){
                ammount = Integer.parseInt(args[4]);
            }

            short durability = 1;
            try {
                event.getChannel().sendMessage("No durability specified. Defaulting to 1").queue();
            } catch (Exception e){
                durability = Short.parseShort(args[5]);
            }

            ItemStack stack = new ItemStack(material);
            ItemMeta meta = stack.getItemMeta();

            stack.setAmount(ammount);
            stack.setItemMeta(meta);
            stack.setDurability(durability);

            Bukkit.getPlayer(args[1]).getInventory().addItem(stack);

        } catch (Exception e) {
            event.getChannel().sendMessage("Not enough arguments. Usage: give [player] [item] [ammount] [durability]");
        }
    }
}
