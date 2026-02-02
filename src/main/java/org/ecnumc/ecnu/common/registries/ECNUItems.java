package org.ecnumc.ecnu.common.registries;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import static org.ecnumc.ecnu.ECNUForge.MODID;

/**
 * Mod Items
 * @author liudongyu
 */
public final class ECNUItems {
	private static final DeferredRegister<Item> REGISTER = DeferredRegister.create(ForgeRegistries.ITEMS, MODID);

	public static final RegistryObject<BlockItem> AGGLOMERATED_STONE = REGISTER.register("agglomerated_stone", () -> new BlockItem(
			ECNUBlocks.AGGLOMERATED_STONE.get(),
			new Item.Properties().stacksTo(16)
	));
	public static final RegistryObject<Item> SHANGHAI_CABBAGE = REGISTER.register("shanghai_cabbage", () -> new Item(
			new Item.Properties().food(ECNUFoods.SHANGHAI_CABBAGE)
	));

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
