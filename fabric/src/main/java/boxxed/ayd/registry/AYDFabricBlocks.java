package boxxed.ayd.registry;

import boxxed.ayd.Constants;
import net.fabricmc.fabric.api.transfer.v1.fluid.CauldronFluidContent;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;

import java.util.function.Supplier;

public class AYDFabricBlocks extends AYDBlocks {
    @Override
    public Supplier<Block> register(String id, Supplier<Block> block) {
        ResourceLocation blockId = new ResourceLocation(Constants.MOD_ID, id);

        Block registeredBlock = Registry.register(BuiltInRegistries.BLOCK, blockId, block.get());
        Item registeredItem = Registry.register(BuiltInRegistries.ITEM, blockId, new BlockItem(registeredBlock, new Item.Properties()));

        return () -> registeredBlock;
    }

    @Override
    public Supplier<BlockEntityType<?>> getBE(ResourceLocation location) {
        return () -> BuiltInRegistries.BLOCK_ENTITY_TYPE.get(location);
    }

    public void init() {}
}
