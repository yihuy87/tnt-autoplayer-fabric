package com.tnt.autoplayer;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.minecraft.client.MinecraftClient;

public class AutoPlayerMod implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        System.out.println("[TNT AutoPlayer] Loaded");

        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            if (client.player == null) return;

            // nanti logic auto player masuk di sini
        });
    }
}
