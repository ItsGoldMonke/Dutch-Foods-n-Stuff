package me.goldmonke.dutchfoodnstuff.mixin;

import me.goldmonke.dutchfoodnstuff.block.ModBlocks;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.material.Fluid;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Map;

@Mixin(ItemBlockRenderTypes.class)
public class RenderLayersMixin {
    @Shadow
    @Final
    private static Map<Block, RenderType> TYPE_BY_BLOCK;
    @Shadow
    @Final
    private static Map<Fluid, RenderType> TYPE_BY_FLUID;

    @Inject(method = "<clinit>*", at = @At("RETURN"))
    private static void onInitialize(CallbackInfo info) {
        TYPE_BY_BLOCK.put(ModBlocks.KALE_CROP.get(), RenderType.cutout());
    }
}