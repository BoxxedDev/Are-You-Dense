package boxxed.ayd.fluid_handling;

public abstract class CommonFluidTypeWrapper<T extends Object> {
    private T fluid;

    protected CommonFluidTypeWrapper(T fluid) {
        this.fluid = fluid;
    }

    public T get() {
        return fluid;
    }
}
