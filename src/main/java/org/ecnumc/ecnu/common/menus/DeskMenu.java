package org.ecnumc.ecnu.common.menus;

import net.minecraft.world.Container;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import org.ecnumc.ecnu.common.blocks.entities.DeskBlockEntity;
import org.ecnumc.ecnu.common.registries.ECNUMenuTypes;

public class DeskMenu extends AbstractContainerMenu {
	private final Container desk;

	public DeskMenu(int id, Inventory inventory) {
		this(id, inventory, new SimpleContainer(DeskBlockEntity.SLOT_BOOK));
	}

	public DeskMenu(int id, Inventory inventory, Container container) {
		super(ECNUMenuTypes.DESK.get(), id);
		checkContainerSize(container, DeskBlockEntity.SLOT_BOOK);
		this.desk = container;

		this.addSlot(new Slot(container, 0, 44, 36));
		this.addSlot(new Slot(container, 1, 62, 36));

		for(int i = 0; i < 3; ++i) {
			for(int j = 0; j < 9; ++j) {
				this.addSlot(new Slot(inventory, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
			}
		}

		for(int k = 0; k < 9; ++k) {
			this.addSlot(new Slot(inventory, k, 8 + k * 18, 142));
		}
	}

	@Override
	public ItemStack quickMoveStack(Player player, int index) {
		ItemStack ret = ItemStack.EMPTY;
		Slot slot = this.slots.get(index);
		if (slot.hasItem()) {
			ItemStack slotItem = slot.getItem();
			ret = slotItem.copy();
			if (index < DeskBlockEntity.SLOT_BOOK) {
				if (!this.moveItemStackTo(slotItem, DeskBlockEntity.SLOT_BOOK, this.slots.size(), true)) {
					return ItemStack.EMPTY;
				}
			} else if (!this.moveItemStackTo(slotItem, 0, DeskBlockEntity.SLOT_BOOK, false)) {
				return ItemStack.EMPTY;
			}

			if (slotItem.isEmpty()) {
				slot.setByPlayer(ItemStack.EMPTY);
			} else {
				slot.setChanged();
			}
		}

		return ret;
	}

	@Override
	public boolean stillValid(Player player) {
		return this.desk.stillValid(player);
	}
}
