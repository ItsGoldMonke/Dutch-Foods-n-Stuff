package me.goldmonke.dutchfoodnstuff.util;

import me.goldmonke.dutchfoodnstuff.DutchFoodsnStuff;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class ModTags {
    public static class Blocks {

        public static final TagKey<Block> CHEESE_SLICER_MINEABLE = createTag("mineable/cheese_slicer");

        private static TagKey<Block> createTag(String name) {
            return TagKey.of(RegistryKeys.BLOCK, Identifier.of(DutchFoodsnStuff.MOD_ID, name));
        }

    }

    public static class Items {

        public static final TagKey<Item> REPAIRS_CHEESE_SLICER = createTag("repairs_cheese_slicer");


        private static TagKey<Item> createTag(String name) {
            return TagKey.of(RegistryKeys.ITEM, Identifier.of(DutchFoodsnStuff.MOD_ID, name));
        }
    }

    public static class ConventionalTags {

        public static final TagKey<Item> KALE_SEEDS = cItemTag("seeds/kale");


        private static TagKey<Item> cItemTag(String path) {
            return TagKey.of(RegistryKeys.ITEM, Identifier.of("c", path));
        }

    }

}
