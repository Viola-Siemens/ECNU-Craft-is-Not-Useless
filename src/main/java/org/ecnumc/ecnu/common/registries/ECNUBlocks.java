package org.ecnumc.ecnu.common.registries;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import static org.ecnumc.ecnu.ECNUForge.MODID;

public final class ECNUBlocks {
	private static final DeferredRegister<Block> REGISTER = DeferredRegister.create(ForgeRegistries.BLOCKS, MODID);

	public static final RegistryObject<Block> AGGLOMERATED_STONE = REGISTER.register(
			"agglomerated_stone", () -> new Block(
					BlockBehaviour.Properties.of().strength(2.0F).sound(SoundType.STONE).requiresCorrectToolForDrops()
			)
	);

	public static void init(IEventBus modBus) {
		REGISTER.register(modBus);
	}

	private ECNUBlocks() {
	}
}
