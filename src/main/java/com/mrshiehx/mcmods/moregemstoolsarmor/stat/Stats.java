package com.mrshiehx.mcmods.moregemstoolsarmor.stat;

import net.minecraft.stat.StatFormatter;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class Stats {
    public static final Identifier INTERACT_WITH_ITEM_UPGRADE_TABLE;

    private static Identifier register(String string, StatFormatter statFormatter) {
        Identifier identifier = new Identifier(string);
        Registry.register(Registry.CUSTOM_STAT, string, identifier);
        net.minecraft.stat.Stats.CUSTOM.getOrCreateStat(identifier, statFormatter);
        return identifier;
    }

    static {

        INTERACT_WITH_ITEM_UPGRADE_TABLE = register("interact_with_item_upgrade_table", StatFormatter.DEFAULT);
    }
}
