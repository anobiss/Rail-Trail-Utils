package net.anobs.railtrail.recipe;

import net.anobs.railtrail.RailTrail;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModRecipes {
    public static final DeferredRegister<RecipeSerializer<?>> SERIALIZERS =
            DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, RailTrail.MOD_ID);

    public static final RegistryObject<RecipeSerializer<MarketRecipe>> MARKET_SERIALIZER =
            SERIALIZERS.register("market", ()->MarketRecipe.Serializer.INSTANCE);

    public static void register(IEventBus eventBus) {
        SERIALIZERS.register(eventBus);
    }
}
