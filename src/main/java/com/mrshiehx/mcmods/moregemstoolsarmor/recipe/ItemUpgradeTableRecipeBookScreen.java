package net.fabricmc.fabric.test.screenhandler;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.test.screenhandler.AbstractItemUpgradeTableBlockEntity;
import net.minecraft.item.Item;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;

import java.util.Set;

@Environment(EnvType.CLIENT)
public class ItemUpgradeTableRecipeBookScreen extends AbstractItemUpgradeTableRecipeBookScreen {
   private static final Text field_26596 = new TranslatableText("gui.recipebook.toggleRecipes.smeltable");

   protected Text getToggleCraftableButtonText() {
      return field_26596;
   }

   protected Set<Item> getAllowedFuels() {
      return AbstractItemUpgradeTableBlockEntity.createFuelTimeMap().keySet();
   }
}
