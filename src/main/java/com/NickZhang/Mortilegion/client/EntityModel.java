package com.NickZhang.Mortilegion.client;

import com.NickZhang.Mortilegion.Mortilegion;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.core.animatable.GeoAnimatable;

public abstract class EntityModel<T extends GeoAnimatable> extends GeoModel<T>
{
    private final ResourceLocation modelLocation;
    private final ResourceLocation texturesLocation;
    private final ResourceLocation animationLocation;

    public EntityModel(String modelPath, String texturePath, String animationPath)
    {
        this.modelLocation = new ResourceLocation(Mortilegion.MOD_ID, modelPath);
        this.texturesLocation = new ResourceLocation(Mortilegion.MOD_ID, texturePath);
        this.animationLocation = new ResourceLocation(Mortilegion.MOD_ID, animationPath);
    }

    @Override
    public ResourceLocation getModelResource(T object)
    {
        return modelLocation;
    }

    @Override
    public ResourceLocation getTextureResource(T object)
    {
        return texturesLocation;
    }

    @Override
    public ResourceLocation getAnimationResource(T object)
    {
        return animationLocation;
    }
}
