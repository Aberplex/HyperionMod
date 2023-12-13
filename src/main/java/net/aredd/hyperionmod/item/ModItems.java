package net.aredd.hyperionmod.item;

import net.aredd.hyperionmod.HyperionMod;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final Item RAW_HYPERIONITE = registerItem("raw_hyperionite", new Item(new FabricItemSettings()));
    public static final Item HYPERIONITE_INGOT = registerItem("hyperionite_ingot", new Item(new FabricItemSettings()));

    public static final Item HYPERIONITE_SWORD = registerItem("hyperionite_sword",
            new SwordItem(ModToolMaterial.HYPERION_TOOLS, 11, -2.4f, new FabricItemSettings()));
    public static final Item HYPERIONITE_PICKAXE = registerItem("hyperionite_pickaxe",
            new PickaxeItem(ModToolMaterial.HYPERION_TOOLS, 7, -2.8f, new FabricItemSettings()));
    public static final Item HYPERIONITE_AXE = registerItem("hyperionite_axe",
            new AxeItem(ModToolMaterial.HYPERION_TOOLS, 15, -3f, new FabricItemSettings()));
    public static final Item HYPERIONITE_SHOVEL = registerItem("hyperionite_shovel",
            new ShovelItem(ModToolMaterial.HYPERION_TOOLS, 7, -3.0f, new FabricItemSettings()));
    public static final Item HYPERIONITE_HOE = registerItem("hyperionite_hoe",
            new HoeItem(ModToolMaterial.HYPERION_TOOLS, 0, 0, new FabricItemSettings()));

    public static final Item HYPERIONITE_HELMET = registerItem("hyperionite_helmet",
            new ArmorItem(ModArmorMaterials.HYPERIONITE, ArmorItem.Type.HELMET, new FabricItemSettings()));
    public static final Item HYPERIONITE_CHESTPLATE = registerItem("hyperionite_chestplate",
            new ArmorItem(ModArmorMaterials.HYPERIONITE, ArmorItem.Type.CHESTPLATE, new FabricItemSettings()));
    public static final Item HYPERIONITE_LEGGINGS = registerItem("hyperionite_leggings",
            new ArmorItem(ModArmorMaterials.HYPERIONITE, ArmorItem.Type.LEGGINGS, new FabricItemSettings()));
    public static final Item HYPERIONITE_BOOTS = registerItem("hyperionite_boots",
            new ArmorItem(ModArmorMaterials.HYPERIONITE, ArmorItem.Type.BOOTS, new FabricItemSettings()));

    private static void addItemstoIngredientItemGroup(FabricItemGroupEntries entries) {
        entries.add(RAW_HYPERIONITE);
        entries.add(HYPERIONITE_INGOT);
    }
    private static void addItemstoCombatItemGroup(FabricItemGroupEntries entries) {
        entries.add(HYPERIONITE_SWORD);
        entries.add(HYPERIONITE_HELMET);
        entries.add(HYPERIONITE_CHESTPLATE);
        entries.add(HYPERIONITE_LEGGINGS);
        entries.add(HYPERIONITE_BOOTS);
    }
    private static void addItemstoToolItemGroup(FabricItemGroupEntries entries) {
        entries.add(HYPERIONITE_SHOVEL);
        entries.add(HYPERIONITE_AXE);
        entries.add(HYPERIONITE_PICKAXE);
        entries.add(HYPERIONITE_HOE);
    }


    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(HyperionMod.MOD_ID, name), item);
    }

    public static void registerModItems() {
        HyperionMod.LOGGER.info("Registering Mod items for " + HyperionMod.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItems::addItemstoIngredientItemGroup);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(ModItems::addItemstoCombatItemGroup);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register(ModItems::addItemstoToolItemGroup);
    }
}