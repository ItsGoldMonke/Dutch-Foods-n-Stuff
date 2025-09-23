package me.goldmonke.dutchfoodnstuff;

import me.goldmonke.dutchfoodnstuff.block.ModBlocks;
import me.goldmonke.dutchfoodnstuff.item.ModItems;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.client.item.v1.ItemTooltipCallback;
import net.fabricmc.fabric.api.item.v1.DefaultItemComponentEvents;
import net.minecraft.text.Text;
import net.minecraft.util.Colors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DutchFoodsnStuff implements ModInitializer {
	public static final String MOD_ID = "dutchfoodsnstuff";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
        ModItems.initialize();
        ModBlocks.initialize();
        ItemTooltipCallback.EVENT.register(((itemStack, tooltipContext, tooltipType, list) -> {
            if (!itemStack.isOf(ModItems.KLOMPEN)) {
                return;
            }
            list.add(1, Text.translatable("item.dutchfoodsnstuff.klompen.tooltip").withColor(Colors.GRAY));
        }));
    }
}