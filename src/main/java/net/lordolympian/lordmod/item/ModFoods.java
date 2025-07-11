package net.lordolympian.lordmod.item;


import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;


public class ModFoods {
    public static final FoodProperties HEMOGLOBIN = new FoodProperties.Builder().nutrition(4)
            .saturationMod(0.9f).effect(() -> new MobEffectInstance(MobEffects.GLOWING, 2400), 1)
            .effect(() -> new MobEffectInstance(MobEffects.HEALTH_BOOST, 2400), 1).build();
}
