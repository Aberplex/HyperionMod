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
                    .icon(() -> new ItemStack(ModItems.RAW_HYPERIONITE)).entries((displayContext, entries) -> {
                        entries.add(ModItems.RAW_HYPERIONITE);
                        entries.add(ModBlocks.HYPER_STONE);
                        entries.add(ModBlocks.HYPER_ORE);
                    }).build());


    public static void registerItemGroups() {
        HyperionMod.LOGGER.info("Registering Item Groups for " + HyperionMod.MOD_ID);
    }
}
