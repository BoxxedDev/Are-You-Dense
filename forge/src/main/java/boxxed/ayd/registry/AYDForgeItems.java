package boxxed.ayd.registry;

import boxxed.ayd.Constants;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class AYDForgeItems extends AYDItems {
    private static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Constants.MOD_ID);

    @Override
    public Supplier<Item> register(String id, Supplier<Item> item) {
        RegistryObject<Item> registeredItem = ITEMS.register(id, item);

        return registeredItem;
    }

    public void init(IEventBus event) {
        ITEMS.register(event);
    }
}
