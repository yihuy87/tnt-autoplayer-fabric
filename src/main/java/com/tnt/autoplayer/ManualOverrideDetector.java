package com.tnt.autoplayer;

import net.minecraft.client.MinecraftClient;

public class ManualOverrideDetector {

    private static float lastYaw;
    private static float lastPitch;

    public static boolean detect(MinecraftClient client) {
        float yaw = client.player.getYaw();
        float pitch = client.player.getPitch();

        boolean moved =
            Math.abs(yaw - lastYaw) > 0.15f ||
            Math.abs(pitch - lastPitch) > 0.15f;

        lastYaw = yaw;
        lastPitch = pitch;

        return moved;
    }
}
