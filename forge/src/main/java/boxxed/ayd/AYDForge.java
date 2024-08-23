package boxxed.ayd;

import boxxed.ayd.fluid_handling.AYDForgeFluidTypes;
import boxxed.ayd.registry.AYDForgeBlockEntities;
import boxxed.ayd.registry.AYDForgeBlocks;
import boxxed.ayd.registry.AYDForgeFluids;
import boxxed.ayd.registry.AYDForgeItems;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(Constants.MOD_ID)
public class AYDForge {
    public static final AYDForgeItems AYD_ITEMS = new AYDForgeItems();
    public static final AYDForgeBlockEntities AYD_BLOCK_ENTITIES = new AYDForgeBlockEntities();
    public static final AYDForgeBlocks AYD_BLOCKS = new AYDForgeBlocks();

    private final IEventBus eventBus;

    public AYDForge() {

        eventBus = FMLJavaModLoadingContext.get().getModEventBus();

        // This method is invoked by the Forge mod loader when it is ready
        // to load your mod. You can access Forge and Common code in this
        // project.

        // Use Forge to bootstrap the Common mod.
        Constants.LOG.info("Hello Forge world!");
        AYDCommon.init();
        AYD_ITEMS.init(eventBus);

        AYD_BLOCK_ENTITIES.init(eventBus);
        AYD_BLOCKS.init(eventBus);

        AYDForgeFluids.init(eventBus);

        AYDForgeFluidTypes.init();
    }
}