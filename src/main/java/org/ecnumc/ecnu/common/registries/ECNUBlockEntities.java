package org.ecnumc.ecnu.common.registries;

import com.google.common.collect.ImmutableSet;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.ecnumc.ecnu.common.blocks.entities.DeskBlockEntity;

import static org.ecnumc.ecnu.ECNUForge.MODID;

/**
 * Mod Block Entities
 * @author liudongyu
 */
public final class ECNUBlockEntities {
	private static final DeferredRegister<BlockEntityType<?>> REGISTER = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, MODID);

	public static final RegistryObject<BlockEntityType<DeskBlockEntity>> DESK = REGISTER.register(
			"desk", () -> new BlockEntityType<>(DeskBlockEntity::new, ImmutableSet.of(ECNUBlocks.DESK.get()), null)
	);

	private ECNUBlockEntities() {
	}

	public static void init(IEventBus bus) {
		REGISTER.register(bus);
	}
}
