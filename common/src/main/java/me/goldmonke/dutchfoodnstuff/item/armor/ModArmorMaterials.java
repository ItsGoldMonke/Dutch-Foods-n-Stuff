package me.goldmonke.dutchfoodnstuff.item.armor;

import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import me.goldmonke.dutchfoodnstuff.DutchFoodsnStuff;
import me.goldmonke.dutchfoodnstuff.util.ModTags;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.crafting.Ingredient;

import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

public class ModArmorMaterials {
    private static final DeferredRegister<ArmorMaterial> ARMORS = DeferredRegister.create(DutchFoodsnStuff.MOD_ID, Registries.ARMOR_MATERIAL);
    public static ArmorMaterial registerMaterial(String id, Map<ArmorItem.Type, Integer> defensePoints, int enchantability, Holder<SoundEvent> equipSound, Supplier<Ingredient> repairIngredientSupplier, float toughness, float knockBackResistance, boolean dyeable) {
        List<ArmorMaterial.Layer> layers = List.of(
                new ArmorMaterial.Layer(ResourceLocation.fromNamespaceAndPath(DutchFoodsnStuff.MOD_ID, id), "", dyeable)
        );

        ArmorMaterial material = new ArmorMaterial(defensePoints, enchantability, equipSound, repairIngredientSupplier, layers, toughness, knockBackResistance);

        return material;
    }

    public static final int WOODEN_DURABILITY_MULTIPLIER = 10;
    public static final RegistrySupplier<ArmorMaterial> WOODEN_ARMOR_MATERIAL = ARMORS.register("wooden", () -> {
        return registerMaterial("wooden",
            Map.of(
                    ArmorItem.Type.BOOTS, 3
            ),
            5,
            SoundEvents.ARMOR_EQUIP_LEATHER,
            () -> Ingredient.of(ModTags.Items.REPAIRS_WOODEN_ARMOR),
            0.0F,
            0.0F,
            false);
    });


    public static void initialize() {
        ARMORS.register();
    }
}
