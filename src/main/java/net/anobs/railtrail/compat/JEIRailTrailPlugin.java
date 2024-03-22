package net.anobs.railtrail.compat;

import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.registration.IGuiHandlerRegistration;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeRegistration;
import net.anobs.railtrail.RailTrail;
import net.anobs.railtrail.recipe.MarketRecipe;
import net.anobs.railtrail.screen.MarketScreen;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.RecipeManager;

import java.util.List;

@JeiPlugin
public class JEIRailTrailPlugin implements IModPlugin {
    @Override
    public ResourceLocation getPluginUid(){
        return new ResourceLocation(RailTrail.MOD_ID, "jei_plugin");
    }

    @Override
    public void registerCategories(IRecipeCategoryRegistration registration) {
        registration.addRecipeCategories(new MarketCategory(registration.getJeiHelpers().getGuiHelper()));

    }

    @Override
    public void registerRecipes(IRecipeRegistration registration) {
        RecipeManager recipeManager = Minecraft.getInstance().level.getRecipeManager();

        List<MarketRecipe> marketRecipes = recipeManager.getAllRecipesFor(MarketRecipe.Type.INSTANCE);
        registration.addRecipes(MarketCategory.MARKET_TYPE, marketRecipes);

    }

    @Override
    public void registerGuiHandlers(IGuiHandlerRegistration registration) {
        registration.addRecipeClickArea(MarketScreen.class, 78,30,20,30,
                MarketCategory.MARKET_TYPE);
    }
}
