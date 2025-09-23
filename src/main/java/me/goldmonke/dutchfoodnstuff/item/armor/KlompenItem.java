package me.goldmonke.dutchfoodnstuff.item.armor;

import me.goldmonke.dutchfoodnstuff.item.ModItems;
import net.fabricmc.fabric.api.client.item.v1.ItemTooltipCallback;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import org.jetbrains.annotations.Nullable;

public class KlompenItem extends Item {
    public KlompenItem(Settings settings) {
        super(settings);
    }

    @Override
    public void inventoryTick(ItemStack stack, ServerWorld world, Entity entity, @Nullable EquipmentSlot slot) {
        if (!world.isClient()) {
            if (entity instanceof PlayerEntity player) {
                if (player.getEquippedStack(EquipmentSlot.FEET).isOf(ModItems.KLOMPEN)) {
                    player.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, 5, 0, false, false, false));
                }
            }
        }
        super.inventoryTick(stack, world, entity, slot);
    }


}
