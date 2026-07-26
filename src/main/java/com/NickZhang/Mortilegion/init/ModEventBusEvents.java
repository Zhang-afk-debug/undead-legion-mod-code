package com.NickZhang.Mortilegion.init;

import com.NickZhang.Mortilegion.client.HerobrineRenderer;
import com.NickZhang.Mortilegion.entity.Herobrine;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

public class ModEventBusEvents
{
    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event) {
        EntityAttributeRegistry.registerAll(event);
        // 直接调用注册，不使用 Map，避免空 Map 问题
        event.put(ModEntities.HEROBRINE.get(), Herobrine.createAttributes().build());
    }
    @SubscribeEvent
    public static void onClientSetup(FMLClientSetupEvent event)
    {
        event.enqueueWork(() -> {
            EntityRenderers.register(ModEntities.HEROBRINE.get(), HerobrineRenderer::new);
        });
    }
}
