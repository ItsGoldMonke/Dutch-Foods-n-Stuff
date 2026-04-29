package me.goldmonke.dutchfoodnstuff.util;

import me.goldmonke.dutchfoodnstuff.DutchFoodsnStuff;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class ModTags {
    public static class Blocks {

        public static final TagKey<Block> CHEESE_SLICER_MINEABLE = createTag("mineable/cheese_slicer");

        private static TagKey<Block> createTag(String name) {
            return TagKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(DutchFoodsnStuff.MOD_ID, name));
        }

    }

    public static class Items {

        public static final TagKey<Item> REPAIRS_CHEESE_SLICER = createTag("repairs_cheese_slicer");
        public static final TagKey<Item> REPAIRS_WOODEN_ARMOR = createTag("repairs_wooden_armor");


        private static TagKey<Item> createTag(String name) {
            return TagKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(DutchFoodsnStuff.MOD_ID, name));
        }
    }

    public static class ConventionalTags {

        public static final TagKey<Item> KALE_SEEDS = cItemTag("seeds/kale");


        private static TagKey<Item> cItemTag(String path) {
            return TagKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath("c", path));
        }

    }

}
