package org.ecnumc.ecnu;

import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.event.entity.SpawnPlacementRegisterEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.ecnumc.ecnu.common.ECNUContent;
import org.ecnumc.ecnu.common.entities.HaibaoEntity;
import org.ecnumc.ecnu.common.registries.ECNUEntityTypes;

/**
 * Mod Main Class
 * @author liudongyu
 */
@SuppressWarnings("java:S1118")
@Mod(ECNUForge.MODID)
public class ECNUForge {
	public static final String MODID = "ecnu";

	public static final Logger LOGGER = LogManager.getLogger(MODID);

	public ECNUForge() {
		IEventBus modBus = FMLJavaModLoadingContext.get().getModEventBus();
		ECNUContent.modConstruction(modBus);

		modBus.addListener(ECNUForge::onCommonSetup);
		modBus.addListener(ECNUForge::onAttributeCreate);
		modBus.addListener(ECNUForge::onSpawnPlacementRegister);
	}

	public static void onCommonSetup(FMLCommonSetupEvent event) {
	}

	public static void onAttributeCreate(EntityAttributeCreationEvent event) {
		event.put(ECNUEntityTypes.HAIBAO.get(), HaibaoEntity.createAttributes().build());
	}

	public static void onSpawnPlacementRegister(SpawnPlacementRegisterEvent event) {
		event.register(
				ECNUEntityTypes.HAIBAO.get(),
				SpawnPlacements.Type.ON_GROUND,
				Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
				HaibaoEntity::checkHaibaoSpawnRules,
				SpawnPlacementRegisterEvent.Operation.REPLACE
		);
	}
}
