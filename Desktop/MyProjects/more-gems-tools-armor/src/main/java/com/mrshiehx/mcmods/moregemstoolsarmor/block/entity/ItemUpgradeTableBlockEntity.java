package com.mrshiehx.mcmods.moregemstoolsarmor.block.entity;

import com.mrshiehx.mcmods.moregemstoolsarmor.MoreGemsToolsArmor;
import com.mrshiehx.mcmods.moregemstoolsarmor.screen.ItemUpgradeTableScreenHandler;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.recipe.RecipeType;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;

public class ItemUpgradeTableBlockEntity extends AbstractItemUpgradeTableBlockEntity {
   public ItemUpgradeTableBlockEntity() {
      super(MoreGemsToolsArmor.itemUpgradeTableBlockEntity, MoreGemsToolsArmor.upgrading);
   }

   protected Text getContainerName() {
      return new TranslatableText("container.item_upgrade_table");
   }

   protected ScreenHandler createScreenHandler(int syncId, PlayerInventory playerInventory) {
      return new ItemUpgradeTableScreenHandler(syncId, playerInventory, this, this.propertyDelegate);
   }
}
