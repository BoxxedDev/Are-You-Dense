package boxxed.ayd.fluid_handling;

import boxxed.ayd.registry.AYDFabricFluids;
import net.minecraft.world.level.material.Fluids;

public class AYDFabricFluidTypes {
    static {
        CommonFluidTypes.TEST_FLUID = new FabricFluidTypeWrapper(AYDFabricFluids.STILL_TEST_FLUID);
        CommonFluidTypes.WATER = new FabricFluidTypeWrapper(Fluids.WATER);
    }

    public static void init() {}
}
