package org.ecnumc.ecnu.common;

import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.ecnumc.ecnu.common.registries.*;

import static org.ecnumc.ecnu.ECNUForge.MODID;

/**
 * Mod Content
 * @author liudongyu
 */
@Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public final class ECNUContent {
	/**
	 * Called on mod constructing.
	 * @param modBus	the mod bus
	 */
	public static void modConstruction(IEventBus modBus) {
		ECNUEnchantmentCategories.init();
		ECNUEnchantments.init(modBus);
		ECNUEntityTypes.init(modBus);
		ECNUBlocks.init(modBus);
		ECNUItems.init(modBus);
		ECNUBlockEntities.init(modBus);
		ECNUMenuTypes.init(modBus);
		ECNUCreativeModeTabs.init(modBus);
	}

	private ECNUContent() {
	}

	@SubscribeEvent
	public static void onAttributeCreate(EntityAttributeCreationEvent event) {
	}
}
