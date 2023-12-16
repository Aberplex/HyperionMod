package net.aredd.hyperionmod.entity.client;

import net.aredd.hyperionmod.HyperionMod;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.util.Identifier;

public class ModModelLayers {
    public static final EntityModelLayer HYPERION_SPIRIT =
            new EntityModelLayer(new Identifier(HyperionMod.MOD_ID, "hyperion_spirit"), "main");
}
