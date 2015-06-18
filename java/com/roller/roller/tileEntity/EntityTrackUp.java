package com.roller.roller.tileEntity;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.util.ChatComponentText;

import com.roller.roller.models.tmp;


public class EntityTrackUp extends Base{

	int k, speedAim = 6, maxSpeedAim = 10, minSpeedAim = 2;
	public float xForDown = 1.9F, yForDown = 0, zForDown = 1.9F, xForUp = 1.9F, yForUp = 0.1F, zForUp = 1.9F, turnForTrans = 90;
	float speedM = 1.1F;
	public tmp base2;

    public EntityTrackUp()
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
	    	//	if(this.alignment == 0)
	    	//	{
    			if(!this.down)
    			{
	    			if(this.worldObj.getTileEntity(this.xCoord, this.yCoord+1, this.zCoord) != null && this.worldObj.getTileEntity(this.xCoord, this.yCoord+1, this.zCoord) instanceof EntityTrackUp)
	    			{
	    				tmp = (EntityTrackUp) this.worldObj.getTileEntity(this.xCoord, this.yCoord+1, this.zCoord);
	    				if(tmp.alignment == this.alignment)
	    				{
	    					((EntityTrackUp)tmp).down = false;
	    					this.makeNext(tmp);
	    				}
	    			}
	    			if(this.worldObj.getTileEntity(this.xCoord, this.yCoord+1, this.zCoord) != null && this.worldObj.getTileEntity(this.xCoord, this.yCoord+1, this.zCoord) instanceof EntityTrackHorTop)
	    			{
	    				tmp = (EntityTrackHorTop) this.worldObj.getTileEntity(this.xCoord, this.yCoord+1, this.zCoord);
	    				if(tmp.alignment == this.alignment)
	    				{
	    					((EntityTrackHorTop)tmp).down = false;
	    					this.makeNext(tmp);
	    				}
	    			}
	    			if(this.worldObj.getTileEntity(this.xCoord, this.yCoord+1, this.zCoord) != null && this.worldObj.getTileEntity(this.xCoord, this.yCoord+1, this.zCoord) instanceof EntityTrack225Top)
	    			{
	    				tmp = (EntityTrack225Top) this.worldObj.getTileEntity(this.xCoord, this.yCoord+1, this.zCoord);
	    				if((tmp.alignment == 4 && this.alignment == 2) ||(tmp.alignment == 7 && this.alignment == 3) ||(tmp.alignment == 6 && this.alignment == 0) ||(tmp.alignment == 5 && this.alignment == 1))
	    				{
	    					((EntityTrack225Top)tmp).down = false;
	    					this.makeNext(tmp);
	    				}
	    			}
	    			if(this.alignment == 0)
	    			{
		    			if(this.worldObj.getTileEntity(this.xCoord, this.yCoord+1, this.zCoord-1) != null && this.worldObj.getTileEntity(this.xCoord, this.yCoord+1, this.zCoord-1) instanceof EntityTrack225)
		    			{
		    				tmp = (EntityTrack225) this.worldObj.getTileEntity(this.xCoord, this.yCoord+1, this.zCoord-1);
		    				if(tmp.alignment == 6)
		    				{
		    					((EntityTrack225)tmp).down = false;
		    					this.makeNext(tmp);
		    				}
		    			}else
	    				if(this.worldObj.getTileEntity(this.xCoord, this.yCoord+1, this.zCoord-1) != null && this.worldObj.getTileEntity(this.xCoord, this.yCoord+1, this.zCoord-1) instanceof EntityTrackHor)
		    			{
		    				tmp = (EntityTrackHor) this.worldObj.getTileEntity(this.xCoord, this.yCoord+1, this.zCoord-1);
		    				if(tmp.alignment == 2)
		    				{
		    					((EntityTrackHor)tmp).down = false;
		    					this.makeNext(tmp);
		    				}
		    			}
	    			}
	    			if(this.alignment ==1)
	    			{
	    				if(this.worldObj.getTileEntity(this.xCoord-1, this.yCoord+1, this.zCoord) != null && this.worldObj.getTileEntity(this.xCoord-1, this.yCoord+1, this.zCoord) instanceof EntityTrackHor)
		    			{
		    				tmp = (EntityTrackHor) this.worldObj.getTileEntity(this.xCoord-1, this.yCoord+1, this.zCoord);
		    				if(tmp.alignment == 3)
		    				{
		    					((EntityTrackHor)tmp).down = false;
		    					this.makeNext(tmp);
		    				}
		    			}else if(this.worldObj.getTileEntity(this.xCoord-1, this.yCoord+1, this.zCoord) != null && this.worldObj.getTileEntity(this.xCoord-1, this.yCoord+1, this.zCoord) instanceof EntityTrack225)
		    			{
		    				tmp = (EntityTrack225) this.worldObj.getTileEntity(this.xCoord-1, this.yCoord+1, this.zCoord);
		    				if(tmp.alignment == 7)
		    				{
		    					((EntityTrack225)tmp).down = false;
		    					this.makeNext(tmp);
		    				}
		    			}
	    			}
	    			if(this.alignment == 2)
	    			{
	    				if(this.worldObj.getTileEntity(this.xCoord, this.yCoord+1, this.zCoord+1) != null && this.worldObj.getTileEntity(this.xCoord, this.yCoord+1, this.zCoord+1) instanceof EntityTrackHor)
		    			{
		    				tmp = (EntityTrackHor) this.worldObj.getTileEntity(this.xCoord, this.yCoord+1, this.zCoord+1);
		    				if(tmp.alignment == 0)
		    				{
		    					((EntityTrackHor)tmp).down = false;
		    					this.makeNext(tmp);
		    				}
		    			}
	    				else if(this.worldObj.getTileEntity(this.xCoord, this.yCoord+1, this.zCoord+1) != null && this.worldObj.getTileEntity(this.xCoord, this.yCoord+1, this.zCoord+1) instanceof EntityTrack225)
		    			{
		    				tmp = (EntityTrack225) this.worldObj.getTileEntity(this.xCoord, this.yCoord+1, this.zCoord+1);
		    				if(tmp.alignment == 4)
		    				{
		    					((EntityTrack225)tmp).down = false;
		    					this.makeNext(tmp);
		    				}
		    			}
	    				
	    			}
	    			if(this.alignment ==3)
	    			{
	    				if(this.worldObj.getTileEntity(this.xCoord+1, this.yCoord+1, this.zCoord) != null && this.worldObj.getTileEntity(this.xCoord+1, this.yCoord+1, this.zCoord) instanceof EntityTrackHor)
		    			{
		    				tmp = (EntityTrackHor) this.worldObj.getTileEntity(this.xCoord+1, this.yCoord+1, this.zCoord);
		    				if(tmp.alignment == 1)
		    				{
		    					((EntityTrackHor)tmp).down = false;
		    					this.makeNext(tmp);
		    				}
		    			}else if(this.worldObj.getTileEntity(this.xCoord+1, this.yCoord+1, this.zCoord) != null && this.worldObj.getTileEntity(this.xCoord+1, this.yCoord+1, this.zCoord) instanceof EntityTrack225)
		    			{
		    				tmp = (EntityTrack225) this.worldObj.getTileEntity(this.xCoord+1, this.yCoord+1, this.zCoord);
		    				if(tmp.alignment == 5)
		    				{
		    					((EntityTrack225)tmp).down = false;
		    					this.makeNext(tmp);
		    				}
		    			}
	    			}
    			}else
    			{
    				if(this.worldObj.getTileEntity(this.xCoord, this.yCoord-1, this.zCoord) != null && this.worldObj.getTileEntity(this.xCoord, this.yCoord-1, this.zCoord) instanceof EntityTrackUp)
	    			{
	    				tmp = (EntityTrackUp) this.worldObj.getTileEntity(this.xCoord, this.yCoord-1, this.zCoord);
	    				if(tmp.alignment == this.alignment)
	    				{
	    					((EntityTrackUp)tmp).down = true;
	    					this.makeNext(tmp);
	    				}
	    			}
    				if(this.worldObj.getTileEntity(this.xCoord, this.yCoord-1, this.zCoord) != null && this.worldObj.getTileEntity(this.xCoord, this.yCoord-1, this.zCoord) instanceof EntityTrackHor)
	    			{
	    				tmp = (EntityTrackHor) this.worldObj.getTileEntity(this.xCoord, this.yCoord-1, this.zCoord);
	    				if((tmp.alignment == 0 && this.alignment == 2) ||(tmp.alignment == 1 && this.alignment == 3) ||(tmp.alignment == 2 && this.alignment == 0) ||(tmp.alignment == 3 && this.alignment == 1))
	    				{
	    					((EntityTrackHor)tmp).down = true;
	    					this.makeNext(tmp);
	    				}
	    			}
    				if(this.worldObj.getTileEntity(this.xCoord, this.yCoord-1, this.zCoord) != null && this.worldObj.getTileEntity(this.xCoord, this.yCoord-1, this.zCoord) instanceof EntityTrack225_2)
	    			{
	    				tmp = (EntityTrack225_2) this.worldObj.getTileEntity(this.xCoord, this.yCoord-1, this.zCoord);
	    				if((tmp.alignment == 4 && this.alignment == 2) ||(tmp.alignment == 5 && this.alignment == 3) ||(tmp.alignment == 6 && this.alignment == 0) ||(tmp.alignment == 7 && this.alignment == 1))
	    				{
	    					((EntityTrack225_2)tmp).down = true;
	    					this.makeNext(tmp);
	    				}
	    			}
    				if(this.alignment == 0)
    				{
    					if(this.worldObj.getTileEntity(this.xCoord, this.yCoord-1, this.zCoord-1) != null && this.worldObj.getTileEntity(this.xCoord, this.yCoord-1, this.zCoord-1) instanceof EntityTrackHorTop)
		    			{
		    				tmp = (EntityTrackHorTop) this.worldObj.getTileEntity(this.xCoord, this.yCoord-1, this.zCoord-1);
		    				if(tmp.alignment == this.alignment)
		    				{
		    					((EntityTrackHorTop)tmp).down = true;
		    					this.makeNext(tmp);
		    				}
		    			}else
		    				if(this.worldObj.getTileEntity(this.xCoord, this.yCoord-1, this.zCoord-1) != null && this.worldObj.getTileEntity(this.xCoord, this.yCoord-1, this.zCoord-1) instanceof EntityTrack225_2Top)
			    			{
			    				tmp = (EntityTrack225_2Top) this.worldObj.getTileEntity(this.xCoord, this.yCoord-1, this.zCoord-1);
			    				if(tmp.alignment == 6)
			    				{
			    					((EntityTrack225_2Top)tmp).down = true;
			    					this.makeNext(tmp);
			    				}
			    			}
    				}else if(this.alignment == 1)
    				{
    					if(this.worldObj.getTileEntity(this.xCoord-1, this.yCoord-1, this.zCoord) != null && this.worldObj.getTileEntity(this.xCoord-1, this.yCoord-1, this.zCoord) instanceof EntityTrackHorTop)
		    			{
		    				tmp = (EntityTrackHorTop) this.worldObj.getTileEntity(this.xCoord-1, this.yCoord-1, this.zCoord);
		    				if(tmp.alignment == this.alignment)
		    				{
		    					((EntityTrackHorTop)tmp).down = true;
		    					this.makeNext(tmp);
		    				}
		    			}else if(this.worldObj.getTileEntity(this.xCoord-1, this.yCoord-1, this.zCoord) != null && this.worldObj.getTileEntity(this.xCoord-1, this.yCoord-1, this.zCoord) instanceof EntityTrack225_2Top)
		    			{
		    				tmp = (EntityTrack225_2Top) this.worldObj.getTileEntity(this.xCoord-1, this.yCoord-1, this.zCoord);
		    				if(tmp.alignment == 5)
		    				{
		    					((EntityTrack225_2Top)tmp).down = true;
		    					this.makeNext(tmp);
		    				}
		    			}
    				}else if(this.alignment == 2)
    				{
    					if(this.worldObj.getTileEntity(this.xCoord, this.yCoord-1, this.zCoord+1) != null && this.worldObj.getTileEntity(this.xCoord, this.yCoord-1, this.zCoord+1) instanceof EntityTrackHorTop)
		    			{
		    				tmp = (EntityTrackHorTop) this.worldObj.getTileEntity(this.xCoord, this.yCoord-1, this.zCoord+1);
		    				if(tmp.alignment == this.alignment)
		    				{
		    					((EntityTrackHorTop)tmp).down = true;
		    					this.makeNext(tmp);
		    				}
		    			}else if(this.worldObj.getTileEntity(this.xCoord, this.yCoord-1, this.zCoord+1) != null && this.worldObj.getTileEntity(this.xCoord, this.yCoord-1, this.zCoord+1) instanceof EntityTrack225_2Top)
		    			{
		    				tmp = (EntityTrack225_2Top) this.worldObj.getTileEntity(this.xCoord, this.yCoord-1, this.zCoord+1);
		    				if(tmp.alignment == 4)
		    				{
		    					((EntityTrack225_2Top)tmp).down = true;
		    					this.makeNext(tmp);
		    				}
		    			}
    				}else if(this.alignment == 3)
    				{
    					if(this.worldObj.getTileEntity(this.xCoord+1, this.yCoord-1, this.zCoord) != null && this.worldObj.getTileEntity(this.xCoord+1, this.yCoord-1, this.zCoord) instanceof EntityTrackHorTop)
		    			{
		    				tmp = (EntityTrackHorTop) this.worldObj.getTileEntity(this.xCoord+1, this.yCoord-1, this.zCoord);
		    				if(tmp.alignment == this.alignment)
		    				{
		    					((EntityTrackHorTop)tmp).down = true;
		    					this.makeNext(tmp);
		    				}
		    			}else if(this.worldObj.getTileEntity(this.xCoord+1, this.yCoord-1, this.zCoord) != null && this.worldObj.getTileEntity(this.xCoord+1, this.yCoord-1, this.zCoord) instanceof EntityTrack225_2Top)
		    			{
		    				tmp = (EntityTrack225_2Top) this.worldObj.getTileEntity(this.xCoord+1, this.yCoord-1, this.zCoord);
		    				if(tmp.alignment == 7)
		    				{
		    					((EntityTrack225_2Top)tmp).down = true;
		    					this.makeNext(tmp);
		    				}
		    			}
    				}
    			}
	    			
	    		/**else if(this.worldObj.getTileEntity(this.xCoord, this.yCoord, this.zCoord+1) != null && this.worldObj.getTileEntity(this.xCoord, this.yCoord, this.zCoord+1) instanceof EntityTrackCurve)
	    			{
	    				tmp = (EntityTrackCurve) this.worldObj.getTileEntity(this.xCoord, this.yCoord, this.zCoord+1);
	    				if(tmp.alignment == 1 || tmp.alignment == 2)
	    				{
	    					this.makeNext(tmp);
	    				}
	    			}else if(this.worldObj.getTileEntity(this.xCoord, this.yCoord, this.zCoord+1) != null && this.worldObj.getTileEntity(this.xCoord, this.yCoord, this.zCoord+1) instanceof EntityTrackHor)
	    			{
	    				tmp = (EntityTrackHor) this.worldObj.getTileEntity(this.xCoord, this.yCoord, this.zCoord+1);
	    				if(tmp.alignment == this.alignment)
	    				{
	    					this.makeNext(tmp);
	    				}
	    			}else if(this.worldObj.getTileEntity(this.xCoord, this.yCoord-1, this.zCoord+1) != null && this.worldObj.getTileEntity(this.xCoord, this.yCoord-1, this.zCoord+1) instanceof EntityTrackHor)
	    			{
	    				tmp = (EntityTrackHor) this.worldObj.getTileEntity(this.xCoord, this.yCoord-1, this.zCoord+1);
	    				System.out.println(tmp.alignment);
	    				if(tmp.alignment == 2)
	    				{
	    					((EntityTrackHor)tmp).down = true;
	    					this.makeNext(tmp);
	    				}
	    			}
	    		}
	    		if(this.alignment == 1)
	    		{
	    			if(this.worldObj.getTileEntity(this.xCoord+1, this.yCoord, this.zCoord) != null && this.worldObj.getTileEntity(this.xCoord+1, this.yCoord, this.zCoord) instanceof EntityTrackUp)
	    			{
	    				tmp = (EntityTrackUp) this.worldObj.getTileEntity(this.xCoord+1, this.yCoord, this.zCoord);
	    				if((tmp.alignment % 2) != 0)
	    				{
	    					this.makeNext(tmp);
	    				}
	    			}else if(this.worldObj.getTileEntity(this.xCoord+1, this.yCoord, this.zCoord) != null && this.worldObj.getTileEntity(this.xCoord+1, this.yCoord, this.zCoord) instanceof EntityTrackCurve)
	    			{
	    				tmp = (EntityTrackCurve) this.worldObj.getTileEntity(this.xCoord+1, this.yCoord, this.zCoord);
	    				if(tmp.alignment == 0 || tmp.alignment == 1)
	    				{
	    					this.makeNext(tmp);
	    				}
	    			}else if(this.worldObj.getTileEntity(this.xCoord+1, this.yCoord, this.zCoord) != null && this.worldObj.getTileEntity(this.xCoord+1, this.yCoord, this.zCoord) instanceof EntityTrackHor)
	    			{
	    				tmp = (EntityTrackHor) this.worldObj.getTileEntity(this.xCoord+1, this.yCoord, this.zCoord);
	    				if(tmp.alignment == this.alignment)
	    				{
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
	    			}
	    		}
	    		if(this.alignment == 2)
	    		{
	    			if(this.worldObj.getTileEntity(this.xCoord, this.yCoord, this.zCoord-1) != null && this.worldObj.getTileEntity(this.xCoord, this.yCoord, this.zCoord-1) instanceof EntityTrackUp)
	    			{
	    				tmp = (EntityTrackUp) this.worldObj.getTileEntity(this.xCoord, this.yCoord, this.zCoord-1);
	    				if((tmp.alignment % 2) == 0)
	    				{
	    					this.makeNext(tmp);

	    				}
	    			}else if(this.worldObj.getTileEntity(this.xCoord, this.yCoord, this.zCoord-1) != null && this.worldObj.getTileEntity(this.xCoord, this.yCoord, this.zCoord-1) instanceof EntityTrackCurve)
	    			{
	    				tmp = (EntityTrackCurve) this.worldObj.getTileEntity(this.xCoord, this.yCoord, this.zCoord-1);
	    				if(tmp.alignment  == 0 || tmp.alignment == 3)
	    				{
	    					this.makeNext(tmp);

	    				}
	    			}else if(this.worldObj.getTileEntity(this.xCoord, this.yCoord, this.zCoord-1) != null && this.worldObj.getTileEntity(this.xCoord, this.yCoord, this.zCoord-1) instanceof EntityTrackHor)
	    			{
	    				tmp = (EntityTrackHor) this.worldObj.getTileEntity(this.xCoord, this.yCoord, this.zCoord-1);
	    				if(tmp.alignment == this.alignment)
	    				{
	    					this.makeNext(tmp);
	    				}
	    			}else if(this.worldObj.getTileEntity(this.xCoord, this.yCoord-1, this.zCoord-1) != null && this.worldObj.getTileEntity(this.xCoord, this.yCoord-1, this.zCoord-1) instanceof EntityTrackHor)
	    			{
	    				tmp = (EntityTrackHor) this.worldObj.getTileEntity(this.xCoord, this.yCoord-1, this.zCoord-1);
	    				if(tmp.alignment == 0)
	    				{
	    					((EntityTrackHor)tmp).down = true;
	    					this.makeNext(tmp);
	    				}
	    			}
	    		}
	    		if(this.alignment == 3)
	    		{
	    			if(this.worldObj.getTileEntity(this.xCoord-1, this.yCoord, this.zCoord) != null && this.worldObj.getTileEntity(this.xCoord-1, this.yCoord, this.zCoord) instanceof EntityTrackUp)
	    			{
	    				tmp = (EntityTrackUp) this.worldObj.getTileEntity(this.xCoord-1, this.yCoord, this.zCoord);
	    				if((tmp.alignment % 2) != 0)
		    			{
	    					this.makeNext(tmp);
		    			}
	    			}else if(this.worldObj.getTileEntity(this.xCoord-1, this.yCoord, this.zCoord) != null && this.worldObj.getTileEntity(this.xCoord-1, this.yCoord, this.zCoord) instanceof EntityTrackCurve)
	    			{
	    				tmp = (EntityTrackCurve) this.worldObj.getTileEntity(this.xCoord-1, this.yCoord, this.zCoord);
	    				if(tmp.alignment == 2 || tmp.alignment == 3)
		    			{
	    					this.makeNext(tmp);
		    			}
	    			}else if(this.worldObj.getTileEntity(this.xCoord-1, this.yCoord, this.zCoord) != null && this.worldObj.getTileEntity(this.xCoord-1, this.yCoord, this.zCoord) instanceof EntityTrackHor)
	    			{
	    				tmp = (EntityTrackHor) this.worldObj.getTileEntity(this.xCoord-1, this.yCoord, this.zCoord);
	    				if(tmp.alignment == this.alignment)
	    				{
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
	    			}
	    		}*/
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
        	System.out.println("cockfuck bei up");

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
		if(this.power)
			this.power = false;
		else
			this.power = true;
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
		
		public float getPlayerXOff()
		{
    		if(alignment == 1)
    			return 1.4F;
    		else if(alignment == 3)
    			return -1.4F;
    		else return 0;
		}
		
		public float getPlayerYOff()
		{
    		if(!down)
    			return -1.3F;
    		else
    			return -1.2F;
		}	
		
		public float getPlayerZOff()
		{
    		if(alignment == 0)
    			return 1.4F;
    		else if(alignment == 2)
    			return -1.4F;
    		else
    			return 0;
		}
		
		public float getHalfwayX()
		{
			if(this.alignment == 3)
				return this.xCoord+0.999F;
			else if(this.alignment == 1)
				return this.xCoord;
			else
				return this.xCoord+0.5F;
		}
		
		public float getHalfwayY()
		{
			return this.yCoord+0.5F;
		}
		
		public float getHalfwayZ()
		{
			if(this.alignment == 0)
				return this.zCoord+0.999F;
			else if(this.alignment == 2)
				return this.zCoord;
			else
				return this.zCoord+0.5F;
		}
		
		public boolean HasHalfway()
		{
			return true;
		}
		
		public float getDisTillOut(EntityTrain train)
		{
			if(this.alignment == 0 && !down)
				return (float) (Math.sqrt(Math.pow(this.yCoord+1-train.posY, 2)));
			if(this.alignment == 1 && !down)
				return (float) (Math.sqrt(Math.pow(this.yCoord+1-train.posY, 2)));
			if(this.alignment == 2 && !down)
				return (float) (Math.sqrt(Math.pow(this.yCoord+1-train.posY, 2)));
			if(this.alignment == 3 && !down)
				return (float) (Math.sqrt(Math.pow(this.yCoord+1-train.posY, 2)));
			if(this.alignment == 2 && down)
				return (float) (Math.sqrt(Math.pow(train.posY-this.yCoord, 2)));
			if(this.alignment == 3 && down)
				return (float) (Math.sqrt(Math.pow(train.posY-this.yCoord, 2)));
			if(this.alignment == 0 && down)
				return (float) (Math.sqrt(Math.pow(train.posY-this.yCoord, 2)));
			if(this.alignment == 1 && down)
				return (float) (Math.sqrt(Math.pow(train.posY-this.yCoord, 2)));
			else
				return 0;
		}
		
		public float getDisTillOutFromHalf()
		{
			return 0.5F;
		}
		
		public float getDisTillHalf(EntityTrain train)
		{
			return (float) (Math.sqrt(Math.pow(train.posY-this.getHalfwayY(), 2)));
		}
		
		public float getDisTillHalfPrev(EntityTrain train)
		{
			return (float) (Math.sqrt(Math.pow(train.prevPosY-this.getHalfwayY(), 2)));
		}
	@Override
	public boolean acceptsTrain(EntityTrain train) {
		
		if(this.alignment == 0 || this.alignment == 2)			
		{
			train.posX = this.xCoord+0.5F;
			if(this.alignment == 2)
				train.posZ = this.zCoord+0.999F;
			else
				train.posZ = this.zCoord;

			return true;			
		}else if(this.alignment == 1 || this.alignment == 3)			
		{
			train.posZ = this.zCoord+0.5F;
			if(this.alignment == 3)
				train.posX = this.xCoord+0.999F;
			else
				train.posX = this.xCoord;
			return true;
		}
		return false;
		/**
		if(this.alignment == 0 || this.alignment == 2)			
		{
			System.out.println(Math.abs(train.prevPosX) +" "+Math.abs(train.posX) );
			float x1 = (float) Math.abs(Math.abs(train.prevPosX)-Math.abs(this.xCoord));
			float x2 = (float) Math.abs(Math.abs(train.posX)-Math.abs(this.xCoord));
			if(((x2>=x1 && x1 <= 0.5F && x2 >= 0.5F) || (x2<=x1 && x1 >= 0.5F && x2 <= 0.5F)))
			{
				train.posX = this.xCoord+0.5F;
				train.posY = this.yCoord;
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
				train.posY = this.yCoord;
				return true;
			}
		}
		return false;*/
	}

	public int[] getVek(int[] vek, EntityTrain train) {
		
		if(this.alignment == 0 && train.posZ < this.zCoord+1)
		{
			if(train.posZ+train.speedMultiplier > this.zCoord+1)
			{
				int[] tmp = {0,1,1};
				return tmp;
			}else
				train.posZ = this.zCoord+0.00001F;
		}else if(this.alignment == 1 && train.posX < this.xCoord+1)
		{
			if(train.posX+train.speedMultiplier > this.xCoord+1)
			{
				int[] tmp = {1,1,0};
				return tmp;
			}else
				train.posX = this.xCoord+0.0001F;
		}else if(this.alignment == 2 && train.posZ > this.zCoord)
		{
			if(train.posZ-train.speedMultiplier < this.zCoord)
			{
				int[] tmp = {0,1,-1};
				return tmp;
			}else
				train.posZ = this.zCoord+0.9999F;
		}else if(this.alignment == 3 && train.posX < this.xCoord)
		{
			if(train.posX-train.speedMultiplier < this.xCoord)
			{
				int[] tmp = {-1,1,0};
				return tmp;
			}else
				train.posX = this.xCoord+0.9999F;
		}
		if(!this.down)
		{
			int[] tmp = {0,1,0};
			return tmp;
		}else
		{
			int[] tmp = {0,-1,0};
			return tmp;
		}
	}
	
	@Override
	public float getSpeedMultiplier(EntityTrain train) {
		if(!this.power)
		{
			if(!this.down)
				return (float) (0.955F);
			else
				return (float) (1.045F);		
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
					return (float) (0.955F);
				else
					return (float) (1.045F);
			}
		}
	}
	
}
