package com.roller.roller.tileEntity;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.util.ChatComponentText;

import com.roller.roller.models.tmp2;


public class EntityTrack225 extends Base{

	public tmp2 base2;
	public float speedM = 1.1F, tempZ1, tempX1;
	int speedAim = 15, maxSpeedAim = 30, minSpeedAim = 5, holdFor = 60, ticker;	
	public float xForDown = 0.7F, yForDown = 1.7F, zForDown = 0.7F, xForUp = 0.63F, yForUp = 1.8F, zForUp = 0.63F, turnForTrans = 27;
	public EntityTrack225()
    {
    	
    }
    
    public void updateEntity()
    {
    	super.updateEntity();
    	{
    		Base tmp;
    
    		if(this.first)
    		{
    			this.next = null;
    			if(this.alignment == 0)
	    		{
	    			if(!down)
	    			{
		    			if(this.worldObj.getTileEntity(this.xCoord, this.yCoord, this.zCoord+1) != null && this.worldObj.getTileEntity(this.xCoord, this.yCoord, this.zCoord+1) instanceof EntityTrack225_2)
		    			{
		    				tmp = (EntityTrack225_2) this.worldObj.getTileEntity(this.xCoord, this.yCoord, this.zCoord+1);
		    				if(tmp.alignment == 0)
		    				{
		    					((EntityTrack225_2)tmp).down = false;
		    					this.makeNext(tmp);
		    				}
		    			}
	    			}else
	    			{
		    			if(this.worldObj.getTileEntity(this.xCoord, this.yCoord-1, this.zCoord-1) != null && this.worldObj.getTileEntity(this.xCoord, this.yCoord-1, this.zCoord-1) instanceof EntityTrack225_2)
		    			{
		    				tmp = (EntityTrack225_2)this.worldObj.getTileEntity(this.xCoord, this.yCoord-1, this.zCoord-1);
		    				if(tmp.alignment == this.alignment)
		    				{
		    					((EntityTrack225_2)tmp).down = true;
		    					this.makeNext(tmp);
		    				}
		    			}else if(this.worldObj.getTileEntity(this.xCoord, this.yCoord-1, this.zCoord-1) != null && this.worldObj.getTileEntity(this.xCoord, this.yCoord-1, this.zCoord-1) instanceof EntityTrackHor)
		    			{
		    				tmp = (EntityTrackHor)this.worldObj.getTileEntity(this.xCoord, this.yCoord-1, this.zCoord-1);
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
		    			}
	    			}
	    		}
	    		if(this.alignment == 1)
	    		{
	    			if(!down)
	    			{
		    			if(this.worldObj.getTileEntity(this.xCoord+1, this.yCoord, this.zCoord) != null && this.worldObj.getTileEntity(this.xCoord+1, this.yCoord, this.zCoord) instanceof EntityTrack225_2)
		    			{
		    				tmp = (EntityTrack225_2) this.worldObj.getTileEntity(this.xCoord+1, this.yCoord, this.zCoord);
		    				if(tmp.alignment == 1)
		    				{
		    					((EntityTrack225_2)tmp).down = false;
		    					this.makeNext(tmp);
		    				}
		    			}
	    			}else
	    			{
		    			if(this.worldObj.getTileEntity(this.xCoord-1, this.yCoord-1, this.zCoord) != null && this.worldObj.getTileEntity(this.xCoord-1, this.yCoord-1, this.zCoord) instanceof EntityTrack225_2)
		    			{
		    				tmp = (EntityTrack225_2) this.worldObj.getTileEntity(this.xCoord-1, this.yCoord-1, this.zCoord);
		    				if(tmp.alignment == this.alignment)
		    				{
		    					((EntityTrack225_2)tmp).down = true;
		    					this.makeNext(tmp);
		    				}
		    			}else if(this.worldObj.getTileEntity(this.xCoord-1, this.yCoord-1, this.zCoord) != null && this.worldObj.getTileEntity(this.xCoord-1, this.yCoord-1, this.zCoord) instanceof EntityTrackHor)
		    			{
		    				tmp = (EntityTrackHor) this.worldObj.getTileEntity(this.xCoord-1, this.yCoord-1, this.zCoord);
		    				if(tmp.alignment == this.alignment)
		    				{
		    					((EntityTrackHor)tmp).down = true;
		    					this.makeNext(tmp);
		    				}
		    			}else if(this.worldObj.getTileEntity(this.xCoord-1, this.yCoord, this.zCoord) != null && this.worldObj.getTileEntity(this.xCoord-1, this.yCoord, this.zCoord) instanceof EntityTrackBase)
		    			{
		    				tmp = (EntityTrackBase) this.worldObj.getTileEntity(this.xCoord-1, this.yCoord, this.zCoord);
		    				if((tmp.alignment % 2) != 0)
		    				{
		    					this.makeNext(tmp);
		    				}
		    			}
	    			}
	    		}
	    		if(this.alignment == 2)
	    		{
	    			if(!down)
	    			{
		    			if(this.worldObj.getTileEntity(this.xCoord, this.yCoord, this.zCoord-1) != null && this.worldObj.getTileEntity(this.xCoord, this.yCoord, this.zCoord-1) instanceof EntityTrack225_2)
		    			{
		    				tmp = (EntityTrack225_2) this.worldObj.getTileEntity(this.xCoord, this.yCoord, this.zCoord-1);
		    				if(tmp.alignment== 2)
		    				{
		    					((EntityTrack225_2)tmp).down = false;
		    					this.makeNext(tmp);
	
		    				}
		    			}
	    			}
	    			else
	    			{
		    			if(this.worldObj.getTileEntity(this.xCoord, this.yCoord-1, this.zCoord+1) != null && this.worldObj.getTileEntity(this.xCoord, this.yCoord-1, this.zCoord+1) instanceof EntityTrack225_2)
		    			{
		    				tmp = (EntityTrack225_2) this.worldObj.getTileEntity(this.xCoord, this.yCoord-1, this.zCoord+1);
		    				if(tmp.alignment == this.alignment)
		    				{
		    					((EntityTrack225_2)tmp).down = true;
		    					this.makeNext(tmp);
		    				}
		    			}else if(this.worldObj.getTileEntity(this.xCoord, this.yCoord-1, this.zCoord+1) != null && this.worldObj.getTileEntity(this.xCoord, this.yCoord-1, this.zCoord+1) instanceof EntityTrackHor)
		    			{
		    				tmp = (EntityTrackHor) this.worldObj.getTileEntity(this.xCoord, this.yCoord-1, this.zCoord+1);
		    				if(tmp.alignment == this.alignment)
		    				{
		    					((EntityTrackHor)tmp).down = true;
		    					this.makeNext(tmp);
		    				}
		    			}else if(this.worldObj.getTileEntity(this.xCoord, this.yCoord, this.zCoord+1) != null && this.worldObj.getTileEntity(this.xCoord, this.yCoord, this.zCoord+1) instanceof EntityTrackBase)
		    			{
		    				tmp = (EntityTrackBase) this.worldObj.getTileEntity(this.xCoord, this.yCoord, this.zCoord+1);
		    				if((tmp.alignment % 2) == 0)
		    				{
		    					this.makeNext(tmp);
		    				}
		    			}
	    			}
	    		}
	    		if(this.alignment == 3)
	    		{
	    			if(!down)
	    			{
		    			if(this.worldObj.getTileEntity(this.xCoord-1, this.yCoord, this.zCoord) != null && this.worldObj.getTileEntity(this.xCoord-1, this.yCoord, this.zCoord) instanceof EntityTrack225_2)
		    			{
		    				tmp = (EntityTrack225_2) this.worldObj.getTileEntity(this.xCoord-1, this.yCoord, this.zCoord);
		    				if(tmp.alignment == 3)
			    			{
		    					((EntityTrack225_2)tmp).down = false;
		    					this.makeNext(tmp);
			    			}
		    			}
	    			}else
	    			{
	    				if(this.worldObj.getTileEntity(this.xCoord+1, this.yCoord-1, this.zCoord) != null && this.worldObj.getTileEntity(this.xCoord+1, this.yCoord-1, this.zCoord) instanceof EntityTrack225_2)
		    			{
		    				tmp = (EntityTrack225_2) this.worldObj.getTileEntity(this.xCoord+1, this.yCoord-1, this.zCoord);
		    				if(tmp.alignment == this.alignment)
		    				{
		    					((EntityTrack225_2)tmp).down = true;
		    					this.makeNext(tmp);
		    				}
		    			}else if(this.worldObj.getTileEntity(this.xCoord+1, this.yCoord-1, this.zCoord) != null && this.worldObj.getTileEntity(this.xCoord+1, this.yCoord-1, this.zCoord) instanceof EntityTrackHor)
		    			{
		    				tmp = (EntityTrackHor) this.worldObj.getTileEntity(this.xCoord+1, this.yCoord-1, this.zCoord);
		    				if(tmp.alignment == this.alignment)
		    				{
		    					((EntityTrackHor)tmp).down = true;
		    					this.makeNext(tmp);
		    				}
		    			}else if(this.worldObj.getTileEntity(this.xCoord+1, this.yCoord, this.zCoord) != null && this.worldObj.getTileEntity(this.xCoord+1, this.yCoord, this.zCoord) instanceof EntityTrackBase)
		    			{
		    				tmp = (EntityTrackBase) this.worldObj.getTileEntity(this.xCoord+1, this.yCoord, this.zCoord);
		    				if((tmp.alignment % 2) != 0)
		    				{
		    					this.makeNext(tmp);
		    				}
		    			}
	    			}
	    		}
	    		if(this.alignment == 4)
	    		{
	    			if(!down)
	    			{
		    			if(this.worldObj.getTileEntity(this.xCoord, this.yCoord+1, this.zCoord) != null && this.worldObj.getTileEntity(this.xCoord, this.yCoord+1, this.zCoord) instanceof EntityTrack225_2)
		    			{
		    				tmp = (EntityTrack225_2) this.worldObj.getTileEntity(this.xCoord, this.yCoord+1, this.zCoord);
		    				if(tmp.alignment == 4)
		    				{
		    					((EntityTrack225_2)tmp).down = false;
		    					this.makeNext(tmp);
		    				}
		    			}
	    			}else
	    			{
		    			if(this.worldObj.getTileEntity(this.xCoord, this.yCoord-1, this.zCoord-1) != null && this.worldObj.getTileEntity(this.xCoord, this.yCoord-1, this.zCoord-1) instanceof EntityTrack225_2)
		    			{
		    				tmp = (EntityTrack225_2)this.worldObj.getTileEntity(this.xCoord, this.yCoord-1, this.zCoord-1);
		    				if(tmp.alignment == this.alignment)
		    				{
		    					((EntityTrack225_2)tmp).down = true;
		    					this.makeNext(tmp);
		    				}
		    			}else if(this.worldObj.getTileEntity(this.xCoord, this.yCoord-1, this.zCoord-1) != null && this.worldObj.getTileEntity(this.xCoord, this.yCoord-1, this.zCoord-1) instanceof EntityTrackHor)
		    			{
		    				tmp = (EntityTrackHor)this.worldObj.getTileEntity(this.xCoord, this.yCoord-1, this.zCoord-1);
		    				if(tmp.alignment == 0)
		    				{
		    					((EntityTrackHor)tmp).down = true;
		    					this.makeNext(tmp);
		    				}
		    			}else if(this.worldObj.getTileEntity(this.xCoord, this.yCoord-1, this.zCoord-1) != null && this.worldObj.getTileEntity(this.xCoord, this.yCoord-1, this.zCoord-1) instanceof EntityTrackUp)
		    			{
		    				tmp = (EntityTrackUp) this.worldObj.getTileEntity(this.xCoord, this.yCoord-1, this.zCoord-1);
		    				if(tmp.alignment == 2)
		    				{
		    					tmp.down = true;
		    					this.makeNext(tmp);
		    				}
		    			}
	    			}
	    		}
	    		if(this.alignment == 5)
	    		{
	    			if(!down)
	    			{
		    			if(this.worldObj.getTileEntity(this.xCoord, this.yCoord+1, this.zCoord) != null && this.worldObj.getTileEntity(this.xCoord, this.yCoord+1, this.zCoord) instanceof EntityTrack225_2)
		    			{
		    				tmp = (EntityTrack225_2) this.worldObj.getTileEntity(this.xCoord, this.yCoord+1, this.zCoord);
		    				if(tmp.alignment == 5)
		    				{
		    					((EntityTrack225_2)tmp).down = false;
		    					this.makeNext(tmp);
		    				}
		    			}
	    			}else
	    			{
		    			if(this.worldObj.getTileEntity(this.xCoord-1, this.yCoord-1, this.zCoord) != null && this.worldObj.getTileEntity(this.xCoord-1, this.yCoord-1, this.zCoord) instanceof EntityTrack225_2)
		    			{
		    				tmp = (EntityTrack225_2) this.worldObj.getTileEntity(this.xCoord-1, this.yCoord-1, this.zCoord);
		    				if(tmp.alignment == this.alignment)
		    				{
		    					((EntityTrack225_2)tmp).down = true;
		    					this.makeNext(tmp);
		    				}
		    			}else if(this.worldObj.getTileEntity(this.xCoord-1, this.yCoord-1, this.zCoord) != null && this.worldObj.getTileEntity(this.xCoord-1, this.yCoord-1, this.zCoord) instanceof EntityTrackHor)
		    			{
		    				tmp = (EntityTrackHor) this.worldObj.getTileEntity(this.xCoord-1, this.yCoord-1, this.zCoord);
		    				if(tmp.alignment == 1)
		    				{
		    					((EntityTrackHor)tmp).down = true;
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
	    		if(this.alignment == 6)
	    		{
	    			if(!down)
	    			{
		    			if(this.worldObj.getTileEntity(this.xCoord, this.yCoord+1, this.zCoord) != null && this.worldObj.getTileEntity(this.xCoord, this.yCoord+1, this.zCoord) instanceof EntityTrack225_2)
		    			{
		    				tmp = (EntityTrack225_2) this.worldObj.getTileEntity(this.xCoord, this.yCoord+1, this.zCoord);
		    				if(tmp.alignment== 6)
		    				{
		    					((EntityTrack225_2)tmp).down = false;
		    					this.makeNext(tmp);
	
		    				}
		    			}
	    			}
	    			else
	    			{
		    			if(this.worldObj.getTileEntity(this.xCoord, this.yCoord-1, this.zCoord+1) != null && this.worldObj.getTileEntity(this.xCoord, this.yCoord-1, this.zCoord+1) instanceof EntityTrack225_2)
		    			{
		    				tmp = (EntityTrack225_2) this.worldObj.getTileEntity(this.xCoord, this.yCoord-1, this.zCoord+1);
		    				if(tmp.alignment == this.alignment)
		    				{
		    					((EntityTrack225_2)tmp).down = true;
		    					this.makeNext(tmp);
		    				}
		    			}else if(this.worldObj.getTileEntity(this.xCoord, this.yCoord-1, this.zCoord+1) != null && this.worldObj.getTileEntity(this.xCoord, this.yCoord-1, this.zCoord+1) instanceof EntityTrackHor)
		    			{
		    				tmp = (EntityTrackHor) this.worldObj.getTileEntity(this.xCoord, this.yCoord-1, this.zCoord+1);
		    				if(tmp.alignment == 2)
		    				{
		    					((EntityTrackHor)tmp).down = true;
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
	    		if(this.alignment == 7)
	    		{
	    			if(!down)
	    			{
		    			if(this.worldObj.getTileEntity(this.xCoord, this.yCoord+1, this.zCoord) != null && this.worldObj.getTileEntity(this.xCoord, this.yCoord+1, this.zCoord) instanceof EntityTrack225_2)
		    			{
		    				tmp = (EntityTrack225_2) this.worldObj.getTileEntity(this.xCoord, this.yCoord+1, this.zCoord);
		    				if(tmp.alignment == 7)
			    			{
		    					((EntityTrack225_2)tmp).down = false;
		    					this.makeNext(tmp);
			    			}
		    			}
	    			}else
	    			{
	    				if(this.worldObj.getTileEntity(this.xCoord+1, this.yCoord-1, this.zCoord) != null && this.worldObj.getTileEntity(this.xCoord+1, this.yCoord-1, this.zCoord) instanceof EntityTrack225_2)
		    			{
		    				tmp = (EntityTrack225_2) this.worldObj.getTileEntity(this.xCoord+1, this.yCoord-1, this.zCoord);
		    				if(tmp.alignment == this.alignment)
		    				{
		    					((EntityTrack225_2)tmp).down = true;
		    					this.makeNext(tmp);
		    				}
		    			}else if(this.worldObj.getTileEntity(this.xCoord+1, this.yCoord-1, this.zCoord) != null && this.worldObj.getTileEntity(this.xCoord+1, this.yCoord-1, this.zCoord) instanceof EntityTrackHor)
		    			{
		    				tmp = (EntityTrackHor) this.worldObj.getTileEntity(this.xCoord+1, this.yCoord-1, this.zCoord);
		    				if(tmp.alignment == 3)
		    				{
		    					((EntityTrackHor)tmp).down = true;
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
        

	
	 public void readFromNBT(NBTTagCompound k)
	    {
	        super.readFromNBT(k);
	        this.speedAim = k.getInteger("sA");
	    }

	    public void writeToNBT(NBTTagCompound k)
	    {
	        super.writeToNBT(k);
	        k.setInteger("sA", this.speedAim);
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
			if(this.alignment == 0 || this.alignment == 2)			
			{
				train.posX = this.xCoord+0.5F;
				if(this.alignment == 2)
					train.posY = this.yCoord+0.05F+(float)((this.zCoord+0.9999F-train.posZ)*0.5F);
				else
					train.posY = this.yCoord+0.05F+(float)((train.posZ-this.zCoord)*0.5F);

				/**
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

				if(yDings*2 > zDings)
					kole = yDings;
				else
					kole = zDings;
				if(this.down)
					train.posY = this.yCoord+0.999F-(float)(kole/2);
				else
					train.posY = this.yCoord+(float)(kole/2);*/
				return true;			
			}else if(this.alignment == 1 || this.alignment == 3)			
			{
				train.posZ = this.zCoord+0.5F;	
				if(this.alignment == 3)
					train.posY = this.yCoord+0.05F+(float)((this.xCoord+0.9999F-train.posX)*0.5F);
				else
					train.posY = this.yCoord+0.05F+(float)((train.posX-this.xCoord)*0.5F);
				/**
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

					if(yDings > xDings)
						kole = yDings;
					else
						kole = xDings;
					if(this.down)
						train.posY = this.yCoord+0.999F-kole;
					else
						train.posY = this.yCoord+kole;*/
				return true;
			}else if(this.alignment == 4 || this.alignment == 6)			
			{
				train.posX = this.xCoord+0.5F;
				/**
				float kole;
				float yDings, zDings;
				if(down)
					yDings = (float) Math.abs(this.yCoord+0.9999F-train.posY);
				else
					yDings = (float) Math.abs(train.posY-this.yCoord);
				if((this.alignment == 6 && !this.down) || (this.alignment == 4 && this.down))
					zDings = (float) Math.abs(this.zCoord+0.9999F-train.posZ);
				else
					zDings = (float) Math.abs(train.posZ-this.zCoord);

				if(yDings*2 > zDings)
				{
					kole = yDings;
					if(this.down)
						train.posY = this.yCoord+0.999F-(float)(kole/2);
					else
						train.posY = this.yCoord+(float)(kole/2);
				}
				else
				{
					kole = zDings;
					if((this.alignment == 6 && !this.down) || (this.alignment == 4 && this.down))
						train.posZ = this.zCoord+0.999F-kole/2;
					else
						train.posZ = this.zCoord+kole/2;
				}*/
				return true;				
			}else if(this.alignment == 5 || this.alignment == 7)
			{
				train.posZ = this.zCoord+0.5F;
				/**
					float kole;
					float yDings, xDings;
					if(down)
						yDings = (float) Math.abs(this.yCoord+0.9999F-train.posY);
					else
						yDings = (float) Math.abs(train.posY-this.yCoord);
					if((this.alignment == 7 && !this.down) || (this.alignment == 5 && this.down))
						xDings = (float) Math.abs(this.xCoord+0.9999F-train.posX);
					else
						xDings = (float) Math.abs(train.posX-this.xCoord);

					if(yDings*2 > xDings)
					{
						kole = yDings;
						if(this.down)
							train.posY = this.yCoord+0.999F-(float)(kole/2);
						else
							train.posY = this.yCoord+(float)(kole/2);
					}
					else
					{
						kole = xDings;
						if((this.alignment == 6 && !this.down) || (this.alignment == 4 && this.down))
							train.posX = this.xCoord+0.999F-kole/2;
						else
							train.posX = this.xCoord+kole/2;
					}*/
				return true;
			}
		return false;
		}
		
		@Override
		public int[] getVek(int[] vek, EntityTrain train) {
			if(this.alignment == 0)
			{
				if(!this.down)
				{
					int[] tmp = {0,1,2};
					return tmp;
				}
				else
				{
					int[] tmp = {0,-1,-2};
					return tmp;
				}
			}else if(this.alignment == 1)
			{
				if(!this.down)
				{
					int[] tmp = {2,1,0};
					return tmp;
				}
				else
				{
					int[] tmp = {-2,-1,0};
					return tmp;
				}
			}else if(this.alignment == 2)
			{
				if(!this.down)
				{
					int[] tmp = {0,1,-2};
					return tmp;
				}
				else
				{
					int[] tmp = {0,-1,2};
					return tmp;
				}
			}else if(this.alignment == 3)
			{
				if(!this.down)
				{
					int[] tmp = {-2,1,0};
					return tmp;
				}
				else
				{
					int[] tmp = {2,-1,0};
					return tmp;
				}
			}else if(this.alignment == 4)
			{
				if(!this.down)
				{
					int[] tmp = {0,2,1};
					return tmp;
				}
				else
				{
					int[] tmp = {0,-2,-1};
					return tmp;
				}
			}else if(this.alignment == 5)
			{
				if(!this.down)
				{
					int[] tmp = {1,2,0};
					return tmp;
				}
				else
				{
					int[] tmp = {-1,-2,0};
					return tmp;
				}
			}else if(this.alignment == 6)
			{
				if(!this.down)
				{
					int[] tmp = {0,2,-1};
					return tmp;
				}
				else
				{
					int[] tmp = {0,-2,1};
					return tmp;
				}
			}else if(this.alignment == 7)
			{
				if(!this.down)
				{
					int[] tmp = {-1,2,0};
					return tmp;
				}
				else
				{
					int[] tmp = {1,-2,0};
					return tmp;
				}
			}
			int[] tmp = {0,0,0};
			return tmp;
		}
		
		public float getPlayerXOff()
		{
			if(this.alignment == 1)
				return -0.3F;
			else if(this.alignment == 3)
				return 0.3F;
			else if(this.alignment == 5)
				return -1.4F;
			else if(this.alignment == 7)
				return 1.4F;
			else return 0;
		}
		
		public float getPlayerYOff()
		{
			if(this.alignment > 3)
				return -0.7F;
			else
				return 0F;
		}		
		
		public float getPlayerZOff()
		{
			if(this.alignment == 0)
				return -0.3F;
			else if(this.alignment == 2)
				return 0.3F;
			else if(this.alignment == 4)
				return -1.4F;
			else if(this.alignment == 6)
				return 1.4F;
			else return 0;
		}
		
		public float getHalfwayX()
		{
			if(this.alignment <= 3 || this.alignment == 4 || this.alignment == 6)
				return this.xCoord+0.5F;
			else 
				return this.xCoord+0.25F;
		}
		
		public float getHalfwayY()
		{
			if(this.alignment <= 3)
				return this.yCoord+0.25F;
			else
				return this.yCoord+0.5F;
		}
		
		public float getHalfwayZ()
		{
			if(this.alignment <= 3 || this.alignment == 5 || this.alignment == 7)
				return this.zCoord+0.5F;
			else if(this.alignment == 4)
				return this.zCoord+0.25F;
			else
				return this.zCoord+0.75F;
		}
		
		public boolean HasHalfway()
		{
			return true;
		}
		
		public float getDisTillOut(EntityTrain train)
		{
			if(this.alignment == 0 && !down)
				return (float) (Math.sqrt(Math.pow(this.yCoord+0.5F-train.posY, 2)+Math.pow(this.zCoord+1-train.posZ, 2)));
			if(this.alignment == 1 && !down)
				return (float) (Math.sqrt(Math.pow(this.yCoord+0.5F-train.posY, 2)+Math.pow(this.xCoord+1-train.posX, 2)));
			if(this.alignment == 2 && !down)
				return (float) (Math.sqrt(Math.pow(this.yCoord+0.5F-train.posY, 2)+Math.pow(train.posZ-this.zCoord, 2)));
			if(this.alignment == 3 && !down)
				return (float) (Math.sqrt(Math.pow(this.yCoord+0.5F-train.posY, 2)+Math.pow(train.posX-this.xCoord, 2)));
			if(this.alignment == 2 && down)
				return (float) (Math.sqrt(Math.pow(train.posY-this.yCoord, 2)+Math.pow(this.zCoord+1-train.posZ, 2)));
			if(this.alignment == 3 && down)
				return (float) (Math.sqrt(Math.pow(train.posY-this.yCoord, 2)+Math.pow(this.xCoord+1-train.posX, 2)));
			if(this.alignment == 0 && down)
				return (float) (Math.sqrt(Math.pow(train.posY-this.yCoord, 2)+Math.pow(train.posZ-this.zCoord, 2)));
			if(this.alignment == 1 && down)
				return (float) (Math.sqrt(Math.pow(train.posY-this.yCoord, 2)+Math.pow(train.posX-this.xCoord, 2)));
			
			if(this.alignment == 4 && !down)
				return (float) (Math.sqrt(Math.pow(this.yCoord+1-train.posY, 2)+Math.pow(this.zCoord+0.5F-train.posZ, 2)));
			if(this.alignment == 5 && !down)
				return (float) (Math.sqrt(Math.pow(this.yCoord+1-train.posY, 2)+Math.pow(this.xCoord+0.5F-train.posX, 2)));
			if(this.alignment == 6 && !down)
				return (float) (Math.sqrt(Math.pow(this.yCoord+1-train.posY, 2)+Math.pow(train.posZ-this.zCoord, 2)));
			if(this.alignment == 7 && !down)
				return (float) (Math.sqrt(Math.pow(this.yCoord+1-train.posY, 2)+Math.pow(train.posX-this.xCoord, 2)));
			if(this.alignment == 6 && down)
				return (float) (Math.sqrt(Math.pow(train.posY-this.yCoord, 2)+Math.pow(this.zCoord+1F-train.posZ, 2)));
			if(this.alignment == 7 && down)
				return (float) (Math.sqrt(Math.pow(train.posY-this.yCoord, 2)+Math.pow(this.xCoord+1F-train.posX, 2)));
			if(this.alignment == 4 && down)
				return (float) (Math.sqrt(Math.pow(train.posY-this.yCoord, 2)+Math.pow(train.posZ-this.zCoord, 2)));
			if(this.alignment == 5 && down)
				return (float) (Math.sqrt(Math.pow(train.posY-this.yCoord, 2)+Math.pow(train.posX-this.xCoord, 2)));
			else
				return 0;
		}
		
		public float getDisTillOutFromHalf()
		{
			return (float) Math.sqrt(0.3125F);
		}
		
		public float getDisTillHalf(EntityTrain train)
		{
			if(this.alignment == 0 || this.alignment == 2)
				if(down)
					return (float) (Math.sqrt(Math.pow(train.posZ-this.getHalfwayZ(), 2)+Math.pow(train.posY-this.getHalfwayY(), 2)));
				else
					return (float) (Math.sqrt(Math.pow(train.posZ-this.getHalfwayZ(), 2)+Math.pow(this.getHalfwayY()-train.posY, 2)));
			if(this.alignment == 1 || this.alignment == 3)
				if(down)
					return (float) (Math.sqrt(Math.pow(train.posX-this.getHalfwayX(), 2)+Math.pow(train.posY-this.getHalfwayY(), 2)));
				else
					return (float) (Math.sqrt(Math.pow(train.posX-this.getHalfwayX(), 2)+Math.pow(this.getHalfwayY()-train.posY, 2)));
			if(this.alignment == 4 || this.alignment == 6)
				if(down)
					return (float) (Math.sqrt(Math.pow(train.posZ-this.getHalfwayZ(), 2)+Math.pow(train.posY-this.getHalfwayY(), 2)));
				else
					return (float) (Math.sqrt(Math.pow(this.getHalfwayZ()-train.posZ, 2)+Math.pow(this.getHalfwayY()-train.posY, 2)));
			if(this.alignment == 5 || this.alignment == 7)
				if(down)
					return (float) (Math.sqrt(Math.pow(train.posX-this.getHalfwayX(), 2)+Math.pow(train.posY-this.getHalfwayY(), 2)));
				else
					return (float) (Math.sqrt(Math.pow(this.getHalfwayX()-train.posX, 2)+Math.pow(this.getHalfwayY()-train.posY, 2)));
			else
				return 0;
		}
		
		public float getDisTillHalfPrev(EntityTrain train)
		{
			if(this.alignment == 0 || this.alignment == 2)
				if(down)
					return (float) (Math.sqrt(Math.pow(train.prevPosZ-this.getHalfwayZ(), 2)+Math.pow(train.prevPosY-this.getHalfwayY(), 2)));
				else
					return (float) (Math.sqrt(Math.pow(train.prevPosZ-this.getHalfwayZ(), 2)+Math.pow(this.getHalfwayY()-train.prevPosY, 2)));
			if(this.alignment == 1 || this.alignment == 3)
				if(down)
					return (float) (Math.sqrt(Math.pow(train.prevPosX-this.getHalfwayX(), 2)+Math.pow(train.prevPosY-this.getHalfwayY(), 2)));
				else
					return (float) (Math.sqrt(Math.pow(train.prevPosX-this.getHalfwayX(), 2)+Math.pow(this.getHalfwayY()-train.prevPosY, 2)));		
			if(this.alignment == 4 || this.alignment == 6)
				if(down)
					return (float) (Math.sqrt(Math.pow(train.prevPosZ-this.getHalfwayZ(), 2)+Math.pow(train.prevPosY-this.getHalfwayY(), 2)));
				else
					return (float) (Math.sqrt(Math.pow(this.getHalfwayZ()-train.prevPosZ, 2)+Math.pow(this.getHalfwayY()-train.prevPosY, 2)));
			if(this.alignment == 5 || this.alignment == 7)
				if(down)
					return (float) (Math.sqrt(Math.pow(train.prevPosX-this.getHalfwayX(), 2)+Math.pow(train.prevPosY-this.getHalfwayY(), 2)));
				else
					return (float) (Math.sqrt(Math.pow(this.getHalfwayX()-train.prevPosX, 2)+Math.pow(this.getHalfwayY()-train.prevPosY, 2)));
			else
				return 0;
		}
		
		public float getxzForDown()
		{
			if(this.alignment <= 3)
				return 0.7F;
			else
				return 1.75F;
		}
		public float getyForDown()
		{
			if(this.alignment <= 3)
				return 1.7F;
			else
				return 0.8F;
		}
		public float getxzForUp()
		{
			if(this.alignment <= 3)
				return 0.63F;
			else
				return 1.65F;
		}
		public float getyForUp()
		{
			if(this.alignment <= 3)
				return 1.8F;
			else
				return 0.9F;
		}
		public float getTFT()
		{
			if(this.alignment <= 3)
				return 27;
			else
				return 64.5F;
		}
		
		@Override
		public float getSpeedMultiplier(EntityTrain train) {
			if(!this.power)
			{
				if(this.alignment <= 3)
				{
					if(!this.down)
						return 0.985F;
					else
						return 1.015F;
				}else
				{
					if(!this.down)
						return 0.97F;
					else
						return 1.03F;
				}
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
					if(this.alignment <= 3)
					{
						if(!this.down)
							return 0.985F;
						else
							return 1.015F;
					}else
					{
						if(!this.down)
							return 0.97F;
						else
							return 1.03F;
					}
				}
			}
		}
	
}
