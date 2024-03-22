package net.anobs.railtrail.compat;

import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.anobs.railtrail.RailTrail;
import net.anobs.railtrail.block.ModBlocks;
import net.anobs.railtrail.recipe.MarketRecipe;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;

public class MarketCategory implements IRecipeCategory<MarketRecipe> {
    public static final ResourceLocation UID = new ResourceLocation(RailTrail.MOD_ID, "market");
    public static final ResourceLocation TEXTURE = new ResourceLocation(RailTrail.MOD_ID,
            "textures/gui/market_gui.png");

    public static final RecipeType<MarketRecipe> MARKET_TYPE =
            new RecipeType<>(UID, MarketRecipe.class);

    private final IDrawable background;
    private final IDrawable icon;

    public MarketCategory(IGuiHelper helper) {
        this.background = helper.createDrawable(TEXTURE, 0,0,176,82);
        this.icon = helper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(ModBlocks.MARKET.get()));
    }


    @Override
    public RecipeType<MarketRecipe> getRecipeType() {
        return MARKET_TYPE;
    }

    @Override
    public Component getTitle() {
        return Component.translatable("block.railtrail.market");
    }

    @Override
    public IDrawable getBackground() {
        return this.background;
    }

    @Override
    public IDrawable getIcon() {
        return this.icon;
    }

    @Override
    public void setRecipe(IRecipeLayoutBuilder builder, MarketRecipe recipe, IFocusGroup focuses) {
        builder.addSlot(RecipeIngredientRole.INPUT, 80, 11).addIngredients(recipe.getIngredients().get(0));

        builder.addSlot(RecipeIngredientRole.OUTPUT, 80, 59).addItemStack(recipe.getResultItem(null));

    }
}
