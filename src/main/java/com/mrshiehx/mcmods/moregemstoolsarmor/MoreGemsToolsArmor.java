package com.mrshiehx.mcmods.moregemstoolsarmor;

import com.mrshiehx.mcmods.moregemstoolsarmor.block.*;
import com.mrshiehx.mcmods.moregemstoolsarmor.block.entity.ItemUpgradeTableBlockEntity;
import com.mrshiehx.mcmods.moregemstoolsarmor.item.armor.UpgradedArmorItem;
import com.mrshiehx.mcmods.moregemstoolsarmor.item.armor.material.MGTAArmorMaterials;
import com.mrshiehx.mcmods.moregemstoolsarmor.item.food.components.MGTAFoodComponents;
import com.mrshiehx.mcmods.moregemstoolsarmor.item.food.EnchantedAppleItem;
import com.mrshiehx.mcmods.moregemstoolsarmor.item.tool.*;
import com.mrshiehx.mcmods.moregemstoolsarmor.item.tool.material.MGTAToolMaterials;
import com.mrshiehx.mcmods.moregemstoolsarmor.recipe.UpgradingRecipe;
import com.mrshiehx.mcmods.moregemstoolsarmor.recipe.UpgradingRecipeSerializer;
import com.mrshiehx.mcmods.moregemstoolsarmor.screen.ItemUpgradeTableScreenHandler;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.screenhandler.v1.ScreenHandlerRegistry;
import net.fabricmc.fabric.impl.tool.attribute.ToolManagerImpl;
import net.fabricmc.fabric.impl.tool.attribute.handlers.ModdedToolsModdedBlocksToolHandler;
import net.fabricmc.fabric.impl.tool.attribute.handlers.ModdedToolsVanillaBlocksToolHandler;
import net.fabricmc.fabric.impl.tool.attribute.handlers.VanillaToolsModdedBlocksToolHandler;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.*;
import net.minecraft.recipe.*;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.state.property.Properties;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.decorator.Decorator;
import net.minecraft.world.gen.decorator.RangeDecoratorConfig;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;
import java.util.function.ToIntFunction;


public class MoreGemsToolsArmor implements ModInitializer {
    private static final Logger LOGGER = LogManager.getLogger();
    public static final Item sapphire = new Item(new Item.Settings().group(MoreGemsToolsArmor.MOREGEMSTOOLSARMOR_GROUP).maxCount(64));//蓝宝石
    public static final Item brownGem = new Item(new Item.Settings().group(MoreGemsToolsArmor.MOREGEMSTOOLSARMOR_GROUP).maxCount(64));//棕宝石
    public static final Item purpleGem = new Item(new Item.Settings().group(MoreGemsToolsArmor.MOREGEMSTOOLSARMOR_GROUP).maxCount(64));//紫宝石
    public static final Item ruby = new Item(new Item.Settings().group(MoreGemsToolsArmor.MOREGEMSTOOLSARMOR_GROUP).maxCount(64));//红宝石
    public static final Item yellowGem = new Item(new Item.Settings().group(MoreGemsToolsArmor.MOREGEMSTOOLSARMOR_GROUP).maxCount(64));//黄宝石
    public static final Block sapphireBlock = new Block(FabricBlockSettings.of(Material.METAL).strength(5).requiresTool().breakByTool(MGTAToolTags.PICKAXES, 2));//蓝宝石块
    public static final Block brownGemBlock = new Block(FabricBlockSettings.of(Material.METAL).strength(5).requiresTool().breakByTool(MGTAToolTags.PICKAXES, 2));//棕宝石块
    public static final Block purpleGemBlock = new Block(FabricBlockSettings.of(Material.METAL).strength(5).requiresTool().breakByTool(MGTAToolTags.PICKAXES, 2));//紫宝石块
    public static final Block rubyBlock = new Block(FabricBlockSettings.of(Material.METAL).strength(5).requiresTool().breakByTool(MGTAToolTags.PICKAXES, 2));//红宝石块
    public static final Block yellowGemBlock = new Block(FabricBlockSettings.of(Material.METAL).strength(5).requiresTool().breakByTool(MGTAToolTags.PICKAXES, 2));//黄宝石块
    public static final Block sapphireOre = new SapphireOre(FabricBlockSettings.of(Material.STONE).strength(3, 3).requiresTool().breakByTool(MGTAToolTags.PICKAXES, 2));//蓝宝石矿石
    public static final Block brownGemOre = new BrownGemOre(FabricBlockSettings.of(Material.STONE).strength(3, 3).requiresTool().breakByTool(MGTAToolTags.PICKAXES, 2));//棕宝石矿石
    public static final Block purpleGemOre = new PurpleGemOre(FabricBlockSettings.of(Material.STONE).strength(3, 3).requiresTool().breakByTool(MGTAToolTags.PICKAXES, 2));//紫宝石矿石
    public static final Block rubyOre = new RubyOre(FabricBlockSettings.of(Material.STONE).strength(3, 3).requiresTool().breakByTool(MGTAToolTags.PICKAXES, 2));//红宝石矿石
    public static final Block yellowGemOre = new YellowGemOre(FabricBlockSettings.of(Material.STONE).strength(3, 3).requiresTool().breakByTool(MGTAToolTags.PICKAXES, 2));//黄宝石矿石
    public static final Block stoneOfExperience = new StoneOfExperience(FabricBlockSettings.of(Material.STONE).strength(3, 6).requiresTool().breakByTool(MGTAToolTags.PICKAXES, 2));//经验之石
    public static final ArmorItem sapphireHelmet = new ArmorItem(MGTAArmorMaterials.SAPPHIRE, EquipmentSlot.HEAD, new Item.Settings().group(MoreGemsToolsArmor.MOREGEMSTOOLSARMOR_GROUP));
    public static final ArmorItem sapphireChestplate = new ArmorItem(MGTAArmorMaterials.SAPPHIRE, EquipmentSlot.CHEST, new Item.Settings().group(MoreGemsToolsArmor.MOREGEMSTOOLSARMOR_GROUP));
    public static final ArmorItem sapphireLeggings = new ArmorItem(MGTAArmorMaterials.SAPPHIRE, EquipmentSlot.LEGS, new Item.Settings().group(MoreGemsToolsArmor.MOREGEMSTOOLSARMOR_GROUP));
    public static final ArmorItem sapphireBoots = new ArmorItem(MGTAArmorMaterials.SAPPHIRE, EquipmentSlot.FEET, new Item.Settings().group(MoreGemsToolsArmor.MOREGEMSTOOLSARMOR_GROUP));
    public static final ArmorItem brownGemHelmet = new ArmorItem(MGTAArmorMaterials.BROWN_GEM, EquipmentSlot.HEAD, new Item.Settings().group(MoreGemsToolsArmor.MOREGEMSTOOLSARMOR_GROUP));
    public static final ArmorItem brownGemChestplate = new ArmorItem(MGTAArmorMaterials.BROWN_GEM, EquipmentSlot.CHEST, new Item.Settings().group(MoreGemsToolsArmor.MOREGEMSTOOLSARMOR_GROUP));
    public static final ArmorItem brownGemLeggings = new ArmorItem(MGTAArmorMaterials.BROWN_GEM, EquipmentSlot.LEGS, new Item.Settings().group(MoreGemsToolsArmor.MOREGEMSTOOLSARMOR_GROUP));
    public static final ArmorItem brownGemBoots = new ArmorItem(MGTAArmorMaterials.BROWN_GEM, EquipmentSlot.FEET, new Item.Settings().group(MoreGemsToolsArmor.MOREGEMSTOOLSARMOR_GROUP));
    public static final ArmorItem purpleGemHelmet = new ArmorItem(MGTAArmorMaterials.PURPLE_GEM, EquipmentSlot.HEAD, new Item.Settings().group(MoreGemsToolsArmor.MOREGEMSTOOLSARMOR_GROUP));
    public static final ArmorItem purpleGemChestplate = new ArmorItem(MGTAArmorMaterials.PURPLE_GEM, EquipmentSlot.CHEST, new Item.Settings().group(MoreGemsToolsArmor.MOREGEMSTOOLSARMOR_GROUP));
    public static final ArmorItem purpleGemLeggings = new ArmorItem(MGTAArmorMaterials.PURPLE_GEM, EquipmentSlot.LEGS, new Item.Settings().group(MoreGemsToolsArmor.MOREGEMSTOOLSARMOR_GROUP));
    public static final ArmorItem purpleGemBoots = new ArmorItem(MGTAArmorMaterials.PURPLE_GEM, EquipmentSlot.FEET, new Item.Settings().group(MoreGemsToolsArmor.MOREGEMSTOOLSARMOR_GROUP));
    public static final ArmorItem rubyHelmet = new ArmorItem(MGTAArmorMaterials.RUBY, EquipmentSlot.HEAD, new Item.Settings().group(MoreGemsToolsArmor.MOREGEMSTOOLSARMOR_GROUP));
    public static final ArmorItem rubyChestplate = new ArmorItem(MGTAArmorMaterials.RUBY, EquipmentSlot.CHEST, new Item.Settings().group(MoreGemsToolsArmor.MOREGEMSTOOLSARMOR_GROUP));
    public static final ArmorItem rubyLeggings = new ArmorItem(MGTAArmorMaterials.RUBY, EquipmentSlot.LEGS, new Item.Settings().group(MoreGemsToolsArmor.MOREGEMSTOOLSARMOR_GROUP));
    public static final ArmorItem rubyBoots = new ArmorItem(MGTAArmorMaterials.RUBY, EquipmentSlot.FEET, new Item.Settings().group(MoreGemsToolsArmor.MOREGEMSTOOLSARMOR_GROUP));
    public static final ArmorItem yellowGemHelmet = new ArmorItem(MGTAArmorMaterials.YELLOW_GEM, EquipmentSlot.HEAD, new Item.Settings().group(MoreGemsToolsArmor.MOREGEMSTOOLSARMOR_GROUP));
    public static final ArmorItem yellowGemChestplate = new ArmorItem(MGTAArmorMaterials.YELLOW_GEM, EquipmentSlot.CHEST, new Item.Settings().group(MoreGemsToolsArmor.MOREGEMSTOOLSARMOR_GROUP));
    public static final ArmorItem yellowGemLeggings = new ArmorItem(MGTAArmorMaterials.YELLOW_GEM, EquipmentSlot.LEGS, new Item.Settings().group(MoreGemsToolsArmor.MOREGEMSTOOLSARMOR_GROUP));
    public static final ArmorItem yellowGemBoots = new ArmorItem(MGTAArmorMaterials.YELLOW_GEM, EquipmentSlot.FEET, new Item.Settings().group(MoreGemsToolsArmor.MOREGEMSTOOLSARMOR_GROUP));
    public static final ArmorItem emeraldHelmet = new ArmorItem(MGTAArmorMaterials.EMERALD, EquipmentSlot.HEAD, new Item.Settings().group(MoreGemsToolsArmor.MOREGEMSTOOLSARMOR_GROUP));
    public static final ArmorItem emeraldChestplate = new ArmorItem(MGTAArmorMaterials.EMERALD, EquipmentSlot.CHEST, new Item.Settings().group(MoreGemsToolsArmor.MOREGEMSTOOLSARMOR_GROUP));
    public static final ArmorItem emeraldLeggings = new ArmorItem(MGTAArmorMaterials.EMERALD, EquipmentSlot.LEGS, new Item.Settings().group(MoreGemsToolsArmor.MOREGEMSTOOLSARMOR_GROUP));
    public static final ArmorItem emeraldBoots = new ArmorItem(MGTAArmorMaterials.EMERALD, EquipmentSlot.FEET, new Item.Settings().group(MoreGemsToolsArmor.MOREGEMSTOOLSARMOR_GROUP));
    public static final ToolItem brownGemSword = new SwordItem(MGTAToolMaterials.BROWN_GEM, 4, -2.0F, new Item.Settings().group(MoreGemsToolsArmor.MOREGEMSTOOLSARMOR_GROUP));
    public static final ToolItem purpleGemSword = new SwordItem(MGTAToolMaterials.PURPLE_GEM, 4, -2.0F, new Item.Settings().group(MoreGemsToolsArmor.MOREGEMSTOOLSARMOR_GROUP));
    public static final ToolItem sapphireSword = new SwordItem(MGTAToolMaterials.SAPPHIRE, 4, -2.0F, new Item.Settings().group(MoreGemsToolsArmor.MOREGEMSTOOLSARMOR_GROUP));
    public static final ToolItem rubySword = new SwordItem(MGTAToolMaterials.RUBY, 4, -2.0F, new Item.Settings().group(MoreGemsToolsArmor.MOREGEMSTOOLSARMOR_GROUP));
    public static final ToolItem yellowGemSword = new SwordItem(MGTAToolMaterials.YELLOW_GEM, 4, -2.0F, new Item.Settings().group(MoreGemsToolsArmor.MOREGEMSTOOLSARMOR_GROUP));
    public static final ToolItem emeraldSword = new SwordItem(MGTAToolMaterials.EMERALD, 4, -2.0F, new Item.Settings().group(MoreGemsToolsArmor.MOREGEMSTOOLSARMOR_GROUP));
    public static final ToolItem brownGemShovel = new ShovelItem(MGTAToolMaterials.BROWN_GEM, 1.6F, -2.8F, new Item.Settings().group(MoreGemsToolsArmor.MOREGEMSTOOLSARMOR_GROUP));
    public static final ToolItem purpleGemShovel = new ShovelItem(MGTAToolMaterials.PURPLE_GEM, 1.6F, -2.8F, new Item.Settings().group(MoreGemsToolsArmor.MOREGEMSTOOLSARMOR_GROUP));
    public static final ToolItem sapphireShovel = new ShovelItem(MGTAToolMaterials.SAPPHIRE, 1.6F, -2.8F, new Item.Settings().group(MoreGemsToolsArmor.MOREGEMSTOOLSARMOR_GROUP));
    public static final ToolItem rubyShovel = new ShovelItem(MGTAToolMaterials.RUBY, 1.6F, -2.8F, new Item.Settings().group(MoreGemsToolsArmor.MOREGEMSTOOLSARMOR_GROUP));
    public static final ToolItem yellowGemShovel = new ShovelItem(MGTAToolMaterials.YELLOW_GEM, 1.6F, -2.8F, new Item.Settings().group(MoreGemsToolsArmor.MOREGEMSTOOLSARMOR_GROUP));
    public static final ToolItem emeraldShovel = new ShovelItem(MGTAToolMaterials.EMERALD, 1.6F, -2.8F, new Item.Settings().group(MoreGemsToolsArmor.MOREGEMSTOOLSARMOR_GROUP));
    public static final ToolItem brownGemPickaxe = new MGTAPickaxeItem(MGTAToolMaterials.BROWN_GEM, 1, -2.6F, new Item.Settings().group(MoreGemsToolsArmor.MOREGEMSTOOLSARMOR_GROUP));
    public static final ToolItem purpleGemPickaxe = new MGTAPickaxeItem(MGTAToolMaterials.PURPLE_GEM, 1, -2.6F, new Item.Settings().group(MoreGemsToolsArmor.MOREGEMSTOOLSARMOR_GROUP));
    public static final ToolItem sapphirePickaxe = new MGTAPickaxeItem(MGTAToolMaterials.SAPPHIRE, 1, -2.6F, new Item.Settings().group(MoreGemsToolsArmor.MOREGEMSTOOLSARMOR_GROUP));
    public static final ToolItem rubyPickaxe = new MGTAPickaxeItem(MGTAToolMaterials.RUBY, 1, -2.6F, new Item.Settings().group(MoreGemsToolsArmor.MOREGEMSTOOLSARMOR_GROUP));
    public static final ToolItem yellowGemPickaxe = new MGTAPickaxeItem(MGTAToolMaterials.YELLOW_GEM, 1, -2.6F, new Item.Settings().group(MoreGemsToolsArmor.MOREGEMSTOOLSARMOR_GROUP));
    public static final ToolItem emeraldPickaxe = new MGTAPickaxeItem(MGTAToolMaterials.EMERALD, 1, -2.6F, new Item.Settings().group(MoreGemsToolsArmor.MOREGEMSTOOLSARMOR_GROUP));
    public static final ToolItem brownGemAxe = new MGTAAxeItem(MGTAToolMaterials.BROWN_GEM, 6, -2.8F, new Item.Settings().group(MoreGemsToolsArmor.MOREGEMSTOOLSARMOR_GROUP));
    public static final ToolItem purpleGemAxe = new MGTAAxeItem(MGTAToolMaterials.PURPLE_GEM, 6, -2.8F, new Item.Settings().group(MoreGemsToolsArmor.MOREGEMSTOOLSARMOR_GROUP));
    public static final ToolItem sapphireAxe = new MGTAAxeItem(MGTAToolMaterials.SAPPHIRE, 6, -2.8F, new Item.Settings().group(MoreGemsToolsArmor.MOREGEMSTOOLSARMOR_GROUP));
    public static final ToolItem rubyAxe = new MGTAAxeItem(MGTAToolMaterials.RUBY, 6, -2.8F, new Item.Settings().group(MoreGemsToolsArmor.MOREGEMSTOOLSARMOR_GROUP));
    public static final ToolItem yellowGemAxe = new MGTAAxeItem(MGTAToolMaterials.YELLOW_GEM, 6, -2.8F, new Item.Settings().group(MoreGemsToolsArmor.MOREGEMSTOOLSARMOR_GROUP));
    public static final ToolItem emeraldAxe = new MGTAAxeItem(MGTAToolMaterials.EMERALD, 6, -2.8F, new Item.Settings().group(MoreGemsToolsArmor.MOREGEMSTOOLSARMOR_GROUP));
    public static final ToolItem brownGemHoe = new MGTAHoeItem(MGTAToolMaterials.BROWN_GEM, -3, 0.0F, new Item.Settings().group(MoreGemsToolsArmor.MOREGEMSTOOLSARMOR_GROUP));
    public static final ToolItem purpleGemHoe = new MGTAHoeItem(MGTAToolMaterials.PURPLE_GEM, -3, 0.0F, new Item.Settings().group(MoreGemsToolsArmor.MOREGEMSTOOLSARMOR_GROUP));
    public static final ToolItem sapphireHoe = new MGTAHoeItem(MGTAToolMaterials.SAPPHIRE, -3, 0.0F, new Item.Settings().group(MoreGemsToolsArmor.MOREGEMSTOOLSARMOR_GROUP));
    public static final ToolItem rubyHoe = new MGTAHoeItem(MGTAToolMaterials.RUBY, -3, 0.0F, new Item.Settings().group(MoreGemsToolsArmor.MOREGEMSTOOLSARMOR_GROUP));
    public static final ToolItem yellowGemHoe = new MGTAHoeItem(MGTAToolMaterials.YELLOW_GEM, -3, 0.F, new Item.Settings().group(MoreGemsToolsArmor.MOREGEMSTOOLSARMOR_GROUP));
    public static final ToolItem emeraldHoe = new MGTAHoeItem(MGTAToolMaterials.EMERALD, -3, 0.0F, new Item.Settings().group(MoreGemsToolsArmor.MOREGEMSTOOLSARMOR_GROUP));
    public static final Item diamondApple = new Item((new Item.Settings()).group(MoreGemsToolsArmor.MOREGEMSTOOLSARMOR_GROUP).rarity(Rarity.RARE).food(MGTAFoodComponents.DIAMOND_APPLE));
    public static final Item ironApple = new Item((new Item.Settings()).group(MoreGemsToolsArmor.MOREGEMSTOOLSARMOR_GROUP).rarity(Rarity.RARE).food(MGTAFoodComponents.IRON_APPLE));
    public static final Item emeraldApple = new Item((new Item.Settings()).group(MoreGemsToolsArmor.MOREGEMSTOOLSARMOR_GROUP).rarity(Rarity.RARE).food(MGTAFoodComponents.EMERALD_APPLE));
    public static final Item sapphireApple = new Item((new Item.Settings()).group(MoreGemsToolsArmor.MOREGEMSTOOLSARMOR_GROUP).rarity(Rarity.RARE).food(MGTAFoodComponents.SAPPHIRE_APPLE));
    public static final Item brownGemApple = new Item((new Item.Settings()).group(MoreGemsToolsArmor.MOREGEMSTOOLSARMOR_GROUP).rarity(Rarity.RARE).food(MGTAFoodComponents.BROWN_GEM_APPLE));
    public static final Item purpleGemApple = new Item((new Item.Settings()).group(MoreGemsToolsArmor.MOREGEMSTOOLSARMOR_GROUP).rarity(Rarity.RARE).food(MGTAFoodComponents.PURPLE_GEM_APPLE));
    public static final Item rubyApple = new Item((new Item.Settings()).group(MoreGemsToolsArmor.MOREGEMSTOOLSARMOR_GROUP).rarity(Rarity.RARE).food(MGTAFoodComponents.RUBY_APPLE));
    public static final Item yellowGemApple = new Item((new Item.Settings()).group(MoreGemsToolsArmor.MOREGEMSTOOLSARMOR_GROUP).rarity(Rarity.RARE).food(MGTAFoodComponents.YELLOW_GEM_APPLE));
    public static final Item quartzApple = new Item((new Item.Settings()).group(MoreGemsToolsArmor.MOREGEMSTOOLSARMOR_GROUP).rarity(Rarity.RARE).food(MGTAFoodComponents.QUARTZ_APPLE));
    public static final Item netheriteApple = new Item((new Item.Settings()).group(MoreGemsToolsArmor.MOREGEMSTOOLSARMOR_GROUP).rarity(Rarity.RARE).food(MGTAFoodComponents.NETHERITE_APPLE));
    public static final Item enchantedDiamondApple = new EnchantedAppleItem((new Item.Settings()).group(MoreGemsToolsArmor.MOREGEMSTOOLSARMOR_GROUP).rarity(Rarity.EPIC).food(MGTAFoodComponents.ENCHANTED_DIAMOND_APPLE));
    public static final Item enchantedIronApple = new EnchantedAppleItem((new Item.Settings()).group(MoreGemsToolsArmor.MOREGEMSTOOLSARMOR_GROUP).rarity(Rarity.EPIC).food(MGTAFoodComponents.ENCHANTED_IRON_APPLE));
    public static final Item enchantedEmeraldApple = new EnchantedAppleItem((new Item.Settings()).group(MoreGemsToolsArmor.MOREGEMSTOOLSARMOR_GROUP).rarity(Rarity.EPIC).food(MGTAFoodComponents.ENCHANTED_EMERALD_APPLE));
    public static final Item enchantedSapphireApple = new EnchantedAppleItem((new Item.Settings()).group(MoreGemsToolsArmor.MOREGEMSTOOLSARMOR_GROUP).rarity(Rarity.EPIC).food(MGTAFoodComponents.ENCHANTED_SAPPHIRE_APPLE));
    public static final Item enchantedBrownGemApple = new EnchantedAppleItem((new Item.Settings()).group(MoreGemsToolsArmor.MOREGEMSTOOLSARMOR_GROUP).rarity(Rarity.EPIC).food(MGTAFoodComponents.ENCHANTED_BROWN_GEM_APPLE));
    public static final Item enchantedPurpleGemApple = new EnchantedAppleItem((new Item.Settings()).group(MoreGemsToolsArmor.MOREGEMSTOOLSARMOR_GROUP).rarity(Rarity.EPIC).food(MGTAFoodComponents.ENCHANTED_PURPLE_GEM_APPLE));
    public static final Item enchantedRubyApple = new EnchantedAppleItem((new Item.Settings()).group(MoreGemsToolsArmor.MOREGEMSTOOLSARMOR_GROUP).rarity(Rarity.EPIC).food(MGTAFoodComponents.ENCHANTED_RUBY_APPLE));
    public static final Item enchantedYellowGemApple = new EnchantedAppleItem((new Item.Settings()).group(MoreGemsToolsArmor.MOREGEMSTOOLSARMOR_GROUP).rarity(Rarity.EPIC).food(MGTAFoodComponents.ENCHANTED_YELLOW_GEM_APPLE));
    public static final Item enchantedQuartzApple = new EnchantedAppleItem((new Item.Settings()).group(MoreGemsToolsArmor.MOREGEMSTOOLSARMOR_GROUP).rarity(Rarity.EPIC).food(MGTAFoodComponents.ENCHANTED_QUARTZ_APPLE));
    public static final Item enchantedNetheriteApple = new EnchantedAppleItem((new Item.Settings()).group(MoreGemsToolsArmor.MOREGEMSTOOLSARMOR_GROUP).rarity(Rarity.EPIC).food(MGTAFoodComponents.ENCHANTED_NETHERITE_APPLE));
    public static final Item mixedGemApple = new Item((new Item.Settings()).group(MoreGemsToolsArmor.MOREGEMSTOOLSARMOR_GROUP).rarity(Rarity.RARE).food(MGTAFoodComponents.MIXED_GEM_APPLE));
    public static final Item enchantedMixedGemApple = new EnchantedAppleItem((new Item.Settings()).group(MoreGemsToolsArmor.MOREGEMSTOOLSARMOR_GROUP).rarity(Rarity.EPIC).food(MGTAFoodComponents.ENCHANTED_MIXED_GEM_APPLE));
    public static final ToolItem mixedGemSword = new SwordItem(MGTAToolMaterials.MIXED_GEM, 4, -2.0F, new Item.Settings().group(MoreGemsToolsArmor.MOREGEMSTOOLSARMOR_GROUP));
    public static final ToolItem mixedGemShovel = new ShovelItem(MGTAToolMaterials.MIXED_GEM, 1.6F, -2.8F, new Item.Settings().group(MoreGemsToolsArmor.MOREGEMSTOOLSARMOR_GROUP));
    public static final ToolItem mixedGemPickaxe = new MGTAPickaxeItem(MGTAToolMaterials.MIXED_GEM, 1, -2.6F, new Item.Settings().group(MoreGemsToolsArmor.MOREGEMSTOOLSARMOR_GROUP));
    public static final ToolItem mixedGemAxe = new MGTAAxeItem(MGTAToolMaterials.MIXED_GEM, 6, -2.8F, new Item.Settings().group(MoreGemsToolsArmor.MOREGEMSTOOLSARMOR_GROUP));
    public static final ToolItem mixedGemHoe = new MGTAHoeItem(MGTAToolMaterials.MIXED_GEM, -3, 0.0F, new Item.Settings().group(MoreGemsToolsArmor.MOREGEMSTOOLSARMOR_GROUP));
    public static final ArmorItem mixedGemHelmet = new ArmorItem(MGTAArmorMaterials.MIXED_GEM, EquipmentSlot.HEAD, new Item.Settings().group(MoreGemsToolsArmor.MOREGEMSTOOLSARMOR_GROUP));
    public static final ArmorItem mixedGemChestplate = new ArmorItem(MGTAArmorMaterials.MIXED_GEM, EquipmentSlot.CHEST, new Item.Settings().group(MoreGemsToolsArmor.MOREGEMSTOOLSARMOR_GROUP));
    public static final ArmorItem mixedGemLeggings = new ArmorItem(MGTAArmorMaterials.MIXED_GEM, EquipmentSlot.LEGS, new Item.Settings().group(MoreGemsToolsArmor.MOREGEMSTOOLSARMOR_GROUP));
    public static final ArmorItem mixedGemBoots = new ArmorItem(MGTAArmorMaterials.MIXED_GEM, EquipmentSlot.FEET, new Item.Settings().group(MoreGemsToolsArmor.MOREGEMSTOOLSARMOR_GROUP));
    public static final UpgradedArmorItem upgradedSapphireHelmet = new UpgradedArmorItem(MGTAArmorMaterials.UPGRADED_SAPPHIRE, EquipmentSlot.HEAD, new Item.Settings().group(MoreGemsToolsArmor.MOREGEMSTOOLSARMOR_GROUP).rarity(Rarity.RARE));
    public static final UpgradedArmorItem upgradedSapphireChestplate = new UpgradedArmorItem(MGTAArmorMaterials.UPGRADED_SAPPHIRE, EquipmentSlot.CHEST, new Item.Settings().group(MoreGemsToolsArmor.MOREGEMSTOOLSARMOR_GROUP).rarity(Rarity.RARE));
    public static final UpgradedArmorItem upgradedSapphireLeggings = new UpgradedArmorItem(MGTAArmorMaterials.UPGRADED_SAPPHIRE, EquipmentSlot.LEGS, new Item.Settings().group(MoreGemsToolsArmor.MOREGEMSTOOLSARMOR_GROUP).rarity(Rarity.RARE));
    public static final UpgradedArmorItem upgradedSapphireBoots = new UpgradedArmorItem(MGTAArmorMaterials.UPGRADED_SAPPHIRE, EquipmentSlot.FEET, new Item.Settings().group(MoreGemsToolsArmor.MOREGEMSTOOLSARMOR_GROUP).rarity(Rarity.RARE));
    public static final UpgradedArmorItem upgradedBrownGemHelmet = new UpgradedArmorItem(MGTAArmorMaterials.UPGRADED_BROWN_GEM, EquipmentSlot.HEAD, new Item.Settings().group(MoreGemsToolsArmor.MOREGEMSTOOLSARMOR_GROUP).rarity(Rarity.RARE));
    public static final UpgradedArmorItem upgradedBrownGemChestplate = new UpgradedArmorItem(MGTAArmorMaterials.UPGRADED_BROWN_GEM, EquipmentSlot.CHEST, new Item.Settings().group(MoreGemsToolsArmor.MOREGEMSTOOLSARMOR_GROUP).rarity(Rarity.RARE));
    public static final UpgradedArmorItem upgradedBrownGemLeggings = new UpgradedArmorItem(MGTAArmorMaterials.UPGRADED_BROWN_GEM, EquipmentSlot.LEGS, new Item.Settings().group(MoreGemsToolsArmor.MOREGEMSTOOLSARMOR_GROUP).rarity(Rarity.RARE));
    public static final UpgradedArmorItem upgradedBrownGemBoots = new UpgradedArmorItem(MGTAArmorMaterials.UPGRADED_BROWN_GEM, EquipmentSlot.FEET, new Item.Settings().group(MoreGemsToolsArmor.MOREGEMSTOOLSARMOR_GROUP).rarity(Rarity.RARE));
    public static final UpgradedArmorItem upgradedPurpleGemHelmet = new UpgradedArmorItem(MGTAArmorMaterials.UPGRADED_PURPLE_GEM, EquipmentSlot.HEAD, new Item.Settings().group(MoreGemsToolsArmor.MOREGEMSTOOLSARMOR_GROUP).rarity(Rarity.RARE));
    public static final UpgradedArmorItem upgradedPurpleGemChestplate = new UpgradedArmorItem(MGTAArmorMaterials.UPGRADED_PURPLE_GEM, EquipmentSlot.CHEST, new Item.Settings().group(MoreGemsToolsArmor.MOREGEMSTOOLSARMOR_GROUP).rarity(Rarity.RARE));
    public static final UpgradedArmorItem upgradedPurpleGemLeggings = new UpgradedArmorItem(MGTAArmorMaterials.UPGRADED_PURPLE_GEM, EquipmentSlot.LEGS, new Item.Settings().group(MoreGemsToolsArmor.MOREGEMSTOOLSARMOR_GROUP).rarity(Rarity.RARE));
    public static final UpgradedArmorItem upgradedPurpleGemBoots = new UpgradedArmorItem(MGTAArmorMaterials.UPGRADED_PURPLE_GEM, EquipmentSlot.FEET, new Item.Settings().group(MoreGemsToolsArmor.MOREGEMSTOOLSARMOR_GROUP).rarity(Rarity.RARE));
    public static final UpgradedArmorItem upgradedRubyHelmet = new UpgradedArmorItem(MGTAArmorMaterials.UPGRADED_RUBY, EquipmentSlot.HEAD, new Item.Settings().group(MoreGemsToolsArmor.MOREGEMSTOOLSARMOR_GROUP).rarity(Rarity.RARE));
    public static final UpgradedArmorItem upgradedRubyChestplate = new UpgradedArmorItem(MGTAArmorMaterials.UPGRADED_RUBY, EquipmentSlot.CHEST, new Item.Settings().group(MoreGemsToolsArmor.MOREGEMSTOOLSARMOR_GROUP).rarity(Rarity.RARE));
    public static final UpgradedArmorItem upgradedRubyLeggings = new UpgradedArmorItem(MGTAArmorMaterials.UPGRADED_RUBY, EquipmentSlot.LEGS, new Item.Settings().group(MoreGemsToolsArmor.MOREGEMSTOOLSARMOR_GROUP).rarity(Rarity.RARE));
    public static final UpgradedArmorItem upgradedRubyBoots = new UpgradedArmorItem(MGTAArmorMaterials.UPGRADED_RUBY, EquipmentSlot.FEET, new Item.Settings().group(MoreGemsToolsArmor.MOREGEMSTOOLSARMOR_GROUP).rarity(Rarity.RARE));
    public static final UpgradedArmorItem upgradedYellowGemHelmet = new UpgradedArmorItem(MGTAArmorMaterials.UPGRADED_YELLOW_GEM, EquipmentSlot.HEAD, new Item.Settings().group(MoreGemsToolsArmor.MOREGEMSTOOLSARMOR_GROUP).rarity(Rarity.RARE));
    public static final UpgradedArmorItem upgradedYellowGemChestplate = new UpgradedArmorItem(MGTAArmorMaterials.UPGRADED_YELLOW_GEM, EquipmentSlot.CHEST, new Item.Settings().group(MoreGemsToolsArmor.MOREGEMSTOOLSARMOR_GROUP).rarity(Rarity.RARE));
    public static final UpgradedArmorItem upgradedYellowGemLeggings = new UpgradedArmorItem(MGTAArmorMaterials.UPGRADED_YELLOW_GEM, EquipmentSlot.LEGS, new Item.Settings().group(MoreGemsToolsArmor.MOREGEMSTOOLSARMOR_GROUP).rarity(Rarity.RARE));
    public static final UpgradedArmorItem upgradedYellowGemBoots = new UpgradedArmorItem(MGTAArmorMaterials.UPGRADED_YELLOW_GEM, EquipmentSlot.FEET, new Item.Settings().group(MoreGemsToolsArmor.MOREGEMSTOOLSARMOR_GROUP).rarity(Rarity.RARE));
    public static final UpgradedArmorItem upgradedEmeraldHelmet = new UpgradedArmorItem(MGTAArmorMaterials.UPGRADED_EMERALD, EquipmentSlot.HEAD, new Item.Settings().group(MoreGemsToolsArmor.MOREGEMSTOOLSARMOR_GROUP).rarity(Rarity.RARE));
    public static final UpgradedArmorItem upgradedEmeraldChestplate = new UpgradedArmorItem(MGTAArmorMaterials.UPGRADED_EMERALD, EquipmentSlot.CHEST, new Item.Settings().group(MoreGemsToolsArmor.MOREGEMSTOOLSARMOR_GROUP).rarity(Rarity.RARE));
    public static final UpgradedArmorItem upgradedEmeraldLeggings = new UpgradedArmorItem(MGTAArmorMaterials.UPGRADED_EMERALD, EquipmentSlot.LEGS, new Item.Settings().group(MoreGemsToolsArmor.MOREGEMSTOOLSARMOR_GROUP).rarity(Rarity.RARE));
    public static final UpgradedArmorItem upgradedEmeraldBoots = new UpgradedArmorItem(MGTAArmorMaterials.UPGRADED_EMERALD, EquipmentSlot.FEET, new Item.Settings().group(MoreGemsToolsArmor.MOREGEMSTOOLSARMOR_GROUP).rarity(Rarity.RARE));
    public static final ToolItem upgradedBrownGemSword = new UpgradedSwordItem(MGTAToolMaterials.UPGRADED_BROWN_GEM, 4, -2.0F, new Item.Settings().group(MoreGemsToolsArmor.MOREGEMSTOOLSARMOR_GROUP).rarity(Rarity.RARE));
    public static final ToolItem upgradedPurpleGemSword = new UpgradedSwordItem(MGTAToolMaterials.UPGRADED_PURPLE_GEM, 4, -2.0F, new Item.Settings().group(MoreGemsToolsArmor.MOREGEMSTOOLSARMOR_GROUP).rarity(Rarity.RARE));
    public static final ToolItem upgradedSapphireSword = new UpgradedSwordItem(MGTAToolMaterials.UPGRADED_SAPPHIRE, 4, -2.0F, new Item.Settings().group(MoreGemsToolsArmor.MOREGEMSTOOLSARMOR_GROUP).rarity(Rarity.RARE));
    public static final ToolItem upgradedRubySword = new UpgradedSwordItem(MGTAToolMaterials.UPGRADED_RUBY, 4, -2.0F, new Item.Settings().group(MoreGemsToolsArmor.MOREGEMSTOOLSARMOR_GROUP).rarity(Rarity.RARE));
    public static final ToolItem upgradedYellowGemSword = new UpgradedSwordItem(MGTAToolMaterials.UPGRADED_YELLOW_GEM, 4, -2.0F, new Item.Settings().group(MoreGemsToolsArmor.MOREGEMSTOOLSARMOR_GROUP).rarity(Rarity.RARE));
    public static final ToolItem upgradedEmeraldSword = new UpgradedSwordItem(MGTAToolMaterials.UPGRADED_EMERALD, 4, -2.0F, new Item.Settings().group(MoreGemsToolsArmor.MOREGEMSTOOLSARMOR_GROUP).rarity(Rarity.RARE));
    public static final ToolItem upgradedBrownGemShovel = new UpgradedShovelItem(MGTAToolMaterials.UPGRADED_BROWN_GEM, 1.6F, -2.8F, new Item.Settings().group(MoreGemsToolsArmor.MOREGEMSTOOLSARMOR_GROUP).rarity(Rarity.RARE));
    public static final ToolItem upgradedPurpleGemShovel = new UpgradedShovelItem(MGTAToolMaterials.UPGRADED_PURPLE_GEM, 1.6F, -2.8F, new Item.Settings().group(MoreGemsToolsArmor.MOREGEMSTOOLSARMOR_GROUP).rarity(Rarity.RARE));
    public static final ToolItem upgradedSapphireShovel = new UpgradedShovelItem(MGTAToolMaterials.UPGRADED_SAPPHIRE, 1.6F, -2.8F, new Item.Settings().group(MoreGemsToolsArmor.MOREGEMSTOOLSARMOR_GROUP).rarity(Rarity.RARE));
    public static final ToolItem upgradedRubyShovel = new UpgradedShovelItem(MGTAToolMaterials.UPGRADED_RUBY, 1.6F, -2.8F, new Item.Settings().group(MoreGemsToolsArmor.MOREGEMSTOOLSARMOR_GROUP).rarity(Rarity.RARE));
    public static final ToolItem upgradedYellowGemShovel = new UpgradedShovelItem(MGTAToolMaterials.UPGRADED_YELLOW_GEM, 1.6F, -2.8F, new Item.Settings().group(MoreGemsToolsArmor.MOREGEMSTOOLSARMOR_GROUP).rarity(Rarity.RARE));
    public static final ToolItem upgradedEmeraldShovel = new UpgradedShovelItem(MGTAToolMaterials.UPGRADED_EMERALD, 1.6F, -2.8F, new Item.Settings().group(MoreGemsToolsArmor.MOREGEMSTOOLSARMOR_GROUP).rarity(Rarity.RARE));
    public static final ToolItem upgradedBrownGemPickaxe = new UpgradedPickaxeItem(MGTAToolMaterials.UPGRADED_BROWN_GEM, 1, -2.6F, new Item.Settings().group(MoreGemsToolsArmor.MOREGEMSTOOLSARMOR_GROUP).rarity(Rarity.RARE));
    public static final ToolItem upgradedPurpleGemPickaxe = new UpgradedPickaxeItem(MGTAToolMaterials.UPGRADED_PURPLE_GEM, 1, -2.6F, new Item.Settings().group(MoreGemsToolsArmor.MOREGEMSTOOLSARMOR_GROUP).rarity(Rarity.RARE));
    public static final ToolItem upgradedSapphirePickaxe = new UpgradedPickaxeItem(MGTAToolMaterials.UPGRADED_SAPPHIRE, 1, -2.6F, new Item.Settings().group(MoreGemsToolsArmor.MOREGEMSTOOLSARMOR_GROUP).rarity(Rarity.RARE));
    public static final ToolItem upgradedRubyPickaxe = new UpgradedPickaxeItem(MGTAToolMaterials.UPGRADED_RUBY, 1, -2.6F, new Item.Settings().group(MoreGemsToolsArmor.MOREGEMSTOOLSARMOR_GROUP).rarity(Rarity.RARE));
    public static final ToolItem upgradedYellowGemPickaxe = new UpgradedPickaxeItem(MGTAToolMaterials.UPGRADED_YELLOW_GEM, 1, -2.6F, new Item.Settings().group(MoreGemsToolsArmor.MOREGEMSTOOLSARMOR_GROUP).rarity(Rarity.RARE));
    public static final ToolItem upgradedEmeraldPickaxe = new UpgradedPickaxeItem(MGTAToolMaterials.UPGRADED_EMERALD, 1, -2.6F, new Item.Settings().group(MoreGemsToolsArmor.MOREGEMSTOOLSARMOR_GROUP).rarity(Rarity.RARE));
    public static final ToolItem upgradedBrownGemAxe = new UpgradedAxeItem(MGTAToolMaterials.UPGRADED_BROWN_GEM, 6, -2.8F, new Item.Settings().group(MoreGemsToolsArmor.MOREGEMSTOOLSARMOR_GROUP).rarity(Rarity.RARE));
    public static final ToolItem upgradedPurpleGemAxe = new UpgradedAxeItem(MGTAToolMaterials.UPGRADED_PURPLE_GEM, 6, -2.8F, new Item.Settings().group(MoreGemsToolsArmor.MOREGEMSTOOLSARMOR_GROUP).rarity(Rarity.RARE));
    public static final ToolItem upgradedSapphireAxe = new UpgradedAxeItem(MGTAToolMaterials.UPGRADED_SAPPHIRE, 6, -2.8F, new Item.Settings().group(MoreGemsToolsArmor.MOREGEMSTOOLSARMOR_GROUP).rarity(Rarity.RARE));
    public static final ToolItem upgradedRubyAxe = new UpgradedAxeItem(MGTAToolMaterials.UPGRADED_RUBY, 6, -2.8F, new Item.Settings().group(MoreGemsToolsArmor.MOREGEMSTOOLSARMOR_GROUP).rarity(Rarity.RARE));
    public static final ToolItem upgradedYellowGemAxe = new UpgradedAxeItem(MGTAToolMaterials.UPGRADED_YELLOW_GEM, 6, -2.8F, new Item.Settings().group(MoreGemsToolsArmor.MOREGEMSTOOLSARMOR_GROUP).rarity(Rarity.RARE));
    public static final ToolItem upgradedEmeraldAxe = new UpgradedAxeItem(MGTAToolMaterials.UPGRADED_EMERALD, 6, -2.8F, new Item.Settings().group(MoreGemsToolsArmor.MOREGEMSTOOLSARMOR_GROUP).rarity(Rarity.RARE));
    public static final ToolItem upgradedBrownGemHoe = new UpgradedHoeItem(MGTAToolMaterials.UPGRADED_BROWN_GEM, -3, 0.0F, new Item.Settings().group(MoreGemsToolsArmor.MOREGEMSTOOLSARMOR_GROUP).rarity(Rarity.RARE));
    public static final ToolItem upgradedPurpleGemHoe = new UpgradedHoeItem(MGTAToolMaterials.UPGRADED_PURPLE_GEM, -3, 0.0F, new Item.Settings().group(MoreGemsToolsArmor.MOREGEMSTOOLSARMOR_GROUP).rarity(Rarity.RARE));
    public static final ToolItem upgradedSapphireHoe = new UpgradedHoeItem(MGTAToolMaterials.UPGRADED_SAPPHIRE, -3, 0.0F, new Item.Settings().group(MoreGemsToolsArmor.MOREGEMSTOOLSARMOR_GROUP).rarity(Rarity.RARE));
    public static final ToolItem upgradedRubyHoe = new UpgradedHoeItem(MGTAToolMaterials.UPGRADED_RUBY, -3, 0.0F, new Item.Settings().group(MoreGemsToolsArmor.MOREGEMSTOOLSARMOR_GROUP).rarity(Rarity.RARE));
    public static final ToolItem upgradedYellowGemHoe = new UpgradedHoeItem(MGTAToolMaterials.UPGRADED_YELLOW_GEM, -3, 0.F, new Item.Settings().group(MoreGemsToolsArmor.MOREGEMSTOOLSARMOR_GROUP).rarity(Rarity.RARE));
    public static final ToolItem upgradedEmeraldHoe = new UpgradedHoeItem(MGTAToolMaterials.UPGRADED_EMERALD, -3, 0.0F, new Item.Settings().group(MoreGemsToolsArmor.MOREGEMSTOOLSARMOR_GROUP).rarity(Rarity.RARE));
    public static final ToolItem upgradedMixedGemSword = new UpgradedSwordItem(MGTAToolMaterials.UPGRADED_MIXED_GEM, 4, -2.0F, new Item.Settings().group(MoreGemsToolsArmor.MOREGEMSTOOLSARMOR_GROUP).rarity(Rarity.RARE));
    public static final ToolItem upgradedMixedGemShovel = new UpgradedShovelItem(MGTAToolMaterials.UPGRADED_MIXED_GEM, 1.6F, -2.8F, new Item.Settings().group(MoreGemsToolsArmor.MOREGEMSTOOLSARMOR_GROUP).rarity(Rarity.RARE));
    public static final ToolItem upgradedMixedGemPickaxe = new UpgradedPickaxeItem(MGTAToolMaterials.UPGRADED_MIXED_GEM, 1, -2.6F, new Item.Settings().group(MoreGemsToolsArmor.MOREGEMSTOOLSARMOR_GROUP).rarity(Rarity.RARE));
    public static final ToolItem upgradedMixedGemAxe = new UpgradedAxeItem(MGTAToolMaterials.UPGRADED_MIXED_GEM, 6, -2.8F, new Item.Settings().group(MoreGemsToolsArmor.MOREGEMSTOOLSARMOR_GROUP).rarity(Rarity.RARE));
    public static final ToolItem upgradedMixedGemHoe = new UpgradedHoeItem(MGTAToolMaterials.UPGRADED_MIXED_GEM, -3, 0.0F, new Item.Settings().group(MoreGemsToolsArmor.MOREGEMSTOOLSARMOR_GROUP).rarity(Rarity.RARE));
    public static final UpgradedArmorItem upgradedMixedGemHelmet = new UpgradedArmorItem(MGTAArmorMaterials.UPGRADED_MIXED_GEM, EquipmentSlot.HEAD, new Item.Settings().group(MoreGemsToolsArmor.MOREGEMSTOOLSARMOR_GROUP).rarity(Rarity.RARE));
    public static final UpgradedArmorItem upgradedMixedGemChestplate = new UpgradedArmorItem(MGTAArmorMaterials.UPGRADED_MIXED_GEM, EquipmentSlot.CHEST, new Item.Settings().group(MoreGemsToolsArmor.MOREGEMSTOOLSARMOR_GROUP).rarity(Rarity.RARE));
    public static final UpgradedArmorItem upgradedMixedGemLeggings = new UpgradedArmorItem(MGTAArmorMaterials.UPGRADED_MIXED_GEM, EquipmentSlot.LEGS, new Item.Settings().group(MoreGemsToolsArmor.MOREGEMSTOOLSARMOR_GROUP).rarity(Rarity.RARE));
    public static final UpgradedArmorItem upgradedMixedGemBoots = new UpgradedArmorItem(MGTAArmorMaterials.UPGRADED_MIXED_GEM, EquipmentSlot.FEET, new Item.Settings().group(MoreGemsToolsArmor.MOREGEMSTOOLSARMOR_GROUP).rarity(Rarity.RARE));


    public static final Block itemUpgradeTable = new ItemUpgradeTable(FabricBlockSettings.of(Material.STONE).strength(3.5F).lightLevel(createLightLevelFromBlockState(6)).requiresTool().breakByTool(MGTAToolTags.PICKAXES, 1));
    public static final Item itemUpgradeTableItem = new BlockItem(itemUpgradeTable, new Item.Settings().group(ItemGroup.DECORATIONS));
    public static final BlockEntityType<ItemUpgradeTableBlockEntity> itemUpgradeTableBlockEntity = BlockEntityType.Builder.create(ItemUpgradeTableBlockEntity::new, itemUpgradeTable).build(null);
    public static final ScreenHandlerType<ItemUpgradeTableScreenHandler> itemUpgradeTableScreenHandler = ScreenHandlerRegistry.registerSimple(id("item_upgrade_table"), ItemUpgradeTableScreenHandler::new);

    public static Identifier id(String path) {
        return new Identifier(MGTAVariables.modid, path);
    }

    private static ToIntFunction<BlockState> createLightLevelFromBlockState(int litLevel) {
        return (blockState) -> {
            return (Boolean) blockState.get(Properties.LIT) ? litLevel : 0;
        };
    }

    public static final RecipeType<UpgradingRecipe> upgrading = registerRecipeType("upgrading");

    public static final UpgradingRecipeSerializer<UpgradingRecipe> upgradingSerializer = (UpgradingRecipeSerializer) registerRecipeSerializer("upgrading", new UpgradingRecipeSerializer(UpgradingRecipe::new, MGTAVariables.itemUpgradeTableUpgradingTime));

    private static <T extends Recipe<?>> RecipeType<T> registerRecipeType(final String string) {
        return Registry.register(Registry.RECIPE_TYPE, new Identifier(MGTAVariables.modid, string), new RecipeType<T>() {
            public String toString() {
                return string;
            }
        });
    }

    private static <S extends RecipeSerializer<T>, T extends Recipe<?>> S registerRecipeSerializer(String registryName, S serializer) {
        return Registry.register(Registry.RECIPE_SERIALIZER, new Identifier(MGTAVariables.modid, registryName), serializer);
    }


    public static final Item itemUpgradeMaterial = new Item(new Item.Settings().group(MoreGemsToolsArmor.MOREGEMSTOOLSARMOR_GROUP).maxCount(64));
    public static final Item itemUpgradeMaterialShard = new Item(new Item.Settings().group(MoreGemsToolsArmor.MOREGEMSTOOLSARMOR_GROUP).maxCount(64));

    static int gemsOreGenVeinSize = 5;
    static int gemsOreGenBottomOffset = 0;
    static int gemsOreGenMinY = 0;
    static int gemsOreGenMaxY = 48;
    static int gemsOreGenNumberOfVeinsPerChunk = 9;


    public static ConfiguredFeature<?, ?> ORE_BROWN_GEM_ORE = Feature.ORE.configure(new OreFeatureConfig(OreFeatureConfig.Rules.BASE_STONE_OVERWORLD, brownGemOre.getDefaultState(), gemsOreGenVeinSize)).decorate(Decorator.RANGE.configure(new RangeDecoratorConfig(gemsOreGenBottomOffset, gemsOreGenMinY, gemsOreGenMaxY))).spreadHorizontally().repeat(gemsOreGenNumberOfVeinsPerChunk);
    public static ConfiguredFeature<?, ?> ORE_PURPLE_GEM_ORE = Feature.ORE.configure(new OreFeatureConfig(OreFeatureConfig.Rules.BASE_STONE_OVERWORLD, purpleGemOre.getDefaultState(), gemsOreGenVeinSize)).decorate(Decorator.RANGE.configure(new RangeDecoratorConfig(gemsOreGenBottomOffset, gemsOreGenMinY, gemsOreGenMaxY))).spreadHorizontally().repeat(gemsOreGenNumberOfVeinsPerChunk);
    public static ConfiguredFeature<?, ?> ORE_SAPPHIRE_ORE = Feature.ORE.configure(new OreFeatureConfig(OreFeatureConfig.Rules.BASE_STONE_OVERWORLD, sapphireOre.getDefaultState(), gemsOreGenVeinSize)).decorate(Decorator.RANGE.configure(new RangeDecoratorConfig(gemsOreGenBottomOffset, gemsOreGenMinY, gemsOreGenMaxY))).spreadHorizontally().repeat(gemsOreGenNumberOfVeinsPerChunk);
    public static ConfiguredFeature<?, ?> ORE_RUBY_ORE = Feature.ORE.configure(new OreFeatureConfig(OreFeatureConfig.Rules.BASE_STONE_OVERWORLD, rubyOre.getDefaultState(), gemsOreGenVeinSize)).decorate(Decorator.RANGE.configure(new RangeDecoratorConfig(gemsOreGenBottomOffset, gemsOreGenMinY, gemsOreGenMaxY))).spreadHorizontally().repeat(gemsOreGenNumberOfVeinsPerChunk);
    public static ConfiguredFeature<?, ?> ORE_YELLOW_GEM_ORE = Feature.ORE.configure(new OreFeatureConfig(OreFeatureConfig.Rules.BASE_STONE_OVERWORLD, yellowGemOre.getDefaultState(), gemsOreGenVeinSize)).decorate(Decorator.RANGE.configure(new RangeDecoratorConfig(gemsOreGenBottomOffset, gemsOreGenMinY, gemsOreGenMaxY))).spreadHorizontally().repeat(gemsOreGenNumberOfVeinsPerChunk);
    public static ConfiguredFeature<?, ?> ORE_STONE_OF_EXPERIENCE = Feature.ORE.configure(new OreFeatureConfig(OreFeatureConfig.Rules.BASE_STONE_OVERWORLD,
            stoneOfExperience.getDefaultState(),
            4))
            .decorate(Decorator.RANGE.configure(new RangeDecoratorConfig(
                    0,
                    0,
                    64)))
            .spreadHorizontally()
            .repeat(16);


    //创造背包
    public static final ItemGroup MOREGEMSTOOLSARMOR_GROUP = FabricItemGroupBuilder.create(
            new Identifier("moregemstoolsarmor", "main_itemgroup"))
            .icon(() -> new ItemStack(MoreGemsToolsArmor.sapphire))
            .appendItems(stacks ->
            {
                stacks.add(new ItemStack(MoreGemsToolsArmor.sapphire));
                stacks.add(new ItemStack(MoreGemsToolsArmor.brownGem));
                stacks.add(new ItemStack(MoreGemsToolsArmor.purpleGem));
                stacks.add(new ItemStack(MoreGemsToolsArmor.ruby));
                stacks.add(new ItemStack(MoreGemsToolsArmor.yellowGem));
                stacks.add(new ItemStack(MoreGemsToolsArmor.sapphireBlock));
                stacks.add(new ItemStack(MoreGemsToolsArmor.brownGemBlock));
                stacks.add(new ItemStack(MoreGemsToolsArmor.purpleGemBlock));
                stacks.add(new ItemStack(MoreGemsToolsArmor.rubyBlock));
                stacks.add(new ItemStack(MoreGemsToolsArmor.yellowGemBlock));
                stacks.add(new ItemStack(MoreGemsToolsArmor.sapphireOre));
                stacks.add(new ItemStack(MoreGemsToolsArmor.brownGemOre));
                stacks.add(new ItemStack(MoreGemsToolsArmor.purpleGemOre));
                stacks.add(new ItemStack(MoreGemsToolsArmor.rubyOre));
                stacks.add(new ItemStack(MoreGemsToolsArmor.yellowGemOre));
                stacks.add(new ItemStack(MoreGemsToolsArmor.stoneOfExperience));
                stacks.add(new ItemStack(MoreGemsToolsArmor.sapphireHelmet));
                stacks.add(new ItemStack(MoreGemsToolsArmor.sapphireChestplate));
                stacks.add(new ItemStack(MoreGemsToolsArmor.sapphireLeggings));
                stacks.add(new ItemStack(MoreGemsToolsArmor.sapphireBoots));
                stacks.add(new ItemStack(MoreGemsToolsArmor.brownGemHelmet));
                stacks.add(new ItemStack(MoreGemsToolsArmor.brownGemChestplate));
                stacks.add(new ItemStack(MoreGemsToolsArmor.brownGemLeggings));
                stacks.add(new ItemStack(MoreGemsToolsArmor.brownGemBoots));
                stacks.add(new ItemStack(MoreGemsToolsArmor.purpleGemHelmet));
                stacks.add(new ItemStack(MoreGemsToolsArmor.purpleGemChestplate));
                stacks.add(new ItemStack(MoreGemsToolsArmor.purpleGemLeggings));
                stacks.add(new ItemStack(MoreGemsToolsArmor.purpleGemBoots));
                stacks.add(new ItemStack(MoreGemsToolsArmor.rubyHelmet));
                stacks.add(new ItemStack(MoreGemsToolsArmor.rubyChestplate));
                stacks.add(new ItemStack(MoreGemsToolsArmor.rubyLeggings));
                stacks.add(new ItemStack(MoreGemsToolsArmor.rubyBoots));
                stacks.add(new ItemStack(MoreGemsToolsArmor.yellowGemHelmet));
                stacks.add(new ItemStack(MoreGemsToolsArmor.yellowGemChestplate));
                stacks.add(new ItemStack(MoreGemsToolsArmor.yellowGemLeggings));
                stacks.add(new ItemStack(MoreGemsToolsArmor.yellowGemBoots));
                stacks.add(new ItemStack(MoreGemsToolsArmor.emeraldHelmet));
                stacks.add(new ItemStack(MoreGemsToolsArmor.emeraldChestplate));
                stacks.add(new ItemStack(MoreGemsToolsArmor.emeraldLeggings));
                stacks.add(new ItemStack(MoreGemsToolsArmor.emeraldBoots));
                stacks.add(new ItemStack(MoreGemsToolsArmor.mixedGemHelmet));
                stacks.add(new ItemStack(MoreGemsToolsArmor.mixedGemChestplate));
                stacks.add(new ItemStack(MoreGemsToolsArmor.mixedGemLeggings));
                stacks.add(new ItemStack(MoreGemsToolsArmor.mixedGemBoots));
                stacks.add(new ItemStack(MoreGemsToolsArmor.sapphireSword));
                stacks.add(new ItemStack(MoreGemsToolsArmor.sapphireShovel));
                stacks.add(new ItemStack(MoreGemsToolsArmor.sapphirePickaxe));
                stacks.add(new ItemStack(MoreGemsToolsArmor.sapphireAxe));
                stacks.add(new ItemStack(MoreGemsToolsArmor.sapphireHoe));
                stacks.add(new ItemStack(MoreGemsToolsArmor.brownGemSword));
                stacks.add(new ItemStack(MoreGemsToolsArmor.brownGemShovel));
                stacks.add(new ItemStack(MoreGemsToolsArmor.brownGemPickaxe));
                stacks.add(new ItemStack(MoreGemsToolsArmor.brownGemAxe));
                stacks.add(new ItemStack(MoreGemsToolsArmor.brownGemHoe));
                stacks.add(new ItemStack(MoreGemsToolsArmor.purpleGemSword));
                stacks.add(new ItemStack(MoreGemsToolsArmor.purpleGemShovel));
                stacks.add(new ItemStack(MoreGemsToolsArmor.purpleGemPickaxe));
                stacks.add(new ItemStack(MoreGemsToolsArmor.purpleGemAxe));
                stacks.add(new ItemStack(MoreGemsToolsArmor.purpleGemHoe));
                stacks.add(new ItemStack(MoreGemsToolsArmor.rubySword));
                stacks.add(new ItemStack(MoreGemsToolsArmor.rubyShovel));
                stacks.add(new ItemStack(MoreGemsToolsArmor.rubyPickaxe));
                stacks.add(new ItemStack(MoreGemsToolsArmor.rubyAxe));
                stacks.add(new ItemStack(MoreGemsToolsArmor.rubyHoe));
                stacks.add(new ItemStack(MoreGemsToolsArmor.yellowGemSword));
                stacks.add(new ItemStack(MoreGemsToolsArmor.yellowGemShovel));
                stacks.add(new ItemStack(MoreGemsToolsArmor.yellowGemPickaxe));
                stacks.add(new ItemStack(MoreGemsToolsArmor.yellowGemAxe));
                stacks.add(new ItemStack(MoreGemsToolsArmor.yellowGemHoe));
                stacks.add(new ItemStack(MoreGemsToolsArmor.emeraldSword));
                stacks.add(new ItemStack(MoreGemsToolsArmor.emeraldShovel));
                stacks.add(new ItemStack(MoreGemsToolsArmor.emeraldPickaxe));
                stacks.add(new ItemStack(MoreGemsToolsArmor.emeraldAxe));
                stacks.add(new ItemStack(MoreGemsToolsArmor.emeraldHoe));
                stacks.add(new ItemStack(MoreGemsToolsArmor.mixedGemSword));
                stacks.add(new ItemStack(MoreGemsToolsArmor.mixedGemShovel));
                stacks.add(new ItemStack(MoreGemsToolsArmor.mixedGemPickaxe));
                stacks.add(new ItemStack(MoreGemsToolsArmor.mixedGemAxe));
                stacks.add(new ItemStack(MoreGemsToolsArmor.mixedGemHoe));
                stacks.add(new ItemStack(MoreGemsToolsArmor.diamondApple));
                stacks.add(new ItemStack(MoreGemsToolsArmor.ironApple));
                stacks.add(new ItemStack(MoreGemsToolsArmor.emeraldApple));
                stacks.add(new ItemStack(MoreGemsToolsArmor.sapphireApple));
                stacks.add(new ItemStack(MoreGemsToolsArmor.brownGemApple));
                stacks.add(new ItemStack(MoreGemsToolsArmor.purpleGemApple));
                stacks.add(new ItemStack(MoreGemsToolsArmor.rubyApple));
                stacks.add(new ItemStack(MoreGemsToolsArmor.yellowGemApple));
                stacks.add(new ItemStack(MoreGemsToolsArmor.quartzApple));
                stacks.add(new ItemStack(MoreGemsToolsArmor.netheriteApple));
                stacks.add(new ItemStack(MoreGemsToolsArmor.enchantedDiamondApple));
                stacks.add(new ItemStack(MoreGemsToolsArmor.enchantedIronApple));
                stacks.add(new ItemStack(MoreGemsToolsArmor.enchantedEmeraldApple));
                stacks.add(new ItemStack(MoreGemsToolsArmor.enchantedSapphireApple));
                stacks.add(new ItemStack(MoreGemsToolsArmor.enchantedBrownGemApple));
                stacks.add(new ItemStack(MoreGemsToolsArmor.enchantedPurpleGemApple));
                stacks.add(new ItemStack(MoreGemsToolsArmor.enchantedRubyApple));
                stacks.add(new ItemStack(MoreGemsToolsArmor.enchantedYellowGemApple));
                stacks.add(new ItemStack(MoreGemsToolsArmor.enchantedQuartzApple));
                stacks.add(new ItemStack(MoreGemsToolsArmor.enchantedNetheriteApple));
                stacks.add(new ItemStack(MoreGemsToolsArmor.mixedGemApple));
                stacks.add(new ItemStack(MoreGemsToolsArmor.enchantedMixedGemApple));
                stacks.add(new ItemStack(MoreGemsToolsArmor.upgradedSapphireHelmet));
                stacks.add(new ItemStack(MoreGemsToolsArmor.upgradedSapphireChestplate));
                stacks.add(new ItemStack(MoreGemsToolsArmor.upgradedSapphireLeggings));
                stacks.add(new ItemStack(MoreGemsToolsArmor.upgradedSapphireBoots));
                stacks.add(new ItemStack(MoreGemsToolsArmor.upgradedBrownGemHelmet));
                stacks.add(new ItemStack(MoreGemsToolsArmor.upgradedBrownGemChestplate));
                stacks.add(new ItemStack(MoreGemsToolsArmor.upgradedBrownGemLeggings));
                stacks.add(new ItemStack(MoreGemsToolsArmor.upgradedBrownGemBoots));
                stacks.add(new ItemStack(MoreGemsToolsArmor.upgradedPurpleGemHelmet));
                stacks.add(new ItemStack(MoreGemsToolsArmor.upgradedPurpleGemChestplate));
                stacks.add(new ItemStack(MoreGemsToolsArmor.upgradedPurpleGemLeggings));
                stacks.add(new ItemStack(MoreGemsToolsArmor.upgradedPurpleGemBoots));
                stacks.add(new ItemStack(MoreGemsToolsArmor.upgradedRubyHelmet));
                stacks.add(new ItemStack(MoreGemsToolsArmor.upgradedRubyChestplate));
                stacks.add(new ItemStack(MoreGemsToolsArmor.upgradedRubyLeggings));
                stacks.add(new ItemStack(MoreGemsToolsArmor.upgradedRubyBoots));
                stacks.add(new ItemStack(MoreGemsToolsArmor.upgradedYellowGemHelmet));
                stacks.add(new ItemStack(MoreGemsToolsArmor.upgradedYellowGemChestplate));
                stacks.add(new ItemStack(MoreGemsToolsArmor.upgradedYellowGemLeggings));
                stacks.add(new ItemStack(MoreGemsToolsArmor.upgradedYellowGemBoots));
                stacks.add(new ItemStack(MoreGemsToolsArmor.upgradedEmeraldHelmet));
                stacks.add(new ItemStack(MoreGemsToolsArmor.upgradedEmeraldChestplate));
                stacks.add(new ItemStack(MoreGemsToolsArmor.upgradedEmeraldLeggings));
                stacks.add(new ItemStack(MoreGemsToolsArmor.upgradedEmeraldBoots));
                stacks.add(new ItemStack(MoreGemsToolsArmor.upgradedMixedGemHelmet));
                stacks.add(new ItemStack(MoreGemsToolsArmor.upgradedMixedGemChestplate));
                stacks.add(new ItemStack(MoreGemsToolsArmor.upgradedMixedGemLeggings));
                stacks.add(new ItemStack(MoreGemsToolsArmor.upgradedMixedGemBoots));
                stacks.add(new ItemStack(MoreGemsToolsArmor.upgradedSapphireSword));
                stacks.add(new ItemStack(MoreGemsToolsArmor.upgradedSapphireShovel));
                stacks.add(new ItemStack(MoreGemsToolsArmor.upgradedSapphirePickaxe));
                stacks.add(new ItemStack(MoreGemsToolsArmor.upgradedSapphireAxe));
                stacks.add(new ItemStack(MoreGemsToolsArmor.upgradedSapphireHoe));
                stacks.add(new ItemStack(MoreGemsToolsArmor.upgradedBrownGemSword));
                stacks.add(new ItemStack(MoreGemsToolsArmor.upgradedBrownGemShovel));
                stacks.add(new ItemStack(MoreGemsToolsArmor.upgradedBrownGemPickaxe));
                stacks.add(new ItemStack(MoreGemsToolsArmor.upgradedBrownGemAxe));
                stacks.add(new ItemStack(MoreGemsToolsArmor.upgradedBrownGemHoe));
                stacks.add(new ItemStack(MoreGemsToolsArmor.upgradedPurpleGemSword));
                stacks.add(new ItemStack(MoreGemsToolsArmor.upgradedPurpleGemShovel));
                stacks.add(new ItemStack(MoreGemsToolsArmor.upgradedPurpleGemPickaxe));
                stacks.add(new ItemStack(MoreGemsToolsArmor.upgradedPurpleGemAxe));
                stacks.add(new ItemStack(MoreGemsToolsArmor.upgradedPurpleGemHoe));
                stacks.add(new ItemStack(MoreGemsToolsArmor.upgradedRubySword));
                stacks.add(new ItemStack(MoreGemsToolsArmor.upgradedRubyShovel));
                stacks.add(new ItemStack(MoreGemsToolsArmor.upgradedRubyPickaxe));
                stacks.add(new ItemStack(MoreGemsToolsArmor.upgradedRubyAxe));
                stacks.add(new ItemStack(MoreGemsToolsArmor.upgradedRubyHoe));
                stacks.add(new ItemStack(MoreGemsToolsArmor.upgradedYellowGemSword));
                stacks.add(new ItemStack(MoreGemsToolsArmor.upgradedYellowGemShovel));
                stacks.add(new ItemStack(MoreGemsToolsArmor.upgradedYellowGemPickaxe));
                stacks.add(new ItemStack(MoreGemsToolsArmor.upgradedYellowGemAxe));
                stacks.add(new ItemStack(MoreGemsToolsArmor.upgradedYellowGemHoe));
                stacks.add(new ItemStack(MoreGemsToolsArmor.upgradedEmeraldSword));
                stacks.add(new ItemStack(MoreGemsToolsArmor.upgradedEmeraldShovel));
                stacks.add(new ItemStack(MoreGemsToolsArmor.upgradedEmeraldPickaxe));
                stacks.add(new ItemStack(MoreGemsToolsArmor.upgradedEmeraldAxe));
                stacks.add(new ItemStack(MoreGemsToolsArmor.upgradedEmeraldHoe));
                stacks.add(new ItemStack(MoreGemsToolsArmor.upgradedMixedGemSword));
                stacks.add(new ItemStack(MoreGemsToolsArmor.upgradedMixedGemShovel));
                stacks.add(new ItemStack(MoreGemsToolsArmor.upgradedMixedGemPickaxe));
                stacks.add(new ItemStack(MoreGemsToolsArmor.upgradedMixedGemAxe));
                stacks.add(new ItemStack(MoreGemsToolsArmor.upgradedMixedGemHoe));
                stacks.add(new ItemStack(MoreGemsToolsArmor.itemUpgradeTable));
                stacks.add(new ItemStack(MoreGemsToolsArmor.itemUpgradeMaterial));
                stacks.add(new ItemStack(MoreGemsToolsArmor.itemUpgradeMaterialShard));
            }).build();

    @Override
    public void onInitialize() {
        LOGGER.info("More Gems Tools Armor version is " + MGTAVariables.version + ", Minecraft version is " + MGTAVariables.mcVersion);
        //og115();
        og116();
        Registry.register(Registry.ITEM, new Identifier(MGTAVariables.modid, "sapphire"), sapphire);
        Registry.register(Registry.ITEM, new Identifier(MGTAVariables.modid, "brown_gem"), brownGem);
        Registry.register(Registry.ITEM, new Identifier(MGTAVariables.modid, "purple_gem"), purpleGem);
        Registry.register(Registry.ITEM, new Identifier(MGTAVariables.modid, "ruby"), ruby);
        Registry.register(Registry.ITEM, new Identifier(MGTAVariables.modid, "yellow_gem"), yellowGem);
        Registry.register(Registry.BLOCK, new Identifier(MGTAVariables.modid, "sapphire_block"), sapphireBlock);
        Registry.register(Registry.ITEM, new Identifier(MGTAVariables.modid, "sapphire_block"), new BlockItem(sapphireBlock, new Item.Settings().group(MoreGemsToolsArmor.MOREGEMSTOOLSARMOR_GROUP)));
        Registry.register(Registry.BLOCK, new Identifier(MGTAVariables.modid, "brown_gem_block"), brownGemBlock);
        Registry.register(Registry.ITEM, new Identifier(MGTAVariables.modid, "brown_gem_block"), new BlockItem(brownGemBlock, new Item.Settings().group(MoreGemsToolsArmor.MOREGEMSTOOLSARMOR_GROUP)));
        Registry.register(Registry.BLOCK, new Identifier(MGTAVariables.modid, "purple_gem_block"), purpleGemBlock);
        Registry.register(Registry.ITEM, new Identifier(MGTAVariables.modid, "purple_gem_block"), new BlockItem(purpleGemBlock, new Item.Settings().group(MoreGemsToolsArmor.MOREGEMSTOOLSARMOR_GROUP)));
        Registry.register(Registry.BLOCK, new Identifier(MGTAVariables.modid, "ruby_block"), rubyBlock);
        Registry.register(Registry.ITEM, new Identifier(MGTAVariables.modid, "ruby_block"), new BlockItem(rubyBlock, new Item.Settings().group(MoreGemsToolsArmor.MOREGEMSTOOLSARMOR_GROUP)));
        Registry.register(Registry.BLOCK, new Identifier(MGTAVariables.modid, "yellow_gem_block"), yellowGemBlock);
        Registry.register(Registry.ITEM, new Identifier(MGTAVariables.modid, "yellow_gem_block"), new BlockItem(yellowGemBlock, new Item.Settings().group(MoreGemsToolsArmor.MOREGEMSTOOLSARMOR_GROUP)));
        Registry.register(Registry.BLOCK, new Identifier(MGTAVariables.modid, "sapphire_ore"), sapphireOre);
        Registry.register(Registry.ITEM, new Identifier(MGTAVariables.modid, "sapphire_ore"), new BlockItem(sapphireOre, new Item.Settings().group(MoreGemsToolsArmor.MOREGEMSTOOLSARMOR_GROUP)));
        Registry.register(Registry.BLOCK, new Identifier(MGTAVariables.modid, "brown_gem_ore"), brownGemOre);
        Registry.register(Registry.ITEM, new Identifier(MGTAVariables.modid, "brown_gem_ore"), new BlockItem(brownGemOre, new Item.Settings().group(MoreGemsToolsArmor.MOREGEMSTOOLSARMOR_GROUP)));
        Registry.register(Registry.BLOCK, new Identifier(MGTAVariables.modid, "purple_gem_ore"), purpleGemOre);
        Registry.register(Registry.ITEM, new Identifier(MGTAVariables.modid, "purple_gem_ore"), new BlockItem(purpleGemOre, new Item.Settings().group(MoreGemsToolsArmor.MOREGEMSTOOLSARMOR_GROUP)));
        Registry.register(Registry.BLOCK, new Identifier(MGTAVariables.modid, "ruby_ore"), rubyOre);
        Registry.register(Registry.ITEM, new Identifier(MGTAVariables.modid, "ruby_ore"), new BlockItem(rubyOre, new Item.Settings().group(MoreGemsToolsArmor.MOREGEMSTOOLSARMOR_GROUP)));
        Registry.register(Registry.BLOCK, new Identifier(MGTAVariables.modid, "yellow_gem_ore"), yellowGemOre);
        Registry.register(Registry.ITEM, new Identifier(MGTAVariables.modid, "yellow_gem_ore"), new BlockItem(yellowGemOre, new Item.Settings().group(MoreGemsToolsArmor.MOREGEMSTOOLSARMOR_GROUP)));
        Registry.register(Registry.BLOCK, new Identifier(MGTAVariables.modid, "stone_of_experience"), stoneOfExperience);
        Registry.register(Registry.ITEM, new Identifier(MGTAVariables.modid, "stone_of_experience"), new BlockItem(stoneOfExperience, new Item.Settings().group(MoreGemsToolsArmor.MOREGEMSTOOLSARMOR_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(MGTAVariables.modid, "sapphire_helmet"), sapphireHelmet);
        Registry.register(Registry.ITEM, new Identifier(MGTAVariables.modid, "sapphire_chestplate"), sapphireChestplate);
        Registry.register(Registry.ITEM, new Identifier(MGTAVariables.modid, "sapphire_leggings"), sapphireLeggings);
        Registry.register(Registry.ITEM, new Identifier(MGTAVariables.modid, "sapphire_boots"), sapphireBoots);
        Registry.register(Registry.ITEM, new Identifier(MGTAVariables.modid, "brown_gem_helmet"), brownGemHelmet);
        Registry.register(Registry.ITEM, new Identifier(MGTAVariables.modid, "brown_gem_chestplate"), brownGemChestplate);
        Registry.register(Registry.ITEM, new Identifier(MGTAVariables.modid, "brown_gem_leggings"), brownGemLeggings);
        Registry.register(Registry.ITEM, new Identifier(MGTAVariables.modid, "brown_gem_boots"), brownGemBoots);
        Registry.register(Registry.ITEM, new Identifier(MGTAVariables.modid, "purple_gem_helmet"), purpleGemHelmet);
        Registry.register(Registry.ITEM, new Identifier(MGTAVariables.modid, "purple_gem_chestplate"), purpleGemChestplate);
        Registry.register(Registry.ITEM, new Identifier(MGTAVariables.modid, "purple_gem_leggings"), purpleGemLeggings);
        Registry.register(Registry.ITEM, new Identifier(MGTAVariables.modid, "purple_gem_boots"), purpleGemBoots);
        Registry.register(Registry.ITEM, new Identifier(MGTAVariables.modid, "ruby_helmet"), rubyHelmet);
        Registry.register(Registry.ITEM, new Identifier(MGTAVariables.modid, "ruby_chestplate"), rubyChestplate);
        Registry.register(Registry.ITEM, new Identifier(MGTAVariables.modid, "ruby_leggings"), rubyLeggings);
        Registry.register(Registry.ITEM, new Identifier(MGTAVariables.modid, "ruby_boots"), rubyBoots);
        Registry.register(Registry.ITEM, new Identifier(MGTAVariables.modid, "yellow_gem_helmet"), yellowGemHelmet);
        Registry.register(Registry.ITEM, new Identifier(MGTAVariables.modid, "yellow_gem_chestplate"), yellowGemChestplate);
        Registry.register(Registry.ITEM, new Identifier(MGTAVariables.modid, "yellow_gem_leggings"), yellowGemLeggings);
        Registry.register(Registry.ITEM, new Identifier(MGTAVariables.modid, "yellow_gem_boots"), yellowGemBoots);
        Registry.register(Registry.ITEM, new Identifier(MGTAVariables.modid, "emerald_helmet"), emeraldHelmet);
        Registry.register(Registry.ITEM, new Identifier(MGTAVariables.modid, "emerald_chestplate"), emeraldChestplate);
        Registry.register(Registry.ITEM, new Identifier(MGTAVariables.modid, "emerald_leggings"), emeraldLeggings);
        Registry.register(Registry.ITEM, new Identifier(MGTAVariables.modid, "emerald_boots"), emeraldBoots);
        Registry.register(Registry.ITEM, new Identifier(MGTAVariables.modid, "sapphire_sword"), sapphireSword);
        Registry.register(Registry.ITEM, new Identifier(MGTAVariables.modid, "brown_gem_sword"), brownGemSword);
        Registry.register(Registry.ITEM, new Identifier(MGTAVariables.modid, "purple_gem_sword"), purpleGemSword);
        Registry.register(Registry.ITEM, new Identifier(MGTAVariables.modid, "ruby_sword"), rubySword);
        Registry.register(Registry.ITEM, new Identifier(MGTAVariables.modid, "yellow_gem_sword"), yellowGemSword);
        Registry.register(Registry.ITEM, new Identifier(MGTAVariables.modid, "emerald_sword"), emeraldSword);
        Registry.register(Registry.ITEM, new Identifier(MGTAVariables.modid, "sapphire_shovel"), sapphireShovel);
        Registry.register(Registry.ITEM, new Identifier(MGTAVariables.modid, "brown_gem_shovel"), brownGemShovel);
        Registry.register(Registry.ITEM, new Identifier(MGTAVariables.modid, "purple_gem_shovel"), purpleGemShovel);
        Registry.register(Registry.ITEM, new Identifier(MGTAVariables.modid, "ruby_shovel"), rubyShovel);
        Registry.register(Registry.ITEM, new Identifier(MGTAVariables.modid, "yellow_gem_shovel"), yellowGemShovel);
        Registry.register(Registry.ITEM, new Identifier(MGTAVariables.modid, "emerald_shovel"), emeraldShovel);
        Registry.register(Registry.ITEM, new Identifier(MGTAVariables.modid, "sapphire_pickaxe"), sapphirePickaxe);
        Registry.register(Registry.ITEM, new Identifier(MGTAVariables.modid, "brown_gem_pickaxe"), brownGemPickaxe);
        Registry.register(Registry.ITEM, new Identifier(MGTAVariables.modid, "purple_gem_pickaxe"), purpleGemPickaxe);
        Registry.register(Registry.ITEM, new Identifier(MGTAVariables.modid, "ruby_pickaxe"), rubyPickaxe);
        Registry.register(Registry.ITEM, new Identifier(MGTAVariables.modid, "yellow_gem_pickaxe"), yellowGemPickaxe);
        Registry.register(Registry.ITEM, new Identifier(MGTAVariables.modid, "emerald_pickaxe"), emeraldPickaxe);
        Registry.register(Registry.ITEM, new Identifier(MGTAVariables.modid, "sapphire_axe"), sapphireAxe);
        Registry.register(Registry.ITEM, new Identifier(MGTAVariables.modid, "brown_gem_axe"), brownGemAxe);
        Registry.register(Registry.ITEM, new Identifier(MGTAVariables.modid, "purple_gem_axe"), purpleGemAxe);
        Registry.register(Registry.ITEM, new Identifier(MGTAVariables.modid, "ruby_axe"), rubyAxe);
        Registry.register(Registry.ITEM, new Identifier(MGTAVariables.modid, "yellow_gem_axe"), yellowGemAxe);
        Registry.register(Registry.ITEM, new Identifier(MGTAVariables.modid, "emerald_axe"), emeraldAxe);
        Registry.register(Registry.ITEM, new Identifier(MGTAVariables.modid, "sapphire_hoe"), sapphireHoe);
        Registry.register(Registry.ITEM, new Identifier(MGTAVariables.modid, "brown_gem_hoe"), brownGemHoe);
        Registry.register(Registry.ITEM, new Identifier(MGTAVariables.modid, "purple_gem_hoe"), purpleGemHoe);
        Registry.register(Registry.ITEM, new Identifier(MGTAVariables.modid, "ruby_hoe"), rubyHoe);
        Registry.register(Registry.ITEM, new Identifier(MGTAVariables.modid, "yellow_gem_hoe"), yellowGemHoe);
        Registry.register(Registry.ITEM, new Identifier(MGTAVariables.modid, "emerald_hoe"), emeraldHoe);
        Registry.register(Registry.ITEM, new Identifier(MGTAVariables.modid, "diamond_apple"), diamondApple);
        Registry.register(Registry.ITEM, new Identifier(MGTAVariables.modid, "iron_apple"), ironApple);
        Registry.register(Registry.ITEM, new Identifier(MGTAVariables.modid, "emerald_apple"), emeraldApple);
        Registry.register(Registry.ITEM, new Identifier(MGTAVariables.modid, "sapphire_apple"), sapphireApple);
        Registry.register(Registry.ITEM, new Identifier(MGTAVariables.modid, "brown_gem_apple"), brownGemApple);
        Registry.register(Registry.ITEM, new Identifier(MGTAVariables.modid, "purple_gem_apple"), purpleGemApple);
        Registry.register(Registry.ITEM, new Identifier(MGTAVariables.modid, "ruby_apple"), rubyApple);
        Registry.register(Registry.ITEM, new Identifier(MGTAVariables.modid, "yellow_gem_apple"), yellowGemApple);
        Registry.register(Registry.ITEM, new Identifier(MGTAVariables.modid, "quartz_apple"), quartzApple);
        Registry.register(Registry.ITEM, new Identifier(MGTAVariables.modid, "netherite_apple"), netheriteApple);
        Registry.register(Registry.ITEM, new Identifier(MGTAVariables.modid, "enchanted_diamond_apple"), enchantedDiamondApple);
        Registry.register(Registry.ITEM, new Identifier(MGTAVariables.modid, "enchanted_iron_apple"), enchantedIronApple);
        Registry.register(Registry.ITEM, new Identifier(MGTAVariables.modid, "enchanted_emerald_apple"), enchantedEmeraldApple);
        Registry.register(Registry.ITEM, new Identifier(MGTAVariables.modid, "enchanted_sapphire_apple"), enchantedSapphireApple);
        Registry.register(Registry.ITEM, new Identifier(MGTAVariables.modid, "enchanted_brown_gem_apple"), enchantedBrownGemApple);
        Registry.register(Registry.ITEM, new Identifier(MGTAVariables.modid, "enchanted_purple_gem_apple"), enchantedPurpleGemApple);
        Registry.register(Registry.ITEM, new Identifier(MGTAVariables.modid, "enchanted_ruby_apple"), enchantedRubyApple);
        Registry.register(Registry.ITEM, new Identifier(MGTAVariables.modid, "enchanted_yellow_gem_apple"), enchantedYellowGemApple);
        Registry.register(Registry.ITEM, new Identifier(MGTAVariables.modid, "enchanted_quartz_apple"), enchantedQuartzApple);
        Registry.register(Registry.ITEM, new Identifier(MGTAVariables.modid, "enchanted_netherite_apple"), enchantedNetheriteApple);

        Registry.register(Registry.ITEM, new Identifier(MGTAVariables.modid, "mixed_gem_sword"), mixedGemSword);
        Registry.register(Registry.ITEM, new Identifier(MGTAVariables.modid, "mixed_gem_shovel"), mixedGemShovel);
        Registry.register(Registry.ITEM, new Identifier(MGTAVariables.modid, "mixed_gem_pickaxe"), mixedGemPickaxe);
        Registry.register(Registry.ITEM, new Identifier(MGTAVariables.modid, "mixed_gem_axe"), mixedGemAxe);
        Registry.register(Registry.ITEM, new Identifier(MGTAVariables.modid, "mixed_gem_hoe"), mixedGemHoe);
        Registry.register(Registry.ITEM, new Identifier(MGTAVariables.modid, "mixed_gem_helmet"), mixedGemHelmet);
        Registry.register(Registry.ITEM, new Identifier(MGTAVariables.modid, "mixed_gem_chestplate"), mixedGemChestplate);
        Registry.register(Registry.ITEM, new Identifier(MGTAVariables.modid, "mixed_gem_leggings"), mixedGemLeggings);
        Registry.register(Registry.ITEM, new Identifier(MGTAVariables.modid, "mixed_gem_boots"), mixedGemBoots);
        Registry.register(Registry.ITEM, new Identifier(MGTAVariables.modid, "mixed_gem_apple"), mixedGemApple);
        Registry.register(Registry.ITEM, new Identifier(MGTAVariables.modid, "enchanted_mixed_gem_apple"), enchantedMixedGemApple);
        Registry.register(Registry.ITEM, new Identifier(MGTAVariables.modid, "upgraded_sapphire_helmet"), upgradedSapphireHelmet);
        Registry.register(Registry.ITEM, new Identifier(MGTAVariables.modid, "upgraded_sapphire_chestplate"), upgradedSapphireChestplate);
        Registry.register(Registry.ITEM, new Identifier(MGTAVariables.modid, "upgraded_sapphire_leggings"), upgradedSapphireLeggings);
        Registry.register(Registry.ITEM, new Identifier(MGTAVariables.modid, "upgraded_sapphire_boots"), upgradedSapphireBoots);
        Registry.register(Registry.ITEM, new Identifier(MGTAVariables.modid, "upgraded_brown_gem_helmet"), upgradedBrownGemHelmet);
        Registry.register(Registry.ITEM, new Identifier(MGTAVariables.modid, "upgraded_brown_gem_chestplate"), upgradedBrownGemChestplate);
        Registry.register(Registry.ITEM, new Identifier(MGTAVariables.modid, "upgraded_brown_gem_leggings"), upgradedBrownGemLeggings);
        Registry.register(Registry.ITEM, new Identifier(MGTAVariables.modid, "upgraded_brown_gem_boots"), upgradedBrownGemBoots);
        Registry.register(Registry.ITEM, new Identifier(MGTAVariables.modid, "upgraded_purple_gem_helmet"), upgradedPurpleGemHelmet);
        Registry.register(Registry.ITEM, new Identifier(MGTAVariables.modid, "upgraded_purple_gem_chestplate"), upgradedPurpleGemChestplate);
        Registry.register(Registry.ITEM, new Identifier(MGTAVariables.modid, "upgraded_purple_gem_leggings"), upgradedPurpleGemLeggings);
        Registry.register(Registry.ITEM, new Identifier(MGTAVariables.modid, "upgraded_purple_gem_boots"), upgradedPurpleGemBoots);
        Registry.register(Registry.ITEM, new Identifier(MGTAVariables.modid, "upgraded_ruby_helmet"), upgradedRubyHelmet);
        Registry.register(Registry.ITEM, new Identifier(MGTAVariables.modid, "upgraded_ruby_chestplate"), upgradedRubyChestplate);
        Registry.register(Registry.ITEM, new Identifier(MGTAVariables.modid, "upgraded_ruby_leggings"), upgradedRubyLeggings);
        Registry.register(Registry.ITEM, new Identifier(MGTAVariables.modid, "upgraded_ruby_boots"), upgradedRubyBoots);
        Registry.register(Registry.ITEM, new Identifier(MGTAVariables.modid, "upgraded_yellow_gem_helmet"), upgradedYellowGemHelmet);
        Registry.register(Registry.ITEM, new Identifier(MGTAVariables.modid, "upgraded_yellow_gem_chestplate"), upgradedYellowGemChestplate);
        Registry.register(Registry.ITEM, new Identifier(MGTAVariables.modid, "upgraded_yellow_gem_leggings"), upgradedYellowGemLeggings);
        Registry.register(Registry.ITEM, new Identifier(MGTAVariables.modid, "upgraded_yellow_gem_boots"), upgradedYellowGemBoots);
        Registry.register(Registry.ITEM, new Identifier(MGTAVariables.modid, "upgraded_emerald_helmet"), upgradedEmeraldHelmet);
        Registry.register(Registry.ITEM, new Identifier(MGTAVariables.modid, "upgraded_emerald_chestplate"), upgradedEmeraldChestplate);
        Registry.register(Registry.ITEM, new Identifier(MGTAVariables.modid, "upgraded_emerald_leggings"), upgradedEmeraldLeggings);
        Registry.register(Registry.ITEM, new Identifier(MGTAVariables.modid, "upgraded_emerald_boots"), upgradedEmeraldBoots);
        Registry.register(Registry.ITEM, new Identifier(MGTAVariables.modid, "upgraded_sapphire_sword"), upgradedSapphireSword);
        Registry.register(Registry.ITEM, new Identifier(MGTAVariables.modid, "upgraded_brown_gem_sword"), upgradedBrownGemSword);
        Registry.register(Registry.ITEM, new Identifier(MGTAVariables.modid, "upgraded_purple_gem_sword"), upgradedPurpleGemSword);
        Registry.register(Registry.ITEM, new Identifier(MGTAVariables.modid, "upgraded_ruby_sword"), upgradedRubySword);
        Registry.register(Registry.ITEM, new Identifier(MGTAVariables.modid, "upgraded_yellow_gem_sword"), upgradedYellowGemSword);
        Registry.register(Registry.ITEM, new Identifier(MGTAVariables.modid, "upgraded_emerald_sword"), upgradedEmeraldSword);
        Registry.register(Registry.ITEM, new Identifier(MGTAVariables.modid, "upgraded_sapphire_shovel"), upgradedSapphireShovel);
        Registry.register(Registry.ITEM, new Identifier(MGTAVariables.modid, "upgraded_brown_gem_shovel"), upgradedBrownGemShovel);
        Registry.register(Registry.ITEM, new Identifier(MGTAVariables.modid, "upgraded_purple_gem_shovel"), upgradedPurpleGemShovel);
        Registry.register(Registry.ITEM, new Identifier(MGTAVariables.modid, "upgraded_ruby_shovel"), upgradedRubyShovel);
        Registry.register(Registry.ITEM, new Identifier(MGTAVariables.modid, "upgraded_yellow_gem_shovel"), upgradedYellowGemShovel);
        Registry.register(Registry.ITEM, new Identifier(MGTAVariables.modid, "upgraded_emerald_shovel"), upgradedEmeraldShovel);
        Registry.register(Registry.ITEM, new Identifier(MGTAVariables.modid, "upgraded_sapphire_pickaxe"), upgradedSapphirePickaxe);
        Registry.register(Registry.ITEM, new Identifier(MGTAVariables.modid, "upgraded_brown_gem_pickaxe"), upgradedBrownGemPickaxe);
        Registry.register(Registry.ITEM, new Identifier(MGTAVariables.modid, "upgraded_purple_gem_pickaxe"), upgradedPurpleGemPickaxe);
        Registry.register(Registry.ITEM, new Identifier(MGTAVariables.modid, "upgraded_ruby_pickaxe"), upgradedRubyPickaxe);
        Registry.register(Registry.ITEM, new Identifier(MGTAVariables.modid, "upgraded_yellow_gem_pickaxe"), upgradedYellowGemPickaxe);
        Registry.register(Registry.ITEM, new Identifier(MGTAVariables.modid, "upgraded_emerald_pickaxe"), upgradedEmeraldPickaxe);
        Registry.register(Registry.ITEM, new Identifier(MGTAVariables.modid, "upgraded_sapphire_axe"), upgradedSapphireAxe);
        Registry.register(Registry.ITEM, new Identifier(MGTAVariables.modid, "upgraded_brown_gem_axe"), upgradedBrownGemAxe);
        Registry.register(Registry.ITEM, new Identifier(MGTAVariables.modid, "upgraded_purple_gem_axe"), upgradedPurpleGemAxe);
        Registry.register(Registry.ITEM, new Identifier(MGTAVariables.modid, "upgraded_ruby_axe"), upgradedRubyAxe);
        Registry.register(Registry.ITEM, new Identifier(MGTAVariables.modid, "upgraded_yellow_gem_axe"), upgradedYellowGemAxe);
        Registry.register(Registry.ITEM, new Identifier(MGTAVariables.modid, "upgraded_emerald_axe"), upgradedEmeraldAxe);
        Registry.register(Registry.ITEM, new Identifier(MGTAVariables.modid, "upgraded_sapphire_hoe"), upgradedSapphireHoe);
        Registry.register(Registry.ITEM, new Identifier(MGTAVariables.modid, "upgraded_brown_gem_hoe"), upgradedBrownGemHoe);
        Registry.register(Registry.ITEM, new Identifier(MGTAVariables.modid, "upgraded_purple_gem_hoe"), upgradedPurpleGemHoe);
        Registry.register(Registry.ITEM, new Identifier(MGTAVariables.modid, "upgraded_ruby_hoe"), upgradedRubyHoe);
        Registry.register(Registry.ITEM, new Identifier(MGTAVariables.modid, "upgraded_yellow_gem_hoe"), upgradedYellowGemHoe);
        Registry.register(Registry.ITEM, new Identifier(MGTAVariables.modid, "upgraded_emerald_hoe"), upgradedEmeraldHoe);
        Registry.register(Registry.ITEM, new Identifier(MGTAVariables.modid, "upgraded_mixed_gem_sword"), upgradedMixedGemSword);
        Registry.register(Registry.ITEM, new Identifier(MGTAVariables.modid, "upgraded_mixed_gem_shovel"), upgradedMixedGemShovel);
        Registry.register(Registry.ITEM, new Identifier(MGTAVariables.modid, "upgraded_mixed_gem_pickaxe"), upgradedMixedGemPickaxe);
        Registry.register(Registry.ITEM, new Identifier(MGTAVariables.modid, "upgraded_mixed_gem_axe"), upgradedMixedGemAxe);
        Registry.register(Registry.ITEM, new Identifier(MGTAVariables.modid, "upgraded_mixed_gem_hoe"), upgradedMixedGemHoe);
        Registry.register(Registry.ITEM, new Identifier(MGTAVariables.modid, "upgraded_mixed_gem_helmet"), upgradedMixedGemHelmet);
        Registry.register(Registry.ITEM, new Identifier(MGTAVariables.modid, "upgraded_mixed_gem_chestplate"), upgradedMixedGemChestplate);
        Registry.register(Registry.ITEM, new Identifier(MGTAVariables.modid, "upgraded_mixed_gem_leggings"), upgradedMixedGemLeggings);
        Registry.register(Registry.ITEM, new Identifier(MGTAVariables.modid, "upgraded_mixed_gem_boots"), upgradedMixedGemBoots);


        Registry.register(Registry.BLOCK, id("item_upgrade_table"), itemUpgradeTable);
        Registry.register(Registry.ITEM, id("item_upgrade_table"), itemUpgradeTableItem);
        Registry.register(Registry.BLOCK_ENTITY_TYPE, id("item_upgrade_table"), itemUpgradeTableBlockEntity);

        Registry.register(Registry.ITEM, new Identifier(MGTAVariables.modid, "item_upgrade_material"), itemUpgradeMaterial);
        Registry.register(Registry.ITEM, new Identifier(MGTAVariables.modid, "item_upgrade_material_shard"), itemUpgradeMaterialShard);

        ToolManagerImpl.general().register(new ModdedToolsModdedBlocksToolHandler());
        ToolManagerImpl.general().register(new VanillaToolsModdedBlocksToolHandler());
        ToolManagerImpl.tag(MGTAToolTags.PICKAXES).register(new ModdedToolsVanillaBlocksToolHandler(
                Arrays.asList(
                        Items.WOODEN_PICKAXE,
                        Items.STONE_PICKAXE,
                        Items.IRON_PICKAXE,
                        Items.DIAMOND_PICKAXE,
                        Items.NETHERITE_PICKAXE,
                        sapphirePickaxe,
                        brownGemPickaxe,
                        purpleGemPickaxe,
                        rubyPickaxe,
                        yellowGemPickaxe,
                        emeraldPickaxe,
                        mixedGemPickaxe,
                        upgradedSapphirePickaxe,
                        upgradedBrownGemPickaxe,
                        upgradedPurpleGemPickaxe,
                        upgradedRubyPickaxe,
                        upgradedYellowGemPickaxe,
                        upgradedEmeraldPickaxe,
                        upgradedMixedGemPickaxe
                )
        ));
    }






	/*public void og115(){
		Registry.BIOME.forEach(this::brownGemOreGeneration);
		RegistryEntryAddedCallback.event(Registry.BIOME).register((i, identifier, biome) -> brownGemOreGeneration(biome));
		Registry.BIOME.forEach(this::purpleGemOreGeneration);
		RegistryEntryAddedCallback.event(Registry.BIOME).register((i, identifier, biome) -> purpleGemOreGeneration(biome));
		Registry.BIOME.forEach(this::sapphireOreGeneration);
		RegistryEntryAddedCallback.event(Registry.BIOME).register((i, identifier, biome) -> sapphireOreGeneration(biome));
		Registry.BIOME.forEach(this::rubyOreGeneration);
		RegistryEntryAddedCallback.event(Registry.BIOME).register((i, identifier, biome) -> rubyOreGeneration(biome));
		Registry.BIOME.forEach(this::yellowGemOreGeneration);
		RegistryEntryAddedCallback.event(Registry.BIOME).register((i, identifier, biome) -> yellowGemOreGeneration(biome));
		Registry.BIOME.forEach(this::stoneOfExperienceGeneration);
		RegistryEntryAddedCallback.event(Registry.BIOME).register((i, identifier, biome) -> stoneOfExperienceGeneration(biome));
	}
*/

    public void og116() {
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, new Identifier(MGTAVariables.modid, "ore_brown_gem_ore"), ORE_BROWN_GEM_ORE);
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, new Identifier(MGTAVariables.modid, "ore_purple_gem_ore"), ORE_PURPLE_GEM_ORE);
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, new Identifier(MGTAVariables.modid, "ore_sapphire_ore"), ORE_SAPPHIRE_ORE);
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, new Identifier(MGTAVariables.modid, "ore_ruby_ore"), ORE_RUBY_ORE);
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, new Identifier(MGTAVariables.modid, "ore_yellow_gem_ore"), ORE_YELLOW_GEM_ORE);
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, new Identifier(MGTAVariables.modid, "ore_stone_of_experience"), ORE_STONE_OF_EXPERIENCE);

    }


    //矿物生成
	/*1.15矿物生成，1.16用不了

	private void brownGemOreGeneration(Biome biome) {

		if(biome.getCategory() != Biome.Category.NETHER && biome.getCategory() != Biome.Category.THEEND) {
			biome.addFeature(
					GenerationStep.Feature.UNDERGROUND_ORES,
					Feature.ORE.configure(
							new OreFeatureConfig(
									OreFeatureConfig.Target.NATURAL_STONE,
									brownGemOre.getDefaultState(),
									8 //Ore vein size
							)).createDecoratedFeature(
							Decorator.COUNT_RANGE.configure(new RangeDecoratorConfig(
									8, //Number of veins per chunk
									0, //Bottom Offset
									0, //Min y level
									64 //Max y level
							))));
		}
	}
	private void purpleGemOreGeneration(Biome biome) {
		if(biome.getCategory() != Biome.Category.NETHER && biome.getCategory() != Biome.Category.THEEND) {
			biome.addFeature(
					GenerationStep.Feature.UNDERGROUND_ORES,
					Feature.ORE.configure(
							new OreFeatureConfig(
									OreFeatureConfig.Target.NATURAL_STONE,
									purpleGemOre.getDefaultState(),
									8 //Ore vein size
							)).createDecoratedFeature(
							Decorator.COUNT_RANGE.configure(new RangeDecoratorConfig(
									8, //Number of veins per chunk
									0, //Bottom Offset
									0, //Min y level
									64 //Max y level
							))));
		}
	}
	private void sapphireOreGeneration(Biome biome) {
		if(biome.getCategory() != Biome.Category.NETHER && biome.getCategory() != Biome.Category.THEEND) {
			biome.addFeature(
					GenerationStep.Feature.UNDERGROUND_ORES,
					Feature.ORE.configure(
							new OreFeatureConfig(
									OreFeatureConfig.Target.NATURAL_STONE,
									sapphireOre.getDefaultState(),
									8 //Ore vein size
							)).createDecoratedFeature(
							Decorator.COUNT_RANGE.configure(new RangeDecoratorConfig(
									8, //Number of veins per chunk
									0, //Bottom Offset
									0, //Min y level
									64 //Max y level
							))));
		}
	}
	private void rubyOreGeneration(Biome biome) {
		if(biome.getCategory() != Biome.Category.NETHER && biome.getCategory() != Biome.Category.THEEND) {
			biome.addFeature(
					GenerationStep.Feature.UNDERGROUND_ORES,
					Feature.ORE.configure(
							new OreFeatureConfig(
									OreFeatureConfig.Target.NATURAL_STONE,
									rubyOre.getDefaultState(),
									8 //Ore vein size
							)).createDecoratedFeature(
							Decorator.COUNT_RANGE.configure(new RangeDecoratorConfig(
									8, //Number of veins per chunk
									0, //Bottom Offset
									0, //Min y level
									64 //Max y level
							))));
		}
	}
	private void yellowGemOreGeneration(Biome biome) {
		if(biome.getCategory() != Biome.Category.NETHER && biome.getCategory() != Biome.Category.THEEND) {
			biome.addFeature(
					GenerationStep.Feature.UNDERGROUND_ORES,
					Feature.ORE.configure(
							new OreFeatureConfig(
									OreFeatureConfig.Target.NATURAL_STONE,
									yellowGemOre.getDefaultState(),
									8 //Ore vein size
							)).createDecoratedFeature(
							Decorator.COUNT_RANGE.configure(new RangeDecoratorConfig(
									8, //Number of veins per chunk
									0, //Bottom Offset
									0, //Min y level
									64 //Max y level
							))));
		}
	}
	private void stoneOfExperienceGeneration(Biome biome) {
		if(biome.getCategory() != Biome.Category.NETHER && biome.getCategory() != Biome.Category.THEEND) {
			biome.addFeature(
					GenerationStep.Feature.UNDERGROUND_ORES,
					Feature.ORE.configure(
							new OreFeatureConfig(
									OreFeatureConfig.Target.NATURAL_STONE,
									stoneOfExperience.getDefaultState(),
									16 //Ore vein size
							)).createDecoratedFeature(
							Decorator.COUNT_RANGE.configure(new RangeDecoratorConfig(
									16, //Number of veins per chunk
									0, //Bottom Offset
									0, //Min y level
									64 //Max y level
							))));

	}
}*/
}
