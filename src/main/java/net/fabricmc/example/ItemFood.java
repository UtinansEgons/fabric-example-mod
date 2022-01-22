package net.fabricmc.example;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.FoodComponent;

public class ItemFood {
    public static final FoodComponent ASTOLFO_FACE = (new FoodComponent.Builder()).hunger(-30).alwaysEdible().statusEffect(new StatusEffectInstance(StatusEffects.POISON, 6000, 5), 1.0F).statusEffect(new StatusEffectInstance(StatusEffects.NAUSEA, 6000, 5), 1.0F).statusEffect(new StatusEffectInstance(StatusEffects.BLINDNESS, 6000, 5), 1.0F).statusEffect(new StatusEffectInstance(StatusEffects.WITHER, 6000, 5), 1.0F).statusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, 6000, 5), 1.0F).snack().build();

    public static final FoodComponent GOLDEN_ASTOLFO_FACE = (new FoodComponent.Builder()).hunger(+30).alwaysEdible().statusEffect(new StatusEffectInstance(StatusEffects.SATURATION, 99999, 9), 1.0F).statusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION, 99999, 9), 1.0F).statusEffect(new StatusEffectInstance(StatusEffects.HEALTH_BOOST, 99999, 10000), 1.0F).statusEffect(new StatusEffectInstance(StatusEffects.STRENGTH, 99999, 9), 1.0F).statusEffect(new StatusEffectInstance(StatusEffects.SPEED, 99999, 9), 1.0F).statusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, 99999, 9), 1.0F).statusEffect(new StatusEffectInstance(StatusEffects.NIGHT_VISION, 99999, 9), 1.0F).statusEffect(new StatusEffectInstance(StatusEffects.LUCK, 99999, 9), 1.0F).statusEffect(new StatusEffectInstance(StatusEffects.HASTE, 99999, 9), 1.0F).statusEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, 6000, 9), 1.0F).statusEffect(new StatusEffectInstance(StatusEffects.WATER_BREATHING, 99999, 9), 1.0F).snack().build();
}
