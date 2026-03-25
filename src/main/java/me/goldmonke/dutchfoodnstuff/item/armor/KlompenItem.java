package me.goldmonke.dutchfoodnstuff.item.armor;

import me.goldmonke.dutchfoodnstuff.item.ModItems;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.Nullable;

public class KlompenItem extends Item {
    public KlompenItem(net.minecraft.world.item.Item.Properties settings) {
        super(settings);
    }

    @Override
    public void inventoryTick(ItemStack stack, ServerLevel world, Entity entity, @Nullable EquipmentSlot slot) {
        if (!world.isClientSide()) {
            if (entity instanceof Player player) {
                if (player.getItemBySlot(EquipmentSlot.FEET).is(ModItems.KLOMPEN)) {
                    player.addEffect(new MobEffectInstance(MobEffects.SLOWNESS, 20, 0, false, false, false));
                }
            }
        }
        super.inventoryTick(stack, world, entity, slot);
    }


}
