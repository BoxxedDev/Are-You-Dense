package boxxed.ayd.blocks.compressor;

import boxxed.ayd.blocks.base.BaseTickingBlock;
import net.minecraft.world.level.block.entity.BlockEntityType;

import java.util.function.Supplier;

public class CompressorBlock extends BaseTickingBlock {
    public CompressorBlock(Properties properties, Supplier<BlockEntityType<?>> blockEntityType) {
        super(properties, blockEntityType);
    }
}
