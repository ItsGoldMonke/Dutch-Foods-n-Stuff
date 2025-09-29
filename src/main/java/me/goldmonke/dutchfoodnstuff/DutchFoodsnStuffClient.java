package me.goldmonke.dutchfoodnstuff;

import me.goldmonke.dutchfoodnstuff.block.ModBlocks;
import me.goldmonke.dutchfoodnstuff.item.ModItems;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.item.v1.ItemTooltipCallback;
import net.fabricmc.fabric.api.client.rendering.v1.BlockRenderLayerMap;
import net.minecraft.client.render.BlockRenderLayer;
import net.minecraft.text.Text;
import net.minecraft.util.Colors;

public class DutchFoodsnStuffClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {

        BlockRenderLayerMap.putBlock(ModBlocks.KALE_CROP, BlockRenderLayer.CUTOUT);
        ItemTooltipCallback.EVENT.register(((itemStack, tooltipContext, tooltipType, list) -> {
            if (itemStack.isOf(ModItems.KLOMPEN)) {
                list.add(1, Text.translatable("item.dutchfoodsnstuff.klompen.tooltip").withColor(Colors.GRAY));
            } else if (itemStack.isOf(ModItems.DOUGH_BALL)) {
                list.add(1, Text.translatable("item.dutchfoodsnstuff.doughball.tooltip").withColor(Colors.GRAY));
            }
        }));

    }
}
