package me.thesaltyboys.backdoor.filler;

import lombok.Getter;

import java.util.HashMap;
import java.util.UUID;

public class PlayerRegionTracker {

    @Getter
    private final HashMap<UUID, PlayerRegion> regions = new HashMap<>();
}
