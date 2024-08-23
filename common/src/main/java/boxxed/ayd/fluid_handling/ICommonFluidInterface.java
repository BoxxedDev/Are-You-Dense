package boxxed.ayd.fluid_handling;

public interface ICommonFluidInterface<T extends CommonFluidTypeWrapper> {
    void setFluidWrapper(T fluid);
    T getFluidWrapper();
    void setFluidAmount(int amount);
    int getFluidAmount();
    void setFluidCapacity(int amount);
    int getFluidCapacity();
}
