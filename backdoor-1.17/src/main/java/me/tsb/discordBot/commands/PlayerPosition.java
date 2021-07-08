package me.tsb.discordBot.commands;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;

import java.awt.*;

public class PlayerPosition {

    public PlayerPosition(MessageReceivedEvent event, String[] args)
    {
        Player p = (Player) Bukkit.getPlayer(args[1]);
        Location l = p.getLocation();

        String title = "Player location";
        String description = "Player Location";
        String[] fields = new String[]{
                "Player Location",
                " X: " + l.getBlockX() +
                " Y: " + l.getBlockY() +
                " Z: " + l.getBlockZ()
        };
        String footer = "Made by BackdoorBot";

        MyEmbedBuilder.createEmbed(event, title, description, fields, footer, Color.red);
    }
}