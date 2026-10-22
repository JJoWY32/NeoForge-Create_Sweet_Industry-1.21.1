package net.jjowy.create_sweet_industry.datagen;

import net.jjowy.create_sweet_industry.CreateSweetIndustry;
import net.jjowy.create_sweet_industry.block.ModBlocks;
import net.jjowy.create_sweet_industry.item.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.ItemLike;
import net.neoforged.neoforge.common.conditions.IConditionBuilder;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    @Override
    protected void buildRecipes(RecipeOutput recipeOutput) {
        // Dried honeycomb block
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.DRIED_HONEYCOMB_BLOCK.get(), 1)
                .pattern("##")
                .pattern("##")
                .define('#', ModItems.DRIED_HONEYCOMB.get())
                .unlockedBy("has_dried_honeycomb", has(ModItems.DRIED_HONEYCOMB.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(CreateSweetIndustry.MOD_ID, "dried_honeycomb_block_from_dried_honeycomb"));

        // Beeswax
        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, ModItems.BEESWAX.get(), 4)
                .requires(ModBlocks.WAX_BLOCK)
                .unlockedBy("has_wax_block", has(ModBlocks.WAX_BLOCK)).save(recipeOutput);

        // Dried beeswax.json
        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, ModItems.DRIED_BEESWAX.get(), 4)
                .requires(ModBlocks.DRIED_WAX_BLOCK)
                .unlockedBy("has_dried_wax_block", has(ModBlocks.DRIED_WAX_BLOCK)).save(recipeOutput);

        // Candle
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, Items.CANDLE)
                .define('S', Items.STRING)
                .define('W', ModItems.DRIED_BEESWAX.get())
                .pattern("S")
                .pattern("W")
                .unlockedBy("has_string", has(Items.STRING))
                .unlockedBy("has_dried_beeswax", has(ModItems.DRIED_BEESWAX.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(CreateSweetIndustry.MOD_ID, "candle"));

        // Wax block
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.WAX_BLOCK.get(), 1)
                .pattern("BB")
                .pattern("BB")
                .define('B', ModItems.BEESWAX.get())
                .unlockedBy("has_beeswax", has(ModItems.BEESWAX.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(CreateSweetIndustry.MOD_ID, "wax_block_from_beeswax"));

        // Wax stairs
        stairBuilder(ModBlocks.WAX_STAIRS.get(), Ingredient.of(ModBlocks.WAX_BLOCK)).group("wax_blocks")
                .unlockedBy("has_wax_block", has(ModBlocks.WAX_BLOCK)).save(recipeOutput);

        SingleItemRecipeBuilder.stonecutting(Ingredient.of(ModBlocks.WAX_BLOCK.get()), RecipeCategory.BUILDING_BLOCKS, ModBlocks.WAX_STAIRS.get())
                .unlockedBy("has_wax_block", has(ModBlocks.WAX_BLOCK.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(CreateSweetIndustry.MOD_ID, "wax_stairs_from_wax_block_stonecutting"));

        // Wax slab
        slab(recipeOutput, RecipeCategory.BUILDING_BLOCKS, ModBlocks.WAX_SLAB.get(), ModBlocks.WAX_BLOCK.get());

        SingleItemRecipeBuilder.stonecutting(Ingredient.of(ModBlocks.WAX_BLOCK.get()), RecipeCategory.BUILDING_BLOCKS, ModBlocks.WAX_SLAB.get(), 2)
                .unlockedBy("has_wax_block", has(ModBlocks.WAX_BLOCK.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(CreateSweetIndustry.MOD_ID, "wax_slab_from_wax_block_stonecutting"));

        // Wax wall
        wall(recipeOutput, RecipeCategory.BUILDING_BLOCKS, ModBlocks.WAX_WALL.get(), ModBlocks.WAX_BLOCK.get());

        SingleItemRecipeBuilder.stonecutting(Ingredient.of(ModBlocks.WAX_BLOCK.get()), RecipeCategory.BUILDING_BLOCKS, ModBlocks.WAX_WALL.get())
                .unlockedBy("has_wax_block", has(ModBlocks.WAX_BLOCK.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(CreateSweetIndustry.MOD_ID, "wax_wall_from_wax_block_stonecutting"));

        // Polished wax
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_WAX.get(), 1)
                .pattern("##")
                .pattern("##")
                .define('#', ModBlocks.WAX_BLOCK.get())
                .unlockedBy("has_wax_block", has(ModBlocks.WAX_BLOCK.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(CreateSweetIndustry.MOD_ID, "polished_wax_from_wax_block"));

        SingleItemRecipeBuilder.stonecutting(Ingredient.of(ModBlocks.WAX_BLOCK.get()), RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_WAX.get())
                .unlockedBy("has_polished_wax", has(ModBlocks.WAX_BLOCK.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(CreateSweetIndustry.MOD_ID, "polished_wax_from_wax_block_stonecutting"));

        // Polished wax stairs
        stairBuilder(ModBlocks.POLISHED_WAX_STAIRS.get(), Ingredient.of(ModBlocks.POLISHED_WAX)).group("wax_blocks")
                .unlockedBy("has_polished_wax", has(ModBlocks.POLISHED_WAX)).save(recipeOutput);

        SingleItemRecipeBuilder.stonecutting(Ingredient.of(ModBlocks.WAX_BLOCK.get()), RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_WAX_STAIRS.get())
                .unlockedBy("has_wax_block", has(ModBlocks.WAX_BLOCK.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(CreateSweetIndustry.MOD_ID, "polished_wax_stairs_from_wax_block_stonecutting"));
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(ModBlocks.POLISHED_WAX.get()), RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_WAX_STAIRS.get())
                .unlockedBy("has_polished_wax", has(ModBlocks.POLISHED_WAX.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(CreateSweetIndustry.MOD_ID, "polished_wax_stairs_from_polished_wax_stonecutting"));

        // Polished wax slab
        slab(recipeOutput, RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_WAX_SLAB.get(), ModBlocks.POLISHED_WAX.get());

        SingleItemRecipeBuilder.stonecutting(Ingredient.of(ModBlocks.WAX_BLOCK.get()), RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_WAX_SLAB.get(), 2)
                .unlockedBy("has_wax_block", has(ModBlocks.WAX_BLOCK.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(CreateSweetIndustry.MOD_ID, "polished_wax_slab_from_wax_block_stonecutting"));
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(ModBlocks.POLISHED_WAX.get()), RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_WAX_SLAB.get(), 2)
                .unlockedBy("has_polished_wax", has(ModBlocks.POLISHED_WAX.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(CreateSweetIndustry.MOD_ID, "polished_wax_slab_from_polished_wax_stonecutting"));

        // Polished wax wall
        wall(recipeOutput, RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_WAX_WALL.get(), ModBlocks.POLISHED_WAX.get());

        SingleItemRecipeBuilder.stonecutting(Ingredient.of(ModBlocks.WAX_BLOCK.get()), RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_WAX_WALL.get())
                .unlockedBy("has_wax_block", has(ModBlocks.WAX_BLOCK.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(CreateSweetIndustry.MOD_ID, "polished_wax_wall_from_wax_block_stonecutting"));
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(ModBlocks.POLISHED_WAX.get()), RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_WAX_WALL.get())
                .unlockedBy("has_polished_wax", has(ModBlocks.POLISHED_WAX.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(CreateSweetIndustry.MOD_ID, "polished_wax_wall_from_polished_wax_stonecutting"));

        // Polished wax button
        buttonBuilder(ModBlocks.POLISHED_WAX_BUTTON.get(), Ingredient.of(ModBlocks.POLISHED_WAX.get())).group("wax_blocks")
                .unlockedBy("has_polished_dried_wax", has(ModBlocks.POLISHED_WAX.get())).save(recipeOutput);

        // Wax bricks
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.WAX_BRICKS.get(), 1)
                .pattern("##")
                .pattern("##")
                .define('#', ModBlocks.POLISHED_WAX.get())
                .unlockedBy("has_polished_wax", has(ModBlocks.POLISHED_WAX.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(CreateSweetIndustry.MOD_ID, "wax_bricks_from_polished_wax"));

        SingleItemRecipeBuilder.stonecutting(Ingredient.of(ModBlocks.POLISHED_WAX.get()), RecipeCategory.BUILDING_BLOCKS, ModBlocks.WAX_BRICKS.get())
                .unlockedBy("has_polished_wax", has(ModBlocks.POLISHED_WAX.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(CreateSweetIndustry.MOD_ID, "wax_bricks_from_polished_wax_stonecutting"));
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(ModBlocks.WAX_BLOCK.get()), RecipeCategory.BUILDING_BLOCKS, ModBlocks.WAX_BRICKS.get())
                .unlockedBy("has_wax_block", has(ModBlocks.WAX_BLOCK.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(CreateSweetIndustry.MOD_ID, "wax_bricks_from_wax_block_stonecutting"));

        // Wax brick stairs
        stairBuilder(ModBlocks.WAX_BRICK_STAIRS.get(), Ingredient.of(ModBlocks.WAX_BRICKS)).group("wax_blocks")
                .unlockedBy("has_wax_bricks", has(ModBlocks.WAX_BRICKS)).save(recipeOutput);

        SingleItemRecipeBuilder.stonecutting(Ingredient.of(ModBlocks.WAX_BLOCK.get()), RecipeCategory.BUILDING_BLOCKS, ModBlocks.WAX_BRICK_STAIRS.get())
                .unlockedBy("has_wax_block", has(ModBlocks.WAX_BLOCK.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(CreateSweetIndustry.MOD_ID, "wax_brick_stairs_from_wax_block_stonecutting"));
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(ModBlocks.POLISHED_WAX.get()), RecipeCategory.BUILDING_BLOCKS, ModBlocks.WAX_BRICK_STAIRS.get())
                .unlockedBy("has_polished_wax", has(ModBlocks.POLISHED_WAX.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(CreateSweetIndustry.MOD_ID, "wax_brick_stairs_from_polished_wax_stonecutting"));
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(ModBlocks.WAX_BRICKS.get()), RecipeCategory.BUILDING_BLOCKS, ModBlocks.WAX_BRICK_STAIRS.get())
                .unlockedBy("has_wax_bricks", has(ModBlocks.WAX_BRICKS.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(CreateSweetIndustry.MOD_ID, "wax_brick_stairs_from_wax_bricks_stonecutting"));

        // Wax brick slab
        slab(recipeOutput, RecipeCategory.BUILDING_BLOCKS, ModBlocks.WAX_BRICK_SLAB.get(), ModBlocks.WAX_BRICKS.get());

        SingleItemRecipeBuilder.stonecutting(Ingredient.of(ModBlocks.WAX_BLOCK.get()), RecipeCategory.BUILDING_BLOCKS, ModBlocks.WAX_BRICK_SLAB.get(), 2)
                .unlockedBy("has_wax_block", has(ModBlocks.WAX_BLOCK.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(CreateSweetIndustry.MOD_ID, "wax_brick_slab_from_wax_block_stonecutting"));
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(ModBlocks.POLISHED_WAX.get()), RecipeCategory.BUILDING_BLOCKS, ModBlocks.WAX_BRICK_SLAB.get(), 2)
                .unlockedBy("has_polished_wax", has(ModBlocks.POLISHED_WAX.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(CreateSweetIndustry.MOD_ID, "wax_brick_slab_from_polished_wax_stonecutting"));
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(ModBlocks.WAX_BRICKS.get()), RecipeCategory.BUILDING_BLOCKS, ModBlocks.WAX_BRICK_SLAB.get(), 2)
                .unlockedBy("has_wax_bricks", has(ModBlocks.WAX_BRICKS.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(CreateSweetIndustry.MOD_ID, "wax_brick_slab_from_wax_bricks_stonecutting"));

        // Wax brick wall
        wall(recipeOutput, RecipeCategory.BUILDING_BLOCKS, ModBlocks.WAX_BRICK_WALL.get(), ModBlocks.WAX_BRICKS.get());

        SingleItemRecipeBuilder.stonecutting(Ingredient.of(ModBlocks.WAX_BLOCK.get()), RecipeCategory.BUILDING_BLOCKS, ModBlocks.WAX_BRICK_WALL.get())
                .unlockedBy("has_wax_block", has(ModBlocks.WAX_BLOCK.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(CreateSweetIndustry.MOD_ID, "wax_brick_wall_from_wax_block_stonecutting"));
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(ModBlocks.POLISHED_WAX.get()), RecipeCategory.BUILDING_BLOCKS, ModBlocks.WAX_BRICK_WALL.get())
                .unlockedBy("has_polished_wax", has(ModBlocks.POLISHED_WAX.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(CreateSweetIndustry.MOD_ID, "wax_brick_wall_from_polished_wax_stonecutting"));
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(ModBlocks.WAX_BRICKS.get()), RecipeCategory.BUILDING_BLOCKS, ModBlocks.WAX_BRICK_WALL.get())
                .unlockedBy("has_wax_bricks", has(ModBlocks.WAX_BRICKS.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(CreateSweetIndustry.MOD_ID, "wax_brick_wall_from_wax_bricks_stonecutting"));

        // Wax pillar
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.WAX_PILLAR.get(), 2)
                .pattern("#")
                .pattern("#")
                .define('#', ModBlocks.WAX_BLOCK.get())
                .unlockedBy("has_wax_block", has(ModBlocks.WAX_BLOCK.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(CreateSweetIndustry.MOD_ID, "wax_pillar_from_wax_block"));

        SingleItemRecipeBuilder.stonecutting(Ingredient.of(ModBlocks.WAX_BLOCK.get()), RecipeCategory.BUILDING_BLOCKS, ModBlocks.WAX_PILLAR.get())
                .unlockedBy("has_wax_block", has(ModBlocks.WAX_BLOCK.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(CreateSweetIndustry.MOD_ID, "wax_pillar_from_wax_block_stonecutting"));

        // Dried wax block
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.DRIED_WAX_BLOCK.get(), 1)
                .pattern("##")
                .pattern("##")
                .define('#', ModItems.DRIED_BEESWAX.get())
                .unlockedBy("has_dried_beeswax", has(ModItems.DRIED_BEESWAX.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(CreateSweetIndustry.MOD_ID, "dried_wax_block_from_dried_beeswax"));

        // Dried wax stairs
        stairBuilder(ModBlocks.DRIED_WAX_STAIRS.get(), Ingredient.of(ModBlocks.DRIED_WAX_BLOCK)).group("dried_wax_blocks")
                .unlockedBy("has_dried_wax_block", has(ModBlocks.DRIED_WAX_BLOCK)).save(recipeOutput);

        SingleItemRecipeBuilder.stonecutting(Ingredient.of(ModBlocks.DRIED_WAX_BLOCK.get()), RecipeCategory.BUILDING_BLOCKS, ModBlocks.DRIED_WAX_STAIRS.get())
                .unlockedBy("has_dried_wax_block", has(ModBlocks.DRIED_WAX_BLOCK.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(CreateSweetIndustry.MOD_ID, "dried_wax_stairs_from_dried_wax_block_stonecutting"));

        // Dried wax slab
        slab(recipeOutput, RecipeCategory.BUILDING_BLOCKS, ModBlocks.DRIED_WAX_SLAB.get(), ModBlocks.DRIED_WAX_BLOCK.get());

        SingleItemRecipeBuilder.stonecutting(Ingredient.of(ModBlocks.DRIED_WAX_BLOCK.get()), RecipeCategory.BUILDING_BLOCKS, ModBlocks.DRIED_WAX_SLAB.get(), 2)
                .unlockedBy("has_dried_wax_block", has(ModBlocks.DRIED_WAX_BLOCK.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(CreateSweetIndustry.MOD_ID, "dried_wax_slab_from_dried_wax_block_stonecutting"));

        // Dried wax wall
        wall(recipeOutput, RecipeCategory.BUILDING_BLOCKS, ModBlocks.DRIED_WAX_WALL.get(), ModBlocks.DRIED_WAX_BLOCK.get());

        SingleItemRecipeBuilder.stonecutting(Ingredient.of(ModBlocks.DRIED_WAX_BLOCK.get()), RecipeCategory.BUILDING_BLOCKS, ModBlocks.DRIED_WAX_WALL.get())
                .unlockedBy("has_dried_wax_block", has(ModBlocks.DRIED_WAX_BLOCK.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(CreateSweetIndustry.MOD_ID, "dried_wax_wall_from_dried_wax_block_stonecutting"));

        // Polished dried wax
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_DRIED_WAX.get(), 1)
                .pattern("##")
                .pattern("##")
                .define('#', ModBlocks.DRIED_WAX_BLOCK.get())
                .unlockedBy("has_dried_wax_block", has(ModBlocks.DRIED_WAX_BLOCK.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(CreateSweetIndustry.MOD_ID, "polished_dried_wax_from_dried_wax_block"));

        SingleItemRecipeBuilder.stonecutting(Ingredient.of(ModBlocks.DRIED_WAX_BLOCK.get()), RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_DRIED_WAX.get())
                .unlockedBy("has_polished_dried_wax", has(ModBlocks.DRIED_WAX_BLOCK.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(CreateSweetIndustry.MOD_ID, "polished_dried_wax_from_dried_wax_block_stonecutting"));

        // Polished dried wax stairs
        stairBuilder(ModBlocks.POLISHED_DRIED_WAX_STAIRS.get(), Ingredient.of(ModBlocks.POLISHED_DRIED_WAX)).group("dried_wax_blocks")
                .unlockedBy("has_polished_dried_wax", has(ModBlocks.POLISHED_DRIED_WAX)).save(recipeOutput);

        SingleItemRecipeBuilder.stonecutting(Ingredient.of(ModBlocks.DRIED_WAX_BLOCK.get()), RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_DRIED_WAX_STAIRS.get())
                .unlockedBy("has_dried_wax_block", has(ModBlocks.DRIED_WAX_BLOCK.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(CreateSweetIndustry.MOD_ID, "polished_dried_wax_stairs_from_dried_wax_block_stonecutting"));
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(ModBlocks.POLISHED_DRIED_WAX.get()), RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_DRIED_WAX_STAIRS.get())
                .unlockedBy("has_polished_dried_wax", has(ModBlocks.POLISHED_DRIED_WAX.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(CreateSweetIndustry.MOD_ID, "polished_dried_wax_stairs_from_polished_dried_wax_stonecutting"));

        // Polished dried wax slab
        slab(recipeOutput, RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_DRIED_WAX_SLAB.get(), ModBlocks.POLISHED_DRIED_WAX.get());

        SingleItemRecipeBuilder.stonecutting(Ingredient.of(ModBlocks.DRIED_WAX_BLOCK.get()), RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_DRIED_WAX_SLAB.get(), 2)
                .unlockedBy("has_dried_wax_block", has(ModBlocks.DRIED_WAX_BLOCK.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(CreateSweetIndustry.MOD_ID, "polished_dried_wax_slab_from_dried_wax_block_stonecutting"));
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(ModBlocks.POLISHED_DRIED_WAX.get()), RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_DRIED_WAX_SLAB.get(), 2)
                .unlockedBy("has_polished_dried_wax", has(ModBlocks.POLISHED_DRIED_WAX.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(CreateSweetIndustry.MOD_ID, "polished_dried_wax_slab_from_polished_dried_wax_stonecutting"));

        // Polished dried wax wall
        wall(recipeOutput, RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_DRIED_WAX_WALL.get(), ModBlocks.POLISHED_DRIED_WAX.get());

        SingleItemRecipeBuilder.stonecutting(Ingredient.of(ModBlocks.DRIED_WAX_BLOCK.get()), RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_DRIED_WAX_WALL.get())
                .unlockedBy("has_dried_wax_block", has(ModBlocks.DRIED_WAX_BLOCK.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(CreateSweetIndustry.MOD_ID, "polished_dried_wax_wall_from_dried_wax_block_stonecutting"));
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(ModBlocks.POLISHED_DRIED_WAX.get()), RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_DRIED_WAX_WALL.get())
                .unlockedBy("has_polished_dried_wax", has(ModBlocks.POLISHED_DRIED_WAX.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(CreateSweetIndustry.MOD_ID, "polished_dried_wax_wall_from_polished_dried_wax_stonecutting"));

        // Polished dried wax button
        buttonBuilder(ModBlocks.POLISHED_DRIED_WAX_BUTTON.get(), Ingredient.of(ModBlocks.POLISHED_DRIED_WAX.get())).group("dried_wax_blocks")
                .unlockedBy("has_polished_dried_wax", has(ModBlocks.POLISHED_DRIED_WAX.get())).save(recipeOutput);

        // Dried wax bricks
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.DRIED_WAX_BRICKS.get(), 1)
                .pattern("##")
                .pattern("##")
                .define('#', ModBlocks.POLISHED_DRIED_WAX.get())
                .unlockedBy("has_polished_dried_wax", has(ModBlocks.POLISHED_DRIED_WAX.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(CreateSweetIndustry.MOD_ID, "dried_wax_bricks_from_polished_dried_wax"));

        SingleItemRecipeBuilder.stonecutting(Ingredient.of(ModBlocks.POLISHED_DRIED_WAX.get()), RecipeCategory.BUILDING_BLOCKS, ModBlocks.DRIED_WAX_BRICKS.get())
                .unlockedBy("has_polished_dried_wax", has(ModBlocks.POLISHED_DRIED_WAX.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(CreateSweetIndustry.MOD_ID, "dried_wax_bricks_from_polished_dried_wax_stonecutting"));
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(ModBlocks.DRIED_WAX_BLOCK.get()), RecipeCategory.BUILDING_BLOCKS, ModBlocks.DRIED_WAX_BRICKS.get())
                .unlockedBy("has_dried_wax_block", has(ModBlocks.DRIED_WAX_BLOCK.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(CreateSweetIndustry.MOD_ID, "dried_wax_bricks_from_dried_wax_block_stonecutting"));

        // Dried wax brick stairs
        stairBuilder(ModBlocks.DRIED_WAX_BRICK_STAIRS.get(), Ingredient.of(ModBlocks.DRIED_WAX_BRICKS)).group("dried_wax_blocks")
                .unlockedBy("has_dried_wax_bricks", has(ModBlocks.DRIED_WAX_BRICKS)).save(recipeOutput);

        SingleItemRecipeBuilder.stonecutting(Ingredient.of(ModBlocks.DRIED_WAX_BLOCK.get()), RecipeCategory.BUILDING_BLOCKS, ModBlocks.DRIED_WAX_BRICK_STAIRS.get())
                .unlockedBy("has_dried_wax_block", has(ModBlocks.DRIED_WAX_BLOCK.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(CreateSweetIndustry.MOD_ID, "dried_wax_brick_stairs_from_dried_wax_block_stonecutting"));
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(ModBlocks.POLISHED_DRIED_WAX.get()), RecipeCategory.BUILDING_BLOCKS, ModBlocks.DRIED_WAX_BRICK_STAIRS.get())
                .unlockedBy("has_polished_dried_wax", has(ModBlocks.POLISHED_DRIED_WAX.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(CreateSweetIndustry.MOD_ID, "dried_wax_brick_stairs_from_polished_dried_wax_stonecutting"));
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(ModBlocks.DRIED_WAX_BRICKS.get()), RecipeCategory.BUILDING_BLOCKS, ModBlocks.DRIED_WAX_BRICK_STAIRS.get())
                .unlockedBy("has_dried_wax_bricks", has(ModBlocks.DRIED_WAX_BRICKS.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(CreateSweetIndustry.MOD_ID, "dried_wax_brick_stairs_from_dried_wax_bricks_stonecutting"));

        // Dried wax brick slab
        slab(recipeOutput, RecipeCategory.BUILDING_BLOCKS, ModBlocks.DRIED_WAX_BRICK_SLAB.get(), ModBlocks.DRIED_WAX_BRICKS.get());

        SingleItemRecipeBuilder.stonecutting(Ingredient.of(ModBlocks.DRIED_WAX_BLOCK.get()), RecipeCategory.BUILDING_BLOCKS, ModBlocks.DRIED_WAX_BRICK_SLAB.get(), 2)
                .unlockedBy("has_dried_wax_block", has(ModBlocks.DRIED_WAX_BLOCK.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(CreateSweetIndustry.MOD_ID, "dried_wax_brick_slab_from_dried_wax_block_stonecutting"));
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(ModBlocks.POLISHED_DRIED_WAX.get()), RecipeCategory.BUILDING_BLOCKS, ModBlocks.DRIED_WAX_BRICK_SLAB.get(), 2)
                .unlockedBy("has_polished_dried_wax", has(ModBlocks.POLISHED_DRIED_WAX.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(CreateSweetIndustry.MOD_ID, "dried_wax_brick_slab_from_polished_dried_wax_stonecutting"));
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(ModBlocks.DRIED_WAX_BRICKS.get()), RecipeCategory.BUILDING_BLOCKS, ModBlocks.DRIED_WAX_BRICK_SLAB.get(), 2)
                .unlockedBy("has_dried_wax_bricks", has(ModBlocks.DRIED_WAX_BRICKS.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(CreateSweetIndustry.MOD_ID, "dried_wax_brick_slab_from_dried_wax_bricks_stonecutting"));

        // Dried wax brick wall
        wall(recipeOutput, RecipeCategory.BUILDING_BLOCKS, ModBlocks.DRIED_WAX_BRICK_WALL.get(), ModBlocks.DRIED_WAX_BRICKS.get());

        SingleItemRecipeBuilder.stonecutting(Ingredient.of(ModBlocks.DRIED_WAX_BLOCK.get()), RecipeCategory.BUILDING_BLOCKS, ModBlocks.DRIED_WAX_BRICK_WALL.get())
                .unlockedBy("has_dried_wax_block", has(ModBlocks.DRIED_WAX_BLOCK.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(CreateSweetIndustry.MOD_ID, "dried_wax_brick_wall_from_dried_wax_block_stonecutting"));
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(ModBlocks.POLISHED_DRIED_WAX.get()), RecipeCategory.BUILDING_BLOCKS, ModBlocks.DRIED_WAX_BRICK_WALL.get())
                .unlockedBy("has_polished_dried_wax", has(ModBlocks.POLISHED_DRIED_WAX.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(CreateSweetIndustry.MOD_ID, "dried_wax_brick_wall_from_polished_dried_wax_stonecutting"));
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(ModBlocks.DRIED_WAX_BRICKS.get()), RecipeCategory.BUILDING_BLOCKS, ModBlocks.DRIED_WAX_BRICK_WALL.get())
                .unlockedBy("has_dried_wax_bricks", has(ModBlocks.DRIED_WAX_BRICKS.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(CreateSweetIndustry.MOD_ID, "dried_wax_brick_wall_from_dried_wax_bricks_stonecutting"));

        // Dried wax pillar
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.DRIED_WAX_PILLAR.get(), 2)
                .pattern("#")
                .pattern("#")
                .define('#', ModBlocks.DRIED_WAX_BLOCK.get())
                .unlockedBy("has_dried_wax_block", has(ModBlocks.DRIED_WAX_BLOCK.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(CreateSweetIndustry.MOD_ID, "dried_wax_pillar_from_dried_wax_block"));

        SingleItemRecipeBuilder.stonecutting(Ingredient.of(ModBlocks.DRIED_WAX_BLOCK.get()), RecipeCategory.BUILDING_BLOCKS, ModBlocks.DRIED_WAX_PILLAR.get())
                .unlockedBy("has_dried_wax_block", has(ModBlocks.DRIED_WAX_BLOCK.get()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(CreateSweetIndustry.MOD_ID, "dried_wax_pillar_from_dried_wax_block_stonecutting"));

























        /*
        doorBuilder(ModBlocks.BISMUTH_DOOR.get(), Ingredient.of(ModItems.BISMUTH.get())).group("bismuth")
                .unlockedBy("has_bismuth", has(ModItems.BISMUTH.get())).save(recipeOutput);
        trapdoorBuilder(ModBlocks.BISMUTH_TRAPDOOR.get(), Ingredient.of(ModItems.BISMUTH.get())).group("bismuth")
                .unlockedBy("has_bismuth", has(ModItems.BISMUTH.get())).save(recipeOutput);

         */
    }

    protected static void oreSmelting(RecipeOutput recipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult,
                                      float pExperience, int pCookingTIme, String pGroup) {
        oreCooking(recipeOutput, RecipeSerializer.SMELTING_RECIPE, SmeltingRecipe::new, pIngredients, pCategory, pResult,
                pExperience, pCookingTIme, pGroup, "_from_smelting");
    }

    protected static void oreBlasting(RecipeOutput recipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult,
                                      float pExperience, int pCookingTime, String pGroup) {
        oreCooking(recipeOutput, RecipeSerializer.BLASTING_RECIPE, BlastingRecipe::new, pIngredients, pCategory, pResult,
                pExperience, pCookingTime, pGroup, "_from_blasting");
    }

    protected static <T extends AbstractCookingRecipe> void oreCooking(RecipeOutput recipeOutput, RecipeSerializer<T> pCookingSerializer, AbstractCookingRecipe.Factory<T> factory,
                                                                       List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup, String pRecipeName) {
        for(ItemLike itemlike : pIngredients) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike), pCategory, pResult, pExperience, pCookingTime, pCookingSerializer, factory).group(pGroup).unlockedBy(getHasName(itemlike), has(itemlike))
                    .save(recipeOutput, CreateSweetIndustry.MOD_ID + ":" + getItemName(pResult) + pRecipeName + "_" + getItemName(itemlike));
        }
    }
}