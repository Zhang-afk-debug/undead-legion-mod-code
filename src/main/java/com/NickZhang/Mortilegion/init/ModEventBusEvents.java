package com.NickZhang.Mortilegion.init;

import com.NickZhang.Mortilegion.client.Entity303Renderer;
import com.NickZhang.Mortilegion.client.HerobrineRenderer;
import com.NickZhang.Mortilegion.entity.Entity303;
import com.NickZhang.Mortilegion.entity.Herobrine;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.registries.RegistryObject;

import java.util.List;
import java.util.function.Supplier;

public class ModEventBusEvents
{
    @SuppressWarnings("rawtypes")
    record EntityRegistration
            (
                    RegistryObject<?> entity,
                    Supplier<AttributeSupplier.Builder> attributes,
                    EntityRendererProvider renderer
            ){}

    private static final List<EntityRegistration> ENTITIES = List.of(
            new EntityRegistration(ModEntities.HEROBRINE, Herobrine::createAttributes, HerobrineRenderer::new),
            new EntityRegistration(ModEntities.ENTITY303, Entity303::createAttributes, Entity303Renderer::new)
    );

    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event)
    {
        EntityAttributeRegistry.registerAll(event);
        for (EntityRegistration reg : ENTITIES)
        {
            // 从 record 中取出实体类型
            @SuppressWarnings("unchecked")
            EntityType<? extends Mob> type = (EntityType<? extends Mob>) reg.entity().get();
            // 调用属性构建器，生成 AttributeSupplier 并注册
            event.put(type, reg.attributes().get().build());
        }
    }

    @SubscribeEvent
    @SuppressWarnings({"rawtypes", "unchecked"})
    public static void onClientSetup(FMLClientSetupEvent event)
    {
        event.enqueueWork(() -> {
            for (EntityRegistration reg : ENTITIES)
            {
                // 注册渲染器
                EntityRenderers.register((EntityType)reg.entity().get(), reg.renderer());
            }
        });
    }
}