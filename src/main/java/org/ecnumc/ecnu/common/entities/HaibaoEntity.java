package org.ecnumc.ecnu.common.entities;

import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.AvoidEntityGoal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.PanicGoal;
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomStrollGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.monster.Husk;
import net.minecraft.world.entity.monster.ZombifiedPiglin;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.Blocks;
import org.ecnumc.ecnu.common.registries.ECNUEntityTypes;

public class HaibaoEntity extends PathfinderMob {
	public HaibaoEntity(Level level) {
		this(ECNUEntityTypes.HAIBAO.get(), level);
	}

	public HaibaoEntity(EntityType<? extends HaibaoEntity> entityType, Level level) {
		super(entityType, level);
	}

	@Override
	protected void registerGoals() {
		super.registerGoals();
		this.goalSelector.addGoal(0, new PanicGoal(this, 1.2D));
		this.goalSelector.addGoal(1, new WaterAvoidingRandomStrollGoal(this, 0.8D));
		this.goalSelector.addGoal(1, new MeleeAttackGoal(this, 1.0D, false));
		this.goalSelector.addGoal(3, new AvoidEntityGoal<>(this, ZombifiedPiglin.class, 10.0F, 1.0D, 1.2D));
		this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, Husk.class, false));
	}

	public static AttributeSupplier.Builder createAttributes() {
		return Mob.createMobAttributes()
				.add(Attributes.MAX_HEALTH, 50.0D)
				.add(Attributes.MOVEMENT_SPEED, 0.5D)
				.add(Attributes.ATTACK_DAMAGE, 5.0D)
				.add(Attributes.FOLLOW_RANGE, 48.0D);
	}

	public static boolean checkHaibaoSpawnRules(EntityType<? extends HaibaoEntity> entityType, ServerLevelAccessor level, MobSpawnType spawnType, BlockPos pos, RandomSource random) {
		return checkMobSpawnRules(entityType, level, spawnType, pos, random) && level.getBlockState(pos.below()).getBlock() != Blocks.DIRT;
	}
}
