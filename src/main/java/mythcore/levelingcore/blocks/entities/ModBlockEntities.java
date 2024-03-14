package mythcore.levelingcore.blocks.entities;

import mythcore.levelingcore.SoloLeveling;
import mythcore.levelingcore.blocks.ModBlocks;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModBlockEntities {
    public static final BlockEntityType<ManaFurnaceBlockEntity> MANA_FURNACE_BLOCK_ENTITY =
            Registry.register(Registries.BLOCK_ENTITY_TYPE, new Identifier(SoloLeveling.MOD_ID, "mana_furnace_be"),
                    FabricBlockEntityTypeBuilder.create(ManaFurnaceBlockEntity::new,
                            ModBlocks.MANA_FURNACE).build());

    public static void registerBlockEntities() {
        SoloLeveling.LOGGER.info("Registering Block Entities for + " + SoloLeveling.MOD_ID);
    }
}
