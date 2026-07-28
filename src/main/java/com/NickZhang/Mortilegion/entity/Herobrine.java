package com.NickZhang.Mortilegion.entity;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.level.Level;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.core.animation.*;

public class Herobrine extends UndeadLegion implements GeoEntity
{
    public static AttributeSupplier.Builder createAttributes()
    {
        return BaseEntity.createAttribute(1200.0, 50.0, 20.0,
                0.0, 1.0, 1.0, 20.0, 1.0);
    }

    public Herobrine(EntityType<Herobrine> type, Level level)
    {
        super(type, level, 1200.0, 50.0, 20.0, 0.0,
                1.0, 1.0, 20.0, 1.0);

    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllers)
    {
        controllers.add(new AnimationController<>(this, "idle_controller", 0, event ->
                event.setAndContinue(RawAnimation.begin().thenLoop("walk"))));
    }
}
