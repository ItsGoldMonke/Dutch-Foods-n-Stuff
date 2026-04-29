package me.goldmonke.dutchfoodnstuff.mixin;


import me.goldmonke.dutchfoodnstuff.item.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;


// Mixin to make ModItems.DOUGH_BALL turn into ModItems.OLIEBOL when in lava
@Mixin(BlockBehaviour.class)
public abstract class BlockBehaviourMixin {
    @Inject(method = "entityInside", at = @At("HEAD"), cancellable = true)
    protected void entityInsideInject(BlockState blockState, Level level, BlockPos blockPos, Entity entity, CallbackInfo callbackInfo) {
        if (!blockState.is(Blocks.LAVA)) return;
        if (entity instanceof ItemEntity itemEntity) {
            if (itemEntity.getItem().is(ModItems.DOUGH_BALL.get())) { //check if is dough Ball
                level.playSound(null, blockPos, SoundEvents.GENERIC_BURN, SoundSource.BLOCKS);
                itemEntity.setItem(new ItemStack(ModItems.OLIEBOL, itemEntity.getItem().getCount()));
                callbackInfo.cancel();
            }
        }
    }
}
