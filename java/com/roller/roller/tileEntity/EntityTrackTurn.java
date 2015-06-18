package com.roller.roller.tileEntity;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.util.ChatComponentText;

import com.roller.roller.models.tmp;


public class EntityTrackTurn extends Base{

	public int speedAim = 35, maxSpeedAim = 70, minSpeedAim = 0, ticksForQuarter = 50;
	float speedM = 1.1F, maxSpeedM = 1.25F, minSpeedM = 1.01F,tempZ1, tempX1, turn;
	public float turn2;
	int k, aim;
	boolean finished;
	EntityTrain tra;
	public tmp base2;
	

    public EntityTrackTurn()
    {

    }
    
    public void updateEntity()
    {
    	super.updateEntity();
    	bitch:
    	if(tra != null)
    	{
			if(tra.isDead)
			{
				this.tra = null;
				break bitch;
			}
    		if(this.turn > this.getDir(this.aim)+1 || this.turn < this.getDir(this.aim)-1)
    		{
    			if((this.alignment == 0 && this.aim == 3) || (this.alignment == 1 && this.aim == 2)|| (this.alignment == 2 && this.aim == 1)|| (this.alignment == 3 && this.aim == 0))
    			{
    				System.out.println("<0");
	    			if(this.turn < 360)
	    			{
		    			this.turn += 90F/50F;
	    			}
		    		else 
		    		{
		    			this.turn = 0;
		    		}
	    			if(this.turn2 < 360)
	    			{
		    			this.turn2 += 90F/50F;
	    			}
		    		else 
		    		{
		    			this.turn2 = 0;
		    		}
	        		if(tra != null && (this.alignment != 1 && this.alignment != 3))
	        			tra.turn = (int) this.turn2-270;
	        		else if(tra != null)
	        			tra.turn = (int) this.turn2-90;

    			}else
    			{
    				System.out.println(">0");
	    			if(this.turn > 0)
	    			{
		    			this.turn -= 90F/50F;
	    			}
		    		else 
		    		{
		    			this.turn = 360;
		    		}
	    			if(this.turn2 > 0)
	    			{
		    			this.turn2 -= 90F/50F;
	    			}
		    		else 
		    		{
		    			this.turn2 = 360;
		    		}
	        		if(tra != null && (this.alignment != 1 && this.alignment != 3))
	        			tra.turn = (int) this.turn2-270;
	        		else if(tra != null)
	        			tra.turn = (int) this.turn2-90;
    			}

    		}else
    		{
    	    	System.out.println(tra);

    			this.turn = this.getDir(this.aim);
    			tra.move = true;
    			if(tra.speed*1.1F < this.speedAim)
    				tra.speed *= 1.1F;
    			this.finished = true;
        		if(tra != null && (this.alignment != 1 && this.alignment != 3))
        			tra.turn = (int) this.turn2-270;
        		else if(tra != null)
        			tra.turn = (int) this.turn2-90;

    			if(this.aim == 0)
    			{
    				tra.vek[2] = +1;
    				tra.vek[0] = 0;
    			}else if(this.aim == 1)
    			{
    				tra.vek[2] = 0;
    				tra.vek[0] = +1;
    			}else if(this.aim == 2)
    			{
    				tra.vek[2] = -1;
    				tra.vek[0] = 0;
    			}else if(this.aim == 3)
    			{
    				tra.vek[2] = 0;
    				tra.vek[0] = -1;
    			}
    			if(tra.isDead)
    				this.tra = null;
    			else if(this.aim == 0 && tra.posZ > this.zCoord+1)
    				this.tra = null;
    			else if(this.aim == 1 && tra.posX > this.xCoord+1)
    				this.tra = null;
    			else if(this.aim == 2 && tra.posZ < this.zCoord)
    				this.tra = null;
    			else if(this.aim == 3 && tra.posX < this.xCoord)
    				this.tra = null;

    		}
    	}else
    	{
    		if(this.turn2 > this.getDirForRend(this.alignment)+3 || this.turn2 < this.getDirForRend(this.alignment)-3)
    		{
    			if((this.alignment == 0 && this.aim == 3) || (this.alignment == 1 && this.aim == 2)|| (this.alignment == 2 && this.aim == 1)|| (this.alignment == 3 && this.aim == 0))
    			{
	    			if(this.turn2 > 0)
	    				this.turn2 -= 3F;
		    		else 
		    			this.turn2 = 360;
    			}else
    			{
        			if(this.turn2 < 360)
        				this.turn2 += 3F;
    	    		else 
    	    			this.turn2 = 0;
    			}
    		}
    		else
    			this.turn2 = this.getDirForRend(this.alignment);
    		this.finished = false;
    	}
    	{
    		Base tmp;
    		if(this.first)
    		{
    			this.next = null;
	    		if(aim == 0)
	    		{
	    			if(this.worldObj.getTileEntity(this.xCoord, this.yCoord, this.zCoord+1) != null && this.worldObj.getTileEntity(this.xCoord, this.yCoord, this.zCoord+1) instanceof EntityTrackBase)
	    			{
	    				tmp = (EntityTrackBase) this.worldObj.getTileEntity(this.xCoord, this.yCoord, this.zCoord+1);
	    				if(tmp.alignment == 0)
	    				{
	    					this.makeNext(tmp);
	    				}else if(tmp.alignment == 2)
	    				{
	    					tmp.alignment = 0;
	    					this.makeNext(tmp);
	    				}
	    			}
	    		}
	    		if(aim == 1)
	    		{
	    			if(this.worldObj.getTileEntity(this.xCoord+1, this.yCoord, this.zCoord) != null && this.worldObj.getTileEntity(this.xCoord+1, this.yCoord, this.zCoord) instanceof EntityTrackBase)
	    			{
	    				tmp = (EntityTrackBase) this.worldObj.getTileEntity(this.xCoord+1, this.yCoord, this.zCoord);
	    				if(tmp.alignment == 1)
	    				{
	    					this.makeNext(tmp);
	    				}else if(tmp.alignment == 3)
	    				{
	    					tmp.alignment = 1;
	    					this.makeNext(tmp);
	    				}
	    			}
	    		}
	    		if(aim == 2)
	    		{
	    			if(this.worldObj.getTileEntity(this.xCoord, this.yCoord, this.zCoord-1) != null && this.worldObj.getTileEntity(this.xCoord, this.yCoord, this.zCoord-1) instanceof EntityTrackBase)
	    			{
	    				tmp = (EntityTrackBase) this.worldObj.getTileEntity(this.xCoord, this.yCoord, this.zCoord-1);
	    				if(tmp.alignment == 2)
	    				{
	    					this.makeNext(tmp);
	    				}else if(tmp.alignment == 0)
	    				{
	    					tmp.alignment = 2;
	    					this.makeNext(tmp);
	    				}
	    			}
	    		}
	    		if(aim == 3)
	    		{
	    			if(this.worldObj.getTileEntity(this.xCoord-1, this.yCoord, this.zCoord) != null && this.worldObj.getTileEntity(this.xCoord-1, this.yCoord, this.zCoord) instanceof EntityTrackBase)
	    			{
	    				tmp = (EntityTrackBase) this.worldObj.getTileEntity(this.xCoord-1, this.yCoord, this.zCoord);
	    				if(tmp.alignment == 3)
	    				{
	    					this.makeNext(tmp);
	    				}else if(tmp.alignment == 1)
	    				{
	    					tmp.alignment = 3;
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
    
    public int getDir(int a)
    {
    	if(a == 0)
    		return 90;
    	else if(a == 1)
    		return 0;
    	else if(a == 2)
    		return 270;
    	else
    		return 180;
    }
    
    public int getDirForRend(int a)
    {
    	if(a == 0)
    		return 0;
    	else if(a == 1)
    		return 270;
    	else if(a == 2)
    		return 180;
    	else
    		return 90;
    }
    
    public void makeNext(Base tmp)
    {
    	if(tmp == this.prev)
    	{
			if((this.alignment <= 1))
				this.alignment+=2;
			else
				this.alignment-=2;
			this.turn2 = this.getDirForRend(this.alignment);
    	}
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
	public void itemAction(EntityPlayer p) {
		if(this.aim < 3)
			this.aim++;
		else
			this.aim = 0;
		for(int k = 0; k < 10-1; k++)
		{
    		p.addChatMessage(new ChatComponentText(""));  
		}
		for(int k = 0; k < 1; k++)
			p.addChatMessage(new ChatComponentText("Aim: "+this.getAim(this.aim))); 
	}
	
	public String getAim(int a)
	{
		if(a == 0)
			return "z+";
		else if(a == 1)
			return "x+";
		else if(a == 2)
			return "z-";
		else
			return "x-";
			
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
	
	 public void readFromNBT(NBTTagCompound k)
	    {
	        super.readFromNBT(k);
	        this.speedAim = k.getInteger("sA");
	        this.turn2 = k.getFloat("t2");
	        this.aim = k.getInteger("aim");
	    }

	    public void writeToNBT(NBTTagCompound k)
	    {
	        super.writeToNBT(k);
	        k.setInteger("sA", this.speedAim);
	        k.setFloat("t2", this.turn2);
	        k.setInteger("aim", this.aim);
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
	        this.turn2 = k.getFloat("t2");
	        this.aim = k.getInteger("aim");
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
	        k.setFloat("t2", this.turn2);
	        k.setInteger("aim", this.aim);
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
		if(this.finished)
			return true;
		if(this.alignment == 0 || this.alignment == 2)			
		{
			train.posX = this.xCoord+0.5F;
			train.posY = this.yCoord;
			float z1 = (float) Math.abs(this.zCoord+0.5F-train.posZ);
			if(z1 > 0 && train.speed > 5)
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
					train.move = false;
					this.tra = train;
					this.turn = train.turn;
					return false;
				}
				this.tempZ1  = z1;
				return false;
			}
			train.move = false;
			if(tra == null)
			{
				this.tra = train;
				this.turn = train.turn;
			}
			return false;			
		}else if(this.alignment == 1 || this.alignment == 3)			
		{
			train.posZ = this.zCoord+0.5F;
			train.posY = this.yCoord;
			float x1 = (float) Math.abs(this.xCoord+0.5F-train.posX);
			if(x1 > 0 && train.speed > 5)
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
					this.tra = train;
					this.turn = train.turn;
					train.move = false;
					return false;
				}
				this.tempX1  = x1;
				return false;
			}
			if(tra == null)
			{
				this.tra = train;
				this.turn = train.turn;
			}
			return false;	
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
		/**if(!this.power && !this.brake)
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
		}*/
		return 1;
	}
	
}
