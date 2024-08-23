package boxxed.ayd.registry;

import boxxed.ayd.Constants;
import boxxed.ayd.blocks.compressor.CompressorBlockEntity;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class AYDForgeBlocks extends AYDBlocks {
    private static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Constants.MOD_ID);
    private static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Constants.MOD_ID);

    @Override
    public Supplier<Block> register(String id, Supplier<Block> block) {
        RegistryObject<Block> registeredBlock = BLOCKS.register(id, block);
        RegistryObject<Item> registeredItem = ITEMS.register(id, () -> new BlockItem(registeredBlock.get(), new Item.Properties()));

        return registeredBlock;
    }

    @Override
    public Supplier<BlockEntityType<?>> getBE(ResourceLocation location) {
        //return ForgeRegistries.BLOCK_ENTITY_TYPES.getHolder(location).get();
        return () -> ForgeRegistries.BLOCK_ENTITY_TYPES.getValue(location);
    }

    public void init(IEventBus event) {
        BLOCKS.register(event);
        ITEMS.register(event);
    }
}
