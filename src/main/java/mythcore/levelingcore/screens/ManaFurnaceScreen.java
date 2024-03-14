package mythcore.levelingcore.screens;

import com.mojang.blaze3d.systems.RenderSystem;
import mythcore.levelingcore.SoloLeveling;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.render.GameRenderer;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ManaFurnaceScreen extends HandledScreen<ManaFurnaceScreenHandler> {
    private static final Identifier TEXTURE = new Identifier(SoloLeveling.MOD_ID, "textures/gui/mana_furnace_gui.png");
    public ManaFurnaceScreen(ManaFurnaceScreenHandler handler, PlayerInventory inventory, Text title) {
        super(handler, inventory, title);
    }

    @Override
    protected void init() {
        super.init();
    }

    @Override
    protected void drawBackground(DrawContext context, float delta, int mouseX, int mouseY) {
        RenderSystem.setShader(GameRenderer::getPositionTexProgram);
        RenderSystem.setShaderColor(1f, 1f, 1f, 1f);
        RenderSystem.setShaderTexture(0, TEXTURE);
        int x = (width - backgroundWidth) / 2;
        int y = (height - backgroundHeight) / 2;

        context.drawTexture(TEXTURE, x, y, 0, 0, backgroundWidth, backgroundHeight);

        renderProgressArrow(context, x, y);
    }

    private void renderProgressArrow(DrawContext context, int x, int y) {
        if(handler.isCrafting()) {
            context.drawTexture(TEXTURE, x + 100, y + 17, 181, 0, 7, handler.getScaledProgress());
            context.drawTexture(TEXTURE, x + 60, y + 44, 0, 172, handler.getScaledProgressMana(), 4);
        }
    }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        renderBackground(context, mouseX, mouseY, delta);
        super.render(context, mouseX, mouseY, delta);
        drawMouseoverTooltip(context, mouseX, mouseY);
    }
}
