package me.goldmonke.dutchfoodnstuff;

import me.goldmonke.dutchfoodnstuff.block.ModBlocks;
import me.goldmonke.dutchfoodnstuff.item.ModItems;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.item.v1.ItemTooltipCallback;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.text.Text;
import net.minecraft.util.Colors;

public class DutchFoodsnStuffClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {

        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), ModBlocks.KALE_CROP);
        ItemTooltipCallback.EVENT.register(((itemStack, tooltipContext, tooltipType, list) -> {
            if (itemStack.isOf(ModItems.KLOMPEN)) {
                list.add(1, Text.translatable("item.dutchfoodsnstuff.klompen.tooltip").withColor(Colors.GRAY));
            } else if (itemStack.isOf(ModItems.DOUGH_BALL)) {
                list.add(1, Text.translatable("item.dutchfoodsnstuff.doughball.tooltip").withColor(Colors.GRAY));
            }
        }));

    }
}
