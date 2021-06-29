package me.tsb.backdoor.events;

import me.tsb.backdoor.filler.PlayerRegion;
import me.tsb.plugin.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class ConnectionEvents implements Listener {

    private final Main main;

    public ConnectionEvents(Main main) {
        this.main = main;
    }


    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        main.getPlayerRegionTracker().getRegions().put(event.getPlayer().getUniqueId(), new PlayerRegion());
    }

    @EventHandler
    public void onLeave(PlayerQuitEvent event) {
        main.getPlayerRegionTracker().getRegions().remove(event.getPlayer().getUniqueId());
    }
}
