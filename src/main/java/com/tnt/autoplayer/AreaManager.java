package com.tnt.autoplayer;

import net.minecraft.util.math.BlockPos;

public class AreaManager {

    public final BlockPos min;
    public final BlockPos max;

    public AreaManager(BlockPos a, BlockPos b) {
        this.min = new BlockPos(
            Math.min(a.getX(), b.getX()),
            Math.min(a.getY(), b.getY()),
            Math.min(a.getZ(), b.getZ())
        );
        this.max = new BlockPos(
            Math.max(a.getX(), b.getX()),
            Math.max(a.getY(), b.getY()),
            Math.max(a.getZ(), b.getZ())
        );
    }

    public boolean isInside(BlockPos pos) {
        return pos.getX() >= min.getX() && pos.getX() <= max.getX()
            && pos.getY() >= min.getY() && pos.getY() <= max.getY()
            && pos.getZ() >= min.getZ() && pos.getZ() <= max.getZ();
    }
}
