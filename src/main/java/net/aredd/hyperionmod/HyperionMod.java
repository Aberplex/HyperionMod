package net.aredd.hyperionmod;

import net.aredd.hyperionmod.block.ModBlocks;
import net.aredd.hyperionmod.entity.ModEntities;
import net.aredd.hyperionmod.entity.custom.HyperionSpiritEntity;
import net.aredd.hyperionmod.item.ModItemGroups;
import net.aredd.hyperionmod.item.ModItems;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class  HyperionMod implements ModInitializer {
	public static final String MOD_ID = "hyperionmod";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		FabricDefaultAttributeRegistry.register(ModEntities.HYPERION_SPIRIT, HyperionSpiritEntity.createHyperionSpiritAttributes());

		ModItemGroups.registerItemGroups();

		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
	}
}