package me.goldmonke.dutchfoodnstuff.item.armor;

import me.goldmonke.dutchfoodnstuff.DutchFoodsnStuff;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;

import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

public class WoodenArmorMaterial {

    public static RegistryEntry<ArmorMaterial> registerMaterial(String id, Map<ArmorItem.Type, Integer> defensePoints, int enchantability, RegistryEntry<SoundEvent> equipSound, Supplier<Ingredient> repairIngredientSupplier, float toughness, float knockbackResistance, boolean dyeable) {
        List<ArmorMaterial.Layer> layers = List.of(
                new ArmorMaterial.Layer(Identifier.of(DutchFoodsnStuff.MOD_ID, id), "", dyeable)
        );

        ArmorMaterial material = new ArmorMaterial(defensePoints, enchantability, equipSound, repairIngredientSupplier, layers, toughness, knockbackResistance);

        material = Registry.register(Registries.ARMOR_MATERIAL, Identifier.of(DutchFoodsnStuff.MOD_ID, id), material);

        return RegistryEntry.of(material);
    }

    public static final TagKey<Item> REPAIRS_WOODEN_ARMOR = TagKey.of(Registries.ITEM.getKey(), Identifier.of(DutchFoodsnStuff.MOD_ID, "repairs_wooden_armor"));

    public static final RegistryEntry<ArmorMaterial> WOODEN = registerMaterial("wooden",
            Map.of(
                    ArmorItem.Type.BOOTS, 3
            ),
            5,
            SoundEvents.ITEM_ARMOR_EQUIP_LEATHER,
            () -> Ingredient.fromTag(REPAIRS_WOODEN_ARMOR),
            0.0F,
            0.0F,
            false


            );



    public static final int WOOD_BASE_DURABILITY = 10;
//
//    public static final RegistryKey<EquipmentAsset> WOODEN_ARMOR_MATERIAL_KEY = RegistryKey.of(EquipmentAssetKeys.REGISTRY_KEY, Identifier.of(DutchFoodsnStuff.MOD_ID, "wooden"));






    public static void initialize() {};
}
