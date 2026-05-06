package com.swill.fly;

import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import org.lwjgl.glfw.GLFW;

public class FlyKeybind {
    public static void register() {
        KeyBinding keyBinding = KeyBindingHelper.registerKeyBinding(new KeyBinding(
            "key.flymod.toggle",
            InputUtil.Type.KEYSYM,
            GLFW.GLFW_KEY_G,
            "category.flymod"
        ));

        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            if (client.player != null && keyBinding.wasPressed()) {
                boolean canFly = client.player.getAbilities().allowFlying;
                client.player.getAbilities().allowFlying = !canFly;
                client.player.getAbilities().flying = !canFly;
            }
        });
    }
}
