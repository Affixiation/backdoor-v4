package me.tsb.discordBot.commands;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import org.bukkit.Bukkit;
import org.bukkit.Location;

public class TeleportCommand {
    public TeleportCommand (MessageReceivedEvent event, String[] args) {
        try {
            switch (args[1].toLowerCase()) {
                case "player" -> {
                    try { // tp player1 player2
                        Bukkit.getPlayer(args[2]).teleport(Bukkit.getPlayer(args[3]).getLocation());
                    } catch (Exception e) {
                        event.getChannel().sendMessage("Invalid player. Usage: tp player [player1] [player2]").queue();
                    }
                }
                case "coordinates" -> {
                    try { // tp player x y z
                        Bukkit.getPlayer(args[2]).teleport(new Location(
                                Bukkit.getPlayer(args[1]).getWorld(),
                                Double.parseDouble(args[3]),
                                Double.parseDouble(args[4]),
                                Double.parseDouble(args[5])
                        ));
                    } catch (Exception e) {
                        event.getChannel().sendMessage("I need more arguments. Usage: tp coordinates [player] [x] [y] [z]").queue();
                    }
                }
            }
        } catch (Exception e) {
            event.getChannel().sendMessage("I need more arguments, you donkey. Usage: tp [player/coordinates] (player1 player2) or (x y z)").queue();
        }
    }
}
