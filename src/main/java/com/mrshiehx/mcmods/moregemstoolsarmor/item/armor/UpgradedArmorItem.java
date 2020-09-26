package com.mrshiehx.mcmods.moregemstoolsarmor.item.armor;

import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.ItemStack;

public class UpgradedArmorItem extends ArmorItem {
    public UpgradedArmorItem(ArmorMaterial material, EquipmentSlot slot, Settings settings) {
        super(material, slot, settings);
    }

    @Override
    public boolean hasGlint(ItemStack stack) {
        return true;
    }
}
