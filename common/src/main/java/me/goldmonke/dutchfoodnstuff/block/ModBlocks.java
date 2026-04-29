package me.goldmonke.dutchfoodnstuff.block;

import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import me.goldmonke.dutchfoodnstuff.DutchFoodsnStuff;
import me.goldmonke.dutchfoodnstuff.block.custom.BoerenkoolPot;
import me.goldmonke.dutchfoodnstuff.block.custom.KaleBlock;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class ModBlocks {
//    private static Block register(String name, Function<BlockBehaviour.Properties, Block> blockFactory, BlockBehaviour.Properties settings, boolean shouldRegisterItem) {
//        // Create a registry key for the block
//        ResourceKey<Block> blockKey = keyOfBlock(name);
//        // Create the block instance
//        Block block = blockFactory.apply(settings.setId(blockKey));
//
//        // Whether the item needs to be registered or not.
//        if (shouldRegisterItem) {
//            ResourceKey<Item> itemKey = keyOfItem(name);
//
//            BlockItem blockItem = new BlockItem(block, new Item.Properties().setId(itemKey));
//            Registry.register(BuiltInRegistries.ITEM, itemKey, blockItem);
//        }
//
//        return Registry.register(BuiltInRegistries.BLOCK, blockKey, block);
//    }

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(DutchFoodsnStuff.MOD_ID, Registries.BLOCK);
// BlockBehaviour.Properties().of().strength(0.5f).sound(SoundType.MOSS))
    public static final RegistrySupplier<Block> CHEESE_BLOCK = BLOCKS.register("cheese_block", () -> new Block(BlockBehaviour.Properties.of().strength(0.5f).sound(SoundType.MOSS)));
    public static final RegistrySupplier<Block> KALE_CROP = BLOCKS.register("kale_crop", () -> new KaleBlock(BlockBehaviour.Properties.of().noCollission().noOcclusion().randomTicks().instabreak().sound(SoundType.CROP)));

    public static final RegistrySupplier<Block> BOERENKOOL_POT = BLOCKS.register("boerenkool_pot", () -> new BoerenkoolPot(BlockBehaviour.Properties.of().noOcclusion().strength(0.1f).sound(SoundType.METAL)));


    public static void initialize() {
        BLOCKS.register();

    }
}
