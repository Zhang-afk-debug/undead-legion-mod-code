package com.NickZhang.Mortilegion.entity;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.level.Level;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.core.animation.*;

public class DreadLord extends UndeadLegion implements GeoEntity
{
    public static AttributeSupplier.Builder createAttributes()
    {
        return BaseEntity.createAttribute(900.0, 56.0, 18.0,
                18.0, 0.9, 3.8, 85.0, 2.5);
    }

    public DreadLord(EntityType<Herobrine> type, Level level)
    {
        super(type, level, 900.0, 56.0, 18.0,
                18.0, 0.9, 3.8, 85.0, 2.5);

    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllers)
    {
        controllers.add(new AnimationController<>(this, "idle_controller", 0, event ->
                event.setAndContinue(RawAnimation.begin().thenLoop("idle"))));
    }
}
