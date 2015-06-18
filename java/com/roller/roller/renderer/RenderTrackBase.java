package com.roller.roller.renderer;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import com.roller.roller.models.ModelTrack45;
import com.roller.roller.models.ModelTrackBase;
import com.roller.roller.models.ModelTrackSide;
import com.roller.roller.models.ModelTrackUeb;
import com.roller.roller.models.ModelTrackUeb2;
import com.roller.roller.models.ModelTrackUeb3;
import com.roller.roller.models.ModelTrackUeb4;
import com.roller.roller.models.tmp;
import com.roller.roller.tileEntity.EntityTrackBase;

public class RenderTrackBase extends RenderError {

	final ModelBase base;


  private static final ResourceLocation field_110807_a = new ResourceLocation("mistery:textures/entities/press.png");
    int i;
    
	public RenderTrackBase()
	{
		base = new ModelTrackBase();       //the ':' is very important
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
       ResourceLocation Base = (new ResourceLocation("roller:textures/entity/TrackBase.png")); 
       ResourceLocation Base2 = (new ResourceLocation("roller:textures/entity/tmp.png")); 
  /**     ResourceLocation side = (new ResourceLocation("roller:textures/entity/TrackSide.png")); 
       ResourceLocation Ueb = (new ResourceLocation("roller:textures/entity/Trackueb.png")); 
       ResourceLocation Ueb2 = (new ResourceLocation("roller:textures/entity/Trackueb2.png")); 
       ResourceLocation curve = (new ResourceLocation("roller:textures/entity/TrackTurn.png")); 
       ResourceLocation train = (new ResourceLocation("roller:textures/entity/Train.png")); */
      Minecraft.getMinecraft().renderEngine.bindTexture(Base);        	
       	//binding the textures

        EntityTrackBase t = (EntityTrackBase)te;
        if(t.color == 1)
        	GL11.glColor3f(1, 0.58F, 0.58F);
        if(t.color == 2)
        	GL11.glColor3f(0.58F, 1, 0.58F);
        if(t.color == 3)
        	GL11.glColor3f(0.58F, 0.58F, 1);
        if(t.base2 == null)
        	t.base2 = new tmp();
        //This rotation part is very important! Without it, your te will render upside-down! And for some reason you DO need PushMatrix again!                       
        GL11.glPushMatrix();
        if(t.alignment == 0)
        {
            GL11.glTranslatef((float) x + 0.5F, (float) y + 1.5F, (float) z + 0.5F);
            GL11.glRotatef(180F, 0.0F, 0.0F, 1F);
            this.base.render((Entity)null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
            GL11.glPopMatrix();
            GL11.glPopMatrix();           
        
            GL11.glPushMatrix();
            Minecraft.getMinecraft().renderEngine.bindTexture(Base2);        	
            GL11.glPushMatrix();
            GL11.glTranslatef((float) x + 0.5F, (float) y + 1.5F, (float) z + 0.5F);
            GL11.glRotatef(180F, 0.0F, 0.0F, 1F);
            if(t.brake|| t.start || t.powerAndBreak)
            	for(int k = 0; k < 4; k++)
            		t.base2.brake[k].isHidden = false;
            else
            	for(int k = 0; k < 4; k++)
            		t.base2.brake[k].isHidden = true;
            if(t.power|| t.start || t.powerAndBreak)
            	t.base2.speed.isHidden = false;
            else
            	t.base2.speed.isHidden = true;
            if(t.start)
            	for(int k = 0; k < 2; k++)
            		t.base2.start[k].isHidden = false;
            else
            	for(int k = 0; k < 2; k++)
            		t.base2.start[k].isHidden = true;

            t.base2.render((Entity)null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
            GL11.glPopMatrix();
            GL11.glPopMatrix();         
        }
        else if(t.alignment == 3)
        {
            GL11.glTranslatef((float) x + 0.5F, (float) y + 1.5F, (float) z + 0.5F);
            GL11.glRotatef(180F, 0.0F, 0.0F, 1F);
        	GL11.glRotatef(90F, 0.0F, 1, 0);
            this.base.render((Entity)null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
            GL11.glPopMatrix();
            GL11.glPopMatrix(); 
            
            GL11.glPushMatrix();
            Minecraft.getMinecraft().renderEngine.bindTexture(Base2);        	
            GL11.glPushMatrix();
            GL11.glTranslatef((float) x + 0.5F, (float) y + 1.5F, (float) z + 0.5F);
            GL11.glRotatef(180F, 0.0F, 0.0F, 1F);
        	GL11.glRotatef(90, 0.0F, 1, 0);      
            if(t.brake|| t.start || t.powerAndBreak)
            	for(int k = 0; k < 4; k++)
            		t.base2.brake[k].isHidden = false;
            else
            	for(int k = 0; k < 4; k++)
            		t.base2.brake[k].isHidden = true;
            if(t.power|| t.start || t.powerAndBreak)
            	t.base2.speed.isHidden = false;
            else
            	t.base2.speed.isHidden = true;
            if(t.start)
            	for(int k = 0; k < 2; k++)
            		t.base2.start[k].isHidden = false;
            else
            	for(int k = 0; k < 2; k++)
            		t.base2.start[k].isHidden = true;
            t.base2.render((Entity)null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
            GL11.glPopMatrix();
            GL11.glPopMatrix();       
        }
        else if(t.alignment == 2)
        {
            GL11.glTranslatef((float) x + 0.5F, (float) y + 1.5F, (float) z + 0.5F);
            GL11.glRotatef(180F, 0.0F, 0.0F, 1F);
        	GL11.glRotatef(180, 0.0F, 1, 0);
            this.base.render((Entity)null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
            GL11.glPopMatrix();
            GL11.glPopMatrix(); 
            
            GL11.glPushMatrix();
            Minecraft.getMinecraft().renderEngine.bindTexture(Base2);        	
            GL11.glPushMatrix();
            GL11.glTranslatef((float) x + 0.5F, (float) y + 1.5F, (float) z + 0.5F);
            GL11.glRotatef(180F, 0.0F, 0.0F, 1F);
        	GL11.glRotatef(180, 0.0F, 1, 0);      
            if(t.brake|| t.start || t.powerAndBreak)
            	for(int k = 0; k < 4; k++)
            		t.base2.brake[k].isHidden = false;
            else
            	for(int k = 0; k < 4; k++)
            		t.base2.brake[k].isHidden = true;
            if(t.power|| t.start || t.powerAndBreak)
            	t.base2.speed.isHidden = false;
            else
            	t.base2.speed.isHidden = true;
            if(t.start)
            	for(int k = 0; k < 2; k++)
            		t.base2.start[k].isHidden = false;
            else
            	for(int k = 0; k < 2; k++)
            		t.base2.start[k].isHidden = true;
            t.base2.render((Entity)null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
            GL11.glPopMatrix();
            GL11.glPopMatrix();           
        }
        else if(t.alignment == 1)
        {
            GL11.glTranslatef((float) x + 0.5F, (float) y + 1.5F, (float) z + 0.5F);
            GL11.glRotatef(180F, 0.0F, 0.0F, 1F);
        	GL11.glRotatef(270, 0.0F, 1, 0);      
            this.base.render((Entity)null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
            GL11.glPopMatrix();
            GL11.glPopMatrix();
            
            GL11.glPushMatrix();
            Minecraft.getMinecraft().renderEngine.bindTexture(Base2);        	
            GL11.glPushMatrix();
            GL11.glTranslatef((float) x + 0.5F, (float) y + 1.5F, (float) z + 0.5F);
            GL11.glRotatef(180F, 0.0F, 0.0F, 1F);
        	GL11.glRotatef(270, 0.0F, 1, 0);      
            if(t.brake || t.start || t.powerAndBreak)
            	for(int k = 0; k < 4; k++)
            		t.base2.brake[k].isHidden = false;
            else
            	for(int k = 0; k < 4; k++)
            		t.base2.brake[k].isHidden = true;
            if(t.power || t.start || t.powerAndBreak)
            	t.base2.speed.isHidden = false;
            else
            	t.base2.speed.isHidden = true;
            if(t.start)
            	for(int k = 0; k < 2; k++)
            		t.base2.start[k].isHidden = false;
            else
            	for(int k = 0; k < 2; k++)
            		t.base2.start[k].isHidden = true;
            t.base2.render((Entity)null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
            GL11.glPopMatrix();
            GL11.glPopMatrix();            
        }

	}

}
