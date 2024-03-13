package mythcore.levelingcore.items;

import mythcore.levelingcore.SoloLeveling;
import mythcore.levelingcore.blocks.ModBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {
    public static final ItemGroup LEVELING_GROUP = Registry.register(Registries.ITEM_GROUP, new Identifier(SoloLeveling.MOD_ID, "sololeveling"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.sololeveling")).icon(() -> new ItemStack(ModItems.CRYSTAL_SHARD)).entries((displayContext, entries) -> {
                //entries.add(ModItems.ITEM);
                entries.add(ModItems.CRYSTAL_SHARD);
                entries.add(ModBlocks.MANA_CRYSTAL);
                entries.add(ModItems.CRYSTAL_BALL);
                entries.add(ModItems.MYTHRIL_INGOT);
                entries.add(ModBlocks.MYTHRIL_BLOCK);
                entries.add(ModBlocks.MYTHRIL_ORE);
                entries.add(ModBlocks.MANA_FURNACE);
            }).build());
    public static void registerItemGroups(){
        SoloLeveling.LOGGER.info("Registering Item Groups for " + SoloLeveling.MOD_ID);
    }
}
