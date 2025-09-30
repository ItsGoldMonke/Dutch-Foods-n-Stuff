package me.goldmonke.dutchfoodnstuff.item;

import me.goldmonke.dutchfoodnstuff.DutchFoodsnStuff;
import me.goldmonke.dutchfoodnstuff.block.ModBlocks;
import me.goldmonke.dutchfoodnstuff.item.armor.KlompenItem;
import me.goldmonke.dutchfoodnstuff.item.armor.WoodenArmorMaterial;
import me.goldmonke.dutchfoodnstuff.item.custom.CheeseSlicer;
import me.goldmonke.dutchfoodnstuff.util.ModTags;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.loot.v3.LootTableEvents;
import net.fabricmc.fabric.api.registry.CompostingChanceRegistry;
import net.minecraft.block.Blocks;
import net.minecraft.component.type.ConsumableComponent;
import net.minecraft.component.type.ConsumableComponents;
import net.minecraft.component.type.FoodComponent;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.*;
import net.minecraft.item.consume.ApplyEffectsConsumeEffect;
import net.minecraft.item.equipment.EquipmentType;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.condition.RandomChanceLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import java.util.Optional;
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
    public static final Item STROOPWAFEL = register("stroopwafel", Item::new, new Item.Settings().food(new FoodComponent.Builder().nutrition(10).saturationModifier(0.5f).build(), ConsumableComponents.food().consumeEffect(new ApplyEffectsConsumeEffect(new StatusEffectInstance(StatusEffects.SPEED, 10 * 20, 1), 1.0f)).build()));
    public static final Item KALE_SEEDS = register("kale_seeds", settings -> new BlockItem(ModBlocks.KALE_CROP, settings), new Item.Settings().useItemPrefixedTranslationKey());
    public static final Item KALE = register("kale", Item::new, new Item.Settings().food(new FoodComponent.Builder().nutrition(6).saturationModifier(0.6f).build()));
    public static final Item OLIEBOL = register("oliebol", Item::new, new Item.Settings().fireproof().food(new FoodComponent.Builder().nutrition(6).saturationModifier(0.8f).build()));
    public static final Item OLIEBOL_SUGAR = register("powdered_sugar_oliebol", Item::new, new Item.Settings().fireproof().food(new FoodComponent.Builder().nutrition(8).saturationModifier(0.8f).build()));
    public static final Item DOUGH_BALL = register("dough_ball", Item::new, new Item.Settings().fireproof().food(new FoodComponent.Builder().nutrition(2).saturationModifier(0.2f).build()));
    public static final Item CHEESE_SOUFLE = register("cheese_soufle", Item::new, new Item.Settings().food(new FoodComponent.Builder().nutrition(6).saturationModifier(0.5f).build()));


    // Special Items ig

    public static final Item KLOMPEN = register(
            "klompen",
            KlompenItem::new,
            new Item.Settings().armor(WoodenArmorMaterial.INSTANCE, EquipmentType.BOOTS)
                    .maxDamage(EquipmentType.HELMET.getMaxDamage(WoodenArmorMaterial.BASE_DURABILITY))
    );



    public static Item register(String name, Function<Item.Settings, Item> itemFactory, Item.Settings settings) {
        // Create the item key.
        RegistryKey<Item> itemKey = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(DutchFoodsnStuff.MOD_ID, name));

        // Create the item instance.
        Item item = itemFactory.apply(settings.registryKey(itemKey));

        // Register the items.
        Registry.register(Registries.ITEM, itemKey, item);




        return item;
    }


    // Make Custom Item Group(s)
    public static final RegistryKey<ItemGroup> DUTCH_FOODS_ITEMGROUP = RegistryKey.of(Registries.ITEM_GROUP.getKey(), Identifier.of(DutchFoodsnStuff.MOD_ID, "dutch_foods_items"));
    public static final ItemGroup DUTCH_ITEM_GROUP = FabricItemGroup.builder()
            .icon(() -> new ItemStack(ModItems.CHEESE))
            .displayName(Text.translatable("itemGroup.dutch_foods_items"))
            .build();

    private static final Optional<RegistryKey<LootTable>> TALL_GRASS_LOOT_TABLE_ID = Blocks.TALL_GRASS.getLootTableKey();




    public static void initialize() {

        // Register Item Groups
        Registry.register(Registries.ITEM_GROUP, DUTCH_FOODS_ITEMGROUP, DUTCH_ITEM_GROUP);

        // Add items to custom group
        ItemGroupEvents.modifyEntriesEvent(DUTCH_FOODS_ITEMGROUP).register(itemGroup -> {
            itemGroup.add(ModItems.CHEESE);
            itemGroup.add(ModItems.CHEESE_SLICE);
            itemGroup.add(ModBlocks.CHEESE_BLOCK);
            itemGroup.add(ModItems.CHEESE_SLICER);
            itemGroup.add(ModItems.STROOPWAFEL);
            itemGroup.add(ModItems.OLIEBOL);
            itemGroup.add(ModItems.OLIEBOL_SUGAR);
            itemGroup.add(ModItems.CHEESE_SOUFLE);
            itemGroup.add(ModItems.DOUGH_BALL);
            itemGroup.add(ModItems.KALE);
            itemGroup.add(ModItems.KALE_SEEDS);
            itemGroup.add(ModItems.KLOMPEN);
        });




        // Add the items to item group
        ItemGroupEvents.modifyEntriesEvent((ItemGroups.FOOD_AND_DRINK))
                .register((itemGroup) -> {
                    itemGroup.add(ModItems.CHEESE);
                    itemGroup.add(ModItems.CHEESE_SLICE);
                    itemGroup.add(ModItems.OLIEBOL_SUGAR);
                    itemGroup.add(ModItems.STROOPWAFEL);
                    itemGroup.add(ModItems.CHEESE_SOUFLE);
                    itemGroup.add(ModItems.OLIEBOL);
                    itemGroup.add(ModItems.KALE);
                    itemGroup.add(ModItems.DOUGH_BALL);
                });

        ItemGroupEvents.modifyEntriesEvent((ItemGroups.TOOLS))
                .register((itemGroup) -> {
                    itemGroup.add(ModItems.CHEESE_SLICER);
                });

        ItemGroupEvents.modifyEntriesEvent((ItemGroups.NATURAL))
                .register((itemGroup) -> {
                    itemGroup.add(ModItems.KALE_SEEDS);
                    itemGroup.add(ModItems.KALE);
                });

        // Make items compostable
        CompostingChanceRegistry.INSTANCE.add(ModItems.KALE, 0.65f);
        CompostingChanceRegistry.INSTANCE.add(ModItems.KALE_SEEDS, 0.3f);



        LootTableEvents.MODIFY.register((registryKey, builder, lootTableSource, wrapperLookup) -> {
            if (lootTableSource.isBuiltin() && TALL_GRASS_LOOT_TABLE_ID.isPresent() && TALL_GRASS_LOOT_TABLE_ID.get().equals(registryKey)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .with(ItemEntry.builder(ModItems.KALE_SEEDS).conditionally(RandomChanceLootCondition.builder(0.125f)));

                builder.pool(poolBuilder);
            }
        });

    }

}


