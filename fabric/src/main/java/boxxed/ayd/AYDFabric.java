package boxxed.ayd;

import boxxed.ayd.fluid_handling.AYDFabricFluidTypes;
import boxxed.ayd.registry.AYDFabricBlockEntities;
import boxxed.ayd.registry.AYDFabricBlocks;
import boxxed.ayd.registry.AYDFabricFluids;
import boxxed.ayd.registry.AYDFabricItems;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;

public class AYDFabric implements ModInitializer {
    public static final AYDFabricItems AYD_ITEMS = new AYDFabricItems();
    public static final AYDFabricBlocks AYD_BLOCKS = new AYDFabricBlocks();
    public static final AYDFabricBlockEntities AYD_BLOCK_ENTITIES = new AYDFabricBlockEntities();

    @Override
    public void onInitialize() {
        // This method is invoked by the Fabric mod loader when it is ready
        // to load your mod. You can access Fabric and Common code in this
        // project.

        BlockRenderLayerMap.INSTANCE.putBlock(BuiltInRegistries.BLOCK.get(new ResourceLocation(Constants.MOD_ID, "compressor")), RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BuiltInRegistries.BLOCK.get(new ResourceLocation(Constants.MOD_ID, "decompressor")), RenderType.cutout());

        // Use Fabric to bootstrap the Common mod.
        Constants.LOG.info("Hello Fabric world!");
        AYDCommon.init();
        AYD_ITEMS.init();
        AYD_BLOCKS.init();
        AYD_BLOCK_ENTITIES.init();
        AYDFabricFluids.init();

        AYDFabricFluidTypes.init();
    }
}
