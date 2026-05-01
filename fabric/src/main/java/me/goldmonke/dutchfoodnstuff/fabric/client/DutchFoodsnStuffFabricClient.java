package me.goldmonke.dutchfoodnstuff.fabric.client;

import me.goldmonke.dutchfoodnstuff.DutchFoodsnStuffClient;
import me.goldmonke.dutchfoodnstuff.block.ModBlocks;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.layers.RenderLayer;

public final class DutchFoodsnStuffFabricClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        // This entrypoint is suitable for setting up client-specific logic, such as rendering.
        DutchFoodsnStuffClient.initialize();
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.KALE_CROP.get(), RenderType.cutout());
    }
}
