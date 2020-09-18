package com.mrshiehx.mcmods.moregemstoolsarmor.item.tool.material;

import com.mrshiehx.mcmods.moregemstoolsarmor.MoreGemsToolsArmor;
import com.mrshiehx.mcmods.moregemstoolsarmor.item.tool.MGTAToolTags;
import net.minecraft.item.Items;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.util.Lazy;

import java.util.function.Supplier;

public enum MGTAToolMaterial implements ToolMaterial {
    EMERALD(3, 1710, 9.0F, 4.0F, 18, () -> {
        return Ingredient.ofItems(Items.EMERALD);
    }),
    BROWN_GEM(3, 1710, 9.0F, 4.0F, 18, () -> {
        return Ingredient.ofItems(MoreGemsToolsArmor.brownGem);
    }),
    PURPLE_GEM(3, 1710, 9.0F, 4.0F, 18, () -> {
        return Ingredient.ofItems(MoreGemsToolsArmor.purpleGem);
    }),
    SAPPHIRE(3, 1710, 9.0F, 4.0F, 18, () -> {
        return Ingredient.ofItems(MoreGemsToolsArmor.sapphire);
    }),
    RUBY(3, 1710, 9.0F, 4.0F, 18, () -> {
        return Ingredient.ofItems(MoreGemsToolsArmor.ruby);
    }),
    YELLOW_GEM(3, 1710, 9.0F, 4.0F, 18, () -> {
        return Ingredient.ofItems(MoreGemsToolsArmor.yellowGem);
    }),
    MIXED_GEM(3, 1710, 9.0F, 4.0F, 18, () -> {
        return Ingredient.ofItems(MoreGemsToolsArmor.sapphire,MoreGemsToolsArmor.brownGem,MoreGemsToolsArmor.purpleGem,MoreGemsToolsArmor.ruby,MoreGemsToolsArmor.yellowGem);
    });

    private final int miningLevel;
    private final int itemDurability;
    private final float miningSpeedMultiplier;
    private final float attackDamage;
    private final int enchantability;
    private final Lazy<Ingredient> repairIngredient;

    MGTAToolMaterial(int miningLevel, int itemDurability, float miningSpeedMultiplier, float attackDamage, int enchantability, Supplier<Ingredient> repairIngredient) {
        this.miningLevel = miningLevel;
        this.itemDurability = itemDurability;
        this.miningSpeedMultiplier = miningSpeedMultiplier;
        this.attackDamage = attackDamage;
        this.enchantability = enchantability;
        this.repairIngredient = new Lazy<>(repairIngredient);
    }

    @Override
    public int getDurability() {
        return this.itemDurability;
    }


    @Override
    public float getMiningSpeedMultiplier() {
        return this.miningSpeedMultiplier;
    }

    @Override
    public float getAttackDamage() {
        return this.attackDamage;
    }

    @Override
    public int getMiningLevel() {
        return this.miningLevel;
    }

    @Override
    public int getEnchantability() {
        return this.enchantability;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return this.repairIngredient.get();
    }
}
