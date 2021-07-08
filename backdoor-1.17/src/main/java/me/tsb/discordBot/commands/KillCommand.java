package me.tsb.discordBot.commands;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class KillCommand {
    public KillCommand(MessageReceivedEvent event, String[] args) {
        try {
            Player target = Bukkit.getPlayer(args[1]);
            target.setHealth(0);
        } catch (Exception e) {
            event.getChannel().sendMessage("I need more arguments, you donkey. Usage: kill [player]").queue();
        }
    }
}
