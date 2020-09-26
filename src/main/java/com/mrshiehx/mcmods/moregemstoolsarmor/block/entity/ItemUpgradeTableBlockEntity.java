package com.mrshiehx.mcmods.moregemstoolsarmor.block.entity;

import com.mojang.datafixers.types.Type;
import com.mrshiehx.mcmods.moregemstoolsarmor.MoreGemsToolsArmor;
import com.mrshiehx.mcmods.moregemstoolsarmor.screen.ItemUpgradeTableScreenHandler;
import net.minecraft.MinecraftVersion;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.datafixer.TypeReferences;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.recipe.RecipeType;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.text.LiteralText;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Util;
import net.minecraft.util.registry.Registry;

import java.util.Set;
import java.util.function.Supplier;

public class ItemUpgradeTableBlockEntity extends com.mrshiehx.mcmods.moregemstoolsarmor.block.entity.AbstractItemUpgradeTableBlockEntity {

   public static BlockEntityType<ItemUpgradeTableBlockEntity> itemUpgradeTable;
   public ItemUpgradeTableBlockEntity() {
      super(itemUpgradeTable, RecipeType.SMELTING);
   }

   protected Text getContainerName() {
      return new TranslatableText("container.item_upgrade_table");
   }

   protected ScreenHandler createScreenHandler(int syncId, PlayerInventory playerInventory) {
      return new ItemUpgradeTableScreenHandler(syncId, playerInventory, this, this.propertyDelegate);

     }
static {
   itemUpgradeTable = create("item_upgrade_table", BlockEntityType.Builder.create(ItemUpgradeTableBlockEntity::new, MoreGemsToolsArmor.itemUpgradeTable));

}

   private static <T extends BlockEntity> BlockEntityType<T> create(String string, BlockEntityType.Builder<T> builder) {

      Type<?> type = Util.getChoiceType(TypeReferences.BLOCK_ENTITY, string);
      return (BlockEntityType) Registry.register(Registry.BLOCK_ENTITY_TYPE, (String)string, builder.build(type));
   }


}

