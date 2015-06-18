package com.roller.roller.tileEntity;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.util.ChatComponentText;

import com.roller.roller.models.tmp;


public class EntityTrackBaseWater extends Base{

	public int speedAim = 50, maxSpeedAim = 190, minSpeedAim = 0;
	float speedM = 1.1F, speedM2, maxSpeedM = 1.25F, minSpeedM = 1.01F;
	int k;
	public tmp base2;
	

    public EntityTrackBaseWater()
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
	    			if(this.worldObj.getTileEntity(this.xCoord, this.yCoord, this.zCoord+1) != null && this.worldObj.getTileEntity(this.xCoord, this.yCoord, this.zCoord+1) instanceof EntityTrackBaseWater)
	    			{
	    				tmp = (EntityTrackBaseWater) this.worldObj.getTileEntity(this.xCoord, this.yCoord, this.zCoord+1);
	    				if((tmp.alignment % 2) == 0)
	    				{
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
	    		if(this.alignment == 1)
	    		{
	    			if(this.worldObj.getTileEntity(this.xCoord+1, this.yCoord, this.zCoord) != null && this.worldObj.getTileEntity(this.xCoord+1, this.yCoord, this.zCoord) instanceof EntityTrackBaseWater)
	    			{
	    				tmp = (EntityTrackBaseWater) this.worldObj.getTileEntity(this.xCoord+1, this.yCoord, this.zCoord);
	    				if((tmp.alignment % 2) != 0)
	    				{
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
	    		if(this.alignment == 2)
	    		{
	    			if(this.worldObj.getTileEntity(this.xCoord, this.yCoord, this.zCoord-1) != null && this.worldObj.getTileEntity(this.xCoord, this.yCoord, this.zCoord-1) instanceof EntityTrackBaseWater)
	    			{
	    				tmp = (EntityTrackBaseWater) this.worldObj.getTileEntity(this.xCoord, this.yCoord, this.zCoord-1);
	    				if((tmp.alignment % 2) == 0)
	    				{
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
	    		if(this.alignment == 3)
	    		{
	    			if(this.worldObj.getTileEntity(this.xCoord-1, this.yCoord, this.zCoord) != null && this.worldObj.getTileEntity(this.xCoord-1, this.yCoord, this.zCoord) instanceof EntityTrackBaseWater)
	    			{
	    				tmp = (EntityTrackBaseWater) this.worldObj.getTileEntity(this.xCoord-1, this.yCoord, this.zCoord);
	    				if((tmp.alignment % 2) != 0)
		    			{
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
			train.posY = this.yCoord;
			return true;			
		}else if(this.alignment == 1 || this.alignment == 3)			
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
		return 0.98F;
	}
	
}
