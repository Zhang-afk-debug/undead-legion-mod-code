package com.NickZhang.Mortilegion.init;

import com.NickZhang.Mortilegion.Mortilegion;
import net.minecraft.world.item.Item;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems
{
    public static final DeferredRegister<Item> ITEM =
            DeferredRegister.create(ForgeRegistries.ITEMS, Mortilegion.MOD_ID);
    public static final RegistryObject<ForgeSpawnEggItem> HEROBRINE_SPAWN_EGG =
            ITEM.register("Herobrine_spawn_egg",
                    () -> new ForgeSpawnEggItem(ModEntities.HEROBRINE, 0xFFFFFF, 0x88AAFF,
                             new Item.Properties()));
}