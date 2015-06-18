package com.roller.roller.renderer;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBase;
import net.minecraft.entity.Entity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import com.roller.roller.models.ModelSupport1;
import com.roller.roller.models.ModelSupport2;
import com.roller.roller.tileEntity.EntitySupport;

public class RenderSupport extends RenderError {

	final ModelSupport1 base;
	final ModelSupport2 base2;


  private static final ResourceLocation field_110807_a = new ResourceLocation("mistery:textures/entities/press.png");
    int i;
    
	public RenderSupport()
	{
		base = new ModelSupport1();       //the ':' is very important
		base2 = new ModelSupport2();       //the ':' is very important
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
       ResourceLocation Base = (new ResourceLocation("roller:textures/entity/support1.png")); 
       ResourceLocation Base2 = (new ResourceLocation("roller:textures/entity/support2.png")); 
  /**     ResourceLocation side = (new ResourceLocation("roller:textures/entity/TrackSide.png")); 
       ResourceLocation Ueb = (new ResourceLocation("roller:textures/entity/Trackueb.png")); 
       ResourceLocation Ueb2 = (new ResourceLocation("roller:textures/entity/Trackueb2.png")); 
       ResourceLocation curve = (new ResourceLocation("roller:textures/entity/TrackTurn.png")); 
       ResourceLocation train = (new ResourceLocation("roller:textures/entity/Train.png")); */
       EntitySupport t = ((EntitySupport)te);
       if(t.form == 4)
       {
    	   	Minecraft.getMinecraft().renderEngine.bindTexture(Base2);        		
	        //This rotation part is very important! Without it, your te will render upside-down! And for some reason you DO need PushMatrix again!                       
	        GL11.glPushMatrix();
	        GL11.glTranslatef((float) x + 0.5F, (float) y + 1.45F, (float) z + 0.5F);
	        GL11.glRotatef(180F, 0.0F, 0.0F, 1F);
	        GL11.glRotatef(t.turn*90-90, 0.0F, 1, 0);
	        this.base2.render((Entity)null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
	        GL11.glPopMatrix();
	        GL11.glPopMatrix();
       }else if(t.form == 3)
       {
   	   		Minecraft.getMinecraft().renderEngine.bindTexture(Base);        		
	        //This rotation part is very important! Without it, your te will render upside-down! And for some reason you DO need PushMatrix again!                       
	        GL11.glPushMatrix();
	        GL11.glTranslatef((float) x + 0.5F, (float) y + 1.5F, (float) z + 0.5F);
	        GL11.glRotatef(180F, 0.0F, 0.0F, 1F);
	        this.base.Shape21.isHidden = true;
	        this.base.Shape2.isHidden = true;
	        this.base.render((Entity)null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
	        GL11.glPopMatrix();
	        GL11.glPopMatrix();
      }else if(t.form == 2)
      {
 	   		Minecraft.getMinecraft().renderEngine.bindTexture(Base);        		
	        //This rotation part is very important! Without it, your te will render upside-down! And for some reason you DO need PushMatrix again!                       
	        GL11.glPushMatrix();
	        GL11.glTranslatef((float) x + 0.5F, (float) y + 1.5F, (float) z + 0.5F);
	        GL11.glRotatef(180F, 0.0F, 0.0F, 1F);
	        this.base.Shape21.isHidden = true;
	        this.base.Shape2.isHidden = false;
	        this.base.render((Entity)null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
	        GL11.glPopMatrix();
	        GL11.glPopMatrix();
    }else if(t.form == 1)
      {
 	   		Minecraft.getMinecraft().renderEngine.bindTexture(Base);        		
	        //This rotation part is very important! Without it, your te will render upside-down! And for some reason you DO need PushMatrix again!                       
	        GL11.glPushMatrix();
	        GL11.glTranslatef((float) x + 0.5F, (float) y + 1.5F, (float) z + 0.5F);
	        GL11.glRotatef(180F, 0.0F, 0.0F, 1F);
	        this.base.Shape21.isHidden = false;
	        this.base.Shape2.isHidden = true;
	        this.base.render((Entity)null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
	        GL11.glPopMatrix();
	        GL11.glPopMatrix();
    }else if(t.form == 0)
    {
    	Minecraft.getMinecraft().renderEngine.bindTexture(Base);        		
        //This rotation part is very important! Without it, your te will render upside-down! And for some reason you DO need PushMatrix again!                       
        GL11.glPushMatrix();
        GL11.glTranslatef((float) x + 0.5F, (float) y + 1.5F, (float) z + 0.5F);
        GL11.glRotatef(180F, 0.0F, 0.0F, 1F);
        this.base.Shape2.isHidden = false;
        this.base.Shape21.isHidden = false;
        this.base.render((Entity)null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
        GL11.glPopMatrix();
        GL11.glPopMatrix();
    }
        

	}

}
