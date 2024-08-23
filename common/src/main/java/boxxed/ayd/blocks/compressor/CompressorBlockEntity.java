package boxxed.ayd.blocks.compressor;

import boxxed.ayd.Constants;
import boxxed.ayd.blocks.base.BaseTickingBlockEntity;
import boxxed.ayd.fluid_handling.CommonFluidTypeWrapper;
import boxxed.ayd.fluid_handling.CommonFluidTypes;
import boxxed.ayd.fluid_handling.ICommonFluidInterface;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.arguments.ComponentArgument;
import net.minecraft.commands.arguments.EntityArgument;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.ComponentUtils;
import net.minecraft.server.commands.TellRawCommand;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.ai.targeting.TargetingConditions;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.FurnaceBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Fluid;
import org.jetbrains.annotations.Nullable;

import java.util.Iterator;
import java.util.function.Supplier;

public class CompressorBlockEntity extends BaseTickingBlockEntity implements MenuProvider {
    public static ICommonFluidInterface FLUID_INTERFACE;

    public CompressorBlockEntity(BlockEntityType<?> blockEntityType, Supplier<ICommonFluidInterface> fluidInterface, BlockPos pos, BlockState state) {
        super(blockEntityType, pos, state);
        FLUID_INTERFACE = fluidInterface.get();
    }

    @Override
    public void tick() {

    }

    @Override
    public Component getDisplayName() {
        return Component.translatable("container.compressor");
    }

    @Nullable
    @Override
    public AbstractContainerMenu createMenu(int i, Inventory inventory, Player player) {
        return null;
    }
}
