package net.jjowy.create_sweet_industry.item;

import net.jjowy.create_sweet_industry.CreateSweetIndustry;
import net.jjowy.create_sweet_industry.item.custom.RoyalJellyBottleItem;
import net.minecraft.world.item.*;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.List;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(CreateSweetIndustry.MOD_ID);

    public static final DeferredItem<Item> BEESWAX = ITEMS.register("beeswax",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> DRIED_BEESWAX = ITEMS.register("dried_beeswax",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> DRIED_HONEYCOMB = ITEMS.register("dried_honeycomb",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> BAR_OF_HONEY = ITEMS.register("bar_of_honey",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> ROYAL_JELLY_BOTTLE = ITEMS.register("royal_jelly_bottle",
            () -> new RoyalJellyBottleItem(new Item.Properties()
                    .stacksTo(16)
                    .food(ModFoodProperties.ROYAL_JELLY_BOTTLE)
                    .craftRemainder(net.minecraft.world.item.Items.GLASS_BOTTLE)));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
