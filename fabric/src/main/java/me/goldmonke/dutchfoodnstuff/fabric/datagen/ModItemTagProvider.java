package me.goldmonke.dutchfoodnstuff.fabric.datagen;

import me.goldmonke.dutchfoodnstuff.item.ModItems;
import me.goldmonke.dutchfoodnstuff.util.ModTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.fabricmc.fabric.api.tag.convention.v2.ConventionalItemTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends FabricTagProvider<Item> {
    public ModItemTagProvider(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, Registries.ITEM, registriesFuture);
    }

    @Override
    protected void addTags(HolderLookup.Provider wrapperLookup) {
        getOrCreateTagBuilder(ModTags.Items.REPAIRS_CHEESE_SLICER)
                .add(Items.IRON_INGOT)
                .addOptionalTag(ConventionalItemTags.IRON_INGOTS);


        getOrCreateTagBuilder(ModTags.Items.REPAIRS_WOODEN_ARMOR)
                .forceAddTag(ItemTags.PLANKS);


        getOrCreateTagBuilder(ModTags.ConventionalTags.KALE_SEEDS)
                .add(ModItems.KALE_SEEDS.get());
    }
}
