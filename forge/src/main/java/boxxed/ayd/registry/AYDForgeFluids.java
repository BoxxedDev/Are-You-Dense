package boxxed.ayd.registry;

import boxxed.ayd.Constants;
import boxxed.ayd.fluid.BaseFluidType;
import boxxed.ayd.fluid.TestFluid;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BucketItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.material.Fluid;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fluids.FluidType;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.joml.Vector3f;

import java.util.function.Supplier;

public class AYDForgeFluids{
    private static final ResourceLocation WATER_STILL_RL = new ResourceLocation("block/water_still");
    private static final ResourceLocation WATER_FLOW_RL = new ResourceLocation("block/water_flow");
    private static final ResourceLocation WATER_OVERLAY_RL = new ResourceLocation("misc/underwater");

    private static final DeferredRegister<Fluid> FLUIDS = DeferredRegister.create(ForgeRegistries.FLUIDS, Constants.MOD_ID);
    private static final DeferredRegister<FluidType> FLUID_TYPES = DeferredRegister.create(ForgeRegistries.Keys.FLUID_TYPES, Constants.MOD_ID);
    private static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Constants.MOD_ID);
    private static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Constants.MOD_ID);

    public static final RegistryObject<FluidType> TEST_FLUID_FLUID_TYPE = FLUID_TYPES.register("test_fluid_fluid",
            () -> new BaseFluidType(WATER_STILL_RL, WATER_FLOW_RL, WATER_OVERLAY_RL, 0xA1FFFFFF, new Vector3f(1f,1f,1f),
                    FluidType.Properties.create().lightLevel(2).viscosity(5).density(15)));

    public static final RegistryObject<FlowingFluid> SOURCE_TEST_FLUID = FLUIDS.register("test_fluid",
            () -> new ForgeFlowingFluid.Source(AYDForgeFluids.TEST_FLUID_FLUID_PROPERTIES));
    public static final RegistryObject<FlowingFluid> FLOWING_TEST_FLUID = FLUIDS.register("flowing_test_fluid",
            () -> new ForgeFlowingFluid.Flowing(AYDForgeFluids.TEST_FLUID_FLUID_PROPERTIES));

    public static final RegistryObject<LiquidBlock> TEST_FLUID_BLOCK = BLOCKS.register("test_fluid_block",
            () -> new LiquidBlock(AYDForgeFluids.SOURCE_TEST_FLUID, BlockBehaviour.Properties.copy(Blocks.WATER).noLootTable()));

    public static final RegistryObject<BucketItem> TEST_FLUID_BUCKET = ITEMS.register("test_fluid_bucket",
            () -> new BucketItem(AYDForgeFluids.SOURCE_TEST_FLUID, new Item.Properties()));

    public static final ForgeFlowingFluid.Properties TEST_FLUID_FLUID_PROPERTIES = new ForgeFlowingFluid.Properties(
            AYDForgeFluids.TEST_FLUID_FLUID_TYPE, AYDForgeFluids.SOURCE_TEST_FLUID, AYDForgeFluids.FLOWING_TEST_FLUID)
            .slopeFindDistance(2).levelDecreasePerBlock(1).block(AYDForgeFluids.TEST_FLUID_BLOCK).bucket(AYDForgeFluids.TEST_FLUID_BUCKET);

    public static void init(IEventBus eventBus) {
        FLUID_TYPES.register(eventBus);
        FLUIDS.register(eventBus);
        BLOCKS.register(eventBus);
        ITEMS.register(eventBus);
    }
}
