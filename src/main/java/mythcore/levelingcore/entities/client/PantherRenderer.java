package mythcore.levelingcore.entities.client;

import mythcore.levelingcore.SoloLeveling;
import mythcore.levelingcore.entities.PantherModel;
import mythcore.levelingcore.entities.custom.PantherEntity;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

public class PantherRenderer extends MobEntityRenderer<PantherEntity, PantherModel<PantherEntity>> {

    private static final Identifier TEXTURE = new Identifier(SoloLeveling.MOD_ID, "textures/entity/panther_base.png");
    public PantherRenderer(EntityRendererFactory.Context context) {
        super(context, new PantherModel<>(context.getPart(ModModelLayers.PANTHER)), 1.0f);
    }

    @Override
    public Identifier getTexture(PantherEntity entity) {
        return TEXTURE;
    }

    @Override
    public void render(PantherEntity mobEntity, float f, float g, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i) {

        if(mobEntity.isAttacking()) {
            matrixStack.scale(1.2f, 1.2f, 1.2f);
        }
        else{
            matrixStack.scale(1.0f, 1.0f, 1.0f);
        }
        super.render(mobEntity, f, g, matrixStack, vertexConsumerProvider, i);
    }
}
