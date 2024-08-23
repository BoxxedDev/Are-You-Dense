package boxxed.ayd.fluid_handling;

import net.fabricmc.fabric.api.transfer.v1.fluid.FluidVariant;
import net.fabricmc.fabric.api.transfer.v1.fluid.base.SingleFluidStorage;
import net.fabricmc.fabric.api.transfer.v1.storage.StorageView;
import net.fabricmc.fabric.api.transfer.v1.storage.base.SingleSlotStorage;
import net.fabricmc.fabric.api.transfer.v1.transaction.TransactionContext;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.annotations.UnmodifiableView;

import java.util.Iterator;
import java.util.List;
import java.util.Spliterator;
import java.util.function.Consumer;

public class FabricFluidInterface extends SingleFluidStorage implements ICommonFluidInterface<FabricFluidTypeWrapper> {
    private Integer capacity;
    private FabricFluidTypeWrapper wrapper;

    @Override
    public void setFluidWrapper(FabricFluidTypeWrapper fluid) {
        this.wrapper = fluid;
    }

    @Override
    public FabricFluidTypeWrapper getFluidWrapper() {
        return wrapper;
    }

    @Override
    public void setFluidAmount(int amount) {
        this.amount = amount* 81L;
    }

    @Override
    public int getFluidAmount() {
        return (int) (super.getAmount()/81);
    }

    @Override
    public void setFluidCapacity(int amount) {
        this.capacity = amount;
    }

    @Override
    public int getFluidCapacity() {
        return this.capacity;
    }

    @Override
    protected long getCapacity(FluidVariant variant) {
        return capacity;
    }
}
