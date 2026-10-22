package net.jjowy.create_sweet_industry.datagen;

import net.jjowy.create_sweet_industry.CreateSweetIndustry;
import net.jjowy.create_sweet_industry.block.ModBlocks;
import net.jjowy.create_sweet_industry.util.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends BlockTagsProvider {
    public ModBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, CreateSweetIndustry.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        tag(BlockTags.MINEABLE_WITH_AXE)
                .add(
                        ModBlocks.WAX_BLOCK.get(),
                        ModBlocks.POLISHED_WAX.get(),
                        ModBlocks.WAX_BRICKS.get(),
                        ModBlocks.WAX_PILLAR.get(),

                        ModBlocks.DRIED_WAX_BLOCK.get(),
                        ModBlocks.POLISHED_DRIED_WAX.get(),
                        ModBlocks.DRIED_WAX_BRICKS.get(),
                        ModBlocks.DRIED_WAX_PILLAR.get(),


                        ModBlocks.WAX_STAIRS.get(),
                        ModBlocks.POLISHED_WAX_STAIRS.get(),
                        ModBlocks.WAX_BRICK_STAIRS.get(),

                        ModBlocks.DRIED_WAX_STAIRS.get(),
                        ModBlocks.POLISHED_DRIED_WAX_STAIRS.get(),
                        ModBlocks.DRIED_WAX_BRICK_STAIRS.get(),


                        ModBlocks.WAX_SLAB.get(),
                        ModBlocks.POLISHED_WAX_SLAB.get(),
                        ModBlocks.WAX_BRICK_SLAB.get(),

                        ModBlocks.DRIED_WAX_SLAB.get(),
                        ModBlocks.POLISHED_DRIED_WAX_SLAB.get(),
                        ModBlocks.DRIED_WAX_BRICK_SLAB.get(),


                        ModBlocks.POLISHED_WAX_BUTTON.get(),

                        ModBlocks.POLISHED_DRIED_WAX_BUTTON.get(),


                        ModBlocks.WAX_WALL.get(),
                        ModBlocks.POLISHED_WAX_WALL.get(),
                        ModBlocks.WAX_BRICK_WALL.get(),

                        ModBlocks.DRIED_WAX_WALL.get(),
                        ModBlocks.POLISHED_DRIED_WAX_WALL.get(),
                        ModBlocks.DRIED_WAX_BRICK_WALL.get()
                );

        tag(BlockTags.WALLS)
                .add(
                        ModBlocks.WAX_WALL.get(),
                        ModBlocks.POLISHED_WAX_WALL.get(),
                        ModBlocks.WAX_BRICK_WALL.get(),

                        ModBlocks.DRIED_WAX_WALL.get(),
                        ModBlocks.POLISHED_DRIED_WAX_WALL.get(),
                        ModBlocks.DRIED_WAX_BRICK_WALL.get()
                );

        tag(BlockTags.WOODEN_BUTTONS)
                .add(
                        ModBlocks.POLISHED_WAX_BUTTON.get(),

                        ModBlocks.POLISHED_DRIED_WAX_BUTTON.get()
                );

        tag(BlockTags.STAIRS)
                .add(
                        ModBlocks.WAX_STAIRS.get(),
                        ModBlocks.POLISHED_WAX_STAIRS.get(),
                        ModBlocks.WAX_BRICK_STAIRS.get(),

                        ModBlocks.DRIED_WAX_STAIRS.get(),
                        ModBlocks.POLISHED_DRIED_WAX_STAIRS.get(),
                        ModBlocks.DRIED_WAX_BRICK_STAIRS.get()
                );

        tag(BlockTags.SLABS)
                .add(
                        ModBlocks.WAX_SLAB.get(),
                        ModBlocks.POLISHED_WAX_SLAB.get(),
                        ModBlocks.WAX_BRICK_SLAB.get(),

                        ModBlocks.DRIED_WAX_SLAB.get(),
                        ModBlocks.POLISHED_DRIED_WAX_SLAB.get(),
                        ModBlocks.DRIED_WAX_BRICK_SLAB.get()
                );

        tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .remove(
                        ModBlocks.WAX_WALL.get(),
                        ModBlocks.POLISHED_WAX_WALL.get(),
                        ModBlocks.WAX_BRICK_WALL.get(),

                        ModBlocks.DRIED_WAX_WALL.get(),
                        ModBlocks.POLISHED_DRIED_WAX_WALL.get(),
                        ModBlocks.DRIED_WAX_BRICK_WALL.get()
                );
    }
}