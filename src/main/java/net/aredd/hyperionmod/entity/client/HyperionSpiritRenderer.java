package net.aredd.hyperionmod.entity.client;

import net.aredd.hyperionmod.HyperionMod;
import net.aredd.hyperionmod.entity.custom.HyperionSpiritEntity;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

public class HyperionSpiritRenderer extends MobEntityRenderer<HyperionSpiritEntity, HyperionSpiritModel<HyperionSpiritEntity>> {
    private static final Identifier TEXTURE = new Identifier(HyperionMod.MOD_ID, "textures/entity/hyperion_spirit.png");

    public HyperionSpiritRenderer(EntityRendererFactory.Context context) {
        super(context, new HyperionSpiritModel<>(context.getPart(ModModelLayers.HYPERION_SPIRIT)), 0.6f);
    }

    @Override
    public Identifier getTexture(HyperionSpiritEntity entity) {
        return TEXTURE;
    }

    @Override
    public void render(HyperionSpiritEntity mobEntity, float f, float g, MatrixStack matrixStack,
                       VertexConsumerProvider vertexConsumerProvider, int i) {
        super.render(mobEntity, f, g, matrixStack, vertexConsumerProvider, i);
    }
}
