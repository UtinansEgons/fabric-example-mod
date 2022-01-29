package net.fabricmc.example.tools;

import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.world.World;

public class AstolfoToolMaterial implements ToolMaterial {

    public static final AstolfoToolMaterial INSTANCE = new AstolfoToolMaterial();


    @Override
    public int getDurability() {
        return 50000000;
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return 1000.0f;
    }

    @Override
    public float getAttackDamage() {
        return 100000000.0f;
    }

    @Override
    public int getMiningLevel() {
        return 10000;
    }

    @Override
    public int getEnchantability() {
        return 100;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.ofItems(Items.END_CRYSTAL);
    }


}
