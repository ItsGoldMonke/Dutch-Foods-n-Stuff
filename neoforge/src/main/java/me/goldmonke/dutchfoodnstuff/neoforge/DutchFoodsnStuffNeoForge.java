package me.goldmonke.dutchfoodnstuff.neoforge;

import net.neoforged.fml.common.Mod;

import me.goldmonke.dutchfoodnstuff.DutchFoodsnStuff;

@Mod(DutchFoodsnStuff.MOD_ID)
public final class DutchFoodsnStuffNeoForge {
    public DutchFoodsnStuffNeoForge() {
        // Run our common setup during mod construction so registrations happen in time.
        DutchFoodsnStuff.LOGGER.info("trying to init");
        DutchFoodsnStuff.init();

        // Keep the event bus available for future NeoForge-specific listeners.
    }
}
