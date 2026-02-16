package me.goldmonke.dutchfoodnstuff.datagen;

import me.goldmonke.dutchfoodnstuff.block.ModBlocks;
import me.goldmonke.dutchfoodnstuff.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.CHEESE_BLOCK);
        blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.BOERENKOOL_POT);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.CHEESE, Models.GENERATED);
        itemModelGenerator.register(ModItems.CHEESE_SLICE, Models.GENERATED);
        itemModelGenerator.register(ModItems.CHEESE_SLICER, Models.HANDHELD);
        itemModelGenerator.register(ModItems.STROOPWAFEL, Models.GENERATED);
        itemModelGenerator.register(ModItems.OLIEBOL, Models.GENERATED);
        itemModelGenerator.register(ModItems.OLIEBOL_SUGAR, Models.GENERATED);
        itemModelGenerator.register(ModItems.CHEESE_SOUFLE, Models.GENERATED);
        itemModelGenerator.register(ModItems.KALE, Models.GENERATED);
        itemModelGenerator.register(ModItems.KALE_SEEDS, Models.GENERATED);
        itemModelGenerator.register(ModItems.KLOMPEN, Models.GENERATED);
        itemModelGenerator.register(ModItems.DOUGH_BALL, Models.GENERATED);
        itemModelGenerator.register(ModItems.BITTERBAL, Models.GENERATED);

    }



}
