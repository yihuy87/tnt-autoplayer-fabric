package com.tnt.autoplayer;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.minecraft.client.MinecraftClient;

public class AutoPlayerMod implements ClientModInitializer {

    public static final AutoController CONTROLLER = new AutoController();

    @Override
    public void onInitializeClient() {
        System.out.println("[TNT AutoPlayer] Loaded");

        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            CONTROLLER.tick(client);
        });
    }
}
