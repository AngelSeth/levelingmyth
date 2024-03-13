package mythcore.levelingcore.blocks.custom;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.FurnaceBlock;

public class ManaFurnaceBlock extends FurnaceBlock {
    public ManaFurnaceBlock() {
        super(Settings.copy(Blocks.FURNACE));
    }
}
