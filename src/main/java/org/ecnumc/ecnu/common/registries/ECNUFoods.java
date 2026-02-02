package org.ecnumc.ecnu.common.registries;


import net.minecraft.world.food.FoodProperties;

public final class ECNUFoods {
	public static final FoodProperties SHANGHAI_CABBAGE = new FoodProperties.Builder()
			.nutrition(4)
			.saturationMod(0.3F)
			.build();

	private ECNUFoods() {
	}
}
