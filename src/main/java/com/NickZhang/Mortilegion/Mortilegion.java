package com.NickZhang.Mortilegion;

import com.NickZhang.Mortilegion.client.HerobrineRenderer;
import com.NickZhang.Mortilegion.entity.BaseEntity;
import com.NickZhang.Mortilegion.entity.Herobrine;
import com.NickZhang.Mortilegion.init.ModEntities;
import com.mojang.logging.LogUtils;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;
import net.minecraft.client.renderer.entity.EntityRenderers;

@Mod(Mortilegion.MOD_ID)
public class Mortilegion
{
    public static final String MOD_ID = "mortilegion";
    private static final Logger LOGGER = LogUtils.getLogger();

    public Mortilegion(FMLJavaModLoadingContext context)
    {
        MinecraftForge.EVENT_BUS.register(this);
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        ModEntities.ENTITIES.register(modEventBus);
    }
}