package com.mrshiehx.mcmods.moregemstoolsarmor.screen;

import com.mrshiehx.mcmods.moregemstoolsarmor.MoreGemsToolsArmor;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.recipe.Recipe;
import net.minecraft.recipe.RecipeType;
import net.minecraft.recipe.SmeltingRecipe;
import net.minecraft.recipe.book.RecipeBookCategory;
import net.minecraft.screen.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;


public class ItemUpgradeTableScreenHandler extends AbstractItemUpgradeTableScreenHandler {

   public ItemUpgradeTableScreenHandler(int syncId, PlayerInventory playerInventory) {
      super(MoreGemsToolsArmor.itemUpgradeTableScreenHandler, RecipeType.SMELTING, RecipeBookCategory.FURNACE,syncId, playerInventory);
   }

   public ItemUpgradeTableScreenHandler(int syncId, PlayerInventory playerInventory, Inventory inventory, PropertyDelegate propertyDelegate) {
      super(MoreGemsToolsArmor.itemUpgradeTableScreenHandler, RecipeType.SMELTING, RecipeBookCategory.FURNACE, syncId, playerInventory, inventory, propertyDelegate);

   }


   static <T extends Recipe<?>> RecipeType<T> register(final String string) {
      return (RecipeType)Registry.register(Registry.RECIPE_TYPE, (Identifier)(new Identifier(string)), new RecipeType<T>() {
         public String toString() {
            return string;
         }
      });
   }
}