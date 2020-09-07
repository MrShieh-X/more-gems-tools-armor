package com.mrshiehx.mcmods.moregemstoolsarmor.item;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.FoodComponent;

public class MGTAFoodComponents {
    public static final FoodComponent DIAMOND_APPLE;
    public static final FoodComponent IRON_APPLE;
    public static final FoodComponent EMERALD_APPLE;
    public static final FoodComponent SAPPHIRE_APPLE;
    public static final FoodComponent BROWN_GEM_APPLE;
    public static final FoodComponent PURPLE_GEM_APPLE;
    public static final FoodComponent RUBY_APPLE;
    public static final FoodComponent YELLOW_GEM_APPLE;
    public static final FoodComponent QUARTZ_APPLE;
    public static final FoodComponent NETHERITE_APPLE;
    public static final FoodComponent ENCHANTED_DIAMOND_APPLE;
    public static final FoodComponent ENCHANTED_IRON_APPLE;
    public static final FoodComponent ENCHANTED_EMERALD_APPLE;
    public static final FoodComponent ENCHANTED_SAPPHIRE_APPLE;
    public static final FoodComponent ENCHANTED_BROWN_GEM_APPLE;
    public static final FoodComponent ENCHANTED_PURPLE_GEM_APPLE;
    public static final FoodComponent ENCHANTED_RUBY_APPLE;
    public static final FoodComponent ENCHANTED_YELLOW_GEM_APPLE;
    public static final FoodComponent ENCHANTED_QUARTZ_APPLE;
    public static final FoodComponent ENCHANTED_NETHERITE_APPLE;



    static {
        DIAMOND_APPLE = (new FoodComponent.Builder()).hunger(6).saturationModifier(1.2F).statusEffect(new StatusEffectInstance(
                StatusEffects.REGENERATION, 200, 1), 1.0F).
                statusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION, 3600, 0), 1.0F)
        .alwaysEdible().build();
        ENCHANTED_DIAMOND_APPLE = (new FoodComponent.Builder()).hunger(6).saturationModifier(1.2F).
                statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 600, 1), 1.0F).
                statusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, 7200, 0), 1.0F).
                statusEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, 7200, 0), 1.0F).
                statusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION, 3600, 3), 1.0F)
        .alwaysEdible().build();
        IRON_APPLE = (new FoodComponent.Builder()).hunger(3).saturationModifier(1.2F).statusEffect(new StatusEffectInstance(
                StatusEffects.REGENERATION, 100, 1), 1.0F).statusEffect(new StatusEffectInstance(
                StatusEffects.ABSORPTION, 1800, 0), 1.0F)
        .alwaysEdible().build();
        ENCHANTED_IRON_APPLE = (new FoodComponent.Builder()).hunger(3).saturationModifier(1.2F).statusEffect(new StatusEffectInstance(
                StatusEffects.REGENERATION, 300, 1), 1.0F).statusEffect(new StatusEffectInstance(
                StatusEffects.RESISTANCE, 4800, 0), 1.0F).statusEffect(new StatusEffectInstance(
                StatusEffects.FIRE_RESISTANCE, 4800, 0), 1.0F).statusEffect(new StatusEffectInstance(
                StatusEffects.ABSORPTION, 1800, 3), 1.0F)
        .alwaysEdible().build();
        EMERALD_APPLE = (new FoodComponent.Builder()).hunger(6).saturationModifier(1.2F).statusEffect(new StatusEffectInstance(
                StatusEffects.REGENERATION, 200, 1), 1.0F).
                statusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION, 3600, 0), 1.0F)
                .alwaysEdible().build();
        ENCHANTED_EMERALD_APPLE = (new FoodComponent.Builder()).hunger(6).saturationModifier(1.2F).
                statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 600, 1), 1.0F).
                statusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, 7200, 0), 1.0F).
                statusEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, 7200, 0), 1.0F).
                statusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION, 3600, 3), 1.0F)
                .alwaysEdible().build();
        SAPPHIRE_APPLE = (new FoodComponent.Builder()).hunger(6).saturationModifier(1.2F).statusEffect(new StatusEffectInstance(
                StatusEffects.REGENERATION, 200, 1), 1.0F).
                statusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION, 3600, 0), 1.0F)
                .alwaysEdible().build();
        ENCHANTED_SAPPHIRE_APPLE = (new FoodComponent.Builder()).hunger(6).saturationModifier(1.2F).
                statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 600, 1), 1.0F).
                statusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, 7200, 0), 1.0F).
                statusEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, 7200, 0), 1.0F).
                statusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION, 3600, 3), 1.0F)
                .alwaysEdible().build();
        BROWN_GEM_APPLE = (new FoodComponent.Builder()).hunger(6).saturationModifier(1.2F).statusEffect(new StatusEffectInstance(
                StatusEffects.REGENERATION, 200, 1), 1.0F).
                statusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION, 3600, 0), 1.0F)
                .alwaysEdible().build();
        ENCHANTED_BROWN_GEM_APPLE = (new FoodComponent.Builder()).hunger(6).saturationModifier(1.2F).
                statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 600, 1), 1.0F).
                statusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, 7200, 0), 1.0F).
                statusEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, 7200, 0), 1.0F).
                statusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION, 3600, 3), 1.0F)
                .alwaysEdible().build();
        PURPLE_GEM_APPLE = (new FoodComponent.Builder()).hunger(6).saturationModifier(1.2F).statusEffect(new StatusEffectInstance(
                StatusEffects.REGENERATION, 200, 1), 1.0F).
                statusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION, 3600, 0), 1.0F)
                .alwaysEdible().build();
        ENCHANTED_PURPLE_GEM_APPLE = (new FoodComponent.Builder()).hunger(6).saturationModifier(1.2F).
                statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 600, 1), 1.0F).
                statusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, 7200, 0), 1.0F).
                statusEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, 7200, 0), 1.0F).
                statusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION, 3600, 3), 1.0F)
                .alwaysEdible().build();
        RUBY_APPLE = (new FoodComponent.Builder()).hunger(6).saturationModifier(1.2F).statusEffect(new StatusEffectInstance(
                StatusEffects.REGENERATION, 200, 1), 1.0F).
                statusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION, 3600, 0), 1.0F)
                .alwaysEdible().build();
        ENCHANTED_RUBY_APPLE = (new FoodComponent.Builder()).hunger(6).saturationModifier(1.2F).
                statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 600, 1), 1.0F).
                statusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, 7200, 0), 1.0F).
                statusEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, 7200, 0), 1.0F).
                statusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION, 3600, 3), 1.0F)
                .alwaysEdible().build();
        YELLOW_GEM_APPLE = (new FoodComponent.Builder()).hunger(6).saturationModifier(1.2F).statusEffect(new StatusEffectInstance(
                StatusEffects.REGENERATION, 200, 1), 1.0F).
                statusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION, 3600, 0), 1.0F)
                .alwaysEdible().build();
        ENCHANTED_YELLOW_GEM_APPLE = (new FoodComponent.Builder()).hunger(6).saturationModifier(1.2F).
                statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 600, 1), 1.0F).
                statusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, 7200, 0), 1.0F).
                statusEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, 7200, 0), 1.0F).
                statusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION, 3600, 3), 1.0F)
                .alwaysEdible().build();
        QUARTZ_APPLE = (new FoodComponent.Builder()).hunger(3).saturationModifier(1.2F).statusEffect(new StatusEffectInstance(
                StatusEffects.REGENERATION, 100, 1), 1.0F).
                statusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION, 1000, 0), 1.0F)
                .alwaysEdible().build();
        ENCHANTED_QUARTZ_APPLE = (new FoodComponent.Builder()).hunger(3).saturationModifier(1.2F).
                statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 300, 1), 1.0F).
                statusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, 4800, 0), 1.0F).
                statusEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, 4800, 0), 1.0F).
                statusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION, 1800, 3), 1.0F)
                .alwaysEdible().build();
        NETHERITE_APPLE = (new FoodComponent.Builder()).hunger(6).saturationModifier(1.2F).statusEffect(new StatusEffectInstance(
                StatusEffects.REGENERATION, 200, 1), 1.0F).
                statusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION, 3600, 0), 1.0F)
                .alwaysEdible().build();
        ENCHANTED_NETHERITE_APPLE = (new FoodComponent.Builder()).hunger(6).saturationModifier(1.2F).
                statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 600, 1), 1.0F).
                statusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, 7200, 0), 1.0F).
                statusEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, 7200, 0), 1.0F).
                statusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION, 3600, 3), 1.0F)
                .alwaysEdible().build();

    }
}
