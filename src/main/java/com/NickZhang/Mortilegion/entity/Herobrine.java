package com.NickZhang.Mortilegion.entity;

import com.NickZhang.Mortilegion.entity.ai.HerobrineBrainConfig;
import com.NickZhang.Mortilegion.entity.animations.HerobrineAnimationsManager;
import com.mojang.serialization.Dynamic;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.NbtOps;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.Brain;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.navigation.GroundPathNavigation;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.tslat.smartbrainlib.api.SmartBrainOwner;
import net.tslat.smartbrainlib.api.core.BrainActivityGroup;
import net.tslat.smartbrainlib.api.core.SmartBrainProvider;
import net.tslat.smartbrainlib.api.core.sensor.ExtendedSensor;

import org.jetbrains.annotations.NotNull;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.core.animation.*;

import javax.annotation.Nonnull;
import java.util.List;

public class Herobrine extends UndeadLegion implements GeoEntity, SmartBrainOwner<Herobrine>
{
    private Brain<Herobrine> brain;

    public static AttributeSupplier.Builder createAttributes()
    {
        return BaseEntity.createAttribute(1200.0, 64.0, 20.0,
                20.0, 1.0, 4.0, 100.0, 3.0, 0.3);
    }

    public Herobrine(EntityType<Herobrine> type, Level level)
    {
        super(type, level, 1200.0, 64.0, 20.0,
                20.0, 1.0, 4.0, 100.0, 3.0, 0.2);
        this.setNoAi(false);

        if (this.navigation instanceof GroundPathNavigation)
        {
            this.navigation.setCanFloat(true);
        }
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllers)
    {
        controllers.add(HerobrineAnimationsManager.createIdleControl(this));
    }

    @Override
    protected Brain.@NotNull Provider<?> brainProvider()
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

    @Override
    public @NotNull Brain<Herobrine> getBrain()
    {
        return this.brain;
    }


    @Override
    public void tick()
    {
        super.tick();
        if (this.isInWaterOrBubble())
        {
            this.setAirSupply(this.getMaxAirSupply());
        }
        if (!this.level().isClientSide())
        {
            if (this.brain == null)
            {
                this.brain = (Brain<Herobrine>) this.brainProvider().makeBrain(new Dynamic<>(NbtOps.INSTANCE,
                        new CompoundTag()));
            }
            this.brain.tick((ServerLevel) this.level(), this);
        }
        Player nearestPlayer = this.level().getNearestPlayer(this, 50.0);
        if (nearestPlayer != null && !nearestPlayer.isCreative() && !nearestPlayer.isSpectator())
        {
            this.setTarget(nearestPlayer);
        }
        LivingEntity target = this.getTarget();
        if (target != null && target.isAlive()) {
            if (this.distanceToSqr(target) > 4.0) {
                this.getNavigation().moveTo(target, 1.0);
            } else {
                this.doHurtTarget(target);
            }
        }
    }
}
