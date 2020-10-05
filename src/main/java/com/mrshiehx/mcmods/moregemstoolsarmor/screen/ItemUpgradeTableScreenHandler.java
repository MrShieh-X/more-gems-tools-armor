package com.mrshiehx.mcmods.moregemstoolsarmor.screen;

import com.mrshiehx.mcmods.moregemstoolsarmor.MoreGemsToolsArmor;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.recipe.RecipeInputProvider;
import net.minecraft.recipe.RecipeType;
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.screen.ScreenHandlerType;

public class ItemUpgradeTableScreenHandler extends AbstractItemUpgradeTableScreenHandler {
    public ItemUpgradeTableScreenHandler(int syncId, PlayerInventory playerInventory) {
        super(MoreGemsToolsArmor.itemUpgradeTableScreenHandler, MoreGemsToolsArmor.upgrading, /*RecipeBookCategory.FURNACE, */syncId, playerInventory);
    }

    public ItemUpgradeTableScreenHandler(int syncId, PlayerInventory playerInventory, Inventory inventory, PropertyDelegate propertyDelegate) {
        super(MoreGemsToolsArmor.itemUpgradeTableScreenHandler, MoreGemsToolsArmor.upgrading, /*RecipeBookCategory.FURNACE, */syncId, playerInventory, inventory, propertyDelegate);
    }
}
