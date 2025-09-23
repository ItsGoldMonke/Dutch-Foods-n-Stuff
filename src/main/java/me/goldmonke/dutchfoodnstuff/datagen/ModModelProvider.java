package me.goldmonke.dutchfoodnstuff.datagen;

import it.unimi.dsi.fastutil.ints.Int2ObjectFunction;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import me.goldmonke.dutchfoodnstuff.block.ModBlocks;
import me.goldmonke.dutchfoodnstuff.item.ModItems;
import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.block.Block;
import net.minecraft.client.data.*;
import net.minecraft.state.property.Property;
import net.minecraft.util.Identifier;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.CHEESE_BLOCK);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.CHEESE, Models.GENERATED);
        itemModelGenerator.register(ModItems.CHEESE_SLICE, Models.GENERATED);
        itemModelGenerator.register(ModItems.CHEESE_SLICER, Models.HANDHELD);
        itemModelGenerator.register(ModItems.STROOPWAFEL, Models.GENERATED);
        itemModelGenerator.register(ModItems.KALE, Models.GENERATED);
        itemModelGenerator.register(ModItems.KALE_SEEDS, Models.GENERATED);
        itemModelGenerator.register(ModItems.KLOMPEN, Models.GENERATED);

    }



}
