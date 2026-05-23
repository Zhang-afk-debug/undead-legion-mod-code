package com.NickZhang.ashes_of_the_legion.client;

import com.NickZhang.ashes_of_the_legion.entity.Herobrine;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class HerobrineRenderer extends GeoEntityRenderer<Herobrine>
{
    public HerobrineRenderer(EntityRendererProvider.Context context)
    {
        super(context, new HerobrineModel());
    }
}