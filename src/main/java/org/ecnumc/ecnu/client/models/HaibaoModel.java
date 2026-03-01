package org.ecnumc.ecnu.client.models;

import net.minecraft.client.model.PlayerModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.ecnumc.ecnu.common.entities.HaibaoEntity;

@OnlyIn(Dist.CLIENT)
public class HaibaoModel<T extends HaibaoEntity> extends PlayerModel<T> {
	public HaibaoModel(ModelPart root) {
		super(root, true);
	}

	public static LayerDefinition createBodyLayer() {
		return LayerDefinition.create(PlayerModel.createMesh(CubeDeformation.NONE, true), 64, 64);
	}
}
