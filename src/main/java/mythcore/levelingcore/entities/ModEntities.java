package mythcore.levelingcore.entities;

import mythcore.levelingcore.SoloLeveling;
import mythcore.levelingcore.entities.custom.PantherEntity;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModEntities {
    public static final EntityType<PantherEntity> PANTHER = Registry.register(Registries.ENTITY_TYPE,
            new Identifier(SoloLeveling.MOD_ID, "panther"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, PantherEntity::new)
                    .dimensions(EntityDimensions.fixed(1f, 1f)).build());

    public static void registerModEntities() {
        SoloLeveling.LOGGER.info("Registering Entities for " + SoloLeveling.MOD_ID);
    }
}
