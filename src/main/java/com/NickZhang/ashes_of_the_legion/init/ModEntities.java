package com.NickZhang.ashes_of_the_legion.init;

import com.NickZhang.ashes_of_the_legion.Mortilegion;
import com.NickZhang.ashes_of_the_legion.entity.Herobrine;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEntities
{
    public static final DeferredRegister<EntityType<?>> ENTITIES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, Mortilegion.MOD_ID);
    public static final RegistryObject<EntityType<Herobrine>> HEROBRINE =
            ENTITIES.register("herobrine",() -> EntityType.Builder.of(Herobrine::new, MobCategory.MONSTER)
                    .sized(0.6f, 1.95f)
                    .build("Herobrine"));
}