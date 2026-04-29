package me.goldmonke.dutchfoodnstuff.fabric.datagen;

import me.goldmonke.dutchfoodnstuff.DutchFoodsnStuff;
import me.goldmonke.dutchfoodnstuff.block.ModBlocks;
import me.goldmonke.dutchfoodnstuff.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.fabricmc.fabric.api.tag.convention.v2.ConventionalItemTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;

import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider  extends FabricRecipeProvider {
    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void buildRecipes(RecipeOutput recipeExporter) {
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.CHEESE.get(), 4)
                .group("Cheese")
                .requires(ConventionalItemTags.MILK_BUCKETS)
                .requires(Items.WHEAT)
                .unlockedBy(getHasName(Items.MILK_BUCKET), has(Items.MILK_BUCKET))
                .save(recipeExporter, ResourceLocation.fromNamespaceAndPath(DutchFoodsnStuff.MOD_ID, "cheese_from_milk_wheat"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ModItems.DOUGH_BALL.get(), 4)
                .requires(ConventionalItemTags.WHEAT_CROPS)
                .requires(Items.POTION)
                .unlockedBy(getHasName(Items.WHEAT), has(Items.WHEAT))
                .save(recipeExporter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ModItems.OLIEBOL_SUGAR.get(), 1)
                .requires(Items.SUGAR)
                .requires(ModItems.OLIEBOL.get())
                .unlockedBy(getHasName(Items.SUGAR), has(Items.SUGAR))
                .save(recipeExporter);

            ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ModBlocks.BOERENKOOL_POT.get(), 1)
                .requires(Items.CAULDRON)
                .requires(ConventionalItemTags.RAW_MEAT_FOODS)
                .requires(ModItems.KALE.get())
                .unlockedBy(getHasName(ModItems.KALE.get()), has(ModItems.KALE.get()))
                .save(recipeExporter);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ModItems.BITTERBAL.get(), 4)
                .requires(ConventionalItemTags.COOKED_MEAT_FOODS)
                .requires(ConventionalItemTags.EGGS)
                .requires(ConventionalItemTags.WHEAT_CROPS)
                .unlockedBy(getHasName(Items.WHEAT), has(Items.WHEAT))
                .save(recipeExporter);




        FabricRecipeProvider.nineBlockStorageRecipes(recipeExporter, RecipeCategory.MISC, ModItems.CHEESE.get(), RecipeCategory.MISC, ModBlocks.CHEESE_BLOCK.get());
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.CHEESE.get(), 2)
                .pattern("ss")
                .pattern("ss")
                .define('s', ModItems.CHEESE_SLICE.get())
                .group("cheese")
                .unlockedBy(getHasName(ModItems.CHEESE_SLICE.get()), has(ModItems.CHEESE_SLICE.get()))
                .save(recipeExporter, ResourceLocation.fromNamespaceAndPath(DutchFoodsnStuff.MOD_ID, "cheese_from_cheese_slice"));

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.CHEESE_SLICER.get())
                .pattern(" ii")
                .pattern(" si")
                .pattern("s  ")
                .define('s', ConventionalItemTags.WOODEN_RODS)
                .define('i', ConventionalItemTags.IRON_INGOTS)
                .unlockedBy(getHasName(Items.IRON_INGOT), has(Items.IRON_INGOT))
                .save(recipeExporter);
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.KLOMPEN.get())
                .pattern("   ")
                .pattern("w w")
                .pattern("w w")
                .define('w', ItemTags.PLANKS)
                .unlockedBy(getHasName(ModItems.CHEESE.get()), has(ModItems.CHEESE.get()))
                .save(recipeExporter);

        ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, ModItems.CHEESE_SOUFLE.get())
                .pattern(" b ")
                .pattern(" k ")
                .pattern(" b ")
                .define('k', ModItems.CHEESE.get())
                .define('b', ConventionalItemTags.BREAD_FOODS)
                .unlockedBy(getHasName(ModItems.CHEESE.get()), has(ModItems.CHEESE.get()))
                .save(recipeExporter);

        ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, ModItems.STROOPWAFEL.get())
                .pattern(" b ")
                .pattern(" h ")
                .pattern(" b ")
                .define('b', ConventionalItemTags.BREAD_FOODS)
                .define('h', ConventionalItemTags.HONEY_DRINKS)
                .unlockedBy(getHasName(Items.BREAD), has(Items.BREAD))
                .save(recipeExporter);


    }
}