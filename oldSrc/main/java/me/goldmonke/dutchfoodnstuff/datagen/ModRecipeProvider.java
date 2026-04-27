package me.goldmonke.dutchfoodnstuff.datagen;

import me.goldmonke.dutchfoodnstuff.DutchFoodsnStuff;
import me.goldmonke.dutchfoodnstuff.block.ModBlocks;
import me.goldmonke.dutchfoodnstuff.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.fabricmc.fabric.api.tag.convention.v2.ConventionalItemTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider  extends FabricRecipeProvider {
    public ModRecipeProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected RecipeProvider createRecipeProvider(HolderLookup.Provider wrapperLookup, RecipeOutput recipeExporter) {
        return new RecipeProvider(wrapperLookup,recipeExporter) {
            @Override
            public void buildRecipes() {
                shapeless(RecipeCategory.MISC, ModItems.CHEESE, 4)
                        .group("Cheese")
                        .requires(ConventionalItemTags.MILK_BUCKETS)
                        .requires(Items.WHEAT)
                        .unlockedBy(getHasName(Items.MILK_BUCKET), has(Items.MILK_BUCKET))
                        .save(recipeExporter, ResourceKey.create(Registries.RECIPE, Identifier.fromNamespaceAndPath(DutchFoodsnStuff.MOD_ID, "cheese_from_milk_wheat")));

                shapeless(RecipeCategory.FOOD, ModItems.DOUGH_BALL, 4)
                        .requires(ConventionalItemTags.WHEAT_CROPS)
                        .requires(Items.POTION)
                        .unlockedBy(getHasName(Items.WHEAT), has(Items.WHEAT))
                        .save(recipeExporter);

                shapeless(RecipeCategory.FOOD, ModItems.OLIEBOL_SUGAR, 1)
                        .requires(Items.SUGAR)
                        .requires(ModItems.OLIEBOL)
                        .unlockedBy(getHasName(Items.SUGAR), has(Items.SUGAR))
                        .save(recipeExporter);

                shapeless(RecipeCategory.FOOD, ModBlocks.BOERENKOOL_POT, 1)
                        .requires(Items.CAULDRON)
                        .requires(ConventionalItemTags.RAW_MEAT_FOODS)
                        .requires(ModItems.KALE)
                        .unlockedBy(getHasName(ModItems.KALE), has(ModItems.KALE))
                        .save(recipeExporter);
                shapeless(RecipeCategory.FOOD, ModItems.BITTERBAL, 4)
                        .requires(ConventionalItemTags.COOKED_MEAT_FOODS)
                        .requires(ConventionalItemTags.EGGS)
                        .requires(ConventionalItemTags.WHEAT_CROPS)
                        .unlockedBy(getHasName(Items.WHEAT), has(Items.WHEAT))
                        .save(recipeExporter);




                nineBlockStorageRecipes(RecipeCategory.MISC, ModItems.CHEESE, RecipeCategory.MISC, ModBlocks.CHEESE_BLOCK);
                shaped(RecipeCategory.MISC, ModItems.CHEESE, 2)
                        .pattern("ss")
                        .pattern("ss")
                        .define('s', ModItems.CHEESE_SLICE)
                        .group("cheese")
                        .unlockedBy(getHasName(ModItems.CHEESE_SLICE), has(ModItems.CHEESE_SLICE))
                        .save(recipeExporter, ResourceKey.create(Registries.RECIPE, Identifier.fromNamespaceAndPath(DutchFoodsnStuff.MOD_ID, "cheese_from_cheese_slice")));

                shaped(RecipeCategory.TOOLS, ModItems.CHEESE_SLICER)
                        .pattern(" ii")
                        .pattern(" si")
                        .pattern("s  ")
                        .define('s', ConventionalItemTags.WOODEN_RODS)
                        .define('i', ConventionalItemTags.IRON_INGOTS)
                        .unlockedBy(getHasName(Items.IRON_INGOT), has(Items.IRON_INGOT))
                        .save(recipeExporter);
                shaped(RecipeCategory.COMBAT, ModItems.KLOMPEN)
                        .pattern("   ")
                        .pattern("w w")
                        .pattern("w w")
                        .define('w', ItemTags.PLANKS)
                        .unlockedBy(getHasName(ModItems.CHEESE), has(ModItems.CHEESE))
                        .save(recipeExporter);

                shaped(RecipeCategory.FOOD, ModItems.CHEESE_SOUFLE)
                        .pattern(" b ")
                        .pattern(" k ")
                        .pattern(" b ")
                        .define('k', ModItems.CHEESE)
                        .define('b', ConventionalItemTags.BREAD_FOODS)
                        .unlockedBy(getHasName(ModItems.CHEESE), has(ModItems.CHEESE))
                        .save(recipeExporter);

                shaped(RecipeCategory.FOOD, ModItems.STROOPWAFEL)
                        .pattern(" b ")
                        .pattern(" h ")
                        .pattern(" b ")
                        .define('b', ConventionalItemTags.BREAD_FOODS)
                        .define('h', ConventionalItemTags.HONEY_DRINKS)
                        .unlockedBy(getHasName(Items.BREAD), has(Items.BREAD))
                        .save(recipeExporter);


            }
        };
    }

    @Override
    public String getName() {
        return "DutchFoodsNStuffRecipeProvider";
    }
}
