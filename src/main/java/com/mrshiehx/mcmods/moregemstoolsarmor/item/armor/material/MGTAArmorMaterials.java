package com.mrshiehx.mcmods.moregemstoolsarmor.item.armor.material;

import com.mrshiehx.mcmods.moregemstoolsarmor.MoreGemsToolsArmor;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Lazy;

import java.util.function.Supplier;

public enum MGTAArmorMaterials implements ArmorMaterial {

   SAPPHIRE("sapphire", 40, new int[]{4, 7, 9, 4}, 20, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 2.0F, () -> {
      return Ingredient.ofItems(MoreGemsToolsArmor.sapphire);
   }),
   BROWN_GEM("brown_gem", 40, new int[]{4, 7, 9, 4}, 20, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 2.0F, () -> {
      return Ingredient.ofItems(MoreGemsToolsArmor.brownGem);
   }),
   PURPLE_GEM("purple_gem", 40, new int[]{4, 7, 9, 4}, 20, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 2.0F, () -> {
      return Ingredient.ofItems(MoreGemsToolsArmor.purpleGem);
   }),
   RUBY("ruby", 40, new int[]{4, 7, 9, 4}, 20, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 2.0F, () -> {
      return Ingredient.ofItems(MoreGemsToolsArmor.ruby);
   }),
   YELLOW_GEM("yellow_gem", 40, new int[]{4, 7, 9, 4}, 20, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 2.0F, () -> {
      return Ingredient.ofItems(MoreGemsToolsArmor.yellowGem);
   }),
   EMERALD("emerald", 40, new int[]{4, 7, 9, 4}, 20, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 2.0F, () -> {
      return Ingredient.ofItems(Items.EMERALD);
   }),
   MIXED_GEM("mixed_gem", 40, new int[]{4, 7, 9, 4}, 20, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 2.0F, () -> {
      return Ingredient.ofItems(MoreGemsToolsArmor.sapphire,MoreGemsToolsArmor.brownGem,MoreGemsToolsArmor.purpleGem,MoreGemsToolsArmor.ruby,MoreGemsToolsArmor.yellowGem);
   });

   private static final int[] BASE_DURABILITY = new int[]{13, 15, 16, 11};
   private final String name;
   private final int durabilityMultiplier;
   private final int[] protectionAmounts;
   private final int enchantability;
   private final SoundEvent equipSound;
   private final float toughness;
   private final Lazy<Ingredient> repairIngredientSupplier;

   private MGTAArmorMaterials(String name, int durabilityMultiplier, int[] protectionAmounts, int enchantability, SoundEvent equipSound, float toughness, Supplier<Ingredient> ingredientSupplier) {
      this.name = name;
      this.durabilityMultiplier = durabilityMultiplier;
      this.protectionAmounts = protectionAmounts;
      this.enchantability = enchantability;
      this.equipSound = equipSound;
      this.toughness = toughness;
      this.repairIngredientSupplier = new Lazy(ingredientSupplier);
   }

   public int getDurability(EquipmentSlot slot) {
      return BASE_DURABILITY[slot.getEntitySlotId()] * this.durabilityMultiplier;
   }

   public int getProtectionAmount(EquipmentSlot slot) {
      return this.protectionAmounts[slot.getEntitySlotId()];
   }

   public int getEnchantability() {
      return this.enchantability;
   }

   public SoundEvent getEquipSound() {
      return this.equipSound;
   }

   public Ingredient getRepairIngredient() {
      return (Ingredient)this.repairIngredientSupplier.get();
   }

   @Environment(EnvType.CLIENT)
   public String getName() {
      return this.name;
   }

   public float getToughness() {
      return this.toughness;
   }

   @Override
   public float getKnockbackResistance() {
      return 0;
   }
}
