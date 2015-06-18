package com.roller.roller.guis;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

public class PicChooseBtn extends GuiButton{

	   public ResourceLocation buttonTextures2;
	   public String name;
	   boolean marked;
	   public int centreX, centreY;
	   
	   
	   
	   public PicChooseBtn(int par1, int par2, int par3, int par4, int par5,
				String par6Str) {
			super(par1, par2, par3, par4, par5, par6Str);
			this.centreX = par2;
			this.centreY = par3;
			this.name = par6Str;
			this.buttonTextures2 = new ResourceLocation("roller:textures/gui/widgets.png");
			}
		
		
	    public void drawButton(Minecraft p_146112_1_, int p_146112_2_, int p_146112_3_)
	    {
	    	 if (this.visible)
	         {
	             FontRenderer fontrenderer = p_146112_1_.fontRenderer;
	             GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
	             this.field_146123_n = p_146112_2_ >= this.xPosition && p_146112_3_ >= this.yPosition && p_146112_2_ < this.xPosition + this.width && p_146112_3_ < this.yPosition + this.height;
	             int k = this.getHoverState(this.field_146123_n);
	             GL11.glEnable(GL11.GL_BLEND);
	             OpenGlHelper.glBlendFunc(770, 771, 1, 0);
	             GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
	             p_146112_1_.getTextureManager().bindTexture(buttonTextures2);
	             if(k == 2)
	            	 System.out.println(this.yPosition);
	             if(this.yPosition >= 52 && this.yPosition < 188-20)
	             {
		             this.drawTexturedModalRect(this.xPosition, this.yPosition, 0, 44 + (k-1) * 20, this.width, this.height);
	             }else if(this.yPosition < 188-20)
	             {
	            	 this.drawTexturedModalRect(this.xPosition, 53, 0, 44 + (k-1) * 20 + (53-this.yPosition), this.width, this.height-(53-this.yPosition));
	             }else if(this.yPosition >= 188-20 && this.yPosition < 188)
	            	 this.drawTexturedModalRect(this.xPosition, this.yPosition, 0, 44 + (k-1) * 20, this.width, this.height+(167-this.yPosition));

	             this.mouseDragged(p_146112_1_, p_146112_2_, p_146112_3_);
	             int l = 14737632;

	             if (packedFGColour != 0)
	             {
	                 l = packedFGColour;
	             }
	             else if (!this.enabled)
	             {
	                 l = 10526880;
	             }
	             else if (this.field_146123_n)
	             {
	                 l = 16777120;
	             }
	             if(this.yPosition >= 45 && this.yPosition < 174)
	            	 this.drawCenteredString(fontrenderer, this.name, this.xPosition + this.width / 2, this.yPosition + (this.height - 8) / 2, l);
	        }
	    }   

}