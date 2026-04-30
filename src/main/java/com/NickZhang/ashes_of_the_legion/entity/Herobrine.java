package com.NickZhang.ashes_of_the_legion.entity;

import com.NickZhang.ashes_of_the_legion.entity.UndeadLegion;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.ai.attributes.Attributes;

public class Herobrine extends UndeadLegion
{
    public Herobrine(EntityType<? extends Monster> type, Level level)
    {
        super(type, level);
    }
    public static AttributeSupplier.Builder createAttributes() {
        return Mob.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 1000.0)
                .add(Attributes.FOLLOW_RANGE, 50.0)
                .add(Attributes.ARMOR, 8.0)
                .add(Attributes.ARMOR_TOUGHNESS, 3.0)
                .add(Attributes.KNOCKBACK_RESISTANCE, 7.5)
                .add(Attributes.ATTACK_SPEED, 2.5)
                .add(Attributes.ATTACK_DAMAGE, 20.0)
                .add(Attributes.ATTACK_KNOCKBACK, 2.5);
    }
}
