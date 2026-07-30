package com.NickZhang.Mortilegion.client;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import software.bernie.geckolib.renderer.GeoEntityRenderer;
import com.NickZhang.Mortilegion.entity.DreadLord;

public class DreadLordRenderer extends GeoEntityRenderer<DreadLord>
{
    public DreadLordRenderer(EntityRendererProvider.Context context)
    {
        super(context, new DreadlordModel());
    }
}
