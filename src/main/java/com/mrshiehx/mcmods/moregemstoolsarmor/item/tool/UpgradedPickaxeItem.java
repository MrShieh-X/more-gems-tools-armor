package com.mrshiehx.mcmods.moregemstoolsarmor.item.tool;

import net.minecraft.item.ItemStack;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ToolMaterial;

public class UpgradedPickaxeItem extends PickaxeItem {
    public UpgradedPickaxeItem(ToolMaterial material, int attackDamage, float attackSpeed, Settings settings) {
        super(material, attackDamage, attackSpeed, settings);
    }

    @Override
    public boolean hasGlint(ItemStack stack) {
        return true;
    }
}
