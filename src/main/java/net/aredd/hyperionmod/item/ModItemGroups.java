package net.aredd.hyperionmod.item;

import net.aredd.hyperionmod.HyperionMod;
import net.aredd.hyperionmod.block.ModBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {
    public static final ItemGroup HYPER_GROUP = Registry.register(Registries.ITEM_GROUP, new Identifier(HyperionMod.MOD_ID, "hyperionite"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.hyperionite"))
                    .icon(() -> new ItemStack(ModItems.HYPERIONITE_INGOT)).entries((displayContext, entries) -> {
                        entries.add(ModItems.RAW_HYPERIONITE);
                        entries.add(ModItems.HYPERIONITE_INGOT);

                        entries.add(ModItems.HYPERIONITE_SWORD);
                        entries.add(ModItems.HYPERIONITE_PICKAXE);
                        entries.add(ModItems.HYPERIONITE_SHOVEL);
                        entries.add(ModItems.HYPERIONITE_AXE);
                        entries.add(ModItems.HYPERIONITE_HOE);

                        entries.add(ModItems.HYPERIONITE_HELMET);
                        entries.add(ModItems.HYPERIONITE_CHESTPLATE);
                        entries.add(ModItems.HYPERIONITE_LEGGINGS);
                        entries.add(ModItems.HYPERIONITE_BOOTS);

                        entries.add(ModBlocks.HYPER_STONE);
                        entries.add(ModBlocks.HYPER_ORE);

                        entries.add(ModItems.HYPER_BERRY);

                    }).build());


    public static void registerItemGroups() {
        HyperionMod.LOGGER.info("Registering Item Groups for " + HyperionMod.MOD_ID);
    }
}
