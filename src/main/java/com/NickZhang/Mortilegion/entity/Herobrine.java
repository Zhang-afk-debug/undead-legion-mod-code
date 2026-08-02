package com.NickZhang.Mortilegion.entity;

import com.NickZhang.Mortilegion.entity.ai.HerobrineBrainConfig;
import com.NickZhang.Mortilegion.entity.animations.HerobrineAnimationsManager;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.Brain;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.level.Level;
import net.tslat.smartbrainlib.api.SmartBrainOwner;
import net.tslat.smartbrainlib.api.core.BrainActivityGroup;
import net.tslat.smartbrainlib.api.core.SmartBrainProvider;
import net.tslat.smartbrainlib.api.core.sensor.ExtendedSensor;

import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.core.animation.*;

import javax.annotation.Nonnull;
import java.util.List;

public class Herobrine extends UndeadLegion implements GeoEntity, SmartBrainOwner<Herobrine>
{
    public static AttributeSupplier.Builder createAttributes()
    {
        return BaseEntity.createAttribute(1200.0, 64.0, 20.0,
                20.0, 1.0, 4.0, 100.0, 3.0);
    }

    public Herobrine(EntityType<Herobrine> type, Level level)
    {
        super(type, level, 1200.0, 64.0, 20.0,
                20.0, 1.0, 4.0, 100.0, 3.0);

    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllers)
    {
        controllers.add(HerobrineAnimationsManager.createIdleControl(this));
    }

    @Override
    protected Brain.Provider<?> brainProvider()
    {
        return new SmartBrainProvider<>(this);
    }
    @Override
    @Nonnull
    public List<ExtendedSensor<Herobrine>> getSensors() {
        return HerobrineBrainConfig.sensors();
    }

    @Override
    @Nonnull
    public BrainActivityGroup<Herobrine> getCoreTasks() {
        return HerobrineBrainConfig.coreTasks();
    }

    @Override
    @Nonnull
    public BrainActivityGroup<Herobrine> getIdleTasks() {
        return HerobrineBrainConfig.idleTasks();
    }

    @Override
    @Nonnull
    public BrainActivityGroup<Herobrine> getFightTasks() {
        return HerobrineBrainConfig.fightTasks();
    }
}
