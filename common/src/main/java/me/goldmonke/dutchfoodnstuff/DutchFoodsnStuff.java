package me.goldmonke.dutchfoodnstuff;


import me.goldmonke.dutchfoodnstuff.block.ModBlocks;
import me.goldmonke.dutchfoodnstuff.item.ModItems;

import me.goldmonke.dutchfoodnstuff.item.armor.ModArmorMaterials;
import me.goldmonke.dutchfoodnstuff.util.ModStats;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DutchFoodsnStuff {
	public static final String MOD_ID = "dutchfoodsnstuff";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);


	public static void init() {
		LOGGER.info("Initializing Mod");
		ModTabs.initialize();
		ModArmorMaterials.initialize();
		ModBlocks.initialize();
		ModItems.initialize();
        ModStats.initialize();
    }
}