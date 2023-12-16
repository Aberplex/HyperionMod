package net.aredd.hyperionmod.entity;

import net.aredd.hyperionmod.HyperionMod;
import net.aredd.hyperionmod.entity.custom.HyperionSpiritEntity;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModEntities {
    public static final EntityType<HyperionSpiritEntity> HYPERION_SPIRIT = Registry.register(Registries.ENTITY_TYPE,
            new Identifier(HyperionMod.MOD_ID, "hyperion_spirit"),
            FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, HyperionSpiritEntity::new)
                    .dimensions(EntityDimensions.fixed(1f, 2f)).build());
}