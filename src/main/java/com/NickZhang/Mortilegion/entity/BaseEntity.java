package com.NickZhang.Mortilegion.entity;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.animal.TropicalFish;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.Level;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.core.animatable.GeoAnimatable;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animation.*;
import software.bernie.geckolib.util.GeckoLibUtil;

public abstract class BaseEntity extends Mob implements GeoEntity
{
    private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);

    protected BaseEntity(EntityType<? extends Mob> type, Level level,
        double health, double followRange, double armor, double armorToughness,
                         double knockBackResistance, double attackSpeed, double attackDamage, double attackKnockBack)
    {
        super(type, level);
    }

    public BaseEntity(EntityType<? extends Monster> type, Level level)
    {
        super(type, level);
    }

    public static AttributeSupplier.Builder createAttribute(
            double health, double followRange, double armor, double armorToughness,
            double knockbackResistance, double attackSpeed, double attackDamage, double attackKnockBack
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
                .add(Attributes.ATTACK_KNOCKBACK, attackKnockBack);
    }
    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache()
    {
        return cache;
    }
}
