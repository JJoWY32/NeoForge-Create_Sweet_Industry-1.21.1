package net.jjowy.create_sweet_industry.datagen;

import net.jjowy.create_sweet_industry.CreateSweetIndustry;
import net.jjowy.create_sweet_industry.block.ModBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, CreateSweetIndustry.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(ModBlocks.DRIED_HONEYCOMB_BLOCK);

        blockWithItem(ModBlocks.WAX_BLOCK);
        blockWithItem(ModBlocks.POLISHED_WAX);
        blockWithItem(ModBlocks.WAX_BRICKS);

        ResourceLocation wax_pillar_side = modLoc("block/wax_pillar_side");
        ResourceLocation wax_pillar_end = modLoc("block/wax_pillar_end");

        axisBlock((RotatedPillarBlock) ModBlocks.WAX_PILLAR.get());
        simpleBlockItem(ModBlocks.WAX_PILLAR.get(), models().cubeColumn("wax_pillar", wax_pillar_side, wax_pillar_end));


        blockWithItem(ModBlocks.DRIED_WAX_BLOCK);
        blockWithItem(ModBlocks.POLISHED_DRIED_WAX);
        blockWithItem(ModBlocks.DRIED_WAX_BRICKS);

        ResourceLocation dried_wax_pillar_side = modLoc("block/dried_wax_pillar_side");
        ResourceLocation dried_wax_pillar_end = modLoc("block/dried_wax_pillar_end");
        axisBlock((RotatedPillarBlock) ModBlocks.DRIED_WAX_PILLAR.get());
        simpleBlockItem(ModBlocks.DRIED_WAX_PILLAR.get(), models().cubeColumn("dried_wax_pillar", dried_wax_pillar_side, dried_wax_pillar_end));


        stairsBlock(ModBlocks.WAX_STAIRS.get(), blockTexture(ModBlocks.WAX_BLOCK.get()));
        slabBlock(ModBlocks.WAX_SLAB.get(), blockTexture(ModBlocks.WAX_BLOCK.get()), blockTexture(ModBlocks.WAX_BLOCK.get()));
        stairsBlock(ModBlocks.POLISHED_WAX_STAIRS.get(), blockTexture(ModBlocks.POLISHED_WAX.get()));
        slabBlock(ModBlocks.POLISHED_WAX_SLAB.get(), blockTexture(ModBlocks.POLISHED_WAX.get()), blockTexture(ModBlocks.POLISHED_WAX.get()));
        stairsBlock(ModBlocks.WAX_BRICK_STAIRS.get(), blockTexture(ModBlocks.WAX_BRICKS.get()));
        slabBlock(ModBlocks.WAX_BRICK_SLAB.get(), blockTexture(ModBlocks.WAX_BRICKS.get()), blockTexture(ModBlocks.WAX_BRICKS.get()));

        stairsBlock(ModBlocks.DRIED_WAX_STAIRS.get(), blockTexture(ModBlocks.DRIED_WAX_BLOCK.get()));
        slabBlock(ModBlocks.DRIED_WAX_SLAB.get(), blockTexture(ModBlocks.DRIED_WAX_BLOCK.get()), blockTexture(ModBlocks.DRIED_WAX_BLOCK.get()));
        stairsBlock(ModBlocks.POLISHED_DRIED_WAX_STAIRS.get(), blockTexture(ModBlocks.POLISHED_DRIED_WAX.get()));
        slabBlock(ModBlocks.POLISHED_DRIED_WAX_SLAB.get(), blockTexture(ModBlocks.POLISHED_DRIED_WAX.get()), blockTexture(ModBlocks.POLISHED_DRIED_WAX.get()));
        stairsBlock(ModBlocks.DRIED_WAX_BRICK_STAIRS.get(), blockTexture(ModBlocks.DRIED_WAX_BRICKS.get()));
        slabBlock(ModBlocks.DRIED_WAX_BRICK_SLAB.get(), blockTexture(ModBlocks.DRIED_WAX_BRICKS.get()), blockTexture(ModBlocks.DRIED_WAX_BRICKS.get()));


        buttonBlock(ModBlocks.POLISHED_WAX_BUTTON.get(), blockTexture(ModBlocks.POLISHED_WAX.get()));

        buttonBlock(ModBlocks.POLISHED_DRIED_WAX_BUTTON.get(), blockTexture(ModBlocks.POLISHED_DRIED_WAX.get()));


        wallBlock(ModBlocks.WAX_WALL.get(), blockTexture(ModBlocks.WAX_BLOCK.get()));
        wallBlock(ModBlocks.POLISHED_WAX_WALL.get(), blockTexture(ModBlocks.POLISHED_WAX.get()));
        wallBlock(ModBlocks.WAX_BRICK_WALL.get(), blockTexture(ModBlocks.WAX_BRICKS.get()));

        wallBlock(ModBlocks.DRIED_WAX_WALL.get(), blockTexture(ModBlocks.DRIED_WAX_BLOCK.get()));
        wallBlock(ModBlocks.POLISHED_DRIED_WAX_WALL.get(), blockTexture(ModBlocks.POLISHED_DRIED_WAX.get()));
        wallBlock(ModBlocks.DRIED_WAX_BRICK_WALL.get(), blockTexture(ModBlocks.DRIED_WAX_BRICKS.get()));


        /*
        doorBlockWithRenderType(ModBlocks.BISMUTH_DOOR.get(), modLoc("block/bismuth_door_bottom"), modLoc("block/bismuth_door_top"), "cutout");
        trapdoorBlockWithRenderType(ModBlocks.BISMUTH_TRAPDOOR.get(), modLoc("block/bismuth_trapdoor"), true, "cutout");
         */


        blockItem(ModBlocks.WAX_STAIRS);
        blockItem(ModBlocks.WAX_SLAB);
        blockItem(ModBlocks.POLISHED_WAX_STAIRS);
        blockItem(ModBlocks.POLISHED_WAX_SLAB);
        blockItem(ModBlocks.WAX_BRICK_STAIRS);
        blockItem(ModBlocks.WAX_BRICK_SLAB);

        blockItem(ModBlocks.DRIED_WAX_STAIRS);
        blockItem(ModBlocks.DRIED_WAX_SLAB);
        blockItem(ModBlocks.POLISHED_DRIED_WAX_STAIRS);
        blockItem(ModBlocks.POLISHED_DRIED_WAX_SLAB);
        blockItem(ModBlocks.DRIED_WAX_BRICK_STAIRS);
        blockItem(ModBlocks.DRIED_WAX_BRICK_SLAB);



        // blockItem(ModBlocks.HONEYCOMB_TRAPDOOR, "_bottom");
    }


    private void blockWithItem(DeferredBlock<?> deferredBlock) {
        simpleBlockWithItem(deferredBlock.get(), cubeAll(deferredBlock.get()));
    }

    private void blockItem(DeferredBlock<?> deferredBlock) {
        simpleBlockItem(deferredBlock.get(), new ModelFile.UncheckedModelFile("create_sweet_industry:block/" + deferredBlock.getId().getPath()));
    }

    private void blockItem(DeferredBlock<?> deferredBlock, String appendix) {
        simpleBlockItem(deferredBlock.get(), new ModelFile.UncheckedModelFile("create_sweet_industry:block/" + deferredBlock.getId().getPath() + appendix));
    }
}