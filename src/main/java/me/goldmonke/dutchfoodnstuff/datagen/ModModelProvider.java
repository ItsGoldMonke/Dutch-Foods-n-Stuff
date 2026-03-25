package me.goldmonke.dutchfoodnstuff.datagen;

import me.goldmonke.dutchfoodnstuff.block.ModBlocks;
import me.goldmonke.dutchfoodnstuff.item.ModItems;
import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.model.ModelTemplates;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricPackOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockModelGenerators blockStateModelGenerator) {
        blockStateModelGenerator.createTrivialCube(ModBlocks.CHEESE_BLOCK);
        blockStateModelGenerator.createNonTemplateHorizontalBlock(ModBlocks.BOERENKOOL_POT);
    }

    @Override
    public void generateItemModels(ItemModelGenerators itemModelGenerator) {
        itemModelGenerator.generateFlatItem(ModItems.CHEESE, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ModItems.CHEESE_SLICE, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ModItems.CHEESE_SLICER, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerator.generateFlatItem(ModItems.STROOPWAFEL, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ModItems.OLIEBOL, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ModItems.OLIEBOL_SUGAR, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ModItems.CHEESE_SOUFLE, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ModItems.KALE, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ModItems.KALE_SEEDS, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ModItems.KLOMPEN, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ModItems.DOUGH_BALL, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ModItems.BITTERBAL, ModelTemplates.FLAT_ITEM);

    }



}
