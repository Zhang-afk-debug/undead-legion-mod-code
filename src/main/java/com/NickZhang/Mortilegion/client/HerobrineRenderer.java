package com.NickZhang.Mortilegion.client;

import com.NickZhang.Mortilegion.entity.Herobrine;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class HerobrineRenderer extends GeoEntityRenderer<Herobrine>
{
    public HerobrineRenderer(EntityRendererProvider.Context context)
    {
        super(context, new HerobrineModel());
    }
}