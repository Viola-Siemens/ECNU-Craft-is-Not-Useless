package org.ecnumc.ecnu.common.registries;

import net.minecraft.world.item.ShieldItem;
import net.minecraft.world.item.enchantment.EnchantmentCategory;

public final class ECNUEnchantmentCategories {
	public static final EnchantmentCategory SHIELD = EnchantmentCategory.create("ecnu_shield", ShieldItem.class::isInstance);

	public static void init() {
	}

	private ECNUEnchantmentCategories() {
	}
}
