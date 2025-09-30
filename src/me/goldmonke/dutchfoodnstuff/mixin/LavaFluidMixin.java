package me.goldmonke.dutchfoodnstuff.mixin;


import me.goldmonke.dutchfoodnstuff.item.ModItems;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityCollisionHandler;
import net.minecraft.entity.ItemEntity;
import net.minecraft.fluid.LavaFluid;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;


// Mixin to make ModItems.DOUGH_BALL turn into ModItems.OLIEBOL when in lava
@Mixin(LavaFluid.class)
public abstract class LavaFluidMixin {
    @Inject(method = "onEntityCollision", at = @At("HEAD"), cancellable = true)
    protected void onEntityCollisionMixin(World world, BlockPos pos, Entity entity, EntityCollisionHandler handler, CallbackInfo callbackInfo) {
        if (entity instanceof ItemEntity itemEntity) {
            if (itemEntity.getStack().isOf(ModItems.DOUGH_BALL)) { //check if is dough Ball
                world.playSound(null, pos, SoundEvents.ENTITY_GENERIC_BURN, SoundCategory.BLOCKS);
                itemEntity.setStack(new ItemStack(ModItems.OLIEBOL, itemEntity.getStack().getCount()));
                callbackInfo.cancel();
            }
        }
    }
}