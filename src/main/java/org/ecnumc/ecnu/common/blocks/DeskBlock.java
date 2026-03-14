package org.ecnumc.ecnu.common.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import org.ecnumc.ecnu.common.blocks.entities.DeskBlockEntity;
import org.jetbrains.annotations.Nullable;

@SuppressWarnings("deprecation")
public class DeskBlock extends BaseEntityBlock {
	public DeskBlock(Properties properties) {
		super(properties);
	}

	@Override @Nullable
	public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
		return new DeskBlockEntity(pos, state);
	}

	@Override
	public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
		if (level.isClientSide) {
			return InteractionResult.SUCCESS;
		}
		player.openMenu(state.getMenuProvider(level, pos));
		return InteractionResult.CONSUME;
	}
}
