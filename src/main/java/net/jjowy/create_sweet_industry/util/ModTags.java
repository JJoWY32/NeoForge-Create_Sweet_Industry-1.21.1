package net.jjowy.create_sweet_industry.util;

import net.jjowy.create_sweet_industry.CreateSweetIndustry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class ModTags {
    public static class Blocks {

        private static TagKey<Block> createTag(String name) {
            return BlockTags.create(ResourceLocation.fromNamespaceAndPath(CreateSweetIndustry.MOD_ID, name));
        }
    }

    public static class Items {

    }
}
