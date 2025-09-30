package me.goldmonke.dutchfoodnstuff.block;

import me.goldmonke.dutchfoodnstuff.DutchFoodsnStuff;
import me.goldmonke.dutchfoodnstuff.block.custom.BoerenkoolPot;
import me.goldmonke.dutchfoodnstuff.block.custom.KaleBlock;
import me.goldmonke.dutchfoodnstuff.item.ModItems;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

import java.util.function.Function;

public class ModBlocks {
    private static Block register(String name, Function<AbstractBlock.Settings, Block> blockFactory, AbstractBlock.Settings settings, boolean shouldRegisterItem) {
        // Create a registry key for the block
        RegistryKey<Block> blockKey = keyOfBlock(name);
        // Create the block instance
        Block block = blockFactory.apply(settings.registryKey(blockKey));

        // Whether the item needs to be registered or not.
        if (shouldRegisterItem) {

            RegistryKey<Item> itemKey = keyOfItem(name);

            BlockItem blockItem = new BlockItem(block, new Item.Settings().registryKey(itemKey));
            Registry.register(Registries.ITEM, itemKey, blockItem);
        }

        return Registry.register(Registries.BLOCK, blockKey, block);
    }

    private static RegistryKey<Block> keyOfBlock(String name) {
        return RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(DutchFoodsnStuff.MOD_ID, name));
    }

    private static RegistryKey<Item> keyOfItem(String name) {
        return RegistryKey.of(RegistryKeys.ITEM, Identifier.of(DutchFoodsnStuff.MOD_ID, name));
    }

    public static final Block CHEESE_BLOCK = register(
            "cheese_block",
            Block::new,
            AbstractBlock.Settings.create().strength(0.5f).sounds(BlockSoundGroup.CACTUS_FLOWER),
            true
    );

    public static final Block KALE_CROP = register("kale_crop", KaleBlock::new, AbstractBlock.Settings.create().nonOpaque().noCollision().ticksRandomly().breakInstantly().sounds(BlockSoundGroup.CROP), false);

    public static final Block BOERENKOOL_POT = register("boerenkool_pot", BoerenkoolPot::new, AbstractBlock.Settings.create().nonOpaque().strength(0.1f).sounds(BlockSoundGroup.IRON), true);



    public static void initialize() {
        ItemGroupEvents.modifyEntriesEvent((ItemGroups.FOOD_AND_DRINK)).register((itemGroup) -> {
            itemGroup.add(ModBlocks.CHEESE_BLOCK.asItem());
            itemGroup.add(ModBlocks.BOERENKOOL_POT.asItem());
        });
    }
}
