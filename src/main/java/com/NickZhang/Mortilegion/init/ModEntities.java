package com.NickZhang.Mortilegion.init;

import com.NickZhang.Mortilegion.Mortilegion;
import com.NickZhang.Mortilegion.entity.Entity303;
import com.NickZhang.Mortilegion.entity.Herobrine;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEntities
{
    public static final DeferredRegister<EntityType<?>> ENTITIES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, Mortilegion.MOD_ID);
    public static <T extends Mob> RegistryObject<EntityType<T>> registeryEntity(
            String name, EntityType.EntityFactory<T> factory, float width, float height)
    {
        return ENTITIES.register(name, () -> EntityType.Builder.of(factory, MobCategory.MONSTER)
                .sized(width, height)
                .build(name));
    }
    public static final RegistryObject<EntityType<Herobrine>> HEROBRINE =
            registeryEntity("herobrine", Herobrine::new, 0.6f, 1.95f);
    public static final RegistryObject<EntityType<Entity303>> ENTITY303 =
            registeryEntity("entity303", Entity303::new, 0.6f, 1.95f);
    public static final RegistryObject<EntityType<Entity303>> DREADLORD =
            registeryEntity("entity303", Entity303::new, 0.6f, 1.95f);
}