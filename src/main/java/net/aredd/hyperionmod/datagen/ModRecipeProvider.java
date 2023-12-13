package net.aredd.hyperionmod.datagen;

import net.aredd.hyperionmod.block.ModBlocks;
import net.aredd.hyperionmod.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.util.Identifier;

import java.util.List;

public class ModRecipeProvider extends FabricRecipeProvider {
    private static final List<ItemConvertible> HYPERIONITE_SMELTABLES = List.of(ModItems.RAW_HYPERIONITE,
            ModBlocks.HYPER_ORE);

    public ModRecipeProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generate(RecipeExporter exporter) {
        offerSmelting(exporter, HYPERIONITE_SMELTABLES, RecipeCategory.MISC, ModItems.HYPERIONITE_INGOT,
                2.0f, 220, "hyperionite");
        offerBlasting(exporter, HYPERIONITE_SMELTABLES, RecipeCategory.MISC, ModItems.HYPERIONITE_INGOT,
                2.0f, 100, "hyperionite");

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.HYPERIONITE_SWORD, 1)
                .pattern("h")
                .pattern("h")
                .pattern("s")
                .input('h', ModItems.HYPERIONITE_INGOT)
                .input('s', Items.STICK)
                .criterion(hasItem(ModItems.HYPERIONITE_INGOT), conditionsFromItem(ModItems.HYPERIONITE_INGOT))
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.HYPERIONITE_SWORD)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.HYPERIONITE_PICKAXE, 1)
                .pattern("hhh")
                .pattern(" s ")
                .pattern(" s ")
                .input('h', ModItems.HYPERIONITE_INGOT)
                .input('s', Items.STICK)
                .criterion(hasItem(ModItems.HYPERIONITE_INGOT), conditionsFromItem(ModItems.HYPERIONITE_INGOT))
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.HYPERIONITE_PICKAXE)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.HYPERIONITE_AXE, 1)
                .pattern(" hh")
                .pattern(" sh")
                .pattern(" s ")
                .input('h', ModItems.HYPERIONITE_INGOT)
                .input('s', Items.STICK)
                .criterion(hasItem(ModItems.HYPERIONITE_INGOT), conditionsFromItem(ModItems.HYPERIONITE_INGOT))
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.HYPERIONITE_AXE)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.HYPERIONITE_SHOVEL, 1)
                .pattern("h")
                .pattern("s")
                .pattern("s")
                .input('h', ModItems.HYPERIONITE_INGOT)
                .input('s', Items.STICK)
                .criterion(hasItem(ModItems.HYPERIONITE_INGOT), conditionsFromItem(ModItems.HYPERIONITE_INGOT))
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.HYPERIONITE_SHOVEL)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.HYPERIONITE_HOE, 1)
                .pattern(" hh")
                .pattern(" s ")
                .pattern(" s ")
                .input('h', ModItems.HYPERIONITE_INGOT)
                .input('s', Items.STICK)
                .criterion(hasItem(ModItems.HYPERIONITE_INGOT), conditionsFromItem(ModItems.HYPERIONITE_INGOT))
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.HYPERIONITE_HOE)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.HYPERIONITE_CHESTPLATE, 1)
                .pattern("h h")
                .pattern("hhh")
                .pattern("hhh")
                .input('h', ModItems.HYPERIONITE_INGOT)
                .criterion(hasItem(ModItems.HYPERIONITE_INGOT), conditionsFromItem(ModItems.HYPERIONITE_INGOT))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.HYPERIONITE_CHESTPLATE)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.HYPERIONITE_LEGGINGS, 1)
                .pattern("hhh")
                .pattern("h h")
                .pattern("h h")
                .input('h', ModItems.HYPERIONITE_INGOT)
                .criterion(hasItem(ModItems.HYPERIONITE_INGOT), conditionsFromItem(ModItems.HYPERIONITE_INGOT))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.HYPERIONITE_LEGGINGS)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.HYPERIONITE_HELMET, 1)
                .pattern("   ")
                .pattern("hhh")
                .pattern("h h")
                .input('h', ModItems.HYPERIONITE_INGOT)
                .criterion(hasItem(ModItems.HYPERIONITE_INGOT), conditionsFromItem(ModItems.HYPERIONITE_INGOT))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.HYPERIONITE_HELMET)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.HYPERIONITE_BOOTS, 1)
                .pattern("   ")
                .pattern("h h")
                .pattern("h h")
                .input('h', ModItems.HYPERIONITE_INGOT)
                .criterion(hasItem(ModItems.HYPERIONITE_INGOT), conditionsFromItem(ModItems.HYPERIONITE_INGOT))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.HYPERIONITE_BOOTS)));
    }
}