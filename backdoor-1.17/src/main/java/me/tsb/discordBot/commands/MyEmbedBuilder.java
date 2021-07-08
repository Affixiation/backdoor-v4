package me.tsb.discordBot.commands;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

import java.awt.*;

public class MyEmbedBuilder {

    public static void createEmbed(MessageReceivedEvent event, String title, String description, String[] fields, String footer, Color color) {

        EmbedBuilder eb = new net.dv8tion.jda.api.EmbedBuilder();

        // ############
        // Embed Title
        try { eb.setTitle(title); }
        catch (Exception e)
        {
            eb.setTitle("Empty Title");
            e.printStackTrace();
            System.out.println("\n Empty Title");
        }
        // ############

        // ############
        // Embed Description
        try {
            eb.setDescription(description);
        }
        catch (Exception e) {
            eb.setDescription("Empty Description");
        }
        // ############

        // ############
        // Embed Field
        try {
            for (int i = 0; i < fields.length; i += 2)
                eb.addField(fields[i], fields[i + 1], false);
        }
        catch (Exception e) {
            eb.addField("Empty Field Name", "Empty Field Value", false);
        }
        // ############

        // ############
        // Embed Footer
        try {
            eb.setFooter(footer);
        }
        catch (Exception e) {
            eb.setFooter("Empty Footer");
        }
        // ############

        // ############
        // Embed Color
        try {
            eb.setColor(color);
        }
        catch (Exception e) {
            eb.setColor(Color.white);
        }
        // ############

        // ############
        // Embed Build/Send
        try {
            event.getChannel().sendMessage(eb.build()).queue();
        }
        catch (Exception e) {
            event.getChannel().sendMessage("Failed to send embed").queue();
        }
        // ############

        // ############
        // Embed Clear
        try {
            eb.clear();
        } catch (Exception e) {
            event.getChannel().sendMessage("Failed to clear embed");
        }
        // ############
    }

}
