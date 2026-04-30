package com.NickZhang.ashes_of_the_legion.entity;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.level.Level;

import java.lang.reflect.Type;

public class UndeadLegion extends Monster
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
    public UndeadLegion(EntityType<? extends Monster> type, Level level)
    {
        super(type, level);
    }
}