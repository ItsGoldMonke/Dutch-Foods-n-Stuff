package me.goldmonke.dutchfoodnstuff.mixin;


import me.goldmonke.dutchfoodnstuff.item.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.InsideBlockEffectApplier;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.material.LavaFluid;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;


// Mixin to make ModItems.DOUGH_BALL turn into ModItems.OLIEBOL when in lava
@Mixin(LavaFluid.class)
public abstract class LavaFluidMixin {
    @Inject(method = "entityInside", at = @At("HEAD"), cancellable = true)
    protected void onEntityCollisionMixin(Level world, BlockPos pos, Entity entity, InsideBlockEffectApplier handler, CallbackInfo callbackInfo) {
        if (entity instanceof ItemEntity itemEntity) {
            if (itemEntity.getItem().is(ModItems.DOUGH_BALL)) { //check if is dough Ball
                world.playSound(null, pos, SoundEvents.GENERIC_BURN, SoundSource.BLOCKS);
                itemEntity.setItem(new ItemStack(ModItems.OLIEBOL, itemEntity.getItem().getCount()));
                callbackInfo.cancel();
            }
        }
    }
}