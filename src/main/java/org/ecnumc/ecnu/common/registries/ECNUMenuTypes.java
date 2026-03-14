package org.ecnumc.ecnu.common.registries;

import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.inventory.MenuType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.ecnumc.ecnu.common.menus.DeskMenu;

import static org.ecnumc.ecnu.ECNUForge.MODID;

/**
 * Mod Block Entities
 * @author liudongyu
 */
public final class ECNUMenuTypes {
	private static final DeferredRegister<MenuType<?>> REGISTER = DeferredRegister.create(ForgeRegistries.MENU_TYPES, MODID);

	public static final RegistryObject<MenuType<DeskMenu>> DESK = REGISTER.register(
			"desk", () -> new MenuType<>(DeskMenu::new, FeatureFlags.VANILLA_SET)
	);

	private ECNUMenuTypes() {
	}

	public static void init(IEventBus bus) {
		REGISTER.register(bus);
	}
}
