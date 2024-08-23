package boxxed.ayd.registry;

import boxxed.ayd.AYDCommon;
import boxxed.ayd.Constants;
import boxxed.ayd.blocks.compressor.CompressorBlock;
import boxxed.ayd.fluid_handling.ICommonFluidInterface;
import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class AYDForgeBlockEntities extends AYDBlockEntities{
    private static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, Constants.MOD_ID);

    @Override
    public Supplier<BlockEntityType<BlockEntity>> register(String id, Supplier<BlockEntityType.Builder<?>> builder) {
        RegistryObject<BlockEntityType<?>> registeredBlockEntity = BLOCK_ENTITIES.register(id, () -> builder.get().build(null));

        return () -> (BlockEntityType<BlockEntity>) registeredBlockEntity.get();
    }

    @Override
    public Supplier<Block> getBlock(ResourceLocation location) {
        return () -> ForgeRegistries.BLOCKS.getValue(location);
    }

    @Override
    public Supplier<BlockEntityType<?>> getBE(ResourceLocation location) {
        return () -> ForgeRegistries.BLOCK_ENTITY_TYPES.getValue(location);
    }

    @Override
    public Supplier<ICommonFluidInterface> getInterface() {
        return null;
    }

    public void init(IEventBus bus) {BLOCK_ENTITIES.register(bus);}
}
