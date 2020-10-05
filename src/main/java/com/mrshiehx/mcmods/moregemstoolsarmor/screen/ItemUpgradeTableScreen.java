package com.mrshiehx.mcmods.moregemstoolsarmor.screen;

import com.mrshiehx.mcmods.moregemstoolsarmor.MGTAVariables;
import com.mrshiehx.mcmods.moregemstoolsarmor.recipe.ItemUpgradeTableRecipeBookScreen;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

@Environment(EnvType.CLIENT)
public class ItemUpgradeTableScreen extends AbstractItemUpgradeTableScreen<ItemUpgradeTableScreenHandler> {

    private static final Identifier TEXTURE = new Identifier(MGTAVariables.modid, "textures/gui/container/item_upgrade_table.png");

    public ItemUpgradeTableScreen(ItemUpgradeTableScreenHandler container, PlayerInventory inventory, Text title) {
        super(container, new ItemUpgradeTableRecipeBookScreen(), inventory, title, TEXTURE);
    }
}
