package com.mrshiehx.mcmods.moregemstoolsarmor.client;

import com.mrshiehx.mcmods.moregemstoolsarmor.MoreGemsToolsArmor;
import com.mrshiehx.mcmods.moregemstoolsarmor.screen.ItemUpgradeTableScreen;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.screenhandler.v1.ScreenRegistry;

public class MGTAClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        ScreenRegistry.register(MoreGemsToolsArmor.itemUpgradeTableScreenHandler, ItemUpgradeTableScreen::new);
    }
}