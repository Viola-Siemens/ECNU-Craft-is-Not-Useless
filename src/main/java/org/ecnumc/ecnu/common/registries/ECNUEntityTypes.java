package org.ecnumc.ecnu.common.registries;

import net.minecraft.world.entity.EntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import static org.ecnumc.ecnu.ECNUForge.MODID;

/**
 * Mod Entity Types
 * @author liudongyu
 */
public final class ECNUEntityTypes {
	private static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, MODID);

	private ECNUEntityTypes() {
	}

	/**
	 * Register the entity types on mod constructing.
	 * @param modBus	the mod bus
	 */
	public static void init(IEventBus modBus) {
		ENTITY_TYPES.register(modBus);
	}
}
