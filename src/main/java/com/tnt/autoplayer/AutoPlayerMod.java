package com.tnt.autoplayer;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;

public class AutoPlayerMod implements ClientModInitializer {

    public static final AutoController CONTROLLER = new AutoController();

    @Override
    public void onInitializeClient() {
        System.out.println("[TNT AutoPlayer] Loaded");

        Keybinds.register();

        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            while (Keybinds.TOGGLE.wasPressed()) {
                CONTROLLER.toggle();
            }
            CONTROLLER.tick(client);
        });
    }
}
