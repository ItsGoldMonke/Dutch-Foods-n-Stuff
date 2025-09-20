package me.goldmonke.dutchfoodnstuff.datagen;

import me.goldmonke.dutchfoodnstuff.block.ModBlocks;
import me.goldmonke.dutchfoodnstuff.item.ModItems;
import me.goldmonke.dutchfoodnstuff.util.ModTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.fabricmc.fabric.api.tag.convention.v2.ConventionalBlockTags;
import net.fabricmc.fabric.api.tag.convention.v2.ConventionalItemTags;
import net.minecraft.item.Items;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        valueLookupBuilder(BlockTags.HOE_MINEABLE)
                .add(ModBlocks.CHEESE_BLOCK);

        valueLookupBuilder(ModTags.Blocks.CHEESE_SLICER_MINEABLE)
                .add(ModBlocks.CHEESE_BLOCK);

    }
}
