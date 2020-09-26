package net.fabricmc.fabric.test.screenhandler;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.test.screenhandler.ItemUpgradeTableRecipeBookScreen;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

@Environment(EnvType.CLIENT)
public class ItemUpgradeTableScreen extends AbstractItemUpgradeTableScreen<ItemUpgradeTableScreenHandler> {
   private static final Identifier TEXTURE = new Identifier(ScreenHandlerTest.ID,"textures/gui/container/item_upgrade_table.png");

   public ItemUpgradeTableScreen(ItemUpgradeTableScreenHandler container, PlayerInventory inventory, Text title) {
      super(container, new ItemUpgradeTableRecipeBookScreen(), inventory, title, TEXTURE);
   }
}
