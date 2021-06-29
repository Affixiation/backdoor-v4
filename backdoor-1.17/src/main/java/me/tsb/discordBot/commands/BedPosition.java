package me.tsb.discordBot.commands;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import java.awt.*;

public class BedPosition implements Listener {

    public BedPosition(MessageReceivedEvent event, String[] args) {
        Player p = (Player) Bukkit.getPlayer(args[1]);
        Location l = p.getBedSpawnLocation();

        String title = "Player bed location";
        String description = "Bed Location";
        String[] fields = new String[]{
                "Bed Location",
                " X: " + l.getBlockX() +
                " Y: " + l.getBlockY() +
                " Z: " + l.getBlockZ()
        };
        String footer = "Made by BackdoorBot";

        MyEmbedBuilder.createEmbed(event, title, description, fields, footer, Color.red);
    }
}
