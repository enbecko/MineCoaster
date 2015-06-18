package com.roller.roller.tileEntity;

import scala.actors.threadpool.Arrays;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ChatComponentText;

public abstract class Base extends TileEntity{
	
	public boolean first, power;
	public boolean brake;
	public boolean powerAndBreak;
	public boolean start;
	public boolean down, locked, failed;
	public float xForDown, yForDown, zForDown, xForUp, yForUp, zForUp, turnForTrans;
	public Base firstBlock;
	public Base next;
	public Base prev;
	public int[] nextC, prevC;
	public int alignment, color;

	
	public void makeFirst(Base b)
	{
		this.firstBlock = b;
		this.color = firstBlock.color;
		if(this.locked != this.firstBlock.locked)
		{
			this.locked = firstBlock.locked;
			if(this.worldObj.isRemote)
			{
				if(this.locked)
					Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText("Locked track in "+this.xCoord+" "+this.yCoord+" "+this.zCoord)); 
				else
					Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText("Unlocked track in "+this.xCoord+" "+this.yCoord+" "+this.zCoord)); 			
			}
		}
		if(this.first)
			this.first = false;
		else
		{
			this.failed = false;
			this.first = true;
		}
		this.worldObj.markBlockForUpdate(this.xCoord, this.yCoord, this.zCoord);
			
	}
	
	public float getPlayerXOff()
	{
		return 0;
	}
	
	public float getPlayerYOff()
	{
		return 0;
	}	
	
	public float getPlayerZOff()
	{
		return 0;
	}
	
	public float getHalfwayX()
	{
		return this.xCoord;
	}
	
	public float getHalfwayY()
	{
		return this.yCoord;
	}
	
	public float getHalfwayZ()
	{
		return this.zCoord;
	}
	
	public float getDisTillOut(EntityTrain train)
	{
		return 0;
	}
	
	public float getDisTillOutFromHalf()
	{
		return 0;
	}
	
	public float getDisTillHalf(EntityTrain train)
	{
		return 0;
	}
	
	public float getDisTillHalfPrev(EntityTrain train)
	{
		return 0;
	}
	
	public boolean HasHalfway()
	{
		return false;
	}
	
    public void makeNext(Base tmp)
    {
    	if(tmp == this.prev)
    	{

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
    
    public void itemAction(EntityPlayer p){
		for(int k = 0; k < 10-1; k++)
		{
    		p.addChatMessage(new ChatComponentText(""));  
		}
		p.addChatMessage(new ChatComponentText("mode: "+1+"/"+1)); 
    	
    }

    public  void itemAction2(boolean up, EntityPlayer p){}

    public  void itemAction3(boolean up, EntityPlayer p){}

    public abstract boolean acceptsTrain(EntityTrain train);

    public abstract float getSpeedMultiplier(EntityTrain train);

    public abstract int[] getVek(int[] vek, EntityTrain train);
  
    public int getAsBMin(float speed)
    {
    	return (int)(((-0.00002F*Math.pow(speed-200,2)+0.8F))*1200);
    }
    
    public float getAsBSec(float speed)
    {
    	return (float)(((-0.00002F*Math.pow(speed-200,2)+0.8F))*20);
    }
    
    public float getAsBTick(float speed)
    {
    	return (float)(((-0.00002F*Math.pow(speed-200,2)+0.8F)));
    }
    
    public void updateEntity()
    {
    	if(this.next == this.firstBlock && this.prev != this.firstBlock)
    		this.first = false;
    	if(!this.first && this.next == null && this.nextC != null)
    		this.next = (Base) this.worldObj.getTileEntity(this.nextC[0], this.nextC[1], this.nextC[2]);
      	if(!this.first && this.prev == null && this.prevC != null)
    		this.prev = (Base) this.worldObj.getTileEntity(this.prevC[0], this.prevC[1], this.prevC[2]);
      
    }
    
    public void readFromNBT(NBTTagCompound k)
    {
        super.readFromNBT(k);
        this.alignment = k.getInteger("Al");
        this.brake = k.getBoolean("br");
        this.power = k.getBoolean("po");
        this.powerAndBreak = k.getBoolean("pobr");
        this.start = k.getBoolean("st");
        this.down = k.getBoolean("do");
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
   }

    public void writeToNBT(NBTTagCompound k)
    {
        super.writeToNBT(k);
        k.setInteger("Al", this.alignment);
        k.setBoolean("br", this.brake);
        k.setBoolean("po", this.power);
        k.setBoolean("pobr", this.powerAndBreak);
        k.setBoolean("st", this.start);
        k.setBoolean("do", this.down);
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

}
