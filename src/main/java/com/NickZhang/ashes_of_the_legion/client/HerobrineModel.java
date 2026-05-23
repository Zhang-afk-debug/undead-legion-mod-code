package com.NickZhang.ashes_of_the_legion.client;

import com.NickZhang.ashes_of_the_legion.Mortilegion;
import com.NickZhang.ashes_of_the_legion.entity.Herobrine;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class HerobrineModel extends GeoModel<Herobrine>
{
    @Override
    public ResourceLocation getModelResource(Herobrine object)
    {
        return new ResourceLocation(Mortilegion.MOD_ID, "geo/herobrine.geo.json");
    }
    @Override
    public ResourceLocation getTextureResource(Herobrine object)
    {
        return new ResourceLocation(Mortilegion.MOD_ID, "textures/entity/herobrine.png");
    }
    @Override
    public ResourceLocation getAnimationResource(Herobrine object)
    {
        return new ResourceLocation(Mortilegion.MOD_ID, "animations/herobrine_walk.animation.json");
    }
}