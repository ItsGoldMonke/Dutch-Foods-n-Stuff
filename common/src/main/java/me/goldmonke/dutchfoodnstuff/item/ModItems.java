package me.goldmonke.dutchfoodnstuff.item;

import dev.architectury.event.events.common.LootEvent;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import me.goldmonke.dutchfoodnstuff.DutchFoodsnStuff;
import me.goldmonke.dutchfoodnstuff.block.ModBlocks;
import me.goldmonke.dutchfoodnstuff.item.armor.KlompenItem;
import me.goldmonke.dutchfoodnstuff.item.armor.ModArmorMaterials;
import me.goldmonke.dutchfoodnstuff.item.custom.CheeseSlicer;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.*;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;

public class ModItems {

    // DeferredRegister for Items
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(DutchFoodsnStuff.MOD_ID, Registries.ITEM);

    // Register Normal Items
    public static final RegistrySupplier<Item> CHEESE = ITEMS.register("cheese", () -> new Item(new Item.Properties().arch$tab(CreativeModeTabs.FOOD_AND_DRINKS).food(new FoodProperties.Builder().nutrition(10).saturationModifier(0.5f).build())));
    public static final RegistrySupplier<Item> CHEESE_SLICE = ITEMS.register("cheese_slice", () -> new Item(new Item.Properties().arch$tab(CreativeModeTabs.FOOD_AND_DRINKS).food(new FoodProperties.Builder().nutrition(5).saturationModifier(0.5f).build())));
    public static final RegistrySupplier<Item> CHEESE_SLICER = ITEMS.register("cheese_slicer", () ->
            new CheeseSlicer(
                    ModToolTiers.CHEESE_SLICER,
                    new Item.Properties().arch$tab(CreativeModeTabs.TOOLS_AND_UTILITIES)
            ));
    public static final RegistrySupplier<Item> STROOPWAFEL = ITEMS.register("stroopwafel", () -> new Item(new Item.Properties().arch$tab(CreativeModeTabs.FOOD_AND_DRINKS).food(new FoodProperties.Builder().nutrition(10).saturationModifier(0.5f).effect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 10 * 20, 1), 1.0f).build())));
    public static final RegistrySupplier<Item> KALE = ITEMS.register("kale", () -> new Item(new Item.Properties().arch$tab(CreativeModeTabs.FOOD_AND_DRINKS).food(new FoodProperties.Builder().nutrition(6).saturationModifier(0.6f).build())));
    public static final RegistrySupplier<Item> OLIEBOL = ITEMS.register("oliebol", () -> new Item(new Item.Properties().arch$tab(CreativeModeTabs.FOOD_AND_DRINKS).fireResistant().food(new FoodProperties.Builder().nutrition(6).saturationModifier(0.8f).build())));
    public static final RegistrySupplier<Item> OLIEBOL_SUGAR = ITEMS.register("powdered_sugar_oliebol", () -> new Item(new Item.Properties().arch$tab(CreativeModeTabs.FOOD_AND_DRINKS).fireResistant().food(new FoodProperties.Builder().nutrition(8).saturationModifier(0.8f).build())));
    public static final RegistrySupplier<Item> DOUGH_BALL = ITEMS.register("dough_ball", () -> new Item(new Item.Properties().arch$tab(CreativeModeTabs.FOOD_AND_DRINKS).fireResistant().food(new FoodProperties.Builder().nutrition(2).saturationModifier(0.2f).build())));
    public static final RegistrySupplier<Item> CHEESE_SOUFLE = ITEMS.register("cheese_soufle", () -> new Item(new Item.Properties().arch$tab(CreativeModeTabs.FOOD_AND_DRINKS).food(new FoodProperties.Builder().nutrition(6).saturationModifier(0.5f).build())));
    public static final RegistrySupplier<Item> BITTERBAL = ITEMS.register("bitterbal", () -> new Item(new Item.Properties().arch$tab(CreativeModeTabs.FOOD_AND_DRINKS).food(new FoodProperties.Builder().nutrition(7).saturationModifier(0.6f).build())));

    public static final RegistrySupplier<Item> KLOMPEN = ITEMS.register(
            "klompen",
            () -> new KlompenItem(ModArmorMaterials.WOODEN_ARMOR_MATERIAL, ArmorItem.Type.BOOTS,
                    new Item.Properties().durability(ArmorItem.Type.BOOTS.getDurability(ModArmorMaterials.WOODEN_DURABILITY_MULTIPLIER))
            ));

    // Block Items
    public static final RegistrySupplier<Item> KALE_SEEDS = ITEMS.register("kale_seeds", () -> new ItemNameBlockItem(ModBlocks.KALE_CROP.get(), new Item.Properties().arch$tab(CreativeModeTabs.NATURAL_BLOCKS)));
    public static final RegistrySupplier<Item> CHEESE_BLOCK = ITEMS.register("cheese_block", () -> new BlockItem(ModBlocks.CHEESE_BLOCK.get(), new Item.Properties()));
    public static final RegistrySupplier<Item> BOERENKOOL_POT = ITEMS.register("boerenkool_pot", () -> new BlockItem(ModBlocks.BOERENKOOL_POT.get(), new Item.Properties()));

    public static void initialize() {
        DutchFoodsnStuff.LOGGER.info("Registering Items");
        ITEMS.register();
        // Register Item Groups


        LootEvent.MODIFY_LOOT_TABLE.register((key, context, builtin) -> {
            // Check that the loot table is dirt and built-in
            if (builtin && (Blocks.TALL_GRASS.getLootTable().equals(key) || Blocks.SHORT_GRASS.getLootTable().equals(key))) {
                // Create a loot pool with a single item entry of Items.DIAMOND
                LootPool.Builder pool = LootPool.lootPool().add(LootItem.lootTableItem(ModItems.KALE_SEEDS.get()).when(LootItemRandomChanceCondition.randomChance(0.125f)));
                context.addPool(pool);
            }
        });
    }
}
