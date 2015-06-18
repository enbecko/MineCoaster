package com.roller.roller.tileEntity;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;


public class EntityTrackSeitlich extends Base{

	public int power;
	public boolean start;
	public float speed;
	int k;
	

    public EntityTrackSeitlich()
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
	    			if(this.worldObj.getTileEntity(this.xCoord, this.yCoord, this.zCoord-1) != null && this.worldObj.getTileEntity(this.xCoord, this.yCoord, this.zCoord-1) instanceof EntityTrackSeitlich)
	    			{
	    				tmp = (EntityTrackSeitlich) this.worldObj.getTileEntity(this.xCoord, this.yCoord, this.zCoord-1);
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
	    				System.out.println(tmp.alignment);
	    				if(tmp.alignment == 2)
	    				{
	    					if(tmp != this.prev)
	    						((EntityTrackHorTop)tmp).down = false;
	    					this.makeNext(tmp);
	    				}
	    			}
	    		}
	    		if(this.alignment == 1)
	    		{
	    			if(this.worldObj.getTileEntity(this.xCoord-1, this.yCoord, this.zCoord) != null && this.worldObj.getTileEntity(this.xCoord-1, this.yCoord, this.zCoord) instanceof EntityTrackSeitlich)
	    			{
	    				tmp = (EntityTrackSeitlich) this.worldObj.getTileEntity(this.xCoord-1, this.yCoord, this.zCoord);
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
	    			}
	    		}
	    		if(this.alignment == 2)
	    		{
	    			if(this.worldObj.getTileEntity(this.xCoord, this.yCoord, this.zCoord+1) != null && this.worldObj.getTileEntity(this.xCoord, this.yCoord, this.zCoord+1) instanceof EntityTrackSeitlich)
	    			{
	    				tmp = (EntityTrackSeitlich) this.worldObj.getTileEntity(this.xCoord, this.yCoord, this.zCoord+1);
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
	    			}
	    		}
	    		if(this.alignment == 3)
	    		{
	    			if(this.worldObj.getTileEntity(this.xCoord+1, this.yCoord, this.zCoord) != null && this.worldObj.getTileEntity(this.xCoord+1, this.yCoord, this.zCoord) instanceof EntityTrackSeitlich)
	    			{
	    				tmp = (EntityTrackSeitlich) this.worldObj.getTileEntity(this.xCoord+1, this.yCoord, this.zCoord);
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
	    			}
	    		}
	    		if(this.next == null && k < 1)
	    		{
	    			k++;
	    		}else if(this.next == null)
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
