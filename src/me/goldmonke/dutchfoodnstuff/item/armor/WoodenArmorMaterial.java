package me.goldmonke.dutchfoodnstuff.item.armor;

import me.goldmonke.dutchfoodnstuff.DutchFoodsnStuff;
import net.minecraft.item.Item;
import net.minecraft.item.equipment.ArmorMaterial;
import net.minecraft.item.equipment.EquipmentAsset;
import net.minecraft.item.equipment.EquipmentAssetKeys;
import net.minecraft.item.equipment.EquipmentType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;

import java.util.Map;

public class WoodenArmorMaterial {

    public static final int BASE_DURABILITY = 10;

    public static final RegistryKey<EquipmentAsset> WOODEN_ARMOR_MATERIAL_KEY = RegistryKey.of(EquipmentAssetKeys.REGISTRY_KEY, Identifier.of(DutchFoodsnStuff.MOD_ID, "wooden"));

    public static final TagKey<Item> REPAIRS_WOODEN_ARMOR = TagKey.of(Registries.ITEM.getKey(), Identifier.of(DutchFoodsnStuff.MOD_ID, "repairs_wooden_armor"));


    public static final ArmorMaterial INSTANCE = new ArmorMaterial(
            BASE_DURABILITY,
            Map.of(
                    EquipmentType.BOOTS, 3

            ),
            5,
            SoundEvents.ITEM_ARMOR_EQUIP_LEATHER,
            0.0F,
            0.0F,
            REPAIRS_WOODEN_ARMOR,
            WOODEN_ARMOR_MATERIAL_KEY
    );
}
