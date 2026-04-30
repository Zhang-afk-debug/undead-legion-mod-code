package com.NickZhang.ashes_of_the_legion.client;

import com.NickZhang.ashes_of_the_legion.AshesOfTheLegionMod;
import com.NickZhang.ashes_of_the_legion.entity.Herobrine;
import net.minecraft.client.model.PlayerModel;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.client.renderer.entity.player.PlayerRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;
import org.jetbrains.annotations.NotNull;
import com.NickZhang.ashes_of_the_legion.AshesOfTheLegionMod;
import com.NickZhang.ashes_of_the_legion.entity.Herobrine; // 你的实体类路径
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.model.HumanoidModel; // 复用玩家模型
import net.minecraft.client.model.geom.ModelLayers;

public class HerobrineRenderer extends MobRenderer<Herobrine, HumanoidModel<Herobrine>> {

    private static final ResourceLocation TEXTURE =
            new ResourceLocation(AshesOfTheLegionMod.MOD_ID, "textures/entity/herobrine.png");

    public HerobrineRenderer(EntityRendererProvider.Context context)
    {
        super(context, new HumanoidModel<>(context.bakeLayer(ModelLayers.PLAYER)), 0.5f);
    }

    @Override
    public @NotNull ResourceLocation getTextureLocation(@NotNull Herobrine entity) {
        return TEXTURE;
    }
}