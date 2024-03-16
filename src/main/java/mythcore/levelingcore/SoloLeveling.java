package mythcore.levelingcore;

import mythcore.levelingcore.blocks.ModBlocks;
import mythcore.levelingcore.blocks.entities.ModBlockEntities;
import mythcore.levelingcore.entities.ModEntities;
import mythcore.levelingcore.entities.custom.PantherEntity;
import mythcore.levelingcore.items.ModItemGroups;
import mythcore.levelingcore.items.ModItems;
import mythcore.levelingcore.screens.ModScreenHandlers;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SoloLeveling implements ModInitializer {

	public static final String MOD_ID = "sololeveling";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {

		ModItems.registerModItems();
		ModItemGroups.registerItemGroups();
		ModBlocks.registerModBlocks();
		ModBlockEntities.registerBlockEntities();
		ModScreenHandlers.registerScreenHandlers();
		ModEntities.registerModEntities();
		FabricDefaultAttributeRegistry.register(ModEntities.PANTHER, PantherEntity.createPantherAttribute());
	}
}