package org.ecnumc.ecnu.mixin;

import com.llamalad7.mixinextras.sugar.Local;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.goal.MoveToBlockGoal;
import net.minecraft.world.entity.animal.Rabbit;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import org.ecnumc.ecnu.common.blocks.ShanghaiCabbageBlock;
import org.objectweb.asm.Opcodes;
import org.spongepowered.asm.mixin.Debug;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Debug(export = true)
@Mixin(Rabbit.RaidGardenGoal.class)
public abstract class RaidGardenGoalMixin extends MoveToBlockGoal {
	@Shadow @Final
	private Rabbit rabbit;

	@Shadow
	private boolean canRaid;

	protected RaidGardenGoalMixin(PathfinderMob mob, double speedModifier, int searchRange) {
		super(mob, speedModifier, searchRange);
		throw new UnsupportedOperationException("Mixin constructor");
	}

	@Inject(method = "tick", at = @At(value = "FIELD", target = "Lnet/minecraft/world/entity/animal/Rabbit$RaidGardenGoal;canRaid:Z", opcode = Opcodes.PUTFIELD))
	private void ecnu$destroyShanghaiCabbage(CallbackInfo ci) {
		Level level = this.rabbit.level();
		BlockPos blockpos = this.blockPos.above();
		BlockState blockstate = level.getBlockState(blockpos);
		Block block = blockstate.getBlock();
		if (this.canRaid && block instanceof ShanghaiCabbageBlock) {
			int i = blockstate.getValue(CropBlock.AGE);
			if (i == 0) {
				level.setBlock(blockpos, Blocks.AIR.defaultBlockState(), 2);
				level.destroyBlock(blockpos, true, this.rabbit);
			} else {
				level.setBlock(blockpos, blockstate.setValue(CropBlock.AGE, i - 1), 2);
				level.levelEvent(LevelEvent.PARTICLES_DESTROY_BLOCK, blockpos, Block.getId(blockstate));
			}

			this.rabbit.moreCarrotTicks = 40;
		}
	}

	@Inject(method = "isValidTarget", at = @At(
			value = "INVOKE_ASSIGN",
			target = "Lnet/minecraft/world/level/LevelReader;getBlockState(Lnet/minecraft/core/BlockPos;)Lnet/minecraft/world/level/block/state/BlockState;",
			ordinal = 1, shift = At.Shift.AFTER
	), cancellable = true)
	private void ecnu$checkShanghaiCabbage(LevelReader pLevel, BlockPos pPos, CallbackInfoReturnable<Boolean> cir, @Local BlockState blockState) {
		if (blockState.getBlock() instanceof ShanghaiCabbageBlock shanghaiCabbageBlock && shanghaiCabbageBlock.isMaxAge(blockState)) {
			this.canRaid = true;
			cir.setReturnValue(true);
		}
	}
}
