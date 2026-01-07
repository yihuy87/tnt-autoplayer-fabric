package com.tnt.autoplayer;

import net.minecraft.client.MinecraftClient;
import net.minecraft.util.math.BlockPos;

public class TargetSelector {

    public static BlockPos findNextAir(MinecraftClient client, AreaManager area) {
        BlockPos playerPos = client.player.getBlockPos();

        BlockPos closest = null;
        double closestDist = Double.MAX_VALUE;

        for (int x = area.min.getX(); x <= area.max.getX(); x++) {
            for (int y = area.min.getY(); y <= area.max.getY(); y++) {
                for (int z = area.min.getZ(); z <= area.max.getZ(); z++) {

                    BlockPos pos = new BlockPos(x, y, z);

                    if (!client.world.isAir(pos)) continue;

                    double dist = pos.getSquaredDistance(playerPos);
                    if (dist < closestDist) {
                        closestDist = dist;
                        closest = pos;
                    }
                }
            }
        }
        return closest;
    }
}
