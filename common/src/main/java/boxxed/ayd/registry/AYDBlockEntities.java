package boxxed.ayd.registry;

import boxxed.ayd.Constants;
import boxxed.ayd.blocks.compressor.CompressorBlockEntity;
import boxxed.ayd.blocks.decompressor.DecompressorBlockEntity;
import boxxed.ayd.fluid_handling.ICommonFluidInterface;
import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;

import java.util.function.Supplier;

public abstract class AYDBlockEntities {
    public final Supplier<BlockEntityType<BlockEntity>> COMPRESSOR_BLOCK_ENTITY = register("compressor_be", () -> BlockEntityType.Builder.of(
            (pos, state) -> new CompressorBlockEntity(getBE(new ResourceLocation(Constants.MOD_ID, "compressor_be")).get(), getInterface(),
                    pos, state), getBlock(new ResourceLocation(Constants.MOD_ID, "compressor")).get()));
    public final Supplier<BlockEntityType<BlockEntity>> DECOMPRESSOR_BLOCK_ENTITY = register("decompressor_be", () -> BlockEntityType.Builder.of(
            (pos, state) -> new DecompressorBlockEntity(getBE(new ResourceLocation(Constants.MOD_ID, "decompressor_be")).get(),
                    pos, state), getBlock(new ResourceLocation(Constants.MOD_ID, "decompressor")).get()));

    public abstract Supplier<BlockEntityType<BlockEntity>> register(String id, Supplier<BlockEntityType.Builder<?>> blockEntityType);

    public abstract Supplier<Block> getBlock(ResourceLocation location);

    public abstract Supplier<BlockEntityType<?>> getBE(ResourceLocation location);

    public abstract Supplier<ICommonFluidInterface> getInterface();
}
