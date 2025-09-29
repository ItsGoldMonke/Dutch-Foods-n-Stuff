package me.goldmonke.dutchfoodnstuff.util;

import me.goldmonke.dutchfoodnstuff.DutchFoodsnStuff;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.stat.StatFormatter;
import net.minecraft.stat.Stats;
import net.minecraft.util.Identifier;

public class ModStats {

    public static final Identifier EAT_STAMPPOT_BOERENKOOL = register("eat_stamppot_boerenkool", StatFormatter.DEFAULT);





    private static Identifier register(String id, StatFormatter formatter) {
        Identifier identifier = Identifier.of(DutchFoodsnStuff.MOD_ID, id);
        Registry.register(Registries.CUSTOM_STAT, id, identifier);
        Stats.CUSTOM.getOrCreateStat(identifier, formatter);
        return identifier;
    }


    public static void initialize(){

    }
}
