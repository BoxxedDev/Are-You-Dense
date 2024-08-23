package boxxed.ayd.blocks.base;

import boxxed.ayd.blocks.compressor.CompressorBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

import java.util.function.Supplier;

public class BaseTickingBlock extends Block implements EntityBlock {
    private Supplier<BlockEntityType<?>> blockEntityType;

    public BaseTickingBlock(Properties properties, Supplier<BlockEntityType<?>> blockEntityType) {
        super(properties);
        this.blockEntityType = blockEntityType;
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos blockPos, BlockState blockState) {
        return this.blockEntityType.get().create(blockPos,blockState);
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState $$1, BlockEntityType<T> $$2) {
        return level.isClientSide() ? null : ($0, pos, $1, blockEntity) -> {
            if(blockEntity instanceof BaseTickingBlockEntity be) {
                be.tick();
            }
        };
    }
}
