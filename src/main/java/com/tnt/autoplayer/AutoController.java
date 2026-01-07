package com.tnt.autoplayer;

import net.minecraft.client.MinecraftClient;
import net.minecraft.util.math.BlockPos;

public class AutoController {

    private AutoState state = AutoState.OFF;
    private final DelayTimer delay = new DelayTimer();

    private AreaManager area;

    public void toggle() {
        if (state == AutoState.ACTIVE) {
            state = AutoState.OFF;
            System.out.println("[TNT AutoPlayer] OFF");
            return;
        }

        if (!AreaSelector.ready()) {
            System.out.println("[TNT AutoPlayer] Area not set");
            return;
        }

        area = AreaSelector.build();
        state = AutoState.ACTIVE;
        System.out.println("[TNT AutoPlayer] ON");
    }

    public void tick(MinecraftClient client) {
        if (state != AutoState.ACTIVE) return;
        if (client.player == null || client.world == null) return;

        if (ManualOverrideDetector.detect(client)) {
            state = AutoState.PAUSED;
            return;
        }

        if (!delay.ready()) return;

        BlockPos target = TargetSelector.findNextAir(client, area);

        if (target == null) {
            state = AutoState.OFF;
            System.out.println("[TNT AutoPlayer] Area full, auto OFF");
            return;
        }

        client.player.setPitch(80f);
        BlockPlacer.place(client, target);
        delay.set(8);
    }

    public AutoState getState() {
        return state;
    }
}
