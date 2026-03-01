package org.ecnumc.ecnu.client.renderers;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.ecnumc.ecnu.ECNUForge;
import org.ecnumc.ecnu.client.ECNULayerLocations;
import org.ecnumc.ecnu.client.models.HaibaoModel;
import org.ecnumc.ecnu.common.entities.HaibaoEntity;

@OnlyIn(Dist.CLIENT)
public class HaibaoRenderer extends MobRenderer<HaibaoEntity, HaibaoModel<HaibaoEntity>> {
	public static final ResourceLocation TEXTURE = new ResourceLocation(ECNUForge.MODID, "textures/entity/haibao/haibao.png");

	public HaibaoRenderer(EntityRendererProvider.Context context) {
		super(context, new HaibaoModel<>(context.bakeLayer(ECNULayerLocations.HAIBAO)), 0.6F);
	}

	@Override
	public ResourceLocation getTextureLocation(HaibaoEntity pEntity) {
		return TEXTURE;
	}
}
