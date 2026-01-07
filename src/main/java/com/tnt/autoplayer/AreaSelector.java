package com.tnt.autoplayer;

import net.fabricmc.fabric.api.event.player.UseBlockCallback;
import net.minecraft.item.Items;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;

public class AreaSelector {

    private static BlockPos a;
    private static BlockPos b;

    public static void register() {
        UseBlockCallback.EVENT.register((player, world, hand, hit) -> {
            if (!world.isClient()) return ActionResult.PASS;
            if (player.getMainHandStack().getItem() != Items.STICK)
                return ActionResult.PASS;

            if (a == null) a = hit.getBlockPos();
            else b = hit.getBlockPos();

            return ActionResult.SUCCESS;
        });
    }

    public static boolean ready() {
        return a != null && b != null;
    }

    public static AreaManager build() {
        return new AreaManager(a, b);
    }
}
