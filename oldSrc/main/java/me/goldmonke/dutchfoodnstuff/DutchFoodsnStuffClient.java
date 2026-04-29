package me.goldmonke.dutchfoodnstuff;

import me.goldmonke.dutchfoodnstuff.item.ModItems;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.item.v1.ItemTooltipCallback;
import net.minecraft.network.chat.Component;
import net.minecraft.util.CommonColors;

public class DutchFoodsnStuffClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {

        ChunkSectionLayerMap.putBlock(ModBlocks.KALE_CROP, ChunkSectionLayer.CUTOUT); // Not needed anymore with 26.1
        ItemTooltipCallback.EVENT.register(((itemStack, tooltipContext, tooltipType, list) -> {
            if (itemStack.is(ModItems.KLOMPEN)) {
                list.add(1, Component.translatable("item.dutchfoodsnstuff.klompen.tooltip").withColor(CommonColors.GRAY));
            } else if (itemStack.is(ModItems.DOUGH_BALL)) {
                list.add(1, Component.translatable("item.dutchfoodsnstuff.doughball.tooltip").withColor(CommonColors.GRAY));
            }
        }));

    }
}
