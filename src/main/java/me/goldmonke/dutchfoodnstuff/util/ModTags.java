package me.goldmonke.dutchfoodnstuff.util;

import me.goldmonke.dutchfoodnstuff.DutchFoodsnStuff;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class ModTags {
    public static class Blocks {

        public static final TagKey<Block> CHEESE_SLICER_MINEABLE = createTag("mineable/cheese_slicer");

        private static TagKey<Block> createTag(String name) {
            return TagKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(DutchFoodsnStuff.MOD_ID, name));
        }

    }

    public static class Items {

        public static final TagKey<Item> REPAIRS_CHEESE_SLICER = createTag("repairs_cheese_slicer");


        private static TagKey<Item> createTag(String name) {
            return TagKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(DutchFoodsnStuff.MOD_ID, name));
        }
    }

    public static class ConventionalTags {

        public static final TagKey<Item> KALE_SEEDS = cItemTag("seeds/kale");


        private static TagKey<Item> cItemTag(String path) {
            return TagKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath("c", path));
        }

    }

}
