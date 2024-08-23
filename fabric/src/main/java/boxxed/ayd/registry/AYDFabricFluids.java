package boxxed.ayd.registry;

import boxxed.ayd.Constants;
import boxxed.ayd.fluid.TestFluid;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BucketItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.material.FlowingFluid;

import java.util.function.Supplier;

public class AYDFabricFluids{
    public static FlowingFluid STILL_TEST_FLUID;
    public static FlowingFluid FLOWING_TEST_FLUID;
    public static Block TEST_FLUID_BLOCK;
    public static Item TEST_FLUID_BUCKET;

    public static void init() {
        STILL_TEST_FLUID = Registry.register(BuiltInRegistries.FLUID,
                new ResourceLocation(Constants.MOD_ID, "test_fluid"), new TestFluid.Source());
        FLOWING_TEST_FLUID = Registry.register(BuiltInRegistries.FLUID,
                new ResourceLocation(Constants.MOD_ID, "flowing_test_fluid"), new TestFluid.Flowing());

        TEST_FLUID_BLOCK = Registry.register(BuiltInRegistries.BLOCK, new ResourceLocation(Constants.MOD_ID, "test_fluid_block"),
                new LiquidBlock(AYDFabricFluids.STILL_TEST_FLUID, FabricBlockSettings.copyOf(Blocks.WATER)){});
        TEST_FLUID_BUCKET = Registry.register(BuiltInRegistries.ITEM, new ResourceLocation(Constants.MOD_ID, "test_fluid_bucket"),
                new BucketItem(AYDFabricFluids.STILL_TEST_FLUID, new Item.Properties()));
    }
}
