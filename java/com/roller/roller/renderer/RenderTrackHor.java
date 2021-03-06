package com.roller.roller.renderer;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import com.roller.roller.models.ModelTrack45;
import com.roller.roller.models.tmp2;
import com.roller.roller.tileEntity.EntityTrackHor;

public class RenderTrackHor extends RenderError {

	/**final ModelBase base;
	final ModelBase curve;
	final ModelBase ueb;
	final ModelBase ueb1;
	final ModelBase ueb2;
	final ModelBase ueb3;
	final ModelBase side;
	*/final ModelBase t45;

  private static final ResourceLocation field_110807_a = new ResourceLocation("mistery:textures/entities/press.png");
    int i;
    
	public RenderTrackHor()
	{
		/**base = new ModelTrackBase();       //the ':' is very important
		curve = new ModelTrackCurve();       //the ':' is very important
		ueb = new ModelTrackUeb();       //the ':' is very important
		ueb1 = new ModelTrackUeb2();       //the ':' is very important
		ueb2 = new ModelTrackUeb3();       //the ':' is very important
		ueb3 = new ModelTrackUeb4();       //the ':' is very important
		side = new ModelTrackSide();       //the ':' is very important
	*/	t45 = new ModelTrack45();       //the ':' is very important
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
       ResourceLocation u45 = (new ResourceLocation("roller:textures/entity/Track45.png")); 
       ResourceLocation u45_2 = (new ResourceLocation("roller:textures/entity/Track45_2.png")); 
       ResourceLocation Base2 = (new ResourceLocation("roller:textures/entity/tmp2.png")); 
/**       ResourceLocation Ueb2 = (new ResourceLocation("roller:textures/entity/Trackueb2.png")); 
       ResourceLocation curve = (new ResourceLocation("roller:textures/entity/TrackTurn.png")); 
       ResourceLocation train = (new ResourceLocation("roller:textures/entity/Train.png")); */
       	//binding the textures

        EntityTrackHor t = (EntityTrackHor)te;
        if(t.color == 1)
        	GL11.glColor3f(1, 0.58F, 0.58F);
        if(t.color == 2)
        	GL11.glColor3f(0.58F, 1, 0.58F);
        if(t.color == 3)
        	GL11.glColor3f(0.58F, 0.58F, 1);
        if(t.base2 == null)
        	t.base2 = new tmp2();
        Minecraft.getMinecraft().renderEngine.bindTexture(u45);        	

        //This rotation part is very important! Without it, your te will render upside-down! And for some reason you DO need PushMatrix again!                       
        GL11.glPushMatrix();
        if(t.alignment == 2)
        {
            GL11.glTranslatef((float) x + 0.5F, (float) y + 1.5F, (float) z + 0.5F);
            GL11.glRotatef(180F, 0.0F, 0.0F, 1F);
            this.t45.render((Entity)null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);	         
            GL11.glPopMatrix();
            GL11.glPopMatrix(); 
            
            GL11.glPushMatrix();
            Minecraft.getMinecraft().renderEngine.bindTexture(Base2);        	
            GL11.glPushMatrix();
            GL11.glTranslatef((float) x + 0.5F, (float) y + 1.5F, (float) z + 0.5F);
            GL11.glRotatef(180F, 0.0F, 0.0F, 1F);
            GL11.glRotatef(180F, 0.0F, 1, 0);
            if(t.power)
            	for(int k = 0; k < 2; k++)
            		t.base2.power[k].isHidden = false;
            else
            	for(int k = 0; k < 2; k++)
            		t.base2.power[k].isHidden = true;

            t.base2.render((Entity)null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
            GL11.glPopMatrix();
            GL11.glPopMatrix(); 
        }
        else if(t.alignment == 1)
        {
            GL11.glTranslatef((float) x + 0.5F, (float) y + 1.5F, (float) z + 0.5F);
            GL11.glRotatef(180F, 0.0F, 0.0F, 1F);
        	GL11.glRotatef(90F, 0.0F, 1, 0);
            this.t45.render((Entity)null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
            GL11.glPopMatrix();
            GL11.glPopMatrix();   
            
            GL11.glPushMatrix();
            Minecraft.getMinecraft().renderEngine.bindTexture(Base2);        	
            GL11.glPushMatrix();
            GL11.glTranslatef((float) x + 0.5F, (float) y + 1.5F, (float) z + 0.5F);
            GL11.glRotatef(180F, 0.0F, 0.0F, 1F);
        	GL11.glRotatef(270, 0.0F, 1, 0);      
            if(t.power)
            	for(int k = 0; k < 2; k++)
            		t.base2.power[k].isHidden = false;
            else
            	for(int k = 0; k < 2; k++)
            		t.base2.power[k].isHidden = true;

            t.base2.render((Entity)null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
            GL11.glPopMatrix();
            GL11.glPopMatrix(); 
       }
        else if(t.alignment == 0)
        {
            GL11.glTranslatef((float) x + 0.5F, (float) y + 1.5F, (float) z + 0.5F);
            GL11.glRotatef(180F, 0.0F, 0.0F, 1F);
        	GL11.glRotatef(180, 0.0F, 1, 0);           
            this.t45.render((Entity)null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
            GL11.glPopMatrix();
            GL11.glPopMatrix(); 
            
            GL11.glPushMatrix();
            Minecraft.getMinecraft().renderEngine.bindTexture(Base2);        	
            GL11.glPushMatrix();
            GL11.glTranslatef((float) x + 0.5F, (float) y + 1.5F, (float) z + 0.5F);
        	GL11.glRotatef(0, 0.0F, 1, 0);      
            GL11.glRotatef(180, 0.0F, 0.0F, 1F);
            if(t.power)
            	for(int k = 0; k < 2; k++)
            		t.base2.power[k].isHidden = false;
            else
            	for(int k = 0; k < 2; k++)
            		t.base2.power[k].isHidden = true;

            t.base2.render((Entity)null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
            GL11.glPopMatrix();
            GL11.glPopMatrix();  
        }
        else if(t.alignment == 3)
        {
            GL11.glTranslatef((float) x + 0.5F, (float) y + 1.5F, (float) z + 0.5F);
            GL11.glRotatef(180F, 0.0F, 0.0F, 1F);
        	GL11.glRotatef(270, 0.0F, 1, 0);            
            this.t45.render((Entity)null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
            GL11.glPopMatrix();
            GL11.glPopMatrix(); 
            
            GL11.glPushMatrix();
            Minecraft.getMinecraft().renderEngine.bindTexture(Base2);        	
            GL11.glPushMatrix();
            GL11.glTranslatef((float) x + 0.5F, (float) y + 1.5F, (float) z + 0.5F);
            GL11.glRotatef(180F, 0.0F, 0.0F, 1F);
        	GL11.glRotatef(90, 0.0F, 1, 0);      
            if(t.power)
            	for(int k = 0; k < 2; k++)
            		t.base2.power[k].isHidden = false;
            else
            	for(int k = 0; k < 2; k++)
            		t.base2.power[k].isHidden = true;

            t.base2.render((Entity)null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
            GL11.glPopMatrix();
            GL11.glPopMatrix(); 
        }

      /**
        else if(t.alignment == 4)
        {
            GL11.glTranslatef((float) x + 0.5F, (float) y + 0.5F, (float) z + 1.5F);
            GL11.glRotatef(270F, 1, 0.0F, 0);
            if(t.curve == 0 && t.neigungHor == 0)
            {
            	this.base.render((Entity)null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
	            if(t.model != null)
	            {
	            	GL11.glPushMatrix();
	                Minecraft.getMinecraft().renderEngine.bindTexture(train);        	
	            	GL11.glPushMatrix();
	            	GL11.glRotatef(90, 0, 1, 0);
	            	t.model.render((Entity)null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
	            	GL11.glPopMatrix();
	            	GL11.glPopMatrix();
	           }
            }
        }else if(t.alignment == 5)
        {
            GL11.glTranslatef((float) x + 1.5F, (float) y + 0.5F, (float) z + 0.5F);
        	GL11.glRotatef(90F, 0.0F, 1, 0);
            GL11.glRotatef(270, 1, 0.0F, 0);
            if(t.curve == 0 && t.neigungHor == 0)
            {
            	this.base.render((Entity)null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
	            if(t.model != null)
	            {
	            	GL11.glPushMatrix();
	                Minecraft.getMinecraft().renderEngine.bindTexture(train);        	
	            	GL11.glPushMatrix();
	            	GL11.glRotatef(90, 0, 1, 0);
	            	t.model.render((Entity)null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
	            	GL11.glPopMatrix();
	            	GL11.glPopMatrix();
	           }
            }
        }
        else if(t.alignment == 6)
        {
            GL11.glTranslatef((float) x + 0.5F, (float) y + 0.5F, (float) z - 0.5F);
        	GL11.glRotatef(180F, 0.0F, 1, 0);
            GL11.glRotatef(270, 1, 0.0F, 0);
            if(t.curve == 0 && t.neigungHor == 0)
            {
            	this.base.render((Entity)null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
	            if(t.model != null)
	            {
	            	GL11.glPushMatrix();
	                Minecraft.getMinecraft().renderEngine.bindTexture(train);        	
	            	GL11.glPushMatrix();
	            	GL11.glRotatef(90, 0, 1, 0);
	            	t.model.render((Entity)null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
	            	GL11.glPopMatrix();
	            	GL11.glPopMatrix();
	           }
            }
        }
        else if(t.alignment == 7)
        {
            GL11.glTranslatef((float) x - 0.5F, (float) y + 0.5F, (float) z + 0.5F);
        	GL11.glRotatef(270F, 0.0F, 1, 0);
            GL11.glRotatef(270, 1, 0.0F, 0);
            if(t.curve == 0 && t.neigungHor == 0)
            {
            	this.base.render((Entity)null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
	            if(t.model != null)
	            {
	            	GL11.glPushMatrix();
	                Minecraft.getMinecraft().renderEngine.bindTexture(train);        	
	            	GL11.glPushMatrix();
	            	GL11.glRotatef(90, 0, 1, 0);
	            	t.model.render((Entity)null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
	            	GL11.glPopMatrix();
	            	GL11.glPopMatrix();
	           }
            }
        }
        else if(t.alignment == 8)
        {
            GL11.glTranslatef((float) x + 0.5F, (float) y - 0.5F, (float) z + 0.5F);
            if(t.curve == 0 && t.neigungHor == 0)
            {
            	this.base.render((Entity)null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
	            if(t.model != null)
	            {
	            	GL11.glPushMatrix();
	                Minecraft.getMinecraft().renderEngine.bindTexture(train);        	
	            	GL11.glPushMatrix();
	            	GL11.glRotatef(90, 0, 1, 0);
	            	t.model.render((Entity)null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
	            	GL11.glPopMatrix();
	            	GL11.glPopMatrix();
	           }
            }
        }
        else if(t.alignment == 9)
        {
            GL11.glTranslatef((float) x + 0.5F, (float) y - 0.5F, (float) z + 0.5F);
        	GL11.glRotatef(90F, 0.0F, 1, 0);
            if(t.curve == 0 && t.neigungHor == 0)
            {
            	this.base.render((Entity)null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
	            if(t.model != null)
	            {
	            	GL11.glPushMatrix();
	                Minecraft.getMinecraft().renderEngine.bindTexture(train);        	
	            	GL11.glPushMatrix();
	            	GL11.glRotatef(90, 0, 1, 0);
	            	t.model.render((Entity)null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
	            	GL11.glPopMatrix();
	            	GL11.glPopMatrix();
	           }
            }
       }
        else if(t.alignment == 10)
        {
            GL11.glTranslatef((float) x + 0.5F, (float) y - 0.5F, (float) z + 0.5F);
        	GL11.glRotatef(180F, 0.0F, 1, 0);
            if(t.curve == 0 && t.neigungHor == 0)
            {
            	this.base.render((Entity)null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
	            if(t.model != null)
	            {
	            	GL11.glPushMatrix();
	                Minecraft.getMinecraft().renderEngine.bindTexture(train);        	
	            	GL11.glPushMatrix();
	            	GL11.glRotatef(90, 0, 1, 0);
	            	t.model.render((Entity)null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
	            	GL11.glPopMatrix();
	            	GL11.glPopMatrix();
	           }
            }
        }
        else if(t.alignment == 11)
        {
            GL11.glTranslatef((float) x + 0.5F, (float) y - 0.5F, (float) z + 0.5F);
        	GL11.glRotatef(270F, 0.0F, 1, 0);
            if(t.curve == 0 && t.neigungHor == 0)
            {
            	this.base.render((Entity)null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
	            if(t.model != null)
	            {
	            	GL11.glPushMatrix();
	                Minecraft.getMinecraft().renderEngine.bindTexture(train);        	
	            	GL11.glPushMatrix();
	            	GL11.glRotatef(90, 0, 1, 0);
	            	t.model.render((Entity)null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
	            	GL11.glPopMatrix();
	            	GL11.glPopMatrix();
	           }
            }
       }
        
        if(t.neigungHor == 1 && ((t.alignment >= 0 && t.alignment < 4) || (t.alignment >= 8 && t.alignment < 12)))
        {
            Minecraft.getMinecraft().renderEngine.bindTexture(u45);        	
            	this.t45.render((Entity)null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F); 
        }
        else if(t.neigungHor == 2 && ((t.alignment >= 0 && t.alignment < 4) || (t.alignment >= 8 && t.alignment < 12)))
        {
            Minecraft.getMinecraft().renderEngine.bindTexture(side);        	
            	this.side.render((Entity)null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
                if(t.model != null)
                {
                	GL11.glPushMatrix();
                    Minecraft.getMinecraft().renderEngine.bindTexture(train);        	
                	GL11.glPushMatrix();
                	GL11.glRotatef(90, 0, 1, 0);
                	t.model.render((Entity)null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
                	GL11.glPopMatrix();
                	GL11.glPopMatrix();
               }
        }
        else if(t.neigungHor == 3 && ((t.alignment >= 0 && t.alignment < 4) || (t.alignment >= 8 && t.alignment < 12)))
        {
            Minecraft.getMinecraft().renderEngine.bindTexture(Ueb);   
        	GL11.glRotatef(180, 0.0F, 1, 0);
            	this.ueb.render((Entity)null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F); 
                if(t.model != null)
                {
                	GL11.glPushMatrix();
                    Minecraft.getMinecraft().renderEngine.bindTexture(train);        	
                	GL11.glPushMatrix();
                	GL11.glRotatef(90, 0, 1, 0);
                	t.model.render((Entity)null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
                	GL11.glPopMatrix();
                	GL11.glPopMatrix();
               }
        }
        else if(t.neigungHor == 4 && ((t.alignment >= 0 && t.alignment < 4) || (t.alignment >= 8 && t.alignment < 12)))
        {
            Minecraft.getMinecraft().renderEngine.bindTexture(Ueb);   
        	GL11.glRotatef(180, 0.0F, 1, 0);
            	this.ueb1.render((Entity)null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F); 
                if(t.model != null)
                {
                	GL11.glPushMatrix();
                    Minecraft.getMinecraft().renderEngine.bindTexture(train);        	
                	GL11.glPushMatrix();
                	GL11.glRotatef(90, 0, 1, 0);
                	t.model.render((Entity)null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
                	GL11.glPopMatrix();
                	GL11.glPopMatrix();
               }
        }
        else if(t.neigungHor == 5 && ((t.alignment >= 0 && t.alignment < 4) || (t.alignment >= 8 && t.alignment < 12)))
        {
            Minecraft.getMinecraft().renderEngine.bindTexture(Ueb2);   
        	GL11.glRotatef(180, 0.0F, 1, 0);
            	this.ueb2.render((Entity)null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F); 
                if(t.model != null)
                {
                	GL11.glPushMatrix();
                    Minecraft.getMinecraft().renderEngine.bindTexture(train);        	
                	GL11.glPushMatrix();
                	GL11.glRotatef(90, 0, 1, 0);
                	t.model.render((Entity)null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
                	GL11.glPopMatrix();
                	GL11.glPopMatrix();
               }
        }
        else if(t.neigungHor == 6 && ((t.alignment >= 0 && t.alignment < 4) || (t.alignment >= 8 && t.alignment < 12)))
        {
            Minecraft.getMinecraft().renderEngine.bindTexture(Ueb2);   
        	GL11.glRotatef(180, 0.0F, 1, 0);
            	this.ueb3.render((Entity)null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F); 
                if(t.model != null)
                {
                	GL11.glPushMatrix();
                    Minecraft.getMinecraft().renderEngine.bindTexture(train);        	
                	GL11.glPushMatrix();
                	GL11.glRotatef(90, 0, 1, 0);
                	t.model.render((Entity)null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
                	GL11.glPopMatrix();
                	GL11.glPopMatrix();
               }
        }
        
        if(t.curve == 1 && ((t.alignment >= 0 && t.alignment < 4) || (t.alignment >= 8 && t.alignment < 12)) && t.neigungHor == 0)
        {
        	GL11.glRotatef(-90, 0.0F, 1, 0);
            Minecraft.getMinecraft().renderEngine.bindTexture(curve);        	
            this.curve.render((Entity)null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
            if(t.model != null)
            {
            	GL11.glPushMatrix();
                Minecraft.getMinecraft().renderEngine.bindTexture(train);        	
            	GL11.glPushMatrix();
            	GL11.glRotatef(90, 0, 1, 0);
            	t.model.render((Entity)null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
            	GL11.glPopMatrix();
            	GL11.glPopMatrix();
           }
        }
        

       // System.out.println(((EntityTrackBase)t.getWorldObj().getTileEntity(t.xCoord, t.yCoord, t.zCoord)).alignment);
        //Tell it to stop rendering for both the PushMatrix's
        GL11.glPopMatrix();
        GL11.glPopMatrix();
    //	GL11.glPushMatrix();
    	/**
        Minecraft.getMinecraft().renderEngine.bindTexture(train);        	
    	GL11.glPushMatrix();
        float zPlus = 1;
        if(t.alignment == 0)
        {
            if(t.curve == 0 && t.neigungHor == 0)
            {
                GL11.glTranslatef((float) x + 0.5F, (float) y + 1.5F, (float) z + 0.5F+zPlus);
                GL11.glRotatef(90, 0.0F, 1, 0);
                GL11.glRotatef(180F, 0.0F, 0.0F, 1F);
	            if(t.model != null)
	            {
	            	t.model.render((Entity)null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
	           }
            }
        }
        else if(t.alignment == 1)
        {
            if(t.curve == 0 && t.neigungHor == 0)
            {
                GL11.glTranslatef((float) x + 0.5F, (float) y + 1.5F, (float) z + 0.5F);
            	GL11.glRotatef(180, 0, 1, 0);
            	GL11.glRotatef(180F, 0.0F, 0.0F, 1F);
	            if(t.model != null)
	            {
	            	t.model.render((Entity)null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
	           }
            }
       }
        else if(t.alignment == 2)
        {
            if(t.curve == 0 && t.neigungHor == 0)
            {
                GL11.glTranslatef((float) x + 0.5F, (float) y + 1.5F, (float) z + 0.5F+zPlus);
                GL11.glRotatef(270, 0, 1, 0);
                GL11.glRotatef(180F, 0.0F, 0.0F, 1F);
	            if(t.model != null)
	            {
	            	t.model.render((Entity)null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
	           }
            }
        }
        else if(t.alignment == 3)
        {
            if(t.curve == 0 && t.neigungHor == 0)
            {
                GL11.glTranslatef((float) x + 0.5F, (float) y + 1.5F, (float) z + 0.5F);
                GL11.glRotatef(180F, 0.0F, 0.0F, 1F);
	            if(t.model != null)
	            {
	            	t.model.render((Entity)null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
	           }
            }
        }
        /**
        else if(t.alignment == 4)
        {
            GL11.glTranslatef((float) x + 0.5F, (float) y + 0.5F, (float) z + 1.5F);
            GL11.glRotatef(270F, 1, 0.0F, 0);
            if(t.curve == 0 && t.neigungHor == 0)
            {
            	this.base.render((Entity)null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
	            if(t.model != null)
	            {
	            	GL11.glPushMatrix();
	                Minecraft.getMinecraft().renderEngine.bindTexture(train);        	
	            	GL11.glPushMatrix();
	            	GL11.glRotatef(90, 0, 1, 0);
	            	t.model.render((Entity)null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
	            	GL11.glPopMatrix();
	            	GL11.glPopMatrix();
	           }
            }
        }else if(t.alignment == 5)
        {
            GL11.glTranslatef((float) x + 1.5F, (float) y + 0.5F, (float) z + 0.5F);
        	GL11.glRotatef(90F, 0.0F, 1, 0);
            GL11.glRotatef(270, 1, 0.0F, 0);
            if(t.curve == 0 && t.neigungHor == 0)
            {
            	this.base.render((Entity)null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
	            if(t.model != null)
	            {
	            	GL11.glPushMatrix();
	                Minecraft.getMinecraft().renderEngine.bindTexture(train);        	
	            	GL11.glPushMatrix();
	            	GL11.glRotatef(90, 0, 1, 0);
	            	t.model.render((Entity)null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
	            	GL11.glPopMatrix();
	            	GL11.glPopMatrix();
	           }
            }
        }
        else if(t.alignment == 6)
        {
            GL11.glTranslatef((float) x + 0.5F, (float) y + 0.5F, (float) z - 0.5F);
        	GL11.glRotatef(180F, 0.0F, 1, 0);
            GL11.glRotatef(270, 1, 0.0F, 0);
            if(t.curve == 0 && t.neigungHor == 0)
            {
            	this.base.render((Entity)null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
	            if(t.model != null)
	            {
	            	GL11.glPushMatrix();
	                Minecraft.getMinecraft().renderEngine.bindTexture(train);        	
	            	GL11.glPushMatrix();
	            	GL11.glRotatef(90, 0, 1, 0);
	            	t.model.render((Entity)null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
	            	GL11.glPopMatrix();
	            	GL11.glPopMatrix();
	           }
            }
        }
        else if(t.alignment == 7)
        {
            GL11.glTranslatef((float) x - 0.5F, (float) y + 0.5F, (float) z + 0.5F);
        	GL11.glRotatef(270F, 0.0F, 1, 0);
            GL11.glRotatef(270, 1, 0.0F, 0);
            if(t.curve == 0 && t.neigungHor == 0)
            {
            	this.base.render((Entity)null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
	            if(t.model != null)
	            {
	            	GL11.glPushMatrix();
	                Minecraft.getMinecraft().renderEngine.bindTexture(train);        	
	            	GL11.glPushMatrix();
	            	GL11.glRotatef(90, 0, 1, 0);
	            	t.model.render((Entity)null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
	            	GL11.glPopMatrix();
	            	GL11.glPopMatrix();
	           }
            }
        }
        else if(t.alignment == 8)
        {
            GL11.glTranslatef((float) x + 0.5F, (float) y - 0.5F, (float) z + 0.5F);
            if(t.curve == 0 && t.neigungHor == 0)
            {
            	this.base.render((Entity)null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
	            if(t.model != null)
	            {
	            	GL11.glPushMatrix();
	                Minecraft.getMinecraft().renderEngine.bindTexture(train);        	
	            	GL11.glPushMatrix();
	            	GL11.glRotatef(90, 0, 1, 0);
	            	t.model.render((Entity)null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
	            	GL11.glPopMatrix();
	            	GL11.glPopMatrix();
	           }
            }
        }
        else if(t.alignment == 9)
        {
            GL11.glTranslatef((float) x + 0.5F, (float) y - 0.5F, (float) z + 0.5F);
        	GL11.glRotatef(90F, 0.0F, 1, 0);
            if(t.curve == 0 && t.neigungHor == 0)
            {
            	this.base.render((Entity)null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
	            if(t.model != null)
	            {
	            	GL11.glPushMatrix();
	                Minecraft.getMinecraft().renderEngine.bindTexture(train);        	
	            	GL11.glPushMatrix();
	            	GL11.glRotatef(90, 0, 1, 0);
	            	t.model.render((Entity)null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
	            	GL11.glPopMatrix();
	            	GL11.glPopMatrix();
	           }
            }
       }
        else if(t.alignment == 10)
        {
            GL11.glTranslatef((float) x + 0.5F, (float) y - 0.5F, (float) z + 0.5F);
        	GL11.glRotatef(180F, 0.0F, 1, 0);
            if(t.curve == 0 && t.neigungHor == 0)
            {
            	this.base.render((Entity)null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
	            if(t.model != null)
	            {
	            	GL11.glPushMatrix();
	                Minecraft.getMinecraft().renderEngine.bindTexture(train);        	
	            	GL11.glPushMatrix();
	            	GL11.glRotatef(90, 0, 1, 0);
	            	t.model.render((Entity)null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
	            	GL11.glPopMatrix();
	            	GL11.glPopMatrix();
	           }
            }
        }
        else if(t.alignment == 11)
        {
            GL11.glTranslatef((float) x + 0.5F, (float) y - 0.5F, (float) z + 0.5F);
        	GL11.glRotatef(270F, 0.0F, 1, 0);
            if(t.curve == 0 && t.neigungHor == 0)
            {
            	this.base.render((Entity)null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
	            if(t.model != null)
	            {
	            	GL11.glPushMatrix();
	                Minecraft.getMinecraft().renderEngine.bindTexture(train);        	
	            	GL11.glPushMatrix();
	            	GL11.glRotatef(90, 0, 1, 0);
	            	t.model.render((Entity)null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
	            	GL11.glPopMatrix();
	            	GL11.glPopMatrix();
	           }
            }
       }
        
        if(t.neigungHor == 1 && ((t.alignment >= 0 && t.alignment < 4)))
        {
                if(t.model != null)
                {
                    if(t.alignment == 0)
                    {
                        GL11.glTranslatef((float) x + 0.5F, (float) y , (float) z -0.5F);
                    	GL11.glRotatef(270, 0, 1, 0);
                    }
                    else if(t.alignment == 1)
                    {
                        GL11.glTranslatef((float) x + 1.5F, (float) y , (float) z +0.5F);
                    	GL11.glRotatef(180, 0, 1, 0);
                    }
                    else if(t.alignment == 2)
                    {
                        GL11.glTranslatef((float) x + 0.5F, (float) y , (float) z +1.5F);
                    	GL11.glRotatef(90, 0, 1, 0);
                    }else
                        GL11.glTranslatef((float) x - 0.5F, (float) y , (float) z +0.5F);

                	GL11.glRotatef(-45, 0, 0, 1);
                	t.model.render((Entity)null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
               }
        }
        else if(t.neigungHor == 1 && (t.alignment >= 8 && t.alignment < 12))
        {
                if(t.model != null)
                {
                    if(t.alignment == 10)
                    {
                        GL11.glTranslatef((float) x + 0.5F, (float) y +1F, (float) z +1.5F);
                    	GL11.glRotatef(270, 0, 1, 0);
                    }
                    else if(t.alignment == 9)
                    {
                        GL11.glTranslatef((float) x - 0.5F, (float) y +1F, (float) z +0.5F);
                    	GL11.glRotatef(180, 0, 1, 0);
                    }
                    else if(t.alignment == 8)
                    {
                        GL11.glTranslatef((float) x + 0.5F, (float) y +1F, (float) z -0.5F);
                    	GL11.glRotatef(90, 0, 1, 0);
                    }else
                        GL11.glTranslatef((float) x + 1.5F, (float) y +1F, (float) z +0.5F);

                	GL11.glRotatef(-45-180, 0, 0, 1);
                	t.model.render((Entity)null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
               }
        }
        else if(t.neigungHor == 2 && ((t.alignment >= 0 && t.alignment < 4) || (t.alignment >= 8 && t.alignment < 12)))
        {
            Minecraft.getMinecraft().renderEngine.bindTexture(side);        	
            	this.side.render((Entity)null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
                if(t.model != null)
                {
                	GL11.glPushMatrix();
                    Minecraft.getMinecraft().renderEngine.bindTexture(train);        	
                	GL11.glPushMatrix();
                	GL11.glRotatef(90, 0, 1, 0);
                	t.model.render((Entity)null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
                	GL11.glPopMatrix();
                	GL11.glPopMatrix();
               }
        }
        else if(t.neigungHor == 3 && ((t.alignment >= 0 && t.alignment < 4) || (t.alignment >= 8 && t.alignment < 12)))
        {
            Minecraft.getMinecraft().renderEngine.bindTexture(Ueb);   
        	GL11.glRotatef(180, 0.0F, 1, 0);
            	this.ueb.render((Entity)null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F); 
                if(t.model != null)
                {
                	GL11.glPushMatrix();
                    Minecraft.getMinecraft().renderEngine.bindTexture(train);        	
                	GL11.glPushMatrix();
                	GL11.glRotatef(90, 0, 1, 0);
                	t.model.render((Entity)null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
                	GL11.glPopMatrix();
                	GL11.glPopMatrix();
               }
        }
        else if(t.neigungHor == 4 && ((t.alignment >= 0 && t.alignment < 4) || (t.alignment >= 8 && t.alignment < 12)))
        {
            Minecraft.getMinecraft().renderEngine.bindTexture(Ueb);   
        	GL11.glRotatef(180, 0.0F, 1, 0);
            	this.ueb1.render((Entity)null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F); 
                if(t.model != null)
                {
                	GL11.glPushMatrix();
                    Minecraft.getMinecraft().renderEngine.bindTexture(train);        	
                	GL11.glPushMatrix();
                	GL11.glRotatef(90, 0, 1, 0);
                	t.model.render((Entity)null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
                	GL11.glPopMatrix();
                	GL11.glPopMatrix();
               }
        }
        else if(t.neigungHor == 5 && ((t.alignment >= 0 && t.alignment < 4) || (t.alignment >= 8 && t.alignment < 12)))
        {
            Minecraft.getMinecraft().renderEngine.bindTexture(Ueb2);   
        	GL11.glRotatef(180, 0.0F, 1, 0);
            	this.ueb2.render((Entity)null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F); 
                if(t.model != null)
                {
                	GL11.glPushMatrix();
                    Minecraft.getMinecraft().renderEngine.bindTexture(train);        	
                	GL11.glPushMatrix();
                	GL11.glRotatef(90, 0, 1, 0);
                	t.model.render((Entity)null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
                	GL11.glPopMatrix();
                	GL11.glPopMatrix();
               }
        }
        else if(t.neigungHor == 6 && ((t.alignment >= 0 && t.alignment < 4) || (t.alignment >= 8 && t.alignment < 12)))
        {
            Minecraft.getMinecraft().renderEngine.bindTexture(Ueb2);   
        	GL11.glRotatef(180, 0.0F, 1, 0);
            	this.ueb3.render((Entity)null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F); 
                if(t.model != null)
                {
                	GL11.glPushMatrix();
                    Minecraft.getMinecraft().renderEngine.bindTexture(train);        	
                	GL11.glPushMatrix();
                	GL11.glRotatef(90, 0, 1, 0);
                	t.model.render((Entity)null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
                	GL11.glPopMatrix();
                	GL11.glPopMatrix();
               }
        }
        
        if(t.curve == 1 && ((t.alignment >= 0 && t.alignment < 4) || (t.alignment >= 8 && t.alignment < 12)) && t.neigungHor == 0)
        {
        	GL11.glRotatef(-90, 0.0F, 1, 0);
            Minecraft.getMinecraft().renderEngine.bindTexture(curve);        	
            this.curve.render((Entity)null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
            if(t.model != null)
            {
            	GL11.glPushMatrix();
                Minecraft.getMinecraft().renderEngine.bindTexture(train);        	
            	GL11.glPushMatrix();
            	GL11.glRotatef(90, 0, 1, 0);
            	t.model.render((Entity)null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
            	GL11.glPopMatrix();
            	GL11.glPopMatrix();
           }
        }
    	GL11.glPopMatrix();
    	GL11.glPopMatrix();*/
	}

}
