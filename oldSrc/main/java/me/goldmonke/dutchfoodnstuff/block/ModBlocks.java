package me.goldmonke.dutchfoodnstuff.block;

import me.goldmonke.dutchfoodnstuff.DutchFoodsnStuff;
import me.goldmonke.dutchfoodnstuff.block.custom.BoerenkoolPot;
import me.goldmonke.dutchfoodnstuff.block.custom.KaleBlock;
import net.fabricmc.fabric.api.creativetab.v1.CreativeModeTabEvents;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import java.util.function.Function;

public class ModBlocks {
    private static Block register(String name, Function<BlockBehaviour.Properties, Block> blockFactory, BlockBehaviour.Properties settings, boolean shouldRegisterItem) {
        // Create a registry key for the block
        ResourceKey<Block> blockKey = keyOfBlock(name);
        // Create the block instance
        Block block = blockFactory.apply(settings.setId(blockKey));

        // Whether the item needs to be registered or not.
        if (shouldRegisterItem) {

            ResourceKey<Item> itemKey = keyOfItem(name);

            BlockItem blockItem = new BlockItem(block, new Item.Properties().setId(itemKey));
            Registry.register(BuiltInRegistries.ITEM, itemKey, blockItem);
        }

        return Registry.register(BuiltInRegistries.BLOCK, blockKey, block);
    }

    private static ResourceKey<Block> keyOfBlock(String name) {
        return ResourceKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(DutchFoodsnStuff.MOD_ID, name));
    }

    private static ResourceKey<Item> keyOfItem(String name) {
        return ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(DutchFoodsnStuff.MOD_ID, name));
    }

    public static final Block CHEESE_BLOCK = register(
            "cheese_block",
            Block::new,
            BlockBehaviour.Properties.of().strength(0.5f).sound(SoundType.CACTUS_FLOWER),
            true
    );

    public static final Block KALE_CROP = register("kale_crop", KaleBlock::new, BlockBehaviour.Properties.of().noOcclusion().noCollision().randomTicks().instabreak().sound(SoundType.CROP), false);

    public static final Block BOERENKOOL_POT = register("boerenkool_pot", BoerenkoolPot::new, BlockBehaviour.Properties.of().noOcclusion().strength(0.1f).sound(SoundType.IRON), true);



    public static void initialize() {
        CreativeModeTabEvents.modifyOutputEvent((CreativeModeTabs.FOOD_AND_DRINKS)).register((itemGroup) -> {
            itemGroup.accept(ModBlocks.CHEESE_BLOCK.asItem());
            itemGroup.accept(ModBlocks.BOERENKOOL_POT.asItem());
        });
    }
}
