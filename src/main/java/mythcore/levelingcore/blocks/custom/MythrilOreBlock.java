package mythcore.levelingcore.blocks.custom;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;

public class MythrilOreBlock extends Block {
    public MythrilOreBlock() {
        super(Settings.copy(Blocks.DIAMOND_ORE));
    }
}
