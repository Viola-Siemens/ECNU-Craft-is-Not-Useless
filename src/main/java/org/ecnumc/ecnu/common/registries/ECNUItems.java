package org.ecnumc.ecnu.common.registries;

import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import static org.ecnumc.ecnu.ECNUForge.MODID;

/**
 * Mod Items
 * @author liudongyu
 */
public final class ECNUItems {
	private static final DeferredRegister<Item> REGISTER = DeferredRegister.create(ForgeRegistries.ITEMS, MODID);

	private ECNUItems() {
	}

	/**
	 * Register the items on mod constructing.
	 * @param modBus	the mod bus
	 */
	public static void init(IEventBus modBus) {
		REGISTER.register(modBus);
	}
}
