package com.NickZhang.Mortilegion.init;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class EntityAttributeRegistry
{
    private static final Map<Supplier<EntityType<? extends LivingEntity>>, Supplier<AttributeSupplier.Builder>> ATTRIBUTES =
            new HashMap<>();
    public static void register(Supplier<EntityType<? extends LivingEntity>> entityType,
                                Supplier<AttributeSupplier.Builder> attributes)
    {
        ATTRIBUTES.put(entityType, attributes);
    }
    public static void registerAll(EntityAttributeCreationEvent event)
    {
        for(Map.Entry<Supplier<EntityType<? extends LivingEntity>>, Supplier<AttributeSupplier.Builder>> entry : ATTRIBUTES.entrySet())
        {
            EntityType<? extends LivingEntity> type = entry.getKey().get();
            AttributeSupplier supplier = entry.getValue().get().build();
            event.put(type, supplier);
        }
    }
}
