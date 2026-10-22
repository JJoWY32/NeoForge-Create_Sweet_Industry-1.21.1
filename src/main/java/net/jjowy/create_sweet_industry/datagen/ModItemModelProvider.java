package net.jjowy.create_sweet_industry.datagen;

import net.jjowy.create_sweet_industry.CreateSweetIndustry;
import net.jjowy.create_sweet_industry.block.ModBlocks;
import net.jjowy.create_sweet_industry.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.client.model.generators.ItemModelBuilder;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, CreateSweetIndustry.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        basicItem(ModItems.BEESWAX.get());
        basicItem(ModItems.DRIED_BEESWAX.get());
        basicItem(ModItems.DRIED_HONEYCOMB.get());

        basicItem(ModItems.BAR_OF_HONEY.get());
        basicItem(ModItems.ROYAL_JELLY_BOTTLE.get());

        buttonItem(ModBlocks.POLISHED_WAX_BUTTON, ModBlocks.POLISHED_WAX);
        buttonItem(ModBlocks.POLISHED_DRIED_WAX_BUTTON, ModBlocks.POLISHED_DRIED_WAX);

        wallItem(ModBlocks.WAX_WALL, ModBlocks.WAX_BLOCK);
        wallItem(ModBlocks.POLISHED_WAX_WALL, ModBlocks.POLISHED_WAX);
        wallItem(ModBlocks.WAX_BRICK_WALL, ModBlocks.WAX_BRICKS);
        wallItem(ModBlocks.DRIED_WAX_WALL, ModBlocks.DRIED_WAX_BLOCK);
        wallItem(ModBlocks.POLISHED_DRIED_WAX_WALL, ModBlocks.POLISHED_DRIED_WAX);
        wallItem(ModBlocks.DRIED_WAX_BRICK_WALL, ModBlocks.DRIED_WAX_BRICKS);

        //basicItem(ModBlocks.BISMUTH_DOOR.asItem());
    }

    public void buttonItem(DeferredBlock<?> block, DeferredBlock<Block> baseBlock) {
        this.withExistingParent(block.getId().getPath(), mcLoc("block/button_inventory"))
                .texture("texture",  ResourceLocation.fromNamespaceAndPath(CreateSweetIndustry.MOD_ID,
                        "block/" + baseBlock.getId().getPath()));
    }

    public void wallItem(DeferredBlock<?> block, DeferredBlock<Block> baseBlock) {
        this.withExistingParent(block.getId().getPath(), mcLoc("block/wall_inventory"))
                .texture("wall",  ResourceLocation.fromNamespaceAndPath(CreateSweetIndustry.MOD_ID,
                        "block/" + baseBlock.getId().getPath()));
    }

    private ItemModelBuilder handheldItem(DeferredItem<?> item) {
        return withExistingParent(item.getId().getPath(),
                ResourceLocation.parse("item/handheld")).texture("layer0",
                ResourceLocation.fromNamespaceAndPath(CreateSweetIndustry.MOD_ID,"item/" + item.getId().getPath()));
    }
}