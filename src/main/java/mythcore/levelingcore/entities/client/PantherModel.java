package mythcore.levelingcore.entities.client;

import mythcore.levelingcore.entities.animation.ModAnimations;
import mythcore.levelingcore.entities.custom.PantherEntity;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.MathHelper;

// Made with Blockbench 4.9.4
// Exported for Minecraft version 1.17+ for Yarn
// Paste this class into your mod and generate all required imports
public class PantherModel<T extends PantherEntity> extends SinglePartEntityModel<T> {
	private final ModelPart body;
	private final ModelPart head;

	public PantherModel(ModelPart root) {
		this.body = root.getChild("body");
		this.head = body.getChild("torso").getChild("head");
	}
	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();
		ModelPartData body = modelPartData.addChild("body", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 24.0F, 0.0F));

		ModelPartData torso = body.addChild("torso", ModelPartBuilder.create().uv(0, 0).cuboid(-3.0F, -18.0F, -11.0F, 6.0F, 7.0F, 20.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 1.0F, 0.0F));

		ModelPartData tail = torso.addChild("tail", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData tail1 = tail.addChild("tail1", ModelPartBuilder.create().uv(0, 0).cuboid(-1.0F, -1.0F, -3.5F, 2.0F, 2.0F, 7.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -17.0F, 12.5F));

		ModelPartData tail2 = tail.addChild("tail2", ModelPartBuilder.create().uv(0, 0).cuboid(-1.0F, -1.0F, -3.5F, 2.0F, 2.0F, 7.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -18.0F, 18.5F));

		ModelPartData tail3 = tail.addChild("tail3", ModelPartBuilder.create().uv(0, 0).cuboid(-1.0F, -1.0F, -3.5F, 2.0F, 2.0F, 7.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -18.0F, 25.5F));

		ModelPartData head = torso.addChild("head", ModelPartBuilder.create().uv(0, 27).cuboid(-3.0F, -20.0F, -18.5F, 6.0F, 6.0F, 7.5F, new Dilation(0.0F))
				.uv(21, 27).cuboid(-2.0F, -17.0F, -21.0F, 4.0F, 3.0F, 2.5F, new Dilation(0.0F))
				.uv(48, 4).cuboid(-3.0F, -22.0F, -15.0F, 2.0F, 2.0F, 2.5F, new Dilation(0.0F))
				.uv(48, 4).cuboid(1.0F, -22.0F, -15.0F, 2.0F, 2.0F, 2.5F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0F, 0F));

		ModelPartData backLegL = body.addChild("backLegL", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData backlegTL = backLegL.addChild("backlegTL", ModelPartBuilder.create().uv(28, 36).cuboid(-2.5F, -8.0F, 0.0F, 3.0F, 5.0F, 3.0F, new Dilation(0.0F))
				.uv(12, 41).cuboid(-2.25F, -3.0F, 0.5F, 2.5F, 4.0F, 2.5F, new Dilation(0.0F)), ModelTransform.pivot(-2.1F, -6.0F, 5.0F));

		ModelPartData backlegBL = backLegL.addChild("backlegBL", ModelPartBuilder.create().uv(44, 10).cuboid(-2.0F, 5.0F, 0.0F, 2.0F, 1.0F, 3.0F, new Dilation(0.0F))
				.uv(11, 0).cuboid(-2.0F, 1.0F, 1.0F, 2.0F, 4.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(-2.1F, -6.0F, 5.0F));

		ModelPartData backLegR = body.addChild("backLegR", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData backlegTR = backLegR.addChild("backlegTR", ModelPartBuilder.create().uv(28, 36).mirrored().cuboid(-5.7F, -8.0F, 0.0F, 3.0F, 5.0F, 3.0F, new Dilation(0.0F)).mirrored(false)
				.uv(12, 41).mirrored().cuboid(-5.45F, -3.0F, 0.5F, 2.5F, 4.0F, 2.5F, new Dilation(0.0F)).mirrored(false), ModelTransform.pivot(7.1F, -6.0F, 5.0F));

		ModelPartData backlegBR = backLegR.addChild("backlegBR", ModelPartBuilder.create().uv(11, 0).mirrored().cuboid(-5.2F, 1.0F, 1.0F, 2.0F, 4.0F, 2.0F, new Dilation(0.0F)).mirrored(false)
				.uv(44, 10).mirrored().cuboid(-5.2F, 5.0F, 0.0F, 2.0F, 1.0F, 3.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.pivot(7.1F, -6.0F, 5.0F));

		ModelPartData frontLegL = body.addChild("frontLegL", ModelPartBuilder.create(), ModelTransform.pivot(-1.2F, -10.2F, -5.0F));

		ModelPartData frontlegTL = frontLegL.addChild("frontlegTL", ModelPartBuilder.create().uv(32, 0).cuboid(-3.4F, -3.8F, -5.0F, 4.0F, 6.0F, 4.0F, new Dilation(0.0F))
				.uv(39, 27).cuboid(-3.1F, 2.2F, -4.0F, 2.5F, 4.0F, 3.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData frontlegBL = frontLegL.addChild("frontlegBL", ModelPartBuilder.create().uv(0, 27).mirrored().cuboid(-1.0F, -2.5F, -0.75F, 2.0F, 3.0F, 2.0F, new Dilation(0.0F)).mirrored(false)
				.uv(44, 0).mirrored().cuboid(-1.0F, 0.5F, -1.75F, 2.0F, 1.0F, 3.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.pivot(-1.9F, 8.7F, -2.25F));

		ModelPartData frontLegR = body.addChild("frontLegR", ModelPartBuilder.create(), ModelTransform.pivot(7.2F, -10.2F, -5.0F));

		ModelPartData frontlegTR = frontLegR.addChild("frontlegTR", ModelPartBuilder.create().uv(32, 0).mirrored().cuboid(-6.8F, -3.8F, -5.0F, 4.0F, 6.0F, 4.0F, new Dilation(0.0F)).mirrored(false)
				.uv(39, 27).mirrored().cuboid(-5.5F, 2.2F, -4.0F, 2.5F, 4.0F, 3.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData frontlegBR = frontLegR.addChild("frontlegBR", ModelPartBuilder.create().uv(0, 27).mirrored().cuboid(-1.0F, -2.5F, -0.75F, 2.0F, 3.0F, 2.0F, new Dilation(0.0F)).mirrored(false)
				.uv(44, 0).mirrored().cuboid(-1.0F, 0.5F, -1.75F, 2.0F, 1.0F, 3.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.pivot(-4.3F, 8.7F, -2.25F));
		return TexturedModelData.of(modelData, 64, 64);
	}
	@Override
	public void setAngles(PantherEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.getPart().traverse().forEach(ModelPart::resetTransform);
		this.setHeadAngles(netHeadYaw, headPitch);

		this.animateMovement(ModAnimations.PANTHER_WALK, limbSwing, limbSwingAmount, 2f, 2.5f);
		this.updateAnimation(entity.idleAnimationState, ModAnimations.PANTHER_IDLE, ageInTicks, 1f);
	}

	private void setHeadAngles(float headYaw, float headPitch){
		headYaw = MathHelper.clamp(headYaw, -15.0F, 15.0F);
		headPitch = MathHelper.clamp(headPitch, -12.5F, 22.5F);

		this.head.yaw = headYaw * 0.017453292F;
		this.head.pitch = headPitch * 0.017453292F;
	}
	@Override
	public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
		body.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
	}

	@Override
	public ModelPart getPart() {
		return body;
	}
}