package org.ecnumc.ecnu;

import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.ecnumc.ecnu.common.ECNUContent;

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
	}

	public static void onCommonSetup(FMLCommonSetupEvent event) {
	}
}
