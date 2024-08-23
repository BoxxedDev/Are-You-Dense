package boxxed.ayd.blocks.base;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.Nullable;

public class AbstractFluidManipulationMenu extends AbstractContainerMenu {
    protected AbstractFluidManipulationMenu(@Nullable MenuType<?> type, int containerId) {
        super(type, containerId);
    }

    @Override
    public ItemStack quickMoveStack(Player player, int i) {
        return null;
    }

    @Override
    public boolean stillValid(Player player) {
        return false;
    }
}
