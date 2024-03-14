package mythcore.levelingcore.items;

import mythcore.levelingcore.SoloLeveling;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {

    //public static final Item ANTHILL = registerItem("anthill", new Item(new FabricItemSettings()));
    public static final Item CRYSTAL_SHARD = registerItem("crystal_shard", new Item(new FabricItemSettings()));
    public static final Item CRYSTAL_BALL = registerItem("crystal_ball", new Item(new FabricItemSettings()));
    public static final Item IMPURE_MYTHRIL_INGOT = registerItem("impure_mythril_ingot", new Item(new FabricItemSettings()));
    public static final Item RAW_MYTHRIL = registerItem("raw_mythril", new Item(new FabricItemSettings()));
    public static final Item MAGIC_DUST = registerItem("magic_dust", new Item(new FabricItemSettings()));



    private static Item registerItem(String name, Item item){
        return Registry.register(Registries.ITEM, new Identifier(SoloLeveling.MOD_ID, name), item);
    }

    public static void registerModItems() {
        SoloLeveling.LOGGER.info("Registering Mod Items for " + SoloLeveling.MOD_ID);
    }
}
