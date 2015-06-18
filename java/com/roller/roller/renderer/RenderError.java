package com.roller.roller.renderer;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import com.roller.roller.models.ModelWallpic;
import com.roller.roller.tileEntity.Base;

public class RenderError extends TileEntitySpecialRenderer {

	final ModelBase kack;


  private static final ResourceLocation field_110807_a = new ResourceLocation("mistery:textures/entities/press.png");
    int i;
    
	public RenderError()
	{
		kack = new ModelWallpic(2);       //the ':' is very important
	}
	
	
	@Override
	public void renderTileEntityAt(TileEntity te, double x, double y,
			double z, float var8) {
	    //The PushMatrix tells the renderer to "start" doing something.
		if(te instanceof Base && (((Base)te).failed))
		{
	        GL11.glPushMatrix();
	        //This is setting the initial location.
	        //This is the texture of your block. It's pathed to be the same place as your other blocks here.
	        //Outdated bindTextureByName("/mods/roads/textures/blocks/TrafficLightPoleRed.png");
	        //Use in 1.6.2  this
	       ResourceLocation KACKA = (new ResourceLocation("roller:textures/entity/Failed.png")); 
	
	      Minecraft.getMinecraft().renderEngine.bindTexture(KACKA);        	
	       	//binding the textures
	        //This rotation part is very important! Without it, your te will render upside-down! And for some reason you DO need PushMatrix again!                       
	        GL11.glPushMatrix();
	        GL11.glTranslatef((float) x + 0.5F, (float) y + 2.2F, (float) z + 0.5F);
	        GL11.glRotatef(180, 1, 0, 0);
	        float[] tmp = {(float) x,(float) y,(float) z};
	        GL11.glRotatef(this.getRotationTo(tmp)-90, 0, 1, 0);
	        GL11.glScalef(0.6F, 0.6F, 0.6F);
	        this.kack.render((Entity)null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
	        GL11.glPopMatrix();
	        GL11.glPopMatrix(); 
		}    
		if(te instanceof Base && (((Base)te).prev == null) && ((Base)te).firstBlock != te)
		{
	        GL11.glPushMatrix();
	        //This is setting the initial location.
	        //This is the texture of your block. It's pathed to be the same place as your other blocks here.
	        //Outdated bindTextureByName("/mods/roads/textures/blocks/TrafficLightPoleRed.png");
	        //Use in 1.6.2  this
	       ResourceLocation KACKA = (new ResourceLocation("roller:textures/entity/tested.png")); 
	
	      Minecraft.getMinecraft().renderEngine.bindTexture(KACKA);        	
	       	//binding the textures
	        //This rotation part is very important! Without it, your te will render upside-down! And for some reason you DO need PushMatrix again!                       
	        GL11.glPushMatrix();
	        GL11.glTranslatef((float) x + 0.5F, (float) y + 2.2F, (float) z + 0.5F);
	        GL11.glRotatef(180, 1, 0, 0);
	        float[] tmp = {(float) x,(float) y,(float) z};
	        GL11.glRotatef(this.getRotationTo(tmp)-90, 0, 1, 0);
	        GL11.glScalef(0.6F, 0.6F, 0.6F);
	        this.kack.render((Entity)null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
	        GL11.glPopMatrix();
	        GL11.glPopMatrix(); 
		}    
		
	}
	
	private int getRotationTo(float[] coords) {
		float h;
		float l;
		boolean hX;
		if(Math.abs(coords[0]) > Math.abs(coords[2]))
		{
			l = coords[2];
			h = coords[0];
			hX = true;
		}
		else
		{
			l = coords[0];
			h = coords[2];
			hX = false;
		}
		l = (float)l/h;
		if(h > 0)
			h = 1;
		else if(h < 0)
			h = -1;
		int rot;
		if(hX)
		{
			rot = (int) (90+h*90);
			rot = (int) ((2*rot+(l*(90)))/2);
		}
		else
		{
			rot = (int) (180+h*90);
			rot = (int) ((2*rot+(l*(-90)))/2);
		}
		if(rot > 360)
			rot = rot-360;
		return rot;
	}


}
