package me.goldmonke.dutchfoodnstuff.item;

import me.goldmonke.dutchfoodnstuff.DutchFoodsnStuff;
import me.goldmonke.dutchfoodnstuff.block.ModBlocks;
import me.goldmonke.dutchfoodnstuff.item.armor.KlompenItem;
import me.goldmonke.dutchfoodnstuff.item.armor.WoodenArmorMaterial;
import me.goldmonke.dutchfoodnstuff.item.custom.CheeseSlicer;
import me.goldmonke.dutchfoodnstuff.util.ModTags;
import net.fabricmc.fabric.api.creativetab.v1.CreativeModeTabEvents;
import net.fabricmc.fabric.api.creativetab.v1.FabricCreativeModeTab;
import net.fabricmc.fabric.api.loot.v3.LootTableEvents;
import net.fabricmc.fabric.api.registry.CompostableRegistry;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ToolMaterial;
import net.minecraft.world.item.component.Consumables;
import net.minecraft.world.item.consume_effects.ApplyStatusEffectsConsumeEffect;
import net.minecraft.world.item.equipment.ArmorType;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
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
    public static final Item CHEESE = register("cheese", Item::new, new Item.Properties().food(new FoodProperties.Builder().nutrition(10).saturationModifier(0.5f).build()));
    public static final Item CHEESE_SLICE = register("cheese_slice", Item::new, new Item.Properties().food(new FoodProperties.Builder().nutrition(5).saturationModifier(0.5f).build()));
    public static final Item CHEESE_SLICER = register("cheese_slicer", CheeseSlicer::new, new Item.Properties().tool(CHEESE_SLICER_TOOL_MATERIAL, ModTags.Blocks.CHEESE_SLICER_MINEABLE, 2.0F, -2.8F, 0));
    public static final Item STROOPWAFEL = register("stroopwafel", Item::new, new Item.Properties().food(new FoodProperties.Builder().nutrition(10).saturationModifier(0.5f).build(), Consumables.defaultFood().onConsume(new ApplyStatusEffectsConsumeEffect(new MobEffectInstance(MobEffects.SPEED, 10 * 20, 1), 1.0f)).build()));
    public static final Item KALE_SEEDS = register("kale_seeds", settings -> new BlockItem(ModBlocks.KALE_CROP, settings), new Item.Properties().useItemDescriptionPrefix());
    public static final Item KALE = register("kale", Item::new, new Item.Properties().food(new FoodProperties.Builder().nutrition(6).saturationModifier(0.6f).build()));
    public static final Item OLIEBOL = register("oliebol", Item::new, new Item.Properties().fireResistant().food(new FoodProperties.Builder().nutrition(6).saturationModifier(0.8f).build()));
    public static final Item OLIEBOL_SUGAR = register("powdered_sugar_oliebol", Item::new, new Item.Properties().fireResistant().food(new FoodProperties.Builder().nutrition(8).saturationModifier(0.8f).build()));
    public static final Item DOUGH_BALL = register("dough_ball", Item::new, new Item.Properties().fireResistant().food(new FoodProperties.Builder().nutrition(2).saturationModifier(0.2f).build()));
    public static final Item CHEESE_SOUFLE = register("cheese_soufle", Item::new, new Item.Properties().food(new FoodProperties.Builder().nutrition(6).saturationModifier(0.5f).build()));
    public static final Item BITTERBAL = register("bitterbal", Item::new, new Item.Properties().food(new FoodProperties.Builder().nutrition(7).saturationModifier(0.6f).build()));

    // Special Items ig

    public static final Item KLOMPEN = register(
            "klompen",
            KlompenItem::new,
            new Item.Properties().humanoidArmor(WoodenArmorMaterial.INSTANCE, ArmorType.BOOTS)
                    .durability(ArmorType.HELMET.getDurability(WoodenArmorMaterial.BASE_DURABILITY))
    );



    public static Item register(String name, Function<Item.Properties, Item> itemFactory, Item.Properties settings) {
        // Create the item key.
        ResourceKey<Item> itemKey = ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(DutchFoodsnStuff.MOD_ID, name));

        // Create the item instance.
        Item item = itemFactory.apply(settings.setId(itemKey));

        // Register the items.
        Registry.register(BuiltInRegistries.ITEM, itemKey, item);




        return item;
    }


    // Make Custom Item Group(s)
    public static final ResourceKey<CreativeModeTab> DUTCH_FOODS_ITEMGROUP = ResourceKey.create(BuiltInRegistries.CREATIVE_MODE_TAB.key(), Identifier.fromNamespaceAndPath(DutchFoodsnStuff.MOD_ID, "dutch_foods_items"));
    public static final CreativeModeTab DUTCH_ITEM_GROUP = FabricCreativeModeTab.builder()
            .icon(() -> new ItemStack(ModItems.CHEESE))
            .title(Component.translatable("itemGroup.dutch_foods_items"))
            .build();

    private static final Optional<ResourceKey<LootTable>> TALL_GRASS_LOOT_TABLE_ID = Blocks.TALL_GRASS.getLootTable();




    public static void initialize() {

        // Register Item Groups
        Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB, DUTCH_FOODS_ITEMGROUP, DUTCH_ITEM_GROUP);

        // Add items to custom group
        CreativeModeTabEvents.modifyOutputEvent(DUTCH_FOODS_ITEMGROUP).register(itemGroup -> {
            itemGroup.accept(ModItems.CHEESE);
            itemGroup.accept(ModItems.CHEESE_SLICE);
            itemGroup.accept(ModBlocks.CHEESE_BLOCK);
            itemGroup.accept(ModBlocks.BOERENKOOL_POT);
            itemGroup.accept(ModItems.CHEESE_SLICER);
            itemGroup.accept(ModItems.STROOPWAFEL);
            itemGroup.accept(ModItems.OLIEBOL);
            itemGroup.accept(ModItems.OLIEBOL_SUGAR);
            itemGroup.accept(ModItems.CHEESE_SOUFLE);
            itemGroup.accept(ModItems.DOUGH_BALL);
            itemGroup.accept(ModItems.KALE);
            itemGroup.accept(ModItems.KALE_SEEDS);
            itemGroup.accept(ModItems.KLOMPEN);
            itemGroup.accept(ModItems.BITTERBAL);
        });




        // Add the items to item group
        CreativeModeTabEvents.modifyOutputEvent((CreativeModeTabs.FOOD_AND_DRINKS))
                .register((itemGroup) -> {
                    itemGroup.accept(ModItems.CHEESE);
                    itemGroup.accept(ModItems.CHEESE_SLICE);
                    itemGroup.accept(ModItems.OLIEBOL_SUGAR);
                    itemGroup.accept(ModItems.STROOPWAFEL);
                    itemGroup.accept(ModItems.CHEESE_SOUFLE);
                    itemGroup.accept(ModItems.OLIEBOL);
                    itemGroup.accept(ModItems.KALE);
                    itemGroup.accept(ModItems.DOUGH_BALL);
                    itemGroup.accept(ModItems.BITTERBAL);
                });

        CreativeModeTabEvents.modifyOutputEvent((CreativeModeTabs.TOOLS_AND_UTILITIES))
                .register((itemGroup) -> {
                    itemGroup.accept(ModItems.CHEESE_SLICER);
                });

        CreativeModeTabEvents.modifyOutputEvent((CreativeModeTabs.NATURAL_BLOCKS))
                .register((itemGroup) -> {
                    itemGroup.accept(ModItems.KALE_SEEDS);
                    itemGroup.accept(ModItems.KALE);
                });

        // Make items compostable
        CompostableRegistry.INSTANCE.add(ModItems.KALE, 0.65f);
        CompostableRegistry.INSTANCE.add(ModItems.KALE_SEEDS, 0.3f);



        LootTableEvents.MODIFY.register((registryKey, builder, lootTableSource, wrapperLookup) -> {
            if (lootTableSource.isBuiltin() && TALL_GRASS_LOOT_TABLE_ID.isPresent() && TALL_GRASS_LOOT_TABLE_ID.get().equals(registryKey)) {
                LootPool.Builder poolBuilder = LootPool.lootPool()
                        .add(LootItem.lootTableItem(ModItems.KALE_SEEDS).when(LootItemRandomChanceCondition.randomChance(0.125f)));

                builder.withPool(poolBuilder);
            }
        });

    }

}


