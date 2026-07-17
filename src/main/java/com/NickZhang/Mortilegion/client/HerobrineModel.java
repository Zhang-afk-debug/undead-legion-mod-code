package com.NickZhang.Mortilegion.client;

import com.NickZhang.Mortilegion.entity.Herobrine;

public class HerobrineModel extends EntityModel<Herobrine>
{
    public HerobrineModel()
    {
        super("geo/herobrine.geo.json",
                "textures/entity/herobrine.png",
                "animations/herobrine_walk.animation.json");
    }
}