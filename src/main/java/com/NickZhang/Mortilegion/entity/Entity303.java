package com.NickZhang.Mortilegion.entity;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.core.animation.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;

public class Entity303 extends UndeadLegion implements GeoEntity
{
    public static AttributeSupplier.Builder createAttributes()
    {
        return BaseEntity.createAttribute(400.0, 50.0, 3.0, 0.0, 0.8,
                5.0, 10.0, 1.0);
    }

    public Entity303(EntityType<Entity303> type, Level level)
    {
        super(type, level, 400.0, 50.0, 3.0, 0.0 ,0.8,
                5.0, 10.0, 1.0);

    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllers)
    {
        controllers.add(new AnimationController<>(this, "idle_controller", 0, event ->
                event.setAndContinue(RawAnimation.begin().thenLoop("entity303_walk"))));
    }
}