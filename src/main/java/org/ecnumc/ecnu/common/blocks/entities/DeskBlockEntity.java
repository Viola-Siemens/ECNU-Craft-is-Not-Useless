package org.ecnumc.ecnu.common.blocks.entities;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.NonNullList;
import net.minecraft.network.chat.Component;
import net.minecraft.world.ContainerHelper;
import net.minecraft.world.WorldlyContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.entity.BaseContainerBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.wrapper.SidedInvWrapper;
import org.ecnumc.ecnu.common.menus.DeskMenu;
import org.ecnumc.ecnu.common.registries.ECNUBlockEntities;
import org.jetbrains.annotations.Nullable;

public class DeskBlockEntity extends BaseContainerBlockEntity implements WorldlyContainer {
	private static final int[] SLOTS_FOR_UP = new int[]{0, 1};
	private static final int[] SLOTS_FOR_SIDES = new int[0];
	private static final int[] SLOTS_FOR_DOWN = new int[]{0, 1};

	public static final int SLOT_BOOK = 2;

	protected final NonNullList<ItemStack> items = NonNullList.withSize(SLOT_BOOK, ItemStack.EMPTY);

	public DeskBlockEntity(BlockPos pos, BlockState blockState) {
		this(ECNUBlockEntities.DESK.get(), pos, blockState);
	}

	public DeskBlockEntity(BlockEntityType<?> type, BlockPos pos, BlockState blockState) {
		super(type, pos, blockState);
	}

	// TODO: 持久化

	@Override
	protected Component getDefaultName() {
		return Component.translatable("container.ecnu.desk");
	}

	@Override
	protected DeskMenu createMenu(int containerId, Inventory inventory) {
		return new DeskMenu(containerId, inventory);
	}

	@Override
	public int getContainerSize() {
		return this.items.size();
	}

	@Override
	public boolean isEmpty() {
		for(ItemStack itemStack : this.items) {
			if(!itemStack.isEmpty()) {
				return false;
			}
		}
		return true;
	}

	@Override
	public ItemStack getItem(int slot) {
		return this.items.get(slot);
	}

	@Override
	public ItemStack removeItem(int slot, int amount) {
		return ContainerHelper.removeItem(this.items, slot, amount);
	}

	@Override
	public ItemStack removeItemNoUpdate(int slot) {
		return ContainerHelper.takeItem(this.items, slot);
	}

	@Override
	public void setItem(int slot, ItemStack stack) {
		this.items.set(slot, stack);
		if(stack.getCount() > this.getMaxStackSize()) {
			stack.setCount(this.getMaxStackSize());
		}
	}

	@Override
	public boolean stillValid(Player player) {
		if(this.level.getBlockEntity(this.worldPosition) != this) {
			return false;
		}
		return player.distanceToSqr(this.worldPosition.getX() + 0.5D, this.worldPosition.getY() + 0.5D, this.worldPosition.getZ() + 0.5D) <= 64.0D;
	}

	@Override
	public void clearContent() {
		this.items.clear();
	}

	@Override
	public boolean canPlaceItem(int slot, ItemStack stack) {
		return stack.is(Items.BOOK) || stack.is(Items.WRITTEN_BOOK) || stack.is(Items.WRITABLE_BOOK) || stack.is(Items.ENCHANTED_BOOK);
	}

	@Override
	public int[] getSlotsForFace(Direction side) {
		if(side == Direction.UP) {
			return SLOTS_FOR_UP;
		}
		if(side == Direction.DOWN) {
			return SLOTS_FOR_DOWN;
		}
		return SLOTS_FOR_SIDES;
	}

	@Override
	public boolean canPlaceItemThroughFace(int index, ItemStack itemStack, @Nullable Direction direction) {
		return direction == Direction.UP;
	}

	@Override
	public boolean canTakeItemThroughFace(int index, ItemStack itemStack, Direction direction) {
		return direction == Direction.DOWN;
	}

	// ==== Forge ====

	LazyOptional<? extends IItemHandler>[] handlers = SidedInvWrapper.create(this, Direction.UP, Direction.DOWN);

	@Override
	public <T> LazyOptional<T> getCapability(Capability<T> capability, @Nullable Direction facing) {
		if (!this.remove && facing != null && capability == ForgeCapabilities.ITEM_HANDLER) {
			if (facing == Direction.UP) {
				return this.handlers[0].cast();
			}
			if(facing == Direction.DOWN) {
				return this.handlers[1].cast();
			}
		}
		return super.getCapability(capability, facing);
	}

	@Override
	public void invalidateCaps() {
		super.invalidateCaps();
		for (LazyOptional<? extends IItemHandler> handler : this.handlers) {
			handler.invalidate();
		}
	}

	@Override
	public void reviveCaps() {
		super.reviveCaps();
		this.handlers = SidedInvWrapper.create(this, Direction.UP, Direction.DOWN);
	}
}
