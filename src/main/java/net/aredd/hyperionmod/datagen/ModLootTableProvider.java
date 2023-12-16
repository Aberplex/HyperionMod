package net.aredd.hyperionmod.datagen;


import net.aredd.hyperionmod.block.ModBlocks;
import net.aredd.hyperionmod.block.custom.HyperCropBlock;
import net.aredd.hyperionmod.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.NetherWartBlock;
import net.minecraft.data.server.loottable.BlockLootTableGenerator;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.condition.BlockStatePropertyLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.entry.LeafEntry;
import net.minecraft.loot.entry.LootPoolEntry;
import net.minecraft.loot.function.ApplyBonusLootFunction;
import net.minecraft.loot.function.LootFunction;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.predicate.StatePredicate;

public class ModLootTableProvider extends FabricBlockLootTableProvider {
    public ModLootTableProvider(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    @Override
    public void generate() {
        addDrop(ModBlocks.HYPER_STONE);
        addDrop(ModBlocks.HYPER_ORE, HyperioniteOreDrops(ModBlocks.HYPER_ORE, ModItems.RAW_HYPERIONITE));

        this.addDrop(ModBlocks.HYPER_BERRY_BUSH, (Block block) -> LootTable.builder().pool(this.applyExplosionDecay((ItemConvertible)block, LootPool.builder().rolls(ConstantLootNumberProvider.create(1.0f)).with((LootPoolEntry.Builder<?>)((Object)((LeafEntry.Builder)ItemEntry.builder(ModItems.HYPER_BERRY).apply((LootFunction.Builder)((Object)SetCountLootFunction.builder(UniformLootNumberProvider.create(2.0f, 4.0f)).conditionally(BlockStatePropertyLootCondition.builder(block).properties(StatePredicate.Builder.create()
                .exactMatch(HyperCropBlock.AGE, 1)))))).apply((LootFunction.Builder)((Object)ApplyBonusLootFunction.uniformBonusCount(Enchantments.FORTUNE).conditionally(BlockStatePropertyLootCondition.builder(block).properties(StatePredicate.Builder.create().exactMatch(HyperCropBlock.AGE, 0))))))))));
    }

    public LootTable.Builder HyperioniteOreDrops(Block drop, Item item) {
        return BlockLootTableGenerator.dropsWithSilkTouch(drop, (LootPoolEntry.Builder)this.applyExplosionDecay(drop,
                ((LeafEntry.Builder)
                        ItemEntry.builder(item)
                                .apply(SetCountLootFunction
                                        .builder(UniformLootNumberProvider
                                                .create(1.0f, 1.0f))))
                        .apply(ApplyBonusLootFunction.oreDrops(Enchantments.FORTUNE))));
    }
}
