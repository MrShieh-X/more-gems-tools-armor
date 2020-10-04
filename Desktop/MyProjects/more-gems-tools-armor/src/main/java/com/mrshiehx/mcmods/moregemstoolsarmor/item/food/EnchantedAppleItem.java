package com.mrshiehx.mcmods.moregemstoolsarmor.item.food;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class EnchantedAppleItem extends Item {
    public EnchantedAppleItem(Item.Settings settings) {
        super(settings);
    }

    public boolean hasGlint(ItemStack stack) {
        return true;
    }
}