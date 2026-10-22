package net.jjowy.create_sweet_industry.item;

import net.jjowy.create_sweet_industry.CreateSweetIndustry;
import net.jjowy.create_sweet_industry.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, CreateSweetIndustry.MOD_ID);

    public static final Supplier<CreativeModeTab> CREATE_SWEET_INDUSTRY = CREATIVE_MODE_TAB.register("create_sweet_industry",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.BEESWAX.get()))
                    .title(Component.translatable("creativetab.create_sweet_industry.create_sweet_industry_tab"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.BEESWAX);
                        output.accept(ModItems.DRIED_BEESWAX);
                        output.accept(ModItems.DRIED_HONEYCOMB);

                        output.accept(ModItems.BAR_OF_HONEY);

                        output.accept(ModItems.ROYAL_JELLY_BOTTLE);

                        output.accept(ModBlocks.DRIED_HONEYCOMB_BLOCK);


                        output.accept(ModBlocks.WAX_PILLAR);

                        output.accept(ModBlocks.WAX_BLOCK);
                        output.accept(ModBlocks.WAX_STAIRS);
                        output.accept(ModBlocks.WAX_SLAB);
                        output.accept(ModBlocks.WAX_WALL);

                        output.accept(ModBlocks.POLISHED_WAX);
                        output.accept(ModBlocks.POLISHED_WAX_STAIRS);
                        output.accept(ModBlocks.POLISHED_WAX_SLAB);
                        output.accept(ModBlocks.POLISHED_WAX_BUTTON);
                        output.accept(ModBlocks.POLISHED_WAX_WALL);

                        output.accept(ModBlocks.WAX_BRICKS);
                        output.accept(ModBlocks.WAX_BRICK_STAIRS);
                        output.accept(ModBlocks.WAX_BRICK_SLAB);
                        output.accept(ModBlocks.WAX_BRICK_WALL);


                        output.accept(ModBlocks.DRIED_WAX_PILLAR);

                        output.accept(ModBlocks.DRIED_WAX_BLOCK);
                        output.accept(ModBlocks.DRIED_WAX_STAIRS);
                        output.accept(ModBlocks.DRIED_WAX_SLAB);
                        output.accept(ModBlocks.DRIED_WAX_WALL);

                        output.accept(ModBlocks.POLISHED_DRIED_WAX);
                        output.accept(ModBlocks.POLISHED_DRIED_WAX_STAIRS);
                        output.accept(ModBlocks.POLISHED_DRIED_WAX_SLAB);
                        output.accept(ModBlocks.POLISHED_DRIED_WAX_BUTTON);
                        output.accept(ModBlocks.POLISHED_DRIED_WAX_WALL);

                        output.accept(ModBlocks.DRIED_WAX_BRICKS);
                        output.accept(ModBlocks.DRIED_WAX_BRICK_STAIRS);
                        output.accept(ModBlocks.DRIED_WAX_BRICK_SLAB);
                        output.accept(ModBlocks.DRIED_WAX_BRICK_WALL);
                    }).build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TAB.register(eventBus);
    }
}
