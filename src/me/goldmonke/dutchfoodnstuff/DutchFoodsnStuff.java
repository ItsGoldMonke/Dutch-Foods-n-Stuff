package me.goldmonke.dutchfoodnstuff;

import me.goldmonke.dutchfoodnstuff.block.ModBlocks;
import me.goldmonke.dutchfoodnstuff.item.ModItems;
import me.goldmonke.dutchfoodnstuff.util.ModStats;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DutchFoodsnStuff implements ModInitializer {
	public static final String MOD_ID = "dutchfoodsnstuff";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
        ModItems.initialize();
        ModBlocks.initialize();
        ModStats.initialize();
    }
}