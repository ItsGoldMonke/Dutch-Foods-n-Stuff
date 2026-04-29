package me.goldmonke.dutchfoodnstuff;

import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import me.goldmonke.dutchfoodnstuff.block.ModBlocks;
import me.goldmonke.dutchfoodnstuff.item.ModItems;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ModTabs {

    private static final DeferredRegister<CreativeModeTab> TABS = DeferredRegister.create(DutchFoodsnStuff.MOD_ID, Registries.CREATIVE_MODE_TAB);

    // Register the creative tab statically so other classes can reference the RegistrySupplier
    public static final RegistrySupplier<CreativeModeTab> DUTCH_FOODS_TAB = TABS.register("dutch_foods_items", () -> CreativeModeTab.builder(CreativeModeTab.Row.TOP, 1)
            .icon(() -> new ItemStack(ModItems.CHEESE.get()))
            .title(Component.translatable("itemGroup.dutch_foods_items"))
            .displayItems((paremeters, out) -> {
                out.accept(ModItems.CHEESE.get());
                out.accept(ModItems.CHEESE_SLICE.get());
                out.accept(ModBlocks.CHEESE_BLOCK.get());
                out.accept(ModBlocks.BOERENKOOL_POT.get());
                out.accept(ModItems.CHEESE_SLICER.get());
                out.accept(ModItems.STROOPWAFEL.get());
                out.accept(ModItems.OLIEBOL.get());
                out.accept(ModItems.OLIEBOL_SUGAR.get());
                out.accept(ModItems.CHEESE_SOUFLE.get());
                out.accept(ModItems.DOUGH_BALL.get());
                out.accept(ModItems.KALE.get());
                out.accept(ModItems.KALE_SEEDS.get());
                out.accept(ModItems.KLOMPEN.get());
                out.accept(ModItems.BITTERBAL.get());
            })
            .build()
    );


    public static void initialize(){
        // Ensure the deferred register is processed
        TABS.register();
    }
}
