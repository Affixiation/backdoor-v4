package me.tsb.discordBot.commands;

import me.tsb.discordBot.DiscordBackdoorBot;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

import java.awt.*;

public class HelpCommand {

    public HelpCommand(MessageReceivedEvent event, String[] args) {
        String prefix = DiscordBackdoorBot.prefix;
        String title = "HELP";
        String description = "Some help on how to use the backdoor bot";
        String[] fields = new String[]{
            "Help Command"      , prefix + "help/h",
            "Bed Position"      , prefix + "bedposition/bedpos/bp/bedlocation/bedloc/bl [player]",
            "Player Position"   , prefix + "playerposition/playerpos/pp/playerlocation/playerloc/pl [player]",
            "Run Command"       , prefix + "run/r [command]"
        };
        String footer = "Made by BackdoorBot";

        MyEmbedBuilder.createEmbed(event, title, description, fields, footer, Color.red);
    }
}
