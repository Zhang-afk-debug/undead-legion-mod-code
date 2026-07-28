package com.NickZhang.Mortilegion.client;

import com.NickZhang.Mortilegion.entity.Entity303;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class Entity303Renderer extends GeoEntityRenderer<Entity303>
{
    public Entity303Renderer(EntityRendererProvider.Context context)
    {
        super(context, new Entity303Model());
    }
}
