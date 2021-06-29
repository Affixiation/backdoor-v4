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
            "Bed Position"      , prefix + "bedpositionbp/bedlocation/bl [player]",
            "Player Position"   , prefix + "playerposition/pp/playerlocation/pl [player]",
            "Enchant"           , prefix + "enchant/e [player] [item] [level]",
            "Gamemode"          , prefix + "gamemode/gm [player] [(survival/s)/(adventure/a)/(creative/c)/(spectator/sp)]",
            "Give"              , prefix + "give/g [player] [item] [ammount] [durability]",
            "Kill"              , prefix + "kill/k [player]",
            "Teleport"          , prefix + "teleport/tele/tp [player/coordinates] (player1 player2) or (x y z)"
        };
        String footer = "Made by BackdoorBot";

        MyEmbedBuilder.createEmbed(event, title, description, fields, footer, Color.red);
    }
}
