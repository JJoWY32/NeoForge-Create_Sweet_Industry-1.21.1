package net.jjowy.create_sweet_industry.block;

import net.jjowy.create_sweet_industry.CreateSweetIndustry;
import net.jjowy.create_sweet_industry.item.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(CreateSweetIndustry.MOD_ID);

    public static final DeferredBlock<Block> DRIED_HONEYCOMB_BLOCK = registerBlock("dried_honeycomb_block",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(0.6f).sound(SoundType.CORAL_BLOCK)));

    public static final DeferredBlock<Block> WAX_BLOCK = registerBlock("wax_block",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(0.6f).sound(SoundType.CORAL_BLOCK)));
    public static final DeferredBlock<Block> POLISHED_WAX = registerBlock("polished_wax",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(0.6f).sound(SoundType.CORAL_BLOCK)));
    public static final DeferredBlock<Block> WAX_BRICKS = registerBlock("wax_bricks",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(0.6f).sound(SoundType.CORAL_BLOCK)));
    public static final DeferredBlock<Block> WAX_PILLAR = registerBlock("wax_pillar",
            () -> new RotatedPillarBlock(BlockBehaviour.Properties.of()
                    .strength(0.6f).sound(SoundType.CORAL_BLOCK)));

    public static final DeferredBlock<StairBlock> WAX_STAIRS = registerBlock("wax_stairs",
            () -> new StairBlock(ModBlocks.WAX_BLOCK.get().defaultBlockState(),
                    BlockBehaviour.Properties.of().strength(0.6f)));
    public static final DeferredBlock<SlabBlock> WAX_SLAB = registerBlock("wax_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.of().strength(0.6f)));
    public static final DeferredBlock<StairBlock> POLISHED_WAX_STAIRS = registerBlock("polished_wax_stairs",
            () -> new StairBlock(ModBlocks.POLISHED_WAX.get().defaultBlockState(),
                    BlockBehaviour.Properties.of().strength(0.6f)));
    public static final DeferredBlock<SlabBlock> POLISHED_WAX_SLAB = registerBlock("polished_wax_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.of().strength(0.6f)));
    public static final DeferredBlock<StairBlock> WAX_BRICK_STAIRS = registerBlock("wax_brick_stairs",
            () -> new StairBlock(ModBlocks.WAX_BRICKS.get().defaultBlockState(),
                    BlockBehaviour.Properties.of().strength(0.6f)));
    public static final DeferredBlock<SlabBlock> WAX_BRICK_SLAB = registerBlock("wax_brick_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.of().strength(0.6f)));

    public static final DeferredBlock<Block> DRIED_WAX_BLOCK = registerBlock("dried_wax_block",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(0.6f).sound(SoundType.CORAL_BLOCK)));
    public static final DeferredBlock<Block> POLISHED_DRIED_WAX = registerBlock("polished_dried_wax",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(0.6f).sound(SoundType.CORAL_BLOCK)));
    public static final DeferredBlock<Block> DRIED_WAX_BRICKS = registerBlock("dried_wax_bricks",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(0.6f).sound(SoundType.CORAL_BLOCK)));
    public static final DeferredBlock<Block> DRIED_WAX_PILLAR = registerBlock("dried_wax_pillar",
            () -> new RotatedPillarBlock(BlockBehaviour.Properties.of()
                    .strength(0.6f).sound(SoundType.CORAL_BLOCK)));

    public static final DeferredBlock<StairBlock> DRIED_WAX_STAIRS = registerBlock("dried_wax_stairs",
            () -> new StairBlock(ModBlocks.DRIED_WAX_BLOCK.get().defaultBlockState(),
                    BlockBehaviour.Properties.of().strength(0.6f)));
    public static final DeferredBlock<SlabBlock> DRIED_WAX_SLAB = registerBlock("dried_wax_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.of().strength(0.6f)));
    public static final DeferredBlock<StairBlock> POLISHED_DRIED_WAX_STAIRS = registerBlock("polished_dried_wax_stairs",
            () -> new StairBlock(ModBlocks.POLISHED_DRIED_WAX.get().defaultBlockState(),
                    BlockBehaviour.Properties.of().strength(0.6f)));
    public static final DeferredBlock<SlabBlock> POLISHED_DRIED_WAX_SLAB = registerBlock("polished_dried_wax_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.of().strength(0.6f)));
    public static final DeferredBlock<StairBlock> DRIED_WAX_BRICK_STAIRS = registerBlock("dried_wax_brick_stairs",
            () -> new StairBlock(ModBlocks.DRIED_WAX_BRICKS.get().defaultBlockState(),
                    BlockBehaviour.Properties.of().strength(0.6f)));
    public static final DeferredBlock<SlabBlock> DRIED_WAX_BRICK_SLAB = registerBlock("dried_wax_brick_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.of().strength(0.6f)));


    public static final DeferredBlock<ButtonBlock> POLISHED_WAX_BUTTON = registerBlock("polished_wax_button",
            () -> new ButtonBlock(BlockSetType.OAK, 60, BlockBehaviour.Properties.of().strength(0.6f).noCollission()));

    public static final DeferredBlock<ButtonBlock> POLISHED_DRIED_WAX_BUTTON = registerBlock("polished_dried_wax_button",
            () -> new ButtonBlock(BlockSetType.OAK, 40, BlockBehaviour.Properties.of().strength(0.6f).noCollission()));


    public static final DeferredBlock<WallBlock> WAX_WALL = registerBlock("wax_wall",
            () -> new WallBlock(BlockBehaviour.Properties.of().strength(0.6f)));
    public static final DeferredBlock<WallBlock> POLISHED_WAX_WALL = registerBlock("polished_wax_wall",
            () -> new WallBlock(BlockBehaviour.Properties.of().strength(0.6f)));
    public static final DeferredBlock<WallBlock> WAX_BRICK_WALL = registerBlock("wax_brick_wall",
            () -> new WallBlock(BlockBehaviour.Properties.of().strength(0.6f)));

    public static final DeferredBlock<WallBlock> DRIED_WAX_WALL = registerBlock("dried_wax_wall",
            () -> new WallBlock(BlockBehaviour.Properties.of().strength(0.6f)));
    public static final DeferredBlock<WallBlock> POLISHED_DRIED_WAX_WALL = registerBlock("polished_dried_wax_wall",
            () -> new WallBlock(BlockBehaviour.Properties.of().strength(0.6f)));
    public static final DeferredBlock<WallBlock> DRIED_WAX_BRICK_WALL = registerBlock("dried_wax_brick_wall",
            () -> new WallBlock(BlockBehaviour.Properties.of().strength(0.6f)));


    /*
    public static final DeferredBlock<DoorBlock> HONEYCOMB_DOOR = registerBlock("bismuth_door",
            () -> new DoorBlock(BlockSetType.IRON, BlockBehaviour.Properties.of().strength(2f).noOcclusion()));
    public static final DeferredBlock<TrapDoorBlock> HONEYCOMB_TRAPDOOR = registerBlock("bismuth_trapdoor",
            () -> new TrapDoorBlock(BlockSetType.IRON, BlockBehaviour.Properties.of().strength(2f).noOcclusion()));
    */


    private static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> block) {
        DeferredBlock<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block) {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
