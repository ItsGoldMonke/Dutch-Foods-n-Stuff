package me.goldmonke.dutchfoodnstuff.datagen;

import me.goldmonke.dutchfoodnstuff.item.ModItems;
import me.goldmonke.dutchfoodnstuff.util.ModTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.fabricmc.fabric.api.tag.convention.v2.ConventionalItemTags;
import net.minecraft.item.Items;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends FabricTagProvider.ItemTagProvider {
    public ModItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        valueLookupBuilder(ModTags.Items.REPAIRS_CHEESE_SLICER)
                .add(Items.IRON_INGOT)
                .addOptionalTag(ConventionalItemTags.IRON_INGOTS);

        valueLookupBuilder(ModTags.ConventionalTags.KALE_SEEDS)
                .add(ModItems.KALE_SEEDS);
    }
}
