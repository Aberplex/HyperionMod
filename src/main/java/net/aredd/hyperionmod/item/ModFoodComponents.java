package net.aredd.hyperionmod.item;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.FoodComponent;

public class ModFoodComponents {
    public static final FoodComponent HYPER_BERRY = new FoodComponent.Builder().hunger(8).saturationModifier(1.5f).
            statusEffect(new StatusEffectInstance(StatusEffects.SPEED, 3600, 1), 1f).
            statusEffect(new StatusEffectInstance(StatusEffects.HASTE, 3600, 0), 1f).build();
}
