package com.mrshiehx.mcmods.moregemstoolsarmor.block.entity;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.mrshiehx.mcmods.moregemstoolsarmor.MGTAVariables;
import com.mrshiehx.mcmods.moregemstoolsarmor.MoreGemsToolsArmor;
import com.mrshiehx.mcmods.moregemstoolsarmor.block.AbstractItemUpgradeTableBlock;
import com.mrshiehx.mcmods.moregemstoolsarmor.recipe.AbstractUpgradingRecipe;
import it.unimi.dsi.fastutil.objects.Object2IntMap.Entry;
import it.unimi.dsi.fastutil.objects.Object2IntOpenHashMap;
import it.unimi.dsi.fastutil.objects.ObjectIterator;
import net.minecraft.SharedConstants;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.block.entity.LockableContainerBlockEntity;
import net.minecraft.entity.ExperienceOrbEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.Inventories;
import net.minecraft.inventory.SidedInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.recipe.*;
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.tag.ItemTags;
import net.minecraft.tag.Tag;
import net.minecraft.util.Identifier;
import net.minecraft.util.Tickable;
import net.minecraft.util.Util;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public abstract class AbstractItemUpgradeTableBlockEntity extends LockableContainerBlockEntity implements SidedInventory, RecipeUnlocker, RecipeInputProvider, Tickable {
    private static final int[] TOP_SLOTS = new int[]{0};
    private static final int[] BOTTOM_SLOTS = new int[]{2, 1};
    private static final int[] SIDE_SLOTS = new int[]{1};
    protected DefaultedList<ItemStack> inventory;
    private int burnTime;
    private int fuelTime;
    private int upgradeTime;
    private int upgradeTimeTotal;
    protected final PropertyDelegate propertyDelegate;
    private final Object2IntOpenHashMap<Identifier> recipesUsed;
    protected final RecipeType<? extends AbstractUpgradingRecipe> recipeType;

    protected AbstractItemUpgradeTableBlockEntity(BlockEntityType<?> blockEntityType, RecipeType<? extends AbstractUpgradingRecipe> recipeType) {
        super(blockEntityType);
        this.inventory = DefaultedList.ofSize(3, ItemStack.EMPTY);
        this.propertyDelegate = new PropertyDelegate() {
            public int get(int index) {
                switch (index) {
                    case 0:
                        return AbstractItemUpgradeTableBlockEntity.this.burnTime;
                    case 1:
                        return AbstractItemUpgradeTableBlockEntity.this.fuelTime;
                    case 2:
                        return AbstractItemUpgradeTableBlockEntity.this.upgradeTime;
                    case 3:
                        return AbstractItemUpgradeTableBlockEntity.this.upgradeTimeTotal;
                    default:
                        return 0;
                }
            }

            public void set(int index, int value) {
                switch (index) {
                    case 0:
                        AbstractItemUpgradeTableBlockEntity.this.burnTime = value;
                        break;
                    case 1:
                        AbstractItemUpgradeTableBlockEntity.this.fuelTime = value;
                        break;
                    case 2:
                        AbstractItemUpgradeTableBlockEntity.this.upgradeTime = value;
                        break;
                    case 3:
                        AbstractItemUpgradeTableBlockEntity.this.upgradeTimeTotal = value;
                }

            }

            public int size() {
                return 4;
            }
        };
        this.recipesUsed = new Object2IntOpenHashMap();
        this.recipeType = recipeType;
    }

    public static Map<Item, Integer> createFuelTimeMap() {
        Map<Item, Integer> map = Maps.newLinkedHashMap();
        addFuel(map, (ItemConvertible) MoreGemsToolsArmor.itemUpgradeMaterial, MGTAVariables.itemUpgradeTableUpgradingTime);
        return map;
    }

    private static boolean isNonFlammableWood(Item item) {
        return ItemTags.NON_FLAMMABLE_WOOD.contains(item);
    }

    private static void addFuel(Map<Item, Integer> fuelTimes, Tag<Item> tag, int fuelTime) {
        Iterator var3 = tag.values().iterator();

        while (var3.hasNext()) {
            Item item = (Item) var3.next();
            if (!isNonFlammableWood(item)) {
                fuelTimes.put(item, fuelTime);
            }
        }

    }

    private static void addFuel(Map<Item, Integer> map, ItemConvertible item, int fuelTime) {
        Item item2 = item.asItem();
        if (isNonFlammableWood(item2)) {
            if (SharedConstants.isDevelopment) {
                throw (IllegalStateException) Util.throwOrPause(new IllegalStateException("A developer tried to explicitly make fire resistant item " + item2.getName((ItemStack) null).getString() + " a item upgrade table fuel. That will not work!"));
            }
        } else {
            map.put(item2, fuelTime);
        }
    }

    private boolean isBurning() {
        return this.burnTime > 0;
    }

    public void fromTag(BlockState state, CompoundTag tag) {
        super.fromTag(state, tag);
        this.inventory = DefaultedList.ofSize(this.size(), ItemStack.EMPTY);
        Inventories.fromTag(tag, this.inventory);
        this.burnTime = tag.getShort("BurnTime");
        this.upgradeTime = tag.getShort("UpgradeTime");
        this.upgradeTimeTotal = tag.getShort("UpgradeTimeTotal");
        this.fuelTime = this.getFuelTime((ItemStack) this.inventory.get(1));
        CompoundTag compoundTag = tag.getCompound("RecipesUsed");
        Iterator var4 = compoundTag.getKeys().iterator();

        while (var4.hasNext()) {
            String string = (String) var4.next();
            this.recipesUsed.put(new Identifier(string), compoundTag.getInt(string));
        }

    }

    public CompoundTag toTag(CompoundTag tag) {
        super.toTag(tag);
        tag.putShort("BurnTime", (short) this.burnTime);
        tag.putShort("UpgradeTime", (short) this.upgradeTime);
        tag.putShort("UpgradeTimeTotal", (short) this.upgradeTimeTotal);
        Inventories.toTag(tag, this.inventory);
        CompoundTag compoundTag = new CompoundTag();
        this.recipesUsed.forEach((identifier, integer) -> {
            compoundTag.putInt(identifier.toString(), integer);
        });
        tag.put("RecipesUsed", compoundTag);
        return tag;
    }

    public void tick() {
        boolean bl = this.isBurning();
        boolean bl2 = false;
        if (this.isBurning()) {
            --this.burnTime;
        }

        if (!this.world.isClient) {
            ItemStack itemStack = (ItemStack) this.inventory.get(1);
            if (!this.isBurning() && (itemStack.isEmpty() || ((ItemStack) this.inventory.get(0)).isEmpty())) {
                if (!this.isBurning() && this.upgradeTime > 0) {
                    this.upgradeTime = MathHelper.clamp(this.upgradeTime - 2, 0, this.upgradeTimeTotal);
                }
            } else {
                Recipe<?> recipe = (Recipe) this.world.getRecipeManager().getFirstMatch(this.recipeType, this, this.world).orElse(null);
                if (!this.isBurning() && this.canAcceptRecipeOutput(recipe)) {
                    this.burnTime = this.getFuelTime(itemStack);
                    this.fuelTime = this.burnTime;
                    if (this.isBurning()) {
                        bl2 = true;
                        if (!itemStack.isEmpty()) {
                            Item item = itemStack.getItem();
                            itemStack.decrement(1);
                            if (itemStack.isEmpty()) {
                                Item item2 = item.getRecipeRemainder();
                                this.inventory.set(1, item2 == null ? ItemStack.EMPTY : new ItemStack(item2));
                            }
                        }
                    }
                }

                if (this.isBurning() && this.canAcceptRecipeOutput(recipe)) {
                    ++this.upgradeTime;
                    if (this.upgradeTime == this.upgradeTimeTotal) {
                        this.upgradeTime = 0;
                        this.upgradeTimeTotal = this.getUpgradeTime();
                        this.craftRecipe(recipe);
                        bl2 = true;
                    }
                } else {
                    this.upgradeTime = 0;
                }
            }

            if (bl != this.isBurning()) {
                bl2 = true;
                this.world.setBlockState(this.pos, (BlockState) this.world.getBlockState(this.pos).with(AbstractItemUpgradeTableBlock.LIT, this.isBurning()), 3);
            }
        }

        if (bl2) {
            this.markDirty();
        }

    }

    protected boolean canAcceptRecipeOutput(Recipe<?> recipe) {
        if (!((ItemStack) this.inventory.get(0)).isEmpty() && recipe != null) {
            ItemStack itemStack = recipe.getOutput();
            if (itemStack.isEmpty()) {
                return false;
            } else {
                ItemStack itemStack2 = (ItemStack) this.inventory.get(2);
                if (itemStack2.isEmpty()) {
                    return true;
                } else if (!itemStack2.isItemEqualIgnoreDamage(itemStack)) {
                    return false;
                } else if (itemStack2.getCount() < this.getMaxCountPerStack() && itemStack2.getCount() < itemStack2.getMaxCount()) {
                    return true;
                } else {
                    return itemStack2.getCount() < itemStack.getMaxCount();
                }
            }
        } else {
            return false;
        }
    }

    private void craftRecipe(Recipe<?> recipe) {
        if (recipe != null && this.canAcceptRecipeOutput(recipe)) {
            ItemStack itemStack = (ItemStack) this.inventory.get(0);
            ItemStack itemStack2 = recipe.getOutput();
            ItemStack itemStack3 = (ItemStack) this.inventory.get(2);
            if (itemStack3.isEmpty()) {
                this.inventory.set(2, itemStack2.copy());
            } else if (itemStack3.getItem() == itemStack2.getItem()) {
                itemStack3.increment(1);
            }

            if (!this.world.isClient) {
                this.setLastRecipe(recipe);
            }

            if (itemStack.getItem() == Blocks.WET_SPONGE.asItem() && !((ItemStack) this.inventory.get(1)).isEmpty() && ((ItemStack) this.inventory.get(1)).getItem() == Items.BUCKET) {
                this.inventory.set(1, new ItemStack(Items.WATER_BUCKET));
            }

            itemStack.decrement(1);
        }
    }

    protected int getFuelTime(ItemStack fuel) {
        if (fuel.isEmpty()) {
            return 0;
        } else {
            Item item = fuel.getItem();
            return (Integer) createFuelTimeMap().getOrDefault(item, 0);
        }
    }

    protected int getUpgradeTime() {
        return (Integer) this.world.getRecipeManager().getFirstMatch(this.recipeType, this, this.world).map(AbstractUpgradingRecipe::getUpgradeTime).orElse(200);
    }

    public static boolean canUseAsFuel(ItemStack stack) {
        return createFuelTimeMap().containsKey(stack.getItem());
    }

    public int[] getAvailableSlots(Direction side) {
        if (side == Direction.DOWN) {
            return BOTTOM_SLOTS;
        } else {
            return side == Direction.UP ? TOP_SLOTS : SIDE_SLOTS;
        }
    }

    public boolean canInsert(int slot, ItemStack stack, Direction dir) {
        return this.isValid(slot, stack);
    }

    public boolean canExtract(int slot, ItemStack stack, Direction dir) {
        if (dir == Direction.DOWN && slot == 1) {
            Item item = stack.getItem();
            if (item != Items.WATER_BUCKET && item != Items.BUCKET) {
                return false;
            }
        }

        return true;
    }

    public int size() {
        return this.inventory.size();
    }

    public boolean isEmpty() {
        Iterator var1 = this.inventory.iterator();

        ItemStack itemStack;
        do {
            if (!var1.hasNext()) {
                return true;
            }

            itemStack = (ItemStack) var1.next();
        } while (itemStack.isEmpty());

        return false;
    }

    public ItemStack getStack(int slot) {
        return (ItemStack) this.inventory.get(slot);
    }

    public ItemStack removeStack(int slot, int amount) {
        return Inventories.splitStack(this.inventory, slot, amount);
    }

    public ItemStack removeStack(int slot) {
        return Inventories.removeStack(this.inventory, slot);
    }

    public void setStack(int slot, ItemStack stack) {
        ItemStack itemStack = (ItemStack) this.inventory.get(slot);
        boolean bl = !stack.isEmpty() && stack.isItemEqualIgnoreDamage(itemStack) && ItemStack.areTagsEqual(stack, itemStack);
        this.inventory.set(slot, stack);
        if (stack.getCount() > this.getMaxCountPerStack()) {
            stack.setCount(this.getMaxCountPerStack());
        }

        if (slot == 0 && !bl) {
            this.upgradeTimeTotal = this.getUpgradeTime();
            this.upgradeTime = 0;
            this.markDirty();
        }

    }

    public boolean canPlayerUse(PlayerEntity player) {
        if (this.world.getBlockEntity(this.pos) != this) {
            return false;
        } else {
            return player.squaredDistanceTo((double) this.pos.getX() + 0.5D, (double) this.pos.getY() + 0.5D, (double) this.pos.getZ() + 0.5D) <= 64.0D;
        }
    }

    public boolean isValid(int slot, ItemStack stack) {
        if (slot == 2) {
            return false;
        } else if (slot != 1) {
            return true;
        } else {
            ItemStack itemStack = (ItemStack) this.inventory.get(1);
            return canUseAsFuel(stack) || stack.getItem() == Items.BUCKET && itemStack.getItem() != Items.BUCKET;
        }
    }

    public void clear() {
        this.inventory.clear();
    }

    public void setLastRecipe(Recipe<?> recipe) {
        if (recipe != null) {
            Identifier identifier = recipe.getId();
            this.recipesUsed.addTo(identifier, 1);
        }

    }


    public Recipe<?> getLastRecipe() {
        return null;
    }

    public void unlockLastRecipe(PlayerEntity player) {
    }

    public void dropExperience(PlayerEntity player) {
        List<Recipe<?>> list = this.method_27354(player.world, player.getPos());
        player.unlockRecipes((Collection) list);
        this.recipesUsed.clear();
    }

    public List<Recipe<?>> method_27354(World world, Vec3d vec3d) {
        List<Recipe<?>> list = Lists.newArrayList();
        ObjectIterator var4 = this.recipesUsed.object2IntEntrySet().iterator();

        while (var4.hasNext()) {
            Entry<Identifier> entry = (Entry) var4.next();
            world.getRecipeManager().get((Identifier) entry.getKey()).ifPresent((recipe) -> {
                list.add(recipe);
                dropExperience(world, vec3d, entry.getIntValue(), ((AbstractUpgradingRecipe) recipe).getExperience());
            });
        }

        return list;
    }

    private static void dropExperience(World world, Vec3d vec3d, int i, float f) {
        int j = MathHelper.floor((float) i * f);
        float g = MathHelper.fractionalPart((float) i * f);
        if (g != 0.0F && Math.random() < (double) g) {
            ++j;
        }

        while (j > 0) {
            int k = ExperienceOrbEntity.roundToOrbSize(j);
            j -= k;
            world.spawnEntity(new ExperienceOrbEntity(world, vec3d.x, vec3d.y, vec3d.z, k));
        }

    }

    public void provideRecipeInputs(RecipeFinder finder) {
        Iterator var2 = this.inventory.iterator();

        while (var2.hasNext()) {
            ItemStack itemStack = (ItemStack) var2.next();
            finder.addItem(itemStack);
        }

    }
}
