package net.aredd.hyperionmod.entity.client;

import net.aredd.hyperionmod.entity.animation.ModAnimations;
import net.aredd.hyperionmod.entity.custom.HyperionSpiritEntity;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.MathHelper;

public class HyperionSpiritModel<T extends HyperionSpiritEntity> extends SinglePartEntityModel<T> {

	private final ModelPart hyperion_spirit;
	private final ModelPart head;

	public HyperionSpiritModel(ModelPart root) {
		this.hyperion_spirit = root.getChild("hyperion_spirit");
		this.head = hyperion_spirit.getChild("head");
	}

	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();
		ModelPartData hyperion_spirit = modelPartData.addChild("hyperion_spirit", ModelPartBuilder.create(), ModelTransform.of(0.0F, 24.0F, 0.0F, 0.0F, 3.1416F, 0.0F));

		ModelPartData head = hyperion_spirit.addChild("head", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -24.0F, 0.0F));

		ModelPartData wear = head.addChild("wear", ModelPartBuilder.create().uv(0, 22).cuboid(-4.0F, -32.0F, -4.0F, 8.0F, 8.0F, 8.0F, new Dilation(0.5F)), ModelTransform.pivot(0.0F, 24.0F, 0.0F));

		ModelPartData hood = head.addChild("hood", ModelPartBuilder.create().uv(0, 11).cuboid(-4.5F, -33.0F, -5.0F, 9.0F, 1.0F, 10.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 24.0F, 0.0F));

		ModelPartData cube_r1 = hood.addChild("cube_r1", ModelPartBuilder.create().uv(26, 24).cuboid(-10.5F, 10.0F, -4.0F, 10.5F, 1.0F, 4.0F, new Dilation(0.0F))
				.uv(28, 34).cuboid(-10.5F, 1.0F, -4.0F, 10.5F, 1.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(-6.0F, -33.0F, -5.0F, -1.5708F, 1.5708F, 3.1416F));

		ModelPartData cube_r2 = hood.addChild("cube_r2", ModelPartBuilder.create().uv(26, 41).cuboid(-4.5F, 9.5F, -4.0F, 9.0F, 1.0F, 4.0F, new Dilation(0.0F))
				.uv(1, 1).cuboid(-4.5F, 0.0F, -10.0F, 9.0F, 1.0F, 9.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -33.0F, -5.0F, 1.5708F, 0.0F, 0.0F));

		ModelPartData body = hyperion_spirit.addChild("body", ModelPartBuilder.create().uv(0, 38).cuboid(-4.0F, -15.0F, -2.0F, 8.0F, 12.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -9.0F, 0.0F));

		ModelPartData left_leg = hyperion_spirit.addChild("left_leg", ModelPartBuilder.create(), ModelTransform.pivot(1.9F, -12.0F, 0.0F));

		ModelPartData left_leg_1 = left_leg.addChild("left_leg_1", ModelPartBuilder.create().uv(0, 54).cuboid(0.0F, -12.0F, -2.0F, 4.0F, 9.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(-1.9F, 12.0F, 0.0F));

		ModelPartData left_leg_2 = left_leg.addChild("left_leg_2", ModelPartBuilder.create().uv(54, 39).cuboid(0.0F, -8.0F, -5.0F, 4.0F, 6.0F, 3.0F, new Dilation(0.0F)), ModelTransform.pivot(-1.9F, 12.0F, 0.0F));

		ModelPartData right_leg = hyperion_spirit.addChild("right_leg", ModelPartBuilder.create(), ModelTransform.pivot(-1.9F, -12.0F, 0.0F));

		ModelPartData right_leg_1 = right_leg.addChild("right_leg_1", ModelPartBuilder.create().uv(54, 25).cuboid(-4.0F, -12.0F, -2.0F, 4.0F, 9.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(1.9F, 12.0F, 0.0F));

		ModelPartData right_leg_2 = right_leg.addChild("right_leg_2", ModelPartBuilder.create().uv(54, 0).cuboid(-2.1F, 4.0F, -5.0F, 4.0F, 6.0F, 3.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData right_arm = hyperion_spirit.addChild("right_arm", ModelPartBuilder.create().uv(40, 46).cuboid(-3.0F, -2.0F, -2.0F, 4.0F, 9.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(-5.0F, -22.0F, 0.0F));

		ModelPartData left_arm = hyperion_spirit.addChild("left_arm", ModelPartBuilder.create().uv(24, 46).cuboid(-1.0F, -2.0F, -2.0F, 4.0F, 9.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(5.0F, -22.0F, 0.0F));
		return TexturedModelData.of(modelData, 128, 128);
	}

	@Override
	public void setAngles(HyperionSpiritEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.getPart().traverse().forEach(ModelPart::resetTransform);
		this.setHeadAngles(netHeadYaw, headPitch);

		this.updateAnimation(entity.attackAnimationState, ModAnimations.ATTACK, ageInTicks, 1f);
	}

	private void setHeadAngles(float headYaw, float headPitch) {
		headYaw = MathHelper.clamp(headYaw, -15.0f, 15.0f);
		headPitch = MathHelper.clamp(headPitch, -25.0f, 45.0f);

		this.head.yaw = headYaw * ((float)Math.PI / 180);
		this.head.pitch = headPitch * ((float)Math.PI / 180);
	}

	@Override
	public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
		hyperion_spirit.render(matrices, vertexConsumer, light, overlay, red, green, blue, 0.5f);
	}

	@Override
	public ModelPart getPart() {
		return hyperion_spirit;
	}
}