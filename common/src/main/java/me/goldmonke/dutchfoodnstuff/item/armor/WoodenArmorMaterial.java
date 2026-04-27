//package me.goldmonke.dutchfoodnstuff.item.armor;
//
//import me.goldmonke.dutchfoodnstuff.DutchFoodsnStuff;
//import net.minecraft.core.registries.BuiltInRegistries;
//import net.minecraft.resources.Identifier;
//import net.minecraft.resources.ResourceKey;
//import net.minecraft.sounds.SoundEvents;
//import net.minecraft.tags.TagKey;
//import net.minecraft.world.item.Item;
//import net.minecraft.world.item.equipment.ArmorMaterial;
//import net.minecraft.world.item.equipment.ArmorType;
//import net.minecraft.world.item.equipment.EquipmentAsset;
//import net.minecraft.world.item.equipment.EquipmentAssets;
//import java.util.Map;
//
//public class WoodenArmorMaterial {
//
//    public static final int BASE_DURABILITY = 10;
//
//    public static final ResourceKey<EquipmentAsset> WOODEN_ARMOR_MATERIAL_KEY = ResourceKey.create(EquipmentAssets.ROOT_ID, Identifier.fromNamespaceAndPath(DutchFoodsnStuff.MOD_ID, "wooden"));
//
//    public static final TagKey<Item> REPAIRS_WOODEN_ARMOR = TagKey.create(BuiltInRegistries.ITEM.key(), Identifier.fromNamespaceAndPath(DutchFoodsnStuff.MOD_ID, "repairs_wooden_armor"));
//
//
//    public static final ArmorMaterial INSTANCE = new ArmorMaterial(
//            BASE_DURABILITY,
//            Map.of(
//                    ArmorType.BOOTS, 3
//
//            ),
//            5,
//            SoundEvents.ARMOR_EQUIP_LEATHER,
//            0.0F,
//            0.0F,
//            REPAIRS_WOODEN_ARMOR,
//            WOODEN_ARMOR_MATERIAL_KEY
//    );
//}
