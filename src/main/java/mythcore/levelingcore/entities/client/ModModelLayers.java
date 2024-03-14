package mythcore.levelingcore.entities.client;

import mythcore.levelingcore.SoloLeveling;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.util.Identifier;

public class ModModelLayers {
    public static final EntityModelLayer PANTHER =
            new EntityModelLayer(new Identifier(SoloLeveling.MOD_ID, "panther"), "main");
}
