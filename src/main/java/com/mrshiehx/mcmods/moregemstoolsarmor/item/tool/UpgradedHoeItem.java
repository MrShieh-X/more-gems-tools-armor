package com.mrshiehx.mcmods.moregemstoolsarmor.item.tool;

import net.minecraft.item.HoeItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolMaterial;

public class UpgradedHoeItem extends HoeItem {
    public UpgradedHoeItem(ToolMaterial material, int attackDamage, float attackSpeed, Settings settings) {
        super(material, attackDamage, attackSpeed, settings);
    }

    @Override
    public boolean hasGlint(ItemStack stack) {
        return true;
    }
}
