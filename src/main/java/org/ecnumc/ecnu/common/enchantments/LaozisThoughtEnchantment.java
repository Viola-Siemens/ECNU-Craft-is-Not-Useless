package org.ecnumc.ecnu.common.enchantments;

import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.enchantment.Enchantment;
import org.ecnumc.ecnu.common.registries.ECNUEnchantmentCategories;

public class LaozisThoughtEnchantment extends Enchantment {
	public LaozisThoughtEnchantment() {
		super(Rarity.RARE, ECNUEnchantmentCategories.SHIELD, new EquipmentSlot[]{EquipmentSlot.MAINHAND, EquipmentSlot.OFFHAND});
	}

	@Override
	public int getMaxLevel() {
		return 3;
	}

	@Override
	public int getMinCost(int level) {
		return 20 * level - 10;
	}

	@Override
	public int getMaxCost(int level) {
		return this.getMinCost(level) + 50;
	}
}
