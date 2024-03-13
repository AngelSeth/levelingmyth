package mythcore.levelingcore.blocks.custom;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;

public class MythrilBlock extends Block {
    public MythrilBlock() {
        super(Settings.copy(Blocks.DIAMOND_BLOCK));
    }
}
