package com.NickZhang.Mortilegion.entity;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.level.Level;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.util.GeckoLibUtil;

public abstract class BaseEntity extends PathfinderMob implements GeoEntity
{
    private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);

    protected BaseEntity(EntityType<? extends PathfinderMob> type, Level level,
        double health, double followRange, double armor, double armorToughness,
                         double knockBackResistance, double attackSpeed, double attackDamage, double attackKnockBack,
                         double movementSpeed)
    {
        super(type, level);
    }

    public BaseEntity(EntityType<? extends PathfinderMob> type, Level level)
    {
        super(type, level);
    }

    public static AttributeSupplier.Builder createAttribute(
            double health, double followRange, double armor, double armorToughness,
            double knockbackResistance, double attackSpeed, double attackDamage, double attackKnockBack, double movementSpeed
    )
    {
        return Mob.createMobAttributes()
                .add(Attributes.MAX_HEALTH, health)
                .add(Attributes.FOLLOW_RANGE, followRange)
                .add(Attributes.ARMOR, armor)
                .add(Attributes.ARMOR_TOUGHNESS, armorToughness)
                .add(Attributes.KNOCKBACK_RESISTANCE, knockbackResistance)
                .add(Attributes.ATTACK_SPEED, attackSpeed)
                .add(Attributes.ATTACK_DAMAGE, attackDamage)
                .add(Attributes.ATTACK_KNOCKBACK, attackKnockBack)
                .add(Attributes.MOVEMENT_SPEED, movementSpeed);
    }
    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache()
    {
        return cache;
    }
}
