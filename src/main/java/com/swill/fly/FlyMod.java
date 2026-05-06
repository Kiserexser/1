package com.swill.fly;

import net.fabricmc.api.ModInitializer;

public class FlyMod implements ModInitializer {
    @Override
    public void onInitialize() {
        FlyKeybind.register();
    }
}
