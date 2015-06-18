package com.roller.roller.renderer;

import net.minecraft.client.Minecraft;

import com.roller.roller.EntityRenderer2;
import com.roller.roller.tileEntity.EntityMainTrain;
import com.roller.roller.tileEntity.EntitySubTrain;
import com.roller.roller.tileEntity.EntitySupport;
import com.roller.roller.tileEntity.EntityTrack225;
import com.roller.roller.tileEntity.EntityTrack225Top;
import com.roller.roller.tileEntity.EntityTrack225_2;
import com.roller.roller.tileEntity.EntityTrack225_2Top;
import com.roller.roller.tileEntity.EntityTrackBase;
import com.roller.roller.tileEntity.EntityTrackBaseTop;
import com.roller.roller.tileEntity.EntityTrackBaseWater;
import com.roller.roller.tileEntity.EntityTrackCurve;
import com.roller.roller.tileEntity.EntityTrackHor;
import com.roller.roller.tileEntity.EntityTrackHorTop;
import com.roller.roller.tileEntity.EntityTrackPitched;
import com.roller.roller.tileEntity.EntityTrackPitchedCurve;
import com.roller.roller.tileEntity.EntityTrackQuer;
import com.roller.roller.tileEntity.EntityTrackQuerTop;
import com.roller.roller.tileEntity.EntityTrackSeitlich;
import com.roller.roller.tileEntity.EntityTrackTransition;
import com.roller.roller.tileEntity.EntityTrackTurn;
import com.roller.roller.tileEntity.EntityTrackUp;
import com.roller.roller.tileEntity.TEWallpic;

import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;

public class RenderClient extends RenderServer{
	public void registerThings()
	{
		 	RenderingRegistry.registerEntityRenderingHandler(EntityMainTrain.class, new RenderTrain());
		 	RenderingRegistry.registerEntityRenderingHandler(EntitySubTrain.class, new RenderSubTrain());
		 	ClientRegistry.bindTileEntitySpecialRenderer(EntityTrackBase.class, new RenderTrackBase());
			ClientRegistry.bindTileEntitySpecialRenderer(EntityTrackHor.class, new RenderTrackHor());
			ClientRegistry.bindTileEntitySpecialRenderer(EntityTrackCurve.class, new RenderTrackCurve());
			ClientRegistry.bindTileEntitySpecialRenderer(EntityTrackUp.class, new RenderTrackUp());
			ClientRegistry.bindTileEntitySpecialRenderer(EntityTrackHorTop.class, new RenderTrackHorTop());
			ClientRegistry.bindTileEntitySpecialRenderer(EntityTrackBaseTop.class, new RenderTrackBaseTop());
			ClientRegistry.bindTileEntitySpecialRenderer(EntityTrackQuer.class, new RenderTrackQuer());
			ClientRegistry.bindTileEntitySpecialRenderer(EntityTrackQuerTop.class, new RenderTrackQuerTop());
			ClientRegistry.bindTileEntitySpecialRenderer(EntityTrackBaseWater.class, new RenderTrackBaseWater());
			ClientRegistry.bindTileEntitySpecialRenderer(EntityTrackTurn.class, new RenderTrackTurn());
			ClientRegistry.bindTileEntitySpecialRenderer(TEWallpic.class, new RenderWallpic());
			ClientRegistry.bindTileEntitySpecialRenderer(EntityTrackTransition.class, new RenderTrackTransition());
			ClientRegistry.bindTileEntitySpecialRenderer(EntityTrackPitched.class, new RenderTrackPitched());
			ClientRegistry.bindTileEntitySpecialRenderer(EntityTrackSeitlich.class, new RenderTrackSeitlich());
			ClientRegistry.bindTileEntitySpecialRenderer(EntityTrackPitchedCurve.class, new RenderTrackPitchedCurve());
			ClientRegistry.bindTileEntitySpecialRenderer(EntityTrack225.class, new RenderTrack225());
			ClientRegistry.bindTileEntitySpecialRenderer(EntityTrack225_2.class, new RenderTrack225_2());
			ClientRegistry.bindTileEntitySpecialRenderer(EntityTrack225Top.class, new RenderTrack225Top());
			ClientRegistry.bindTileEntitySpecialRenderer(EntityTrack225_2Top.class, new RenderTrack225_2Top());	
			ClientRegistry.bindTileEntitySpecialRenderer(EntitySupport.class, new RenderSupport());	
	    	Minecraft mc = Minecraft.getMinecraft();
	    	if(mc.entityRenderer instanceof EntityRenderer2 == false)
				mc.entityRenderer = new EntityRenderer2(mc, mc.getResourceManager());
	    	System.out.println(mc.entityRenderer+" jaaa");
	}
}
