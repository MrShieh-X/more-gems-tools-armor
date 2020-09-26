package net.fabricmc.fabric.test.screenhandler;

import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.recipe.RecipeType;
import net.minecraft.recipe.book.RecipeBookCategory;
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.screen.ScreenHandlerType;

public class ItemUpgradeTableScreenHandler extends net.fabricmc.fabric.test.screenhandler.AbstractItemUpgradeTableScreenHandler {
   public ItemUpgradeTableScreenHandler(int syncId, PlayerInventory playerInventory) {
      super(ScreenHandlerType.FURNACE, RecipeType.SMELTING, RecipeBookCategory.FURNACE, syncId, playerInventory);
   }

   public ItemUpgradeTableScreenHandler(int syncId, PlayerInventory playerInventory, Inventory inventory, PropertyDelegate propertyDelegate) {
      super(ScreenHandlerType.FURNACE, RecipeType.SMELTING, RecipeBookCategory.FURNACE, syncId, playerInventory, inventory, propertyDelegate);
   }
}