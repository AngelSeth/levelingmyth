package mythcore.levelingcore;

import mythcore.levelingcore.blocks.ModBlocks;
import mythcore.levelingcore.screens.ManaFurnaceScreen;
import mythcore.levelingcore.screens.ModScreenHandlers;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.gui.screen.ingame.HandledScreens;
import net.minecraft.client.render.RenderLayer;


public class SoloLevelingClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		// This entrypoint is suitable for setting up client-specific logic, such as rendering.
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.MANA_CRYSTAL, RenderLayer.getCutoutMipped());
		HandledScreens.register(ModScreenHandlers.MANA_FURNACE_SCREEN_HANDLER, ManaFurnaceScreen::new);
	}
}