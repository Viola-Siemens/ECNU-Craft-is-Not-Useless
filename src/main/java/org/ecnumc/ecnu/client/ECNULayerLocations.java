package org.ecnumc.ecnu.client;

import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import static org.ecnumc.ecnu.ECNUForge.MODID;

/**
 * Mod Layer Locations
 * @author liudongyu
 */
@OnlyIn(Dist.CLIENT)
public class ECNULayerLocations {
	public static final ModelLayerLocation HAIBAO = new ModelLayerLocation(new ResourceLocation(MODID, "haibao"), "main");

	private ECNULayerLocations() {
	}
}
