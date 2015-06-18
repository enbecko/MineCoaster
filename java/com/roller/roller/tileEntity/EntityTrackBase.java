package com.roller.roller.tileEntity;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.util.ChatComponentText;

import com.roller.roller.EntityRenderer2;
import com.roller.roller.models.tmp;


public class EntityTrackBase extends Base{

	public int speedAim = 50, maxSpeedAim = 190, minSpeedAim = 0;
	float speedM = 1.1F, speedM2, maxSpeedM = 1.9F, minSpeedM = 1.01F;
	public float xForDown = 0, yForDown = 1.9F, zForDown = 0, xForUp = 0, yForUp = 1.9F, zForUp = 0, turnForTrans = 0;
	public boolean powered, finished;
	EntityTrain tra;
	int k;
	public tmp base2;
	

    public EntityTrackBase()
    {

    }
    
    public void updateEntity()
    {
    	super.updateEntity();

    	speedM = 1.1F;
    	speedM2 = 2-speedM;
    	if(this.start)
    		this.powered = this.worldObj.isBlockIndirectlyGettingPowered(this.xCoord, this.yCoord, this.zCoord);
		if(this.tra != null)
		{
			if(tra.isDead)
				this.tra = null;
			else if(this.alignment == 2 && tra.posZ > this.zCoord+1)
				this.tra = null;
			else if(this.alignment == 3 && tra.posX > this.xCoord+1)
				this.tra = null;
			else if(this.alignment == 0 && tra.posZ < this.zCoord)
				this.tra = null;
			else if(this.alignment == 1 && tra.posX < this.xCoord)
				this.tra = null;
		}else
    		this.finished = false;
    	{
    		Base tmp;
    		if(this.first)
    		{
    			this.next = null;
	    		if(this.alignment == 0)
	    		{
	    			if(this.worldObj.getTileEntity(this.xCoord, this.yCoord, this.zCoord+1) != null && this.worldObj.getTileEntity(this.xCoord, this.yCoord, this.zCoord+1) instanceof EntityTrackBase)
	    			{
	    				tmp = (EntityTrackBase) this.worldObj.getTileEntity(this.xCoord, this.yCoord, this.zCoord+1);
	    				if((tmp.alignment % 2) == 0)
	    				{
	    					this.makeNext(tmp);
	    				}
	    			}else if(this.worldObj.getTileEntity(this.xCoord, this.yCoord, this.zCoord+1) != null && this.worldObj.getTileEntity(this.xCoord, this.yCoord, this.zCoord+1) instanceof EntityTrackBaseWater)
	    			{
	    				tmp = (EntityTrackBaseWater) this.worldObj.getTileEntity(this.xCoord, this.yCoord, this.zCoord+1);
	    				if((tmp.alignment % 2) == 0)
	    				{
	    					this.makeNext(tmp);
	    				}
	    			}else if(this.worldObj.getTileEntity(this.xCoord, this.yCoord, this.zCoord+1) != null && this.worldObj.getTileEntity(this.xCoord, this.yCoord, this.zCoord+1) instanceof EntityTrackTurn)
	    			{
	    				tmp = (EntityTrackTurn) this.worldObj.getTileEntity(this.xCoord, this.yCoord, this.zCoord+1);
	    				if((tmp.alignment % 2) == 0)
	    				{
	    					this.makeNext(tmp);
	    				}
	    			}else if(this.worldObj.getTileEntity(this.xCoord, this.yCoord, this.zCoord+1) != null && this.worldObj.getTileEntity(this.xCoord, this.yCoord, this.zCoord+1) instanceof EntityTrackCurve)
	    			{
	    				tmp = (EntityTrackCurve) this.worldObj.getTileEntity(this.xCoord, this.yCoord, this.zCoord+1);
	    				if(tmp.alignment == 1 || tmp.alignment == 2)
	    				{
	    					this.makeNext(tmp);
	    				}
	    			}
	    			else if(this.worldObj.getTileEntity(this.xCoord, this.yCoord, this.zCoord+1) != null && this.worldObj.getTileEntity(this.xCoord, this.yCoord, this.zCoord+1) instanceof EntityTrackTransition)
	    			{
	    				tmp = (EntityTrackTransition) this.worldObj.getTileEntity(this.xCoord, this.yCoord, this.zCoord+1);
	    				if(tmp.alignment == 0 || tmp.alignment == 4)
	    				{
	    					if(tmp != this.prev)
	    						tmp.down = false;
	    					this.makeNext(tmp);
	    				}
	    			}else if(this.worldObj.getTileEntity(this.xCoord, this.yCoord, this.zCoord+1) != null && this.worldObj.getTileEntity(this.xCoord, this.yCoord, this.zCoord+1) instanceof EntityTrack225)
	    			{
	    				tmp = (EntityTrack225) this.worldObj.getTileEntity(this.xCoord, this.yCoord, this.zCoord+1);
	    				if(tmp.alignment == 0)
	    				{
	    					if(tmp != this.prev)
	    						tmp.down = false;
	    					this.makeNext(tmp);
	    				}
	    			}
	    			else if(this.worldObj.getTileEntity(this.xCoord, this.yCoord-1, this.zCoord+1) != null && this.worldObj.getTileEntity(this.xCoord, this.yCoord-1, this.zCoord+1) instanceof EntityTrack225_2)
	    			{
	    				tmp = (EntityTrack225_2) this.worldObj.getTileEntity(this.xCoord, this.yCoord-1, this.zCoord+1);
	    				if(tmp.alignment == 2)
	    				{
	    					if(tmp != this.prev)
	    						tmp.down = true;
	    					this.makeNext(tmp);
	    				}
	    			}
	    			else if(this.worldObj.getTileEntity(this.xCoord, this.yCoord, this.zCoord+1) != null && this.worldObj.getTileEntity(this.xCoord, this.yCoord, this.zCoord+1) instanceof EntityTrackQuer)
	    			{
	    				tmp = (EntityTrackQuer) this.worldObj.getTileEntity(this.xCoord, this.yCoord, this.zCoord+1);
	    				if(tmp.alignment == 1 || tmp.alignment == 2)
	    				{
	    					this.makeNext(tmp);
	    				}
	    			}else if(this.worldObj.getTileEntity(this.xCoord, this.yCoord, this.zCoord+1) != null && this.worldObj.getTileEntity(this.xCoord, this.yCoord, this.zCoord+1) instanceof EntityTrackHor)
	    			{
	    				tmp = (EntityTrackHor) this.worldObj.getTileEntity(this.xCoord, this.yCoord, this.zCoord+1);
	    				if(tmp.alignment == this.alignment)
	    				{
	    					if(tmp != this.prev)
	    						((EntityTrackHor)tmp).down = false;
	    					this.makeNext(tmp);
	    				}
	    			}else if(this.worldObj.getTileEntity(this.xCoord, this.yCoord-1, this.zCoord+1) != null && this.worldObj.getTileEntity(this.xCoord, this.yCoord-1, this.zCoord+1) instanceof EntityTrackHor)
	    			{
	    				tmp = (EntityTrackHor) this.worldObj.getTileEntity(this.xCoord, this.yCoord-1, this.zCoord+1);
	    				System.out.println(tmp.alignment);
	    				if(tmp.alignment == 2)
	    				{
	    					if(tmp != this.prev)	
	    						((EntityTrackHor)tmp).down = true;
	    					this.makeNext(tmp);
	    				}
	    			}
	    		}
	    		if(this.alignment == 1)
	    		{
	    			if(this.worldObj.getTileEntity(this.xCoord+1, this.yCoord, this.zCoord) != null && this.worldObj.getTileEntity(this.xCoord+1, this.yCoord, this.zCoord) instanceof EntityTrackBase)
	    			{
	    				tmp = (EntityTrackBase) this.worldObj.getTileEntity(this.xCoord+1, this.yCoord, this.zCoord);
	    				if((tmp.alignment % 2) != 0)
	    				{
	    					this.makeNext(tmp);
	    				}
	    			}else if(this.worldObj.getTileEntity(this.xCoord+1, this.yCoord, this.zCoord) != null && this.worldObj.getTileEntity(this.xCoord+1, this.yCoord, this.zCoord) instanceof EntityTrackBaseWater)
	    			{
	    				tmp = (EntityTrackBaseWater) this.worldObj.getTileEntity(this.xCoord+1, this.yCoord, this.zCoord);
	    				if((tmp.alignment % 2) != 0)
	    				{
	    					this.makeNext(tmp);
	    				}
	    			}else if(this.worldObj.getTileEntity(this.xCoord+1, this.yCoord, this.zCoord) != null && this.worldObj.getTileEntity(this.xCoord+1, this.yCoord, this.zCoord) instanceof EntityTrackTurn)
	    			{
	    				tmp = (EntityTrackTurn) this.worldObj.getTileEntity(this.xCoord+1, this.yCoord, this.zCoord);
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
	    			}
	    			else if(this.worldObj.getTileEntity(this.xCoord+1, this.yCoord, this.zCoord) != null && this.worldObj.getTileEntity(this.xCoord+1, this.yCoord, this.zCoord) instanceof EntityTrackTransition)
	    			{
	    				tmp = (EntityTrackTransition) this.worldObj.getTileEntity(this.xCoord+1, this.yCoord, this.zCoord);
	    				if(tmp.alignment == 3 || tmp.alignment == 7)
	    				{
	    					if(tmp != this.prev)
	    						tmp.down = false;
	    					this.makeNext(tmp);
	    				}
	    			}else if(this.worldObj.getTileEntity(this.xCoord+1, this.yCoord, this.zCoord) != null && this.worldObj.getTileEntity(this.xCoord+1, this.yCoord, this.zCoord) instanceof EntityTrackQuer)
	    			{
	    				tmp = (EntityTrackQuer) this.worldObj.getTileEntity(this.xCoord+1, this.yCoord, this.zCoord);
	    				if(tmp.alignment == 0 || tmp.alignment == 1)
	    				{
	    					this.makeNext(tmp);
	    				}
	    			}else if(this.worldObj.getTileEntity(this.xCoord+1, this.yCoord, this.zCoord) != null && this.worldObj.getTileEntity(this.xCoord+1, this.yCoord, this.zCoord) instanceof EntityTrackHor)
	    			{
	    				tmp = (EntityTrackHor) this.worldObj.getTileEntity(this.xCoord+1, this.yCoord, this.zCoord);
	    				if(tmp.alignment == this.alignment)
	    				{
	    					if(tmp != this.prev)
	    						((EntityTrackHor)tmp).down = false;
	    					this.makeNext(tmp);
	    				}
	    			}else if(this.worldObj.getTileEntity(this.xCoord+1, this.yCoord, this.zCoord) != null && this.worldObj.getTileEntity(this.xCoord+1, this.yCoord, this.zCoord) instanceof EntityTrack225)
	    			{
	    				tmp = (EntityTrack225) this.worldObj.getTileEntity(this.xCoord+1, this.yCoord, this.zCoord);
	    				if(tmp.alignment == this.alignment)
	    				{
	    					if(tmp != this.prev)
	    						((EntityTrack225)tmp).down = false;
	    					this.makeNext(tmp);
	    				}
	    			}
	    			else if(this.worldObj.getTileEntity(this.xCoord+1, this.yCoord-1, this.zCoord) != null && this.worldObj.getTileEntity(this.xCoord+1, this.yCoord-1, this.zCoord) instanceof EntityTrack225_2)
	    			{
	    				tmp = (EntityTrack225_2) this.worldObj.getTileEntity(this.xCoord+1, this.yCoord-1, this.zCoord);
	    				if(tmp.alignment == 3)
	    				{
	    					if(tmp != this.prev)
	    						((EntityTrack225_2)tmp).down = true;
	    					this.makeNext(tmp);
	    				}
	    			}else if(this.worldObj.getTileEntity(this.xCoord+1, this.yCoord-1, this.zCoord) != null && this.worldObj.getTileEntity(this.xCoord+1, this.yCoord-1, this.zCoord) instanceof EntityTrackHor)
	    			{
	    				tmp = (EntityTrackHor) this.worldObj.getTileEntity(this.xCoord+1, this.yCoord-1, this.zCoord);
	    				if(tmp.alignment == 3)
	    				{
	    					if(tmp != this.prev)
	    						((EntityTrackHor)tmp).down = true;
	    					this.makeNext(tmp);
	    				}
	    			}
	    		}
	    		if(this.alignment == 2)
	    		{
	    			if(this.worldObj.getTileEntity(this.xCoord, this.yCoord, this.zCoord-1) != null && this.worldObj.getTileEntity(this.xCoord, this.yCoord, this.zCoord-1) instanceof EntityTrackBase)
	    			{
	    				tmp = (EntityTrackBase) this.worldObj.getTileEntity(this.xCoord, this.yCoord, this.zCoord-1);
	    				if((tmp.alignment % 2) == 0)
	    				{
	    					this.makeNext(tmp);

	    				}
	    			}else if(this.worldObj.getTileEntity(this.xCoord, this.yCoord, this.zCoord-1) != null && this.worldObj.getTileEntity(this.xCoord, this.yCoord, this.zCoord-1) instanceof EntityTrackBaseWater)
	    			{
	    				tmp = (EntityTrackBaseWater) this.worldObj.getTileEntity(this.xCoord, this.yCoord, this.zCoord-1);
	    				if((tmp.alignment % 2) == 0)
	    				{
	    					this.makeNext(tmp);

	    				}
	    			}else if(this.worldObj.getTileEntity(this.xCoord, this.yCoord, this.zCoord-1) != null && this.worldObj.getTileEntity(this.xCoord, this.yCoord, this.zCoord-1) instanceof EntityTrackTurn)
	    			{
	    				tmp = (EntityTrackTurn) this.worldObj.getTileEntity(this.xCoord, this.yCoord, this.zCoord-1);
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
	    			}
	    			else if(this.worldObj.getTileEntity(this.xCoord, this.yCoord, this.zCoord-1) != null && this.worldObj.getTileEntity(this.xCoord, this.yCoord, this.zCoord-1) instanceof EntityTrackTransition)
	    			{
	    				tmp = (EntityTrackTransition) this.worldObj.getTileEntity(this.xCoord, this.yCoord, this.zCoord-1);
	    				if(tmp.alignment  == 2 || tmp.alignment == 6)
	    				{
	    					if(tmp != this.prev)
	    						tmp.down = false;
	    					this.makeNext(tmp);

	    				}
	    			}else if(this.worldObj.getTileEntity(this.xCoord, this.yCoord, this.zCoord-1) != null && this.worldObj.getTileEntity(this.xCoord, this.yCoord, this.zCoord-1) instanceof EntityTrackQuer)
	    			{
	    				tmp = (EntityTrackQuer) this.worldObj.getTileEntity(this.xCoord, this.yCoord, this.zCoord-1);
	    				if(tmp.alignment  == 0 || tmp.alignment == 3)
	    				{
	    					this.makeNext(tmp);

	    				}
	    			}else if(this.worldObj.getTileEntity(this.xCoord, this.yCoord, this.zCoord-1) != null && this.worldObj.getTileEntity(this.xCoord, this.yCoord, this.zCoord-1) instanceof EntityTrackHor)
	    			{
	    				tmp = (EntityTrackHor) this.worldObj.getTileEntity(this.xCoord, this.yCoord, this.zCoord-1);
	    				if(tmp.alignment == this.alignment)
	    				{
	    					if(tmp != this.prev)
	    						((EntityTrackHor)tmp).down = false;
	    					this.makeNext(tmp);
	    				}
	    			}
	    			else if(this.worldObj.getTileEntity(this.xCoord, this.yCoord, this.zCoord-1) != null && this.worldObj.getTileEntity(this.xCoord, this.yCoord, this.zCoord-1) instanceof EntityTrack225)
	    			{
	    				tmp = (EntityTrack225) this.worldObj.getTileEntity(this.xCoord, this.yCoord, this.zCoord-1);
	    				if(tmp.alignment == this.alignment)
	    				{
	    					if(tmp != this.prev)
	    						((EntityTrack225)tmp).down = false;
	    					this.makeNext(tmp);
	    				}
	    			}else if(this.worldObj.getTileEntity(this.xCoord, this.yCoord-1, this.zCoord-1) != null && this.worldObj.getTileEntity(this.xCoord, this.yCoord-1, this.zCoord-1) instanceof EntityTrack225_2)
	    			{
	    				tmp = (EntityTrack225_2) this.worldObj.getTileEntity(this.xCoord, this.yCoord-1, this.zCoord-1);
	    				if(tmp.alignment == 0)
	    				{
	    					if(tmp != this.prev)
	    						((EntityTrack225_2)tmp).down = true;
	    					this.makeNext(tmp);
	    				}
	    			}else if(this.worldObj.getTileEntity(this.xCoord, this.yCoord-1, this.zCoord-1) != null && this.worldObj.getTileEntity(this.xCoord, this.yCoord-1, this.zCoord-1) instanceof EntityTrackHor)
	    			{
	    				tmp = (EntityTrackHor) this.worldObj.getTileEntity(this.xCoord, this.yCoord-1, this.zCoord-1);
	    				if(tmp.alignment == 0)
	    				{
	    					if(tmp != this.prev)
	    						((EntityTrackHor)tmp).down = true;
	    					this.makeNext(tmp);
	    				}
	    			}
	    		}
	    		if(this.alignment == 3)
	    		{
	    			if(this.worldObj.getTileEntity(this.xCoord-1, this.yCoord, this.zCoord) != null && this.worldObj.getTileEntity(this.xCoord-1, this.yCoord, this.zCoord) instanceof EntityTrackBase)
	    			{
	    				tmp = (EntityTrackBase) this.worldObj.getTileEntity(this.xCoord-1, this.yCoord, this.zCoord);
	    				if((tmp.alignment % 2) != 0)
		    			{
	    					this.makeNext(tmp);
		    			}
	    			}else if(this.worldObj.getTileEntity(this.xCoord-1, this.yCoord, this.zCoord) != null && this.worldObj.getTileEntity(this.xCoord-1, this.yCoord, this.zCoord) instanceof EntityTrackBaseWater)
	    			{
	    				tmp = (EntityTrackBaseWater) this.worldObj.getTileEntity(this.xCoord-1, this.yCoord, this.zCoord);
	    				if((tmp.alignment % 2) != 0)
		    			{
	    					this.makeNext(tmp);
		    			}
	    			}else if(this.worldObj.getTileEntity(this.xCoord-1, this.yCoord, this.zCoord) != null && this.worldObj.getTileEntity(this.xCoord-1, this.yCoord, this.zCoord) instanceof EntityTrackTurn)
	    			{
	    				tmp = (EntityTrackTurn) this.worldObj.getTileEntity(this.xCoord-1, this.yCoord, this.zCoord);
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
	    			}
	    			else if(this.worldObj.getTileEntity(this.xCoord-1, this.yCoord, this.zCoord) != null && this.worldObj.getTileEntity(this.xCoord-1, this.yCoord, this.zCoord) instanceof EntityTrackTransition)
	    			{
	    				tmp = (EntityTrackTransition) this.worldObj.getTileEntity(this.xCoord-1, this.yCoord, this.zCoord);
	    				if(tmp.alignment == 1 || tmp.alignment == 5)
		    			{
	    					if(tmp != this.prev)
	    						tmp.down = false;
	    					this.makeNext(tmp);
		    			}
	    			}else if(this.worldObj.getTileEntity(this.xCoord-1, this.yCoord, this.zCoord) != null && this.worldObj.getTileEntity(this.xCoord-1, this.yCoord, this.zCoord) instanceof EntityTrackQuer)
	    			{
	    				tmp = (EntityTrackQuer) this.worldObj.getTileEntity(this.xCoord-1, this.yCoord, this.zCoord);
	    				if(tmp.alignment == 2 || tmp.alignment == 3)
		    			{
	    					this.makeNext(tmp);
		    			}
	    			}else if(this.worldObj.getTileEntity(this.xCoord-1, this.yCoord, this.zCoord) != null && this.worldObj.getTileEntity(this.xCoord-1, this.yCoord, this.zCoord) instanceof EntityTrackHor)
	    			{
	    				tmp = (EntityTrackHor) this.worldObj.getTileEntity(this.xCoord-1, this.yCoord, this.zCoord);
	    				if(tmp.alignment == this.alignment)
	    				{
	    					if(tmp != this.prev)
	    						((EntityTrackHor)tmp).down = false;
	    					this.makeNext(tmp);
	    				}
	    			}else if(this.worldObj.getTileEntity(this.xCoord-1, this.yCoord, this.zCoord) != null && this.worldObj.getTileEntity(this.xCoord-1, this.yCoord, this.zCoord) instanceof EntityTrack225)
	    			{
	    				tmp = (EntityTrack225) this.worldObj.getTileEntity(this.xCoord-1, this.yCoord, this.zCoord);
	    				if(tmp.alignment == this.alignment)
	    				{
	    					if(tmp != this.prev)
	    						((EntityTrack225)tmp).down = false;
	    					this.makeNext(tmp);
	    				}
	    			}else if(this.worldObj.getTileEntity(this.xCoord-1, this.yCoord-1, this.zCoord) != null && this.worldObj.getTileEntity(this.xCoord-1, this.yCoord-1, this.zCoord) instanceof EntityTrack225_2)
	    			{
	    				tmp = (EntityTrack225_2) this.worldObj.getTileEntity(this.xCoord-1, this.yCoord-1, this.zCoord);
	    				if(tmp.alignment == 1)
	    				{
	    					if(tmp != this.prev)
	    						((EntityTrack225_2)tmp).down = true;
	    					this.makeNext(tmp);
	    				}
	    			}else if(this.worldObj.getTileEntity(this.xCoord-1, this.yCoord-1, this.zCoord) != null && this.worldObj.getTileEntity(this.xCoord-1, this.yCoord-1, this.zCoord) instanceof EntityTrackHor)
	    			{
	    				tmp = (EntityTrackHor) this.worldObj.getTileEntity(this.xCoord-1, this.yCoord-1, this.zCoord);
	    				if(tmp.alignment == 1)	
	    				{
	    					if(tmp != this.prev)
	    						((EntityTrackHor)tmp).down = true;
	    					this.makeNext(tmp);
	    				}
	    			}
	    		}
	    		if(this.next == null && k < 2)
	    		{
	    			if(this == this.firstBlock)
	    				this.makeNext(null);
	    			k++;
	    		}else if(this.next == null)
	    		{
	    			k = 0;
	    			this.failed = true;
	    			this.makeFirst(this.firstBlock);
	    		}

				if(!this.worldObj.isRemote)
				{
		    		System.out.println(this.worldObj.isRemote+" "+this.prev+" "+this.xCoord+" "+this.yCoord+" "+this.zCoord+" "+this.next);
		    		System.out.println("");
				}
    		}
    	}
    }
    
    public void makeNext(Base tmp)
    {
    	if(tmp != null && !this.worldObj.isRemote)
    		System.out.println(this.toString().substring(this.toString().indexOf("EntityTrack"))+" "+tmp.toString().substring(tmp.toString().indexOf("EntityTrack"))+" "+this.alignment);
    	if(prev != null&& !this.worldObj.isRemote)
    		System.out.println(prev.toString().substring(this.prev.toString().indexOf("EntityTrack")));
    	if(tmp == this.prev || tmp == null)
			if((this.alignment <= 1))
				this.alignment+=2;
			else
				this.alignment-=2;
    	else
    	{
    		k = 0;
			this.next = tmp;
			tmp.prev = this;
			if(tmp != this.firstBlock)
				tmp.makeFirst(this.firstBlock);
			this.makeFirst(this.firstBlock);
    	}
    }
    


	@Override
	public void itemAction(EntityPlayer p) {
		int num = 0;

		if(!this.power && !this.brake && !this.start)
		{
			this.power = true;
			num = 1;
		}
		else if(this.power && this.brake)
		{
			this.power = false;
			this.brake = false;
			this.start = true;
			num = 4;
		}else if(this.power)
		{
			this.power = false;
			this.brake = true;
			this.start = false;
			num = 2;
		}else if(this.brake)
		{
			this.power = true;
			this.brake = true;
			this.start = false;
			num = 3;
		}
		else if(this.start)
		{
			this.power = false;
			this.brake = false;
			this.start = false;
			num = 0;
		}
		for(int k = 0; k < 10-1; k++)
		{
    		p.addChatMessage(new ChatComponentText(""));  
		}
		String tx = "";
		if(num == 4)
			tx = " start needs HIGH redstone input to power";
		p.addChatMessage(new ChatComponentText("mode: "+(num+1)+"/"+5+tx)); 

	}
	
	public float getHalfwayX()
	{
		return this.xCoord+0.5F;
	}
	
	public float getHalfwayY()
	{
		return this.yCoord;
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
		if(this.alignment == 0)
			return (float) (this.zCoord+1-train.posZ);
		if(this.alignment == 1)
			return (float) (this.xCoord+1-train.posX);
		if(this.alignment == 2)
			return (float) (train.posZ-this.zCoord);
		if(this.alignment == 3)
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
	
	public void itemAction2(boolean up, EntityPlayer p) {
		if(this.power || this.brake)
		{
			if(up)
			{
				if(speedAim + 2 <= this.maxSpeedAim)
					this.speedAim += 2;
			}
			else
				if(speedAim - 2 >= this.minSpeedAim)
					this.speedAim -= 2;
			for(int k = 0; k < 10-1; k++)
			{
	    		p.addChatMessage(new ChatComponentText(""));  
			}
			for(int k = 0; k < 1; k++)
				p.addChatMessage(new ChatComponentText(""+ this.getAsBMin(this.speedAim)+" B/min ("+this.getAsBSec(this.speedAim)+" B/s)")); 
			System.out.println(this.worldObj+" "+this.speedAim);
		}
	}
	
    public  void itemAction3(boolean up, EntityPlayer p)
    {
		if(this.start || this.power)
		{
			if(up)
			{
				if(speedM + 0.05F <= this.maxSpeedM)
					this.speedM += 0.05F;
			}
			else
				if(speedM - 0.05F >= this.minSpeedM)
					this.speedM -= 0.05F;
			for(int k = 0; k < 10-1; k++)
			{
	    		p.addChatMessage(new ChatComponentText(""));  
			}
			for(int k = 0; k < 1; k++)
				p.addChatMessage(new ChatComponentText("acceleration: "+this.speedM)); 
		}
	}

	
	 public void readFromNBT(NBTTagCompound k)
	    {
	        super.readFromNBT(k);
	        this.speedAim = k.getInteger("sA");
	        this.speedM = k.getFloat("sM");
	       // if(this.start)
	        //	this.makeFirst(this);
	    }

	    public void writeToNBT(NBTTagCompound k)
	    {
	        super.writeToNBT(k);
	        k.setInteger("sA", this.speedAim);
	        k.setFloat("sM", this.speedM);
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
	        this.speedM = k.getFloat("sM");
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
	      //  if(this.start)
	      //  	this.makeFirst(this);
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
	        k.setFloat("sM", this.speedM);
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
		if(this.start && !this.finished)
		{
			if(tra == null)
				tra = train;
			if(this.getDisTillHalf(train) < this.getDisTillHalfPrev(train) && train.speed > 5)
				train.speed*=0.5F;
			if(this.getDisTillHalf(train) > this.getDisTillHalfPrev(train))
			{
				if(this.alignment == 0 || this.alignment == 2)			
				{
					train.posZ = this.getHalfwayZ();
					
				}else if(this.alignment == 1 || this.alignment == 3)			
				{
					train.posX = this.getHalfwayX();
				}
				train.speed = 0;
				this.finished = true;
			}
			if(this.alignment == 0 || this.alignment == 2)			
			{
				train.posX = this.xCoord+0.5F;
				train.posY = this.yCoord;
				
			}else if(this.alignment == 1 || this.alignment == 3)			
			{
				train.posZ = this.zCoord+0.5F;
				train.posY = this.yCoord;
			}
		}
		if(!this.start || this.finished)
		{
			if(this.alignment == 0 || this.alignment == 2)			
			{
				train.posX = this.xCoord+0.5F;
				train.posY = this.yCoord;
				return true;			
			}else if(this.alignment == 1 || this.alignment == 3)			
			{
				train.posZ = this.zCoord+0.5F;
				train.posY = this.yCoord;
				return true;
			}
		}
		
		return false;
	}

	@Override
	public int[] getVek(int[] vek, EntityTrain train) {
		if(this.alignment == 0)
		{
			int[] tmp = {0,0,1};
			return tmp;
		}else if(this.alignment == 1)
		{
			int[] tmp = {1,0,0};
			return tmp;
		}else if(this.alignment == 2)
		{
			int[] tmp = {0,0,-1};
			return tmp;
		}else if(this.alignment == 3)
		{
			int[] tmp = {-1,0,0};
			return tmp;
		}
		train.posY = this.yCoord;
		int[] tmp = {0,0,0};
		return tmp;
	}

	@Override
	public float getSpeedMultiplier(EntityTrain train) {
		if(!this.power && !this.brake && !this.start)
		{
			return 0.99F;
		}
		else if(this.power && this.brake)
		{
			
			if(train.speed -1 < this.speedAim && train.speed > this.speedAim)
			{
				train.speed = this.speedAim;
				return 1;
			}else if(train.speed*this.speedM <= this.speedAim)
				return this.speedM;
			else if(train.speed*this.speedM2 >= this.speedAim)
				return this.speedM2;
			else
			{
				return 0.99F;
			}
		}
		else if(this.power)
		{			
			if(train.speed -1 < this.speedAim && train.speed > this.speedAim)
			{
				train.speed = this.speedAim;
				return 1;
			}else if(train.speed*this.speedM <= this.speedAim)
				return this.speedM;
			else
			{
				return 0.99F;
			}
		}
		else if(this.brake)
		{
			
			if(train.speed -1 < this.speedAim && train.speed > this.speedAim)
			{
				train.speed = this.speedAim;
				return 1;
			}else if(train.speed*this.speedM2 >= this.speedAim)
				return this.speedM2;
			else
			{
				return 0.99F;
			}
		}		
		else if(this.start)
		{			
			if(train.speed -1 < this.speedAim && train.speed > this.speedAim)
			{
				train.speed = this.speedAim;
				return 1;
			}else if(train.speed*this.speedM <= this.speedAim)
				return this.speedM;
			else
			{
				return 0.99F;
			}
		}
		return 1;
	}
	
}
