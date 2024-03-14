package mythcore.levelingcore.screens;

import mythcore.levelingcore.SoloLeveling;
import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;

public class ModScreenHandlers {
    public static final ScreenHandlerType<ManaFurnaceScreenHandler> MANA_FURNACE_SCREEN_HANDLER =
            Registry.register(Registries.SCREEN_HANDLER, new Identifier(SoloLeveling.MOD_ID, "mana_furnace.refining"),
                    new ExtendedScreenHandlerType<>(ManaFurnaceScreenHandler::new));
    public static void registerScreenHandlers(){
        SoloLeveling.LOGGER.info("Registering Screen Handlers for + " + SoloLeveling.MOD_ID);
    }
}
