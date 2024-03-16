package mythcore.levelingcore;

import mythcore.levelingcore.blocks.ModBlocks;
import mythcore.levelingcore.entities.ModEntities;
import mythcore.levelingcore.entities.client.PantherModel;
import mythcore.levelingcore.entities.client.ModModelLayers;
import mythcore.levelingcore.entities.client.PantherRenderer;
import mythcore.levelingcore.screens.ManaFurnaceScreen;
import mythcore.levelingcore.screens.ModScreenHandlers;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.gui.screen.ingame.HandledScreens;
import net.minecraft.client.render.RenderLayer;


public class SoloLevelingClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.MANA_CRYSTAL, RenderLayer.getCutoutMipped());
		HandledScreens.register(ModScreenHandlers.MANA_FURNACE_SCREEN_HANDLER, ManaFurnaceScreen::new);
		EntityRendererRegistry.register(ModEntities.PANTHER, PantherRenderer::new);
		EntityModelLayerRegistry.registerModelLayer(ModModelLayers.PANTHER, PantherModel::getTexturedModelData);
	}
}