package me.goldmonke.dutchfoodnstuff.datagen;

import me.goldmonke.dutchfoodnstuff.block.ModBlocks;
import me.goldmonke.dutchfoodnstuff.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.block.CropBlock;
import net.minecraft.loot.condition.BlockStatePropertyLootCondition;
import net.minecraft.loot.condition.LootCondition;
import net.minecraft.predicate.StatePredicate;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class ModLootTableProvider extends FabricBlockLootTableProvider {
    public ModLootTableProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generate() {
        // Add block drops
        addDrop(ModBlocks.CHEESE_BLOCK);

        // Crop Loot Table
        LootCondition.Builder builder2 = BlockStatePropertyLootCondition.builder(ModBlocks.KALE_CROP)
                .properties(StatePredicate.Builder.create().exactMatch(CropBlock.AGE, 7));
        addDrop(ModBlocks.KALE_CROP, cropDrops(ModBlocks.KALE_CROP, ModItems.KALE, ModItems.KALE_SEEDS, builder2));
        
    }
}
// sure paste it ig - loot table for kale crop (similar to wheat in terms of drop) It maybe works now im running datagen