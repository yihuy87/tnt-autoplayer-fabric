package com.tnt.autoplayer;

import net.minecraft.client.MinecraftClient;
import net.minecraft.util.math.BlockPos;

public class AutoController {

    private AutoState state = AutoState.OFF;
    private final DelayTimer delay = new DelayTimer();

    public void toggle() {
        if (state == AutoState.ACTIVE) {
            state = AutoState.OFF;
            System.out.println("[TNT AutoPlayer] OFF");
        } else {
            state = AutoState.ACTIVE;
            System.out.println("[TNT AutoPlayer] ON");
        }
    }

    public void tick(MinecraftClient client) {
        if (state != AutoState.ACTIVE) return;
        if (client.player == null || client.world == null) return;

        if (!delay.ready()) return;

        BlockPos feet = client.player.getBlockPos();
        BlockPos below = feet.down();

        if (client.world.isAir(below)) {
            client.player.setPitch(80f); // lihat ke bawah
            BlockPlacer.place(client, below);
            delay.set(10);
        }

    }

    public AutoState getState() {
        return state;
    }
}
