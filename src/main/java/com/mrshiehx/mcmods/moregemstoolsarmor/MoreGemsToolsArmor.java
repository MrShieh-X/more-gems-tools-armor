package com.mrshiehx.mcmods.moregemstoolsarmor;

import com.mrshiehx.mcmods.moregemstoolsarmor.block.*;
import com.mrshiehx.mcmods.moregemstoolsarmor.item.armor.material.MGTAArmorMaterials;
import com.mrshiehx.mcmods.moregemstoolsarmor.item.food.components.MGTAFoodComponents;
import com.mrshiehx.mcmods.moregemstoolsarmor.item.food.EnchantedAppleItem;
import com.mrshiehx.mcmods.moregemstoolsarmor.item.tool.MGTAAxeItem;
import com.mrshiehx.mcmods.moregemstoolsarmor.item.tool.MGTAHoeItem;
import com.mrshiehx.mcmods.moregemstoolsarmor.item.tool.MGTAPickaxeItem;
import com.mrshiehx.mcmods.moregemstoolsarmor.item.tool.MGTAToolTags;
import com.mrshiehx.mcmods.moregemstoolsarmor.item.tool.material.MGTAToolMaterial;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.impl.tool.attribute.ToolManagerImpl;
import net.fabricmc.fabric.impl.tool.attribute.handlers.ModdedToolsModdedBlocksToolHandler;
import net.fabricmc.fabric.impl.tool.attribute.handlers.ModdedToolsVanillaBlocksToolHandler;
import net.fabricmc.fabric.impl.tool.attribute.handlers.VanillaToolsModdedBlocksToolHandler;
import net.minecraft.block.*;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.decorator.Decorator;
import net.minecraft.world.gen.decorator.RangeDecoratorConfig;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;

import java.util.Arrays;


public class MoreGemsToolsArmor implements ModInitializer {
	public static final String namespace="moregemstoolsarmor";
	public static final Item sapphire=new Item(new Item.Settings().group(MoreGemsToolsArmor.MOREGEMSTOOLSARMOR_GROUP).maxCount(64));//蓝宝石
	public static final Item brownGem=new Item(new Item.Settings().group(MoreGemsToolsArmor.MOREGEMSTOOLSARMOR_GROUP).maxCount(64));//棕宝石
	public static final Item purpleGem=new Item(new Item.Settings().group(MoreGemsToolsArmor.MOREGEMSTOOLSARMOR_GROUP).maxCount(64));//紫宝石
	public static final Item ruby=new Item(new Item.Settings().group(MoreGemsToolsArmor.MOREGEMSTOOLSARMOR_GROUP).maxCount(64));//红宝石
	public static final Item yellowGem=new Item(new Item.Settings().group(MoreGemsToolsArmor.MOREGEMSTOOLSARMOR_GROUP).maxCount(64));//黄宝石
	public static final Block sapphireBlock=new Block(FabricBlockSettings.of(Material.METAL).strength(5).requiresTool().breakByTool(MGTAToolTags.PICKAXES,2));//蓝宝石块
	public static final Block brownGemBlock=new Block(FabricBlockSettings.of(Material.METAL).strength(5).requiresTool().breakByTool(MGTAToolTags.PICKAXES,2));//棕宝石块
	public static final Block purpleGemBlock=new Block(FabricBlockSettings.of(Material.METAL).strength(5).requiresTool().breakByTool(MGTAToolTags.PICKAXES,2));//紫宝石块
	public static final Block rubyBlock=new Block(FabricBlockSettings.of(Material.METAL).strength(5).requiresTool().breakByTool(MGTAToolTags.PICKAXES,2));//红宝石块
	public static final Block yellowGemBlock=new Block(FabricBlockSettings.of(Material.METAL).strength(5).requiresTool().breakByTool(MGTAToolTags.PICKAXES,2));//黄宝石块
	public static final Block sapphireOre=new SapphireOre(FabricBlockSettings.of(Material.STONE).strength(3,3).requiresTool().breakByTool(MGTAToolTags.PICKAXES,2));//蓝宝石矿石
	public static final Block brownGemOre=new BrownGemOre(FabricBlockSettings.of(Material.STONE).strength(3,3).requiresTool().breakByTool(MGTAToolTags.PICKAXES,2));//棕宝石矿石
	public static final Block purpleGemOre=new PurpleGemOre(FabricBlockSettings.of(Material.STONE).strength(3,3).requiresTool().breakByTool(MGTAToolTags.PICKAXES,2));//紫宝石矿石
	public static final Block rubyOre=new RubyOre(FabricBlockSettings.of(Material.STONE).strength(3,3).requiresTool().breakByTool(MGTAToolTags.PICKAXES,2));//红宝石矿石
	public static final Block yellowGemOre=new YellowGemOre(FabricBlockSettings.of(Material.STONE).strength(3,3).requiresTool().breakByTool(MGTAToolTags.PICKAXES,2));//黄宝石矿石
	public static final Block stoneOfExperience=new StoneOfExperience(FabricBlockSettings.of(Material.STONE).strength(3,6).requiresTool().breakByTool(MGTAToolTags.PICKAXES,2));//经验之石
	public static final ArmorItem sapphireHelmet=new ArmorItem(MGTAArmorMaterials.SAPPHIRE, EquipmentSlot.HEAD,new Item.Settings().group(MoreGemsToolsArmor.MOREGEMSTOOLSARMOR_GROUP));
	public static final ArmorItem sapphireChestplate=new ArmorItem(MGTAArmorMaterials.SAPPHIRE, EquipmentSlot.CHEST,new Item.Settings().group(MoreGemsToolsArmor.MOREGEMSTOOLSARMOR_GROUP));
	public static final ArmorItem sapphireLeggings=new ArmorItem(MGTAArmorMaterials.SAPPHIRE, EquipmentSlot.LEGS,new Item.Settings().group(MoreGemsToolsArmor.MOREGEMSTOOLSARMOR_GROUP));
	public static final ArmorItem sapphireBoots=new ArmorItem(MGTAArmorMaterials.SAPPHIRE, EquipmentSlot.FEET,new Item.Settings().group(MoreGemsToolsArmor.MOREGEMSTOOLSARMOR_GROUP));
	public static final ArmorItem brownGemHelmet=new ArmorItem(MGTAArmorMaterials.BROWN_GEM, EquipmentSlot.HEAD,new Item.Settings().group(MoreGemsToolsArmor.MOREGEMSTOOLSARMOR_GROUP));
	public static final ArmorItem brownGemChestplate=new ArmorItem(MGTAArmorMaterials.BROWN_GEM, EquipmentSlot.CHEST,new Item.Settings().group(MoreGemsToolsArmor.MOREGEMSTOOLSARMOR_GROUP));
	public static final ArmorItem brownGemLeggings=new ArmorItem(MGTAArmorMaterials.BROWN_GEM, EquipmentSlot.LEGS,new Item.Settings().group(MoreGemsToolsArmor.MOREGEMSTOOLSARMOR_GROUP));
	public static final ArmorItem brownGemBoots=new ArmorItem(MGTAArmorMaterials.BROWN_GEM, EquipmentSlot.FEET,new Item.Settings().group(MoreGemsToolsArmor.MOREGEMSTOOLSARMOR_GROUP));
	public static final ArmorItem purpleGemHelmet=new ArmorItem(MGTAArmorMaterials.PURPLE_GEM, EquipmentSlot.HEAD,new Item.Settings().group(MoreGemsToolsArmor.MOREGEMSTOOLSARMOR_GROUP));
	public static final ArmorItem purpleGemChestplate=new ArmorItem(MGTAArmorMaterials.PURPLE_GEM, EquipmentSlot.CHEST,new Item.Settings().group(MoreGemsToolsArmor.MOREGEMSTOOLSARMOR_GROUP));
	public static final ArmorItem purpleGemLeggings=new ArmorItem(MGTAArmorMaterials.PURPLE_GEM, EquipmentSlot.LEGS,new Item.Settings().group(MoreGemsToolsArmor.MOREGEMSTOOLSARMOR_GROUP));
	public static final ArmorItem purpleGemBoots=new ArmorItem(MGTAArmorMaterials.PURPLE_GEM, EquipmentSlot.FEET,new Item.Settings().group(MoreGemsToolsArmor.MOREGEMSTOOLSARMOR_GROUP));
	public static final ArmorItem rubyHelmet=new ArmorItem(MGTAArmorMaterials.RUBY, EquipmentSlot.HEAD,new Item.Settings().group(MoreGemsToolsArmor.MOREGEMSTOOLSARMOR_GROUP));
	public static final ArmorItem rubyChestplate=new ArmorItem(MGTAArmorMaterials.RUBY, EquipmentSlot.CHEST,new Item.Settings().group(MoreGemsToolsArmor.MOREGEMSTOOLSARMOR_GROUP));
	public static final ArmorItem rubyLeggings=new ArmorItem(MGTAArmorMaterials.RUBY, EquipmentSlot.LEGS,new Item.Settings().group(MoreGemsToolsArmor.MOREGEMSTOOLSARMOR_GROUP));
	public static final ArmorItem rubyBoots=new ArmorItem(MGTAArmorMaterials.RUBY, EquipmentSlot.FEET,new Item.Settings().group(MoreGemsToolsArmor.MOREGEMSTOOLSARMOR_GROUP));
	public static final ArmorItem yellowGemHelmet=new ArmorItem(MGTAArmorMaterials.YELLOW_GEM, EquipmentSlot.HEAD,new Item.Settings().group(MoreGemsToolsArmor.MOREGEMSTOOLSARMOR_GROUP));
	public static final ArmorItem yellowGemChestplate=new ArmorItem(MGTAArmorMaterials.YELLOW_GEM, EquipmentSlot.CHEST,new Item.Settings().group(MoreGemsToolsArmor.MOREGEMSTOOLSARMOR_GROUP));
	public static final ArmorItem yellowGemLeggings=new ArmorItem(MGTAArmorMaterials.YELLOW_GEM, EquipmentSlot.LEGS,new Item.Settings().group(MoreGemsToolsArmor.MOREGEMSTOOLSARMOR_GROUP));
	public static final ArmorItem yellowGemBoots=new ArmorItem(MGTAArmorMaterials.YELLOW_GEM, EquipmentSlot.FEET,new Item.Settings().group(MoreGemsToolsArmor.MOREGEMSTOOLSARMOR_GROUP));
	public static final ArmorItem emeraldHelmet=new ArmorItem(MGTAArmorMaterials.EMERALD, EquipmentSlot.HEAD,new Item.Settings().group(MoreGemsToolsArmor.MOREGEMSTOOLSARMOR_GROUP));
	public static final ArmorItem emeraldChestplate=new ArmorItem(MGTAArmorMaterials.EMERALD, EquipmentSlot.CHEST,new Item.Settings().group(MoreGemsToolsArmor.MOREGEMSTOOLSARMOR_GROUP));
	public static final ArmorItem emeraldLeggings=new ArmorItem(MGTAArmorMaterials.EMERALD, EquipmentSlot.LEGS,new Item.Settings().group(MoreGemsToolsArmor.MOREGEMSTOOLSARMOR_GROUP));
	public static final ArmorItem emeraldBoots=new ArmorItem(MGTAArmorMaterials.EMERALD, EquipmentSlot.FEET,new Item.Settings().group(MoreGemsToolsArmor.MOREGEMSTOOLSARMOR_GROUP));
	public static final ToolItem brownGemSword=new SwordItem(MGTAToolMaterial.BROWN_GEM,4,-2.0F,new Item.Settings().group(MoreGemsToolsArmor.MOREGEMSTOOLSARMOR_GROUP));
	public static final ToolItem purpleGemSword=new SwordItem(MGTAToolMaterial.PURPLE_GEM,4,-2.0F,new Item.Settings().group(MoreGemsToolsArmor.MOREGEMSTOOLSARMOR_GROUP));
	public static final ToolItem sapphireSword=new SwordItem(MGTAToolMaterial.SAPPHIRE,4,-2.0F,new Item.Settings().group(MoreGemsToolsArmor.MOREGEMSTOOLSARMOR_GROUP));
	public static final ToolItem rubySword=new SwordItem(MGTAToolMaterial.RUBY,4,-2.0F,new Item.Settings().group(MoreGemsToolsArmor.MOREGEMSTOOLSARMOR_GROUP));
	public static final ToolItem yellowGemSword=new SwordItem(MGTAToolMaterial.YELLOW_GEM,4,-2.0F,new Item.Settings().group(MoreGemsToolsArmor.MOREGEMSTOOLSARMOR_GROUP));
	public static final ToolItem emeraldSword=new SwordItem(MGTAToolMaterial.EMERALD,4,-2.0F,new Item.Settings().group(MoreGemsToolsArmor.MOREGEMSTOOLSARMOR_GROUP));
	public static final ToolItem brownGemShovel=new ShovelItem(MGTAToolMaterial.BROWN_GEM,1.6F,-2.8F,new Item.Settings().group(MoreGemsToolsArmor.MOREGEMSTOOLSARMOR_GROUP));
	public static final ToolItem purpleGemShovel=new ShovelItem(MGTAToolMaterial.PURPLE_GEM,1.6F,-2.8F,new Item.Settings().group(MoreGemsToolsArmor.MOREGEMSTOOLSARMOR_GROUP));
	public static final ToolItem sapphireShovel=new ShovelItem(MGTAToolMaterial.SAPPHIRE,1.6F,-2.8F,new Item.Settings().group(MoreGemsToolsArmor.MOREGEMSTOOLSARMOR_GROUP));
	public static final ToolItem rubyShovel=new ShovelItem(MGTAToolMaterial.RUBY,1.6F,-2.8F,new Item.Settings().group(MoreGemsToolsArmor.MOREGEMSTOOLSARMOR_GROUP));
	public static final ToolItem yellowGemShovel=new ShovelItem(MGTAToolMaterial.YELLOW_GEM,1.6F,-2.8F,new Item.Settings().group(MoreGemsToolsArmor.MOREGEMSTOOLSARMOR_GROUP));
	public static final ToolItem emeraldShovel=new ShovelItem(MGTAToolMaterial.EMERALD,1.6F,-2.8F,new Item.Settings().group(MoreGemsToolsArmor.MOREGEMSTOOLSARMOR_GROUP));
	public static final ToolItem brownGemPickaxe=new MGTAPickaxeItem(MGTAToolMaterial.BROWN_GEM,1,-2.6F,new Item.Settings().group(MoreGemsToolsArmor.MOREGEMSTOOLSARMOR_GROUP));
	public static final ToolItem purpleGemPickaxe=new MGTAPickaxeItem(MGTAToolMaterial.PURPLE_GEM,1,-2.6F,new Item.Settings().group(MoreGemsToolsArmor.MOREGEMSTOOLSARMOR_GROUP));
	public static final ToolItem sapphirePickaxe=new MGTAPickaxeItem(MGTAToolMaterial.SAPPHIRE,1,-2.6F,new Item.Settings().group(MoreGemsToolsArmor.MOREGEMSTOOLSARMOR_GROUP));
	public static final ToolItem rubyPickaxe=new MGTAPickaxeItem(MGTAToolMaterial.RUBY,1,-2.6F,new Item.Settings().group(MoreGemsToolsArmor.MOREGEMSTOOLSARMOR_GROUP));
	public static final ToolItem yellowGemPickaxe=new MGTAPickaxeItem(MGTAToolMaterial.YELLOW_GEM,1,-2.6F,new Item.Settings().group(MoreGemsToolsArmor.MOREGEMSTOOLSARMOR_GROUP));
	public static final ToolItem emeraldPickaxe=new MGTAPickaxeItem(MGTAToolMaterial.EMERALD,1,-2.6F,new Item.Settings().group(MoreGemsToolsArmor.MOREGEMSTOOLSARMOR_GROUP));
	public static final ToolItem brownGemAxe=new MGTAAxeItem(MGTAToolMaterial.BROWN_GEM,6,-2.8F,new Item.Settings().group(MoreGemsToolsArmor.MOREGEMSTOOLSARMOR_GROUP));
	public static final ToolItem purpleGemAxe=new MGTAAxeItem(MGTAToolMaterial.PURPLE_GEM,6,-2.8F,new Item.Settings().group(MoreGemsToolsArmor.MOREGEMSTOOLSARMOR_GROUP));
	public static final ToolItem sapphireAxe=new MGTAAxeItem(MGTAToolMaterial.SAPPHIRE,6,-2.8F,new Item.Settings().group(MoreGemsToolsArmor.MOREGEMSTOOLSARMOR_GROUP));
	public static final ToolItem rubyAxe=new MGTAAxeItem(MGTAToolMaterial.RUBY,6,-2.8F,new Item.Settings().group(MoreGemsToolsArmor.MOREGEMSTOOLSARMOR_GROUP));
	public static final ToolItem yellowGemAxe=new MGTAAxeItem(MGTAToolMaterial.YELLOW_GEM,6,-2.8F,new Item.Settings().group(MoreGemsToolsArmor.MOREGEMSTOOLSARMOR_GROUP));
	public static final ToolItem emeraldAxe=new MGTAAxeItem(MGTAToolMaterial.EMERALD,6,-2.8F,new Item.Settings().group(MoreGemsToolsArmor.MOREGEMSTOOLSARMOR_GROUP));

	public static final ToolItem brownGemHoe=new MGTAHoeItem(MGTAToolMaterial.BROWN_GEM,-3,0.0F,new Item.Settings().group(MoreGemsToolsArmor.MOREGEMSTOOLSARMOR_GROUP));
	public static final ToolItem purpleGemHoe=new MGTAHoeItem(MGTAToolMaterial.PURPLE_GEM,-3,0.0F,new Item.Settings().group(MoreGemsToolsArmor.MOREGEMSTOOLSARMOR_GROUP));
	public static final ToolItem sapphireHoe=new MGTAHoeItem(MGTAToolMaterial.SAPPHIRE,-3,0.0F,new Item.Settings().group(MoreGemsToolsArmor.MOREGEMSTOOLSARMOR_GROUP));
	public static final ToolItem rubyHoe=new MGTAHoeItem(MGTAToolMaterial.RUBY,-3,0.0F,new Item.Settings().group(MoreGemsToolsArmor.MOREGEMSTOOLSARMOR_GROUP));
	public static final ToolItem yellowGemHoe=new MGTAHoeItem(MGTAToolMaterial.YELLOW_GEM,-3,0.F,new Item.Settings().group(MoreGemsToolsArmor.MOREGEMSTOOLSARMOR_GROUP));
	public static final ToolItem emeraldHoe=new MGTAHoeItem(MGTAToolMaterial.EMERALD,-3,0.0F,new Item.Settings().group(MoreGemsToolsArmor.MOREGEMSTOOLSARMOR_GROUP));

	public static final Item diamondApple=new Item((new Item.Settings()).group(MoreGemsToolsArmor.MOREGEMSTOOLSARMOR_GROUP).rarity(Rarity.RARE).food(MGTAFoodComponents.DIAMOND_APPLE));
	public static final Item ironApple=new Item((new Item.Settings()).group(MoreGemsToolsArmor.MOREGEMSTOOLSARMOR_GROUP).rarity(Rarity.RARE).food(MGTAFoodComponents.IRON_APPLE));
	public static final Item emeraldApple=new Item((new Item.Settings()).group(MoreGemsToolsArmor.MOREGEMSTOOLSARMOR_GROUP).rarity(Rarity.RARE).food(MGTAFoodComponents.EMERALD_APPLE));
	public static final Item sapphireApple=new Item((new Item.Settings()).group(MoreGemsToolsArmor.MOREGEMSTOOLSARMOR_GROUP).rarity(Rarity.RARE).food(MGTAFoodComponents.SAPPHIRE_APPLE));
	public static final Item brownGemApple=new Item((new Item.Settings()).group(MoreGemsToolsArmor.MOREGEMSTOOLSARMOR_GROUP).rarity(Rarity.RARE).food(MGTAFoodComponents.BROWN_GEM_APPLE));
	public static final Item purpleGemApple=new Item((new Item.Settings()).group(MoreGemsToolsArmor.MOREGEMSTOOLSARMOR_GROUP).rarity(Rarity.RARE).food(MGTAFoodComponents.PURPLE_GEM_APPLE));
	public static final Item rubyApple=new Item((new Item.Settings()).group(MoreGemsToolsArmor.MOREGEMSTOOLSARMOR_GROUP).rarity(Rarity.RARE).food(MGTAFoodComponents.RUBY_APPLE));
	public static final Item yellowGemApple=new Item((new Item.Settings()).group(MoreGemsToolsArmor.MOREGEMSTOOLSARMOR_GROUP).rarity(Rarity.RARE).food(MGTAFoodComponents.YELLOW_GEM_APPLE));
	public static final Item quartzApple=new Item((new Item.Settings()).group(MoreGemsToolsArmor.MOREGEMSTOOLSARMOR_GROUP).rarity(Rarity.RARE).food(MGTAFoodComponents.QUARTZ_APPLE));
	public static final Item netheriteApple=new Item((new Item.Settings()).group(MoreGemsToolsArmor.MOREGEMSTOOLSARMOR_GROUP).rarity(Rarity.RARE).food(MGTAFoodComponents.NETHERITE_APPLE));
	public static final Item enchantedDiamondApple=new EnchantedAppleItem((new Item.Settings()).group(MoreGemsToolsArmor.MOREGEMSTOOLSARMOR_GROUP).rarity(Rarity.EPIC).food(MGTAFoodComponents.ENCHANTED_DIAMOND_APPLE));
	public static final Item enchantedIronApple=new EnchantedAppleItem((new Item.Settings()).group(MoreGemsToolsArmor.MOREGEMSTOOLSARMOR_GROUP).rarity(Rarity.EPIC).food(MGTAFoodComponents.ENCHANTED_IRON_APPLE));
	public static final Item enchantedEmeraldApple=new EnchantedAppleItem((new Item.Settings()).group(MoreGemsToolsArmor.MOREGEMSTOOLSARMOR_GROUP).rarity(Rarity.EPIC).food(MGTAFoodComponents.ENCHANTED_EMERALD_APPLE));
	public static final Item enchantedSapphireApple=new EnchantedAppleItem((new Item.Settings()).group(MoreGemsToolsArmor.MOREGEMSTOOLSARMOR_GROUP).rarity(Rarity.EPIC).food(MGTAFoodComponents.ENCHANTED_SAPPHIRE_APPLE));
	public static final Item enchantedBrownGemApple=new EnchantedAppleItem((new Item.Settings()).group(MoreGemsToolsArmor.MOREGEMSTOOLSARMOR_GROUP).rarity(Rarity.EPIC).food(MGTAFoodComponents.ENCHANTED_BROWN_GEM_APPLE));
	public static final Item enchantedPurpleGemApple=new EnchantedAppleItem((new Item.Settings()).group(MoreGemsToolsArmor.MOREGEMSTOOLSARMOR_GROUP).rarity(Rarity.EPIC).food(MGTAFoodComponents.ENCHANTED_PURPLE_GEM_APPLE));
	public static final Item enchantedRubyApple=new EnchantedAppleItem((new Item.Settings()).group(MoreGemsToolsArmor.MOREGEMSTOOLSARMOR_GROUP).rarity(Rarity.EPIC).food(MGTAFoodComponents.ENCHANTED_RUBY_APPLE));
	public static final Item enchantedYellowGemApple=new EnchantedAppleItem((new Item.Settings()).group(MoreGemsToolsArmor.MOREGEMSTOOLSARMOR_GROUP).rarity(Rarity.EPIC).food(MGTAFoodComponents.ENCHANTED_YELLOW_GEM_APPLE));
	public static final Item enchantedQuartzApple=new EnchantedAppleItem((new Item.Settings()).group(MoreGemsToolsArmor.MOREGEMSTOOLSARMOR_GROUP).rarity(Rarity.EPIC).food(MGTAFoodComponents.ENCHANTED_QUARTZ_APPLE));
	public static final Item enchantedNetheriteApple=new EnchantedAppleItem((new Item.Settings()).group(MoreGemsToolsArmor.MOREGEMSTOOLSARMOR_GROUP).rarity(Rarity.EPIC).food(MGTAFoodComponents.ENCHANTED_NETHERITE_APPLE));
	public static final Item mixedGemApple=new Item((new Item.Settings()).group(MoreGemsToolsArmor.MOREGEMSTOOLSARMOR_GROUP).rarity(Rarity.RARE).food(MGTAFoodComponents.MIXED_GEM_APPLE));
	public static final Item enchantedMixedGemApple=new EnchantedAppleItem((new Item.Settings()).group(MoreGemsToolsArmor.MOREGEMSTOOLSARMOR_GROUP).rarity(Rarity.EPIC).food(MGTAFoodComponents.ENCHANTED_MIXED_GEM_APPLE));


	public static final ToolItem mixedGemSword=new SwordItem(MGTAToolMaterial.MIXED_GEM,4,-2.0F,new Item.Settings().group(MoreGemsToolsArmor.MOREGEMSTOOLSARMOR_GROUP));
	public static final ToolItem mixedGemShovel=new ShovelItem(MGTAToolMaterial.MIXED_GEM,1.6F,-2.8F,new Item.Settings().group(MoreGemsToolsArmor.MOREGEMSTOOLSARMOR_GROUP));
	public static final ToolItem mixedGemPickaxe=new MGTAPickaxeItem(MGTAToolMaterial.MIXED_GEM,1,-2.6F,new Item.Settings().group(MoreGemsToolsArmor.MOREGEMSTOOLSARMOR_GROUP));
	public static final ToolItem mixedGemAxe=new MGTAAxeItem(MGTAToolMaterial.MIXED_GEM,6,-2.8F,new Item.Settings().group(MoreGemsToolsArmor.MOREGEMSTOOLSARMOR_GROUP));
	public static final ToolItem mixedGemHoe=new MGTAHoeItem(MGTAToolMaterial.MIXED_GEM,-3,0.0F,new Item.Settings().group(MoreGemsToolsArmor.MOREGEMSTOOLSARMOR_GROUP));

	public static final ArmorItem mixedGemHelmet=new ArmorItem(MGTAArmorMaterials.MIXED_GEM, EquipmentSlot.HEAD,new Item.Settings().group(MoreGemsToolsArmor.MOREGEMSTOOLSARMOR_GROUP));
	public static final ArmorItem mixedGemChestplate=new ArmorItem(MGTAArmorMaterials.MIXED_GEM, EquipmentSlot.CHEST,new Item.Settings().group(MoreGemsToolsArmor.MOREGEMSTOOLSARMOR_GROUP));
	public static final ArmorItem mixedGemLeggings=new ArmorItem(MGTAArmorMaterials.MIXED_GEM, EquipmentSlot.LEGS,new Item.Settings().group(MoreGemsToolsArmor.MOREGEMSTOOLSARMOR_GROUP));
	public static final ArmorItem mixedGemBoots=new ArmorItem(MGTAArmorMaterials.MIXED_GEM, EquipmentSlot.FEET,new Item.Settings().group(MoreGemsToolsArmor.MOREGEMSTOOLSARMOR_GROUP));

	public static ConfiguredFeature<?, ?> ORE_BROWN_GEM_ORE = Feature.ORE.configure(new OreFeatureConfig(OreFeatureConfig.Rules.BASE_STONE_OVERWORLD,
					brownGemOre.getDefaultState(),
					3))
			.decorate(Decorator.RANGE.configure(new RangeDecoratorConfig(
					0,
					0,
					48)))
			.spreadHorizontally()
			.repeat(6);

    public static ConfiguredFeature<?, ?> ORE_PURPLE_GEM_ORE = Feature.ORE.configure(new OreFeatureConfig(OreFeatureConfig.Rules.BASE_STONE_OVERWORLD,
            purpleGemOre.getDefaultState(),
            3))
            .decorate(Decorator.RANGE.configure(new RangeDecoratorConfig(
                    0,
                    0,
                    48)))
            .spreadHorizontally()
            .repeat(6);

    public static ConfiguredFeature<?, ?> ORE_SAPPHIRE_ORE = Feature.ORE.configure(new OreFeatureConfig(OreFeatureConfig.Rules.BASE_STONE_OVERWORLD,
            sapphireOre.getDefaultState(),
            3))
            .decorate(Decorator.RANGE.configure(new RangeDecoratorConfig(
                    0,
                    0,
                    48)))
            .spreadHorizontally()
            .repeat(6);

    public static ConfiguredFeature<?, ?> ORE_RUBY_ORE = Feature.ORE.configure(new OreFeatureConfig(OreFeatureConfig.Rules.BASE_STONE_OVERWORLD,
            rubyOre.getDefaultState(),
            3))
            .decorate(Decorator.RANGE.configure(new RangeDecoratorConfig(
                    0,
                    0,
                    48)))
            .spreadHorizontally()
            .repeat(6);

    public static ConfiguredFeature<?, ?> ORE_YELLOW_GEM_ORE = Feature.ORE.configure(new OreFeatureConfig(OreFeatureConfig.Rules.BASE_STONE_OVERWORLD,
            yellowGemOre.getDefaultState(),
            3))
            .decorate(Decorator.RANGE.configure(new RangeDecoratorConfig(
                    0,
                    0,
                    48)))
            .spreadHorizontally()
            .repeat(6);

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
				//stacks.add(new ItemStack(MoreGemsToolsArmor.itemUpgradeTable));
			}).build();

	@Override
	public void onInitialize() {
		//og115();
		og116();
		Registry.register(Registry.ITEM, new Identifier(namespace, "sapphire"),sapphire);
		Registry.register(Registry.ITEM, new Identifier(namespace, "brown_gem"),brownGem);
		Registry.register(Registry.ITEM, new Identifier(namespace, "purple_gem"),purpleGem);
		Registry.register(Registry.ITEM, new Identifier(namespace, "ruby"),ruby);
		Registry.register(Registry.ITEM, new Identifier(namespace, "yellow_gem"),yellowGem);Registry.register(Registry.BLOCK, new Identifier(namespace, "sapphire_block"), sapphireBlock);
		Registry.register(Registry.ITEM, new Identifier(namespace, "sapphire_block"), new BlockItem(sapphireBlock, new Item.Settings().group(MoreGemsToolsArmor.MOREGEMSTOOLSARMOR_GROUP)));
		Registry.register(Registry.BLOCK, new Identifier(namespace, "brown_gem_block"), brownGemBlock);
		Registry.register(Registry.ITEM, new Identifier(namespace, "brown_gem_block"), new BlockItem(brownGemBlock, new Item.Settings().group(MoreGemsToolsArmor.MOREGEMSTOOLSARMOR_GROUP)));
		Registry.register(Registry.BLOCK, new Identifier(namespace, "purple_gem_block"), purpleGemBlock);
		Registry.register(Registry.ITEM, new Identifier(namespace, "purple_gem_block"), new BlockItem(purpleGemBlock, new Item.Settings().group(MoreGemsToolsArmor.MOREGEMSTOOLSARMOR_GROUP)));
		Registry.register(Registry.BLOCK, new Identifier(namespace, "ruby_block"), rubyBlock);
		Registry.register(Registry.ITEM, new Identifier(namespace, "ruby_block"), new BlockItem(rubyBlock, new Item.Settings().group(MoreGemsToolsArmor.MOREGEMSTOOLSARMOR_GROUP)));
		Registry.register(Registry.BLOCK, new Identifier(namespace, "yellow_gem_block"), yellowGemBlock);
		Registry.register(Registry.ITEM, new Identifier(namespace, "yellow_gem_block"), new BlockItem(yellowGemBlock, new Item.Settings().group(MoreGemsToolsArmor.MOREGEMSTOOLSARMOR_GROUP)));
		Registry.register(Registry.BLOCK, new Identifier(namespace, "sapphire_ore"), sapphireOre);
		Registry.register(Registry.ITEM, new Identifier(namespace, "sapphire_ore"), new BlockItem(sapphireOre, new Item.Settings().group(MoreGemsToolsArmor.MOREGEMSTOOLSARMOR_GROUP)));
		Registry.register(Registry.BLOCK, new Identifier(namespace, "brown_gem_ore"), brownGemOre);
		Registry.register(Registry.ITEM, new Identifier(namespace, "brown_gem_ore"), new BlockItem(brownGemOre, new Item.Settings().group(MoreGemsToolsArmor.MOREGEMSTOOLSARMOR_GROUP)));
		Registry.register(Registry.BLOCK, new Identifier(namespace, "purple_gem_ore"), purpleGemOre);
		Registry.register(Registry.ITEM, new Identifier(namespace, "purple_gem_ore"), new BlockItem(purpleGemOre, new Item.Settings().group(MoreGemsToolsArmor.MOREGEMSTOOLSARMOR_GROUP)));
		Registry.register(Registry.BLOCK, new Identifier(namespace, "ruby_ore"), rubyOre);
		Registry.register(Registry.ITEM, new Identifier(namespace, "ruby_ore"), new BlockItem(rubyOre, new Item.Settings().group(MoreGemsToolsArmor.MOREGEMSTOOLSARMOR_GROUP)));
		Registry.register(Registry.BLOCK, new Identifier(namespace, "yellow_gem_ore"), yellowGemOre);
		Registry.register(Registry.ITEM, new Identifier(namespace, "yellow_gem_ore"), new BlockItem(yellowGemOre, new Item.Settings().group(MoreGemsToolsArmor.MOREGEMSTOOLSARMOR_GROUP)));
		Registry.register(Registry.BLOCK, new Identifier(namespace, "stone_of_experience"), stoneOfExperience);
		Registry.register(Registry.ITEM, new Identifier(namespace, "stone_of_experience"), new BlockItem(stoneOfExperience, new Item.Settings().group(MoreGemsToolsArmor.MOREGEMSTOOLSARMOR_GROUP)));
		Registry.register(Registry.ITEM, new Identifier(namespace, "sapphire_helmet"),sapphireHelmet);
		Registry.register(Registry.ITEM, new Identifier(namespace, "sapphire_chestplate"),sapphireChestplate);
		Registry.register(Registry.ITEM, new Identifier(namespace, "sapphire_leggings"),sapphireLeggings);
		Registry.register(Registry.ITEM, new Identifier(namespace, "sapphire_boots"),sapphireBoots);
		Registry.register(Registry.ITEM, new Identifier(namespace, "brown_gem_helmet"),brownGemHelmet);
		Registry.register(Registry.ITEM, new Identifier(namespace, "brown_gem_chestplate"),brownGemChestplate);
		Registry.register(Registry.ITEM, new Identifier(namespace, "brown_gem_leggings"),brownGemLeggings);
		Registry.register(Registry.ITEM, new Identifier(namespace, "brown_gem_boots"),brownGemBoots);
		Registry.register(Registry.ITEM, new Identifier(namespace, "purple_gem_helmet"),purpleGemHelmet);
		Registry.register(Registry.ITEM, new Identifier(namespace, "purple_gem_chestplate"),purpleGemChestplate);
		Registry.register(Registry.ITEM, new Identifier(namespace, "purple_gem_leggings"),purpleGemLeggings);
		Registry.register(Registry.ITEM, new Identifier(namespace, "purple_gem_boots"),purpleGemBoots);
		Registry.register(Registry.ITEM, new Identifier(namespace, "ruby_helmet"),rubyHelmet);
		Registry.register(Registry.ITEM, new Identifier(namespace, "ruby_chestplate"),rubyChestplate);
		Registry.register(Registry.ITEM, new Identifier(namespace, "ruby_leggings"),rubyLeggings);
		Registry.register(Registry.ITEM, new Identifier(namespace, "ruby_boots"),rubyBoots);
		Registry.register(Registry.ITEM, new Identifier(namespace, "yellow_gem_helmet"),yellowGemHelmet);
		Registry.register(Registry.ITEM, new Identifier(namespace, "yellow_gem_chestplate"),yellowGemChestplate);
		Registry.register(Registry.ITEM, new Identifier(namespace, "yellow_gem_leggings"),yellowGemLeggings);
		Registry.register(Registry.ITEM, new Identifier(namespace, "yellow_gem_boots"),yellowGemBoots);
		Registry.register(Registry.ITEM, new Identifier(namespace, "emerald_helmet"),emeraldHelmet);
		Registry.register(Registry.ITEM, new Identifier(namespace, "emerald_chestplate"),emeraldChestplate);
		Registry.register(Registry.ITEM, new Identifier(namespace, "emerald_leggings"),emeraldLeggings);
		Registry.register(Registry.ITEM, new Identifier(namespace, "emerald_boots"),emeraldBoots);
		Registry.register(Registry.ITEM, new Identifier(namespace, "sapphire_sword"),sapphireSword);
		Registry.register(Registry.ITEM, new Identifier(namespace, "brown_gem_sword"),brownGemSword);
		Registry.register(Registry.ITEM, new Identifier(namespace, "purple_gem_sword"),purpleGemSword);
		Registry.register(Registry.ITEM, new Identifier(namespace, "ruby_sword"),rubySword);
		Registry.register(Registry.ITEM, new Identifier(namespace, "yellow_gem_sword"),yellowGemSword);
		Registry.register(Registry.ITEM, new Identifier(namespace, "emerald_sword"),emeraldSword);
		Registry.register(Registry.ITEM, new Identifier(namespace, "sapphire_shovel"),sapphireShovel);
		Registry.register(Registry.ITEM, new Identifier(namespace, "brown_gem_shovel"),brownGemShovel);
		Registry.register(Registry.ITEM, new Identifier(namespace, "purple_gem_shovel"),purpleGemShovel);
		Registry.register(Registry.ITEM, new Identifier(namespace, "ruby_shovel"),rubyShovel);
		Registry.register(Registry.ITEM, new Identifier(namespace, "yellow_gem_shovel"),yellowGemShovel);
		Registry.register(Registry.ITEM, new Identifier(namespace, "emerald_shovel"),emeraldShovel);
		Registry.register(Registry.ITEM, new Identifier(namespace, "sapphire_pickaxe"),sapphirePickaxe);
		Registry.register(Registry.ITEM, new Identifier(namespace, "brown_gem_pickaxe"),brownGemPickaxe);
		Registry.register(Registry.ITEM, new Identifier(namespace, "purple_gem_pickaxe"),purpleGemPickaxe);
		Registry.register(Registry.ITEM, new Identifier(namespace, "ruby_pickaxe"),rubyPickaxe);
		Registry.register(Registry.ITEM, new Identifier(namespace, "yellow_gem_pickaxe"),yellowGemPickaxe);
		Registry.register(Registry.ITEM, new Identifier(namespace, "emerald_pickaxe"),emeraldPickaxe);
		Registry.register(Registry.ITEM, new Identifier(namespace, "sapphire_axe"),sapphireAxe);
		Registry.register(Registry.ITEM, new Identifier(namespace, "brown_gem_axe"),brownGemAxe);
		Registry.register(Registry.ITEM, new Identifier(namespace, "purple_gem_axe"),purpleGemAxe);
		Registry.register(Registry.ITEM, new Identifier(namespace, "ruby_axe"),rubyAxe);
		Registry.register(Registry.ITEM, new Identifier(namespace, "yellow_gem_axe"),yellowGemAxe);
		Registry.register(Registry.ITEM, new Identifier(namespace, "emerald_axe"),emeraldAxe);
		Registry.register(Registry.ITEM, new Identifier(namespace, "sapphire_hoe"),sapphireHoe);
		Registry.register(Registry.ITEM, new Identifier(namespace, "brown_gem_hoe"),brownGemHoe);
		Registry.register(Registry.ITEM, new Identifier(namespace, "purple_gem_hoe"),purpleGemHoe);
		Registry.register(Registry.ITEM, new Identifier(namespace, "ruby_hoe"),rubyHoe);
		Registry.register(Registry.ITEM, new Identifier(namespace, "yellow_gem_hoe"),yellowGemHoe);
		Registry.register(Registry.ITEM, new Identifier(namespace, "emerald_hoe"),emeraldHoe);
		Registry.register(Registry.ITEM, new Identifier(namespace, "diamond_apple"),diamondApple);
		Registry.register(Registry.ITEM, new Identifier(namespace, "iron_apple"),ironApple);
		Registry.register(Registry.ITEM, new Identifier(namespace, "emerald_apple"),emeraldApple);
		Registry.register(Registry.ITEM, new Identifier(namespace, "sapphire_apple"),sapphireApple);
		Registry.register(Registry.ITEM, new Identifier(namespace, "brown_gem_apple"),brownGemApple);
		Registry.register(Registry.ITEM, new Identifier(namespace, "purple_gem_apple"),purpleGemApple);
		Registry.register(Registry.ITEM, new Identifier(namespace, "ruby_apple"),rubyApple);
		Registry.register(Registry.ITEM, new Identifier(namespace, "yellow_gem_apple"),yellowGemApple);
		Registry.register(Registry.ITEM, new Identifier(namespace, "quartz_apple"),quartzApple);
		Registry.register(Registry.ITEM, new Identifier(namespace, "netherite_apple"),netheriteApple);
		Registry.register(Registry.ITEM, new Identifier(namespace, "enchanted_diamond_apple"),enchantedDiamondApple);
		Registry.register(Registry.ITEM, new Identifier(namespace, "enchanted_iron_apple"),enchantedIronApple);
		Registry.register(Registry.ITEM, new Identifier(namespace, "enchanted_emerald_apple"),enchantedEmeraldApple);
		Registry.register(Registry.ITEM, new Identifier(namespace, "enchanted_sapphire_apple"),enchantedSapphireApple);
		Registry.register(Registry.ITEM, new Identifier(namespace, "enchanted_brown_gem_apple"),enchantedBrownGemApple);
		Registry.register(Registry.ITEM, new Identifier(namespace, "enchanted_purple_gem_apple"),enchantedPurpleGemApple);
		Registry.register(Registry.ITEM, new Identifier(namespace, "enchanted_ruby_apple"),enchantedRubyApple);
		Registry.register(Registry.ITEM, new Identifier(namespace, "enchanted_yellow_gem_apple"),enchantedYellowGemApple);
		Registry.register(Registry.ITEM, new Identifier(namespace, "enchanted_quartz_apple"),enchantedQuartzApple);
		Registry.register(Registry.ITEM, new Identifier(namespace, "enchanted_netherite_apple"),enchantedNetheriteApple);

		Registry.register(Registry.ITEM, new Identifier(namespace, "mixed_gem_sword"),mixedGemSword);
		Registry.register(Registry.ITEM, new Identifier(namespace, "mixed_gem_shovel"),mixedGemShovel);
		Registry.register(Registry.ITEM, new Identifier(namespace, "mixed_gem_pickaxe"),mixedGemPickaxe);
		Registry.register(Registry.ITEM, new Identifier(namespace, "mixed_gem_axe"),mixedGemAxe);
		Registry.register(Registry.ITEM, new Identifier(namespace, "mixed_gem_hoe"),mixedGemHoe);
		Registry.register(Registry.ITEM, new Identifier(namespace, "mixed_gem_helmet"),mixedGemHelmet);
		Registry.register(Registry.ITEM, new Identifier(namespace, "mixed_gem_chestplate"), mixedGemChestplate);
		Registry.register(Registry.ITEM, new Identifier(namespace, "mixed_gem_leggings"),mixedGemLeggings);
		Registry.register(Registry.ITEM, new Identifier(namespace, "mixed_gem_boots"),mixedGemBoots);
		Registry.register(Registry.ITEM, new Identifier(namespace, "mixed_gem_apple"),mixedGemApple);
		Registry.register(Registry.ITEM, new Identifier(namespace, "enchanted_mixed_gem_apple"),enchantedMixedGemApple);
		/*Registry.register(Registry.BLOCK, new Identifier(namespace, "item_upgrade_table"), itemUpgradeTable);
		Registry.register(Registry.ITEM, new Identifier(namespace, "item_upgrade_table"), new BlockItem(itemUpgradeTable, new Item.Settings().group(MoreGemsToolsArmor.MOREGEMSTOOLSARMOR_GROUP)));
		itemUpgradeTableBlockEntityType=Registry.register(Registry.BLOCK_ENTITY_TYPE,new Identifier(namespace,"item_upgrade_table_block_entity_type"),BlockEntityType.Builder.create(ItemUpgradeTableContainerBlockEntity::new,itemUpgradeTable).build(null));
		ContainerProviderRegistry.INSTANCE.registerFactory(new Identifier(namespace,"item_upgrade_table_block_entity_type"),((syncId, identifier, player, buf) ->{


			return ((ItemUpgradeTableContainerBlockEntity) Objects.requireNonNull(player.world.getBlockEntity(buf.readBlockPos()))).createContainer(syncId, player.inventory);
		}));*/



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
						mixedGemPickaxe
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

	public void og116(){
		Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, new Identifier(namespace, "ore_brown_gem_ore"), ORE_BROWN_GEM_ORE);
		Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, new Identifier(namespace, "ore_purple_gem_ore"), ORE_PURPLE_GEM_ORE);
		Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, new Identifier(namespace, "ore_sapphire_ore"), ORE_SAPPHIRE_ORE);
		Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, new Identifier(namespace, "ore_ruby_ore"), ORE_RUBY_ORE);
		Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, new Identifier(namespace, "ore_yellow_gem_ore"), ORE_YELLOW_GEM_ORE);
		Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, new Identifier(namespace, "ore_stone_of_experience"), ORE_STONE_OF_EXPERIENCE);

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
}*/}
