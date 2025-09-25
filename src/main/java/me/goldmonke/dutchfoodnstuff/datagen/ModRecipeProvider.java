package me.goldmonke.dutchfoodnstuff.datagen;

import me.goldmonke.dutchfoodnstuff.DutchFoodsnStuff;
import me.goldmonke.dutchfoodnstuff.block.ModBlocks;
import me.goldmonke.dutchfoodnstuff.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.fabricmc.fabric.api.tag.convention.v2.ConventionalItemTags;
import net.minecraft.data.recipe.RecipeExporter;
import net.minecraft.data.recipe.RecipeGenerator;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.util.Identifier;

import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider  extends FabricRecipeProvider {
    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected RecipeGenerator getRecipeGenerator(RegistryWrapper.WrapperLookup wrapperLookup, RecipeExporter recipeExporter) {
        return new RecipeGenerator(wrapperLookup,recipeExporter) {
            @Override
            public void generate() {
                createShapeless(RecipeCategory.MISC, ModItems.CHEESE, 4)
                        .group("Cheese")
                        .input(ConventionalItemTags.MILK_BUCKETS)
                        .input(Items.WHEAT)
                        .criterion(hasItem(Items.MILK_BUCKET), conditionsFromItem(Items.MILK_BUCKET))
                        .offerTo(recipeExporter, RegistryKey.of(RegistryKeys.RECIPE, Identifier.of(DutchFoodsnStuff.MOD_ID, "cheese_from_milk_wheat")));


                offerReversibleCompactingRecipes(RecipeCategory.MISC, ModItems.CHEESE, RecipeCategory.MISC, ModBlocks.CHEESE_BLOCK);
                createShaped(RecipeCategory.MISC, ModItems.CHEESE, 2)
                        .pattern("ss")
                        .pattern("ss")
                        .input('s', ModItems.CHEESE_SLICE)
                        .group("cheese")
                        .criterion(hasItem(ModItems.CHEESE_SLICE), conditionsFromItem(ModItems.CHEESE_SLICE))
                        .offerTo(recipeExporter, RegistryKey.of(RegistryKeys.RECIPE, Identifier.of(DutchFoodsnStuff.MOD_ID, "cheese_from_cheese_slice")));

                createShaped(RecipeCategory.TOOLS, ModItems.CHEESE_SLICER)
                        .pattern(" ii")
                        .pattern(" si")
                        .pattern("s  ")
                        .input('s', ConventionalItemTags.WOODEN_RODS)
                        .input('i', ConventionalItemTags.IRON_INGOTS)
                        .criterion(hasItem(Items.IRON_INGOT), conditionsFromItem(Items.IRON_INGOT))
                        .offerTo(recipeExporter);
                createShaped(RecipeCategory.COMBAT, ModItems.KLOMPEN)
                        .pattern("   ")
                        .pattern("w w")
                        .pattern("w w")
                        .input('w', ItemTags.PLANKS)
                        .criterion(hasItem(ModItems.CHEESE), conditionsFromItem(ModItems.CHEESE))
                        .offerTo(recipeExporter);

                createShaped(RecipeCategory.FOOD, ModItems.STROOPWAFEL)
                        .pattern(" b ")
                        .pattern(" h ")
                        .pattern(" b ")
                        .input('b', ConventionalItemTags.BREAD_FOODS)
                        .input('h', ConventionalItemTags.HONEY_DRINKS)
                        .criterion(hasItem(Items.BREAD), conditionsFromItem(Items.BREAD))
                        .offerTo(recipeExporter);


            }
        };
    }

    @Override
    public String getName() {
        return "DutchFoodsNStuffRecipeProvider";
    }
}
