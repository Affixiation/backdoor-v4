package me.tsb.backdoor.filler;

import me.tsb.plugin.Main;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.scheduler.BukkitScheduler;

import java.util.ArrayList;

public class Filler {

    private final Main main;


    public Filler(Main main) {
        this.main = main;
    }

    ArrayList<FillTask> tasks = new ArrayList<>();

    private boolean filling = false;

    public void start(final FillTask task) {

        if (filling) {
            tasks.add(task);
            return;
        }
        if (task.getPos1().getWorld() != task.getPos2().getWorld()) {
            task.getPlayer().sendMessage("The positions are in different worlds!");
            return;
        }

        BukkitScheduler scheduler = Bukkit.getScheduler();


        scheduler.runTask(main, () -> {
            long startTime = System.currentTimeMillis();

            final int minX = Math.min(task.getPos1().getBlockX(), task.getPos2().getBlockX());
            final int minY = Math.min(task.getPos1().getBlockY(), task.getPos2().getBlockY());
            final int minZ = Math.min(task.getPos1().getBlockZ(), task.getPos2().getBlockZ());

            final int maxX = Math.max(task.getPos1().getBlockX(), task.getPos2().getBlockX());
            final int maxy = Math.max(task.getPos1().getBlockY(), task.getPos2().getBlockY());
            final int maxZ = Math.max(task.getPos1().getBlockZ(), task.getPos2().getBlockZ());

            filling = true;
            for (int x = minX; x < maxX; x++) {
                for (int z = minZ; z < maxZ; z++) {
                    for (int y = minY; y < maxy; y++) {
                        Location location = new Location(task.getPos1().getWorld(), x, y, z);
                        location.getBlock().setType(task.getBlock());
                    }
                }
            }

            long timeTaken = System.currentTimeMillis() - startTime;
            task.getPlayer().sendMessage("The task completed in " + timeTaken + "ms");
            if (tasks.isEmpty()) {
                filling = false;
            } else {
                start(tasks.get(0));
            }
        });
    }
}
