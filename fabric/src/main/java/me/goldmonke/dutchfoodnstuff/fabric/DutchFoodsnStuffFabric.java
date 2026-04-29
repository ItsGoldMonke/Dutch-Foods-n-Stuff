package me.goldmonke.dutchfoodnstuff.fabric;

import me.goldmonke.dutchfoodnstuff.DutchFoodsnStuff;
import me.goldmonke.dutchfoodnstuff.item.ModItems;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.registry.CompostingChanceRegistry;


public final class DutchFoodsnStuffFabric implements ModInitializer {




    @Override
    public void onInitialize() {
        // This code runs as soon as Minecraft is in a mod-load-ready state.
        // However, some things (like resources) may still be uninitialized.
        // Proceed with mild caution.

        // Run our common setup.
        DutchFoodsnStuff.init();


        // Add item to compostable
        CompostingChanceRegistry.INSTANCE.add(ModItems.KALE.get(), 0.65f);
        CompostingChanceRegistry.INSTANCE.add(ModItems.KALE_SEEDS.get(), 0.3f);
    }
}
