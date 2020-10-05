package com.mrshiehx.mcmods.moregemstoolsarmor.recipe;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.mrshiehx.mcmods.moregemstoolsarmor.MGTAVariables;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.util.Identifier;
import net.minecraft.util.JsonHelper;
import net.minecraft.util.registry.Registry;


//读取json的内容
public class UpgradingRecipeSerializer<T extends AbstractUpgradingRecipe> implements RecipeSerializer<T> {
    //private final int upgradingTime;
    private final UpgradingRecipeSerializer.RecipeFactory<T> recipeFactory;

    public UpgradingRecipeSerializer(UpgradingRecipeSerializer.RecipeFactory<T> recipeFactory, int upgradingTime) {
        //this.upgradingTime = upgradingTime;
        this.recipeFactory = recipeFactory;
    }

    public T read(Identifier identifier, JsonObject jsonObject) {
        String string = JsonHelper.getString(jsonObject, "group", "");
        JsonElement jsonElement = JsonHelper.hasArray(jsonObject, "ingredient") ? JsonHelper.getArray(jsonObject, "ingredient") : JsonHelper.getObject(jsonObject, "ingredient");
        Ingredient ingredient = Ingredient.fromJson((JsonElement) jsonElement);
        String string2 = JsonHelper.getString(jsonObject, "result");
        Identifier identifier2 = new Identifier(string2);
        ItemStack itemStack = new ItemStack((ItemConvertible) Registry.ITEM.getOrEmpty(identifier2).orElseThrow(() -> {
            return new IllegalStateException("Item: " + string2 + " does not exist");
        }));
        float f = JsonHelper.getFloat(jsonObject, "experience", 0.0F);
        //int i = JsonHelper.getInt(jsonObject, "upgradingTime", this.upgradingTime);
        return this.recipeFactory.create(identifier, string, ingredient, itemStack, f, MGTAVariables.itemUpgradeTableUpgradingTime);
    }

    public T read(Identifier identifier, PacketByteBuf packetByteBuf) {
        String string = packetByteBuf.readString(32767);
        Ingredient ingredient = Ingredient.fromPacket(packetByteBuf);
        ItemStack itemStack = packetByteBuf.readItemStack();
        float f = packetByteBuf.readFloat();
        int i = packetByteBuf.readVarInt();
        return this.recipeFactory.create(identifier, string, ingredient, itemStack, f, i);
    }

    public void write(PacketByteBuf packetByteBuf, T abstractUpgradingRecipe) {
        packetByteBuf.writeString(abstractUpgradingRecipe.group);
        abstractUpgradingRecipe.input.write(packetByteBuf);
        packetByteBuf.writeItemStack(abstractUpgradingRecipe.output);
        packetByteBuf.writeFloat(abstractUpgradingRecipe.experience);
        packetByteBuf.writeVarInt(abstractUpgradingRecipe.upgradeTime);
    }

    public interface RecipeFactory<T extends AbstractUpgradingRecipe> {
        T create(Identifier id, String group, Ingredient input, ItemStack output, float experience, int upgradeTime);
    }
}
