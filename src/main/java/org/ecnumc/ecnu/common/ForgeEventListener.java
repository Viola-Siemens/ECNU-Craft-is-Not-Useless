package org.ecnumc.ecnu.common;

import net.minecraft.SharedConstants;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ShieldItem;
import net.minecraftforge.event.entity.living.ShieldBlockEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.ecnumc.ecnu.common.registries.ECNUEnchantments;

import static org.ecnumc.ecnu.ECNUForge.MODID;

@Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public final class ForgeEventListener {
	@SubscribeEvent
	public static void onShieldBreak(ShieldBlockEvent event) {
		DamageSource damageSource = event.getDamageSource();
		Entity entity = damageSource.getEntity();
		if((damageSource.is(DamageTypes.MOB_ATTACK) || damageSource.is(DamageTypes.PLAYER_ATTACK)) &&
				entity instanceof LivingEntity livingEntity && livingEntity.getMainHandItem().is(ItemTags.AXES)) {
			ItemStack mainHandItem = event.getEntity().getItemInHand(InteractionHand.MAIN_HAND);
			if(!(mainHandItem.getItem() instanceof ShieldItem)) {
				mainHandItem = event.getEntity().getItemInHand(InteractionHand.OFF_HAND);
			}
			int level = mainHandItem.getEnchantmentLevel(ECNUEnchantments.LAOZIS_THOUGHT.get());
			livingEntity.addEffect(new MobEffectInstance(MobEffects.BLINDNESS, (5 + level * 5) * SharedConstants.TICKS_PER_SECOND));
			livingEntity.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, (5 + level * 5) * SharedConstants.TICKS_PER_SECOND, level));
			event.getEntity().addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, (5 + level * 5) * SharedConstants.TICKS_PER_SECOND, level));
		}
	}

	private ForgeEventListener() {
	}
}
