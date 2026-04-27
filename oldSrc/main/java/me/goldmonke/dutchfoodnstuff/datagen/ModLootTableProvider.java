package me.goldmonke.dutchfoodnstuff.datagen;

import me.goldmonke.dutchfoodnstuff.block.ModBlocks;
import me.goldmonke.dutchfoodnstuff.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootSubProvider;
import net.minecraft.advancements.criterion.StatePropertiesPredicate;
import net.minecraft.core.HolderLookup;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import java.util.concurrent.CompletableFuture;

public class ModLootTableProvider extends FabricBlockLootSubProvider {
    public ModLootTableProvider(FabricPackOutput dataOutput, CompletableFuture<HolderLookup.Provider> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generate() {
        // Add block drops
        dropSelf(ModBlocks.CHEESE_BLOCK);
        dropOther(ModBlocks.BOERENKOOL_POT, Items.CAULDRON);


        // Crop Loot Table
        LootItemCondition.Builder builder2 = LootItemBlockStatePropertyCondition.hasBlockStateProperties(ModBlocks.KALE_CROP)
                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(CropBlock.AGE, 7));
        add(ModBlocks.KALE_CROP, createCropDrops(ModBlocks.KALE_CROP, ModItems.KALE, ModItems.KALE_SEEDS, builder2));

    }
}
