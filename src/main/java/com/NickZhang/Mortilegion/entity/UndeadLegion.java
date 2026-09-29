package com.NickZhang.Mortilegion.entity;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.PathfinderMob;
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
    public UndeadLegion(EntityType<? extends PathfinderMob> type, Level level)
    {
        super(type, level);
    }
}