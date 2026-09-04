package com.benbenlaw.modpackutils.util;

import com.benbenlaw.modpackutils.ModpackUtils;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.material.Fluid;

public class MUTags {

    public static class Blocks {

        public static final TagKey<Block> NETHER_PORTAL_FRAME = tag(ModpackUtils.MOD_ID, "nether_portal_frame");
        public static final TagKey<Block> CLIMBABLE_BLOCKS = tag(ModpackUtils.MOD_ID,"climbable_blocks");
        public static final TagKey<Block> BANNED_FROM_COLORING = tag(ModpackUtils.MOD_ID,"banned_from_coloring");

        public static TagKey<Block> tag(String modName, String name) {
            return BlockTags.create(Identifier.fromNamespaceAndPath(modName, name));
        }
    }

    public static class Items {
        public static final TagKey<Item> NETHER_PORTAL_FRAME = tag(ModpackUtils.MOD_ID,"nether_portal_frame");
        public static final TagKey<Item> BANNED_FROM_COLORING = tag(ModpackUtils.MOD_ID,"banned_from_coloring");

        public static TagKey<Item> tag(String modName, String name) {
            return ItemTags.create(Identifier.fromNamespaceAndPath(modName, name));
        }
    }

    public static class Entity {
        public static final TagKey<EntityType<?>> LEASHABLE = tag(ModpackUtils.MOD_ID,"leashable");

        public static TagKey<EntityType<?>> tag(String modName, String name) {
            return TagKey.create(Registries.ENTITY_TYPE, Identifier.fromNamespaceAndPath(modName, name));
        }
    }
}
