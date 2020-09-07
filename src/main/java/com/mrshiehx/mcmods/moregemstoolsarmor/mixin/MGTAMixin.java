package com.mrshiehx.mcmods.moregemstoolsarmor.mixin;

import com.mrshiehx.mcmods.moregemstoolsarmor.MoreGemsToolsArmor;
import net.minecraft.world.biome.GenerationSettings;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.DefaultBiomeFeatures;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(DefaultBiomeFeatures.class)
public class MGTAMixin {
	@Inject(method = "addDefaultOres(Lnet/minecraft/world/biome/GenerationSettings$Builder;)V", at = @At("TAIL"))
	private static void addDefaultOres(GenerationSettings.Builder builder, CallbackInfo ci) {
		builder.feature(GenerationStep.Feature.UNDERGROUND_ORES, MoreGemsToolsArmor.ORE_BROWN_GEM_ORE);
		builder.feature(GenerationStep.Feature.UNDERGROUND_ORES, MoreGemsToolsArmor.ORE_PURPLE_GEM_ORE);
		builder.feature(GenerationStep.Feature.UNDERGROUND_ORES, MoreGemsToolsArmor.ORE_SAPPHIRE_ORE);
		builder.feature(GenerationStep.Feature.UNDERGROUND_ORES, MoreGemsToolsArmor.ORE_RUBY_ORE);
		builder.feature(GenerationStep.Feature.UNDERGROUND_ORES, MoreGemsToolsArmor.ORE_YELLOW_GEM_ORE);
		builder.feature(GenerationStep.Feature.UNDERGROUND_ORES, MoreGemsToolsArmor.ORE_STONE_OF_EXPERIENCE);
	}
}