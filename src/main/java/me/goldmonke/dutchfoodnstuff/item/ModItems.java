package me.goldmonke.dutchfoodnstuff.item;

import me.goldmonke.dutchfoodnstuff.DutchFoodsnStuff;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.component.type.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

import java.util.function.Function;

public class ModItems {
    // Register stuff
    public static final Item CHEESE = register("cheese", Item::new, new Item.Settings().food(new FoodComponent.Builder().nutrition(10).saturationModifier(0.5f).build()));
    public static final Item CHEESE_SLICE = register("cheese_slice", Item::new, new Item.Settings().food(new FoodComponent.Builder().nutrition(5).saturationModifier(0.5f).build()));


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
                });


    }

}


