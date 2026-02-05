package org.ecnumc.ecnu.common.registries;


import net.minecraft.world.food.FoodProperties;

/**
 * Mod Foods
 * @author liudongyu
 */
public final class ECNUFoods {
	public static final FoodProperties SHANGHAI_CABBAGE = new FoodProperties.Builder()
			.nutrition(2)
			.saturationMod(0.3F)
			.build();

	public static final FoodProperties FRIED_CORN_WITH_GRAPES = new FoodProperties.Builder()
			.nutrition(6)
			.saturationMod(0.6F)
			.build();

	public static final FoodProperties EMERALD_CHICKEN_DRUMSTICK = new FoodProperties.Builder()
			.nutrition(8)
			.saturationMod(0.8F)
			.build();

	public static final FoodProperties DOUGH = new FoodProperties.Builder()
			.nutrition(1)
			.saturationMod(0.1F)
			.build();

	public static final FoodProperties GRAPE = new FoodProperties.Builder()
			.nutrition(2)
			.saturationMod(0.3F)
			.build();

	public static final FoodProperties CORN = new FoodProperties.Builder()
			.nutrition(3)
			.saturationMod(0.4F)
			.build();

	public static final FoodProperties CELERY = new FoodProperties.Builder()
			.nutrition(1)
			.saturationMod(0.2F)
			.build();

	private ECNUFoods() {
	}
}
