package me.thesaltyboys.backdoor.events;

import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public final class AnvilRenameItemEvent extends Event {
    // this is not used for anything atm
    private static final HandlerList handlers = new HandlerList();
    private final String newName;
    private final String oldName;
    private final Player player;
    private final Block theBlock;

    public AnvilRenameItemEvent(String newItemName, String oldName, Block theBlock, Player player) {
        this.newName = newItemName;
        this.oldName = oldName;
        this.theBlock = theBlock;
        this.player = player;
    }

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }
}
