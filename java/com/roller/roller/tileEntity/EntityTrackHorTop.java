package com.roller.roller.tileEntity;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;

import com.roller.roller.models.ModelTrain;


public class EntityTrackHorTop extends Base{

	public int power;
	public float speed;
	public float xForDown = -1.3F, yForDown = -1.3F, zForDown = -1.3F, xForUp = -1.3F, yForUp = -1.3F, zForUp = -1.3F, turnForTrans = 45;
	public boolean screenTaken;

    public EntityTrackHorTop()
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
    			if(down)
    			{
    				if(this.worldObj.getTileEntity(this.xCoord, this.yCoord-1, this.zCoord) != null && this.worldObj.getTileEntity(this.xCoord, this.yCoord-1, this.zCoord) instanceof EntityTrackUp)
	    			{
	    				tmp = (EntityTrackUp) this.worldObj.getTileEntity(this.xCoord, this.yCoord-1, this.zCoord);
	    				if(tmp.alignment == this.alignment)
	    				{
	    					if(((EntityTrackUp)tmp) != this.prev)
	    						((EntityTrackUp)tmp).down = true;
	    					this.makeNext(tmp);
	    				}
	    			}
    			}
    			if(this.alignment == 0)
	    		{
	    			if(down)
	    			{
		    			if(this.worldObj.getTileEntity(this.xCoord, this.yCoord-1, this.zCoord-1) != null && this.worldObj.getTileEntity(this.xCoord, this.yCoord-1, this.zCoord-1) instanceof EntityTrackBaseTop)
		    			{
		    				tmp = (EntityTrackBaseTop) this.worldObj.getTileEntity(this.xCoord, this.yCoord-1, this.zCoord-1);
		    				if((tmp.alignment % 2) == 0)
		    				{
		    					this.makeNext(tmp);
		    				}
		    			}else if(this.worldObj.getTileEntity(this.xCoord, this.yCoord-1, this.zCoord-1) != null && this.worldObj.getTileEntity(this.xCoord, this.yCoord-1, this.zCoord-1) instanceof EntityTrackHorTop)
		    			{
		    				tmp = (EntityTrackHorTop) this.worldObj.getTileEntity(this.xCoord, this.yCoord-1, this.zCoord-1);
		    				if(tmp.alignment == this.alignment)
		    				{
		    					if(((EntityTrackHorTop)tmp) != this.prev)
		    						((EntityTrackHorTop)tmp).down = true;
		    					this.makeNext(tmp);
		    				}
		    			} 
		    			else if(this.worldObj.getTileEntity(this.xCoord, this.yCoord-1, this.zCoord-1) != null && this.worldObj.getTileEntity(this.xCoord, this.yCoord-1, this.zCoord-1) instanceof EntityTrack225_2Top)
		    			{
		    				tmp = (EntityTrack225_2Top) this.worldObj.getTileEntity(this.xCoord, this.yCoord-1, this.zCoord-1);
		    				if(tmp.alignment == 6|| tmp.alignment == 2)
		    				{
		    					if(((EntityTrack225_2Top)tmp) != this.prev)
		    						((EntityTrack225_2Top)tmp).down = true;
		    					this.makeNext(tmp);
		    				}
		    			}
	    			}else
	    			{
		    			if(this.worldObj.getTileEntity(this.xCoord, this.yCoord+1, this.zCoord+1) != null && this.worldObj.getTileEntity(this.xCoord, this.yCoord+1, this.zCoord+1) instanceof EntityTrackHorTop)
		    			{
		    				tmp = (EntityTrackHorTop) this.worldObj.getTileEntity(this.xCoord, this.yCoord+1, this.zCoord+1);
		    				if(tmp.alignment == this.alignment)
		    				{
		    					if(((EntityTrackHorTop)tmp) != this.prev)
		    						((EntityTrackHorTop)tmp).down = false;
		    					this.makeNext(tmp);
		    				}
		    			}else if(this.worldObj.getTileEntity(this.xCoord, this.yCoord, this.zCoord+1) != null && this.worldObj.getTileEntity(this.xCoord, this.yCoord, this.zCoord+1) instanceof EntityTrackBaseTop)
		    			{
		    				tmp = (EntityTrackBaseTop) this.worldObj.getTileEntity(this.xCoord, this.yCoord, this.zCoord+1);
		    				if((tmp.alignment % 2) == 0)
		    				{
		    					this.makeNext(tmp);
		    				}
		    			}else if(this.worldObj.getTileEntity(this.xCoord, this.yCoord+1, this.zCoord+1) != null && this.worldObj.getTileEntity(this.xCoord, this.yCoord+1, this.zCoord+1) instanceof EntityTrackUp)
		    			{
		    				tmp = (EntityTrackUp) this.worldObj.getTileEntity(this.xCoord, this.yCoord+1, this.zCoord+1);
		    				if(tmp.alignment == 0)
		    				{
		    					((EntityTrackUp)tmp).down = false;
		    					this.makeNext(tmp);
		    				}
		    			}else if(this.worldObj.getTileEntity(this.xCoord, this.yCoord+1, this.zCoord+1) != null && this.worldObj.getTileEntity(this.xCoord, this.yCoord+1, this.zCoord+1) instanceof EntityTrack225Top)
		    			{
		    				tmp = (EntityTrack225Top) this.worldObj.getTileEntity(this.xCoord, this.yCoord+1, this.zCoord+1);
		    				if(tmp.alignment == 2|| tmp.alignment == 6)
		    				{
		    					((EntityTrack225Top)tmp).down = false;
		    					this.makeNext(tmp);
		    				}
		    			}
	    			}
	    		}
	    		if(this.alignment == 1)
	    		{
	    			if(down)
	    			{
		    			if(this.worldObj.getTileEntity(this.xCoord-1, this.yCoord-1, this.zCoord) != null && this.worldObj.getTileEntity(this.xCoord-1, this.yCoord-1, this.zCoord) instanceof EntityTrackBaseTop)
		    			{
		    				tmp = (EntityTrackBaseTop) this.worldObj.getTileEntity(this.xCoord-1, this.yCoord-1, this.zCoord);
		    				if((tmp.alignment % 2) != 0)
		    				{
		    					this.makeNext(tmp);
		    				}
		    			}else if(this.worldObj.getTileEntity(this.xCoord-1, this.yCoord-1, this.zCoord) != null && this.worldObj.getTileEntity(this.xCoord-1, this.yCoord-1, this.zCoord) instanceof EntityTrackHorTop)
		    			{
		    				tmp = (EntityTrackHorTop) this.worldObj.getTileEntity(this.xCoord-1, this.yCoord-1, this.zCoord);
		    				if(tmp.alignment == this.alignment)
		    				{
		    					if(((EntityTrackHorTop)tmp) != this.prev)
		    						((EntityTrackHorTop)tmp).down = true;
		    					this.makeNext(tmp);
		    				}
		    			}
		    			else if(this.worldObj.getTileEntity(this.xCoord-1, this.yCoord-1, this.zCoord) != null && this.worldObj.getTileEntity(this.xCoord-1, this.yCoord-1, this.zCoord) instanceof EntityTrack225_2Top)
		    			{
		    				tmp = (EntityTrack225_2Top) this.worldObj.getTileEntity(this.xCoord-1, this.yCoord-1, this.zCoord);
		    				if(tmp.alignment == 5|| tmp.alignment == 1)
		    				{
		    					if(((EntityTrack225_2Top)tmp) != this.prev)
		    						((EntityTrack225_2Top)tmp).down = true;
		    					this.makeNext(tmp);
		    				}
		    			}
	    			}else
	    			{
		    			if(this.worldObj.getTileEntity(this.xCoord+1, this.yCoord+1, this.zCoord) != null && this.worldObj.getTileEntity(this.xCoord+1, this.yCoord+1, this.zCoord) instanceof EntityTrackHorTop)
		    			{
		    				tmp = (EntityTrackHorTop) this.worldObj.getTileEntity(this.xCoord+1, this.yCoord+1, this.zCoord);
		    				if(tmp.alignment == this.alignment)
		    				{
		    					if(((EntityTrackHorTop)tmp) != this.prev)
		    						((EntityTrackHorTop)tmp).down = false;
		    					this.makeNext(tmp);
		    				}
		    			}else if(this.worldObj.getTileEntity(this.xCoord+1, this.yCoord, this.zCoord) != null && this.worldObj.getTileEntity(this.xCoord+1, this.yCoord, this.zCoord) instanceof EntityTrackBaseTop)
		    			{
		    				tmp = (EntityTrackBaseTop) this.worldObj.getTileEntity(this.xCoord+1, this.yCoord, this.zCoord);
		    				if((tmp.alignment % 2) != 0)
		    				{
		    					this.makeNext(tmp);
		    				}
		    			}else if(this.worldObj.getTileEntity(this.xCoord+1, this.yCoord+1, this.zCoord) != null && this.worldObj.getTileEntity(this.xCoord+1, this.yCoord+1, this.zCoord) instanceof EntityTrackUp)
		    			{
		    				tmp = (EntityTrackUp) this.worldObj.getTileEntity(this.xCoord+1, this.yCoord+1, this.zCoord);
		    				if(tmp.alignment == 1)
		    				{
		    					((EntityTrackUp)tmp).down = false;
		    					this.makeNext(tmp);
		    				}
		    			}else if(this.worldObj.getTileEntity(this.xCoord+1, this.yCoord+1, this.zCoord) != null && this.worldObj.getTileEntity(this.xCoord+1, this.yCoord+1, this.zCoord) instanceof EntityTrack225Top)
		    			{
		    				tmp = (EntityTrack225Top) this.worldObj.getTileEntity(this.xCoord+1, this.yCoord+1, this.zCoord);
		    				if(tmp.alignment == 3|| tmp.alignment == 5)
		    				{
		    					((EntityTrack225Top)tmp).down = false;
		    					this.makeNext(tmp);
		    				}
		    			}
	    			}
	    		}
	    		if(this.alignment == 2)
	    		{
	    			if(down)
	    			{
		    			if(this.worldObj.getTileEntity(this.xCoord, this.yCoord-1, this.zCoord+1) != null && this.worldObj.getTileEntity(this.xCoord, this.yCoord-1, this.zCoord+1) instanceof EntityTrackBaseTop)
		    			{
		    				tmp = (EntityTrackBaseTop) this.worldObj.getTileEntity(this.xCoord, this.yCoord-1, this.zCoord+1);
		    				if((tmp.alignment % 2) == 0)
		    				{
		    					this.makeNext(tmp);
	
		    				}
		    			}else if(this.worldObj.getTileEntity(this.xCoord, this.yCoord-1, this.zCoord+1) != null && this.worldObj.getTileEntity(this.xCoord, this.yCoord-1, this.zCoord+1) instanceof EntityTrackHorTop)
		    			{
		    				tmp = (EntityTrackHorTop) this.worldObj.getTileEntity(this.xCoord, this.yCoord-1, this.zCoord+1);
		    				if(tmp.alignment == this.alignment)
		    				{
		    					if(((EntityTrackHorTop)tmp) != this.prev)
		    						((EntityTrackHorTop)tmp).down = true;
		    					this.makeNext(tmp);
		    				}
		    			}
		    			else if(this.worldObj.getTileEntity(this.xCoord, this.yCoord-1, this.zCoord+1) != null && this.worldObj.getTileEntity(this.xCoord, this.yCoord-1, this.zCoord+1) instanceof EntityTrack225_2Top)
		    			{
		    				tmp = (EntityTrack225_2Top) this.worldObj.getTileEntity(this.xCoord, this.yCoord-1, this.zCoord+1);
		    				if(tmp.alignment == 4 || tmp.alignment == 0)
		    				{
		    					if(((EntityTrack225_2Top)tmp) != this.prev)
		    						((EntityTrack225_2Top)tmp).down = true;
		    					this.makeNext(tmp);
		    				}
		    			}
	    			}
	    			else
	    			{
		    			if(this.worldObj.getTileEntity(this.xCoord, this.yCoord+1, this.zCoord-1) != null && this.worldObj.getTileEntity(this.xCoord, this.yCoord+1, this.zCoord-1) instanceof EntityTrackHorTop)
		    			{
		    				tmp = (EntityTrackHorTop) this.worldObj.getTileEntity(this.xCoord, this.yCoord+1, this.zCoord-1);
		    				if(tmp.alignment == this.alignment)
		    				{
		    					if(((EntityTrackHorTop)tmp) != this.prev)
		    						((EntityTrackHorTop)tmp).down = false;
		    					this.makeNext(tmp);
		    				}
		    			}else if(this.worldObj.getTileEntity(this.xCoord, this.yCoord, this.zCoord-1) != null && this.worldObj.getTileEntity(this.xCoord, this.yCoord, this.zCoord-1) instanceof EntityTrackBaseTop)
		    			{
		    				tmp = (EntityTrackBaseTop) this.worldObj.getTileEntity(this.xCoord, this.yCoord, this.zCoord-1);
		    				if((tmp.alignment % 2) == 0)
		    				{
		    					this.makeNext(tmp);
		    				}
		    			}else if(this.worldObj.getTileEntity(this.xCoord, this.yCoord+1, this.zCoord-1) != null && this.worldObj.getTileEntity(this.xCoord, this.yCoord+1, this.zCoord-1) instanceof EntityTrackUp)
		    			{
		    				tmp = (EntityTrackUp) this.worldObj.getTileEntity(this.xCoord, this.yCoord+1, this.zCoord-1);
		    				if(tmp.alignment == 2)
		    				{
		    					((EntityTrackUp)tmp).down = false;
		    					this.makeNext(tmp);
		    				}
		    			}
		    			else if(this.worldObj.getTileEntity(this.xCoord, this.yCoord+1, this.zCoord-1) != null && this.worldObj.getTileEntity(this.xCoord, this.yCoord+1, this.zCoord-1) instanceof EntityTrack225Top)
		    			{
		    				tmp = (EntityTrack225Top) this.worldObj.getTileEntity(this.xCoord, this.yCoord+1, this.zCoord-1);
		    				if(tmp.alignment == 0 || tmp.alignment == 4)
		    				{
		    					((EntityTrack225Top)tmp).down = false;
		    					this.makeNext(tmp);
		    				}
		    			}
	    			}
	    		}
	    		if(this.alignment == 3)
	    		{
	    			if(down)
	    			{
		    			if(this.worldObj.getTileEntity(this.xCoord+1, this.yCoord-1, this.zCoord) != null && this.worldObj.getTileEntity(this.xCoord+1, this.yCoord-1, this.zCoord) instanceof EntityTrackBaseTop)
		    			{
		    				tmp = (EntityTrackBaseTop) this.worldObj.getTileEntity(this.xCoord+1, this.yCoord-1, this.zCoord);
		    				if((tmp.alignment % 2) != 0)
			    			{
		    					this.makeNext(tmp);
			    			}
		    			}else if(this.worldObj.getTileEntity(this.xCoord+1, this.yCoord-1, this.zCoord) != null && this.worldObj.getTileEntity(this.xCoord+1, this.yCoord-1, this.zCoord) instanceof EntityTrackHorTop)
		    			{
		    				tmp = (EntityTrackHorTop) this.worldObj.getTileEntity(this.xCoord+1, this.yCoord-1, this.zCoord);
		    				if(tmp.alignment == this.alignment)
		    				{
		    					if(((EntityTrackHorTop)tmp) != this.prev)
		    						((EntityTrackHorTop)tmp).down = true;
		    					this.makeNext(tmp);
		    				}
		    			}else if(this.worldObj.getTileEntity(this.xCoord+1, this.yCoord-1, this.zCoord) != null && this.worldObj.getTileEntity(this.xCoord+1, this.yCoord-1, this.zCoord) instanceof EntityTrack225_2Top)
		    			{
		    				tmp = (EntityTrack225_2Top) this.worldObj.getTileEntity(this.xCoord+1, this.yCoord-1, this.zCoord);
		    				if(tmp.alignment == 7|| tmp.alignment == 3)
		    				{
		    					if(((EntityTrack225_2Top)tmp) != this.prev)
		    						((EntityTrack225_2Top)tmp).down = true;
		    					this.makeNext(tmp);
		    				}
		    			}
	    			}else
	    			{
	    				if(this.worldObj.getTileEntity(this.xCoord-1, this.yCoord+1, this.zCoord) != null && this.worldObj.getTileEntity(this.xCoord-1, this.yCoord+1, this.zCoord) instanceof EntityTrackHorTop)
		    			{
		    				tmp = (EntityTrackHorTop) this.worldObj.getTileEntity(this.xCoord-1, this.yCoord+1, this.zCoord);
		    				if(tmp.alignment == this.alignment)
		    				{
		    					if(((EntityTrackHorTop)tmp) != this.prev)
		    						((EntityTrackHorTop)tmp).down = false;
		    					this.makeNext(tmp);
		    				}
		    			}else if(this.worldObj.getTileEntity(this.xCoord-1, this.yCoord, this.zCoord) != null && this.worldObj.getTileEntity(this.xCoord-1, this.yCoord, this.zCoord) instanceof EntityTrackBaseTop)
		    			{
		    				tmp = (EntityTrackBaseTop) this.worldObj.getTileEntity(this.xCoord-1, this.yCoord, this.zCoord);
		    				if((tmp.alignment % 2) != 0)
		    				{
		    					this.makeNext(tmp);
		    				}
		    			}else if(this.worldObj.getTileEntity(this.xCoord-1, this.yCoord+1, this.zCoord) != null && this.worldObj.getTileEntity(this.xCoord-1, this.yCoord+1, this.zCoord) instanceof EntityTrackUp)
		    			{
		    				tmp = (EntityTrackUp) this.worldObj.getTileEntity(this.xCoord-1, this.yCoord+1, this.zCoord);
		    				if(tmp.alignment == 3)
		    				{
		    					((EntityTrackUp)tmp).down = false;
		    					this.makeNext(tmp);
		    				}
		    			}else if(this.worldObj.getTileEntity(this.xCoord-1, this.yCoord+1, this.zCoord) != null && this.worldObj.getTileEntity(this.xCoord-1, this.yCoord+1, this.zCoord) instanceof EntityTrack225Top)
		    			{
		    				tmp = (EntityTrack225Top) this.worldObj.getTileEntity(this.xCoord-1, this.yCoord+1, this.zCoord);
		    				if(tmp.alignment == 1|| tmp.alignment == 7)
		    				{
		    					((EntityTrack225Top)tmp).down = false;
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
	
	@Override
	public boolean acceptsTrain(EntityTrain train) {

		if(this.alignment == 0 || this.alignment == 2)			
		{
			train.posX = this.xCoord+0.5F;
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

			return true;			
		}else if(this.alignment == 1 || this.alignment == 3)			
		{
			train.posZ = this.zCoord+0.5F;
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
				train.posY = this.yCoord+kole;
			if((this.alignment == 3 && !this.down) || (this.alignment == 1 && this.down))
				train.posX = this.xCoord+0.999F-kole;
			else
				train.posX = this.xCoord+kole ;
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
				if(!this.down && this.next != null && this.next.yCoord == this.yCoord+1)
					train.posY = this.yCoord+0.01F;
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
				if(!this.down && this.next != null && this.next.yCoord == this.yCoord+1)
					train.posY = this.yCoord+0.01F;
				return true;
			}
		}*/
		return false;
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
				if(train.posY+train.speedMultiplier < this.yCoord+1)
				{
					int[] tmp = {0,1,1};
					return tmp;
				}
				else
				{
					train.posY = this.yCoord+0.99999F;
					int[] tmp = {0,0,1};
					return tmp;
				}
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
				if(train.posY+train.speedMultiplier < this.yCoord+1)
				{
					int[] tmp = {1,1,0};
					return tmp;
				}
				else
				{
					train.posY = this.yCoord+0.99999F;
					int[] tmp = {1,0,0};
					return tmp;
				}
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
				if(train.posY+train.speedMultiplier < this.yCoord+1)
				{
					int[] tmp = {0,1,-1};
					return tmp;
				}
				else
				{
					train.posY = this.yCoord+0.99999F;
					int[] tmp = {0,0,-1};
					return tmp;
				}
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
				if(train.posY+train.speedMultiplier < this.yCoord+1)
				{
					int[] tmp = {-1,1,0};
					return tmp;
				}
				else
				{
					train.posY = this.yCoord+0.99999F;
					int[] tmp = {-1,0,0};
					return tmp;
				}
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
	
	
	public float getPlayerXOff()
	{
		if(!down)
		{
			if(this.alignment == 1)
				return 0.85F;
			else if(this.alignment == 3)
				return -0.85F;
		}else
		{
			if(this.alignment == 1)
				return 1.3F;
			else if(this.alignment == 3)
				return -1.3F;
		}
		return 0;
	}
	
	public float getPlayerYOff()
	{
		if(!this.down)
		{
    		return -2.3F;
		}else
		{
			return -2.3F;
		}
	}	
	
	public float getPlayerZOff()
	{
		if(!down)
		{
			if(this.alignment == 0)
				return 0.85F;
			else if(this.alignment == 2)
				return -0.85F;
		}else
		{
			if(this.alignment == 0)
				return 1.3F;
			else if(this.alignment == 2)
				return -1.3F;
		}
		return 0;
	}
	
	@Override
	public float getSpeedMultiplier(EntityTrain train) {
		if(!this.down)
			return 0.97F;
		else
			return 1.03F;
	}
	
}
