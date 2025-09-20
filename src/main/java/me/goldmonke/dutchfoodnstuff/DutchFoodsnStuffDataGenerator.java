package me.goldmonke.dutchfoodnstuff;

import me.goldmonke.dutchfoodnstuff.datagen.ModBlockTagProvider;
import me.goldmonke.dutchfoodnstuff.datagen.ModItemTagProvider;
import me.goldmonke.dutchfoodnstuff.datagen.ModLootTableProvider;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

public class DutchFoodsnStuffDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
        FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

        pack.addProvider(ModBlockTagProvider::new);
        pack.addProvider(ModItemTagProvider::new);
        pack.addProvider(ModLootTableProvider::new);
	}
}
