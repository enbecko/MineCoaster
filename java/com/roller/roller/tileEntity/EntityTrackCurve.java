package com.roller.roller.tileEntity;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;

import com.roller.roller.models.ModelTrain;


public class EntityTrackCurve extends Base{

	public int power;
	public float speed;
	

    public EntityTrackCurve()
    {

    }
    
    public void updateEntity()
    {
    	super.updateEntity();
    		Base tmp;
    		if(this.first)
    		{
    			this.next = null;
    			ifclause:
	    		if(this.alignment == 0)
	    		{
		    			if(this.worldObj.getTileEntity(this.xCoord-1, this.yCoord, this.zCoord) != null && this.worldObj.getTileEntity(this.xCoord-1, this.yCoord, this.zCoord) instanceof EntityTrackBase)
		    			{
		    				tmp = (EntityTrackBase) this.worldObj.getTileEntity(this.xCoord-1, this.yCoord, this.zCoord);
		    				if(tmp != this.prev)
			    				if((tmp.alignment % 2) != 0)
			    				{
			    					this.makeNext(tmp);
			    					break ifclause;
			    				}
		    			}
		    		if(this.worldObj.getTileEntity(this.xCoord, this.yCoord, this.zCoord+1) != null && this.worldObj.getTileEntity(this.xCoord, this.yCoord, this.zCoord+1) instanceof EntityTrackBase)
	    			{
	    				tmp = (EntityTrackBase) this.worldObj.getTileEntity(this.xCoord, this.yCoord, this.zCoord+1);
	    				if((tmp.alignment % 2) == 0)
		    			{
	    					this.makeNext(tmp);
		    			}
	    			}/**else if(this.worldObj.getTileEntity(this.xCoord, this.yCoord+1, this.zCoord+1) != null && this.worldObj.getTileEntity(this.xCoord, this.yCoord+1, this.zCoord+1) instanceof EntityTrackCurve)
		    			{
		    				tmp = (EntityTrackCurve) this.worldObj.getTileEntity(this.xCoord, this.yCoord+1, this.zCoord+1);
		    				if(tmp.alignment == this.alignment)
		    				{
		    					this.makeNext(tmp);
		    				}
		    			}*/
	    			
	    		}
    			ifclause:
	    		if(this.alignment == 1)
	    		{
		    			if(this.worldObj.getTileEntity(this.xCoord, this.yCoord, this.zCoord-1) != null && this.worldObj.getTileEntity(this.xCoord, this.yCoord, this.zCoord-1) instanceof EntityTrackBase)
		    			{
		    				tmp = (EntityTrackBase) this.worldObj.getTileEntity(this.xCoord, this.yCoord, this.zCoord-1);
		    				if(tmp != this.prev)
			    				if((tmp.alignment % 2) == 0)
			    				{
			    					this.makeNext(tmp);
			    					break ifclause;
			    				}
		    			}
		    		if(this.worldObj.getTileEntity(this.xCoord-1, this.yCoord, this.zCoord) != null && this.worldObj.getTileEntity(this.xCoord-1, this.yCoord, this.zCoord) instanceof EntityTrackBase)
	    			{
	    				tmp = (EntityTrackBase) this.worldObj.getTileEntity(this.xCoord-1, this.yCoord, this.zCoord);
		    			if((tmp.alignment % 2) != 0)
		    			{
		    				this.makeNext(tmp);
		    			}
	    			}/**else if(this.worldObj.getTileEntity(this.xCoord+1, this.yCoord+1, this.zCoord) != null && this.worldObj.getTileEntity(this.xCoord+1, this.yCoord+1, this.zCoord) instanceof EntityTrackCurve)
		    			{
		    				tmp = (EntityTrackCurve) this.worldObj.getTileEntity(this.xCoord+1, this.yCoord+1, this.zCoord);
		    				if(tmp.alignment == this.alignment)
		    				{
		    					this.makeNext(tmp);
		    				}
		    			}*/
	    			
	    		}
    			ifclause:
	    		if(this.alignment == 2)
	    		{
		    			if(this.worldObj.getTileEntity(this.xCoord+1, this.yCoord, this.zCoord) != null && this.worldObj.getTileEntity(this.xCoord+1, this.yCoord, this.zCoord) instanceof EntityTrackBase)
		    			{
		    				tmp = (EntityTrackBase) this.worldObj.getTileEntity(this.xCoord+1, this.yCoord, this.zCoord);
		    				if(tmp != this.prev)
			    				if((tmp.alignment % 2) != 0)
			    				{
			    					this.makeNext(tmp);
			    					break ifclause;
			    				}
		    			}
	    			if(this.worldObj.getTileEntity(this.xCoord, this.yCoord, this.zCoord-1) != null && this.worldObj.getTileEntity(this.xCoord, this.yCoord, this.zCoord-1) instanceof EntityTrackBase)
		    		{
		    			tmp = (EntityTrackBase) this.worldObj.getTileEntity(this.xCoord, this.yCoord, this.zCoord-1);
		    			if((tmp.alignment % 2) == 0)
			    		{
			    			this.makeNext(tmp);
			    		}
		    		}/**else if(this.worldObj.getTileEntity(this.xCoord, this.yCoord+1, this.zCoord-1) != null && this.worldObj.getTileEntity(this.xCoord, this.yCoord+1, this.zCoord-1) instanceof EntityTrackCurve)
		    			{
		    				tmp = (EntityTrackCurve) this.worldObj.getTileEntity(this.xCoord, this.yCoord+1, this.zCoord-1);
		    				if(tmp.alignment == this.alignment)
		    				{
		    					this.makeNext(tmp);
		    				}
		    			}*/
	    			
	    			
	    		}
    			ifclause:
	    		if(this.alignment == 3)
	    		{
		    			if(this.worldObj.getTileEntity(this.xCoord, this.yCoord, this.zCoord+1) != null && this.worldObj.getTileEntity(this.xCoord, this.yCoord, this.zCoord+1) instanceof EntityTrackBase)
		    			{
		    				tmp = (EntityTrackBase) this.worldObj.getTileEntity(this.xCoord, this.yCoord, this.zCoord+1);
		    				if(tmp != this.prev)
			    				if((tmp.alignment % 2) == 0)
				    			{
			    					this.makeNext(tmp);
			    					break ifclause;
				    			}
		    			}
		    		if(this.worldObj.getTileEntity(this.xCoord+1, this.yCoord, this.zCoord) != null && this.worldObj.getTileEntity(this.xCoord+1, this.yCoord, this.zCoord) instanceof EntityTrackBase)
	    			{
	    				tmp = (EntityTrackBase) this.worldObj.getTileEntity(this.xCoord+1, this.yCoord, this.zCoord);
		    			if((tmp.alignment % 2) != 0)
		    			{
		    				this.makeNext(tmp);
		    			}
	    			}/**else if(this.worldObj.getTileEntity(this.xCoord-1, this.yCoord+1, this.zCoord) != null && this.worldObj.getTileEntity(this.xCoord-1, this.yCoord+1, this.zCoord) instanceof EntityTrackCurve)
		    			{
		    				tmp = (EntityTrackCurve) this.worldObj.getTileEntity(this.xCoord-1, this.yCoord+1, this.zCoord);
		    				if(tmp.alignment == this.alignment)
		    				{
		    					this.makeNext(tmp);
		    				}
		    			}*/
	    			
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
    

	@Override
	public boolean acceptsTrain(EntityTrain train) {
		float x1 = (float) Math.abs(Math.abs(train.prevPosX)-Math.abs(this.xCoord));
		float x2 = (float) Math.abs(Math.abs(train.posX)-Math.abs(this.xCoord));
		float y1 = (float) Math.abs(Math.abs(train.prevPosZ)-Math.abs(this.zCoord));
		float y2 = (float) Math.abs(Math.abs(train.posZ)-Math.abs(this.zCoord));
		System.out.println(x1 +" "+x2 + " "+y1+" "+y2);

		if(((x2>=x1 && x1 <= 0.5F && x2 >= 0.5F) || (x2<=x1 && x1 >= 0.5F && x2 <= 0.5F)) && ((y2>=y1 && y1 <= 0.5F && y2 >= 0.5F) || (y2<=y1 && y1 >= 0.5F && y2 <= 0.5F)) )
		{
			System.out.println("ja");
			train.posX = this.xCoord+0.5F;
			train.posZ = this.zCoord+0.5F;
			return true;
		}
		return false;
		
	}
	
	@Override
	public int[] getVek(int[] vek, EntityTrain train) {
		if(this.alignment == 0)
		{
			if(vek[0] > 0)
			{
				int[] tmp = {0,0,1};
				return tmp;
			}
			else if(vek[2] < 0)
			{
				int[] tmp = {-1,0,0};
				return tmp;
			}
		}else if(this.alignment == 1)
		{
			if(vek[2] > 0)
			{
				int[] tmp = {-1,0,0};
				return tmp;
			}
			else if(vek[0] > 0)
			{
				int[] tmp = {0,0,-1};
				return tmp;
			}
		}else if(this.alignment == 2)
		{
			if(vek[0] < 0)
			{
				int[] tmp = {0,0,-1};
				return tmp;
			}
			else if(vek[2] > 0)
			{
				int[] tmp = {1,0,0};
				return tmp;
			}
		}else if(this.alignment == 3)
		{
			if(vek[2] < 0)
			{
				int[] tmp = {1,0,0};
				return tmp;
			}
			else if(vek[0] < 0)
			{
				int[] tmp = {0,0,1};
				return tmp;
			}
		}
		return null;
	}
	
	@Override
	public float getSpeedMultiplier(EntityTrain train) {
		return 0.98F;
	}
	
}
