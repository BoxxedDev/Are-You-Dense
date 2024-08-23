package boxxed.ayd.fluid_handling;

import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.material.Fluid;

public class ForgeFluidTypeWrapper extends CommonFluidTypeWrapper<Fluid> {
    protected ForgeFluidTypeWrapper(Fluid fluid) {
        super(fluid);
    }
}
