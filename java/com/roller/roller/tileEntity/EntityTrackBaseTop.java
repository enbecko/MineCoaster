
package com.roller.roller.tileEntity;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;


public class EntityTrackBaseTop extends Base{

	public int power;
	public boolean start;
	public boolean screenTaken, followed;
	public float xForDown = 0, yForDown = -1.9F, zForDown = 0, xForUp = 0, yForUp = -1.9F, zForUp = 0, turnForTrans = 0;
	EntityTrain tra, tmp7;
	Base prevNext, posNext;
	public float speed;
	int k2, k;
	

    public EntityTrackBaseTop()
    {

    }
    
    public void updateEntity()
    {
    	super.updateEntity();
    	/**
    	for (int i = 0; i < worldObj.loadedEntityList.size(); i++)
    	{
		    	if (worldObj.loadedEntityList.get(i) instanceof EntityPlayer == false) //if it is a mob...
		    	{
			    	((Entity) worldObj.loadedEntityList.get(i)).setDead();
		    	}
	    	
    	}*/
    	{
    		Base tmp;
    		if(this.first)
    		{
    			this.next = null;
	    		if(this.alignment == 0)
	    		{
	    			if(this.worldObj.getTileEntity(this.xCoord, this.yCoord, this.zCoord-1) != null && this.worldObj.getTileEntity(this.xCoord, this.yCoord, this.zCoord-1) instanceof EntityTrackBaseTop)
	    			{
	    				tmp = (EntityTrackBaseTop) this.worldObj.getTileEntity(this.xCoord, this.yCoord, this.zCoord-1);
	    				if((tmp.alignment % 2) == 0)
	    				{
	    					this.makeNext(tmp);
	    				}
	    			}else if(this.worldObj.getTileEntity(this.xCoord, this.yCoord, this.zCoord-1) != null && this.worldObj.getTileEntity(this.xCoord, this.yCoord, this.zCoord-1) instanceof EntityTrackQuerTop)
	    			{
	    				tmp = (EntityTrackQuerTop) this.worldObj.getTileEntity(this.xCoord, this.yCoord, this.zCoord-1);
	    				if(tmp.alignment == 3 || tmp.alignment == 0)
	    				{
	    					this.makeNext(tmp);
	    				}
	    			}
	    			else if(this.worldObj.getTileEntity(this.xCoord, this.yCoord, this.zCoord-1) != null && this.worldObj.getTileEntity(this.xCoord, this.yCoord, this.zCoord-1) instanceof EntityTrackHorTop)
	    			{
	    				tmp = (EntityTrackHorTop) this.worldObj.getTileEntity(this.xCoord, this.yCoord, this.zCoord-1);
	    				if(tmp.alignment == this.alignment)
	    				{
	    					if(tmp != this.prev)
	    						((EntityTrackHorTop)tmp).down = true;
	    					this.makeNext(tmp);
	    				}
	    			}else if(this.worldObj.getTileEntity(this.xCoord, this.yCoord+1, this.zCoord-1) != null && this.worldObj.getTileEntity(this.xCoord, this.yCoord+1, this.zCoord-1) instanceof EntityTrackHorTop)
	    			{
	    				tmp = (EntityTrackHorTop) this.worldObj.getTileEntity(this.xCoord, this.yCoord+1, this.zCoord-1);
	    				if(tmp.alignment == 2)
	    				{
	    					if(tmp != this.prev)
	    						((EntityTrackHorTop)tmp).down = false;
	    					this.makeNext(tmp);
	    				}
	    			}else if(this.worldObj.getTileEntity(this.xCoord, this.yCoord, this.zCoord-1) != null && this.worldObj.getTileEntity(this.xCoord, this.yCoord, this.zCoord-1) instanceof EntityTrack225_2Top)
	    			{
	    				tmp = (EntityTrack225_2Top) this.worldObj.getTileEntity(this.xCoord, this.yCoord, this.zCoord-1);
	    				if(tmp.alignment == 2)
	    				{
	    					if(tmp != this.prev)
	    						((EntityTrack225_2Top)tmp).down = true;
	    					this.makeNext(tmp);
	    				}
	    			}
	    		}
	    		if(this.alignment == 1)
	    		{
	    			if(this.worldObj.getTileEntity(this.xCoord-1, this.yCoord, this.zCoord) != null && this.worldObj.getTileEntity(this.xCoord-1, this.yCoord, this.zCoord) instanceof EntityTrackBaseTop)
	    			{
	    				tmp = (EntityTrackBaseTop) this.worldObj.getTileEntity(this.xCoord-1, this.yCoord, this.zCoord);
	    				if((tmp.alignment % 2) != 0)
	    				{
	    					this.makeNext(tmp);
	    				}
	    			}else if(this.worldObj.getTileEntity(this.xCoord-1, this.yCoord, this.zCoord) != null && this.worldObj.getTileEntity(this.xCoord-1, this.yCoord, this.zCoord) instanceof EntityTrackQuerTop)
	    			{
	    				tmp = (EntityTrackQuerTop) this.worldObj.getTileEntity(this.xCoord-1, this.yCoord, this.zCoord);
	    				if(tmp.alignment == 2 || tmp.alignment == 3)
	    				{
	    					this.makeNext(tmp);
	    				}
	    			}else if(this.worldObj.getTileEntity(this.xCoord-1, this.yCoord, this.zCoord) != null && this.worldObj.getTileEntity(this.xCoord-1, this.yCoord, this.zCoord) instanceof EntityTrackHorTop)
	    			{
	    				tmp = (EntityTrackHorTop) this.worldObj.getTileEntity(this.xCoord-1, this.yCoord, this.zCoord);
	    				if(tmp.alignment == this.alignment)
	    				{
	    					if(tmp != this.prev)
	    						((EntityTrackHorTop)tmp).down = true;
	    					this.makeNext(tmp);
	    				}
	    			}else if(this.worldObj.getTileEntity(this.xCoord-1, this.yCoord+1, this.zCoord) != null && this.worldObj.getTileEntity(this.xCoord-1, this.yCoord+1, this.zCoord) instanceof EntityTrackHorTop)
	    			{
	    				tmp = (EntityTrackHorTop) this.worldObj.getTileEntity(this.xCoord-1, this.yCoord+1, this.zCoord);
	    				if(tmp.alignment == 3)
	    				{
	    					if(tmp != this.prev)
	    						((EntityTrackHorTop)tmp).down = false;
	    					this.makeNext(tmp);
	    				}
	    			}else if(this.worldObj.getTileEntity(this.xCoord-1, this.yCoord, this.zCoord) != null && this.worldObj.getTileEntity(this.xCoord-1, this.yCoord, this.zCoord) instanceof EntityTrack225_2Top)
	    			{
	    				tmp = (EntityTrack225_2Top) this.worldObj.getTileEntity(this.xCoord-1, this.yCoord, this.zCoord);
	    				if(tmp.alignment == 3)
	    				{
	    					if(tmp != this.prev)
	    						((EntityTrack225_2Top)tmp).down = true;
	    					this.makeNext(tmp);
	    				}
	    			}
	    		}
	    		if(this.alignment == 2)
	    		{
	    			if(this.worldObj.getTileEntity(this.xCoord, this.yCoord, this.zCoord+1) != null && this.worldObj.getTileEntity(this.xCoord, this.yCoord, this.zCoord+1) instanceof EntityTrackBaseTop)
	    			{
	    				tmp = (EntityTrackBaseTop) this.worldObj.getTileEntity(this.xCoord, this.yCoord, this.zCoord+1);
	    				if((tmp.alignment % 2) == 0)
	    				{
	    					this.makeNext(tmp);

	    				}
	    			}else if(this.worldObj.getTileEntity(this.xCoord, this.yCoord, this.zCoord+1) != null && this.worldObj.getTileEntity(this.xCoord, this.yCoord, this.zCoord+1) instanceof EntityTrackQuerTop)
	    			{
	    				tmp = (EntityTrackQuerTop) this.worldObj.getTileEntity(this.xCoord, this.yCoord, this.zCoord+1);
	    				if(tmp.alignment  == 1 || tmp.alignment == 2)
	    				{
	    					this.makeNext(tmp);

	    				}
	    			}else if(this.worldObj.getTileEntity(this.xCoord, this.yCoord, this.zCoord+1) != null && this.worldObj.getTileEntity(this.xCoord, this.yCoord, this.zCoord+1) instanceof EntityTrackHorTop)
	    			{
	    				tmp = (EntityTrackHorTop) this.worldObj.getTileEntity(this.xCoord, this.yCoord, this.zCoord+1);
	    				if(tmp.alignment == this.alignment)
	    				{
	    					if(tmp != this.prev)
	    						((EntityTrackHorTop)tmp).down = true;
	    					this.makeNext(tmp);
	    				}
	    			}else if(this.worldObj.getTileEntity(this.xCoord, this.yCoord+1, this.zCoord+1) != null && this.worldObj.getTileEntity(this.xCoord, this.yCoord+1, this.zCoord+1) instanceof EntityTrackHorTop)
	    			{
	    				tmp = (EntityTrackHorTop) this.worldObj.getTileEntity(this.xCoord, this.yCoord+1, this.zCoord+1);
	    				if(tmp.alignment == 0)
	    				{
	    					if(tmp != this.prev)
	    						((EntityTrackHorTop)tmp).down = false;
	    					this.makeNext(tmp);
	    				}
	    			}else if(this.worldObj.getTileEntity(this.xCoord, this.yCoord, this.zCoord+1) != null && this.worldObj.getTileEntity(this.xCoord, this.yCoord, this.zCoord+1) instanceof EntityTrack225_2Top)
	    			{
	    				tmp = (EntityTrack225_2Top) this.worldObj.getTileEntity(this.xCoord, this.yCoord, this.zCoord+1);
	    				if(tmp.alignment == 0)
	    				{
	    					if(tmp != this.prev)
	    						((EntityTrack225_2Top)tmp).down = true;
	    					this.makeNext(tmp);
	    				}
	    			}
	    		}
	    		if(this.alignment == 3)
	    		{
	    			if(this.worldObj.getTileEntity(this.xCoord+1, this.yCoord, this.zCoord) != null && this.worldObj.getTileEntity(this.xCoord+1, this.yCoord, this.zCoord) instanceof EntityTrackBaseTop)
	    			{
	    				tmp = (EntityTrackBaseTop) this.worldObj.getTileEntity(this.xCoord+1, this.yCoord, this.zCoord);
	    				if((tmp.alignment % 2) != 0)
		    			{
	    					this.makeNext(tmp);
		    			}
	    			}else if(this.worldObj.getTileEntity(this.xCoord+1, this.yCoord, this.zCoord) != null && this.worldObj.getTileEntity(this.xCoord+1, this.yCoord, this.zCoord) instanceof EntityTrackQuerTop)
	    			{
	    				tmp = (EntityTrackQuerTop) this.worldObj.getTileEntity(this.xCoord+1, this.yCoord, this.zCoord);
	    				if(tmp.alignment == 0 || tmp.alignment == 1)
		    			{
	    					this.makeNext(tmp);
		    			}
	    			}else if(this.worldObj.getTileEntity(this.xCoord+1, this.yCoord, this.zCoord) != null && this.worldObj.getTileEntity(this.xCoord+1, this.yCoord, this.zCoord) instanceof EntityTrackHorTop)
	    			{
	    				tmp = (EntityTrackHorTop) this.worldObj.getTileEntity(this.xCoord+1, this.yCoord, this.zCoord);
	    				if(tmp.alignment == this.alignment)
	    				{
	    					if(tmp != this.prev)
	    						((EntityTrackHorTop)tmp).down = true;
	    					this.makeNext(tmp);
	    				}
	    			}else if(this.worldObj.getTileEntity(this.xCoord+1, this.yCoord+1, this.zCoord) != null && this.worldObj.getTileEntity(this.xCoord+1, this.yCoord+1, this.zCoord) instanceof EntityTrackHorTop)
	    			{
	    				tmp = (EntityTrackHorTop) this.worldObj.getTileEntity(this.xCoord+1, this.yCoord+1, this.zCoord);
	    				if(tmp.alignment == 1)	
	    				{
	    					if(tmp != this.prev)
	    						((EntityTrackHorTop)tmp).down = false;
	    					this.makeNext(tmp);
	    				}
	    			}else if(this.worldObj.getTileEntity(this.xCoord+1, this.yCoord, this.zCoord) != null && this.worldObj.getTileEntity(this.xCoord+1, this.yCoord, this.zCoord) instanceof EntityTrack225_2Top)
	    			{
	    				tmp = (EntityTrack225_2Top) this.worldObj.getTileEntity(this.xCoord+1, this.yCoord, this.zCoord);
	    				if(tmp.alignment == 1)	
	    				{
	    					if(tmp != this.prev)
	    						((EntityTrack225_2Top)tmp).down = true;
	    					this.makeNext(tmp);
	    				}
	    			}
	    		}
	    		if(this.next == null && k2 < 1)
	    		{
	    			k2++;
	    		}else if(this.next == null && posNext == null)
	    		{
	    			this.failed = true;
	    			this.makeFirst(this.firstBlock);
	    		}

				//if(!this.worldObj.isRemote)
				{
		    		System.out.println(this.worldObj.isRemote+" "+this.prev+" "+this.xCoord+" "+this.yCoord+" "+this.zCoord+" "+this.next);
		    		System.out.println("");
				}
    		}
    		/**
    		if(this.prevNext != this.posNext)  				
			{
				this.screenTaken = false;
				this.followed = false;
			}
    		if(this.posNext != null && !screenTaken)
    		{
    			if(k == 0)
    			{
		    		tmp7 = new EntityTrain(this.worldObj, this.xCoord+0.5F, this.yCoord+0.999F, this.zCoord+0.5F);
		    		if(!this.worldObj.isRemote)
		    			this.worldObj.spawnEntityInWorld(tmp7);
		    		Minecraft.getMinecraft().thePlayer.mountEntity(tmp7);
		    		Minecraft.getMinecraft().thePlayer.rotationPitch = -30;
		    		//Minecraft.getMinecraft().thePlayer.setPosition(this.xCoord+0.5F, this.yCoord-1.7F, this.zCoord+0.999F);
		    		tmp7.move = false;
    			}
	    		if(k < 10)
	    		{
	    			k++;
	    		}
	    		else
	    		{
					Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
					Rectangle screenRectangle = new Rectangle(screenSize);
					try{
						Robot robot = new Robot();
						BufferedImage image = robot.createScreenCapture(screenRectangle);
						if(!this.worldObj.isRemote)
							ImageIO.write(image, "png", new File((this.xCoord+"-"+this.yCoord+"-"+this.zCoord+".png")));
					}catch(Exception e)
					{}
					tmp7.setDead();
					this.screenTaken = true;
					k = 0; 
	    		}
    		}
    		if(this.screenTaken && !followed)
    		{
    			System.out.println("it goes on"+ this.worldObj);
    			if(posNext != this.firstBlock)
    				posNext.makeFirst(this.firstBlock);
    			prevNext = next = posNext;
    			this.makeFirst(this.firstBlock);
    			this.followed = true;
    		}*/
    	}
    }
    
    public void makeNext(Base tmp)
    {
    	if(tmp == this.prev)
			if((this.alignment <= 1))
				this.alignment+=2;
			else
				this.alignment-=2;
    	else
    	{
			this.next = tmp;
			tmp.prev = this;
			if(tmp != this.firstBlock)
				tmp.makeFirst(this.firstBlock);
			this.makeFirst(this.firstBlock);
    	}
    }

	@Override
	public boolean acceptsTrain(EntityTrain train) {
		
		train.posY = this.yCoord+0.999F;
		if(this.alignment == 0 || this.alignment == 2)			
		{
			train.posX = this.xCoord+0.5F;
			return true;			
		}else if(this.alignment == 1 || this.alignment == 3)			
		{
			train.posZ = this.zCoord+0.5F;
			return true;
		}
		/**
		if(this.alignment == 0 || this.alignment == 2)			
		{
			System.out.println(Math.abs(train.prevPosX) +" "+Math.abs(train.posX) );
			float x1 = (float) Math.abs(Math.abs(train.prevPosX)-Math.abs(this.xCoord));
			float x2 = (float) Math.abs(Math.abs(train.posX)-Math.abs(this.xCoord));
			if(((x2>=x1 && x1 <= 0.5F && x2 >= 0.5F) || (x2<=x1 && x1 >= 0.5F && x2 <= 0.5F)))
			{
				train.posX = this.xCoord+0.5F;
				train.posY = this.yCoord+0.99999F;
				return true;
			}
		}else if(this.alignment == 1 || this.alignment == 3)			
		{
			System.out.println(Math.abs(train.prevPosZ)+" "+Math.abs(train.posZ));
			float y1 = (float) Math.abs(Math.abs(train.prevPosZ)-Math.abs(this.zCoord));
			float y2 = (float) Math.abs(Math.abs(train.posZ)-Math.abs(this.zCoord));
			if(((y2>=y1 && y1 <= 0.5F && y2 >= 0.5F) || (y2<=y1 && y1 >= 0.5F && y2 <= 0.5F)) )
			{
				train.posZ = this.zCoord+0.5F;
				train.posY = this.yCoord+0.99999F;
				return true;
			}
		}*/
		return false;
	}
	
	public float getPlayerYOff()
	{
		return -2.7F;
	}	
	
	public float getPlayerXOff()
	{
		return 0;
	}
	
	public float getPlayerZOff()
	{
		return 0;
	}
	
	public float getHalfwayX()
	{
		return this.xCoord+0.5F;
	}
	
	public float getHalfwayY()
	{
		return this.yCoord+0.999F;
	}
	
	public float getHalfwayZ()
	{
		return this.zCoord+0.5F;
	}
	
	public boolean HasHalfway()
	{
		return true;
	}
	
	public float getDisTillOut(EntityTrain train)
	{
		if(this.alignment == 2)
			return (float) (this.zCoord+1-train.posZ);
		if(this.alignment == 3)
			return (float) (this.xCoord+1-train.posX);
		if(this.alignment == 0)
			return (float) (train.posZ-this.zCoord);
		if(this.alignment == 1)
			return (float) (train.posX-this.xCoord);
		else
			return 0;
	}
	
	public float getDisTillOutFromHalf()
	{
		return 0.5F;
	}
	
	public float getDisTillHalf(EntityTrain train)
	{
		if(this.alignment == 0 || this.alignment == 2)
			return (float) (Math.sqrt(Math.pow(this.getHalfwayZ()-train.posZ, 2)));
		if(this.alignment == 1 || this.alignment == 3)
			return (float) (Math.sqrt(Math.pow(this.getHalfwayX()-train.posX, 2)));
		else
			return 0;
	}
	
	public float getDisTillHalfPrev(EntityTrain train)
	{
		if(this.alignment == 0 || this.alignment == 2)
			return (float) (Math.sqrt(Math.pow(this.getHalfwayZ()-train.prevPosZ, 2)));
		if(this.alignment == 1 || this.alignment == 3)
			return (float) (Math.sqrt(Math.pow(this.getHalfwayX()-train.prevPosX, 2)));
		else
			return 0;
	}
	

	@Override
	public int[] getVek(int[] vek, EntityTrain train) {
		if(this.alignment == 0)
		{
			int[] tmp = {0,0,-1};
			return tmp;
		}else if(this.alignment == 1)
		{
			int[] tmp = {-1,0,0};
			return tmp;
		}else if(this.alignment == 2)
		{
			int[] tmp = {0,0,1};
			return tmp;
		}else if(this.alignment == 3)
		{
			int[] tmp = {1,0,0};
			return tmp;
		}
		train.posY = this.yCoord;
		int[] tmp = {0,0,0};
		return tmp;
	}
	
	@Override
	public float getSpeedMultiplier(EntityTrain train) {
		return 0.98F;
	}
	
}
