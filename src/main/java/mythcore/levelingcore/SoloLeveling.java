package mythcore.levelingcore;

import mythcore.levelingcore.blocks.ModBlocks;
import mythcore.levelingcore.items.ModItemGroups;
import mythcore.levelingcore.items.ModItems;
import net.fabricmc.api.ModInitializer;
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
	}
}