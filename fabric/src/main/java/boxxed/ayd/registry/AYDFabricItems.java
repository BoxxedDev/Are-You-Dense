package boxxed.ayd.registry;

import boxxed.ayd.Constants;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;

import java.util.function.Supplier;

public class AYDFabricItems extends AYDItems {
    @Override
    public Supplier<Item> register(String id, Supplier<Item> item) {
        ResourceLocation itemId = new ResourceLocation(Constants.MOD_ID, id);

        Item registeredItem = Registry.register(BuiltInRegistries.ITEM, itemId, item.get());

        return () -> registeredItem;
    }

    public void init() {}
}
