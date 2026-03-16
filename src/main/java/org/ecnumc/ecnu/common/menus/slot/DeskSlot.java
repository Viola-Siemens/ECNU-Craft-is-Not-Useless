package org.ecnumc.ecnu.common.menus.slot;

import net.minecraft.world.Container;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import org.ecnumc.ecnu.common.blocks.entities.DeskBlockEntity;

public class DeskSlot extends Slot {
	public DeskSlot(Container inventory, int index, int x, int y) {
		super(inventory, index, x, y);
	}

	@Override
	public boolean mayPlace(ItemStack stack) {
		return DeskBlockEntity.mayPlace(stack);
	}
}
