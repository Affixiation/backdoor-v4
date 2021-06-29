package me.tsb.discordBot.commands;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

import java.awt.*;

public class MyEmbedBuilder {

    public static void createEmbed(MessageReceivedEvent event, String title, String description, String[] fields, String footer, Color color) {

        EmbedBuilder eb = new net.dv8tion.jda.api.EmbedBuilder();
        try { eb.setTitle(title); }
        catch (Exception e)
        {
            eb.setTitle("Empty Title");
            e.printStackTrace();
            System.out.println("\n Empty Title");
        }
        try { eb.setDescription(description); }
        catch (Exception e) {
            eb.setDescription("Empty Description");
            e.printStackTrace();
            System.out.println("\n Empty Description");
        }
        try {
            for (int i = 0; i < fields.length; i += 2)
                eb.addField(fields[i], fields[i + 1], false);
        }
        catch (Exception e) {
            eb.addField("Empty Field Name", "Empty Field Value", false);
            e.printStackTrace();
            System.out.println("\n Empty Field");
        }
        try { eb.setFooter(footer); }
        catch (Exception e) {
            eb.setFooter("Empty Footer");
            e.printStackTrace();
            System.out.println("\n Empty Footer");
        }
        try { eb.setColor(color); }
        catch (Exception e) {
            eb.setColor(Color.white);
            e.printStackTrace();
            System.out.println("\n Empty Color");
        }
        try { event.getChannel().sendMessage(eb.build()).queue(); }
        catch (Exception e) {
            e.printStackTrace();
            System.out.println("\n Build/Send Message");
        }
        try { eb.clear(); }
        catch (Exception e) {
            e.printStackTrace();
            System.out.println("\n embed clear");
        }
    }

}
