package com.mrshiehx.mcmods.moregemstoolsarmor.item.tool;

import net.fabricmc.fabric.api.tag.TagRegistry;
import net.minecraft.item.Item;
import net.minecraft.tag.Tag;
import net.minecraft.util.Identifier;

public class MGTAToolTags {
    public static final Tag<Item> PICKAXES = register("pickaxes");

    private MGTAToolTags() { }
    private static Tag<Item> register(String id) {
        return TagRegistry.item(new Identifier("moregemstoolsarmor", id));
    }
}
