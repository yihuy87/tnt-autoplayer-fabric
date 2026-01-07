package com.tnt.autoplayer;

import net.minecraft.client.MinecraftClient;

public class AutoController {

    private AutoState state = AutoState.OFF;

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
        if (client.player == null) return;

        // logic auto akan ditambah di tahap berikutnya
    }

    public AutoState getState() {
        return state;
    }
}
