package boxxed.ayd.registry;

import net.minecraft.world.item.Item;

import java.util.function.Supplier;

public abstract class AYDItems {
    //public final Supplier<Item> TEST_ITEM = register("test_item", () -> new Item(new Item.Properties()));

    public abstract Supplier<Item> register(String id, Supplier<Item> item);
}
