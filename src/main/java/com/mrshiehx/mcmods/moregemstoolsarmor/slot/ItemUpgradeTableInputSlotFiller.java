package com.mrshiehx.mcmods.moregemstoolsarmor.slot;

import it.unimi.dsi.fastutil.ints.IntArrayList;
import it.unimi.dsi.fastutil.ints.IntList;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.InputSlotFiller;
import net.minecraft.recipe.Recipe;
import net.minecraft.recipe.RecipeFinder;
import net.minecraft.screen.AbstractRecipeScreenHandler;
import net.minecraft.screen.slot.Slot;

import java.util.Iterator;

public class ItemUpgradeTableInputSlotFiller<C extends Inventory> extends InputSlotFiller<C> {
    private boolean slotMatchesRecipe;

    public ItemUpgradeTableInputSlotFiller(AbstractRecipeScreenHandler<C> abstractRecipeScreenHandler) {
        super(abstractRecipeScreenHandler);
    }

    protected void fillInputSlots(Recipe<C> recipe, boolean craftAll) {
        this.slotMatchesRecipe = this.craftingScreenHandler.matches(recipe);
        int i = this.recipeFinder.countRecipeCrafts(recipe, (IntList) null);
        if (this.slotMatchesRecipe) {
            ItemStack itemStack = this.craftingScreenHandler.getSlot(0).getStack();
            if (itemStack.isEmpty() || i <= itemStack.getCount()) {
                return;
            }
        }

        int j = this.getAmountToFill(craftAll, i, this.slotMatchesRecipe);
        IntList intList = new IntArrayList();
        if (this.recipeFinder.findRecipe(recipe, intList, j)) {
            if (!this.slotMatchesRecipe) {
                this.returnSlot(this.craftingScreenHandler.getCraftingResultSlotIndex());
                this.returnSlot(0);
            }

            this.fillInputSlot(j, intList);
        }
    }

    protected void returnInputs() {
        this.returnSlot(this.craftingScreenHandler.getCraftingResultSlotIndex());
        super.returnInputs();
    }

    protected void fillInputSlot(int limit, IntList inputs) {
        Iterator<Integer> iterator = inputs.iterator();
        Slot slot = this.craftingScreenHandler.getSlot(0);
        ItemStack itemStack = RecipeFinder.getStackFromId((Integer) iterator.next());
        if (!itemStack.isEmpty()) {
            int i = Math.min(itemStack.getMaxCount(), limit);
            if (this.slotMatchesRecipe) {
                i -= slot.getStack().getCount();
            }

            for (int j = 0; j < i; ++j) {
                this.fillInputSlot(slot, itemStack);
            }

        }
    }
}
