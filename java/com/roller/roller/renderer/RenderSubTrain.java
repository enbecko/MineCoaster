package com.roller.roller.renderer;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import com.roller.roller.models.ModelSubTrain;
import com.roller.roller.tileEntity.Base;
import com.roller.roller.tileEntity.EntitySubTrain;
import com.roller.roller.tileEntity.EntityTrack225;
import com.roller.roller.tileEntity.EntityTrack225Top;
import com.roller.roller.tileEntity.EntityTrack225_2;
import com.roller.roller.tileEntity.EntityTrack225_2Top;
import com.roller.roller.tileEntity.EntityTrackBase;
import com.roller.roller.tileEntity.EntityTrackBaseTop;
import com.roller.roller.tileEntity.EntityTrackBaseWater;
import com.roller.roller.tileEntity.EntityTrackHor;
import com.roller.roller.tileEntity.EntityTrackHorTop;
import com.roller.roller.tileEntity.EntityTrackPitched;
import com.roller.roller.tileEntity.EntityTrackPitchedCurve;
import com.roller.roller.tileEntity.EntityTrackQuerTop;
import com.roller.roller.tileEntity.EntityTrackTransition;
import com.roller.roller.tileEntity.EntityTrackUp;
import com.roller.roller.tileEntity.EntityTrain;

public class RenderSubTrain extends Render
{
    private static final ResourceLocation t = new ResourceLocation("roller:textures/entity/subTrain.png");
    /** instance of ModelBoat for rendering */
    protected ModelSubTrain modelBoat;
    private static final String __OBFID = "CL_00000981";

    public RenderSubTrain()
    {
        this.shadowSize = 0.5F;
    }

    /**
     * Actually renders the given argument. This is a synthetic bridge method, always casting down its argument and then
     * handing it off to a worker function which does the actual work. In all probabilty, the class Render is generic
     * (Render<T extends Entity) and this method has signature public void func_76986_a(T entity, double d, double d1,
     * double d2, float f, float f1). But JAD is pre 1.5 so doesn't do that.
     */
    public void doRender(EntitySubTrain te, double x, double y, double z, float par8, float par9)
    {
        GL11.glPushMatrix();
//This is setting the initial location.
        Minecraft.getMinecraft().renderEngine.bindTexture(t);
        GL11.glColor3f(1, 1, 1);

       // GL11.glEnable( GL11.GL_BLEND );
      /*//  GL11.glRotatef(te.rot, 0.0F, 0.0F, 1.0F);
        GL11.glTranslatef((float) x , (float) y + 1.9F, (float) z);
        GL11.glPushMatrix();
        GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
        GL11.glRotatef(te.turn, 0.0F, 1, 0);*/
        boolean cock = false;
        if(te.transition && (te.transAim instanceof EntityTrackHor || te.transAim instanceof EntityTrackBase || te.transAim instanceof EntityTrack225 || te.transAim instanceof EntityTrack225_2 || (te.transAim instanceof EntityTrackUp && te.transAct.getClass().toString().contains("Top") == false)))
        {
        	float part = 1-(float)te.transitionDisPart/te.transitionDisFull;

        	float aimYFD = 0, aimXZFD= 0, aimYFU= 0, aimXZFU= 0, aimTFT= 0, actYFD= 0, actXZFD= 0, actYFU= 0, actXZFU= 0, actTFT= 0;
        	if(te.transAim instanceof EntityTrackHor)
        	{ aimTFT = ((EntityTrackHor)te.transAim).turnForTrans; aimYFD = ((EntityTrackHor)te.transAim).yForDown; aimXZFD = ((EntityTrackHor)te.transAim).xForDown; aimYFU = ((EntityTrackHor)te.transAim).yForUp; aimXZFU = ((EntityTrackHor)te.transAim).xForUp;}
        	else if(te.transAim instanceof EntityTrackBase)
        	{ aimTFT = ((EntityTrackBase)te.transAim).turnForTrans; aimYFD = ((EntityTrackBase)te.transAim).yForDown; aimXZFD = ((EntityTrackBase)te.transAim).xForDown; aimYFU = ((EntityTrackBase)te.transAim).yForUp; aimXZFU = ((EntityTrackBase)te.transAim).xForUp;}
        	else if(te.transAim instanceof EntityTrack225)
        	{ aimTFT = ((EntityTrack225)te.transAim).getTFT(); aimYFD = ((EntityTrack225)te.transAim).getyForDown(); aimXZFD = ((EntityTrack225)te.transAim).getxzForDown(); aimYFU = ((EntityTrack225)te.transAim).getyForUp(); aimXZFU = ((EntityTrack225)te.transAim).getxzForUp();}
        	else if(te.transAim instanceof EntityTrack225_2)
        	{ aimTFT = ((EntityTrack225_2)te.transAim).getTFT(); aimYFD = ((EntityTrack225_2)te.transAim).getyForDown(); aimXZFD = ((EntityTrack225_2)te.transAim).getxzForDown(); aimYFU = ((EntityTrack225_2)te.transAim).getyForUp(); aimXZFU = ((EntityTrack225_2)te.transAim).getxzForUp();}
        	else if(te.transAim instanceof EntityTrackUp)
        	{ aimTFT = ((EntityTrackUp)te.transAim).turnForTrans; aimYFD = ((EntityTrackUp)te.transAim).yForDown; aimXZFD = ((EntityTrackUp)te.transAim).xForDown; aimYFU = ((EntityTrackUp)te.transAim).yForUp; aimXZFU = ((EntityTrackUp)te.transAim).xForUp;}
        	else if(te.transAim instanceof EntityTrackHorTop)
        	{ aimTFT = ((EntityTrackHorTop)te.transAim).turnForTrans; aimYFD = ((EntityTrackHorTop)te.transAim).yForDown; aimXZFD = ((EntityTrackHorTop)te.transAim).xForDown; aimYFU = ((EntityTrackHorTop)te.transAim).yForUp; aimXZFU = ((EntityTrackHorTop)te.transAim).xForUp;}
        	
        	if(te.transAct instanceof EntityTrackBase)
        	{ actTFT = ((EntityTrackBase)te.transAct).turnForTrans; actYFD = ((EntityTrackBase)te.transAct).yForDown; actXZFD = ((EntityTrackBase)te.transAct).xForDown; actYFU = ((EntityTrackBase)te.transAct).yForUp; actXZFU = ((EntityTrackBase)te.transAct).xForUp;}
        	else if(te.transAct instanceof EntityTrackHor)
        	{ actTFT = ((EntityTrackHor)te.transAct).turnForTrans; actYFD = ((EntityTrackHor)te.transAct).yForDown; actXZFD = ((EntityTrackHor)te.transAct).xForDown; actYFU = ((EntityTrackHor)te.transAct).yForUp; actXZFU = ((EntityTrackHor)te.transAct).xForUp;}
        	else if(te.transAct instanceof EntityTrack225)
        	{ actTFT = ((EntityTrack225)te.transAct).getTFT(); actYFD = ((EntityTrack225)te.transAct).getyForDown(); actXZFD = ((EntityTrack225)te.transAct).getxzForDown(); actYFU = ((EntityTrack225)te.transAct).getyForUp(); actXZFU = ((EntityTrack225)te.transAct).getxzForUp();}
        	else if(te.transAct instanceof EntityTrack225_2)
        	{ actTFT = ((EntityTrack225_2)te.transAct).getTFT(); actYFD = ((EntityTrack225_2)te.transAct).getyForDown(); actXZFD = ((EntityTrack225_2)te.transAct).getxzForDown(); actYFU = ((EntityTrack225_2)te.transAct).getyForUp(); actXZFU = ((EntityTrack225_2)te.transAct).getxzForUp();}
        	else if(te.transAct instanceof EntityTrackUp)
        	{ actTFT = ((EntityTrackUp)te.transAct).turnForTrans; actYFD = ((EntityTrackUp)te.transAct).yForDown; actXZFD = ((EntityTrackUp)te.transAct).xForDown; actYFU = ((EntityTrackUp)te.transAct).yForUp; actXZFU = ((EntityTrackUp)te.transAct).xForUp;}
        	else if(te.transAct instanceof EntityTrackHorTop)
        	{ actTFT = ((EntityTrackHorTop)te.transAct).turnForTrans; actYFD = ((EntityTrackHorTop)te.transAct).yForDown; actXZFD = ((EntityTrackHorTop)te.transAct).xForDown; actYFU = ((EntityTrackHorTop)te.transAct).yForUp; actXZFU = ((EntityTrackHorTop)te.transAct).xForUp;}
        	
        	if(te.transAim instanceof EntityTrackBase)
        		te.transAim.down = te.transAct.down;
        	
        	float yOff = (float) ((-4*Math.pow(part-0.5,2))+1);
        	float yling = 0;
	    	int mul = te.act instanceof EntityTrackUp ? -1 : 1;
        	if(te.transAct instanceof EntityTrackHor || te.transAim instanceof EntityTrackHor)
        		yling = 0.15F;
        	if(te.transAct instanceof EntityTrack225 || te.transAim instanceof EntityTrack225||te.transAct instanceof EntityTrack225_2 || te.transAim instanceof EntityTrack225_2)
        		yling = 0.05F;
        	if(te.act instanceof EntityTrackUp)
        		System.out.println(te.turn);
	    	if((te.act instanceof EntityTrackUp == false && te.turn == 90) || (te.act instanceof EntityTrackUp && te.turn == 270 && te.act.down)|| (te.act instanceof EntityTrackUp && te.turn == 90 && !te.act.down))
        	{
	    		if((te.act instanceof EntityTrackUp && te.turn == 90 && te.act.down && te.transAim instanceof EntityTrackUp))
	    		{
	    			mul = 1;
	    		}
		       if(((Base)te.transAim).down)
		       {
		       	 	GL11.glTranslatef((float) x , (float) y +actYFD-((actYFD-aimYFD)*part)+yling*yOff, (float) z+(actXZFD-((actXZFD-aimXZFD)*part))+yling*yOff);
		       	 	GL11.glPushMatrix();
			        GL11.glRotatef(180, 0, 0.0F, 1);
			        GL11.glRotatef(-(actTFT-((actTFT-aimTFT)*part)), 1, 0.0F, 0);
			        GL11.glRotatef(te.turn*mul, 0.0F, 1, 0);
			        if(te.riddenByEntity != null && cock)
			        	te.riddenByEntity.rotationPitch = (actTFT-(float)((actTFT-aimTFT)*part))+30;

		       }else
		       {
			       	GL11.glTranslatef((float) x , (float) y +(actYFU-((actYFU-aimYFU)*part))+yling*yOff, (float) z-(actXZFU-((actXZFU-aimXZFU)*part))-yling*yOff);
		       	 	GL11.glPushMatrix();
			        GL11.glRotatef(180, 0, 0.0F, 1);
			        GL11.glRotatef((actTFT-(float)((actTFT-aimTFT)*part)), 1, 0.0F, 0);
			        GL11.glRotatef(te.turn, 0.0F, 1, 0);
			        if(te.riddenByEntity != null&& cock)
			        	te.riddenByEntity.rotationPitch = -(actTFT-(float)((actTFT-aimTFT)*part))+30;
		       }
        	}else if((te.act instanceof EntityTrackUp == false && te.turn == 0) || (te.act instanceof EntityTrackUp && te.turn == 180 && te.act.down) || (te.act instanceof EntityTrackUp && te.turn == 0 && !te.act.down))
        	{
	    		if((te.act instanceof EntityTrackUp && te.turn == 180 && te.act.down))
	    		{
	    			mul = 0;
	    		}
	       	 if(((Base)te.transAim).down)
		       {
		       	 	GL11.glTranslatef((float) x +(actXZFD-((actXZFD-aimXZFD)*part))+yling*yOff, (float) y +actYFD-((actYFD-aimYFD)*part)+yling*yOff, (float) z);
		       	 	GL11.glPushMatrix();
			        GL11.glRotatef(180, 0, 0.0F, 1);
			        GL11.glRotatef(-(actTFT-((actTFT-aimTFT)*part)), 0, 0.0F, 1);
			        GL11.glRotatef(-te.turn*mul, 0.0F, 1, 0);
			        if(te.riddenByEntity != null&& cock)
			        	te.riddenByEntity.rotationPitch = (actTFT-(float)((actTFT-aimTFT)*part))+30;

		       }else
		       {
		       	 	GL11.glTranslatef((float) x -(actXZFU-((actXZFU-aimXZFU)*part))-yling*yOff, (float) y +(actYFU-((actYFU-aimYFU)*part))+yling*yOff, (float) z);
		       	 	GL11.glPushMatrix();
			        GL11.glRotatef(180, 0, 0.0F, 1);
			        GL11.glRotatef((actTFT-((actTFT-aimTFT)*part)), 0, 0.0F, 1);
			       	GL11.glRotatef(te.turn*mul, 0.0F, 1, 0);
			        if(te.riddenByEntity != null&& cock)
			        	te.riddenByEntity.rotationPitch = -(actTFT-(float)((actTFT-aimTFT)*part))+30;

		       }

	    	}else if((te.act instanceof EntityTrackUp == false && te.turn == 270) || (te.act instanceof EntityTrackUp && te.turn == 90 && te.act.down)|| (te.act instanceof EntityTrackUp && te.turn == 270 && !te.act.down))
        	{
	    		if((te.act instanceof EntityTrackUp && te.turn == 270 && te.act.down && te.transAim instanceof EntityTrackUp))
	    		{
	    			mul = 1;
	    		}
	       	 	if(!((Base)te.transAim).down)
	       	 	{
		       	 	GL11.glTranslatef((float) x , (float) y +(actYFU-((actYFU-aimYFU)*part))+yling*yOff, (float) z+(actXZFU-((actXZFU-aimXZFU)*part))+yling*yOff);
		       	 	GL11.glPushMatrix();
		       	 	GL11.glRotatef(180, 0, 0.0F, 1);
			        GL11.glRotatef(-(actTFT-((actTFT-aimTFT)*part)), 1, 0.0F, 0);
			        GL11.glRotatef(te.turn, 0.0F, 1, 0);
			        if(te.riddenByEntity != null&& cock)
			        	te.riddenByEntity.rotationPitch = -(actTFT-(float)((actTFT-aimTFT)*part))+30;

	       	 	}else
	       	 	{	       	 	
	       	 		GL11.glTranslatef((float) x , (float) y +actYFD-((actYFD-aimYFD)*part)+yling*yOff, (float) z-(actXZFD-((actXZFD-aimXZFD)*part))-yling*yOff);
	       	 		GL11.glPushMatrix();
	       	 		GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
			        GL11.glRotatef((actTFT-((actTFT-aimTFT)*part)), 1, 0.0F, 0);
			        GL11.glRotatef(te.turn*mul, 0.0F, 1, 0);
			        if(te.riddenByEntity != null&& cock)
			        	te.riddenByEntity.rotationPitch = (actTFT-(float)((actTFT-aimTFT)*part))+30;

	       	 	}
	       	 		
        	}else if((te.act instanceof EntityTrackUp == false && te.turn == 180) || (te.act instanceof EntityTrackUp && te.turn == 0 && te.act.down) || (te.act instanceof EntityTrackUp && te.turn == 180 && !te.act.down))
        	{
        		int tmp = 0;
	    		if((te.act instanceof EntityTrackUp && te.turn == 0 && te.act.down))
	    		{
	    			tmp = 180;
	    		}
	       	 	if(!((Base)te.transAim).down)
	       	 	{
		       	 	GL11.glTranslatef((float) x+(actXZFU-((actXZFU-aimXZFU)*part))+yling*yOff, (float) y+(actYFU-((actYFU-aimYFU)*part))+yling*yOff, (float) z);
		       	 	GL11.glPushMatrix();
			        GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
			        GL11.glRotatef(-(actTFT-((actTFT-aimTFT)*part)), 0, 0.0F, 1);
			        GL11.glRotatef(-te.turn*mul+tmp, 0.0F, 1, 0);
			        if(te.riddenByEntity != null&& cock)
			        	te.riddenByEntity.rotationPitch = -(actTFT-(float)((actTFT-aimTFT)*part))+30;

	       	 	}else
	       	 	{
		       	 	GL11.glTranslatef((float) x-(actXZFD-((actXZFD-aimXZFD)*part))-yling*yOff, (float) y+actYFD-((actYFD-aimYFD)*part)+yling*yOff, (float) z);
		       	 	GL11.glPushMatrix();
	       	 		GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
			        GL11.glRotatef((actTFT-((actTFT-aimTFT)*part)), 0, 0.0F, 1);
			        GL11.glRotatef(-te.turn*mul+tmp, 0.0F, 1, 0);
			        if(te.riddenByEntity != null&& cock)
			        	te.riddenByEntity.rotationPitch = (actTFT-(float)((actTFT-aimTFT)*part))+30;

	       	 	}
        	}
	        if(te.riddenByEntity != null)
	        {
	        	te.riddenByEntity.rotationPitch = MathHelper.wrapAngleTo180_float(te.riddenByEntity.rotationPitch);
	        }
        }else if(te.transition && (te.transAim instanceof EntityTrackBaseTop || te.transAim instanceof EntityTrackHorTop || te.transAim instanceof EntityTrack225_2Top || te.transAim instanceof EntityTrack225Top|| te.transAim instanceof EntityTrackUp))
        {
        	float part = 1-(float)te.transitionDisPart/te.transitionDisFull;

	    	float aimYFD = 0, aimXZFD= 0, aimYFU= 0, aimXZFU= 0, aimTFT= 0, actYFD= 0, actXZFD= 0, actYFU= 0, actXZFU= 0, actTFT= 0;
	    	if(te.transAim instanceof EntityTrackBaseTop)
	    	{ aimTFT = ((EntityTrackBaseTop)te.transAim).turnForTrans; aimYFD = ((EntityTrackBaseTop)te.transAim).yForDown; aimXZFD = ((EntityTrackBaseTop)te.transAim).xForDown; aimYFU = ((EntityTrackBaseTop)te.transAim).yForUp; aimXZFU = ((EntityTrackBaseTop)te.transAim).xForUp;}
	    	else if(te.transAim instanceof EntityTrackHorTop)
	    	{ aimTFT = ((EntityTrackHorTop)te.transAim).turnForTrans; aimYFD = ((EntityTrackHorTop)te.transAim).yForDown; aimXZFD = ((EntityTrackHorTop)te.transAim).xForDown; aimYFU = ((EntityTrackHorTop)te.transAim).yForUp; aimXZFU = ((EntityTrackHorTop)te.transAim).xForUp;}
	    	else if(te.transAim instanceof EntityTrack225_2Top)
        	{ aimTFT = ((EntityTrack225_2Top)te.transAim).getTFT(); aimYFD = ((EntityTrack225_2Top)te.transAim).getyForDown(); aimXZFD = ((EntityTrack225_2Top)te.transAim).getxzForDown(); aimYFU = ((EntityTrack225_2Top)te.transAim).getyForUp(); aimXZFU = ((EntityTrack225_2Top)te.transAim).getxzForUp();}
	    	else if(te.transAim instanceof EntityTrack225Top)
        	{ aimTFT = ((EntityTrack225Top)te.transAim).getTFT(); aimYFD = ((EntityTrack225Top)te.transAim).getyForDown(); aimXZFD = ((EntityTrack225Top)te.transAim).getxzForDown(); aimYFU = ((EntityTrack225Top)te.transAim).getyForUp(); aimXZFU = ((EntityTrack225Top)te.transAim).getxzForUp();}
	    	else if(te.transAim instanceof EntityTrackUp)
	    	{ aimTFT = ((EntityTrackUp)te.transAim).turnForTrans; aimYFD = ((EntityTrackUp)te.transAim).yForDown; aimXZFD = -((EntityTrackUp)te.transAim).xForDown; aimYFU = ((EntityTrackUp)te.transAim).yForUp; aimXZFU = -((EntityTrackUp)te.transAim).xForUp;}
	    	
	    	if(te.transAct instanceof EntityTrackBaseTop)
	    	{ actTFT = ((EntityTrackBaseTop)te.transAct).turnForTrans; actYFD = ((EntityTrackBaseTop)te.transAct).yForDown; actXZFD = ((EntityTrackBaseTop)te.transAct).xForDown; actYFU = ((EntityTrackBaseTop)te.transAct).yForUp; actXZFU = ((EntityTrackBaseTop)te.transAct).xForUp;}
	    	else if(te.transAct instanceof EntityTrackHorTop)
	    	{ actTFT = ((EntityTrackHorTop)te.transAct).turnForTrans; actYFD = ((EntityTrackHorTop)te.transAct).yForDown; actXZFD = ((EntityTrackHorTop)te.transAct).xForDown; actYFU = ((EntityTrackHorTop)te.transAct).yForUp; actXZFU = ((EntityTrackHorTop)te.transAct).xForUp;}
	    	else if(te.transAct instanceof EntityTrack225_2Top)
        	{ actTFT = ((EntityTrack225_2Top)te.transAct).getTFT(); actYFD = ((EntityTrack225_2Top)te.transAct).getyForDown(); actXZFD = ((EntityTrack225_2Top)te.transAct).getxzForDown(); actYFU = ((EntityTrack225_2Top)te.transAct).getyForUp(); actXZFU = ((EntityTrack225_2Top)te.transAct).getxzForUp();}
	    	else if(te.transAct instanceof EntityTrack225Top)
        	{ actTFT = ((EntityTrack225Top)te.transAct).getTFT(); actYFD = ((EntityTrack225Top)te.transAct).getyForDown(); actXZFD = ((EntityTrack225Top)te.transAct).getxzForDown(); actYFU = ((EntityTrack225Top)te.transAct).getyForUp(); actXZFU = ((EntityTrack225Top)te.transAct).getxzForUp();}
	    	else if(te.transAct instanceof EntityTrackUp)
	    	{ actTFT = ((EntityTrackUp)te.transAct).turnForTrans; actYFD = ((EntityTrackUp)te.transAct).yForDown; actXZFD = -((EntityTrackUp)te.transAct).xForDown; actYFU = ((EntityTrackUp)te.transAct).yForUp; actXZFU = -((EntityTrackUp)te.transAct).xForUp;}
	    	
	    	if(te.transAim instanceof EntityTrackBaseTop)
	    		te.transAim.down = te.transAct.down;	    	

	    	float yOff = (float) ((-4*Math.pow(part-0.5,2))+1);
	    	float yling = 0;
	    	int mul = te.act instanceof EntityTrackUp ? -1 : 1;
	    	if(te.transAct instanceof EntityTrackHorTop || te.transAim instanceof EntityTrackHorTop)
	    		yling = 0.2F;
	    	if(te.transAct instanceof EntityTrack225Top || te.transAim instanceof EntityTrack225Top||te.transAct instanceof EntityTrack225_2Top || te.transAim instanceof EntityTrack225_2Top)
	    		yling = 0.05F;
	    	
	    	if((te.act instanceof EntityTrackUp == false && te.turn == 90) || (te.act instanceof EntityTrackUp && te.turn == 270 && !te.act.down) || (te.act instanceof EntityTrackUp && te.turn == 90 && te.act.down))
	    	{
	    		
		       if(((Base)te.transAim).down)
		       {
		       	 	GL11.glTranslatef((float) x , (float) y +actYFD-((actYFD-aimYFD)*part)-yling*yOff, (float) z+(actXZFD-((actXZFD-aimXZFD)*part))-yling*yOff);
		       	 	GL11.glPushMatrix();
			        GL11.glRotatef((actTFT-((actTFT-aimTFT)*part)), 1, 0.0F, 0);
			        GL11.glRotatef(te.turn, 0.0F, 1, 0);
			        if(te.riddenByEntity != null&& cock)
			        	te.riddenByEntity.rotationPitch = 90+(90-(actTFT-(float)((actTFT-aimTFT)*part)))+30;

		       }else
		       {
			       	GL11.glTranslatef((float) x , (float) y +(actYFU-((actYFU-aimYFU)*part))-yling*yOff, (float) z-(actXZFU-((actXZFU-aimXZFU)*part))+yling*yOff);
		       	 	GL11.glPushMatrix();
			        GL11.glRotatef(-(actTFT-(float)((actTFT-aimTFT)*part)), 1, 0.0F, 0);
			        GL11.glRotatef(te.turn*mul, 0.0F, 1, 0);
			        if(te.riddenByEntity != null&& cock)
			        	te.riddenByEntity.rotationPitch = -90-(90-(actTFT-(float)((actTFT-aimTFT)*part)))+30;
		       }
	    	}else if((te.act instanceof EntityTrackUp == false && te.turn == 0) || (te.act instanceof EntityTrackUp && te.turn == 180 && !te.act.down) || (te.act instanceof EntityTrackUp && te.turn == 0 && te.act.down))
	    	{
	
	       	 if(((Base)te.transAim).down)
		       {
		       	 	GL11.glTranslatef((float) x +(actXZFD-((actXZFD-aimXZFD)*part))-yling*yOff, (float) y +actYFD-((actYFD-aimYFD)*part)-yling*yOff, (float) z);
		       	 	GL11.glPushMatrix();
			        GL11.glRotatef(-(actTFT-((actTFT-aimTFT)*part)), 0, 0.0F, 1);
			        GL11.glRotatef(180, 0.0F, 1, 0);
			        if(te.riddenByEntity != null&& cock)
			        	te.riddenByEntity.rotationPitch = 90+(90-(actTFT-(float)((actTFT-aimTFT)*part)))+30;

		       }else
		       {
		       	 	GL11.glTranslatef((float) x -(actXZFU-((actXZFU-aimXZFU)*part))+yling*yOff, (float) y +(actYFU-((actYFU-aimYFU)*part))-yling*yOff, (float) z);
		       	 	GL11.glPushMatrix();
			        GL11.glRotatef((actTFT-((actTFT-aimTFT)*part)), 0, 0.0F, 1);
			       	GL11.glRotatef(-180, 0.0F, 1, 0);
			        if(te.riddenByEntity != null&& cock)
			        	te.riddenByEntity.rotationPitch = -90-(90-(actTFT-(float)((actTFT-aimTFT)*part)))+30;

		       }
	
	    	}else if((te.act instanceof EntityTrackUp == false && te.turn == 270) || (te.act instanceof EntityTrackUp && te.turn == 90 && !te.act.down) || (te.act instanceof EntityTrackUp && te.turn == 270 && te.act.down))
	    	{
	       	 	if(!((Base)te.transAim).down)
	       	 	{
		       	 	GL11.glTranslatef((float) x , (float) y +(actYFU-((actYFU-aimYFU)*part))-yling*yOff, (float) z+(actXZFU-((actXZFU-aimXZFU)*part))-yling*yOff);
		       	 	GL11.glPushMatrix();
			        GL11.glRotatef((actTFT-((actTFT-aimTFT)*part)), 1, 0.0F, 0);
			        GL11.glRotatef(te.turn*mul, 0.0F, 1, 0);
			        if(te.riddenByEntity != null&& cock)
			        	te.riddenByEntity.rotationPitch = -90-(90-(actTFT-(float)((actTFT-aimTFT)*part)))+30;

	       	 	}else
	       	 	{	       	 	
	       	 		GL11.glTranslatef((float) x , (float) y +actYFD-((actYFD-aimYFD)*part)-yling*yOff, (float) z-(actXZFD-((actXZFD-aimXZFD)*part))+yling*yOff);
	       	 		GL11.glPushMatrix();
			        GL11.glRotatef(-(actTFT-((actTFT-aimTFT)*part)), 1, 0.0F, 0);
			        GL11.glRotatef(te.turn, 0.0F, 1, 0);
			        if(te.riddenByEntity != null&& cock)
			        	te.riddenByEntity.rotationPitch = 90+(90-(actTFT-(float)((actTFT-aimTFT)*part)))+30;

	       	 	}
	       	 		
	    	}else if((te.act instanceof EntityTrackUp == false && te.turn == 180) || (te.act instanceof EntityTrackUp && te.turn == 0 && !te.act.down) || (te.act instanceof EntityTrackUp && te.turn == 180 && te.act.down))
	    	{
	
	       	 	if(!((Base)te.transAim).down)
	       	 	{
		       	 	GL11.glTranslatef((float) x+(actXZFU-((actXZFU-aimXZFU)*part))-yling*yOff, (float) y+(actYFU-((actYFU-aimYFU)*part))-yling*yOff, (float) z);
		       	 	GL11.glPushMatrix();
			        GL11.glRotatef(-(actTFT-((actTFT-aimTFT)*part)), 0, 0.0F, 1);
			        if(te.riddenByEntity != null&& cock)
			        	te.riddenByEntity.rotationPitch = -90-(90-(actTFT-(float)((actTFT-aimTFT)*part)))+30;

	       	 	}else
	       	 	{
		       	 	GL11.glTranslatef((float) x-(actXZFD-((actXZFD-aimXZFD)*part))+yling*yOff, (float) y+actYFD-((actYFD-aimYFD)*part)-yling*yOff, (float) z);
		       	 	GL11.glPushMatrix();
			        GL11.glRotatef((actTFT-((actTFT-aimTFT)*part)), 0, 0.0F, 1);
			        if(te.riddenByEntity != null&& cock)
			        	te.riddenByEntity.rotationPitch = 90+(90-(actTFT-(float)((actTFT-aimTFT)*part)))+30;

	       	 	}
	    	}
	        if(te.riddenByEntity != null)
	        {
	        	te.riddenByEntity.rotationPitch = MathHelper.wrapAngleTo180_float(te.riddenByEntity.rotationPitch);
	        }

        }
        else if(te.act instanceof EntityTrackBaseTop)
        {
        	 GL11.glTranslatef((float) x , (float) y -1.9F, (float) z);
        	 GL11.glPushMatrix();
        	 if(te.turn == 90 || te.turn == 270)
        		 GL11.glRotatef(te.turn, 0.0F, 1, 0);
        	 else if(te.turn == 180)
        		 GL11.glRotatef(0, 0.0F, 1, 0);
        	 else
        		 GL11.glRotatef(180, 0.0F, 1, 0);


       	 //GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
        }else if(te.act instanceof EntityTrackQuerTop)
        {
       	 GL11.glTranslatef((float) x , (float) y -1.9F, (float) z);
       	 GL11.glPushMatrix();
    	 GL11.glRotatef(180-te.turn, 0.0F, 1, 0);
      	 //GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
       }else if(te.act instanceof EntityTrackUp)
        {
        	if(((EntityTrackUp)te.act).alignment == 2)
        	{
		       if(((EntityTrackUp)te.act).down)
		       {
		       	 	GL11.glTranslatef((float) x , (float) y, (float) z-1.9F);
		       	 	GL11.glPushMatrix();
			        GL11.glRotatef(90, 1, 0.0F, 0);
			        GL11.glRotatef(90, 0.0F, 1, 0);
		       }else
		       {
		       	 	GL11.glTranslatef((float) x , (float) y +0.1F, (float) z-1.9F);
		       	 	GL11.glPushMatrix();
		    	   	GL11.glRotatef(90, 1, 0.0F, 0);
			       	GL11.glRotatef(-90, 0.0F, 1, 0);
		       }
        	}else if(((EntityTrackUp)te.act).alignment == 3)
        	{
	       	 if(((EntityTrackUp)te.act).down)
		       {
		       	 	GL11.glTranslatef((float) x -1.9F, (float) y, (float) z);
		       	 	GL11.glPushMatrix();
			        GL11.glRotatef(-90, 0, 0.0F, 1);
			        GL11.glRotatef(-180, 0.0F, 1, 0);
		       }else
		       {
		       	 	GL11.glTranslatef((float) x -1.9F, (float) y +0.1F, (float) z);
		       	 	GL11.glPushMatrix();
		    	   	GL11.glRotatef(-90, 0, 0.0F, 1);
			      // 	GL11.glRotatef(180, 0.0F, 1, 0);
			      // 	GL11.glRotatef(180, 0.0F, 0, 1);
		       }

        	}else if(((EntityTrackUp)te.act).alignment == 0)
        	{
	       	 	if(!((EntityTrackUp)te.act).down)
	       	 	{
		       	 	GL11.glTranslatef((float) x , (float) y +0.1F, (float) z+1.9F);
		       	 	GL11.glPushMatrix();
			      //  GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
			        GL11.glRotatef(-90, 1, 0.0F, 0);
			        GL11.glRotatef(-270, 0.0F, 1, 0);
	       	 	}else
	       	 	{
		       	 	GL11.glTranslatef((float) x , (float) y, (float) z+1.9F);
		       	 	GL11.glPushMatrix();
	       	 	//	GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
			        GL11.glRotatef(-90, 1, 0.0F, 0);
			        GL11.glRotatef(270, 0.0F, 1, 0);
	       	 	}
	       	 		
        	}else if(((EntityTrackUp)te.act).alignment == 1)
        	{
	       	 	if(!((EntityTrackUp)te.act).down)
	       	 	{
		       	 	GL11.glTranslatef((float) x +1.9F, (float) y +0.1F, (float) z);
		       	 	GL11.glPushMatrix();
			        GL11.glRotatef(180F, 1, 0, 0);
			        GL11.glRotatef(90, 0, 0.0F, 1);
	       	 	}else
	       	 	{
		       	 	GL11.glTranslatef((float) x +1.9F, (float) y, (float) z);
		       	 	GL11.glPushMatrix();
	       	 	//	GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
			        GL11.glRotatef(90, 0, 0.0F, 1);
	       	 	}
        	}
	       	 //GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
        }
       
       
       	else if(te.act instanceof EntityTrackHor)
        {
        	if(te.turn == 90)
        	{

		       if(((EntityTrackHor)te.act).down)
		       {
		       	 	GL11.glTranslatef((float) x , (float) y +1.3F, (float) z+1.3F);
		       	 	GL11.glPushMatrix();
			        GL11.glRotatef(180, 0, 0.0F, 1);
			        GL11.glRotatef(-45, 1, 0.0F, 0);
			        GL11.glRotatef(te.turn, 0.0F, 1, 0);
		       }else
		       {
		       	 	GL11.glTranslatef((float) x , (float) y +1.4F, (float) z-1.2F);
		       	 	GL11.glPushMatrix();
			        GL11.glRotatef(180, 0, 0.0F, 1);
			        GL11.glRotatef(45, 1, 0.0F, 0);
			       	GL11.glRotatef(te.turn, 0.0F, 1, 0);
		       }
        	}else if(te.turn == 0)
        	{

	       	 if(((EntityTrackHor)te.act).down)
		       {
		       	 	GL11.glTranslatef((float) x +1.3F, (float) y +1.3F, (float) z);
		       	 	GL11.glPushMatrix();
			        GL11.glRotatef(180, 0, 0.0F, 1);
			        GL11.glRotatef(-45, 0, 0.0F, 1);
			        GL11.glRotatef(-te.turn, 0.0F, 1, 0);
		       }else
		       {
		       	 	GL11.glTranslatef((float) x -1.2F, (float) y +1.4F, (float) z);
		       	 	GL11.glPushMatrix();
			        GL11.glRotatef(180, 0, 0.0F, 1);
			        GL11.glRotatef(45, 0, 0.0F, 1);
			       	GL11.glRotatef(te.turn, 0.0F, 1, 0);
		       }

        	}else if(te.turn == 270)
        	{

	       	 	if(!((EntityTrackHor)te.act).down)
	       	 	{
		       	 	GL11.glTranslatef((float) x , (float) y +1.4F, (float) z+1.2F);
		       	 	GL11.glPushMatrix();
		       	 	GL11.glRotatef(180, 0, 0.0F, 1);
			        GL11.glRotatef(-45, 1, 0.0F, 0);
			        GL11.glRotatef(te.turn, 0.0F, 1, 0);
	       	 	}else
	       	 	{	       	 	
	       	 		GL11.glTranslatef((float) x , (float) y +1.3F, (float) z-1.3F);
	       	 		GL11.glPushMatrix();
	       	 		GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
			        GL11.glRotatef(45, 1, 0.0F, 0);
			        GL11.glRotatef(te.turn, 0.0F, 1, 0);
	       	 	}
	       	 		
        	}else if(te.turn == 180)
        	{

	       	 	if(!((EntityTrackHor)te.act).down)
	       	 	{
		       	 	GL11.glTranslatef((float) x+1.2F, (float) y+1.4F, (float) z);
		       	 	GL11.glPushMatrix();
			        GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
			        GL11.glRotatef(-45, 0, 0.0F, 1);
			        GL11.glRotatef(-te.turn, 0.0F, 1, 0);
	       	 	}else
	       	 	{
		       	 	GL11.glTranslatef((float) x-1.3F, (float) y+1.3F, (float) z);
		       	 	GL11.glPushMatrix();
	       	 		GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
			        GL11.glRotatef(45, 0, 0.0F, 1);
			        GL11.glRotatef(-te.turn, 0.0F, 1, 0);
	       	 	}
        	}
	       	 //GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
        }
       	else if(te.act instanceof EntityTrack225 || te.act instanceof EntityTrack225_2)
        {
       		if(te.act.alignment == 0)
        	{

		       if((te.act).down)
		       {
		       	 	GL11.glTranslatef((float) x , (float) y +1.7F, (float) z-0.7F);
		       	 	GL11.glPushMatrix();
			        GL11.glRotatef(180, 0, 0.0F, 1);
			        GL11.glRotatef(27F, 1, 0.0F, 0);
			        GL11.glRotatef(te.turn, 0.0F, 1, 0);
		       }else
		       {
		       	 	GL11.glTranslatef((float) x , (float) y +1.8F, (float) z-0.63F);
		       	 	GL11.glPushMatrix();
			        GL11.glRotatef(180, 0, 0.0F, 1);
			        GL11.glRotatef(27F, 1, 0.0F, 0);
			       	GL11.glRotatef(te.turn, 0.0F, 1, 0);
		       }
        	}else if(te.act.alignment == 1)
        	{

	       	 if((te.act).down)
		       {
		       	 	GL11.glTranslatef((float) x -0.7F, (float) y +1.7F, (float) z);
		       	 	GL11.glPushMatrix();
			        GL11.glRotatef(180, 0, 0.0F, 1);
			        GL11.glRotatef(27F, 0, 0.0F, 1);
			        GL11.glRotatef(-te.turn, 0.0F, 1, 0);
		       }else
		       {
		       	 	GL11.glTranslatef((float) x -0.63F, (float) y +1.8F, (float) z);
		       	 	GL11.glPushMatrix();
			        GL11.glRotatef(180, 0, 0.0F, 1);
			        GL11.glRotatef(27F, 0, 0.0F, 1);
			       	GL11.glRotatef(te.turn, 0.0F, 1, 0);
		       }

        	}else if(te.act.alignment == 2)
        	{

	       	 	if(!(te.act).down)
	       	 	{
		       	 	GL11.glTranslatef((float) x , (float) y +1.8F, (float) z+0.63F);
		       	 	GL11.glPushMatrix();
		       	 	GL11.glRotatef(180, 0, 0.0F, 1);
			        GL11.glRotatef(-27F, 1, 0.0F, 0);
			        GL11.glRotatef(te.turn, 0.0F, 1, 0);
	       	 	}else
	       	 	{	       	 	
	       	 		GL11.glTranslatef((float) x , (float) y+1.7F, (float) z+0.7F);
	       	 		GL11.glPushMatrix();
	       	 		GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
			        GL11.glRotatef(-27F, 1, 0.0F, 0);
			        GL11.glRotatef(te.turn, 0.0F, 1, 0);
	       	 	}
	       	 		
        	}else if(te.act.alignment == 3)
        	{

	       	 	if(!(te.act).down)
	       	 	{
		       	 	GL11.glTranslatef((float) x +0.63F, (float) y +1.8F, (float) z);
		       	 	GL11.glPushMatrix();
			        GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
			        GL11.glRotatef(-27F, 0, 0.0F, 1);
			        GL11.glRotatef(-te.turn, 0.0F, 1, 0);
	       	 	}else
	       	 	{
		       	 	GL11.glTranslatef((float) x +0.7F, (float) y +1.7F, (float) z);
		       	 	GL11.glPushMatrix();
	       	 		GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
			        GL11.glRotatef(-27F, 0, 0.0F, 1);
			        GL11.glRotatef(-te.turn, 0.0F, 1, 0);
	       	 	}
        	}else if(te.act.alignment == 4)
        	{

		       if((te.act).down)
		       {
		       	 	GL11.glTranslatef((float) x , (float) y +0.8F, (float) z-1.75F);
		       	 	GL11.glPushMatrix();
			        GL11.glRotatef(180, 0, 0.0F, 1);
			        GL11.glRotatef(64.5F, 1, 0.0F, 0);
			        GL11.glRotatef(te.turn, 0.0F, 1, 0);
		       }else
		       {
		       	 	GL11.glTranslatef((float) x , (float) y +0.9F, (float) z-1.65F);
		       	 	GL11.glPushMatrix();
			        GL11.glRotatef(180, 0, 0.0F, 1);
			        GL11.glRotatef(64.5F, 1, 0.0F, 0);
			       	GL11.glRotatef(te.turn, 0.0F, 1, 0);
		       }
        	}else if(te.act.alignment == 5)
        	{

	       	 if((te.act).down)
		       {
		       	 	GL11.glTranslatef((float) x -1.75F, (float) y +0.8F, (float) z);
		       	 	GL11.glPushMatrix();
			        GL11.glRotatef(180, 0, 0.0F, 1);
			        GL11.glRotatef(64.5F, 0, 0.0F, 1);
			        GL11.glRotatef(-te.turn, 0.0F, 1, 0);
		       }else
		       {
		       	 	GL11.glTranslatef((float) x -1.65F, (float) y +0.9F, (float) z);
		       	 	GL11.glPushMatrix();
			        GL11.glRotatef(180, 0, 0.0F, 1);
			        GL11.glRotatef(64.5F, 0, 0.0F, 1);
			       	GL11.glRotatef(te.turn, 0.0F, 1, 0);
		       }

        	}else if(te.act.alignment == 6)
        	{

	       	 	if(!(te.act).down)
	       	 	{
		       	 	GL11.glTranslatef((float) x , (float) y +0.9F, (float) z+1.65F);
		       	 	GL11.glPushMatrix();
		       	 	GL11.glRotatef(180, 0, 0.0F, 1);
			        GL11.glRotatef(-64.5F, 1, 0.0F, 0);
			        GL11.glRotatef(te.turn, 0.0F, 1, 0);
	       	 	}else
	       	 	{	       	 	
	       	 		GL11.glTranslatef((float) x , (float) y +0.8F, (float) z+1.75F);
	       	 		GL11.glPushMatrix();
	       	 		GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
			        GL11.glRotatef(-64.5F, 1, 0.0F, 0);
			        GL11.glRotatef(te.turn, 0.0F, 1, 0);
	       	 	}
	       	 		
        	}else if(te.act.alignment == 7)
        	{

	       	 	if(!(te.act).down)
	       	 	{
		       	 	GL11.glTranslatef((float) x +1.65F, (float) y +0.9F, (float) z);
		       	 	GL11.glPushMatrix();
			        GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
			        GL11.glRotatef(-64.5F, 0, 0.0F, 1);
			        GL11.glRotatef(-te.turn, 0.0F, 1, 0);
	       	 	}else
	       	 	{
		       	 	GL11.glTranslatef((float) x +1.75F, (float) y +0.8F, (float) z);
		       	 	GL11.glPushMatrix();
	       	 		GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
			        GL11.glRotatef(-64.5F, 0, 0.0F, 1);
			        GL11.glRotatef(-te.turn, 0.0F, 1, 0);
	       	 	}
        	}
        }else if(te.act instanceof EntityTrack225Top || te.act instanceof EntityTrack225_2Top)
        {
       		if(te.act.alignment == 0)
        	{

		       if((te.act).down)
		       {
		       	 	GL11.glTranslatef((float) x , (float) y -1.7F, (float) z-0.8F);
		       	 	GL11.glPushMatrix();
			        GL11.glRotatef(180, 0, 0.0F, 1);
			        GL11.glRotatef(153F, 1, 0.0F, 0);
			        GL11.glRotatef(-te.turn, 0.0F, 1, 0);
		       }else
		       {
		       	 	GL11.glTranslatef((float) x , (float) y -1.65F, (float) z-0.9F);
		       	 	GL11.glPushMatrix();
			        //GL11.glRotatef(180, 0, 0.0F, 1);
			        GL11.glRotatef(27F, 1, 0.0F, 0);
			       	GL11.glRotatef(te.turn, 0.0F, 1, 0);
		       }
        	}else if(te.act.alignment == 1)
        	{

	       	 if((te.act).down)
		       {
		       	 	GL11.glTranslatef((float) x -0.8F, (float) y -1.7F, (float) z);
		       	 	GL11.glPushMatrix();
			     //   GL11.glRotatef(180, 0, 0.0F, 1);
			        GL11.glRotatef(-27F, 0, 0.0F, 1);
			        GL11.glRotatef(180, 0.0F, 1, 0);
		       }else
		       {
		       	 	GL11.glTranslatef((float) x -0.9F, (float) y -1.65F, (float) z);
		       	 	GL11.glPushMatrix();
			     //   GL11.glRotatef(180, 0, 0.0F, 1);
			        GL11.glRotatef(-27F, 0, 0.0F, 1);
			       	GL11.glRotatef(0, 0.0F, 1, 0);
		       }

        	}else if(te.act.alignment == 2)
        	{

	       	 	if(!(te.act).down)
	       	 	{
		       	 	GL11.glTranslatef((float) x , (float) y -1.65F, (float) z+0.9F);
		       	 	GL11.glPushMatrix();
		       	 //	GL11.glRotatef(180, 0, 0.0F, 1);
			        GL11.glRotatef(-27F, 1, 0.0F, 0);
			        GL11.glRotatef(te.turn, 0.0F, 1, 0);
	       	 	}else
	       	 	{	       	 	
	       	 		GL11.glTranslatef((float) x , (float) y-1.7F, (float) z+0.8F);
	       	 		GL11.glPushMatrix();
	       	 	//	GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
			        GL11.glRotatef(-27F, 1, 0.0F, 0);
			        GL11.glRotatef(te.turn, 0.0F, 1, 0);
	       	 	}
	       	 		
        	}else if(te.act.alignment == 3)
        	{

	       	 	if(!(te.act).down)
	       	 	{
		       	 	GL11.glTranslatef((float) x +0.9F, (float) y -1.65F, (float) z);
		       	 	GL11.glPushMatrix();
			       // GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
			        GL11.glRotatef(27F, 0, 0.0F, 1);
			        GL11.glRotatef(180, 0.0F, 1, 0);
	       	 	}else
	       	 	{
		       	 	GL11.glTranslatef((float) x +0.8F, (float) y -1.7F, (float) z);
		       	 	GL11.glPushMatrix();
	       	 		//GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
			        GL11.glRotatef(27F, 0, 0.0F, 1);
			        GL11.glRotatef(0, 0.0F, 1, 0);
	       	 	}
        	}else if(te.act.alignment == 4)
        	{

		       if((te.act).down)
		       {
		       	 	GL11.glTranslatef((float) x , (float) y -0.8F, (float) z-1.75F);
		       	 	GL11.glPushMatrix();
			       // GL11.glRotatef(180, 0, 0.0F, 1);
			        GL11.glRotatef(64.5F, 1, 0.0F, 0);
			        GL11.glRotatef(te.turn, 0.0F, 1, 0);
		       }else
		       {
		       	 	GL11.glTranslatef((float) x , (float) y -0.8F, (float) z-1.75F);
		       	 	GL11.glPushMatrix();
			       // GL11.glRotatef(180, 0, 0.0F, 1);
			        GL11.glRotatef(64.5F, 1, 0.0F, 0);
			       	GL11.glRotatef(te.turn, 0.0F, 1, 0);
		       }
        	}else if(te.act.alignment == 5)
        	{

	       	 if((te.act).down)
		       {
		       	 	GL11.glTranslatef((float) x +1.75F, (float) y -0.8F, (float) z);
		       	 	GL11.glPushMatrix();
			       // GL11.glRotatef(180, 0, 0.0F, 1);
			        GL11.glRotatef(64.5F, 0, 0.0F, 1);
			        GL11.glRotatef(0, 0.0F, 1, 0);
		       }else
		       {
		       	 	GL11.glTranslatef((float) x +1.75F, (float) y -0.8F, (float) z);
		       	 	GL11.glPushMatrix();
			      //  GL11.glRotatef(180, 0, 0.0F, 1);
			        GL11.glRotatef(64.5F, 0, 0.0F, 1);
			       	GL11.glRotatef(180, 0.0F, 1, 0);
		       }

        	}else if(te.act.alignment == 6)
        	{

	       	 	if(!(te.act).down)
	       	 	{
		       	 	GL11.glTranslatef((float) x , (float) y -0.8F, (float) z+1.75F);
		       	 	GL11.glPushMatrix();
		       	 	//GL11.glRotatef(180, 0, 0.0F, 1);
			        GL11.glRotatef(-64.5F, 1, 0.0F, 0);
			        GL11.glRotatef(te.turn, 0.0F, 1, 0);
	       	 	}else
	       	 	{	       	 	
	       	 		GL11.glTranslatef((float) x , (float) y -0.8F, (float) z+1.75F);
	       	 		GL11.glPushMatrix();
	       	 		//GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
			        GL11.glRotatef(-64.5F, 1, 0.0F, 0);
			        GL11.glRotatef(te.turn, 0.0F, 1, 0);
	       	 	}
	       	 		
        	}else if(te.act.alignment == 7)
        	{

	       	 	if(!(te.act).down)
	       	 	{
		       	 	GL11.glTranslatef((float) x -1.75F, (float) y -0.8F, (float) z);
		       	 	GL11.glPushMatrix();
			       // GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
			        GL11.glRotatef(-64.5F, 0, 0.0F, 1);
			        GL11.glRotatef(0, 0.0F, 1, 0);
	       	 	}else
	       	 	{
		       	 	GL11.glTranslatef((float) x -1.75F, (float) y -0.8F, (float) z);
		       	 	GL11.glPushMatrix();
	       	 		//GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
			        GL11.glRotatef(-64.5F, 0, 0.0F, 1);
			        GL11.glRotatef(180, 0.0F, 1, 0);
	       	 	}
        	}
        }
     	else if(te.act instanceof EntityTrackTransition)
        {
    		double tmp;
	    	tmp = te.posZ-te.act.zCoord;
    		double tmp2;
	    	tmp2 = te.posX-te.act.xCoord;
        	float yOff = (float) ((-4*Math.pow(tmp-0.5,2))+1);
        	float yOff2 = (float) ((-4*Math.pow(tmp2-0.5,2))+1);
        	float yling = 0.25F;
        	if(((Base)te.act).alignment == 0)
        	{
	       	 	GL11.glTranslated((float) x-1.35F*tmp, (float) y +1.9F-(1.9F-1.45F)*tmp+yling*yOff, (float) z);
	       	 	GL11.glPushMatrix();
		        GL11.glRotatef(180, 0, 0.0F, 1);
		        GL11.glRotatef((float)(56*tmp), 0, 0.0F, 1);
		        GL11.glRotatef(te.turn, 0.0F, 1, 0);
        	}else if(((Base)te.act).alignment == 1)
        	{
	       	 	GL11.glTranslated((float) x, (float) y +1.9F-(1.9F-1.45F)*(1-tmp2)+yling*yOff2, (float) z-1.35F*(1-tmp2));
	       	 	GL11.glPushMatrix();
		        GL11.glRotatef(180, 0, 0.0F, 1);
		        GL11.glRotatef((float)(56*(1-tmp2)), 1, 0.0F, 0);
		        GL11.glRotatef(-te.turn, 0.0F, 1, 0);

        	}else if(((Base)te.act).alignment == 2)
        	{

	       	 	GL11.glTranslated((float) x+1.35F*(1-tmp), (float) y +1.9F-(1.9F-1.45F)*(1-tmp)+yling*yOff, (float) z);
	       	 	GL11.glPushMatrix();
		        GL11.glRotatef(180, 0, 0.0F, 1);
		        GL11.glRotatef((float)(-56*(1-tmp)), 0, 0.0F, 1);
		        GL11.glRotatef(te.turn, 0.0F, 1, 0);
	       	 		
        	}else if(((Base)te.act).alignment == 3)
        	{
	       	 	GL11.glTranslated((float) x, (float) y +1.9F-(1.9F-1.45F)*tmp2+yling*yOff2, (float) z+1.35F*tmp2);
	       	 	GL11.glPushMatrix();
		        GL11.glRotatef(180, 0, 0.0F, 1);
		        GL11.glRotatef((float)(-56*tmp2), 1, 0.0F, 0);
		        GL11.glRotatef(-te.turn, 0.0F, 1, 0);
        	}
        	else if(((Base)te.act).alignment == 4)
        	{
	       	 	GL11.glTranslated((float) x+1.35F*tmp, (float) y +1.9F-(1.9F-1.45F)*tmp+yling*yOff, (float) z);
	       	 	GL11.glPushMatrix();
		        GL11.glRotatef(180, 0, 0.0F, 1);
		        GL11.glRotatef((float)(-56*tmp), 0, 0.0F, 1);
		        GL11.glRotatef(te.turn, 0.0F, 1, 0);
        	}
        	else if(((Base)te.act).alignment == 5)
        	{
	       	 	GL11.glTranslated((float) x, (float) y +1.9F-(1.9F-1.45F)*(1-tmp2)+yling*yOff2, (float) z+1.35F*(1-tmp2));
	       	 	GL11.glPushMatrix();
		        GL11.glRotatef(180, 0, 0.0F, 1);
		        GL11.glRotatef((float)(-56*(1-tmp2)), 1, 0.0F, 0);
		        GL11.glRotatef(-te.turn, 0.0F, 1, 0);
        	}else if(((Base)te.act).alignment == 6)
        	{

	       	 	GL11.glTranslated((float) x-1.35F*(1-tmp), (float) y +1.9F-(1.9F-1.45F)*(1-tmp)+yling*yOff, (float) z);
	       	 	GL11.glPushMatrix();
		        GL11.glRotatef(180, 0, 0.0F, 1);
		        GL11.glRotatef((float)(56*(1-tmp)), 0, 0.0F, 1);
		        GL11.glRotatef(te.turn, 0.0F, 1, 0);
	       	 		
        	}else if(((Base)te.act).alignment == 7)
        	{
	       	 	GL11.glTranslated((float) x, (float) y +1.9F-(1.9F-1.45F)*tmp2+yling*yOff2, (float) z-1.35F*tmp2);
	       	 	GL11.glPushMatrix();
		        GL11.glRotatef(180, 0, 0.0F, 1);
		        GL11.glRotatef((float)(56*tmp2), 1, 0.0F, 0);
		        GL11.glRotatef(-te.turn, 0.0F, 1, 0);
        	}
	       	 //GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
        }
       	else if(te.act instanceof EntityTrackPitched)
        {
       		
        	if(((EntityTrackPitched)te.act).alignment == 0)
        	{
	       	 	GL11.glTranslatef((float) x -1.35F, (float) y +1.45F, (float) z);
		       	 GL11.glPushMatrix();
			     GL11.glRotatef(180, 0, 0.0F, 1);
			     GL11.glRotatef(56, 0, 0.0F, 1);
			     GL11.glRotatef(te.turn, 0.0F, 1, 0);
        	}else if(((EntityTrackPitched)te.act).alignment == 1)
        	{
		       	 	GL11.glTranslatef((float) x, (float) y +1.45F, (float) z-1.35F);
		       	 	GL11.glPushMatrix();
			        GL11.glRotatef(180, 0, 0.0F, 1);
			        GL11.glRotatef(56, 1, 0.0F, 0);
			        GL11.glRotatef(-te.turn, 0.0F, 1, 0);

        	}else if(((EntityTrackPitched)te.act).alignment == 2)
        	{
		       	 	GL11.glTranslatef((float) x +1.35F, (float) y +1.45F, (float) z);
		       	 	GL11.glPushMatrix();
		       	 	GL11.glRotatef(180, 0, 0.0F, 1);
			        GL11.glRotatef(-56, 0, 0.0F, 1);
			        GL11.glRotatef(te.turn, 0.0F, 1, 0);
	       	 		
        	}else if(((EntityTrackPitched)te.act).alignment == 3)
        	{
		       	 	GL11.glTranslatef((float) x, (float) y +1.45F, (float) z+1.35F);
		       	 	GL11.glPushMatrix();
			        GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
			        GL11.glRotatef(-56, 1, 0.0F, 0);
			        GL11.glRotatef(-te.turn, 0.0F, 1, 0);
        	}
	       	 //GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
        }
       	else if(te.act instanceof EntityTrackPitchedCurve)
        {
        	if(((EntityTrackPitchedCurve)te.act).alignment == 0)
        	{
          	 	GL11.glTranslatef((float) x-1.2F, (float) y +1.2F, (float) z+1.1F);
          	 	GL11.glPushMatrix();
          	 	GL11.glRotatef(135, 0,1,0);
          	 	GL11.glRotatef(113, 1,0,0);
          	 	if(te.act.down)
          	 		GL11.glRotatef(180, 0,1,0);
        	}else if(((EntityTrackPitchedCurve)te.act).alignment == 1)
        	{
          	 	GL11.glTranslatef((float) x-1.1F, (float) y +1.2F, (float) z-1.2F);
          	 	GL11.glPushMatrix();
          	 	GL11.glRotatef(-135, 0,1,0);
          	 	GL11.glRotatef(-113, 1,0,0);
          	 	if(!te.act.down)
          	 		GL11.glRotatef(180, 0,1,0);

        	}else if(((EntityTrackPitchedCurve)te.act).alignment == 2)
        	{

          	 	GL11.glTranslatef((float) x+1.2F, (float) y +1.2F, (float) z-1.1F);
          	 	GL11.glPushMatrix();
          	 	GL11.glRotatef(-45, 0,1,0);
          	 	GL11.glRotatef(113, 1,0,0);
          	 	if(te.act.down)
          	 		GL11.glRotatef(180, 0,1,0);
	       	 		
        	}else if(((EntityTrackPitchedCurve)te.act).alignment == 3)
        	{
          	 	GL11.glTranslatef((float) x+1.1F, (float) y +1.2F, (float) z+1.2F);
          	 	GL11.glPushMatrix();
          	 	GL11.glRotatef(45, 0,1,0);
          	 	GL11.glRotatef(-113, 1,0,0);
          	 	if(!te.act.down)
          	 		GL11.glRotatef(180, 0,1,0);

        	}
	       	 //GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
        }
       	else if(te.act instanceof EntityTrackHorTop)
        {
       		if(te.turn == 90)
        	{

		       if(((EntityTrackHorTop)te.act).down)
		       {
		       	 	GL11.glTranslatef((float) x , (float) y -1.3F, (float) z-1.3F);
		       	 	GL11.glPushMatrix();
			        GL11.glRotatef(45, 1, 0, 0);
			        GL11.glRotatef(te.turn, 0.0F, 1, 0);
		       }else
		       {
		       	 	GL11.glTranslatef((float) x , (float) y -1.3F, (float) z+1.3F);
		       	 	GL11.glPushMatrix();
			        GL11.glRotatef(-45, 1, 0, 0);
			       	GL11.glRotatef(te.turn, 0.0F, 1, 0);
		       }
        	}else if(te.turn == 0)
        	{

	       	 if(((EntityTrackHorTop)te.act).down)
		       {
		       	 	GL11.glTranslatef((float) x -1.3F, (float) y -1.3F, (float) z);
		       	 	GL11.glPushMatrix();
			        GL11.glRotatef(-45, 0, 0.0F, 1);
			        GL11.glRotatef(180, 0.0F, 1, 0);
		       }else
		       {
		       	 	GL11.glTranslatef((float) x +1.3F, (float) y -1.3F, (float) z);
		       	 	GL11.glPushMatrix();
			        GL11.glRotatef(45, 0, 0.0F, 1);
			       	GL11.glRotatef(-180, 0.0F, 1, 0);
		       }

        	}else if(te.turn == 270)
        	{

	       	 	if(!((EntityTrackHorTop)te.act).down)
	       	 	{
		       	 	GL11.glTranslatef((float) x , (float) y -1.3F, (float) z-1.3F);
		       	 	GL11.glPushMatrix();
			        GL11.glRotatef(45, 1, 0, 0);
			        GL11.glRotatef(te.turn, 0.0F, 1, 0);
	       	 	}else
	       	 	{	       	 	
	       	 		GL11.glTranslatef((float) x , (float) y -1.3F, (float) z+1.3F);
	       	 		GL11.glPushMatrix();
			        GL11.glRotatef(-45, 1, 0, 0);
			        GL11.glRotatef(te.turn, 0.0F, 1, 0);
	       	 	}
	       	 		
        	}else if(te.turn == 180)
        	{

	       	 	if(!((EntityTrackHorTop)te.act).down)
	       	 	{
		       	 	GL11.glTranslatef((float) x -1.3F, (float) y -1.3F, (float) z);
		       	 	GL11.glPushMatrix();
			        GL11.glRotatef(-45, 0, 0.0F, 1);
			        GL11.glRotatef(0, 0.0F, 1, 0);
	       	 	}else
	       	 	{
		       	 	GL11.glTranslatef((float) x +1.3F, (float) y -1.3F, (float) z);
		       	 	GL11.glPushMatrix();
			        GL11.glRotatef(45, 0, 0.0F, 1);
			        GL11.glRotatef(0, 0.0F, 1, 0);
	       	 	}
        	}
	       	 //GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
        }
       	
       	else if(te.act instanceof EntityTrackBaseWater)
        {
	        GL11.glTranslatef((float) x , (float) y + 1.9F-te.yOff, (float) z);
	        GL11.glPushMatrix();
	        GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
	        GL11.glRotatef(te.turn, 0.0F, 1, 0);
   }else
	   
   {
       if(te.riddenByEntity != null && cock)
       	te.riddenByEntity.rotationPitch = 30;
  	 	
       GL11.glTranslatef((float) x , (float) y + 1.9F, (float) z);
       GL11.glPushMatrix();
       GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
       GL11.glRotatef(te.turn, 0.0F, 1, 0);
       
   }
        if(te.riddenByEntity != null && Minecraft.getMinecraft().thePlayer != te.riddenByEntity)
        {
        	te.model.head.isHidden = false;
        	te.model.body.isHidden = false;
        	te.model.leg1.isHidden = false;
        	te.model.leg2.isHidden = false;
        	te.model.arm2.isHidden = false;
        	te.model.arm1.isHidden = false;
        	if(te.turn == 0 || te.turn == 180)
        	{
        		te.model.head.rotateAngleY = (float) ((te.riddenByEntity.rotationYaw-te.turn)*0.0174532925D);
            	te.model.head.rotateAngleX = -(float) (te.riddenByEntity.rotationPitch*0.0174532925D);
        	}
        	else
        	{
        		te.model.head.rotateAngleY = (float) ((te.riddenByEntity.rotationYaw-te.turn)*0.0174532925D);
        		te.model.head.rotateAngleX = -(float) (te.riddenByEntity.rotationPitch*0.0174532925D);
        	}
/**
        	if(te.turn == 90 || te.turn == 0)
        	{
        		te.model.head.rotateAngleX = -(float) (te.riddenByEntity.rotationPitch*0.0174532925D);
        	}
        	else
        	{
        	}
*/
        }else
        {
        	te.model.head.isHidden = true;
        	te.model.body.isHidden = true;
        	te.model.leg1.isHidden = true;
        	te.model.leg2.isHidden = true;
        	te.model.arm2.isHidden = true;
        	te.model.arm1.isHidden = true;

        }
        
        GL11.glScalef(1.2F, 1.2F, 1.2F);
    	te.model.render((Entity)null, 0.0F, 0.0F, 0, 0.0F, 0.0F, 0.0625F);
    
    	GL11.glPopMatrix();
        GL11.glPopMatrix();


    }

    /**
     * Returns the location of an entity's texture. Doesn't seem to be called unless you call Render.bindEntityTexture.
     */
    protected ResourceLocation getEntityTexture(EntityTrain par1EntityBoat)
    {
        return t;
    }

    /**
     * Returns the location of an entity's texture. Doesn't seem to be called unless you call Render.bindEntityTexture.
     */
    protected ResourceLocation getEntityTexture(Entity par1Entity)
    {
        return this.getEntityTexture((EntityTrain)par1Entity);
    }

    /**
     * Actually renders the given argument. This is a synthetic bridge method, always casting down its argument and then
     * handing it off to a worker function which does the actual work. In all probabilty, the class Render is generic
     * (Render<T extends Entity) and this method has signature public void func_76986_a(T entity, double d, double d1,
     * double d2, float f, float f1). But JAD is pre 1.5 so doesn't do that.
     */
    public void doRender(Entity par1Entity, double par2, double par4, double par6, float par8, float par9)
    {
        this.doRender((EntitySubTrain)par1Entity, par2, par4, par6, par8, par9);
    }
}
