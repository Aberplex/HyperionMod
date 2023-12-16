package net.aredd.hyperionmod.block;

import net.aredd.hyperionmod.HyperionMod;
import net.aredd.hyperionmod.block.custom.HyperCropBlock;
import net.aredd.hyperionmod.item.ModItems;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.MapColor;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModBlocks {

    public static final Block HYPER_STONE = registerBlock("hyper_stone",
            new Block(FabricBlockSettings.copyOf(Blocks.END_STONE).mapColor(MapColor.PALE_PURPLE)));
    public static final Block HYPER_ORE = registerBlock("hyper_ore",
            new Block(FabricBlockSettings.copyOf(Blocks.DIAMOND_ORE).mapColor(MapColor.PURPLE).strength(35.0f, 2000.0f)));

    public static final Block HYPER_BERRY_BUSH = Registry.register(Registries.BLOCK,
            new Identifier(HyperionMod.MOD_ID, "hyper_berry_bush"), new HyperCropBlock(FabricBlockSettings.copyOf(Blocks.NETHER_WART).nonOpaque()));

    private static Block registerBlock(String name, Block block)  {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(HyperionMod.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block) {
        return Registry.register(Registries.ITEM, new Identifier(HyperionMod.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings()));
    }

    public static void registerModBlocks() {
        HyperionMod.LOGGER.info("Registering Mod Blocks for " + HyperionMod.MOD_ID);
    }
}
