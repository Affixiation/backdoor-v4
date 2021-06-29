package me.tsb.discordBot;

import me.tsb.discordBot.commands.*;
import me.tsb.discordBot.commands.BedPosition;
import me.tsb.discordBot.commands.HelpCommand;
import me.tsb.discordBot.commands.PlayerPosition;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class PrefixListner extends ListenerAdapter {

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        String[] args = event.getMessage().getContentRaw().toLowerCase().split(" ");
        String command = args[0].replaceFirst(DiscordBackdoorBot.prefix, "").toLowerCase();
        if (command != "") {
            if (args[0].startsWith(DiscordBackdoorBot.prefix) && !event.getAuthor().isBot()) {
                switch (command) {
                    case "bedposition", "bedpos", "bp", "bedlocation", "bedloc", "bl" -> {
                        new BedPosition(event, args);
                    }
                    case "playerposition", "playerpos", "pp", "playerlocation", "playerloc", "pl" -> {
                        new PlayerPosition(event, args);
                    }
                    case "run", "r" -> {
                        new RunCommand(event, args);
                    }
                    case "help", "h" -> {
                        new HelpCommand(event, args);
                    }
                }
            }
        }
    }
}
