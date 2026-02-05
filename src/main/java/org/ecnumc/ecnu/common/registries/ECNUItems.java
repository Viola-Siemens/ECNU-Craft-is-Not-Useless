package org.ecnumc.ecnu.common.registries;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
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
	public static final RegistryObject<Item> FRIED_CORN_WITH_GRAPES = REGISTER.register("fried_corn_with_grapes", () -> new Item(
			new Item.Properties().food(ECNUFoods.FRIED_CORN_WITH_GRAPES).craftRemainder(Items.BOWL)
	));
	public static final RegistryObject<Item> EMERALD_CHICKEN_DRUMSTICK = REGISTER.register("emerald_chicken_drumstick", () -> new Item(
			new Item.Properties().food(ECNUFoods.EMERALD_CHICKEN_DRUMSTICK)
	));
	public static final RegistryObject<Item> DOUGH = REGISTER.register("dough", () -> new Item(
			new Item.Properties().food(ECNUFoods.DOUGH)
	));
	public static final RegistryObject<Item> GRAPE = REGISTER.register("grape", () -> new Item(
			new Item.Properties().food(ECNUFoods.GRAPE)
	));
	public static final RegistryObject<Item> CORN = REGISTER.register("corn", () -> new Item(
			new Item.Properties().food(ECNUFoods.CORN)
	));
	public static final RegistryObject<Item> CELERY = REGISTER.register("celery", () -> new Item(
			new Item.Properties().food(ECNUFoods.CELERY)
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
