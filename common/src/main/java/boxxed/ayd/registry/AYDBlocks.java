package boxxed.ayd.registry;

import boxxed.ayd.Constants;
import boxxed.ayd.blocks.compressor.CompressorBlock;
import boxxed.ayd.blocks.compressor.CompressorBlockEntity;
import boxxed.ayd.blocks.decompressor.DecompressorBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;

import java.util.function.Supplier;

public abstract class AYDBlocks {
    public final Supplier<Block> COMPRESSOR = register("compressor",
            () -> new CompressorBlock(BlockBehaviour.Properties.of().sound(SoundType.DEEPSLATE).noOcclusion(),
                    getBE(new ResourceLocation(Constants.MOD_ID, "compressor_be"))));
    public final Supplier<Block> DECOMPRESSOR = register("decompressor",
            () -> new DecompressorBlock(BlockBehaviour.Properties.of().sound(SoundType.DEEPSLATE).noOcclusion(),
                    getBE(new ResourceLocation(Constants.MOD_ID, "decompressor_be"))));

    public abstract Supplier<Block> register(String id, Supplier<Block> block);
    public abstract Supplier<BlockEntityType<?>> getBE(ResourceLocation location);
}
