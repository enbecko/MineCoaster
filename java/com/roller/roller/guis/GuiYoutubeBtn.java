package com.roller.roller.guis;

import net.minecraft.client.Minecraft;
import net.minecraft.client.audio.PositionedSoundRecord;
import net.minecraft.client.audio.SoundHandler;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class GuiYoutubeBtn extends GuiButton{

	   public ResourceLocation buttonTextures2;
	   public String name;
	   
	   
	   public GuiYoutubeBtn(int par1, int par2, int par3, int par4, int par5,
				String par6Str) {
			super(par1, par2, par3, par4, par5, par6Str);
			this.name = par6Str;
			this.buttonTextures2 = new ResourceLocation("roller:textures/gui/buttons/Youtube.png");
			}
		
	    public void drawButton(Minecraft p_146112_1_, int p_146112_2_, int p_146112_3_)
	    {
	    	 if (this.visible)
	         {
	             FontRenderer fontrenderer = p_146112_1_.fontRenderer;
	             p_146112_1_.getTextureManager().bindTexture(buttonTextures2);
	             GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
	             this.field_146123_n = p_146112_2_ >= this.xPosition && p_146112_3_ >= this.yPosition && p_146112_2_ < this.xPosition + this.width && p_146112_3_ < this.yPosition + this.height;
	             int k = this.getHoverState(this.field_146123_n);
	             GL11.glEnable(GL11.GL_BLEND);
	             OpenGlHelper.glBlendFunc(770, 771, 1, 0);
	             GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
	             if(id == 21)
	            	 k+=2;
	             this.drawTexturedModalRect(this.xPosition, this.yPosition, 0,(k-1) * 20, this.width -5, this.height);
	             this.drawTexturedModalRect(this.xPosition + (this.width -5), this.yPosition, 200 - 5,(k-1) * 20, 5, this.height);
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
		         this.drawCenteredString(fontrenderer, this.name, this.xPosition + this.width / 2, this.yPosition + (this.height - 8) / 2, l);
	             
	         }
	    }   

}