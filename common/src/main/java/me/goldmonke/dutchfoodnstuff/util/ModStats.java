package me.goldmonke.dutchfoodnstuff.util;

import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import me.goldmonke.dutchfoodnstuff.DutchFoodsnStuff;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;

public class ModStats {
    private static final DeferredRegister<ResourceLocation> STATS = DeferredRegister.create(DutchFoodsnStuff.MOD_ID, Registries.CUSTOM_STAT);

    public static final RegistrySupplier<ResourceLocation> EAT_STAMPPOT_BOERENKOOL = register("eat_stamppot_boerenkool");
    public static final RegistrySupplier<ResourceLocation> CHEESE_SLICED = register("cheese_sliced");

    private static RegistrySupplier<ResourceLocation> register(String id) {
        return STATS.register(id, () -> ResourceLocation.fromNamespaceAndPath(DutchFoodsnStuff.MOD_ID, id));
    }

    public static void initialize(){
        STATS.register();
    }
}
