package com.roller.roller.tileEntity;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;

import com.roller.roller.models.tmp;


public class EntityTrackTransition extends Base{

	public int speedAim = 50, maxSpeedAim = 190, minSpeedAim = 0;
	float speedM = 1.1F, speedM2, maxSpeedM = 1.25F, minSpeedM = 1.01F;
	int k;
	public tmp base2;
	

    public EntityTrackTransition()
    {

    }
    
    public void updateEntity()
    {
    	super.updateEntity();
    	speedM2 = 2-speedM;
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
	    			if(!down)
	    			{
		    			if(this.worldObj.getTileEntity(this.xCoord, this.yCoord, this.zCoord+1) != null && this.worldObj.getTileEntity(this.xCoord, this.yCoord, this.zCoord+1) instanceof EntityTrackPitched)
		    			{
		    				tmp = (EntityTrackPitched) this.worldObj.getTileEntity(this.xCoord, this.yCoord, this.zCoord+1);
		    				if(tmp.alignment == 0)
		    				{
		    					this.makeNext(tmp);
		    				}
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
	    		if(this.alignment == 1)
	    		{
	    			if(!down)
	    			{
		    			if(this.worldObj.getTileEntity(this.xCoord-1, this.yCoord, this.zCoord) != null && this.worldObj.getTileEntity(this.xCoord-1, this.yCoord, this.zCoord) instanceof EntityTrackPitched)
		    			{
		    				tmp = (EntityTrackPitched) this.worldObj.getTileEntity(this.xCoord-1, this.yCoord, this.zCoord);
		    				if(tmp.alignment == 1)
		    				{
		    					this.makeNext(tmp);
		    				}
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
	    		if(this.alignment == 2)
	    		{
	    			if(!down)
	    			{
		    			if(this.worldObj.getTileEntity(this.xCoord, this.yCoord, this.zCoord-1) != null && this.worldObj.getTileEntity(this.xCoord, this.yCoord, this.zCoord-1) instanceof EntityTrackPitched)
		    			{
		    				tmp = (EntityTrackPitched) this.worldObj.getTileEntity(this.xCoord, this.yCoord, this.zCoord-1);
		    				if(tmp.alignment == 2)
		    				{
		    					this.makeNext(tmp);
	
		    				}
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
	    		if(this.alignment == 3)
	    		{
	    			if(!down)
	    			{
		    			if(this.worldObj.getTileEntity(this.xCoord+1, this.yCoord, this.zCoord) != null && this.worldObj.getTileEntity(this.xCoord+1, this.yCoord, this.zCoord) instanceof EntityTrackPitched)
		    			{
		    				tmp = (EntityTrackPitched) this.worldObj.getTileEntity(this.xCoord+1, this.yCoord, this.zCoord);
		    				if(tmp.alignment == 3)
			    			{
		    					this.makeNext(tmp);
			    			}
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
	    		if(this.alignment == 4)
	    		{
	    			if(!down)
	    			{
		    			if(this.worldObj.getTileEntity(this.xCoord, this.yCoord, this.zCoord+1) != null && this.worldObj.getTileEntity(this.xCoord, this.yCoord, this.zCoord+1) instanceof EntityTrackPitched)
		    			{
		    				tmp = (EntityTrackPitched) this.worldObj.getTileEntity(this.xCoord, this.yCoord, this.zCoord+1);
		    				if(tmp.alignment == 2)
		    				{
		    					tmp.down = true;
		    					this.makeNext(tmp);
		    				}
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
	    		if(this.alignment == 5)
	    		{
	    			if(!down)
	    			{
		    			if(this.worldObj.getTileEntity(this.xCoord-1, this.yCoord, this.zCoord) != null && this.worldObj.getTileEntity(this.xCoord-1, this.yCoord, this.zCoord) instanceof EntityTrackPitched)
		    			{
		    				tmp = (EntityTrackPitched) this.worldObj.getTileEntity(this.xCoord-1, this.yCoord, this.zCoord);
		    				if(tmp.alignment == 3)
		    				{
		    					tmp.down = true;
		    					this.makeNext(tmp);
		    				}
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
	    		if(this.alignment == 6)
	    		{
	    			if(!down)
	    			{
		    			if(this.worldObj.getTileEntity(this.xCoord, this.yCoord, this.zCoord-1) != null && this.worldObj.getTileEntity(this.xCoord, this.yCoord, this.zCoord-1) instanceof EntityTrackPitched)
		    			{
		    				tmp = (EntityTrackPitched) this.worldObj.getTileEntity(this.xCoord, this.yCoord, this.zCoord-1);
		    				if(tmp.alignment == 0)
		    				{
		    					tmp.down = true;
		    					this.makeNext(tmp);
	
		    				}
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
	    		if(this.alignment == 7)
	    		{
	    			if(!down)
	    			{
		    			if(this.worldObj.getTileEntity(this.xCoord+1, this.yCoord, this.zCoord) != null && this.worldObj.getTileEntity(this.xCoord+1, this.yCoord, this.zCoord) instanceof EntityTrackPitched)
		    			{
		    				tmp = (EntityTrackPitched) this.worldObj.getTileEntity(this.xCoord+1, this.yCoord, this.zCoord);
		    				if(tmp.alignment == 1)
			    			{
		    					tmp.down = true;
		    					this.makeNext(tmp);
			    			}
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
	    		if(this.next == null && k < 2)
	    		{
	    			k++;
	    		}else if(this.next == null)
	    		{
	    			this.failed = true;
	    			k= 0;
	    			this.makeFirst(this.firstBlock);
	    		}

				//if(!this.worldObj.isRemote)
				{
		    		System.out.println(this.worldObj.isRemote+" "+this.prev+" "+this.xCoord+" "+this.yCoord+" "+this.zCoord+" "+this.next);
		    		System.out.println("");
				}
    		}
    	}
    }
    
    public void makeNext(Base tmp)
    {
    	if(tmp == this.prev)
			if(this.down)
				this.down = false;
			else
				this.down = true;
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
	public boolean acceptsTrain(EntityTrain train) {
		
		if(this.alignment == 0 || this.alignment == 2 || this.alignment == 4 || this.alignment == 6)			
		{
			train.posX = this.xCoord+0.5F;
			train.posY = this.yCoord;
			return true;			
		}else if(this.alignment == 1 || this.alignment == 3 || this.alignment == 5 || this.alignment == 7)			
		{
			train.posZ = this.zCoord+0.5F;
			train.posY = this.yCoord;
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
		}*/
		return false;
	}

	@Override
	public int[] getVek(int[] vek, EntityTrain train) {
		if(this.alignment == 0 || this.alignment == 4 )
		{
			if(!down)
			{
				int[] tmp = {0,0,1};
				return tmp;
			}else
			{
				int[] tmp = {0,0,-1};
				return tmp;
			}
		}else if(this.alignment == 1 || this.alignment == 5)
		{
			if(!down)
			{
				int[] tmp = {-1,0,0};
				return tmp;
			}else
			{
				int[] tmp = {1,0,0};
				return tmp;
			}
		}else if(this.alignment == 2 || this.alignment == 6)
		{
			if(!down)
			{
				int[] tmp = {0,0,-1};
				return tmp;
			}else
			{
				int[] tmp = {0,0,1};
				return tmp;
			}
		}else if(this.alignment == 3 || this.alignment == 7)
		{
			if(!down)
			{
				int[] tmp = {1,0,0};
				return tmp;
			}else
			{
				int[] tmp = {-1,0,0};
				return tmp;
			}
		}
		train.posY = this.yCoord;
		int[] tmp = {0,0,0};
		return tmp;
	}

	
	public float getPlayerYOff()
	{
		if(!this.down)
			return -0.2F;
		return 0;
	}	
	
	public float getPlayerXOff()
	{
		if(!this.down)
		{
			if(this.alignment == 2 || this.alignment == 4)
				return 0.7F;
			else if(this.alignment == 0 || this.alignment == 6)
				return -0.7F;
		}
		return 0;
	}
	
	public float getPlayerZOff()
	{
		if(!this.down)
		{
			if(this.alignment == 3 || this.alignment == 5)
				return 0.7F;
			else if(this.alignment == 1 || this.alignment == 7)
				return -0.7F;
		}
		return 0;
	}
	
	@Override
	public float getSpeedMultiplier(EntityTrain train) {
		return 0.97F;
	}
	
}
