package com.tnt.autoplayer;

import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.option.KeyBinding;
import org.lwjgl.glfw.GLFW;

public class Keybinds {

    public static KeyBinding TOGGLE;

    public static void register() {
        TOGGLE = KeyBindingHelper.registerKeyBinding(
            new KeyBinding(
                "key.tntautoplayer.toggle",
                GLFW.GLFW_KEY_G,
                "category.tntautoplayer"
            )
        );
    }
}
