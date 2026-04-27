package me.goldmonke.dutchfoodnstuff.neoforge;

import net.neoforged.fml.common.Mod;

import me.goldmonke.dutchfoodnstuff.DutchFoodsnStuff;

@Mod(DutchFoodsnStuff.MOD_ID)
public final class DutchFoodsnStuffNeoForge {
    public DutchFoodsnStuffNeoForge() {
        // Run our common setup.
        DutchFoodsnStuff.init();
    }
}
