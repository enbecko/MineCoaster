package com.roller.roller.tileEntity;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.util.ChatComponentText;

import com.roller.roller.models.tmp2;


public class EntityTrackHor extends Base{

	public tmp2 base2;
	public float speedM = 1.1F, tempZ1, tempX1;
	int speedAim = 15, maxSpeedAim = 30, minSpeedAim = 5, holdFor = 60, ticker, k;
	public float xForDown = 1.3F, yForDown = 1.3F, zForDown = 1.3F, xForUp = 1.2F, yForUp = 1.3F, zForUp = 1.2F, turnForTrans = 45;
	boolean stop, finished;
	Base prevNext;
	public boolean screenTaken, followed;
	EntityTrain tra, tmp7;
	
    public EntityTrackHor()
    {
    	
    }
    
    public void updateEntity()
    {
    	super.updateEntity();
    	{
    		Base tmp;
    		if(this.tra != null)
    		{
    			if(this.ticker < this.holdFor)
    				this.ticker++;
    			else
    			{
    				this.tra.speed = 5;
    				this.tra.move = true;
    				this.ticker = 0;
    				this.finished = true;
    			}
    			if(tra.isDead)
    				this.tra = null;
    			if(this.alignment == 2 && tra.posZ > this.zCoord+1)
    				this.tra = null;
    			else if(this.alignment == 3 && tra.posX > this.xCoord+1)
    				this.tra = null;
    			else if(this.alignment == 0 && tra.posZ < this.zCoord)
    				this.tra = null;
    			else if(this.alignment == 1 && tra.posX < this.xCoord)
    				this.tra = null;
    		}else
        		this.finished = false;

    		if(this.first)
    		{
    			this.next = null;
    			if(this.stop && !this.down)
    				this.stop = false;
    			if(this.alignment == 0)
	    		{
	    			if(!down)
	    			{
		    			if(this.worldObj.getTileEntity(this.xCoord, this.yCoord+1, this.zCoord+1) != null && this.worldObj.getTileEntity(this.xCoord, this.yCoord+1, this.zCoord+1) instanceof EntityTrackBase)
		    			{
		    				tmp = (EntityTrackBase) this.worldObj.getTileEntity(this.xCoord, this.yCoord+1, this.zCoord+1);
		    				if((tmp.alignment % 2) == 0)
		    				{
		    					this.makeNext(tmp);
		    				}
		    			}else if(this.worldObj.getTileEntity(this.xCoord, this.yCoord+1, this.zCoord+1) != null && this.worldObj.getTileEntity(this.xCoord, this.yCoord+1, this.zCoord+1) instanceof EntityTrack225)
		    			{
		    				tmp = (EntityTrack225) this.worldObj.getTileEntity(this.xCoord, this.yCoord+1, this.zCoord+1);
		    				if(tmp.alignment == 0 || tmp.alignment == 4)
		    				{
		    					((EntityTrack225)tmp).down = false;
		    					this.makeNext(tmp);
		    				}
		    			}else if(this.worldObj.getTileEntity(this.xCoord, this.yCoord+1, this.zCoord+1) != null && this.worldObj.getTileEntity(this.xCoord, this.yCoord+1, this.zCoord+1) instanceof EntityTrackHor)
		    			{
		    				tmp = (EntityTrackHor) this.worldObj.getTileEntity(this.xCoord, this.yCoord+1, this.zCoord+1);
		    				if(tmp.alignment == this.alignment)
		    				{
		    					((EntityTrackHor)tmp).down = false;
		    					this.makeNext(tmp);
		    				}
		    			}else if(this.worldObj.getTileEntity(this.xCoord, this.yCoord+1, this.zCoord) != null && this.worldObj.getTileEntity(this.xCoord, this.yCoord+1, this.zCoord) instanceof EntityTrackUp)
		    			{
		    				tmp = (EntityTrackUp) this.worldObj.getTileEntity(this.xCoord, this.yCoord+1, this.zCoord);
		    				if(tmp.alignment == 2)
		    				{
		    					((EntityTrackUp)tmp).down = false;
		    					this.makeNext(tmp);
		    				}
		    			}
	    			}else
	    			{
		    			if(this.worldObj.getTileEntity(this.xCoord, this.yCoord-1, this.zCoord-1) != null && this.worldObj.getTileEntity(this.xCoord, this.yCoord-1, this.zCoord-1) instanceof EntityTrack225_2)
		    			{
		    				tmp = (EntityTrack225_2) this.worldObj.getTileEntity(this.xCoord, this.yCoord-1, this.zCoord-1);
		    				if(tmp.alignment == this.alignment || tmp.alignment == 4)
		    				{
		    					((EntityTrack225_2)tmp).down = true;
		    					this.makeNext(tmp);
		    				}
		    			}else if(this.worldObj.getTileEntity(this.xCoord, this.yCoord-1, this.zCoord-1) != null && this.worldObj.getTileEntity(this.xCoord, this.yCoord-1, this.zCoord-1) instanceof EntityTrackHor)
		    			{
		    				tmp = (EntityTrackHor) this.worldObj.getTileEntity(this.xCoord, this.yCoord-1, this.zCoord-1);
		    				if(tmp.alignment == this.alignment)
		    				{
		    					((EntityTrackHor)tmp).down = true;
		    					this.makeNext(tmp);
		    				}
		    			}else if(this.worldObj.getTileEntity(this.xCoord, this.yCoord, this.zCoord-1) != null && this.worldObj.getTileEntity(this.xCoord, this.yCoord, this.zCoord-1) instanceof EntityTrackBase)
		    			{
		    				tmp = (EntityTrackBase) this.worldObj.getTileEntity(this.xCoord, this.yCoord, this.zCoord-1);
		    				if((tmp.alignment % 2) == 0)
		    				{
		    					this.makeNext(tmp);
		    				}
		    			}else if(this.worldObj.getTileEntity(this.xCoord, this.yCoord-1, this.zCoord-1) != null && this.worldObj.getTileEntity(this.xCoord, this.yCoord-1, this.zCoord-1) instanceof EntityTrackUp)
		    			{
		    				tmp = (EntityTrackUp) this.worldObj.getTileEntity(this.xCoord, this.yCoord-1, this.zCoord-1);
		    				if(tmp.alignment == 2)
		    				{
		    					((EntityTrackUp)tmp).down = true;
		    					this.makeNext(tmp);
		    				}
		    			}
	    			}
	    		}
	    		if(this.alignment == 1)
	    		{
	    			if(!down)
	    			{
		    			if(this.worldObj.getTileEntity(this.xCoord+1, this.yCoord+1, this.zCoord) != null && this.worldObj.getTileEntity(this.xCoord+1, this.yCoord+1, this.zCoord) instanceof EntityTrackBase)
		    			{
		    				tmp = (EntityTrackBase) this.worldObj.getTileEntity(this.xCoord+1, this.yCoord+1, this.zCoord);
		    				if((tmp.alignment % 2) != 0)
		    				{
		    					this.makeNext(tmp);
		    				}
		    			}else if(this.worldObj.getTileEntity(this.xCoord+1, this.yCoord+1, this.zCoord) != null && this.worldObj.getTileEntity(this.xCoord+1, this.yCoord+1, this.zCoord) instanceof EntityTrackHor)
		    			{
		    				tmp = (EntityTrackHor) this.worldObj.getTileEntity(this.xCoord+1, this.yCoord+1, this.zCoord);
		    				if(tmp.alignment == this.alignment)
		    				{
		    					((EntityTrackHor)tmp).down = false;
		    					this.makeNext(tmp);
		    				}
		    			}else if(this.worldObj.getTileEntity(this.xCoord+1, this.yCoord+1, this.zCoord) != null && this.worldObj.getTileEntity(this.xCoord+1, this.yCoord+1, this.zCoord) instanceof EntityTrack225)
		    			{
		    				tmp = (EntityTrack225) this.worldObj.getTileEntity(this.xCoord+1, this.yCoord+1, this.zCoord);
		    				if(tmp.alignment == this.alignment || tmp.alignment == 5)
		    				{
		    					((EntityTrack225)tmp).down = false;
		    					this.makeNext(tmp);
		    				}
		    			}else if(this.worldObj.getTileEntity(this.xCoord, this.yCoord+1, this.zCoord) != null && this.worldObj.getTileEntity(this.xCoord, this.yCoord+1, this.zCoord) instanceof EntityTrackUp)
		    			{
		    				tmp = (EntityTrackUp) this.worldObj.getTileEntity(this.xCoord, this.yCoord+1, this.zCoord);
		    				if(tmp.alignment == 3)
		    				{
		    					((EntityTrackUp)tmp).down = false;
		    					this.makeNext(tmp);
		    				}
		    			}
	    			}else
	    			{
		    			if(this.worldObj.getTileEntity(this.xCoord-1, this.yCoord-1, this.zCoord) != null && this.worldObj.getTileEntity(this.xCoord-1, this.yCoord-1, this.zCoord) instanceof EntityTrackHor)
		    			{
		    				tmp = (EntityTrackHor) this.worldObj.getTileEntity(this.xCoord-1, this.yCoord-1, this.zCoord);
		    				if(tmp.alignment == this.alignment)
		    				{
		    					((EntityTrackHor)tmp).down = true;
		    					this.makeNext(tmp);
		    				}
		    			}else if(this.worldObj.getTileEntity(this.xCoord-1, this.yCoord-1, this.zCoord) != null && this.worldObj.getTileEntity(this.xCoord-1, this.yCoord-1, this.zCoord) instanceof EntityTrack225_2)
		    			{
		    				tmp = (EntityTrack225_2) this.worldObj.getTileEntity(this.xCoord-1, this.yCoord-1, this.zCoord);
		    				if(tmp.alignment == this.alignment || tmp.alignment == 5)
		    				{
		    					((EntityTrack225_2)tmp).down = true;
		    					this.makeNext(tmp);
		    				}
		    			}else if(this.worldObj.getTileEntity(this.xCoord-1, this.yCoord, this.zCoord) != null && this.worldObj.getTileEntity(this.xCoord-1, this.yCoord, this.zCoord) instanceof EntityTrackBase)
		    			{
		    				tmp = (EntityTrackBase) this.worldObj.getTileEntity(this.xCoord-1, this.yCoord, this.zCoord);
		    				if((tmp.alignment % 2) != 0)
		    				{
		    					this.makeNext(tmp);
		    				}
		    			}else if(this.worldObj.getTileEntity(this.xCoord-1, this.yCoord-1, this.zCoord) != null && this.worldObj.getTileEntity(this.xCoord-1, this.yCoord-1, this.zCoord) instanceof EntityTrackUp)
		    			{
		    				tmp = (EntityTrackUp) this.worldObj.getTileEntity(this.xCoord-1, this.yCoord-1, this.zCoord);
		    				if(tmp.alignment == 3)
		    				{
		    					((EntityTrackUp)tmp).down = true;
		    					this.makeNext(tmp);
		    				}
		    			}
	    			}
	    		}
	    		if(this.alignment == 2)
	    		{
	    			if(!down)
	    			{
		    			if(this.worldObj.getTileEntity(this.xCoord, this.yCoord+1, this.zCoord-1) != null && this.worldObj.getTileEntity(this.xCoord, this.yCoord+1, this.zCoord-1) instanceof EntityTrackBase)
		    			{
		    				tmp = (EntityTrackBase) this.worldObj.getTileEntity(this.xCoord, this.yCoord+1, this.zCoord-1);
		    				if((tmp.alignment % 2) == 0)
		    				{
		    					this.makeNext(tmp);
	
		    				}
		    			}else if(this.worldObj.getTileEntity(this.xCoord, this.yCoord+1, this.zCoord-1) != null && this.worldObj.getTileEntity(this.xCoord, this.yCoord+1, this.zCoord-1) instanceof EntityTrackHor)
		    			{
		    				tmp = (EntityTrackHor) this.worldObj.getTileEntity(this.xCoord, this.yCoord+1, this.zCoord-1);
		    				if(tmp.alignment == this.alignment)
		    				{
		    					((EntityTrackHor)tmp).down = false;
		    					this.makeNext(tmp);
		    				}
		    			}else if(this.worldObj.getTileEntity(this.xCoord, this.yCoord+1, this.zCoord-1) != null && this.worldObj.getTileEntity(this.xCoord, this.yCoord+1, this.zCoord-1) instanceof EntityTrack225)
		    			{
		    				tmp = (EntityTrack225) this.worldObj.getTileEntity(this.xCoord, this.yCoord+1, this.zCoord-1);
		    				if(tmp.alignment == this.alignment || tmp.alignment == 6)
		    				{
		    					((EntityTrack225)tmp).down = false;
		    					this.makeNext(tmp);
		    				}
		    			}else if(this.worldObj.getTileEntity(this.xCoord, this.yCoord+1, this.zCoord) != null && this.worldObj.getTileEntity(this.xCoord, this.yCoord+1, this.zCoord) instanceof EntityTrackUp)
		    			{
		    				tmp = (EntityTrackUp) this.worldObj.getTileEntity(this.xCoord, this.yCoord+1, this.zCoord);
		    				if(tmp.alignment == 0)
		    				{
		    					((EntityTrackUp)tmp).down = false;
		    					this.makeNext(tmp);
		    				}
		    			}
	    			}
	    			else
	    			{
		    			if(this.worldObj.getTileEntity(this.xCoord, this.yCoord-1, this.zCoord+1) != null && this.worldObj.getTileEntity(this.xCoord, this.yCoord-1, this.zCoord+1) instanceof EntityTrackHor)
		    			{
		    				tmp = (EntityTrackHor) this.worldObj.getTileEntity(this.xCoord, this.yCoord-1, this.zCoord+1);
		    				if(tmp.alignment == this.alignment)
		    				{
		    					((EntityTrackHor)tmp).down = true;
		    					this.makeNext(tmp);
		    				}
		    			}else if(this.worldObj.getTileEntity(this.xCoord, this.yCoord-1, this.zCoord+1) != null && this.worldObj.getTileEntity(this.xCoord, this.yCoord-1, this.zCoord+1) instanceof EntityTrack225_2)
		    			{
		    				tmp = (EntityTrack225_2) this.worldObj.getTileEntity(this.xCoord, this.yCoord-1, this.zCoord+1);
		    				if(tmp.alignment == this.alignment || tmp.alignment == 6)
		    				{
		    					((EntityTrack225_2)tmp).down = true;
		    					this.makeNext(tmp);
		    				}
		    			}else if(this.worldObj.getTileEntity(this.xCoord, this.yCoord, this.zCoord+1) != null && this.worldObj.getTileEntity(this.xCoord, this.yCoord, this.zCoord+1) instanceof EntityTrackBase)
		    			{
		    				tmp = (EntityTrackBase) this.worldObj.getTileEntity(this.xCoord, this.yCoord, this.zCoord+1);
		    				if((tmp.alignment % 2) == 0)
		    				{
		    					this.makeNext(tmp);
		    				}
		    			}else if(this.worldObj.getTileEntity(this.xCoord, this.yCoord-1, this.zCoord+1) != null && this.worldObj.getTileEntity(this.xCoord, this.yCoord-1, this.zCoord+1) instanceof EntityTrackUp)
		    			{
		    				tmp = (EntityTrackUp) this.worldObj.getTileEntity(this.xCoord, this.yCoord-1, this.zCoord+1);
		    				if(tmp.alignment == 0)
		    				{
		    					((EntityTrackUp)tmp).down = true;
		    					this.makeNext(tmp);
		    				}
		    			}
	    			}
	    		}
	    		if(this.alignment == 3)
	    		{
	    			if(!down)
	    			{
		    			if(this.worldObj.getTileEntity(this.xCoord-1, this.yCoord+1, this.zCoord) != null && this.worldObj.getTileEntity(this.xCoord-1, this.yCoord+1, this.zCoord) instanceof EntityTrackBase)
		    			{
		    				tmp = (EntityTrackBase) this.worldObj.getTileEntity(this.xCoord-1, this.yCoord+1, this.zCoord);
		    				if((tmp.alignment % 2) != 0)
			    			{
		    					this.makeNext(tmp);
			    			}
		    			}else if(this.worldObj.getTileEntity(this.xCoord-1, this.yCoord+1, this.zCoord) != null && this.worldObj.getTileEntity(this.xCoord-1, this.yCoord+1, this.zCoord) instanceof EntityTrackHor)
		    			{
		    				tmp = (EntityTrackHor) this.worldObj.getTileEntity(this.xCoord-1, this.yCoord+1, this.zCoord);
		    				if(tmp.alignment == this.alignment)
		    				{
		    					((EntityTrackHor)tmp).down = false;
		    					this.makeNext(tmp);
		    				}
		    			}else if(this.worldObj.getTileEntity(this.xCoord-1, this.yCoord+1, this.zCoord) != null && this.worldObj.getTileEntity(this.xCoord-1, this.yCoord+1, this.zCoord) instanceof EntityTrack225)
		    			{
		    				tmp = (EntityTrack225) this.worldObj.getTileEntity(this.xCoord-1, this.yCoord+1, this.zCoord);
		    				if(tmp.alignment == this.alignment || tmp.alignment == 7)
		    				{
		    					((EntityTrack225)tmp).down = false;
		    					this.makeNext(tmp);
		    				}
		    			}else if(this.worldObj.getTileEntity(this.xCoord, this.yCoord+1, this.zCoord) != null && this.worldObj.getTileEntity(this.xCoord, this.yCoord+1, this.zCoord) instanceof EntityTrackUp)
		    			{
		    				tmp = (EntityTrackUp) this.worldObj.getTileEntity(this.xCoord, this.yCoord+1, this.zCoord);
		    				if(tmp.alignment == 1)
		    				{
		    					((EntityTrackUp)tmp).down = false;
		    					this.makeNext(tmp);
		    				}
		    			}
	    			}else
	    			{
	    				if(this.worldObj.getTileEntity(this.xCoord+1, this.yCoord-1, this.zCoord) != null && this.worldObj.getTileEntity(this.xCoord+1, this.yCoord-1, this.zCoord) instanceof EntityTrackHor)
		    			{
		    				tmp = (EntityTrackHor) this.worldObj.getTileEntity(this.xCoord+1, this.yCoord-1, this.zCoord);
		    				if(tmp.alignment == this.alignment)
		    				{
		    					((EntityTrackHor)tmp).down = true;
		    					this.makeNext(tmp);
		    				}
		    			}else if(this.worldObj.getTileEntity(this.xCoord+1, this.yCoord-1, this.zCoord) != null && this.worldObj.getTileEntity(this.xCoord+1, this.yCoord-1, this.zCoord) instanceof EntityTrack225_2)
		    			{
		    				tmp = (EntityTrack225_2) this.worldObj.getTileEntity(this.xCoord+1, this.yCoord-1, this.zCoord);
		    				if(tmp.alignment == this.alignment || tmp.alignment == 7)
		    				{
		    					((EntityTrack225_2)tmp).down = true;
		    					this.makeNext(tmp);
		    				}
		    			}else if(this.worldObj.getTileEntity(this.xCoord+1, this.yCoord, this.zCoord) != null && this.worldObj.getTileEntity(this.xCoord+1, this.yCoord, this.zCoord) instanceof EntityTrackBase)
		    			{
		    				tmp = (EntityTrackBase) this.worldObj.getTileEntity(this.xCoord+1, this.yCoord, this.zCoord);
		    				if((tmp.alignment % 2) != 0)
		    				{
		    					this.makeNext(tmp);
		    				}
		    			}else if(this.worldObj.getTileEntity(this.xCoord+1, this.yCoord-1, this.zCoord) != null && this.worldObj.getTileEntity(this.xCoord+1, this.yCoord-1, this.zCoord) instanceof EntityTrackUp)
		    			{
		    				tmp = (EntityTrackUp) this.worldObj.getTileEntity(this.xCoord+1, this.yCoord-1, this.zCoord);
		    				if(tmp.alignment == 1)
		    				{
		    					((EntityTrackUp)tmp).down = true;
		    					this.makeNext(tmp);
		    				}
		    			}
	    			}
	    		}
	    		//if(!this.worldObj.isRemote)
	    		if(this.next == null)
	    		{
	    			this.failed = true;
	    		}
	    		this.makeFirst(this.firstBlock);
				if(!this.worldObj.isRemote)
				{
		    		System.out.println(this.prev+" "+this.xCoord+" "+this.yCoord+" "+this.zCoord+" "+this.next);
		    		System.out.println("");
				}
    		}
    	}
    }
    
	
    public void makeNext(Base tmp)
    {
    	if(tmp == this.prev)
    	{
        	System.out.println(this.down+" "+tmp+" "+this.prev+" cockfuck bei hor");

			if((tmp.alignment <= 1))
				tmp.alignment+=2;
			else
				tmp.alignment-=2;
    	}
    	else
    	{
			this.next = tmp;
			tmp.prev = this;
			if(tmp != this.firstBlock)
				tmp.makeFirst(this.firstBlock);	    	
    	}
    }
        
	@Override
	public void itemAction(EntityPlayer p) {
		int num = 0;
		if(!this.power && !this.stop)
		{
			this.power = true;
			num = 2;
		}
		else if(this.power)
		{
			this.power = false;
			this.stop = true;
			num = 1;
		}else if(this.stop)
		{
			this.power = false;
			this.stop = false;
			num = 0;
		}
		for(int k = 0; k < 10-1; k++)
		{
    		p.addChatMessage(new ChatComponentText(""));  
		}
		p.addChatMessage(new ChatComponentText("mode: "+(num+1)+"/"+3)); 
	}
	
	public void itemAction2(boolean up, EntityPlayer p) {
		if(this.power || this.brake)
		{
			if(up)
			{
				if(speedAim + 1 <= this.maxSpeedAim)
					this.speedAim += 1;
			}
			else
				if(speedAim - 1 >= this.minSpeedAim)
					this.speedAim -= 1;
			for(int k = 0; k < 10-1; k++)
			{
	    		p.addChatMessage(new ChatComponentText(""));  
			}
			for(int k = 0; k < 1; k++)
				p.addChatMessage(new ChatComponentText(""+ this.getAsBMin(this.speedAim)+" B/min ("+this.getAsBSec(this.speedAim)+" B/s)")); 
			System.out.println(this.worldObj+" "+this.speedAim);
		}
	}
	
	 public void readFromNBT(NBTTagCompound k)
	    {
	        super.readFromNBT(k);
	        this.speedAim = k.getInteger("sA");
	        this.stop = k.getBoolean("st");
	    }

	    public void writeToNBT(NBTTagCompound k)
	    {
	        super.writeToNBT(k);
	        k.setInteger("sA", this.speedAim);
	        k.setBoolean("st", this.stop);
	   }
	    
		@Override
	    public void onDataPacket(NetworkManager net, S35PacketUpdateTileEntity packet) {
			NBTTagCompound k = packet.func_148857_g();
	        this.alignment = k.getInteger("Al");
	        this.brake = k.getBoolean("br");
	        this.power = k.getBoolean("po");
	        this.powerAndBreak = k.getBoolean("pobr");
	        this.start = k.getBoolean("st");
	        this.down = k.getBoolean("do");
	        this.speedAim = k.getInteger("sA");
	        this.stop = k.getBoolean("st");
	        this.color = k.getInteger("col");
	        this.locked = k.getBoolean("lo");
	        int[] tmp = k.getIntArray("next");
	        boolean mhm = false;
	        for(int l = 0; l < 3; l++)
	        {
	        	if(tmp[l] == 999)
	        	{
	        		mhm = true;
	        	}
	        }
	        if(!mhm)
	        {
	        	try{
	        		this.nextC = tmp;
	        	}catch(Exception e)
	        	{
	        		e.printStackTrace();
	        	}
	        }
	        int[] tmp2 = k.getIntArray("prev");
	        boolean mhm2 = false;
	        for(int l = 0; l < 3; l++)
	        {
	        	if(tmp2[l] == 999)
	        	{
	        		mhm2 = true;
	        	}
	        }
	        if(!mhm2)
	        {
	        	try{
	        		this.prevC = tmp2;
	        	}catch(Exception e)
	        	{
	        		
	        	}
	        }
		}
		
		public Packet getDescriptionPacket()
		{
			NBTTagCompound k = new NBTTagCompound();
	        k.setInteger("Al", this.alignment);
	        k.setBoolean("br", this.brake);
	        k.setBoolean("po", this.power);
	        k.setBoolean("pobr", this.powerAndBreak);
	        k.setBoolean("st", this.start);
	        k.setBoolean("do", this.down);
	        k.setBoolean("st", this.stop);
	        k.setInteger("sA", this.speedAim);
	        k.setInteger("col", this.color);
	        k.setBoolean("lo", this.locked);
	        int[] tmp = new int[3];
	    	if(this.next != null)
	    	{
	    		tmp[0] = next.xCoord;
	    		tmp[1] = next.yCoord;
	    		tmp[2] = next.zCoord;
	    	}else
	    	{
	    		tmp[0] = 999;
	    		tmp[1] = 999;
	    		tmp[2] = 999;
	    	}
	    	k.setIntArray("next", tmp);
	    	int[] tmp2 = new int[3];
	    	if(this.next != null)
	    	{
	    		tmp2[0] = next.xCoord;
	    		tmp2[1] = next.yCoord;
	    		tmp2[2] = next.zCoord;
	    	}else
	    	{
	    		tmp2[0] = 999;
	    		tmp2[1] = 999;
	    		tmp2[2] = 999;
	    	}
	    	k.setIntArray("prev", tmp);
	        return new S35PacketUpdateTileEntity(this.xCoord, this.yCoord, this.zCoord, 0, k);
		}

	
	@Override
	public boolean acceptsTrain(EntityTrain train) {
		if(!this.stop || this.finished)
		{
			if(this.alignment == 0 || this.alignment == 2)			
			{
				train.posX = this.xCoord+0.5F;
				if(!this.finished)
				{
					float kole;
					float yDings, zDings;
					if(down)
						yDings = (float) Math.abs(this.yCoord+0.9999F-train.posY);
					else
						yDings = (float) Math.abs(train.posY-this.yCoord);
					if((this.alignment == 2 && !this.down) || (this.alignment == 0 && this.down))
						zDings = (float) Math.abs(this.zCoord+0.9999F-train.posZ);
					else
						zDings = (float) Math.abs(train.posZ-this.zCoord);

					if(yDings > zDings)
						kole = yDings;
					else
						kole = zDings;
					if(this.down)
						train.posY = this.yCoord+0.999F-kole;
					else
						train.posY = this.yCoord+kole;
					if((this.alignment == 2 && !this.down) || (this.alignment == 0 && this.down))
						train.posZ = this.zCoord+0.999F-kole;
					else
						train.posZ = this.zCoord+kole;
				}
				return true;			
			}else if(this.alignment == 1 || this.alignment == 3)			
			{
				train.posZ = this.zCoord+0.5F;
				if(!this.finished)
				{
					float kole;
					float yDings, xDings;
					if(down)
						yDings = (float) Math.abs(this.yCoord+0.9999F-train.posY);
					else
						yDings = (float) Math.abs(train.posY-this.yCoord);
					if((this.alignment == 3 && !this.down) || (this.alignment == 1 && this.down))
						xDings = (float) Math.abs(this.xCoord+0.9999F-train.posX);
					else
						xDings = (float) Math.abs(train.posX-this.xCoord);
					System.out.println(yDings+" "+xDings);
					if(yDings > xDings)
						kole = yDings;
					else
						kole = xDings;
					if(this.down)
						train.posY = this.yCoord+0.999999F-kole;
					else
						train.posY = this.yCoord+kole;
					if((this.alignment == 3 && !this.down) || (this.alignment == 1 && this.down))
						train.posX = this.xCoord+0.999999F-kole;
					else
						train.posX = this.xCoord+kole;

				}
				return true;
			}
		}else
		{
			if(this.alignment == 0 || this.alignment == 2)			
			{
				float z1 = (float) Math.abs(this.zCoord+0.5F-train.posZ);
				if(z1 > 0 && train.speed > 2)
				{
					train.speed *= 0.7F;
					this.tempZ1  = z1;
					return false;
				}
				else if(z1 > 0)
				{
					if(z1 > tempZ1)
					{
						train.posZ = this.zCoord+0.5F;
						train.posY = this.yCoord+0.5F;
						train.move = false;
						this.tra = train;
						return false;
					}
					this.tempZ1  = z1;
					return false;
				}
				train.move = false;
				this.tra = train;
				return false;			
			}else if(this.alignment == 1 || this.alignment == 3)			
			{
				float x1 = (float) Math.abs(this.xCoord+0.5F-train.posX);
				if(x1 > 0 && train.speed > 2)
				{
					train.speed *= 0.7F;
					this.tempX1  = x1;
					return false;
				}
				else if(x1 > 0)
				{
					if(x1 > tempX1)
					{
						train.posX = this.xCoord+0.5F;
						train.posY = this.yCoord+0.5F;
						this.tra = train;
						train.move = false;
						return false;
					}
					this.tempX1  = x1;
					return false;
				}
				train.move = false;
				this.tra = train;
				return false;	
			}
		}
		return false;
	}
	
	public float getPlayerXOff()
	{
		if(this.alignment == 1)
			return -0.9F;
		else if(this.alignment == 3)
			return 0.9F;
		else return 0;
	}
	
	public float getPlayerYOff()
	{
		if(!this.down)
		{
    		return -0.3F;
		}else
		{
			return -0.2F;
		}
	}	
	
	public float getPlayerZOff()
	{
		if(this.alignment == 0)
			return -0.9F;
		else if(this.alignment == 2)
			return 0.9F;
		else return 0;
	}
	
	public float getHalfwayX()
	{
		return this.xCoord+0.5F;
	}
	
	public float getHalfwayY()
	{
		return this.yCoord+0.5F;
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
		if(this.alignment == 0 && !down)
			return (float) (Math.sqrt(Math.pow(this.yCoord+1-train.posY, 2)+Math.pow(this.zCoord+1-train.posZ, 2)));
		if(this.alignment == 1 && !down)
			return (float) (Math.sqrt(Math.pow(this.yCoord+1-train.posY, 2)+Math.pow(this.xCoord+1-train.posX, 2)));
		if(this.alignment == 2 && !down)
			return (float) (Math.sqrt(Math.pow(this.yCoord+1-train.posY, 2)+Math.pow(train.posZ-this.zCoord, 2)));
		if(this.alignment == 3 && !down)
			return (float) (Math.sqrt(Math.pow(this.yCoord+1-train.posY, 2)+Math.pow(train.posX-this.xCoord, 2)));
		if(this.alignment == 2 && down)
			return (float) (Math.sqrt(Math.pow(train.posY-this.yCoord, 2)+Math.pow(this.zCoord+1-train.posZ, 2)));
		if(this.alignment == 3 && down)
			return (float) (Math.sqrt(Math.pow(train.posY-this.yCoord, 2)+Math.pow(this.xCoord+1-train.posX, 2)));
		if(this.alignment == 0 && down)
			return (float) (Math.sqrt(Math.pow(train.posY-this.yCoord, 2)+Math.pow(train.posZ-this.zCoord, 2)));
		if(this.alignment == 1 && down)
			return (float) (Math.sqrt(Math.pow(train.posY-this.yCoord, 2)+Math.pow(train.posX-this.xCoord, 2)));
		else
			return 0;
	}
	
	public float getDisTillOutFromHalf()
	{
		return (float) Math.sqrt(0.5F);
	}
	
	public float getDisTillHalf(EntityTrain train)
	{
		if(this.alignment == 0 || this.alignment == 2)
			return (float) (Math.sqrt(Math.pow(train.posZ-this.getHalfwayZ(), 2)+Math.pow(train.posY-this.getHalfwayY(), 2)));
		if(this.alignment == 1 || this.alignment == 3)
			return (float) (Math.sqrt(Math.pow(train.posX-this.getHalfwayX(), 2)+Math.pow(train.posY-this.getHalfwayY(), 2)));
		else
			return 0;
	}
	
	public float getDisTillHalfPrev(EntityTrain train)
	{
		if(this.alignment == 0 || this.alignment == 2)
			return (float) (Math.sqrt(Math.pow(train.prevPosZ-this.getHalfwayZ(), 2)+Math.pow(train.prevPosY-this.getHalfwayY(), 2)));
		if(this.alignment == 1 || this.alignment == 3)
			return (float) (Math.sqrt(Math.pow(train.prevPosX-this.getHalfwayX(), 2)+Math.pow(train.prevPosY-this.getHalfwayY(), 2)));
		else
			return 0;
	}
	
	@Override
	public int[] getVek(int[] vek, EntityTrain train) {
		if(this.alignment == 0)
		{
			if(!this.down)
			{
				int[] tmp = {0,1,1};
				return tmp;
			}
			else
			{
				int[] tmp = {0,-1,-1};
				return tmp;
			}
		}else if(this.alignment == 1)
		{
			if(!this.down)
			{
				int[] tmp = {1,1,0};
				return tmp;
			}
			else
			{
				int[] tmp = {-1,-1,0};
				return tmp;
			}
		}else if(this.alignment == 2)
		{
			if(!this.down)
			{
				int[] tmp = {0,1,-1};
				return tmp;
			}
			else
			{
				int[] tmp = {0,-1,1};
				return tmp;
			}
		}else if(this.alignment == 3)
		{
			if(!this.down)
			{
				int[] tmp = {-1,1,0};
				return tmp;
			}
			else
			{
				int[] tmp = {1,-1,0};
				return tmp;
			}
		}
		int[] tmp = {0,0,0};
		return tmp;
	}
	
	@Override
	public float getSpeedMultiplier(EntityTrain train) {
		if(!this.power)
		{
			if(!this.down)
				return 0.975F;
			else
				return 1.025F;
		}else
		{
			if(train.speed*this.speedM <= this.speedAim)
				return this.speedM;
			else if(train.speed -1 < this.speedAim && train.speed > this.speedAim)
			{
				train.speed = this.speedAim;
				return 1;
			}else
			{
				if(!this.down)
					return 0.975F;
				else
					return 1.025F;
			}
		}
	}
	
}
