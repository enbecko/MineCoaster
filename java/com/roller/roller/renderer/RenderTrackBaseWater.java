package com.roller.roller.renderer;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import com.roller.roller.models.ModelTrackBase;
import com.roller.roller.tileEntity.EntityTrackBase;
import com.roller.roller.tileEntity.EntityTrackBaseWater;

public class RenderTrackBaseWater extends RenderError {

	final ModelBase base;
	/**final ModelBase curve;
	final ModelBase ueb;
	final ModelBase ueb1;
	final ModelBase ueb2;
	final ModelBase ueb3;
	final ModelBase side;
	final ModelBase curve;*/

  private static final ResourceLocation field_110807_a = new ResourceLocation("mistery:textures/entities/press.png");
    int i;
    
	public RenderTrackBaseWater()
	{
		base = new ModelTrackBase();       //the ':' is very important
	/**	curve = new ModelTrackCurve();       //the ':' is very important
		ueb = new ModelTrackUeb();       //the ':' is very important
		ueb1 = new ModelTrackUeb2();       //the ':' is very important
		ueb2 = new ModelTrackUeb3();       //the ':' is very important
		ueb3 = new ModelTrackUeb4();       //the ':' is very important
		side = new ModelTrackSide();       //the ':' is very important
		t45 = new ModelTrack45(); */      //the ':' is very important
	}
	
	
	@Override
	public void renderTileEntityAt(TileEntity te, double x, double y,
			double z, float var8) {
		super.renderTileEntityAt(te, x, y, z, var8);
	    //The PushMatrix tells the renderer to "start" doing something.
        GL11.glPushMatrix();
        //This is setting the initial location.
        //This is the texture of your block. It's pathed to be the same place as your other blocks here.
        //Outdated bindTextureByName("/mods/roads/textures/blocks/TrafficLightPoleRed.png");
        //Use in 1.6.2  this
//       ResourceLocation Base = (new ResourceLocation("roller:textures/entity/TrackBase.png")); 
       ResourceLocation curve = (new ResourceLocation("roller:textures/entity/TrackBase.png")); 
    //   ResourceLocation train = (new ResourceLocation("roller:textures/entity/Train.png")); */
       	//binding the textures

        EntityTrackBaseWater t = (EntityTrackBaseWater)te;
        Minecraft.getMinecraft().renderEngine.bindTexture(curve);        	       	

        if(t.color == 1)
        	GL11.glColor3f(1, 0.58F, 0.58F);
        if(t.color == 2)
        	GL11.glColor3f(0.58F, 1, 0.58F);
        if(t.color == 3)
        	GL11.glColor3f(0.58F, 0.58F, 1);
        GL11.glPushMatrix();
        if(t.alignment == 0)
        {
            if(t.getWorldObj().getTileEntity(t.xCoord, t.yCoord, t.zCoord-1) instanceof EntityTrackBase)
            {
                GL11.glTranslatef((float) x + 0.5F, (float) y + 1.37F, (float) z + 0.765F);
                GL11.glRotatef(180F, 0.0F, 0.0F, 1F);
                GL11.glRotatef(-11, 1, 0.0F, 0);
                this.base.render((Entity)null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);	
            }else if(t.getWorldObj().getTileEntity(t.xCoord, t.yCoord, t.zCoord+1) instanceof EntityTrackBase)
            {
                GL11.glTranslatef((float) x + 0.5F, (float) y + 1.37F, (float) z + 0.235F);
                GL11.glRotatef(180F, 0.0F, 0.0F, 1F);
                GL11.glRotatef(11, 1, 0.0F, 0);
                this.base.render((Entity)null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);	
            }else
            {
	            GL11.glTranslatef((float) x + 0.5F, (float) y + 1.3F, (float) z + 0.5F);
	            GL11.glRotatef(180F, 0.0F, 0.0F, 1F);
	            this.base.render((Entity)null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);	
            }
            
        }
        else if(t.alignment == 1)
        {
        	if(t.getWorldObj().getTileEntity(t.xCoord+1, t.yCoord, t.zCoord) instanceof EntityTrackBase)
            {
                GL11.glTranslatef((float) x + 0.235F, (float) y + 1.37F, (float) z + 0.5F);
                GL11.glRotatef(180F, 0.0F, 0.0F, 1F);
            	GL11.glRotatef(90F, 0.0F, 1, 0);
            	GL11.glRotatef(-11, 1, 0.0F, 0);
                this.base.render((Entity)null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);	
            }else if(t.getWorldObj().getTileEntity(t.xCoord-1, t.yCoord, t.zCoord) instanceof EntityTrackBase)
            {
                GL11.glTranslatef((float) x + 0.765F, (float) y + 1.37F, (float) z + 0.5F);
                GL11.glRotatef(180F, 0.0F, 0.0F, 1F);
            	GL11.glRotatef(90F, 0.0F, 1, 0);
            	GL11.glRotatef(11, 1, 0.0F, 0);
                this.base.render((Entity)null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);	
            }else
            {
	            GL11.glTranslatef((float) x + 0.5F, (float) y + 1.3F, (float) z + 0.5F);
	            GL11.glRotatef(180F, 0.0F, 0.0F, 1F);
	        	GL11.glRotatef(90F, 0.0F, 1, 0);
	            this.base.render((Entity)null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
            }
            
       }
        else if(t.alignment == 2)
        {
            if(t.getWorldObj().getTileEntity(t.xCoord, t.yCoord, t.zCoord+1) instanceof EntityTrackBase)
            {
                GL11.glTranslatef((float) x + 0.5F, (float) y + 1.37F, (float) z + 0.235F);
                GL11.glRotatef(180F, 0.0F, 0.0F, 1F);
                GL11.glRotatef(180F, 0.0F, 1, 0);
                GL11.glRotatef(-11, 1, 0.0F, 0);
                this.base.render((Entity)null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);	
            }else if(t.getWorldObj().getTileEntity(t.xCoord, t.yCoord, t.zCoord-1) instanceof EntityTrackBase)
            {
                GL11.glTranslatef((float) x + 0.5F, (float) y + 1.37F, (float) z + 0.765F);
                GL11.glRotatef(180F, 0.0F, 0.0F, 1F);
                GL11.glRotatef(180F, 0.0F, 1, 0);
                GL11.glRotatef(11, 1, 0.0F, 0);
                this.base.render((Entity)null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);	
            }else
            {
	            GL11.glTranslatef((float) x + 0.5F, (float) y + 1.3F, (float) z + 0.5F);
	            GL11.glRotatef(180F, 0.0F, 0.0F, 1F);
                GL11.glRotatef(180F, 0.0F, 1, 0);
                this.base.render((Entity)null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);	
            }
            
        }
        else if(t.alignment == 3)
        {
        	if(t.getWorldObj().getTileEntity(t.xCoord-1, t.yCoord, t.zCoord) instanceof EntityTrackBase)
            {
                GL11.glTranslatef((float) x + 0.765F, (float) y + 1.37F, (float) z + 0.5F);
                GL11.glRotatef(180F, 0.0F, 0.0F, 1F);
            	GL11.glRotatef(270, 0.0F, 1, 0);
            	GL11.glRotatef(-11, 1, 0.0F, 0);
                this.base.render((Entity)null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);	
            }else if(t.getWorldObj().getTileEntity(t.xCoord+1, t.yCoord, t.zCoord) instanceof EntityTrackBase)
            {
                GL11.glTranslatef((float) x + 0.235F, (float) y + 1.37F, (float) z + 0.5F);
                GL11.glRotatef(180F, 0.0F, 0.0F, 1F);
            	GL11.glRotatef(270, 0.0F, 1, 0);
            	GL11.glRotatef(11, 1, 0.0F, 0);
                this.base.render((Entity)null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);	
            }else
            {
	            GL11.glTranslatef((float) x + 0.5F, (float) y + 1.3F, (float) z + 0.5F);
	            GL11.glRotatef(180F, 0.0F, 0.0F, 1F);
	        	GL11.glRotatef(270, 0.0F, 1, 0);
	            this.base.render((Entity)null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
            }
            
        }
        GL11.glPopMatrix();
        GL11.glPopMatrix();
	}

}
