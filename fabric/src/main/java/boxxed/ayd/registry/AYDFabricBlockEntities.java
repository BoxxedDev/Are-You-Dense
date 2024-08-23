package boxxed.ayd.registry;

import boxxed.ayd.Constants;
import boxxed.ayd.fluid_handling.FabricFluidInterface;
import boxxed.ayd.fluid_handling.ICommonFluidInterface;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;

import java.util.function.Supplier;

public class AYDFabricBlockEntities extends AYDBlockEntities{
    @Override
    public Supplier<BlockEntityType<BlockEntity>> register(String id, Supplier<BlockEntityType.Builder<?>> blockEntityType) {
        ResourceLocation blockEntityId = new ResourceLocation(Constants.MOD_ID, id);

        BlockEntityType<BlockEntity> registeredBlockEntityType = (BlockEntityType<BlockEntity>) Registry.register(BuiltInRegistries.BLOCK_ENTITY_TYPE, blockEntityId, blockEntityType.get().build(null));

        return () -> registeredBlockEntityType;
    }

    @Override
    public Supplier<Block> getBlock(ResourceLocation location) {
        return () -> BuiltInRegistries.BLOCK.get(location);
    }

    @Override
    public Supplier<BlockEntityType<?>> getBE(ResourceLocation location) {
        return () -> BuiltInRegistries.BLOCK_ENTITY_TYPE.get(location);
    }

    @Override
    public Supplier<ICommonFluidInterface> getInterface() {
        return FabricFluidInterface::new;
    }

    public void init(){}
}
