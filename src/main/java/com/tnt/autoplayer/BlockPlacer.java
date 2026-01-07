package com.tnt.autoplayer;

import net.minecraft.client.MinecraftClient;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;

public class BlockPlacer {

    public static void place(MinecraftClient client, BlockPos target) {
        BlockHitResult hit = new BlockHitResult(
            client.player.getPos(),
            Direction.UP,
            target.down(),
            false
        );

        client.interactionManager.interactBlock(
            client.player,
            Hand.MAIN_HAND,
            hit
        );
    }
}
