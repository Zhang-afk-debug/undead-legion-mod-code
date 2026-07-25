package com.NickZhang.Mortilegion.entity;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.Level;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.core.animation.*;

public class Entity303 extends UndeadLegion implements GeoEntity
{
    public Entity303(EntityType<? extends Monster> type, Level level)
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