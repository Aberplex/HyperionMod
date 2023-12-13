package net.aredd.hyperionmod.datagen;

import net.aredd.hyperionmod.block.ModBlocks;
import net.aredd.hyperionmod.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;
import net.minecraft.item.ArmorItem;

public class    ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.HYPER_STONE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.HYPER_ORE);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.RAW_HYPERIONITE, Models.GENERATED);
        itemModelGenerator.register(ModItems.HYPERIONITE_INGOT, Models.GENERATED);

        itemModelGenerator.register(ModItems.HYPERIONITE_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.HYPERIONITE_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.HYPERIONITE_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.HYPERIONITE_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.HYPERIONITE_HOE, Models.HANDHELD);

        itemModelGenerator.registerArmor((ArmorItem) ModItems.HYPERIONITE_HELMET);
        itemModelGenerator.registerArmor((ArmorItem) ModItems.HYPERIONITE_CHESTPLATE);
        itemModelGenerator.registerArmor((ArmorItem) ModItems.HYPERIONITE_LEGGINGS);
        itemModelGenerator.registerArmor((ArmorItem) ModItems.HYPERIONITE_BOOTS);
    }
}
