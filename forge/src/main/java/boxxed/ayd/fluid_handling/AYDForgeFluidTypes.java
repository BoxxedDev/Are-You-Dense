package boxxed.ayd.fluid_handling;

import boxxed.ayd.registry.AYDForgeFluids;
import net.minecraft.world.level.material.Fluids;

public class AYDForgeFluidTypes {
    static {
        CommonFluidTypes.TEST_FLUID = new ForgeFluidTypeWrapper(AYDForgeFluids.SOURCE_TEST_FLUID.get());
        CommonFluidTypes.WATER = new ForgeFluidTypeWrapper(Fluids.WATER);
    }

    public static void init() {}
}
