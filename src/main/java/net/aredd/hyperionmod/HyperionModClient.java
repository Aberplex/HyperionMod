package net.aredd.hyperionmod;

import net.aredd.hyperionmod.block.ModBlocks;
import net.aredd.hyperionmod.entity.ModEntities;
import net.aredd.hyperionmod.entity.client.HyperionSpiritModel;
import net.aredd.hyperionmod.entity.client.HyperionSpiritRenderer;
import net.aredd.hyperionmod.entity.client.ModModelLayers;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.render.RenderLayer;

public class HyperionModClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.HYPER_BERRY_BUSH, RenderLayer.getCutout());

        EntityModelLayerRegistry.registerModelLayer(ModModelLayers.HYPERION_SPIRIT, HyperionSpiritModel::getTexturedModelData);
        EntityRendererRegistry.register(ModEntities.HYPERION_SPIRIT, HyperionSpiritRenderer::new);
    }
}
