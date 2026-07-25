package com.NickZhang.Mortilegion.entity;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.level.Level;

public abstract class UndeadLegion extends BaseEntity
{
    //初始化通用属性
    protected final int legionLevel = 5;
    protected boolean beAllyToPlayer = false;
    protected String faction = "undead_legion";
    protected boolean immuneToWither = true;

    //返回不死军团等级
    public int getLegionLevel()
    {
        return legionLevel;
    }
    public UndeadLegion(EntityType<? extends Mob> type, Level level, double health, double followRange,
                        double armor, double armorToughness, double knockbackResistance,
                        double attackSpeed, double attackDamage, double attackKnockback)
    {
        super(type, level, health, followRange, armor, armorToughness,
                knockbackResistance, attackSpeed, attackDamage, attackKnockback);
    }
}