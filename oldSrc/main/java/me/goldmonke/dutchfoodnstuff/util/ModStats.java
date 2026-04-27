package me.goldmonke.dutchfoodnstuff.util;

import me.goldmonke.dutchfoodnstuff.DutchFoodsnStuff;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.stats.StatFormatter;
import net.minecraft.stats.Stats;

public class ModStats {

    public static final Identifier EAT_STAMPPOT_BOERENKOOL = register("eat_stamppot_boerenkool", StatFormatter.DEFAULT);
    public static final Identifier CHEESE_SLICED = register("cheese_sliced", StatFormatter.DEFAULT);





    private static Identifier register(String id, StatFormatter formatter) {
        Identifier identifier = Identifier.fromNamespaceAndPath(DutchFoodsnStuff.MOD_ID, id);
        Registry.register(BuiltInRegistries.CUSTOM_STAT, id, identifier);
        Stats.CUSTOM.get(identifier, formatter);
        return identifier;
    }


    public static void initialize(){

    }
}
