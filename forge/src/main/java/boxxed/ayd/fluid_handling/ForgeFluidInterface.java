package boxxed.ayd.fluid_handling;

import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.capability.templates.FluidTank;

public class ForgeFluidInterface extends FluidTank implements ICommonFluidInterface<ForgeFluidTypeWrapper> {
    private Integer amount;
    private Integer capacity;
    private ForgeFluidTypeWrapper wrapper;

    public ForgeFluidInterface(int capacity) {
        super(capacity);
    }

    @Override
    public void setFluidWrapper(ForgeFluidTypeWrapper fluid) {
        this.wrapper = fluid;
        if (amount != null && amount <= super.getCapacity())
            super.setFluid(new FluidStack(fluid.get(), amount));
        amount = null;
    }

    @Override
    public ForgeFluidTypeWrapper getFluidWrapper() {
        return wrapper;
    }

    @Override
    public void setFluidAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public int getFluidAmount() {
        return amount;
    }

    @Override
    public void setFluidCapacity(int amount) {
        super.setCapacity(amount);
    }

    @Override
    public int getFluidCapacity() {
        return super.getCapacity();
    }
}
