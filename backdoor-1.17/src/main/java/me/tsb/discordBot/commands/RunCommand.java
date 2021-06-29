package me.tsb.discordBot.commands;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import org.bukkit.Bukkit;
import org.bukkit.command.ConsoleCommandSender;

import java.awt.*;

public class RunCommand {

    public RunCommand(MessageReceivedEvent event, String[] args)
    {
        String title = "Run Command";
        String description = "Run command as console";
        String[] fields = null;
        String footer = "Made by BackdoorBot";

       try {
            String command = "";
            ConsoleCommandSender console = Bukkit.getServer().getConsoleSender();
            for (int i = 1; i < args.length; i++)
                command += args[i] + " ";
            Bukkit.dispatchCommand(console, "say hello");
            fields = new String[]{"Ran command as console", command};
        } catch (Exception e) {
            e.printStackTrace();
            fields = new String[]{"Failed to send command as console", "not enough arguments"};
        }

        MyEmbedBuilder.createEmbed(event, title, description, fields, footer, Color.red);
    }
}
