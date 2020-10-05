package com.mrshiehx.mcmods.moregemstoolsarmor.recipe;

import com.mrshiehx.mcmods.moregemstoolsarmor.MoreGemsToolsArmor;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.util.Identifier;

public class UpgradingRecipe extends AbstractUpgradingRecipe {
    public UpgradingRecipe(Identifier id, String group, Ingredient input, ItemStack output, float experience, int upgradeTime) {
        super(MoreGemsToolsArmor.upgrading, id, group, input, output, experience, upgradeTime);
    }

    @Environment(EnvType.CLIENT)
    public ItemStack getRecipeKindIcon() {
        return new ItemStack(MoreGemsToolsArmor.itemUpgradeTable);
    }

    public RecipeSerializer<?> getSerializer() {
        return MoreGemsToolsArmor.upgradingSerializer;
    }
}
