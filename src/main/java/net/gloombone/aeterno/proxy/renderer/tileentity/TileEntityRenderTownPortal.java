package net.gloombone.aeterno.proxy.renderer.tileentity;

import net.gloombone.aeterno.reference.Reference;
import org.lwjgl.opengl.GL11;

import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

public class TileEntityRenderTownPortal extends TileEntitySpecialRenderer {

	private final ResourceLocation textureTownPortal = new ResourceLocation(Reference.MODID, "textures/model/townportal.png");
	
	private int textureWidth = 64;
	private int textureHeight = 32;
	
	/**
	 * x,y,z is distance from player.
	 */
	@Override
	public void renderTileEntityAt(TileEntity te, double x, double y, double z, float f) {
		// System.out.println("Rendering Town portal");
		GL11.glPushMatrix();
		GL11.glTranslatef((float)x, (float)y, (float)z);
		
		Tessellator tessellator = Tessellator.instance;
		this.bindTexture(textureTownPortal);
		tessellator.startDrawingQuads(); // Start of tessellator
		{
			tessellator.addVertexWithUV(0, 0, 1, 1, 1);
			tessellator.addVertexWithUV(0.5F, 1, 0.5F, 0, 0);
			tessellator.addVertexWithUV(0.5F, 1, 0.5F, 0, 0);
			tessellator.addVertexWithUV(0, 0, 0, 0, 0);
			
			tessellator.addVertexWithUV(1, 0, 0, 0, 0);
			tessellator.addVertexWithUV(0.5F, 1, 0.5F, 0, 0);
			tessellator.addVertexWithUV(0.5F, 1, 0.5F, 0, 0);
			tessellator.addVertexWithUV(1, 0, 1, 1, 1);
			
			tessellator.addVertexWithUV(.5F, 1, .5F, 0, 0);
			tessellator.addVertexWithUV(0, 0, 1, 0, 0);
			tessellator.addVertexWithUV(1, 0, 1, 1, 1);
			tessellator.addVertexWithUV(.5F, 1, .5F, 0, 0);
			
			tessellator.addVertexWithUV(.5F, 1, .5F, 0, 0);
			tessellator.addVertexWithUV(1, 0, 0, 1, 1);
			tessellator.addVertexWithUV(0, 0, 0, 0, 0);
			tessellator.addVertexWithUV(.5F, 1, .5F, 0, 0);
		}
		tessellator.draw(); // End of tessellator

		GL11.glPopMatrix();
	}

}
