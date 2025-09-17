package me.goldmonke.dutchfoodnstuff.item;

import me.goldmonke.dutchfoodnstuff.DutchFoodsnStuff;
import me.goldmonke.dutchfoodnstuff.item.custom.CheeseSlicer;
import me.goldmonke.dutchfoodnstuff.util.ModTags;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.component.type.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.ToolMaterial;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.util.Identifier;

import java.util.function.Function;

public class ModItems {

    // Tools Materials

    public static final ToolMaterial CHEESE_SLICER_TOOL_MATERIAL = new ToolMaterial(
            BlockTags.INCORRECT_FOR_IRON_TOOL,
            465,
            6.0F,
            2F,
            1,
            ModTags.Items.REPAIRS_CHEESE_SLICER
                );




    // Register stuff
    public static final Item CHEESE = register("cheese", Item::new, new Item.Settings().food(new FoodComponent.Builder().nutrition(10).saturationModifier(0.5f).build()));
    public static final Item CHEESE_SLICE = register("cheese_slice", Item::new, new Item.Settings().food(new FoodComponent.Builder().nutrition(5).saturationModifier(0.5f).build()));
    public static final Item CHEESE_SLICER = register("cheese_slicer", CheeseSlicer::new, new Item.Settings().tool(CHEESE_SLICER_TOOL_MATERIAL, ModTags.Blocks.CHEESE_SLICER_MINEABLE, 2.0F, -2.8F, 0));
    public static final Item STROOPWAFEL = register("stroopwafel", Item::new, new Item.Settings().food(new FoodComponent.Builder().nutrition(10).saturationModifier(0.5f).build()));




    public static Item register(String name, Function<Item.Settings, Item> itemFactory, Item.Settings settings) {
        // Create the item key.
        RegistryKey<Item> itemKey = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(DutchFoodsnStuff.MOD_ID, name));

        // Create the item instance.
        Item item = itemFactory.apply(settings.registryKey(itemKey));

        // Register the items.
        Registry.register(Registries.ITEM, itemKey, item);




        return item;
    }

    public static void initialize() {

        // Add the items to item group
        ItemGroupEvents.modifyEntriesEvent((ItemGroups.FOOD_AND_DRINK))
                .register((itemGroup) -> {
                    itemGroup.add(ModItems.CHEESE);
                    itemGroup.add(ModItems.CHEESE_SLICE);
                    itemGroup.add(ModItems.STROOPWAFEL);
                });

        ItemGroupEvents.modifyEntriesEvent((ItemGroups.TOOLS))
                .register((itemGroup) -> {
                    itemGroup.add(ModItems.CHEESE_SLICER);
                });



    }

}


