package org.ecnumc.ecnu.common.registries;

import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.ecnumc.ecnu.common.enchantments.LaozisThoughtEnchantment;

import static org.ecnumc.ecnu.ECNUForge.MODID;

public final class ECNUEnchantments {
	private static final DeferredRegister<Enchantment> REGISTER = DeferredRegister.create(ForgeRegistries.ENCHANTMENTS, MODID);

	public static final RegistryObject<LaozisThoughtEnchantment> LAOZIS_THOUGHT = REGISTER.register(
			"laozis_thought", LaozisThoughtEnchantment::new
	);

	private ECNUEnchantments() {
	}

	public static void init(IEventBus bus) {
		REGISTER.register(bus);
	}
}
