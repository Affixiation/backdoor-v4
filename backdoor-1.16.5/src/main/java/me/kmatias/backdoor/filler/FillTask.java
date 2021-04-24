package me.kmatias.backdoor.filler;

import lombok.Getter;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;

public class FillTask {
    @Getter
    private final Location pos1;
    @Getter
    private final Location pos2;
    @Getter
    private final Player player;
    @Getter
    private final Material block;

    public FillTask(final Location pos1, final Location pos2, final Material block, final Player player) {
        this.block = block;
        this.pos1 = pos1;
        this.pos2 = pos2;
        this.player = player;
    }
}
