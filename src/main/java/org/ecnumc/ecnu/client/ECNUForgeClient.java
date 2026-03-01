package org.ecnumc.ecnu.client;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.ecnumc.ecnu.client.models.HaibaoModel;
import org.ecnumc.ecnu.client.renderers.HaibaoRenderer;
import org.ecnumc.ecnu.common.registries.ECNUEntityTypes;

import static org.ecnumc.ecnu.ECNUForge.MODID;

/**
 * Mod Client
 * @author liudongyu
 */
@Mod.EventBusSubscriber(modid = MODID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
public final class ECNUForgeClient {
	/**
	 * Register layer definitions for mod entities.
	 * @param event	register layer definitions event
	 */
	@SubscribeEvent
	public static void onRegisterLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
		event.registerLayerDefinition(ECNULayerLocations.HAIBAO, HaibaoModel::createBodyLayer);
	}

	/**
	 * Register renderers for mod entities.
	 * @param event	register renderers event
	 */
	@SubscribeEvent
	public static void onRegisterRenderer(EntityRenderersEvent.RegisterRenderers event) {
		event.registerEntityRenderer(ECNUEntityTypes.HAIBAO.get(), HaibaoRenderer::new);
	}

	private ECNUForgeClient() {
	}
}
