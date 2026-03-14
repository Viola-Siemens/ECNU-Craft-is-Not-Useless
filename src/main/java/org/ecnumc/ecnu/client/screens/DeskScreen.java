package org.ecnumc.ecnu.client.screens;

import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.ecnumc.ecnu.common.menus.DeskMenu;

import static org.ecnumc.ecnu.ECNUForge.MODID;

@OnlyIn(Dist.CLIENT)
public class DeskScreen extends AbstractContainerScreen<DeskMenu> {
	private static final ResourceLocation BG_LOCATION = new ResourceLocation(MODID, "textures/gui/container/desk.png");

	public DeskScreen(DeskMenu menu, Inventory playerInventory, Component title) {
		super(menu, playerInventory, title);
		--this.titleLabelY;
	}

	@Override
	public void render(GuiGraphics transform, int mouseX, int mouseY, float partialTick) {
		super.render(transform, mouseX, mouseY, partialTick);
		this.renderTooltip(transform, mouseX, mouseY);
	}

	@Override
	protected void renderBg(GuiGraphics transform, float partialTick, int mouseX, int mouseY) {
		int left = (this.width - this.imageWidth) / 2;
		int top = (this.height - this.imageHeight) / 2;

		transform.blit(BG_LOCATION, left, top, 0, 0, this.imageWidth, this.imageHeight);
	}
}
