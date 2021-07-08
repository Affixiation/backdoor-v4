package me.tsb.discordBot.commands;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;

public class GamemodeCommand {
    public GamemodeCommand(MessageReceivedEvent event, String[] args) {
        try {
            GameMode gameMode = GameMode.SURVIVAL;
            try {
                switch (args[2].toLowerCase()) {
                    case "survival", "s" -> {
                        gameMode = GameMode.SURVIVAL;
                    }
                    case "adventure", "a" -> {
                        gameMode = GameMode.ADVENTURE;
                    }
                    case "creative", "c" -> {
                        gameMode = GameMode.CREATIVE;
                    }
                    case "spectator", "sp" -> {
                        gameMode = GameMode.SPECTATOR;
                    }
                }
            } catch (Exception e) {
                event.getChannel().sendMessage("No gamemode selected. defaulting to Survival. Usage: gamemode [player] [gamemode]");
            }
            Bukkit.getPlayer(args[1]).setGameMode(gameMode);
        } catch (Exception e) {
            event.getChannel().sendMessage("I need more arguments. Usage: gamemode [player] [gamemode]");
        }
    }
}
