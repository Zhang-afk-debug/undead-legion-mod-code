package com.NickZhang.Mortilegion.entity;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.level.Level;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.core.animation.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;

public class Entity303 extends UndeadLegion implements GeoEntity
{
    public static AttributeSupplier.Builder createAttributes()
    {
        return Mob.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 400.0)
                .add(Attributes.FOLLOW_RANGE, 50.0)
                .add(Attributes.ARMOR, 3.0)
                .add(Attributes.ARMOR_TOUGHNESS, 0.0)
                .add(Attributes.KNOCKBACK_RESISTANCE, 0.8)
                .add(Attributes.ATTACK_SPEED, 5.0)
                .add(Attributes.ATTACK_DAMAGE, 10.0)
                .add(Attributes.ATTACK_KNOCKBACK, 1.0)
                .add(Attributes.MOVEMENT_SPEED, 0.3);
    }

    public Entity303(EntityType<Entity303> type, Level level)
    {
        super(type, level);

    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllers)
    {
        controllers.add(new AnimationController<>(this, "idle_controller", 0, event ->
                event.setAndContinue(RawAnimation.begin().thenLoop("entity303_walk"))));
    }
}