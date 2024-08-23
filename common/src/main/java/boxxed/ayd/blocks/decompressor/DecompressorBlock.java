package boxxed.ayd.blocks.decompressor;

import boxxed.ayd.blocks.base.BaseTickingBlock;
import net.minecraft.world.level.block.entity.BlockEntityType;

import java.util.function.Supplier;

public class DecompressorBlock extends BaseTickingBlock {
    public DecompressorBlock(Properties properties, Supplier<BlockEntityType<?>> blockEntityType) {
        super(properties, blockEntityType);
    }
}
