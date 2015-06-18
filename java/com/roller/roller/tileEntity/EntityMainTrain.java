package com.roller.roller.tileEntity;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

import com.roller.roller.Main;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.relauncher.Side;

public class EntityMainTrain extends EntityTrain{

	public int subCount;
	
	public EntityMainTrain(World w, double x, double y,
			double z, int colo) {
		super(w, x, y, z, colo);
	}
	
	public EntityMainTrain(World w)
	{
		super(w);
	}
	
	public void onUpdate()
	{
		super.onUpdate();
	}
	
	public int getLastIndex()
	{
		return this.subCount;
	}
	
	public void updateRiderPosition() {
		
		super.updateRiderPosition();
		if(this.riddenByEntity != null && this.riddenByEntity instanceof EntityPlayer)
			((EntityPlayer)this.riddenByEntity).addPotionEffect(new PotionEffect(14, 3, 1,false));
		
	}
	
	public boolean interactFirst(EntityPlayer p) {

		if(p.inventory.getCurrentItem() == null || (!p.inventory.getCurrentItem().isItemEqual(new ItemStack(Main.subTrain)) && !p.inventory.getCurrentItem().isItemEqual(new ItemStack(Main.paintBrush))))
		{
			if (this.riddenByEntity != null
					&& this.riddenByEntity instanceof EntityPlayer
					&& this.riddenByEntity != p) {
				return true;
			} else {
				if (!this.worldObj.isRemote) {
					p.mountEntity(this);
				}
	
				return true;
			}
		}else if(p.inventory.getCurrentItem() != null && p.inventory.getCurrentItem().isItemEqual(new ItemStack(Main.paintBrush)))
		{
	    	p.openGui(Main.instance, 55, this.worldObj, this.getEntityId(), 0, 0);
	    	return true;
		}		
		else
		{
			if(this.speed == 0 || !this.move)
			{
				EntitySubTrain train = null;
				if(!Main.trains.contains(this))
					Main.trains.add(this);
				int h = this.subCount;
				int k = Main.trains.indexOf(this);
				if(this.turn == 0)
					train = new EntitySubTrain(this.worldObj, this.posX-1.8F-1.8F*h, this.posY, this.posZ, k, h, this);
				if(this.turn == 90)
					train = new EntitySubTrain(this.worldObj, this.posX, this.posY, this.posZ-1.8F-1.8F*h, k, h, this);
				if(this.turn == 180)
					train = new EntitySubTrain(this.worldObj, this.posX+1.8F+1.8F*h, this.posY, this.posZ, k, h, this);
				if(this.turn == 270)
					train = new EntitySubTrain(this.worldObj, this.posX, this.posY, this.posZ+1.8F+1.8F*h, k, h, this);
				if(p.inventory.getCurrentItem().stackTagCompound != null)
				{
					train.red = p.inventory.getCurrentItem().stackTagCompound.getInteger("red");
					train.green = p.inventory.getCurrentItem().stackTagCompound.getInteger("gre");
					train.blue = p.inventory.getCurrentItem().stackTagCompound.getInteger("blu");
				}
				if(this.subCount < 3 && train != null)
				{
					if(!p.capabilities.isCreativeMode)
						p.inventory.setInventorySlotContents(p.inventory.currentItem, null);
					this.subCount++;
					if(!this.worldObj.isRemote)
						this.worldObj.spawnEntityInWorld(train);
				}
				return true;
			}
			return false;
		}

	}

	
}
